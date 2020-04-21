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
import tools.Settings;
import tools.Menu;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import loci.formats.FormatException;
import tools.IO;

/**
 *
 * @author  Zbigniew Baster
 */
public class Run{
    public static void run(Settings settings, ArrayList<String> extensions,JButton jButton_Run){

        if(!thread.isAlive()){
            thread = new Thread(){
                @Override
                public void run(){ 
                    method();
                }
                void method(){    
                    
                    if(jButton_Run!=null)jButton_Run.setText("Stop");
                    files = new TreeMap<>();
                    seriesFrames = new TreeMap<>();

                    if(jButton_Run!=null)Menu.readSettings(settings);

                    //create files list
                    for(String f: new File(settings.inputPath).list()){                                     //all files ininput directory
                        if(new File(settings.inputPath+"\\"+f).isDirectory()){                              //folder - continue
                            continue;
                        }else if(!extensions.contains(f.substring(f.lastIndexOf(".")+1, f.length()))){      //non image - continue
                            continue;
                        }else{    
                            files.put(settings.inputPath+"\\"+f,f.substring(0, f.lastIndexOf(".")));       //add to files list
                        }          
                    }

                    if(!files.isEmpty()){
                        for(Map.Entry<String,String> f:files.entrySet()){                                     
                            if(new File(settings.outputPath+"\\"+f.getValue()+"_d.tif").exists()){          //remove already deconvolved files from the list
                                files.remove(f.getKey());
                            }
                        }

                        if(!files.isEmpty()){
                            //create folders
                            if(!new File(settings.outputPath).exists())new File(settings.outputPath).mkdirs();
                            if(!new File(settings.intermediatePath).exists())new File(settings.intermediatePath).mkdirs();
                            if(!new File(settings.logPath).exists())new File(settings.logPath).mkdirs();

                            //save settings
                            try {
                                IO.saveSettings(settings.logPath+"\\BDsettings.dat", settings);
                            } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            //split files into channels ##############################################
                            if(settings._PSF_calc!=2){
                                pxPSF = new TreeMap<String,Pair<double[],int[]>>();
                            }             

                            try {
                                blackList = new ArrayList<String>();

                                for(Map.Entry<String,String> f:files.entrySet()){                  //has to go for all files before goin to PSF calc
                                    Split.run(settings,f,seriesFrames,pxPSF,blackList);
                                }

                                for(Object bl: blackList.toArray()){                               //Remove from calculations files with wrong number of channels
                                    IJ.log(files.get(bl)+" removed form further calculations"); 
                                    files.remove(bl);
                                    blackList.clear();
                                }
                            } catch (IOException | FormatException ex) {
                                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            //####################################################################
                            //prepare PSF config files
                            try {
                                if(settings._PSF_calc != 2){
                                    for(Map.Entry<String,Pair<double[],int[]>> px:pxPSF.entrySet()){     
                                        PSF.config(settings, px.getKey(), px.getValue());
                                    }
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                            }        

                            //#######################################################
                            //Calculate PSFs and deconvolve
                            calculate(settings, files, seriesFrames);
                            IJ.log("Finished"); 
                            JOptionPane.showMessageDialog(null,"Finished!","Finished!",JOptionPane.INFORMATION_MESSAGE);                      
                            
                        }else{
                        IJ.log("All files from the are folder alredy deconvolved");
                        JOptionPane.showMessageDialog(null,"All files from the are folder alredy deconvolved!","Warning!",JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        IJ.log("No files in the selected folder!");
                        JOptionPane.showMessageDialog(null,"No files in the selected folder!","Warning!",JOptionPane.WARNING_MESSAGE);
                    }
                    if(jButton_Run!=null)jButton_Run.setText("Run");
                }                
            };

            thread.start();
        }else{
            if(JOptionPane.showConfirmDialog (null, "Calculations are running!\nAre you sure you want to stop?","Calculations running!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                thread.interrupt();
                if(jButton_Run!=null)jButton_Run.setText("Run");
            }
        }
    }
    
    public static void calculate(Settings settings, TreeMap<String,String> files, TreeMap<String,int[]> seriesFrames){
        
        pathPSF = settings.intermediatePath+"\\PSF";
        pathDeconvolved = settings.intermediatePath+"\\Deconvolved";
        pathLog = settings.intermediatePath+"\\Log";
        if(!new File(pathPSF).exists()){
            new File(pathPSF).mkdirs();
        }        
        if(!new File(pathDeconvolved).exists()){
            new File(pathDeconvolved).mkdirs();
        }       
        if(!new File(pathLog).exists()){
            new File(pathLog).mkdirs();
        }
        
        if(settings._PSF_calc==2)try {
            PSF.load(settings);
        } catch (FormatException | IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Map.Entry<String,String> file:files.entrySet()){                    //input file
            for(int sr=0; sr<seriesFrames.get(file.getValue())[0];sr++){        //series
                for(int fr=0; fr<seriesFrames.get(file.getValue())[1];fr++){    //
                    for(int ch=0 ; ch<settings.channels ; ch++){
                                                
                        fileName=file.getValue()+"_sr"+sr+"_fr"+fr+"_ch"+ch+".tif";
                        if(!new File(pathDeconvolved+"\\"+fileName).exists()){
                            try {
                                
                                if(settings._BF.get(ch)){
                                    PSF.bf(settings.intermediatePath+"\\Split\\"+fileName,pathDeconvolved+"\\"+fileName);
                                    //FileUtils.copyFile(new File(settings.intermediatePath+"\\Split\\"+fileName), new File(pathDeconvolved+"\\"+fileName));
                                }else{   
                                    //calculate PSF
                                    if(settings._PSF_calc != 2 && sr == 0 && fr == 0){
                                        if(settings._BF.get(ch)==true) continue;
                                        PSF.calculate(settings, file, ch);
                                    }
                                    Deconvolution.run(settings, file, sr, fr, ch);

                                }
                            } catch (IOException | InterruptedException ex) {
                                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                try {
                    Combine.run(settings, file, seriesFrames.get(file.getValue()), sr);
                    /////////
                } catch (FormatException | IOException ex) {
                    Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(settings.delete){
                    for(int fr=0; fr<seriesFrames.get(file.getValue())[1];fr++){
                        for(int ch=0 ; ch<settings.channels ; ch++){
                            
                            
                            new File(settings.intermediatePath+"\\Deconvolved\\"+file.getValue()+"_sr"+sr+"_fr"+fr+"_ch"+ch+".tif").delete();
                        }
                    }
                }
            }
            if(settings._PSF_calc == 1 && settings.delete && settings.deletePSF){
                for(int ch=0 ; ch<settings.channels ; ch++){
                    if(!settings._BF.get(ch)){
                        new File(settings.intermediatePath+"\\PSF\\PSF_"+file.getValue()+"_ch"+ch+".tif").delete();
                        new File(settings.intermediatePath+"\\PSF_config\\PSF_"+file.getValue()+"_ch"+ch+".txt").delete();
                    }
                }
            }   
        }   
        try {
            Log.create(settings, files, seriesFrames);
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(settings.delete){
            IJ.log("Deleting intermediate files");
            delete(settings.intermediatePath+"\\Split");
            delete(settings.intermediatePath+"\\Deconvolved");
            
            if(settings.deletePSF){
                delete(settings.intermediatePath+"\\PSF");
                delete(settings.intermediatePath+"\\PSF_config");
            }     
            
            if(settings.deleteLog){
                delete(settings.intermediatePath+"\\PSF");
            }
            
            if(settings.deleteLog && settings.deletePSF){
                delete(settings.intermediatePath);
            }
        }
        

            
        
        
    }
    
    public static void delete(String path){
        while(!new File(path).delete() && new File(path).isDirectory()){
            for(String file: new File(path).list()){
                delete(path+"\\"+file);
            }
        }
    }
    
    private static String pathPSF;
    private static String pathDeconvolved;
    private static String pathLog;
    private static String fileName;
    private static TreeMap<String,String> files;
    private static TreeMap<String,Pair<double[],int[]>> pxPSF;
    private static ArrayList<String> blackList;
    private static TreeMap<String,int[]> seriesFrames;
    private static Thread thread = new Thread();
}
