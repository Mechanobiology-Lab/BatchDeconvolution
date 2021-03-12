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
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import loci.formats.FormatException;
import loci.plugins.BF;
import tools.Settings;

/**
 *
 * @author Zbigniew Baster
 */
public class PSF {
    public static void calculate(Settings settings, Map.Entry<String,String> file, int ch){
        switch(settings._PSF_calc){
            case 0:
                pathPSF=settings.intermediatePath+"/PSF/PSF_"+file.getValue().substring(0,file.getValue().indexOf("_",file.getValue().indexOf("_")+1))+"_ch"+ch+".tif";
                break;
            case 1:
                pathPSF=settings.intermediatePath+"/PSF/PSF_"+file.getValue()+"_ch"+ch+".tif";
                break;
        }
        
        if(!new File(pathPSF).exists()){
            try {
                IJ.log("Calculating PSF: "+pathPSF.substring(pathPSF.lastIndexOf("/")+1));
                pathGenerator = new File("").getAbsolutePath()+"/plugins/PSFGenerator/PSFGenerator.jar";
                
                pathConfig=settings.intermediatePath+"/PSF_config/"+pathPSF.substring(pathPSF.lastIndexOf("/")+1,pathPSF.lastIndexOf("."))+".txt";
                Runtime.getRuntime().exec("cmd /c cd /d \""+settings.intermediatePath+"/PSF"+"\" & java -Xmx32g -cp \""+pathGenerator+"\" PSFGenerator \""+pathConfig+"\" & ren \"PSF "+settings.modelPSF+".tif\" \""+pathPSF.substring(pathPSF.lastIndexOf("/")+1)+"\"").waitFor();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(PSF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        IJ.freeMemory();
        System.gc();
    }
    
    public static void bf(String inPath, String outPath){
        if(!new File(outPath).exists()){
            imp = IJ.openImage(inPath);
            IJ.run(imp, "32-bit", "");
            IJ.log(imp.getStringProperty("Label"));
            for(int sl=0; sl < imp.getDimensions()[3]; sl++){
                imp.setZ(sl+1);
                IJ.run(imp,"Set Label...", "label=[]");
            }

            new FileSaver(imp).saveAsTiff(outPath);
            
            imp.close();
        }
    }
    
    public static void load(Settings settings) throws FormatException, IOException{
        imp = BF.openImagePlus(settings._PSFPath)[0];
        channels=imp.getDimensions()[2];
        slices=imp.getDimensions()[3];
        noBF=0;
        
        for(int ch=0; ch< settings.channels; ch++){
            if(settings._BF.get(ch)==true) {
                noBF++;
                continue;
            }
            
            if(settings.channels==channels){
                if(!new File(settings.intermediatePath+"/PSF/PSF_ch"+ch+".tif").exists()){
                    new FileSaver(new Duplicator().run(imp, ch+1, ch+1, 1, slices, 1, 1)).saveAsTiff(settings.intermediatePath+"/PSF/PSF_ch"+ch+".tif");
                }
            }else{
                if(!new File(settings.intermediatePath+"/PSF/PSF_ch"+ch+".tif").exists()){
                    new FileSaver(new Duplicator().run(imp, ch+1-noBF, ch+1-noBF, 1, slices, 1, 1)).saveAsTiff(settings.intermediatePath+"/PSF/PSF_ch"+ch+".tif");
                }
            }
        }
        imp.close();
    }
    
    
    public static void config(Settings settings, String file, Pair<double[],int[]> pxPSF) throws IOException{
        pathConfig = settings.intermediatePath+"/PSF_config";
        if(!new File(pathConfig).exists()){
            new File(pathConfig).mkdirs();
        }
        
        for(int ch = 0; ch < settings.channels; ch++){
            if(settings._BF.get(ch))continue;
            if(!new File(pathConfig+"/PSF_"+file+"_ch"+ch+".txt").exists()){
                fw = new FileWriter(pathConfig+"/PSF_"+file+"_ch"+ch+".txt");
                
		fw.write("#PSFGenerator\n");
		fw.write("#"+new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").format(new Date())+"\n");
                
                fw.write("PSF-shortname="+settings.modelPSF+"\n");
                
                fw.write("ResLateral="+pxPSF.getKey()[0]+"\n");
                fw.write("ResAxial="+pxPSF.getKey()[1]+"\n");
                
                fw.write("NX="+((pxPSF.getValue()[0]<4) ? "4" : pxPSF.getValue()[0])+"\n");
                fw.write("NY="+((pxPSF.getValue()[1]<4) ? "4" : pxPSF.getValue()[1])+"\n");
                fw.write("NZ="+((pxPSF.getValue()[2]<3) ? "3" : pxPSF.getValue()[2])+"\n");
                
                fw.write("Type="+settings.bit+"\n");
                fw.write("NA="+settings._NA+"\n");
                fw.write("LUT=Fire\n");
                fw.write("Lambda="+settings.lambda.get(ch)+"\n");
                fw.write("Scale=Linear\n");
                
                if(!settings._RIoil_different){
                    fw.write("psf-BW-NI="+settings._RIoil+"\n");
                    fw.write("psf-RW-NI="+settings._RIoil+"\n");
                    fw.write("psf-GL-NI="+settings._RIoil+"\n");
                    fw.write("psf-TV-NI="+settings._RIoil+"\n");
                    fw.write("psf-VRIGL-NI="+settings._RIoil+"\n");
                }else{
                    fw.write("psf-BW-NI="+settings.oil_RI.get(ch)+"\n");
                    fw.write("psf-RW-NI="+settings.oil_RI.get(ch)+"\n");
                    fw.write("psf-GL-NI="+settings.oil_RI.get(ch)+"\n");
                    fw.write("psf-TV-NI="+settings.oil_RI.get(ch)+"\n");
                    fw.write("psf-VRIGL-NI="+settings.oil_RI.get(ch)+"\n");
                }
                
                if(!settings._RIsample_different){
                    fw.write("psf-GL-NS="+settings._RIsample+"\n");
                    fw.write("psf-TV-NS="+settings._RIsample+"\n");
                    fw.write("psf-VRIGL-NS1="+settings._RIsample+"\n");
                }else{
                    fw.write("psf-GL-NS="+settings.sample_RI.get(ch)+"\n");
                    fw.write("psf-TV-NS="+settings.sample_RI.get(ch)+"\n");
                    fw.write("psf-VRIGL-NS1="+settings.sample_RI.get(ch)+"\n");
                }
                
                if(!settings._RIsampleZ_different){
                    fw.write("psf-VRIGL-NS2="+settings._RIsampleZ+"\n");
                }else{
                    fw.write("psf-VRIGL-NS2="+settings.sampleZ_RI.get(ch)+"\n");
                }
                
                fw.write("psf-BW-accuracy="+settings.accuracy+"\n");
                fw.write("psf-RW-accuracy="+settings.accuracy+"\n");
                fw.write("psf-GL-accuracy="+settings.accuracy+"\n");
                fw.write("psf-VRIGL-accuracy="+settings.accuracy+"\n");
                           
                fw.write("psf-GL-ZPos="+settings.zPos+"\n");
                fw.write("psf-TV-ZPos="+settings.zPos+"\n");
                fw.write("psf-VRIGL-ZPos="+settings.zPos+"\n");
                
                fw.write("psf-GL-TI="+settings._WD+"\n");
                fw.write("psf-TV-TI="+settings._WD+"\n");
                fw.write("psf-VRIGL-TI="+settings._WD+"\n");
                
                fw.write("psf-VRIGL-RIvary="+settings._RIvariation+"\n");
                
                fw.write("psf-VRIGL-TG=170.0\n");
                fw.write("psf-VRIGL-NG=1.5\n");

                fw.close();
            }
            
        }
        
    }
    private static String pathPSF;
    private static String fileName;
    private static String pathConfig;
    private static String pathGenerator;
    private static FileWriter fw;
    private static ImagePlus imp;
    private static int channels;
    private static int slices;
    private static int noBF;
}

