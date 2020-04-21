/*
 * Copyright (C) 2020 Mechanobiology Lab UJ
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package calculations;

import ij.IJ;
import ij.ImagePlus;
import ij.io.FileSaver;
import ij.plugin.Duplicator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import loci.formats.FormatException;
import loci.plugins.BF;
import loci.plugins.in.ImporterOptions;
import tools.Scale;
import tools.Settings;

/**
 *
 * @author  Zbigniew Baster
 */
public class Split {
    public static void run(Settings settings, Map.Entry<String,String> file, TreeMap<String,int[]> seriesFramesMap, TreeMap<String,Pair<double[],int[]>> pxPSF, ArrayList<String> blackList) throws IOException, FormatException{
        path = settings.intermediatePath+"\\Split";
        if(!new File(path).exists()){
            new File(path).mkdirs();
        }
        IJ.log("Splitting: "+file.getKey().substring(file.getKey().lastIndexOf("\\")+1));
        
        options = new ImporterOptions();
        options.setId(file.getKey());
        options.setOpenAllSeries(true);
        imps = BF.openImagePlus(options);
	//imp.show();
        imp = imps[0];
        channels = imp.getDimensions()[2];
        if(channels!=settings.channels){
            blackList.add(file.getKey());
            IJ.log(file.getValue()+" does not match channels number with settings!");
            for(ImagePlus images :imps) images.close();
            IJ.freeMemory();
            System.gc();
            return;
        }

        dimensions = new int[]{imp.getDimensions()[0],imp.getDimensions()[1],imp.getDimensions()[3]}; // 0-width, 1-height, 3-slices
        frames = imp.getDimensions()[4]; 



        //prepare databes for PSF calc  
        if(settings._PSF_calc!=2){
            try {
                pxXYZ = new double[]{Scale.nm(imp.getCalibration().pixelWidth, imp.getCalibration().getUnit()),Scale.nm(imp.getCalibration().pixelDepth, imp.getCalibration().getUnit())}; //0-XY, 1-Z
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Split.class.getName()).log(Level.SEVERE, null, ex);
            }

            switch(settings._PSF_calc){
                case 0:
                    if(pxPSF.containsKey(String.format("%3.2f_%3.2f",pxXYZ[0],pxXYZ[1]))){
                        for(int i = 0; i < dimensions.length; i++){
                            if(pxPSF.get(String.format("%3.2f_%3.2f",pxXYZ[0],pxXYZ[1])).getValue()[i]<dimensions[i]){
                                pxPSF.get(String.format("%3.2f_%3.2f",pxXYZ[0],pxXYZ[1])).getValue()[i] = dimensions[i];
                            }
                        }
                    }else{
                        pxPSF.put(String.format("%3.2f_%3.2f",pxXYZ[0],pxXYZ[1]),new Pair<>(pxXYZ, dimensions));
                    }
                    break;

                case 1:
                    pxPSF.put(file.getValue(),new Pair<>(pxXYZ, dimensions));
                    break;
            }
        }

        if(settings._PSF_calc == 0){
            file.setValue(String.format("%3.2f_%3.2f_",pxXYZ[0],pxXYZ[1])+file.getValue()); //renameing files names in "files"
        } 
        seriesFramesMap.put(file.getValue(),new int[]{imps.length,frames});
          
        for(int sr=0; sr < imps.length; sr++){            
            for(int fr=0;fr<frames;fr++){
                for(int ch=0;ch<channels;ch++){
                    outputPath=path+"\\"+file.getValue()+"_sr"+sr+"_fr"+fr+"_ch"+ch+".tif";   
                    if(!new File(outputPath).exists()){
                        new FileSaver(new Duplicator().run(imps[sr], ch+1, ch+1, 1, dimensions[2], fr+1, fr+1)).saveAsTiff(outputPath);
                    }
                }
            }
            imps[sr].close();
        }
        
        IJ.freeMemory();
        System.gc();
    }    
    private static String path;
    private static String outputPath;
    private static int[] dimensions;   
    private static int channels; 
    private static int frames; 
    private static ImagePlus[] imps;
    private static ImagePlus imp;
    private static double[] pxXYZ;
    private static ImporterOptions options;
}
