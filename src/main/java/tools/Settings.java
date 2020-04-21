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
package tools;

import java.util.ArrayList;
/**
 *
 * @author Zbigniew Baster
 */
public class Settings {
    //General
    public static String loadSavePath;
    
    //IO
    public static String inputPath;
    public static boolean outputPath_Selected;
    public static String outputPath;
    public static boolean intermediatePath_Selected;
    public static String intermediatePath;
    public static boolean logPath_Selected;
    public static String logPath;
    public static boolean delete;
    public static boolean deletePSF;
    public static boolean deleteLog;
    
    //PSF
    public static int _PSF_calc; // 0 - once; 1 - all; 2 - load
    public static double _NA;        
    public static String accuracy;
    public static String bit;
    public static int _PSFTab; // 0 - GL; 1 - RW; 2 - VRIGL; 3 - BW; 4 - TV
    public static String modelPSF;
    
    public static int _WD;
    public static int zPos;
    public static String _RIvariation;
    
    public static String _PSFPath;
    
    //Wavelength
    public static int channels;
    public static double _RIoil;
    public static boolean _RIoil_different;
    public static double _RIsample;
    public static boolean _RIsample_different;
    public static double _RIsampleZ;
    public static boolean _RIsampleZ_different;
    
    public static int lambda1;
    public static int lambda2;
    public static int lambda3;
    public static int lambda4;
    public static int lambda5;
    public static int lambda6;
    public static int lambda7;
    public static int lambda8;
    public static ArrayList<Integer> lambda;
    
    public static double oil_RI1;
    public static double oil_RI2;
    public static double oil_RI3;
    public static double oil_RI4;
    public static double oil_RI5;
    public static double oil_RI6;
    public static double oil_RI7;
    public static double oil_RI8;
    public static ArrayList<Double> oil_RI;
    
    public static double sample_RI1;
    public static double sample_RI2;
    public static double sample_RI3;
    public static double sample_RI4;
    public static double sample_RI5;
    public static double sample_RI6;
    public static double sample_RI7;
    public static double sample_RI8;
    public static ArrayList<Double> sample_RI;
    
    public static double sampleZ_RI1;
    public static double sampleZ_RI2;
    public static double sampleZ_RI3;
    public static double sampleZ_RI4;
    public static double sampleZ_RI5;
    public static double sampleZ_RI6;
    public static double sampleZ_RI7;
    public static double sampleZ_RI8;
    public static ArrayList<Double> sampleZ_RI;  
    
    public static boolean _BF1;
    public static boolean _BF2;
    public static boolean _BF3;
    public static boolean _BF4;
    public static boolean _BF5;
    public static boolean _BF6;
    public static boolean _BF7;
    public static boolean _BF8;
    public static ArrayList<Boolean> _BF;
    
    //Deconvolution
    public static int deconvTab;
    public static String deconvAlgorithm;
    public static int nIterations;
    public static double step;
    public static double reg;
    public static String wevelets;
    public static int scale;
    
    public static String constraint;
    public static boolean residuSelected;
    public static double residu;
    public static String fft;
    public static String epsilon;
    public static String apodizationXY;
    public static String apodizationZ;
    public static int paddingExtensionXY;
    public static int paddingExtensionZ;
    public static String paddingConstrainXY;
    public static String paddingConstrainZ;
    public static String _PSFnorm;
    
    
    //IO unimportant
    public static boolean outputPath_Enabled;
    public static boolean jButton_OutputPath_Enabled;
   
    public static boolean intermediatePath_Enabled;
    public static boolean jButton_IntermediatePath_Enabled;
    
    public static boolean logPath_Enabled;
    public static boolean jButton_LogPath_Enabled;
    
    public static boolean deletePSF_Enabled;
    public static boolean deleteLog_Enabled;
    
    //PSF uninportant
    public static boolean jLabel_Accuracy_Enabled;
    public static boolean jComboBox_Accuracy_Enabled;
    public static boolean jTextField_RI_Oil_Enabled;
    public static boolean jTextField_RI_Sample_GL_Enabled;
    public static boolean jTextField_RI_Sample0_VRIGL_Enabled;
    public static boolean jTextField_RI_SampleZ_VRIGL_Enabled;
    public static boolean jTextField_RI_Sample_TV_Enabled;
    
    //Wavelength unimportant
    public static boolean jLabel_Wave_RIOil_Enabled;
    public static boolean jLabel_Wave_RISample_Enabled;
    public static boolean jLabel_Wave_RISample0_Enabled;
    public static boolean jLabel_Wave_RISampleZ_Enabled;
    public static boolean jTextField_Wave_RI_Oil_Enabled;
    public static boolean jTextField_Wave_RI_Sample_Enabled;
    public static boolean jTextField_Wave_RI_SampleZ_Enabled;
    
    public static boolean jLabel_Wavelength_Enabled;
    public static boolean jLabel_OilRI_Enabled;
    public static boolean jLabel_SampleRI_Enabled;
    public static boolean jLabel_Sample0RI_Enabled;
    public static boolean jLabel_SampleZRI_Enabled;
    
    public static boolean channel1_Enabled;
    public static boolean channel2_Enabled;
    public static boolean channel3_Enabled;
    public static boolean channel4_Enabled;
    public static boolean channel5_Enabled;
    public static boolean channel6_Enabled;
    public static boolean channel7_Enabled;
    public static boolean channel8_Enabled; 
    
    public static boolean lambda1_Enabled;
    public static boolean lambda2_Enabled;
    public static boolean lambda3_Enabled;
    public static boolean lambda4_Enabled;
    public static boolean lambda5_Enabled;
    public static boolean lambda6_Enabled;
    public static boolean lambda7_Enabled;
    public static boolean lambda8_Enabled;
    
    public static boolean oil_RI1_Enabled;
    public static boolean oil_RI2_Enabled;
    public static boolean oil_RI3_Enabled;
    public static boolean oil_RI4_Enabled;
    public static boolean oil_RI5_Enabled;
    public static boolean oil_RI6_Enabled;
    public static boolean oil_RI7_Enabled;
    public static boolean oil_RI8_Enabled;
    
    public static boolean sample_RI1_Enabled;
    public static boolean sample_RI2_Enabled;
    public static boolean sample_RI3_Enabled;
    public static boolean sample_RI4_Enabled;
    public static boolean sample_RI5_Enabled;
    public static boolean sample_RI6_Enabled;
    public static boolean sample_RI7_Enabled;
    public static boolean sample_RI8_Enabled;
    
    public static boolean sampleZ_RI1_Enabled;
    public static boolean sampleZ_RI2_Enabled;
    public static boolean sampleZ_RI3_Enabled;
    public static boolean sampleZ_RI4_Enabled;
    public static boolean sampleZ_RI5_Enabled;
    public static boolean sampleZ_RI6_Enabled;
    public static boolean sampleZ_RI7_Enabled;
    public static boolean sampleZ_RI8_Enabled;  
    
    public static boolean _BF1_Enabled;
    public static boolean _BF2_Enabled;
    public static boolean _BF3_Enabled;
    public static boolean _BF4_Enabled;
    public static boolean _BF5_Enabled;
    public static boolean _BF6_Enabled;
    public static boolean _BF7_Enabled;
    public static boolean _BF8_Enabled;
    
    //Deconvolution unimportant
    public static boolean residu_Enabled;
    
    public static void lambda(){
        lambda = new ArrayList<Integer>();
        lambda.add(lambda1);
        lambda.add(lambda2);
        lambda.add(lambda3);
        lambda.add(lambda4);
        lambda.add(lambda5);
        lambda.add(lambda6);
        lambda.add(lambda7);
        lambda.add(lambda8);
    }
    
    public static void oil_RI(){
        oil_RI = new ArrayList<Double>();
        oil_RI.add(oil_RI1);
        oil_RI.add(oil_RI2);
        oil_RI.add(oil_RI3);
        oil_RI.add(oil_RI4);
        oil_RI.add(oil_RI5);
        oil_RI.add(oil_RI6);
        oil_RI.add(oil_RI7);
        oil_RI.add(oil_RI8);
    }
    
    public static void sample_RI(){
        sample_RI = new ArrayList<Double>();
        sample_RI.add(sample_RI1);
        sample_RI.add(sample_RI2);
        sample_RI.add(sample_RI3);
        sample_RI.add(sample_RI4);
        sample_RI.add(sample_RI5);
        sample_RI.add(sample_RI6);
        sample_RI.add(sample_RI7);
        sample_RI.add(sample_RI8);
    }  
    
    public static void sampleZ_RI(){
        sampleZ_RI = new ArrayList<Double>();
        sampleZ_RI.add(sampleZ_RI1);
        sampleZ_RI.add(sampleZ_RI2);
        sampleZ_RI.add(sampleZ_RI3);
        sampleZ_RI.add(sampleZ_RI4);
        sampleZ_RI.add(sampleZ_RI5);
        sampleZ_RI.add(sampleZ_RI6);
        sampleZ_RI.add(sampleZ_RI7);
        sampleZ_RI.add(sampleZ_RI8);
    }
    
    public static void _BF(){
        _BF = new ArrayList<Boolean>();
        _BF.add(_BF1);
        _BF.add(_BF2);
        _BF.add(_BF3);
        _BF.add(_BF4);
        _BF.add(_BF5);
        _BF.add(_BF6);
        _BF.add(_BF7);
        _BF.add(_BF8);
    } 
}
