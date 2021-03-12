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
import ij.plugin.Concatenator;
import ij.plugin.HyperStackConverter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import loci.formats.FormatException;
import loci.plugins.BF;
import tools.Settings;

/**
 *
 * @author Zbigniew Baster
 */
public class Combine {
    public static void run(Settings settings, Map.Entry<String,String> file, int[] positionsFrames, int pos) throws FormatException, IOException{
        imps = new ArrayList<>();
        
        outputFile=file.getKey().substring(file.getKey().lastIndexOf("/")+1, file.getKey().lastIndexOf("."));
        if(positionsFrames[0] > 1) outputFile+="_pos"+pos;
        outputFile+="_d.tif";
        
        IJ.log("Combining: "+outputFile);
        
        for(int fr = 0; fr < positionsFrames[1]; fr++){
            for(int ch = 0; ch < settings.channels; ch++){
                imgPath = settings.intermediatePath+"/Deconvolved/"+file.getValue().replaceAll(" ", "")+"_pos"+pos+"_fr"+fr+"_ch"+ch+".tif";
                
                imps.add(IJ.openImage(imgPath));
            }
        }
        
        
        imp = Concatenator.run(imps.toArray(new ImagePlus[imps.size()]));
        
        for(int i=0; i<imps.size(); i++){
            imps.get(i).close();
        }
        imps.clear();
                
        /*if(positionsFrames[1] > 1) */
            imp = HyperStackConverter.toHyperStack(imp,settings.channels, imp.getDimensions()[3], positionsFrames[1], "xyzct", "Color");
        

        if( pos==0 ){
            imp.copyAttributes(BF.openImagePlus(file.getKey())[0]);
        }else{
            imp.copyAttributes(BF.openImagePlus(settings.outputPath+"/"+file.getKey().substring(file.getKey().lastIndexOf("/")+1, file.getKey().lastIndexOf("."))+"_pos0_d.tif")[0]);
        }
       
                     
        outputFile=settings.outputPath+"/"+outputFile;
        
        if(!new File(outputFile).exists()){
            new FileSaver(imp).saveAsTiff(outputFile);
        }
        imp.close();
        
        IJ.freeMemory();
        System.gc();
    }
    
    private static ArrayList<ImagePlus> imps;
    private static ImagePlus imp;
    private static String imgPath;
    private static String outputFile;
}
