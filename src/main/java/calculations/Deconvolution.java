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
import java.io.File;
import java.io.IOException;
import java.util.Map;
import tools.Settings;

/**
 *
 * @author Zbigniew Baster
 */
public class Deconvolution {
    public static void run(Settings settings, Map.Entry<String,String> file, int pos, int fr, int ch) throws IOException, InterruptedException{
        pathDeconvolutionLab = new File("").getAbsolutePath()+"\\plugins\\DeconvolutionLab2\\DeconvolutionLab_2.jar";
        parameters=parameters(settings, file, pos, fr, ch);

        fileImg=file.getValue()+"_pos"+pos+"_fr"+fr+"_ch"+ch;
        IJ.log("Deconvolving: "+fileImg+".tif");
        
        Runtime.getRuntime().exec("java -jar \""+pathDeconvolutionLab+"\" Run"+parameters).waitFor();
                
        if(settings._PSF_calc==0)fileImg=fileImg.substring(fileImg.indexOf("_",fileImg.indexOf("_")+1)+1);
        if(new File(settings.intermediatePath+"\\Log\\stats_"+fileImg+".csv").exists())new File(settings.intermediatePath+"\\Log\\stats_"+fileImg+".csv").delete();
        new File(settings.intermediatePath+"\\Log\\stats.csv").renameTo(new File(settings.intermediatePath+"\\Log\\stats_"+fileImg+".csv"));
        
        if(settings.delete){
            new File(settings.intermediatePath+"\\Split\\"+file.getValue()+"_pos"+pos+"_fr"+fr+"_ch"+ch+".tif").delete();
        }
    }  
    
    public static String parameters(Settings settings, Map.Entry<String,String> file, int pos, int fr, int ch){
        
        fileImg=file.getValue()+"_pos"+pos+"_fr"+fr+"_ch"+ch;
        // image
        image = " -image file "+settings.intermediatePath+"\\Split\\"+fileImg+".tif";
        
        // psf
        psf = " -psf file "+settings.intermediatePath+"\\PSF\\";
        switch(settings._PSF_calc){
            case 0:
                psf+="PSF_"+file.getValue().substring(0,file.getValue().indexOf("_",file.getValue().indexOf("_")+1))+"_ch"+ch+".tif";
                break;
            case 1:
                psf+="PSF_"+file.getValue()+"_ch"+ch+".tif";
                break;
            case 2:
                psf+="PSF_ch"+ch+".tif";
                break;
        }
        
        // algorithm
        
        algorithm=" -algorithm "+settings.deconvAlgorithm;
        switch(settings.deconvAlgorithm){
            case "RIF":
                algorithm+=" "+settings.reg;
                break;
            case "TRIF":
                algorithm+=" "+settings.reg;
                break;
            case "NIF":
                break;
            case "FISTA":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                algorithm+=" "+settings.reg;
                algorithm+=" "+settings.wevelets;
                algorithm+=" "+settings.scale;
                break;
            case "ISTA":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                algorithm+=" "+settings.reg;
                algorithm+=" "+settings.wevelets;
                algorithm+=" "+settings.scale;
                break;
            case "LW":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                break;
            case "NNLS":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                break;
            case "BVLS":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                break;
            case "RL":
                algorithm+=" "+settings.nIterations;
                break;
            case "RLTV":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                algorithm+=" "+settings.reg;
                break;
            case "TM":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                algorithm+=" "+settings.reg;
                break;
            case "ICTM":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                algorithm+=" "+settings.reg;
                break;
            case "VC":
                algorithm+=" "+settings.nIterations;
                algorithm+=" "+settings.step;
                break;
            case "DIV":
                break;
        }
        
        out = " -out stack ..\\Deconvolved\\"+fileImg+" noshow";
        monitor = " -monitor table";
        display = " -display no";
        verbose = " -verbose log";
        stats = " -stats save noshow";
        constraint = " -constraint "+settings.constraint;
        
        //residu
        if(settings.residuSelected) residu = " -residu "+settings.residu;
        else residu = "";
        
        pad = " -pad "+pad(settings.paddingConstrainXY)+" "+pad(settings.paddingConstrainZ)+" "+settings.paddingExtensionXY+" "+settings.paddingExtensionZ;
        apo = " -apo "+settings.apodizationXY.toUpperCase()+" "+settings.apodizationZ.toUpperCase();
        
        //norm
        if(settings._PSFnorm.equals("no"))norm = " -norm 1.0";
        else norm = " -norm "+settings._PSFnorm;
        path = " -path "+settings.intermediatePath+"\\Log";
        
        //fft
        if(settings.fft.equals("Fastest")) fft = ""; 
        else fft = " -fft "+settings.fft;
        
        epsilon = " -epsilon "+settings.epsilon;
        
        parameters = 
            image
            +psf
            +algorithm
            +out
            +monitor
            +display
            +verbose
            +stats
            +constraint
            +residu
            +pad
            +apo
            +norm
            +path
            +fft
            +epsilon;
        
        return parameters;
    }
    
    private static String pad(String s){
        switch (s){
            case "None":
                return "NO";
            case "Even":
                return "X2";
            case "Power of 2":
                return "E2";
            case "Multiple {2,3}":
                return "X2X3";
            case "Multiple {2,3,5}":
                return "X2X3X5";
        }
        return null;
    }
    
    private static String fileImg;
    private static String pathDeconvolutionLab;
    
    private static String image;
    private static String psf;
    private static String algorithm;
    private static String out;
    private static String display;
    private static String monitor;
    private static String verbose;
    private static String stats;
    private static String constraint;
    private static String residu;
    private static String pad;
    private static String apo;
    private static String norm;
    private static String path;
    private static String fft;
    private static String epsilon;
    
    private static String parameters;
}
	/*	
		display_d = " -display no";
		out_file_d = " -out stack deconv"+i+" noshow";
		out_path_d = " -path "+input+"Final\\";
		*/