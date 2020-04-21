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
    public static void run(Settings settings, Map.Entry<String,String> file, int[] seriesFrames, int sr) throws FormatException, IOException{
        imps = new ArrayList<>();
        
        IJ.log("Combineing: "+file.getKey().substring(file.getKey().lastIndexOf("\\")+1, file.getKey().lastIndexOf(".")));
        
        for(int fr = 0; fr < seriesFrames[1]; fr++){
            for(int ch = 0; ch < settings.channels; ch++){
                imgPath = settings.intermediatePath+"\\Deconvolved\\"+file.getValue()+"_sr"+sr+"_fr"+fr+"_ch"+ch+".tif";
                
                imps.add(IJ.openImage(imgPath));
            }
        }
        
        imp = Concatenator.run(imps.toArray(new ImagePlus[imps.size()]));
        
        if(seriesFrames[1] > 1) imp = HyperStackConverter.toHyperStack(imp,settings.channels, imp.getDimensions()[3], seriesFrames[1], "xyzct", "Color");
        
        for(int i=0; i<imps.size(); i++){
            imps.get(i).close();
        }
        imps.clear();
        imp.copyAttributes(BF.openImagePlus(file.getKey())[0]);
       
                     
        outputPath=settings.outputPath;
        outputPath+="\\"+file.getKey().substring(file.getKey().lastIndexOf("\\")+1, file.getKey().lastIndexOf("."));
        if(seriesFrames[0] > 1) outputPath+="_sr"+sr;
        outputPath+="_d.tif";
        
        if(!new File(outputPath).exists()){
            new FileSaver(imp).saveAsTiff(outputPath);
        }
        imp.close();
    }
    
    private static ArrayList<ImagePlus> imps;
    private static ImagePlus imp;
    private static String imgPath;
    private static String outputPath;
}
