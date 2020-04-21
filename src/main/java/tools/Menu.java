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

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.text.NumberFormatter;
import calculations.Run;

/**
 *
 * @author Zbigniew Baster
 */
public class Menu extends javax.swing.JFrame {
    
    public void PSFMethodNone() {     
        jTextField_SampleRI1.setEnabled(false);
        jTextField_SampleRI2.setEnabled(false);
        jTextField_SampleRI3.setEnabled(false);
        jTextField_SampleRI4.setEnabled(false);
        jTextField_SampleRI5.setEnabled(false);
        jTextField_SampleRI6.setEnabled(false);
        jTextField_SampleRI7.setEnabled(false);
        jTextField_SampleRI8.setEnabled(false);
        
        jTextField_SampleZRI1.setEnabled(false);
        jTextField_SampleZRI2.setEnabled(false);
        jTextField_SampleZRI3.setEnabled(false);
        jTextField_SampleZRI4.setEnabled(false);
        jTextField_SampleZRI5.setEnabled(false);
        jTextField_SampleZRI6.setEnabled(false);
        jTextField_SampleZRI7.setEnabled(false);
        jTextField_SampleZRI8.setEnabled(false);
        
        jLabel_Wave_RISample.setEnabled(false);
        jLabel_Wave_RISample0.setEnabled(false);
        jLabel_Wave_RISampleZ.setEnabled(false);
        jLabel_SampleRI.setEnabled(false);
        jLabel_Sample0RI.setEnabled(false);
        jLabel_SampleZRI.setEnabled(false);

        jTextField_Wave_RISample.setEnabled(false);
        jTextField_Wave_RISampleZ.setEnabled(false);

        jCheckBox_Wave_DifferentRISample.setEnabled(false);
        jCheckBox_Wave_DifferentRISampleZ.setEnabled(false);
    }
    
    public void PSFMethodGL_TV(boolean ri) {
        if(!jCheckBox_Brightfield1.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=0)jTextField_SampleRI1.setEnabled(ri);
        if(!jCheckBox_Brightfield2.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=1)jTextField_SampleRI2.setEnabled(ri);
        if(!jCheckBox_Brightfield3.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=2)jTextField_SampleRI3.setEnabled(ri);
        if(!jCheckBox_Brightfield4.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=3)jTextField_SampleRI4.setEnabled(ri);
        if(!jCheckBox_Brightfield5.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=4)jTextField_SampleRI5.setEnabled(ri);
        if(!jCheckBox_Brightfield6.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=5)jTextField_SampleRI6.setEnabled(ri);
        if(!jCheckBox_Brightfield7.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=6)jTextField_SampleRI7.setEnabled(ri);
        if(!jCheckBox_Brightfield8.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=7)jTextField_SampleRI8.setEnabled(ri);
               
        jTextField_SampleZRI1.setEnabled(false);
        jTextField_SampleZRI2.setEnabled(false);
        jTextField_SampleZRI3.setEnabled(false);
        jTextField_SampleZRI4.setEnabled(false);
        jTextField_SampleZRI5.setEnabled(false);
        jTextField_SampleZRI6.setEnabled(false);
        jTextField_SampleZRI7.setEnabled(false);
        jTextField_SampleZRI8.setEnabled(false);
        
        jLabel_Wave_RISample.setEnabled(true);
        jLabel_Wave_RISample0.setEnabled(false);
        jLabel_Wave_RISampleZ.setEnabled(false);
        jLabel_SampleRI.setEnabled(ri);
        jLabel_Sample0RI.setEnabled(false);
        jLabel_SampleZRI.setEnabled(false);

        jTextField_Wave_RISample.setEnabled(!ri);
        jTextField_Wave_RISampleZ.setEnabled(false);

        jCheckBox_Wave_DifferentRISample.setEnabled(true);
        jCheckBox_Wave_DifferentRISampleZ.setEnabled(false);
        
        jCheckBox_Wave_DifferentRISample.setSelected(ri);
    }
    
    public void PSFMethodVRIGL(boolean ri0, boolean riZ) {
        if(!jCheckBox_Brightfield1.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=0)jTextField_SampleRI1.setEnabled(ri0);
        if(!jCheckBox_Brightfield2.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=1)jTextField_SampleRI2.setEnabled(ri0);
        if(!jCheckBox_Brightfield3.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=2)jTextField_SampleRI3.setEnabled(ri0);
        if(!jCheckBox_Brightfield4.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=3)jTextField_SampleRI4.setEnabled(ri0);
        if(!jCheckBox_Brightfield5.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=4)jTextField_SampleRI5.setEnabled(ri0);
        if(!jCheckBox_Brightfield6.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=5)jTextField_SampleRI6.setEnabled(ri0);
        if(!jCheckBox_Brightfield7.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=6)jTextField_SampleRI7.setEnabled(ri0);
        if(!jCheckBox_Brightfield8.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=7)jTextField_SampleRI8.setEnabled(ri0);
               
        if(!jCheckBox_Brightfield1.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=0)jTextField_SampleZRI1.setEnabled(riZ);
        if(!jCheckBox_Brightfield2.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=1)jTextField_SampleZRI2.setEnabled(riZ);
        if(!jCheckBox_Brightfield3.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=2)jTextField_SampleZRI3.setEnabled(riZ);
        if(!jCheckBox_Brightfield4.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=3)jTextField_SampleZRI4.setEnabled(riZ);
        if(!jCheckBox_Brightfield5.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=4)jTextField_SampleZRI5.setEnabled(riZ);
        if(!jCheckBox_Brightfield6.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=5)jTextField_SampleZRI6.setEnabled(riZ);
        if(!jCheckBox_Brightfield7.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=6)jTextField_SampleZRI7.setEnabled(riZ);
        if(!jCheckBox_Brightfield8.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=7)jTextField_SampleZRI8.setEnabled(riZ);
        
        jLabel_Wave_RISample.setEnabled(true);
        jLabel_Wave_RISample0.setEnabled(true);
        jLabel_Wave_RISampleZ.setEnabled(true);
        jLabel_SampleRI.setEnabled(ri0);
        jLabel_Sample0RI.setEnabled(ri0);
        jLabel_SampleZRI.setEnabled(riZ);

        jTextField_Wave_RISample.setEnabled(!ri0);
        jTextField_Wave_RISampleZ.setEnabled(!riZ);

        jCheckBox_Wave_DifferentRISample.setEnabled(true);
        jCheckBox_Wave_DifferentRISampleZ.setEnabled(true);
        
        jCheckBox_Wave_DifferentRISample.setSelected(ri0);
        jCheckBox_Wave_DifferentRISampleZ.setSelected(riZ);
    }
    
    public void setOilRI_ON(boolean on){
        jTextField_RI_Oil.setEnabled(!on);
        jTextField_Wave_RIOil.setEnabled(!on);
        
        jLabel_OilRI.setEnabled(on);
        
        jCheckBox_DifferentRIOil.setSelected(on);
        jCheckBox_Wave_DifferentRIOil.setSelected(on);
        
        if(!jCheckBox_Brightfield1.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=0)jTextField_OilRI1.setEnabled(on);
        if(!jCheckBox_Brightfield2.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=1)jTextField_OilRI2.setEnabled(on);
        if(!jCheckBox_Brightfield3.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=2)jTextField_OilRI3.setEnabled(on);
        if(!jCheckBox_Brightfield4.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=3)jTextField_OilRI4.setEnabled(on);
        if(!jCheckBox_Brightfield5.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=4)jTextField_OilRI5.setEnabled(on);
        if(!jCheckBox_Brightfield6.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=5)jTextField_OilRI6.setEnabled(on);
        if(!jCheckBox_Brightfield7.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=6)jTextField_OilRI7.setEnabled(on);
        if(!jCheckBox_Brightfield8.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=7)jTextField_OilRI8.setEnabled(on);
    }
    
    public void setSampleRI_ON(boolean on){
        jTextField_Wave_RISample.setEnabled(!on);
        jTextField_RI_Sample_GL.setEnabled(!on);
        jTextField_RI_Sample0_VRIGL.setEnabled(!on);
        jTextField_RI_Sample_TV.setEnabled(!on);
        
        jLabel_SampleRI.setEnabled(on);
                
        jCheckBox_DifferentRI_Sample_GL.setSelected(on);
        jCheckBox_DifferentRI_Sample0_VRIGL.setSelected(on);
        jCheckBox_DifferentRI_Sample_TV.setSelected(on);
        jCheckBox_Wave_DifferentRISample.setSelected(on);
        
        if(!jCheckBox_Brightfield1.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=0)jTextField_SampleRI1.setEnabled(on);
        if(!jCheckBox_Brightfield2.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=1)jTextField_SampleRI2.setEnabled(on);
        if(!jCheckBox_Brightfield3.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=2)jTextField_SampleRI3.setEnabled(on);
        if(!jCheckBox_Brightfield4.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=3)jTextField_SampleRI4.setEnabled(on);
        if(!jCheckBox_Brightfield5.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=4)jTextField_SampleRI5.setEnabled(on);
        if(!jCheckBox_Brightfield6.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=5)jTextField_SampleRI6.setEnabled(on);
        if(!jCheckBox_Brightfield7.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=6)jTextField_SampleRI7.setEnabled(on);
        if(!jCheckBox_Brightfield8.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=7)jTextField_SampleRI8.setEnabled(on);
        
        if(jTabbedPane_PSFMethod.getSelectedIndex()==2)jLabel_Sample0RI.setEnabled(on);
    }
    
    public void setSampleRIZ_ON(boolean on){
        jTextField_RI_SampleZ_VRIGL.setEnabled(!on);
        jTextField_Wave_RISampleZ.setEnabled(!on);
        
        jLabel_SampleZRI.setEnabled(on);
        jCheckBox_DifferentRI_SampleZ_VRIGL.setSelected(on);
        jCheckBox_Wave_DifferentRISampleZ.setSelected(on);
        
        jCheckBox_DifferentRI_SampleZ_VRIGL.setSelected(on);
        jCheckBox_Wave_DifferentRISampleZ.setSelected(on);
        
        if(!jCheckBox_Brightfield1.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=0)jTextField_SampleZRI1.setEnabled(on);
        if(!jCheckBox_Brightfield2.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=1)jTextField_SampleZRI2.setEnabled(on);
        if(!jCheckBox_Brightfield3.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=2)jTextField_SampleZRI3.setEnabled(on);
        if(!jCheckBox_Brightfield4.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=3)jTextField_SampleZRI4.setEnabled(on);
        if(!jCheckBox_Brightfield5.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=4)jTextField_SampleZRI5.setEnabled(on);
        if(!jCheckBox_Brightfield6.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=5)jTextField_SampleZRI6.setEnabled(on);
        if(!jCheckBox_Brightfield7.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=6)jTextField_SampleZRI7.setEnabled(on);
        if(!jCheckBox_Brightfield8.isSelected() && jComboBox_ChannelNumber.getSelectedIndex()>=7)jTextField_SampleZRI8.setEnabled(on);
    }
    
    private static void activateChannel (int no){
        jLabel_Channel2.setEnabled(no>0);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield2.isSelected()) jTextField_Wavelength2.setEnabled(no>0);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield2.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI2.setEnabled(no>0);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield2.isSelected() && jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI2.setEnabled(no>0);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield2.isSelected() &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI2.setEnabled(no>0);
        jCheckBox_Brightfield2.setEnabled(no>0);
        
        jLabel_Channel3.setEnabled(no>1);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield3.isSelected()) jTextField_Wavelength3.setEnabled(no>1);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield3.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI3.setEnabled(no>1);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield3.isSelected() && jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI3.setEnabled(no>1);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield3.isSelected() &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI3.setEnabled(no>1);
        jCheckBox_Brightfield3.setEnabled(no>1);
        
        jLabel_Channel4.setEnabled(no>2);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield4.isSelected()) jTextField_Wavelength4.setEnabled(no>2);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield4.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI4.setEnabled(no>2);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield4.isSelected() && jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI4.setEnabled(no>2);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield4.isSelected() &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI4.setEnabled(no>2);
        jCheckBox_Brightfield4.setEnabled(no>2);
        
        jLabel_Channel5.setEnabled(no>3);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield5.isSelected()) jTextField_Wavelength5.setEnabled(no>3);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield5.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI5.setEnabled(no>3);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield5.isSelected() && jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI5.setEnabled(no>3);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield5.isSelected() &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI5.setEnabled(no>3);
        jCheckBox_Brightfield5.setEnabled(no>3);
        
        jLabel_Channel6.setEnabled(no>4);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield6.isSelected()) jTextField_Wavelength6.setEnabled(no>4);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield6.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI6.setEnabled(no>4);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield6.isSelected() && jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI6.setEnabled(no>4);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield6.isSelected() &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI6.setEnabled(no>4);
        jCheckBox_Brightfield6.setEnabled(no>4);
        
        jLabel_Channel7.setEnabled(no>5);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield7.isSelected()) jTextField_Wavelength7.setEnabled(no>5);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield7.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI7.setEnabled(no>5);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield7.isSelected() && jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI7.setEnabled(no>5);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield7.isSelected() &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI7.setEnabled(no>5);
        jCheckBox_Brightfield7.setEnabled(no>5);
        
        jLabel_Channel8.setEnabled(no>6);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield8.isSelected()) jTextField_Wavelength8.setEnabled(no>6);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield8.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI8.setEnabled(no>6);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield8.isSelected() && jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI8.setEnabled(no>6);
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 && !jCheckBox_Brightfield8.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI8.setEnabled(no>6);
        jCheckBox_Brightfield8.setEnabled(no>6);  
        
    }
    
    private static void setReg (String deconv, int reg){
        try{
            if(! ("RIFf".equals(deconv)))jTextField_RIF_Reg.setText(
                ((-1000 <= reg && reg < 4000) ?
                    String.format("%.4G",Math.pow(10,(double)reg/1000)):
                    String.format("%4.3E",Math.pow(10,(double)reg/1000)))
            );
            if(! ("TRIFf".equals(deconv)))jTextField_TRIF_Reg.setText(
                ((-1000 <= reg && reg < 4000) ?
                    String.format("%.4G",Math.pow(10,(double)reg/1000)):
                    String.format("%4.3E",Math.pow(10,(double)reg/1000)))
            );
            if(! ("FISTAf".equals(deconv)))jTextField_FISTA_Reg.setText(
                ((-1000 <= reg && reg < 4000) ?
                    String.format("%.4G",Math.pow(10,(double)reg/1000)):
                    String.format("%4.3E",Math.pow(10,(double)reg/1000)))
            );
            if(! ("ISTAf".equals(deconv)))jTextField_ISTA_Reg.setText(
                ((-1000 <= reg && reg < 4000) ?
                    String.format("%.4G",Math.pow(10,(double)reg/1000)):
                    String.format("%4.3E",Math.pow(10,(double)reg/1000)))
            );
            if(! ("RLTVf".equals(deconv)))jTextField_RLTV_Reg.setText(
                ((-1000 <= reg && reg < 4000) ?
                    String.format("%.4G",Math.pow(10,(double)reg/1000)):
                    String.format("%4.3E",Math.pow(10,(double)reg/1000)))
            );
            if(! ("TMf".equals(deconv)))jTextField_TM_Reg.setText(
                ((-1000 <= reg && reg < 4000) ?
                    String.format("%.4G",Math.pow(10,(double)reg/1000)):
                    String.format("%4.3E",Math.pow(10,(double)reg/1000)))
            );
            if(! ("ICTMf".equals(deconv)))jTextField_ICTM_Reg.setText(
                ((-1000 <= reg && reg < 4000) ?
                    String.format("%.4G",Math.pow(10,(double)reg/1000)):
                    String.format("%4.3E",Math.pow(10,(double)reg/1000)))
            );
          
            if(! ("RIFs".equals(deconv)))jSlider_RIF_Reg.setValue(reg);
            if(! ("TRIFs".equals(deconv)))jSlider_TRIF_Reg.setValue(reg);
            if(! ("FISTAs".equals(deconv)))jSlider_FISTA_Reg.setValue(reg);
            if(! ("ISTAs".equals(deconv)))jSlider_ISTA_Reg.setValue(reg);
            if(! ("RLTVs".equals(deconv)))jSlider_RLTV_Reg.setValue(reg);
            if(! ("TMs".equals(deconv)))jSlider_TM_Reg.setValue(reg);
            if(! ("ICTMs".equals(deconv)))jSlider_ICTM_Reg.setValue(reg);
        }catch(NumberFormatException ex){}
    }
    
    private static void setNIterations (Object iteration){
        jSpinner_FISTA_Iterations.setValue(iteration);
        jSpinner_ISTA_Iterations.setValue(iteration);
        jSpinner_LW_Iterations.setValue(iteration);
        jSpinner_NNLS_Iterations.setValue(iteration);
        jSpinner_BVLS_Iterations.setValue(iteration);
        jSpinner_RL_Iterations.setValue(iteration);
        jSpinner_RLTV_Iterations.setValue(iteration);
        jSpinner_TM_Iterations.setValue(iteration);
        jSpinner_ICTM_Iterations.setValue(iteration);
        jSpinner_VC_Iterations.setValue(iteration);

    }
    
    private static void setStep (Object step){
        jSpinner_FISTA_Step.setValue(step);
        jSpinner_ISTA_Step.setValue(step);
        jSpinner_LW_Step.setValue(step);
        jSpinner_NNLS_Step.setValue(step);
        jSpinner_BVLS_Step.setValue(step);
        jSpinner_TM_Step.setValue(step);
        jSpinner_ICTM_Step.setValue(step);
        jSpinner_VC_Step.setValue(step);

    }
    
    private static void setWavelets (Object pos){
        jComboBox_FISTA_Wavelets.setSelectedItem(pos);
        jComboBox_ISTA_Wavelets.setSelectedItem(pos);
    }
    
    private static void setScale (Object pos){
        jComboBox_FISTA_Scale.setSelectedItem(pos);
        jComboBox_ISTA_Scale.setSelectedItem(pos);

    }
    
    private static void jComboBox_LoadPSP (boolean b){
        
        jTextField_Wave_RIOil.setEnabled(b && !jCheckBox_Wave_DifferentRIOil.isSelected());
        jCheckBox_Wave_DifferentRIOil.setEnabled(b);
        jTextField_Wave_RISample.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jTextField_RI_Sample0_VRIGL.isEnabled());
        jCheckBox_Wave_DifferentRISample.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0);
        jTextField_Wave_RISampleZ.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jTextField_RI_SampleZ_VRIGL.isEnabled());
        jCheckBox_Wave_DifferentRISampleZ.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex() == 2);
        
        jLabel_Wave_RIOil.setEnabled(b);
        jLabel_Wave_RISample.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0);
        jLabel_Wave_RISample0.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex() == 2);
        jLabel_Wave_RISampleZ.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex() == 2);
        
        jLabel_Wavelength.setEnabled(b);
        jLabel_OilRI.setEnabled(b && jCheckBox_Wave_DifferentRIOil.isSelected());
        jLabel_SampleRI.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
        jLabel_Sample0RI.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISample.isSelected());
        jLabel_SampleZRI.setEnabled(b && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());
                      
        jTextField_Wavelength1.setEnabled(b && jLabel_Channel1.isEnabled() && !jCheckBox_Brightfield1.isSelected());
        jTextField_Wavelength2.setEnabled(b && jLabel_Channel2.isEnabled() && !jCheckBox_Brightfield2.isSelected());
        jTextField_Wavelength3.setEnabled(b && jLabel_Channel3.isEnabled() && !jCheckBox_Brightfield3.isSelected());
        jTextField_Wavelength4.setEnabled(b && jLabel_Channel4.isEnabled() && !jCheckBox_Brightfield4.isSelected());
        jTextField_Wavelength5.setEnabled(b && jLabel_Channel5.isEnabled() && !jCheckBox_Brightfield5.isSelected());
        jTextField_Wavelength6.setEnabled(b && jLabel_Channel6.isEnabled() && !jCheckBox_Brightfield6.isSelected());
        jTextField_Wavelength7.setEnabled(b && jLabel_Channel7.isEnabled() && !jCheckBox_Brightfield7.isSelected());
        jTextField_Wavelength8.setEnabled(b && jLabel_Channel8.isEnabled() && !jCheckBox_Brightfield8.isSelected());
        
        jTextField_OilRI1.setEnabled(b && jLabel_Channel1.isEnabled() && !jCheckBox_Brightfield1.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected());
        jTextField_OilRI2.setEnabled(b && jLabel_Channel2.isEnabled() && !jCheckBox_Brightfield2.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected());
        jTextField_OilRI3.setEnabled(b && jLabel_Channel3.isEnabled() && !jCheckBox_Brightfield3.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected());
        jTextField_OilRI4.setEnabled(b && jLabel_Channel4.isEnabled() && !jCheckBox_Brightfield4.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected());
        jTextField_OilRI5.setEnabled(b && jLabel_Channel5.isEnabled() && !jCheckBox_Brightfield5.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected());
        jTextField_OilRI6.setEnabled(b && jLabel_Channel6.isEnabled() && !jCheckBox_Brightfield6.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected());
        jTextField_OilRI7.setEnabled(b && jLabel_Channel7.isEnabled() && !jCheckBox_Brightfield7.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected());
        jTextField_OilRI8.setEnabled(b && jLabel_Channel8.isEnabled() && !jCheckBox_Brightfield8.isSelected() && jCheckBox_Wave_DifferentRIOil.isSelected());
       
        jTextField_SampleRI1.setEnabled(b && jLabel_Channel1.isEnabled() && !jCheckBox_Brightfield1.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
        jTextField_SampleRI2.setEnabled(b && jLabel_Channel2.isEnabled() && !jCheckBox_Brightfield2.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
        jTextField_SampleRI3.setEnabled(b && jLabel_Channel3.isEnabled() && !jCheckBox_Brightfield3.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
        jTextField_SampleRI4.setEnabled(b && jLabel_Channel4.isEnabled() && !jCheckBox_Brightfield4.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
        jTextField_SampleRI5.setEnabled(b && jLabel_Channel5.isEnabled() && !jCheckBox_Brightfield5.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
        jTextField_SampleRI6.setEnabled(b && jLabel_Channel6.isEnabled() && !jCheckBox_Brightfield6.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
        jTextField_SampleRI7.setEnabled(b && jLabel_Channel7.isEnabled() && !jCheckBox_Brightfield7.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
        jTextField_SampleRI8.setEnabled(b && jLabel_Channel8.isEnabled() && !jCheckBox_Brightfield8.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex()%2 == 0 && jCheckBox_Wave_DifferentRISample.isSelected());
       
        jTextField_SampleZRI1.setEnabled(b && jLabel_Channel1.isEnabled() && !jCheckBox_Brightfield1.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());
        jTextField_SampleZRI2.setEnabled(b && jLabel_Channel2.isEnabled() && !jCheckBox_Brightfield2.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());
        jTextField_SampleZRI3.setEnabled(b && jLabel_Channel3.isEnabled() && !jCheckBox_Brightfield3.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());
        jTextField_SampleZRI4.setEnabled(b && jLabel_Channel4.isEnabled() && !jCheckBox_Brightfield4.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());
        jTextField_SampleZRI5.setEnabled(b && jLabel_Channel5.isEnabled() && !jCheckBox_Brightfield5.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());
        jTextField_SampleZRI6.setEnabled(b && jLabel_Channel6.isEnabled() && !jCheckBox_Brightfield6.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());
        jTextField_SampleZRI7.setEnabled(b && jLabel_Channel7.isEnabled() && !jCheckBox_Brightfield7.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());
        jTextField_SampleZRI8.setEnabled(b && jLabel_Channel8.isEnabled() && !jCheckBox_Brightfield8.isSelected() && jTabbedPane_PSFMethod.getSelectedIndex() == 2 && jCheckBox_Wave_DifferentRISampleZ.isSelected());      
    }
    
    public static void readSettings (Settings s){
                //IO
        s.inputPath                  = jTextField_InputPath.getText();
        s.outputPath_Selected        = jCheckBox_OutputPath.isSelected();
        s.outputPath                 = jTextField_OutputPath.getText();
        s.intermediatePath_Selected  = jCheckBox_IntermediatePath.isSelected();
        s.intermediatePath           = jTextField_IntermediatePath.getText();
        s.logPath_Selected           = jCheckBox_LogPath.isSelected();
        s.logPath                    = jTextField_LogPath.getText();
        s.delete                     = jCheckBox_Delete.isSelected();
        s.deletePSF                  = jCheckBox_DeletePSF.isSelected();
        s.deleteLog                  = jCheckBox_DeleteLog.isSelected();
        
         //PSF
        s._PSF_calc              = jComboBox_PSFCalculateOrNot.getSelectedIndex(); // 0 - once; 1 - all; 2 - load
        s._NA                    = Double.parseDouble(jTextField_NA.getText());        
        s.accuracy               = (String) jComboBox_Accuracy.getSelectedItem();
        s.bit                    = (String) jComboBox_Bit.getSelectedItem();
        s._PSFTab                = jComboBox_PSFMethod.getSelectedIndex(); // 0 - GL; 1 - RW; 2 - VRIGL; 3 - BW; 4 - TV
        s.modelPSF               = listPSF.get(jComboBox_PSFMethod.getSelectedIndex());   
        
        s._WD                    = Integer.parseInt(jTextField_Working_GL.getText());
        s.zPos                   = Integer.parseInt(jTextField_Position_GL.getText());
        s._RIvariation           = (String) jComboBox_RIVariation.getSelectedItem();
        s._PSFPath               = jTextField_PSFPath.getText();
    
        //Wavelength
        s.channels              = Integer.parseInt((String)jComboBox_ChannelNumber.getSelectedItem());
        
        s._RIoil                 = Double.parseDouble(jTextField_Wave_RIOil.getText());
        s._RIoil_different       = jCheckBox_Wave_DifferentRIOil.isSelected();
        s._RIsample              = Double.parseDouble(jTextField_Wave_RISample.getText());
        s._RIsample_different    = jCheckBox_Wave_DifferentRISample.isSelected();
        s._RIsampleZ             = Double.parseDouble(jTextField_Wave_RISampleZ.getText());
        s._RIsampleZ_different   = jCheckBox_Wave_DifferentRISampleZ.isSelected();
        
            
        s.lambda1                = Integer.parseInt(jTextField_Wavelength1.getText());
        s.lambda2                = Integer.parseInt(jTextField_Wavelength2.getText());
        s.lambda3                = Integer.parseInt(jTextField_Wavelength3.getText());
        s.lambda4                = Integer.parseInt(jTextField_Wavelength4.getText());
        s.lambda5                = Integer.parseInt(jTextField_Wavelength5.getText());
        s.lambda6                = Integer.parseInt(jTextField_Wavelength6.getText());
        s.lambda7                = Integer.parseInt(jTextField_Wavelength7.getText());
        s.lambda8                = Integer.parseInt(jTextField_Wavelength8.getText());
        s.lambda();
    
        s.oil_RI1                = Double.parseDouble(jTextField_OilRI1.getText());
        s.oil_RI2                = Double.parseDouble(jTextField_OilRI2.getText());
        s.oil_RI3                = Double.parseDouble(jTextField_OilRI3.getText());
        s.oil_RI4                = Double.parseDouble(jTextField_OilRI4.getText());
        s.oil_RI5                = Double.parseDouble(jTextField_OilRI5.getText());
        s.oil_RI6                = Double.parseDouble(jTextField_OilRI6.getText());
        s.oil_RI7                = Double.parseDouble(jTextField_OilRI7.getText());
        s.oil_RI8                = Double.parseDouble(jTextField_OilRI8.getText());
        s.oil_RI();
    
        s.sample_RI1             = Double.parseDouble(jTextField_SampleRI1.getText());
        s.sample_RI2             = Double.parseDouble(jTextField_SampleRI2.getText());
        s.sample_RI3             = Double.parseDouble(jTextField_SampleRI3.getText());
        s.sample_RI4             = Double.parseDouble(jTextField_SampleRI4.getText());
        s.sample_RI5             = Double.parseDouble(jTextField_SampleRI5.getText());
        s.sample_RI6             = Double.parseDouble(jTextField_SampleRI6.getText());
        s.sample_RI7             = Double.parseDouble(jTextField_SampleRI7.getText());
        s.sample_RI8             = Double.parseDouble(jTextField_SampleRI8.getText());
        s.sample_RI();
    
        s.sampleZ_RI1             = Double.parseDouble(jTextField_SampleZRI1.getText());
        s.sampleZ_RI2             = Double.parseDouble(jTextField_SampleZRI2.getText());
        s.sampleZ_RI3             = Double.parseDouble(jTextField_SampleZRI3.getText());
        s.sampleZ_RI4             = Double.parseDouble(jTextField_SampleZRI4.getText());
        s.sampleZ_RI5             = Double.parseDouble(jTextField_SampleZRI5.getText());
        s.sampleZ_RI6             = Double.parseDouble(jTextField_SampleZRI6.getText());
        s.sampleZ_RI7             = Double.parseDouble(jTextField_SampleZRI7.getText());
        s.sampleZ_RI8             = Double.parseDouble(jTextField_SampleZRI8.getText());
        s.sampleZ_RI();
    
        s._BF1                    = jCheckBox_Brightfield1.isSelected();
        s._BF2                    = jCheckBox_Brightfield2.isSelected();
        s._BF3                    = jCheckBox_Brightfield3.isSelected();
        s._BF4                    = jCheckBox_Brightfield4.isSelected();
        s._BF5                    = jCheckBox_Brightfield5.isSelected();
        s._BF6                    = jCheckBox_Brightfield6.isSelected();
        s._BF7                    = jCheckBox_Brightfield7.isSelected();
        s._BF8                    = jCheckBox_Brightfield8.isSelected();
        s._BF();
        
           //Deconvolution
           
        s.deconvTab               = jComboBox_DeconvolutionAlgorithm.getSelectedIndex();
        s.deconvAlgorithm         = listDeconvolution.get(jComboBox_DeconvolutionAlgorithm.getSelectedIndex());
        s.nIterations             = (int)jSpinner_FISTA_Iterations.getValue();
        s.step                    = (double)jSpinner_FISTA_Step.getValue();
        s.reg                     = Double.parseDouble(jTextField_FISTA_Reg.getText());
        s.wevelets                = (String) jComboBox_FISTA_Wavelets.getSelectedItem();
        s.scale                   = Integer.parseInt(jComboBox_FISTA_Scale.getSelectedItem().toString());
        
        s.constraint               = (String) jComboBox_Constraint.getSelectedItem();
        s.residuSelected          = jCheckBox_Residu.isSelected();
        s.residu                  = Double.parseDouble(jTextField_Residu.getText());  
        s.fft                     = (String) jComboBox_FTT.getSelectedItem();
        s.epsilon                 = (String) jComboBox_Epsilon.getSelectedItem();
        s.apodizationXY           = (String) jComboBox_ApodizationXY.getSelectedItem();
        s.apodizationZ            = (String) jComboBox_ApodizationZ.getSelectedItem();
        s.paddingExtensionXY      = (int) jSpinner_PaddingExtensionXY.getValue();
        s.paddingExtensionZ       = (int) jSpinner_PaddingExtensionZ.getValue();
        s.paddingConstrainXY      = (String) jComboBox_PaddingConstraintXY.getSelectedItem();
        s.paddingConstrainZ       = (String) jComboBox_PaddingConstraintZ.getSelectedItem();
        s._PSFnorm                = (String) jComboBox_PSFNormalization.getSelectedItem();
        
    
        //IO unimportant
        s.outputPath_Enabled                   = jTextField_OutputPath.isEnabled();
        s.jButton_OutputPath_Enabled           = jCheckBox_OutputPath.isEnabled();
        
        s.intermediatePath_Enabled             = jTextField_IntermediatePath.isEnabled();
        s.jButton_IntermediatePath_Enabled     = jCheckBox_IntermediatePath.isEnabled();
    
        s.logPath_Enabled                      = jTextField_LogPath.isEnabled();
        s.jButton_LogPath_Enabled              = jCheckBox_LogPath.isEnabled();
        
        s.deletePSF_Enabled                    = jCheckBox_DeletePSF.isEnabled();
        s.deleteLog_Enabled                    = jCheckBox_DeleteLog.isEnabled();
        
        //PSF uninportant        
        s.jLabel_Accuracy_Enabled              = jLabel_Accuracy.isEnabled();
        s.jComboBox_Accuracy_Enabled           = jComboBox_Accuracy.isEnabled();
        s.jTextField_RI_Oil_Enabled            = jTextField_RI_Oil.isEnabled();
        s.jTextField_RI_Sample_GL_Enabled      = jTextField_RI_Sample_GL.isEnabled();
        s.jTextField_RI_Sample0_VRIGL_Enabled  = jTextField_RI_Sample0_VRIGL.isEnabled();
        s.jTextField_RI_SampleZ_VRIGL_Enabled  = jTextField_RI_SampleZ_VRIGL.isEnabled();
        s.jTextField_RI_Sample_TV_Enabled      = jTextField_RI_Sample_TV.isEnabled();
        
        //Wavelength unimportant
        s.jLabel_Wave_RIOil_Enabled           = jLabel_Wave_RIOil.isEnabled();
        s.jLabel_Wave_RISample_Enabled        = jLabel_Wave_RISample.isEnabled();
        s.jLabel_Wave_RISample0_Enabled        = jLabel_Wave_RISample0.isEnabled();
        s.jLabel_Wave_RISampleZ_Enabled        = jLabel_Wave_RISampleZ.isEnabled();
        s.jTextField_Wave_RI_Oil_Enabled      = jTextField_Wave_RIOil.isEnabled();
        s.jTextField_Wave_RI_Sample_Enabled   = jTextField_Wave_RISample.isEnabled();
        s.jTextField_Wave_RI_SampleZ_Enabled  = jTextField_Wave_RISampleZ.isEnabled();
        
        s.jLabel_Wavelength_Enabled           = jLabel_Wavelength.isEnabled();
        s.jLabel_OilRI_Enabled                = jLabel_OilRI.isEnabled();
        s.jLabel_SampleRI_Enabled             = jLabel_SampleRI.isEnabled();
        s.jLabel_Sample0RI_Enabled            = jLabel_Sample0RI.isEnabled();
        s.jLabel_SampleZRI_Enabled            = jLabel_SampleZRI.isEnabled();
        
        s.channel1_Enabled               = jLabel_Channel1.isEnabled();
        s.channel2_Enabled               = jLabel_Channel2.isEnabled();
        s.channel3_Enabled               = jLabel_Channel3.isEnabled();
        s.channel4_Enabled               = jLabel_Channel4.isEnabled();
        s.channel5_Enabled               = jLabel_Channel5.isEnabled();
        s.channel6_Enabled               = jLabel_Channel6.isEnabled();
        s.channel7_Enabled               = jLabel_Channel7.isEnabled();
        s.channel8_Enabled               = jLabel_Channel8.isEnabled();  
    
        s.lambda1_Enabled                = jTextField_Wavelength1.isEnabled();
        s.lambda2_Enabled                = jTextField_Wavelength2.isEnabled();
        s.lambda3_Enabled                = jTextField_Wavelength3.isEnabled();
        s.lambda4_Enabled                = jTextField_Wavelength4.isEnabled();
        s.lambda5_Enabled                = jTextField_Wavelength5.isEnabled();
        s.lambda6_Enabled                = jTextField_Wavelength6.isEnabled();
        s.lambda7_Enabled                = jTextField_Wavelength7.isEnabled();
        s.lambda8_Enabled                = jTextField_Wavelength8.isEnabled(); 

        s.oil_RI1_Enabled                = jTextField_OilRI1.isEnabled();
        s.oil_RI2_Enabled                = jTextField_OilRI2.isEnabled();
        s.oil_RI3_Enabled                = jTextField_OilRI3.isEnabled();
        s.oil_RI4_Enabled                = jTextField_OilRI4.isEnabled();
        s.oil_RI5_Enabled                = jTextField_OilRI5.isEnabled();
        s.oil_RI6_Enabled                = jTextField_OilRI6.isEnabled();
        s.oil_RI7_Enabled                = jTextField_OilRI7.isEnabled();
        s.oil_RI8_Enabled                = jTextField_OilRI8.isEnabled(); 

        s.sample_RI1_Enabled             = jTextField_SampleRI1.isEnabled();
        s.sample_RI2_Enabled             = jTextField_SampleRI2.isEnabled();
        s.sample_RI3_Enabled             = jTextField_SampleRI3.isEnabled();
        s.sample_RI4_Enabled             = jTextField_SampleRI4.isEnabled();
        s.sample_RI5_Enabled             = jTextField_SampleRI5.isEnabled();
        s.sample_RI6_Enabled             = jTextField_SampleRI6.isEnabled();
        s.sample_RI7_Enabled             = jTextField_SampleRI7.isEnabled();
        s.sample_RI8_Enabled             = jTextField_SampleRI8.isEnabled(); 

        s.sampleZ_RI1_Enabled            = jTextField_SampleZRI1.isEnabled();
        s.sampleZ_RI2_Enabled            = jTextField_SampleZRI2.isEnabled();
        s.sampleZ_RI3_Enabled            = jTextField_SampleZRI3.isEnabled();
        s.sampleZ_RI4_Enabled            = jTextField_SampleZRI4.isEnabled();
        s.sampleZ_RI5_Enabled            = jTextField_SampleZRI5.isEnabled();
        s.sampleZ_RI6_Enabled            = jTextField_SampleZRI6.isEnabled();
        s.sampleZ_RI7_Enabled            = jTextField_SampleZRI7.isEnabled();
        s.sampleZ_RI8_Enabled            = jTextField_SampleZRI8.isEnabled();  
    
        s._BF1_Enabled                   = jCheckBox_Brightfield1.isEnabled();
        s._BF2_Enabled                   = jCheckBox_Brightfield2.isEnabled();
        s._BF3_Enabled                   = jCheckBox_Brightfield3.isEnabled();
        s._BF4_Enabled                   = jCheckBox_Brightfield4.isEnabled();
        s._BF5_Enabled                   = jCheckBox_Brightfield5.isEnabled();
        s._BF6_Enabled                   = jCheckBox_Brightfield6.isEnabled();
        s._BF7_Enabled                   = jCheckBox_Brightfield7.isEnabled();
        s._BF8_Enabled                   = jCheckBox_Brightfield8.isEnabled();
        
            //Deconvolution unimportant
        s.residu_Enabled                 = jTextField_Residu.isEnabled();
    } 
    
    private static void loadSettings (Settings s){
        //IO
        jTextField_InputPath.setText(s.inputPath);
        jCheckBox_OutputPath.setSelected(s.outputPath_Selected);
        jTextField_OutputPath.setText(s.outputPath);
        jCheckBox_IntermediatePath.setSelected(s.intermediatePath_Selected);
        jTextField_IntermediatePath.setText(s.intermediatePath);
        jCheckBox_LogPath.setSelected(s.logPath_Selected );
        jTextField_LogPath.setText(s.logPath );
        jCheckBox_Delete.setSelected(s.delete);
        jCheckBox_DeletePSF.setSelected(s.deletePSF);
        jCheckBox_DeleteLog.setSelected(s.deleteLog);
        
         //PSF
            jComboBox_PSFCalculateOrNot.setSelectedIndex(s._PSF_calc); // 0 - once; 1 - all; 2 - load
            jTabbedPane_PSFCalculateOrNot.setSelectedIndex(s._PSF_calc/2);
        jTextField_NA.setText(String.valueOf(s._NA));
        jComboBox_Accuracy.setSelectedItem(s.accuracy);
        jComboBox_Bit.setSelectedItem(s.bit); 
        jComboBox_PSFMethod.setSelectedIndex(s._PSFTab); // 0 - GL; 1 - RW; 2 - VRIGL; 3 - BW; 4 - TV
            jTextField_Working_GL.setText(String.valueOf(s._WD));
            jTextField_Working_VRIGL.setText(String.valueOf(s._WD));
            jTextField_Working_TV.setText(String.valueOf(s._WD));
                jTextField_Position_GL.setText(String.valueOf(s.zPos));
                jTextField_Position_VRIGL.setText(String.valueOf(s.zPos));
                jTextField_Position_TV.setText(String.valueOf(s.zPos));
        jComboBox_RIVariation.setSelectedItem(s._RIvariation);
        jTextField_PSFPath.setText(s._PSFPath );
        
    
        //Wavelength
        jComboBox_ChannelNumber.setSelectedItem(String.valueOf(s.channels));
            jTextField_Wave_RIOil.setText(String.valueOf(s._RIoil));
            jTextField_RI_Oil.setText(String.valueOf(s._RIoil));
                jCheckBox_Wave_DifferentRIOil.setSelected(s._RIoil_different);
                jCheckBox_DifferentRIOil.setSelected(s._RIoil_different);
            jTextField_Wave_RISample.setText(String.valueOf(s._RIsample));
            jTextField_RI_Sample_GL.setText(String.valueOf(s._RIsample));
            jTextField_RI_Sample0_VRIGL.setText(String.valueOf(s._RIsample));
            jTextField_RI_Sample_TV.setText(String.valueOf(s._RIsample));
                jCheckBox_Wave_DifferentRISample.setSelected(s._RIsample_different);
                jCheckBox_DifferentRI_Sample_GL.setSelected(s._RIsample_different);
                jCheckBox_DifferentRI_Sample0_VRIGL.setSelected(s._RIsample_different);
                jCheckBox_DifferentRI_Sample_TV.setSelected(s._RIsample_different);
            jTextField_Wave_RISampleZ.setText(String.valueOf(s._RIsampleZ));
            jTextField_RI_SampleZ_VRIGL.setText(String.valueOf(s._RIsampleZ));
                jCheckBox_Wave_DifferentRISampleZ.setSelected(s._RIsampleZ_different);
                jCheckBox_DifferentRI_SampleZ_VRIGL.setSelected(s._RIsampleZ_different);
        
        jTextField_Wavelength1.setText(String.valueOf(s.lambda1));
        jTextField_Wavelength2.setText(String.valueOf(s.lambda2));
        jTextField_Wavelength3.setText(String.valueOf(s.lambda3));
        jTextField_Wavelength4.setText(String.valueOf(s.lambda4));
        jTextField_Wavelength5.setText(String.valueOf(s.lambda5));
        jTextField_Wavelength6.setText(String.valueOf(s.lambda6));
        jTextField_Wavelength7.setText(String.valueOf(s.lambda7));
        jTextField_Wavelength8.setText(String.valueOf(s.lambda8));
         
        jTextField_OilRI1.setText(String.valueOf(s.oil_RI1));
        jTextField_OilRI2.setText(String.valueOf(s.oil_RI2));
        jTextField_OilRI3.setText(String.valueOf(s.oil_RI3));
        jTextField_OilRI4.setText(String.valueOf(s.oil_RI4));
        jTextField_OilRI5.setText(String.valueOf(s.oil_RI5));
        jTextField_OilRI6.setText(String.valueOf(s.oil_RI6));
        jTextField_OilRI7.setText(String.valueOf(s.oil_RI7));
        jTextField_OilRI8.setText(String.valueOf(s.oil_RI8));
        
        jTextField_SampleRI1.setText(String.valueOf(s.sample_RI1));
        jTextField_SampleRI2.setText(String.valueOf(s.sample_RI2));
        jTextField_SampleRI3.setText(String.valueOf(s.sample_RI3));
        jTextField_SampleRI4.setText(String.valueOf(s.sample_RI4));
        jTextField_SampleRI5.setText(String.valueOf(s.sample_RI5));
        jTextField_SampleRI6.setText(String.valueOf(s.sample_RI6));
        jTextField_SampleRI7.setText(String.valueOf(s.sample_RI7));
        jTextField_SampleRI8.setText(String.valueOf(s.sample_RI8));

        jTextField_SampleZRI1.setText(String.valueOf(s.sampleZ_RI1));
        jTextField_SampleZRI2.setText(String.valueOf(s.sampleZ_RI2));
        jTextField_SampleZRI3.setText(String.valueOf(s.sampleZ_RI3));
        jTextField_SampleZRI4.setText(String.valueOf(s.sampleZ_RI4));
        jTextField_SampleZRI5.setText(String.valueOf(s.sampleZ_RI5));
        jTextField_SampleZRI6.setText(String.valueOf(s.sampleZ_RI6));
        jTextField_SampleZRI7.setText(String.valueOf(s.sampleZ_RI7));
        jTextField_SampleZRI8.setText(String.valueOf(s.sampleZ_RI8));
        
        jCheckBox_Brightfield1.setSelected(s._BF1);
        jCheckBox_Brightfield2.setSelected(s._BF2);
        jCheckBox_Brightfield3.setSelected(s._BF3);
        jCheckBox_Brightfield4.setSelected(s._BF4);
        jCheckBox_Brightfield5.setSelected(s._BF5);
        jCheckBox_Brightfield6.setSelected(s._BF6);
        jCheckBox_Brightfield7.setSelected(s._BF7);
        jCheckBox_Brightfield8.setSelected(s._BF8);
        
        //Deconvolution
            jComboBox_DeconvolutionAlgorithm.setSelectedIndex(s.deconvTab);
            jTabbedPane_DeconvolutionAlgorithm.setSelectedIndex(s.deconvTab);
        setNIterations(s.nIterations);
        setStep(s.step);
        setReg ("",(int)(Math.log10(s.reg)*1000));
        setWavelets(s.wevelets);
        setScale(s.scale);
        jComboBox_Constraint.setSelectedItem(s.constraint);
        jCheckBox_Residu.setSelected(s.residuSelected);
        jTextField_Residu.setText(String.valueOf(s.residu));
        jComboBox_FTT.setSelectedItem(s.fft);
        jComboBox_Epsilon.setSelectedItem(s.epsilon);
        jComboBox_ApodizationXY.setSelectedItem(s.apodizationXY);
        jComboBox_ApodizationZ.setSelectedItem(s.apodizationZ);
        jSpinner_PaddingExtensionXY.setValue(s.paddingExtensionXY);
        jSpinner_PaddingExtensionZ.setValue(s.paddingExtensionZ);
        jComboBox_PaddingConstraintXY.setSelectedItem(s.paddingConstrainXY);
        jComboBox_PaddingConstraintZ.setSelectedItem(s.paddingConstrainZ);
        jComboBox_PSFNormalization.setSelectedItem(s._PSFnorm);                  
    
        //IO unimportant
        jTextField_OutputPath.setEnabled(s.outputPath_Enabled);
        jButton_OutputPath.setEnabled(s.jButton_OutputPath_Enabled);
        
        jTextField_IntermediatePath.setEnabled(s.intermediatePath_Enabled);
        jButton_IntermediatePath.setEnabled(s.jButton_IntermediatePath_Enabled);
        
        jTextField_LogPath.setEnabled(s.logPath_Enabled);
        jButton_LogPath.setEnabled(s.jButton_LogPath_Enabled);
       
        jCheckBox_DeletePSF.setEnabled(s.deletePSF_Enabled);
        jCheckBox_DeleteLog.setEnabled(s.deleteLog_Enabled);
        
        //PSF uninportant        
        jLabel_Accuracy.setEnabled(s.jLabel_Accuracy_Enabled);
        jComboBox_Accuracy.setEnabled(s.jComboBox_Accuracy_Enabled);
        jTextField_RI_Oil.setEnabled(s.jTextField_RI_Oil_Enabled);
        jTextField_RI_Sample_GL.setEnabled(s.jTextField_RI_Sample_GL_Enabled);
        jTextField_RI_Sample0_VRIGL.setEnabled(s.jTextField_RI_Sample0_VRIGL_Enabled);
        jTextField_RI_SampleZ_VRIGL.setEnabled(s.jTextField_RI_SampleZ_VRIGL_Enabled);
        jTextField_RI_Sample_TV.setEnabled(s.jTextField_RI_Sample_TV_Enabled);
         
        //Wavelength unimportant
        
        jLabel_Wave_RIOil.setEnabled(s.jLabel_Wave_RIOil_Enabled);
        jLabel_Wave_RISample.setEnabled(s.jLabel_Wave_RISample_Enabled);
        jLabel_Wave_RISample0.setEnabled(s.jLabel_Wave_RISample0_Enabled);
        jLabel_Wave_RISampleZ.setEnabled(s.jLabel_Wave_RISampleZ_Enabled);
        jTextField_Wave_RIOil.setEnabled(s.jTextField_Wave_RI_Oil_Enabled);
        jTextField_Wave_RISample.setEnabled(s.jTextField_Wave_RI_Sample_Enabled);
        jTextField_Wave_RISampleZ.setEnabled(s.jTextField_Wave_RI_SampleZ_Enabled);
        
        jLabel_Wavelength.setEnabled(s.jLabel_Wavelength_Enabled);
        jLabel_OilRI.setEnabled(s.jLabel_OilRI_Enabled);
        jLabel_SampleRI.setEnabled(s.jLabel_SampleRI_Enabled);
        jLabel_Sample0RI.setEnabled(s.jLabel_Sample0RI_Enabled);
        jLabel_SampleZRI.setEnabled(s.jLabel_SampleZRI_Enabled);
        
        jLabel_Channel1.setEnabled(s.channel1_Enabled);
        jLabel_Channel2.setEnabled(s.channel2_Enabled);
        jLabel_Channel3.setEnabled(s.channel3_Enabled);
        jLabel_Channel4.setEnabled(s.channel4_Enabled);
        jLabel_Channel5.setEnabled(s.channel5_Enabled);
        jLabel_Channel6.setEnabled(s.channel6_Enabled);
        jLabel_Channel7.setEnabled(s.channel7_Enabled);
        jLabel_Channel8.setEnabled(s.channel8_Enabled);
        
        jTextField_Wavelength1.setEnabled(s.lambda1_Enabled);
        jTextField_Wavelength2.setEnabled(s.lambda2_Enabled);
        jTextField_Wavelength3.setEnabled(s.lambda3_Enabled);
        jTextField_Wavelength4.setEnabled(s.lambda4_Enabled);
        jTextField_Wavelength5.setEnabled(s.lambda5_Enabled);
        jTextField_Wavelength6.setEnabled(s.lambda6_Enabled);
        jTextField_Wavelength7.setEnabled(s.lambda7_Enabled);
        jTextField_Wavelength8.setEnabled(s.lambda8_Enabled);
        
        jTextField_OilRI1.setEnabled(s.oil_RI1_Enabled);
        jTextField_OilRI2.setEnabled(s.oil_RI2_Enabled);
        jTextField_OilRI3.setEnabled(s.oil_RI3_Enabled);
        jTextField_OilRI4.setEnabled(s.oil_RI4_Enabled);
        jTextField_OilRI5.setEnabled(s.oil_RI5_Enabled);
        jTextField_OilRI6.setEnabled(s.oil_RI6_Enabled);
        jTextField_OilRI7.setEnabled(s.oil_RI7_Enabled);
        jTextField_OilRI8.setEnabled(s.oil_RI8_Enabled);
       
        jTextField_SampleRI1.setEnabled(s.sample_RI1_Enabled);
        jTextField_SampleRI2.setEnabled(s.sample_RI2_Enabled);
        jTextField_SampleRI3.setEnabled(s.sample_RI3_Enabled);
        jTextField_SampleRI4.setEnabled(s.sample_RI4_Enabled);
        jTextField_SampleRI5.setEnabled(s.sample_RI5_Enabled);
        jTextField_SampleRI6.setEnabled(s.sample_RI6_Enabled);
        jTextField_SampleRI7.setEnabled(s.sample_RI7_Enabled);
        jTextField_SampleRI8.setEnabled(s.sample_RI8_Enabled);
       
        jTextField_SampleZRI1.setEnabled(s.sampleZ_RI1_Enabled);
        jTextField_SampleZRI2.setEnabled(s.sampleZ_RI2_Enabled);
        jTextField_SampleZRI3.setEnabled(s.sampleZ_RI3_Enabled);
        jTextField_SampleZRI4.setEnabled(s.sampleZ_RI4_Enabled);
        jTextField_SampleZRI5.setEnabled(s.sampleZ_RI5_Enabled);
        jTextField_SampleZRI6.setEnabled(s.sampleZ_RI6_Enabled);
        jTextField_SampleZRI7.setEnabled(s.sampleZ_RI7_Enabled);
        jTextField_SampleZRI8.setEnabled(s.sampleZ_RI8_Enabled);
       
        jCheckBox_Brightfield1.setEnabled(s._BF1_Enabled);
        jCheckBox_Brightfield2.setEnabled(s._BF2_Enabled);
        jCheckBox_Brightfield3.setEnabled(s._BF3_Enabled);
        jCheckBox_Brightfield4.setEnabled(s._BF4_Enabled);
        jCheckBox_Brightfield5.setEnabled(s._BF5_Enabled);
        jCheckBox_Brightfield6.setEnabled(s._BF6_Enabled);
        jCheckBox_Brightfield7.setEnabled(s._BF7_Enabled);
        jCheckBox_Brightfield8.setEnabled(s._BF8_Enabled);
         
        //Deconvolution unimportant
        jTextField_Residu.setEnabled(s.residu_Enabled);
    } 
    /**
     * Creates new form Menu
     */
    public Menu() {
        Locale.setDefault(new Locale("en", "US"));
        settings = new Settings();
        listPSF = new ArrayList<String>();
        listDeconvolution = new ArrayList<String>();
        
        try {
            extensions = IO.loadExtensions();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        regLabels = new Hashtable<>();
        regLabels.put(-18000, new JLabel("Off"));
        regLabels.put(-12000, new JLabel("Low"));
        regLabels.put(-6000, new JLabel("1E-6"));
        regLabels.put(0, new JLabel("1.0"));
        regLabels.put(9000, new JLabel("High"));
        
        initComponents(); 
                    
        try {
            if(new File(".\\BDsettings.dat").exists()){
                IO.loadSettings(".\\BDsettings.dat", settings);
                loadSettings(settings);
            }else{

                readSettings(settings);
                IO.saveSettings(".\\BDsettings.dat", settings);

            }                
        }catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPanel_Main = new javax.swing.JTabbedPane();
        jPanel_IOPaths = new javax.swing.JPanel();
        jPanelIO = new javax.swing.JPanel();
        jTextField_InputPath = new javax.swing.JTextField();
        jButton_InputPath = new javax.swing.JButton();
        jLabel_InputPath = new javax.swing.JLabel();
        jLabel_OutputPath = new javax.swing.JLabel();
        jTextField_OutputPath = new javax.swing.JTextField();
        jButton_OutputPath = new javax.swing.JButton();
        jCheckBox_OutputPath = new javax.swing.JCheckBox();
        jButton_LogPath = new javax.swing.JButton();
        jTextField_LogPath = new javax.swing.JTextField();
        jCheckBox_LogPath = new javax.swing.JCheckBox();
        jLabel_LogPath = new javax.swing.JLabel();
        jCheckBox_Delete = new javax.swing.JCheckBox();
        jCheckBox_DeletePSF = new javax.swing.JCheckBox();
        jCheckBox_DeleteLog = new javax.swing.JCheckBox();
        jLabel_IntermediatePath = new javax.swing.JLabel();
        jCheckBox_IntermediatePath = new javax.swing.JCheckBox();
        jTextField_IntermediatePath = new javax.swing.JTextField();
        jButton_IntermediatePath = new javax.swing.JButton();
        jPanel_PSF = new javax.swing.JPanel();
        jPanel_PSFBasic = new javax.swing.JPanel();
        jComboBox_PSFCalculateOrNot = new javax.swing.JComboBox<>();
        jTabbedPane_PSFCalculateOrNot = new javax.swing.JTabbedPane();
        jPanel_CalculatePSF = new javax.swing.JPanel();
        jLabel_PSFModel = new javax.swing.JLabel();
        jComboBox_PSFMethod = new javax.swing.JComboBox<>();
        jTabbedPane_PSFMethod = new javax.swing.JTabbedPane();
        jPanel_PSF_RI = new javax.swing.JPanel();
        jLabel_Working_GL = new javax.swing.JLabel();
        jTextField_Working_GL = new javax.swing.JTextField();
        jLabel_WorkingUM_GL = new javax.swing.JLabel();
        jLabel_Position_GL = new javax.swing.JLabel();
        jTextField_Position_GL = new javax.swing.JTextField();
        jLabel_PositionNM_GL = new javax.swing.JLabel();
        jLabel_RI_Sample_GL = new javax.swing.JLabel();
        jTextField_RI_Sample_GL = new javax.swing.JTextField();
        jCheckBox_DifferentRI_Sample_GL = new javax.swing.JCheckBox();
        jPanel_PSF_RW = new javax.swing.JPanel();
        jLabel_RW = new javax.swing.JLabel();
        jPanel_PSF_VRIGL = new javax.swing.JPanel();
        jLabel_Working_VRIGL = new javax.swing.JLabel();
        jTextField_Working_VRIGL = new javax.swing.JTextField();
        jLabel_WorkingUM_VRIGL = new javax.swing.JLabel();
        jLabel_Position_VRIGL = new javax.swing.JLabel();
        jTextField_Position_VRIGL = new javax.swing.JTextField();
        jLabel_PositionNM_VRIGL = new javax.swing.JLabel();
        jLabel_RI_Sample0_VRIGL = new javax.swing.JLabel();
        jTextField_RI_Sample0_VRIGL = new javax.swing.JTextField();
        jCheckBox_DifferentRI_Sample0_VRIGL = new javax.swing.JCheckBox();
        jLabel_RI_SampleZ_VRIGL = new javax.swing.JLabel();
        jTextField_RI_SampleZ_VRIGL = new javax.swing.JTextField();
        jCheckBox_DifferentRI_SampleZ_VRIGL = new javax.swing.JCheckBox();
        jLabel_RI_Variation_VRIGL = new javax.swing.JLabel();
        jComboBox_RIVariation = new javax.swing.JComboBox<>();
        jPanel_PSF_BW = new javax.swing.JPanel();
        jLabel_BW = new javax.swing.JLabel();
        jPanel_PSF_TV = new javax.swing.JPanel();
        jLabel_Working_TV = new javax.swing.JLabel();
        jTextField_Working_TV = new javax.swing.JTextField();
        jLabel_WorkingUM_TV = new javax.swing.JLabel();
        jLabel_Position_TV = new javax.swing.JLabel();
        jTextField_Position_TV = new javax.swing.JTextField();
        jLabel_PositionNM_TV = new javax.swing.JLabel();
        jLabel_RI_Sample_TV = new javax.swing.JLabel();
        jTextField_RI_Sample_TV = new javax.swing.JTextField();
        jCheckBox_DifferentRI_Sample_TV = new javax.swing.JCheckBox();
        jLabel_PSFBasicParameters = new javax.swing.JLabel();
        jLabel_NA = new javax.swing.JLabel();
        jTextField_NA = new javax.swing.JTextField();
        jTextField_RI_Oil = new javax.swing.JTextField();
        jLabel_RI = new javax.swing.JLabel();
        jCheckBox_DifferentRIOil = new javax.swing.JCheckBox();
        jSeparatorPSF2 = new javax.swing.JSeparator();
        jLabel_Accuracy = new javax.swing.JLabel();
        jComboBox_Accuracy = new javax.swing.JComboBox<>();
        jLabel_Bit = new javax.swing.JLabel();
        jComboBox_Bit = new javax.swing.JComboBox<>();
        jPanel_LoadPSF = new javax.swing.JPanel();
        jTextField_PSFPath = new javax.swing.JTextField();
        jLabel_PSFPath = new javax.swing.JLabel();
        jButton_PSFPath = new javax.swing.JButton();
        jSeparator_PSF1 = new javax.swing.JSeparator();
        jPanel_Wavelengths = new javax.swing.JPanel();
        jPanel_Wave = new javax.swing.JPanel();
        jLabel_ChannelNumber = new javax.swing.JLabel();
        jComboBox_ChannelNumber = new javax.swing.JComboBox<>();
        jLabel_Wave_RIOil = new javax.swing.JLabel();
        jLabel_Wave_RISample = new javax.swing.JLabel();
        jLabel_Wave_RISample0 = new javax.swing.JLabel();
        jLabel_Wave_RISampleZ = new javax.swing.JLabel();
        jTextField_Wave_RIOil = new javax.swing.JTextField();
        jTextField_Wave_RISample = new javax.swing.JTextField();
        jTextField_Wave_RISampleZ = new javax.swing.JTextField();
        jCheckBox_Wave_DifferentRIOil = new javax.swing.JCheckBox();
        jCheckBox_Wave_DifferentRISample = new javax.swing.JCheckBox();
        jCheckBox_Wave_DifferentRISampleZ = new javax.swing.JCheckBox();
        jLabel_Channel1 = new javax.swing.JLabel();
        jLabel_Channel2 = new javax.swing.JLabel();
        jLabel_Channel3 = new javax.swing.JLabel();
        jLabel_Channel4 = new javax.swing.JLabel();
        jLabel_Channel5 = new javax.swing.JLabel();
        jLabel_Channel6 = new javax.swing.JLabel();
        jLabel_Channel7 = new javax.swing.JLabel();
        jLabel_Channel8 = new javax.swing.JLabel();
        jLabel_Wavelength = new javax.swing.JLabel();
        jTextField_Wavelength1 = new javax.swing.JTextField();
        jTextField_Wavelength2 = new javax.swing.JTextField();
        jTextField_Wavelength3 = new javax.swing.JTextField();
        jTextField_Wavelength4 = new javax.swing.JTextField();
        jTextField_Wavelength5 = new javax.swing.JTextField();
        jTextField_Wavelength6 = new javax.swing.JTextField();
        jTextField_Wavelength7 = new javax.swing.JTextField();
        jTextField_Wavelength8 = new javax.swing.JTextField();
        jLabel_OilRI = new javax.swing.JLabel();
        jTextField_OilRI1 = new javax.swing.JTextField();
        jTextField_OilRI2 = new javax.swing.JTextField();
        jTextField_OilRI3 = new javax.swing.JTextField();
        jTextField_OilRI4 = new javax.swing.JTextField();
        jTextField_OilRI5 = new javax.swing.JTextField();
        jTextField_OilRI6 = new javax.swing.JTextField();
        jTextField_OilRI7 = new javax.swing.JTextField();
        jTextField_OilRI8 = new javax.swing.JTextField();
        jLabel_SampleRI = new javax.swing.JLabel();
        jLabel_Sample0RI = new javax.swing.JLabel();
        jTextField_SampleRI1 = new javax.swing.JTextField();
        jTextField_SampleRI2 = new javax.swing.JTextField();
        jTextField_SampleRI3 = new javax.swing.JTextField();
        jTextField_SampleRI4 = new javax.swing.JTextField();
        jTextField_SampleRI5 = new javax.swing.JTextField();
        jTextField_SampleRI6 = new javax.swing.JTextField();
        jTextField_SampleRI7 = new javax.swing.JTextField();
        jTextField_SampleRI8 = new javax.swing.JTextField();
        jLabel_SampleZRI = new javax.swing.JLabel();
        jTextField_SampleZRI1 = new javax.swing.JTextField();
        jTextField_SampleZRI2 = new javax.swing.JTextField();
        jTextField_SampleZRI3 = new javax.swing.JTextField();
        jTextField_SampleZRI4 = new javax.swing.JTextField();
        jTextField_SampleZRI5 = new javax.swing.JTextField();
        jTextField_SampleZRI6 = new javax.swing.JTextField();
        jTextField_SampleZRI7 = new javax.swing.JTextField();
        jTextField_SampleZRI8 = new javax.swing.JTextField();
        jLabel_Brightfield = new javax.swing.JLabel();
        jCheckBox_Brightfield1 = new javax.swing.JCheckBox();
        jCheckBox_Brightfield2 = new javax.swing.JCheckBox();
        jCheckBox_Brightfield3 = new javax.swing.JCheckBox();
        jCheckBox_Brightfield4 = new javax.swing.JCheckBox();
        jCheckBox_Brightfield5 = new javax.swing.JCheckBox();
        jCheckBox_Brightfield6 = new javax.swing.JCheckBox();
        jCheckBox_Brightfield7 = new javax.swing.JCheckBox();
        jCheckBox_Brightfield8 = new javax.swing.JCheckBox();
        jPanel_Deconvolution = new javax.swing.JPanel();
        jPanel_DeconvolutionAlgorithm = new javax.swing.JPanel();
        jComboBox_DeconvolutionAlgorithm = new javax.swing.JComboBox<>();
        jTabbedPane_DeconvolutionAlgorithm = new javax.swing.JTabbedPane();
        jPanel_RIF = new javax.swing.JPanel();
        jLabel_RIF = new javax.swing.JLabel();
        jSlider_RIF_Reg = new javax.swing.JSlider();
        jLabel_RIF_Reg = new javax.swing.JLabel();
        jTextField_RIF_Reg = new javax.swing.JTextField();
        jPanel_TRIF = new javax.swing.JPanel();
        jLabel_TRIF = new javax.swing.JLabel();
        jSlider_TRIF_Reg = new javax.swing.JSlider();
        jLabel_TRIF_Reg = new javax.swing.JLabel();
        jTextField_TRIF_Reg = new javax.swing.JTextField();
        jPanel_NIF = new javax.swing.JPanel();
        jLabel_NIF = new javax.swing.JLabel();
        jLabel_NIF_NoParameters = new javax.swing.JLabel();
        jPanel_FISTA = new javax.swing.JPanel();
        jLabel_FISTA = new javax.swing.JLabel();
        jSlider_FISTA_Reg = new javax.swing.JSlider();
        jLabel_FISTA_Reg = new javax.swing.JLabel();
        jTextField_FISTA_Reg = new javax.swing.JTextField();
        jLabel_FISTA_Iterations = new javax.swing.JLabel();
        jSpinner_FISTA_Iterations = new javax.swing.JSpinner();
        jSpinner_FISTA_Step = new javax.swing.JSpinner();
        jLabel_FISTA_Step = new javax.swing.JLabel();
        jLabel_FISTA_Wavelets = new javax.swing.JLabel();
        jLabel_FISTA_Scale = new javax.swing.JLabel();
        jComboBox_FISTA_Wavelets = new javax.swing.JComboBox<>();
        jComboBox_FISTA_Scale = new javax.swing.JComboBox<>();
        jPanel_ISTA = new javax.swing.JPanel();
        jLabel_ISTA = new javax.swing.JLabel();
        jSlider_ISTA_Reg = new javax.swing.JSlider();
        jLabel_ISTA_Reg = new javax.swing.JLabel();
        jTextField_ISTA_Reg = new javax.swing.JTextField();
        jLabel_ISTA_Iterations = new javax.swing.JLabel();
        jSpinner_ISTA_Iterations = new javax.swing.JSpinner();
        jSpinner_ISTA_Step = new javax.swing.JSpinner();
        jLabel_ISTA_Step = new javax.swing.JLabel();
        jLabel_ISTA_Wavelets = new javax.swing.JLabel();
        jLabel_ISTA_Scale = new javax.swing.JLabel();
        jComboBox_ISTA_Wavelets = new javax.swing.JComboBox<>();
        jComboBox_ISTA_Scale = new javax.swing.JComboBox<>();
        jPanel_LW = new javax.swing.JPanel();
        jLabel_LW = new javax.swing.JLabel();
        jLabel_LW_Iterations = new javax.swing.JLabel();
        jSpinner_LW_Iterations = new javax.swing.JSpinner();
        jSpinner_LW_Step = new javax.swing.JSpinner();
        jLabel_LW_Step = new javax.swing.JLabel();
        jPanel_NNLS = new javax.swing.JPanel();
        jLabel_NNLS = new javax.swing.JLabel();
        jLabel_NNLS_Iterations = new javax.swing.JLabel();
        jSpinner_NNLS_Iterations = new javax.swing.JSpinner();
        jSpinner_NNLS_Step = new javax.swing.JSpinner();
        jLabel_NNLS_Step = new javax.swing.JLabel();
        jPanel_BVLS = new javax.swing.JPanel();
        jLabel_BVLS = new javax.swing.JLabel();
        jLabel_BVLS_Iterations = new javax.swing.JLabel();
        jSpinner_BVLS_Iterations = new javax.swing.JSpinner();
        jSpinner_BVLS_Step = new javax.swing.JSpinner();
        jLabel_BVLS_Step = new javax.swing.JLabel();
        jPanel_RL = new javax.swing.JPanel();
        jLabel_RL = new javax.swing.JLabel();
        jLabel_RL_Iterations = new javax.swing.JLabel();
        jSpinner_RL_Iterations = new javax.swing.JSpinner();
        jPanel_RLTV = new javax.swing.JPanel();
        jLabel_RLTV = new javax.swing.JLabel();
        jSlider_RLTV_Reg = new javax.swing.JSlider();
        jLabel_RLTV_Reg = new javax.swing.JLabel();
        jTextField_RLTV_Reg = new javax.swing.JTextField();
        jLabel_RLTV_Iterations = new javax.swing.JLabel();
        jSpinner_RLTV_Iterations = new javax.swing.JSpinner();
        jPanel_TM = new javax.swing.JPanel();
        jLabel_TM = new javax.swing.JLabel();
        jSlider_TM_Reg = new javax.swing.JSlider();
        jLabel_TM_Reg = new javax.swing.JLabel();
        jTextField_TM_Reg = new javax.swing.JTextField();
        jLabel_TM_Iterations = new javax.swing.JLabel();
        jSpinner_TM_Iterations = new javax.swing.JSpinner();
        jSpinner_TM_Step = new javax.swing.JSpinner();
        jLabel_TM_Step = new javax.swing.JLabel();
        jPanel_ICTM = new javax.swing.JPanel();
        jLabel_ICTM = new javax.swing.JLabel();
        jSlider_ICTM_Reg = new javax.swing.JSlider();
        jLabel_ICTM_Reg = new javax.swing.JLabel();
        jTextField_ICTM_Reg = new javax.swing.JTextField();
        jLabel_ICTM_Iterations = new javax.swing.JLabel();
        jSpinner_ICTM_Iterations = new javax.swing.JSpinner();
        jSpinner_ICTM_Step = new javax.swing.JSpinner();
        jLabel_ICTM_Step = new javax.swing.JLabel();
        jPanel_VC = new javax.swing.JPanel();
        jLabel_VC = new javax.swing.JLabel();
        jLabel_VC_Iterations = new javax.swing.JLabel();
        jSpinner_VC_Iterations = new javax.swing.JSpinner();
        jSpinner_VC_Step = new javax.swing.JSpinner();
        jLabel_VC_Step = new javax.swing.JLabel();
        jPanel_DIV = new javax.swing.JPanel();
        jLabel_DIV = new javax.swing.JLabel();
        jLabel_NIF_NoParameters1 = new javax.swing.JLabel();
        jSeparator_Deconvolution1 = new javax.swing.JSeparator();
        jLabel_Advanced = new javax.swing.JLabel();
        jSeparator_Deconvolution2 = new javax.swing.JSeparator();
        jLabel_Controller = new javax.swing.JLabel();
        jLabel_Constraint = new javax.swing.JLabel();
        jComboBox_Constraint = new javax.swing.JComboBox<>();
        Residu = new javax.swing.JLabel();
        jCheckBox_Residu = new javax.swing.JCheckBox();
        jTextField_Residu = new javax.swing.JTextField();
        jLabel_Processing = new javax.swing.JLabel();
        jLabel_FFT = new javax.swing.JLabel();
        jComboBox_FTT = new javax.swing.JComboBox<>();
        jLabel_Epsilon = new javax.swing.JLabel();
        jComboBox_Epsilon = new javax.swing.JComboBox<>();
        jLabel_Preprocessing = new javax.swing.JLabel();
        jLabel_Image = new javax.swing.JLabel();
        jLabel_LateralXY = new javax.swing.JLabel();
        jLabel_AxialZ = new javax.swing.JLabel();
        jLabel_Apodization = new javax.swing.JLabel();
        jComboBox_ApodizationXY = new javax.swing.JComboBox<>();
        jComboBox_ApodizationZ = new javax.swing.JComboBox<>();
        jLabel_PaddingExtension = new javax.swing.JLabel();
        jSpinner_PaddingExtensionXY = new javax.swing.JSpinner();
        jSpinner_PaddingExtensionZ = new javax.swing.JSpinner();
        jLabel_PaddingConstraint = new javax.swing.JLabel();
        jComboBox_PaddingConstraintXY = new javax.swing.JComboBox<>();
        jComboBox_PaddingConstraintZ = new javax.swing.JComboBox<>();
        jLabel_PSFNormalization = new javax.swing.JLabel();
        jComboBox_PSFNormalization = new javax.swing.JComboBox<>();
        jButton_Save = new javax.swing.JButton();
        jButton_Load = new javax.swing.JButton();
        jButton_Run = new javax.swing.JButton();
        jPanel_Status0 = new javax.swing.JPanel();
        jPanel_Status1 = new javax.swing.JPanel();
        jPanel_Status2 = new javax.swing.JPanel();
        jPanel_Status3 = new javax.swing.JPanel();
        jButton_Info = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BatchDeconvolution");

        jTabbedPanel_Main.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPanel_MainStateChanged(evt);
            }
        });
        jTabbedPanel_Main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPanel_MainMouseClicked(evt);
            }
        });

        jPanelIO.setBorder(javax.swing.BorderFactory.createTitledBorder("Input/Output"));

        jTextField_InputPath.setText("User Directory");
        jTextField_InputPath.setText(System.getProperty("user.home"));
        jTextField_InputPath.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_InputPathKeyReleased(evt);
            }
        });

        jButton_InputPath.setText("Select");
        jButton_InputPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InputPathActionPerformed(evt);
            }
        });

        jLabel_InputPath.setText("Input path");

        jLabel_OutputPath.setText("Output path");

        jTextField_OutputPath.setText("User Directory");
        jTextField_OutputPath.setEnabled(false);
        jTextField_OutputPath.setText(System.getProperty("user.home")+"\\Output");

        jButton_OutputPath.setText("Select");
        jButton_OutputPath.setEnabled(false);
        jButton_OutputPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OutputPathActionPerformed(evt);
            }
        });

        jCheckBox_OutputPath.setSelected(true);
        jCheckBox_OutputPath.setText("within input folder");
        jCheckBox_OutputPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_OutputPathActionPerformed(evt);
            }
        });

        jButton_LogPath.setText("Select");
        jButton_LogPath.setEnabled(false);
        jButton_LogPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogPathActionPerformed(evt);
            }
        });

        jTextField_LogPath.setText("User Directory");
        jTextField_LogPath.setEnabled(false);
        jTextField_LogPath.setText(System.getProperty("user.home")+"\\Log");

        jCheckBox_LogPath.setSelected(true);
        jCheckBox_LogPath.setText("within input folder");
        jCheckBox_LogPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_LogPathActionPerformed(evt);
            }
        });

        jLabel_LogPath.setText("Log path");

        jCheckBox_Delete.setSelected(true);
        jCheckBox_Delete.setText("Delete intermediate files after finishing");
        jCheckBox_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DeleteActionPerformed(evt);
            }
        });

        jCheckBox_DeletePSF.setSelected(true);
        jCheckBox_DeletePSF.setText("including PSFs");

        jCheckBox_DeleteLog.setText("including intermediate Logs");

        jLabel_IntermediatePath.setText("Intermediate files folder");

        jCheckBox_IntermediatePath.setSelected(true);
        jCheckBox_IntermediatePath.setText("within input folder");
        jCheckBox_IntermediatePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_IntermediatePathActionPerformed(evt);
            }
        });

        jTextField_IntermediatePath.setText("User Directory");
        jTextField_IntermediatePath.setEnabled(false);
        jTextField_IntermediatePath.setText(System.getProperty("user.home")+"\\Intermediate");

        jButton_IntermediatePath.setText("Select");
        jButton_IntermediatePath.setEnabled(false);
        jButton_IntermediatePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IntermediatePathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIOLayout = new javax.swing.GroupLayout(jPanelIO);
        jPanelIO.setLayout(jPanelIOLayout);
        jPanelIOLayout.setHorizontalGroup(
            jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIOLayout.createSequentialGroup()
                .addComponent(jTextField_InputPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_InputPath))
            .addGroup(jPanelIOLayout.createSequentialGroup()
                .addComponent(jTextField_OutputPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_OutputPath))
            .addGroup(jPanelIOLayout.createSequentialGroup()
                .addComponent(jTextField_IntermediatePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_IntermediatePath))
            .addGroup(jPanelIOLayout.createSequentialGroup()
                .addComponent(jTextField_LogPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_LogPath))
            .addGroup(jPanelIOLayout.createSequentialGroup()
                .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_InputPath)
                    .addComponent(jCheckBox_Delete)
                    .addGroup(jPanelIOLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_DeletePSF)
                            .addComponent(jCheckBox_DeleteLog)))
                    .addGroup(jPanelIOLayout.createSequentialGroup()
                        .addComponent(jLabel_OutputPath, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_OutputPath))
                    .addGroup(jPanelIOLayout.createSequentialGroup()
                        .addComponent(jLabel_IntermediatePath, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_IntermediatePath))
                    .addGroup(jPanelIOLayout.createSequentialGroup()
                        .addComponent(jLabel_LogPath, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_LogPath)))
                .addGap(0, 286, Short.MAX_VALUE))
        );
        jPanelIOLayout.setVerticalGroup(
            jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_InputPath)
                .addGap(10, 10, 10)
                .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_InputPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_InputPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_OutputPath)
                    .addComponent(jCheckBox_OutputPath))
                .addGap(5, 5, 5)
                .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_OutputPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_OutputPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_IntermediatePath)
                    .addComponent(jCheckBox_IntermediatePath))
                .addGap(5, 5, 5)
                .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_IntermediatePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_IntermediatePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_LogPath)
                    .addComponent(jCheckBox_LogPath))
                .addGap(5, 5, 5)
                .addGroup(jPanelIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_LogPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_LogPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_DeletePSF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_DeleteLog)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_IOPathsLayout = new javax.swing.GroupLayout(jPanel_IOPaths);
        jPanel_IOPaths.setLayout(jPanel_IOPathsLayout);
        jPanel_IOPathsLayout.setHorizontalGroup(
            jPanel_IOPathsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelIO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_IOPathsLayout.setVerticalGroup(
            jPanel_IOPathsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_IOPathsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPanel_Main.addTab("Input", jPanel_IOPaths);

        jPanel_PSFBasic.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic PSF Parameters"));

        jComboBox_PSFCalculateOrNot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calculate PSF once", "Calculate PSF for all images", "Load PSF" }));
        jComboBox_PSFCalculateOrNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PSFCalculateOrNotActionPerformed(evt);
            }
        });

        jTabbedPane_PSFCalculateOrNot.setLayout(new CardLayout());
        jTabbedPane_PSFCalculateOrNot.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTabbedPane_PSFCalculateOrNot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel_PSFModel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_PSFModel.setText("Model of calculations");

        jComboBox_PSFMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gibson & Lanni 3D Optical Model", "Richards & Wolf 3D Optical Model", "Variable Refractive Index Gibson & Lanni", "Born & Wolf 3D Optical Model", "Török & Varga 3D Optical Model" }));
        jComboBox_PSFMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PSFMethodActionPerformed(evt);
            }
        });

        jTabbedPane_PSFMethod.setLayout(new CardLayout());
        jTabbedPane_PSFMethod.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTabbedPane_PSFMethod.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel_Working_GL.setText("Working distance");
        jLabel_Working_GL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_Working_GL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_Working_GL.setPreferredSize(new java.awt.Dimension(165, 16));

        jTextField_Working_GL.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Working_GL.setText("170");
        jTextField_Working_GL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Working_GLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Working_GLKeyTyped(evt);
            }
        });

        jLabel_WorkingUM_GL.setText("μm");
        jLabel_WorkingUM_GL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_WorkingUM_GL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_WorkingUM_GL.setPreferredSize(new java.awt.Dimension(165, 16));

        jLabel_Position_GL.setText("Particle Z position");
        jLabel_Position_GL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_Position_GL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_Position_GL.setPreferredSize(new java.awt.Dimension(165, 16));

        jTextField_Position_GL.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Position_GL.setText("0");
        jTextField_Position_GL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Position_GLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Position_GLKeyTyped(evt);
            }
        });

        jLabel_PositionNM_GL.setText("nm");
        jLabel_PositionNM_GL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_PositionNM_GL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_PositionNM_GL.setPreferredSize(new java.awt.Dimension(165, 16));

        jLabel_RI_Sample_GL.setText("Sample Refractive Index");
        jLabel_RI_Sample_GL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_RI_Sample_GL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_RI_Sample_GL.setPreferredSize(new java.awt.Dimension(165, 16));

        jTextField_RI_Sample_GL.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_RI_Sample_GL.setText("1.33");
        jTextField_RI_Sample_GL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_RI_Sample_GLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_RI_Sample_GLKeyTyped(evt);
            }
        });

        jCheckBox_DifferentRI_Sample_GL.setText("Different Sample RI for different wavelengths");
        jCheckBox_DifferentRI_Sample_GL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DifferentRI_Sample_GLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_PSF_RILayout = new javax.swing.GroupLayout(jPanel_PSF_RI);
        jPanel_PSF_RI.setLayout(jPanel_PSF_RILayout);
        jPanel_PSF_RILayout.setHorizontalGroup(
            jPanel_PSF_RILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_RILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_PSF_RILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_RI_Sample_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Position_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Working_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_PSF_RILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_PSF_RILayout.createSequentialGroup()
                        .addComponent(jTextField_RI_Sample_GL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_DifferentRI_Sample_GL))
                    .addGroup(jPanel_PSF_RILayout.createSequentialGroup()
                        .addComponent(jTextField_Position_GL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_PositionNM_GL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_PSF_RILayout.createSequentialGroup()
                        .addComponent(jTextField_Working_GL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_WorkingUM_GL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel_PSF_RILayout.setVerticalGroup(
            jPanel_PSF_RILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_RILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_PSF_RILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Working_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Working_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_WorkingUM_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PSF_RILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Position_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Position_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PositionNM_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PSF_RILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_RI_Sample_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_RI_Sample_GL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_DifferentRI_Sample_GL))
                .addGap(0, 63, Short.MAX_VALUE))
        );

        jTabbedPane_PSFMethod.addTab("GL", jPanel_PSF_RI);

        jLabel_RW.setText("No additional parameters needed");

        javax.swing.GroupLayout jPanel_PSF_RWLayout = new javax.swing.GroupLayout(jPanel_PSF_RW);
        jPanel_PSF_RW.setLayout(jPanel_PSF_RWLayout);
        jPanel_PSF_RWLayout.setHorizontalGroup(
            jPanel_PSF_RWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_RWLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_RW)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_PSF_RWLayout.setVerticalGroup(
            jPanel_PSF_RWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_RWLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_RW)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane_PSFMethod.addTab("RW", jPanel_PSF_RW);

        jLabel_Working_VRIGL.setText("Working distance");
        jLabel_Working_VRIGL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_Working_VRIGL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_Working_VRIGL.setPreferredSize(new java.awt.Dimension(165, 16));

        jTextField_Working_VRIGL.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Working_VRIGL.setText("170");
        jTextField_Working_VRIGL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Working_VRIGLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Working_VRIGLKeyTyped(evt);
            }
        });

        jLabel_WorkingUM_VRIGL.setText("μm");
        jLabel_WorkingUM_VRIGL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_WorkingUM_VRIGL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_WorkingUM_VRIGL.setPreferredSize(new java.awt.Dimension(165, 16));

        jLabel_Position_VRIGL.setText("Particle Z position");
        jLabel_Position_VRIGL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_Position_VRIGL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_Position_VRIGL.setPreferredSize(new java.awt.Dimension(165, 16));

        jTextField_Position_VRIGL.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Position_VRIGL.setText("0");
        jTextField_Position_VRIGL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Position_VRIGLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Position_VRIGLKeyTyped(evt);
            }
        });

        jLabel_PositionNM_VRIGL.setText("nm");
        jLabel_PositionNM_VRIGL.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_PositionNM_VRIGL.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_PositionNM_VRIGL.setPreferredSize(new java.awt.Dimension(165, 16));

        jLabel_RI_Sample0_VRIGL.setText("Sample Refractive Index at 0");

        jTextField_RI_Sample0_VRIGL.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_RI_Sample0_VRIGL.setText("1.33");
        jTextField_RI_Sample0_VRIGL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_RI_Sample0_VRIGLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_RI_Sample0_VRIGLKeyTyped(evt);
            }
        });

        jCheckBox_DifferentRI_Sample0_VRIGL.setText("Different Sample RI for different wavelengths");
        jCheckBox_DifferentRI_Sample0_VRIGL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DifferentRI_Sample0_VRIGLActionPerformed(evt);
            }
        });

        jLabel_RI_SampleZ_VRIGL.setText("Sample Refractive Index at Z");

        jTextField_RI_SampleZ_VRIGL.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_RI_SampleZ_VRIGL.setText("1.33");
        jTextField_RI_SampleZ_VRIGL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_RI_SampleZ_VRIGLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_RI_SampleZ_VRIGLKeyTyped(evt);
            }
        });

        jCheckBox_DifferentRI_SampleZ_VRIGL.setText("Different Sample RI for different wavelengths");
        jCheckBox_DifferentRI_SampleZ_VRIGL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DifferentRI_SampleZ_VRIGLActionPerformed(evt);
            }
        });

        jLabel_RI_Variation_VRIGL.setText("Refractive Index Variation");

        jComboBox_RIVariation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Linear", "Logarythmic", "Exponential" }));

        javax.swing.GroupLayout jPanel_PSF_VRIGLLayout = new javax.swing.GroupLayout(jPanel_PSF_VRIGL);
        jPanel_PSF_VRIGL.setLayout(jPanel_PSF_VRIGLLayout);
        jPanel_PSF_VRIGLLayout.setHorizontalGroup(
            jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_VRIGLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Position_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Working_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_RI_SampleZ_VRIGL)
                    .addComponent(jLabel_RI_Variation_VRIGL)
                    .addComponent(jLabel_RI_Sample0_VRIGL))
                .addGap(18, 18, 18)
                .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_RIVariation, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_PSF_VRIGLLayout.createSequentialGroup()
                        .addComponent(jTextField_RI_SampleZ_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_DifferentRI_SampleZ_VRIGL))
                    .addGroup(jPanel_PSF_VRIGLLayout.createSequentialGroup()
                        .addComponent(jTextField_RI_Sample0_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_DifferentRI_Sample0_VRIGL))
                    .addGroup(jPanel_PSF_VRIGLLayout.createSequentialGroup()
                        .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Position_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Working_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_PositionNM_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_WorkingUM_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel_PSF_VRIGLLayout.setVerticalGroup(
            jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_VRIGLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Working_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Working_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_WorkingUM_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Position_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Position_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PositionNM_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_RI_Sample0_VRIGL)
                    .addComponent(jTextField_RI_Sample0_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_DifferentRI_Sample0_VRIGL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_RI_SampleZ_VRIGL)
                    .addComponent(jCheckBox_DifferentRI_SampleZ_VRIGL)
                    .addComponent(jTextField_RI_SampleZ_VRIGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PSF_VRIGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_RI_Variation_VRIGL)
                    .addComponent(jComboBox_RIVariation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane_PSFMethod.addTab("VRIGL", jPanel_PSF_VRIGL);

        jLabel_BW.setText("No additional parameters needed");

        javax.swing.GroupLayout jPanel_PSF_BWLayout = new javax.swing.GroupLayout(jPanel_PSF_BW);
        jPanel_PSF_BW.setLayout(jPanel_PSF_BWLayout);
        jPanel_PSF_BWLayout.setHorizontalGroup(
            jPanel_PSF_BWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_BWLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_BW)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_PSF_BWLayout.setVerticalGroup(
            jPanel_PSF_BWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_BWLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_BW)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane_PSFMethod.addTab("BW", jPanel_PSF_BW);

        jLabel_Working_TV.setText("Working distance");
        jLabel_Working_TV.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_Working_TV.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_Working_TV.setPreferredSize(new java.awt.Dimension(165, 16));

        jTextField_Working_TV.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Working_TV.setText("170");
        jTextField_Working_TV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Working_TVKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Working_TVKeyTyped(evt);
            }
        });

        jLabel_WorkingUM_TV.setText("μm");
        jLabel_WorkingUM_TV.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_WorkingUM_TV.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_WorkingUM_TV.setPreferredSize(new java.awt.Dimension(165, 16));

        jLabel_Position_TV.setText("Particle Z position");
        jLabel_Position_TV.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_Position_TV.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_Position_TV.setPreferredSize(new java.awt.Dimension(165, 16));

        jTextField_Position_TV.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Position_TV.setText("0");
        jTextField_Position_TV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Position_TVKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Position_TVKeyTyped(evt);
            }
        });

        jLabel_PositionNM_TV.setText("nm");
        jLabel_PositionNM_TV.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_PositionNM_TV.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_PositionNM_TV.setPreferredSize(new java.awt.Dimension(165, 16));

        jLabel_RI_Sample_TV.setText("Sample Refractive Index");
        jLabel_RI_Sample_TV.setMaximumSize(new java.awt.Dimension(165, 16));
        jLabel_RI_Sample_TV.setMinimumSize(new java.awt.Dimension(165, 16));
        jLabel_RI_Sample_TV.setPreferredSize(new java.awt.Dimension(165, 16));

        jTextField_RI_Sample_TV.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_RI_Sample_TV.setText("1.33");
        jTextField_RI_Sample_TV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_RI_Sample_TVKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_RI_Sample_TVKeyTyped(evt);
            }
        });

        jCheckBox_DifferentRI_Sample_TV.setText("Different Sample RI for different wavelengths");
        jCheckBox_DifferentRI_Sample_TV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DifferentRI_Sample_TVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_PSF_TVLayout = new javax.swing.GroupLayout(jPanel_PSF_TV);
        jPanel_PSF_TV.setLayout(jPanel_PSF_TVLayout);
        jPanel_PSF_TVLayout.setHorizontalGroup(
            jPanel_PSF_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_TVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_PSF_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_RI_Sample_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Position_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Working_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_PSF_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_PSF_TVLayout.createSequentialGroup()
                        .addComponent(jTextField_RI_Sample_TV, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_DifferentRI_Sample_TV))
                    .addGroup(jPanel_PSF_TVLayout.createSequentialGroup()
                        .addComponent(jTextField_Working_TV, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_WorkingUM_TV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_PSF_TVLayout.createSequentialGroup()
                        .addComponent(jTextField_Position_TV, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_PositionNM_TV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel_PSF_TVLayout.setVerticalGroup(
            jPanel_PSF_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSF_TVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_PSF_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Working_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Working_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_WorkingUM_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PSF_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Position_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Position_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PositionNM_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PSF_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_RI_Sample_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_RI_Sample_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_DifferentRI_Sample_TV))
                .addGap(0, 63, Short.MAX_VALUE))
        );

        jTabbedPane_PSFMethod.addTab("TV", jPanel_PSF_TV);

        jLabel_PSFBasicParameters.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_PSFBasicParameters.setText("Basic parameters");

        jLabel_NA.setText("NA");

        jTextField_NA.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_NA.setText("1.45");
        jTextField_NA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NAKeyTyped(evt);
            }
        });

        jTextField_RI_Oil.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_RI_Oil.setText("1.518");
        jTextField_RI_Oil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_RI_OilKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_RI_OilKeyTyped(evt);
            }
        });

        jLabel_RI.setText("Immersion Oil Refractive Index");

        jCheckBox_DifferentRIOil.setText("Different Immersion RI for different wavelengths");
        jCheckBox_DifferentRIOil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DifferentRIOilActionPerformed(evt);
            }
        });

        jLabel_Accuracy.setText("Accuracy");

        jComboBox_Accuracy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Good", "Better", "Best" }));
        jComboBox_Accuracy.setSelectedIndex(2);

        jLabel_Bit.setText("Bit depth");

        jComboBox_Bit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8-bit", "16-bit", "32-bit" }));
        jComboBox_Bit.setSelectedIndex(2);
        jComboBox_Bit.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel_CalculatePSFLayout = new javax.swing.GroupLayout(jPanel_CalculatePSF);
        jPanel_CalculatePSF.setLayout(jPanel_CalculatePSFLayout);
        jPanel_CalculatePSFLayout.setHorizontalGroup(
            jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparatorPSF2)
            .addGroup(jPanel_CalculatePSFLayout.createSequentialGroup()
                .addGroup(jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_PSFModel)
                    .addComponent(jLabel_PSFBasicParameters)
                    .addGroup(jPanel_CalculatePSFLayout.createSequentialGroup()
                        .addGroup(jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_RI)
                            .addGroup(jPanel_CalculatePSFLayout.createSequentialGroup()
                                .addComponent(jLabel_NA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_NA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_Accuracy)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_Accuracy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_RI_Oil))
                        .addGroup(jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_CalculatePSFLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jCheckBox_DifferentRIOil))
                            .addGroup(jPanel_CalculatePSFLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_Bit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Bit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jComboBox_PSFMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane_PSFMethod, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel_CalculatePSFLayout.setVerticalGroup(
            jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CalculatePSFLayout.createSequentialGroup()
                .addComponent(jLabel_PSFBasicParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_RI)
                    .addComponent(jTextField_RI_Oil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_DifferentRIOil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Bit)
                        .addComponent(jComboBox_Bit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_CalculatePSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_NA)
                        .addComponent(jTextField_NA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_Accuracy)
                        .addComponent(jComboBox_Accuracy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_PSFModel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_PSFMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorPSF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane_PSFMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        for(int i=0; i<jTabbedPane_PSFMethod.getTabCount(); i++)listPSF.add(jTabbedPane_PSFMethod.getTitleAt(i));

        jTabbedPane_PSFCalculateOrNot.addTab("Calculate PSF", jPanel_CalculatePSF);

        jTextField_PSFPath.setText("User Directory");
        jTextField_PSFPath.setText(System.getProperty("user.home")+"\\PSF.tif");

        jLabel_PSFPath.setText("PSF path");

        jButton_PSFPath.setText("Select");
        jButton_PSFPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PSFPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_LoadPSFLayout = new javax.swing.GroupLayout(jPanel_LoadPSF);
        jPanel_LoadPSF.setLayout(jPanel_LoadPSFLayout);
        jPanel_LoadPSFLayout.setHorizontalGroup(
            jPanel_LoadPSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LoadPSFLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel_LoadPSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_LoadPSFLayout.createSequentialGroup()
                        .addComponent(jLabel_PSFPath)
                        .addContainerGap(511, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_LoadPSFLayout.createSequentialGroup()
                        .addComponent(jTextField_PSFPath)
                        .addGap(7, 7, 7)
                        .addComponent(jButton_PSFPath)
                        .addGap(1, 1, 1))))
        );
        jPanel_LoadPSFLayout.setVerticalGroup(
            jPanel_LoadPSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LoadPSFLayout.createSequentialGroup()
                .addComponent(jLabel_PSFPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_LoadPSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_PSFPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_PSFPath))
                .addContainerGap(296, Short.MAX_VALUE))
        );

        jTabbedPane_PSFCalculateOrNot.addTab("Load PSF", jPanel_LoadPSF);

        javax.swing.GroupLayout jPanel_PSFBasicLayout = new javax.swing.GroupLayout(jPanel_PSFBasic);
        jPanel_PSFBasic.setLayout(jPanel_PSFBasicLayout);
        jPanel_PSFBasicLayout.setHorizontalGroup(
            jPanel_PSFBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane_PSFCalculateOrNot, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel_PSFBasicLayout.createSequentialGroup()
                .addComponent(jComboBox_PSFCalculateOrNot, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator_PSF1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel_PSFBasicLayout.setVerticalGroup(
            jPanel_PSFBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSFBasicLayout.createSequentialGroup()
                .addComponent(jComboBox_PSFCalculateOrNot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator_PSF1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane_PSFCalculateOrNot, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        javax.swing.GroupLayout jPanel_PSFLayout = new javax.swing.GroupLayout(jPanel_PSF);
        jPanel_PSF.setLayout(jPanel_PSFLayout);
        jPanel_PSFLayout.setHorizontalGroup(
            jPanel_PSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_PSFBasic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_PSFLayout.setVerticalGroup(
            jPanel_PSFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PSFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_PSFBasic, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE))
        );

        jTabbedPanel_Main.addTab("PSF", jPanel_PSF);

        jPanel_Wave.setBorder(javax.swing.BorderFactory.createTitledBorder("Wavelengths"));

        jLabel_ChannelNumber.setText("Number of channels");

        jComboBox_ChannelNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        jComboBox_ChannelNumber.setSelectedIndex(3);
        jComboBox_ChannelNumber.setMaximumSize(new java.awt.Dimension(34, 22));
        jComboBox_ChannelNumber.setName(""); // NOI18N
        jComboBox_ChannelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ChannelNumberActionPerformed(evt);
            }
        });

        jLabel_Wave_RIOil.setText("Immersion Oil Refractive Index");

        jLabel_Wave_RISample.setText("Sample Refractive Index");

        jLabel_Wave_RISample0.setText("at 0");
        jLabel_Wave_RISample0.setEnabled(false);

        jLabel_Wave_RISampleZ.setText("Sample Refractive Index at Z");
        jLabel_Wave_RISampleZ.setEnabled(false);

        jTextField_Wave_RIOil.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Wave_RIOil.setText("1.518");
        jTextField_Wave_RIOil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Wave_RIOilKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wave_RIOilKeyTyped(evt);
            }
        });

        jTextField_Wave_RISample.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Wave_RISample.setText("1.33");
        jTextField_Wave_RISample.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Wave_RISampleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wave_RISampleKeyTyped(evt);
            }
        });

        jTextField_Wave_RISampleZ.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Wave_RISampleZ.setText("1.33");
        jTextField_Wave_RISampleZ.setEnabled(false);
        jTextField_Wave_RISampleZ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Wave_RISampleZKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wave_RISampleZKeyTyped(evt);
            }
        });

        jCheckBox_Wave_DifferentRIOil.setText("Different Immersion RI for different wavelengths");
        jCheckBox_Wave_DifferentRIOil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Wave_DifferentRIOilActionPerformed(evt);
            }
        });

        jCheckBox_Wave_DifferentRISample.setText("Different Sample RI for different wavelengths");
        jCheckBox_Wave_DifferentRISample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Wave_DifferentRISampleActionPerformed(evt);
            }
        });

        jCheckBox_Wave_DifferentRISampleZ.setText("Different Sample RI for different wavelengths");
        jCheckBox_Wave_DifferentRISampleZ.setEnabled(false);
        jCheckBox_Wave_DifferentRISampleZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Wave_DifferentRISampleZActionPerformed(evt);
            }
        });

        jLabel_Channel1.setText("Channel 1");

        jLabel_Channel2.setText("Channel 2");

        jLabel_Channel3.setText("Channel 3");

        jLabel_Channel4.setText("Channel 4");

        jLabel_Channel5.setText("Channel 5");
        jLabel_Channel5.setEnabled(false);

        jLabel_Channel6.setText("Channel 6");
        jLabel_Channel6.setEnabled(false);

        jLabel_Channel7.setText("Channel 7");
        jLabel_Channel7.setEnabled(false);

        jLabel_Channel8.setText("Channel 8");
        jLabel_Channel8.setEnabled(false);

        jLabel_Wavelength.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Wavelength.setText("Wavelength [nm]");

        jTextField_Wavelength1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Wavelength1.setText("405");
        jTextField_Wavelength1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wavelength1KeyTyped(evt);
            }
        });

        jTextField_Wavelength2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Wavelength2.setText("488");
        jTextField_Wavelength2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wavelength2KeyTyped(evt);
            }
        });

        jTextField_Wavelength3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Wavelength3.setText("561");
        jTextField_Wavelength3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wavelength3KeyTyped(evt);
            }
        });

        jTextField_Wavelength4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Wavelength4.setText("647");
        jTextField_Wavelength4.setEnabled(false);
        jTextField_Wavelength4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wavelength4KeyTyped(evt);
            }
        });

        jTextField_Wavelength5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Wavelength5.setText("700");
        jTextField_Wavelength5.setEnabled(false);
        jTextField_Wavelength5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wavelength5KeyTyped(evt);
            }
        });

        jTextField_Wavelength6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Wavelength6.setText("700");
        jTextField_Wavelength6.setEnabled(false);
        jTextField_Wavelength6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wavelength6KeyTyped(evt);
            }
        });

        jTextField_Wavelength7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Wavelength7.setText("700");
        jTextField_Wavelength7.setEnabled(false);
        jTextField_Wavelength7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wavelength7KeyTyped(evt);
            }
        });

        jTextField_Wavelength8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Wavelength8.setText("700");
        jTextField_Wavelength8.setEnabled(false);
        jTextField_Wavelength8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Wavelength8KeyTyped(evt);
            }
        });

        jLabel_OilRI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_OilRI.setText("Oil RI");
        jLabel_OilRI.setEnabled(false);

        jTextField_OilRI1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_OilRI1.setText("1.518");
        jTextField_OilRI1.setEnabled(false);
        jTextField_OilRI1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OilRI1KeyTyped(evt);
            }
        });

        jTextField_OilRI2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_OilRI2.setText("1.518");
        jTextField_OilRI2.setEnabled(false);
        jTextField_OilRI2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OilRI2KeyTyped(evt);
            }
        });

        jTextField_OilRI3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_OilRI3.setText("1.518");
        jTextField_OilRI3.setEnabled(false);
        jTextField_OilRI3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OilRI3KeyTyped(evt);
            }
        });

        jTextField_OilRI4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_OilRI4.setText("1.518");
        jTextField_OilRI4.setEnabled(false);
        jTextField_OilRI4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OilRI4KeyTyped(evt);
            }
        });

        jTextField_OilRI5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_OilRI5.setText("1.518");
        jTextField_OilRI5.setEnabled(false);
        jTextField_OilRI5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OilRI5KeyTyped(evt);
            }
        });

        jTextField_OilRI6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_OilRI6.setText("1.518");
        jTextField_OilRI6.setEnabled(false);
        jTextField_OilRI6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OilRI6KeyTyped(evt);
            }
        });

        jTextField_OilRI7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_OilRI7.setText("1.518");
        jTextField_OilRI7.setEnabled(false);
        jTextField_OilRI7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OilRI7KeyTyped(evt);
            }
        });

        jTextField_OilRI8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_OilRI8.setText("1.518");
        jTextField_OilRI8.setEnabled(false);
        jTextField_OilRI8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OilRI8KeyTyped(evt);
            }
        });

        jLabel_SampleRI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_SampleRI.setText("Sample RI");
        jLabel_SampleRI.setEnabled(false);

        jLabel_Sample0RI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Sample0RI.setText("at 0");
        jLabel_Sample0RI.setEnabled(false);

        jTextField_SampleRI1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleRI1.setText("1.33");
        jTextField_SampleRI1.setEnabled(false);
        jTextField_SampleRI1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleRI1KeyTyped(evt);
            }
        });

        jTextField_SampleRI2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleRI2.setText("1.33");
        jTextField_SampleRI2.setEnabled(false);
        jTextField_SampleRI2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleRI2KeyTyped(evt);
            }
        });

        jTextField_SampleRI3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleRI3.setText("1.33");
        jTextField_SampleRI3.setEnabled(false);
        jTextField_SampleRI3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleRI3KeyTyped(evt);
            }
        });

        jTextField_SampleRI4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleRI4.setText("1.33");
        jTextField_SampleRI4.setEnabled(false);
        jTextField_SampleRI4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleRI4KeyTyped(evt);
            }
        });

        jTextField_SampleRI5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleRI5.setText("1.33");
        jTextField_SampleRI5.setEnabled(false);
        jTextField_SampleRI5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleRI5KeyTyped(evt);
            }
        });

        jTextField_SampleRI6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleRI6.setText("1.33");
        jTextField_SampleRI6.setEnabled(false);
        jTextField_SampleRI6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleRI6KeyTyped(evt);
            }
        });

        jTextField_SampleRI7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleRI7.setText("1.33");
        jTextField_SampleRI7.setEnabled(false);
        jTextField_SampleRI7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleRI7KeyTyped(evt);
            }
        });

        jTextField_SampleRI8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleRI8.setText("1.33");
        jTextField_SampleRI8.setEnabled(false);
        jTextField_SampleRI8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleRI8KeyTyped(evt);
            }
        });

        jLabel_SampleZRI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_SampleZRI.setText("Sample RI at Z");
        jLabel_SampleZRI.setEnabled(false);

        jTextField_SampleZRI1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleZRI1.setText("1.33");
        jTextField_SampleZRI1.setEnabled(false);
        jTextField_SampleZRI1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleZRI1KeyTyped(evt);
            }
        });

        jTextField_SampleZRI2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleZRI2.setText("1.33");
        jTextField_SampleZRI2.setEnabled(false);
        jTextField_SampleZRI2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleZRI2KeyTyped(evt);
            }
        });

        jTextField_SampleZRI3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleZRI3.setText("1.33");
        jTextField_SampleZRI3.setEnabled(false);
        jTextField_SampleZRI3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleZRI3KeyTyped(evt);
            }
        });

        jTextField_SampleZRI4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleZRI4.setText("1.33");
        jTextField_SampleZRI4.setEnabled(false);
        jTextField_SampleZRI4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleZRI4KeyTyped(evt);
            }
        });

        jTextField_SampleZRI5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleZRI5.setText("1.33");
        jTextField_SampleZRI5.setEnabled(false);
        jTextField_SampleZRI5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleZRI5KeyTyped(evt);
            }
        });

        jTextField_SampleZRI6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleZRI6.setText("1.33");
        jTextField_SampleZRI6.setEnabled(false);
        jTextField_SampleZRI6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleZRI6KeyTyped(evt);
            }
        });

        jTextField_SampleZRI7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleZRI7.setText("1.33");
        jTextField_SampleZRI7.setEnabled(false);
        jTextField_SampleZRI7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleZRI7KeyTyped(evt);
            }
        });

        jTextField_SampleZRI8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_SampleZRI8.setText("1.33");
        jTextField_SampleZRI8.setEnabled(false);
        jTextField_SampleZRI8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SampleZRI8KeyTyped(evt);
            }
        });

        jLabel_Brightfield.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Brightfield.setText("Brightfield");

        jCheckBox_Brightfield1.setText("    ");
        jCheckBox_Brightfield1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Brightfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Brightfield1ActionPerformed(evt);
            }
        });

        jCheckBox_Brightfield2.setText("    ");
        jCheckBox_Brightfield2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Brightfield2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Brightfield2ActionPerformed(evt);
            }
        });

        jCheckBox_Brightfield3.setText("    ");
        jCheckBox_Brightfield3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Brightfield3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Brightfield3ActionPerformed(evt);
            }
        });

        jCheckBox_Brightfield4.setSelected(true);
        jCheckBox_Brightfield4.setText("    ");
        jCheckBox_Brightfield4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Brightfield4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Brightfield4ActionPerformed(evt);
            }
        });

        jCheckBox_Brightfield5.setText("    ");
        jCheckBox_Brightfield5.setEnabled(false);
        jCheckBox_Brightfield5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Brightfield5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Brightfield5ActionPerformed(evt);
            }
        });

        jCheckBox_Brightfield6.setText("    ");
        jCheckBox_Brightfield6.setEnabled(false);
        jCheckBox_Brightfield6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Brightfield6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Brightfield6ActionPerformed(evt);
            }
        });

        jCheckBox_Brightfield7.setText("    ");
        jCheckBox_Brightfield7.setEnabled(false);
        jCheckBox_Brightfield7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Brightfield7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Brightfield7ActionPerformed(evt);
            }
        });

        jCheckBox_Brightfield8.setText("    ");
        jCheckBox_Brightfield8.setEnabled(false);
        jCheckBox_Brightfield8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Brightfield8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_Brightfield8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_WaveLayout = new javax.swing.GroupLayout(jPanel_Wave);
        jPanel_Wave.setLayout(jPanel_WaveLayout);
        jPanel_WaveLayout.setHorizontalGroup(
            jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_WaveLayout.createSequentialGroup()
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Wave_RIOil)
                    .addComponent(jLabel_ChannelNumber)
                    .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_WaveLayout.createSequentialGroup()
                            .addComponent(jLabel_Wave_RISample)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Wave_RISample0, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel_Wave_RISampleZ, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Wave_RISample, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_Wave_RISampleZ, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_WaveLayout.createSequentialGroup()
                                .addComponent(jTextField_Wave_RIOil, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_Wave_DifferentRISample)
                            .addComponent(jCheckBox_Wave_DifferentRIOil, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox_Wave_DifferentRISampleZ))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addComponent(jComboBox_ChannelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel_WaveLayout.createSequentialGroup()
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Channel3)
                    .addComponent(jLabel_Channel2)
                    .addComponent(jLabel_Channel4)
                    .addComponent(jLabel_Channel1)
                    .addComponent(jLabel_Channel5)
                    .addComponent(jLabel_Channel6)
                    .addComponent(jLabel_Channel7)
                    .addComponent(jLabel_Channel8))
                .addGap(24, 24, 24)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField_Wavelength8)
                    .addComponent(jTextField_Wavelength7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Wavelength6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Wavelength3)
                    .addComponent(jTextField_Wavelength2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Wavelength, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Wavelength1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Wavelength4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Wavelength5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addComponent(jTextField_OilRI6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleRI6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleZRI6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_Brightfield6))
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addComponent(jLabel_OilRI, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_SampleRI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Sample0RI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_SampleZRI, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Brightfield))
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addComponent(jTextField_OilRI3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleRI3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleZRI3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_Brightfield3))
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_OilRI5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_OilRI4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_WaveLayout.createSequentialGroup()
                                .addComponent(jTextField_SampleRI4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_SampleZRI4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox_Brightfield4))
                            .addGroup(jPanel_WaveLayout.createSequentialGroup()
                                .addComponent(jTextField_SampleRI5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_SampleZRI5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox_Brightfield5))))
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addComponent(jTextField_OilRI7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleRI7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleZRI7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_Brightfield7))
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addComponent(jTextField_OilRI8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleRI8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleZRI8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_Brightfield8))
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addComponent(jTextField_OilRI1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleRI1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleZRI1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_Brightfield1))
                    .addGroup(jPanel_WaveLayout.createSequentialGroup()
                        .addComponent(jTextField_OilRI2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleRI2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_SampleZRI2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_Brightfield2))))
        );
        jPanel_WaveLayout.setVerticalGroup(
            jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_WaveLayout.createSequentialGroup()
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_ChannelNumber)
                    .addComponent(jComboBox_ChannelNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Wave_RIOil)
                    .addComponent(jTextField_Wave_RIOil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_Wave_DifferentRIOil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Wave_RISample)
                    .addComponent(jLabel_Wave_RISample0)
                    .addComponent(jTextField_Wave_RISample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_Wave_DifferentRISample))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Wave_RISampleZ)
                    .addComponent(jTextField_Wave_RISampleZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_Wave_DifferentRISampleZ))
                .addGap(18, 18, 18)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Wavelength)
                    .addComponent(jLabel_OilRI)
                    .addComponent(jLabel_SampleRI)
                    .addComponent(jLabel_Sample0RI)
                    .addComponent(jLabel_SampleZRI)
                    .addComponent(jLabel_Brightfield))
                .addGap(11, 11, 11)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Wavelength1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_OilRI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleRI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleZRI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Channel1)
                    .addComponent(jCheckBox_Brightfield1))
                .addGap(4, 4, 4)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Wavelength2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Channel2)
                    .addComponent(jTextField_OilRI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleRI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleZRI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_Brightfield2))
                .addGap(4, 4, 4)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Wavelength3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Channel3)
                    .addComponent(jTextField_OilRI3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleRI3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleZRI3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_Brightfield3))
                .addGap(4, 4, 4)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Wavelength4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Channel4)
                    .addComponent(jTextField_OilRI4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleRI4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleZRI4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_Brightfield4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Wavelength5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_Channel5))
                    .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_OilRI5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_SampleRI5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_SampleZRI5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox_Brightfield5)))
                .addGap(4, 4, 4)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Wavelength6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_OilRI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleRI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleZRI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Channel6)
                    .addComponent(jCheckBox_Brightfield6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Wavelength7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_OilRI7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleRI7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleZRI7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Channel7)
                    .addComponent(jCheckBox_Brightfield7))
                .addGap(4, 4, 4)
                .addGroup(jPanel_WaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Wavelength8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_OilRI8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleRI8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SampleZRI8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Channel8)
                    .addComponent(jCheckBox_Brightfield8))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_WavelengthsLayout = new javax.swing.GroupLayout(jPanel_Wavelengths);
        jPanel_Wavelengths.setLayout(jPanel_WavelengthsLayout);
        jPanel_WavelengthsLayout.setHorizontalGroup(
            jPanel_WavelengthsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Wave, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
        );
        jPanel_WavelengthsLayout.setVerticalGroup(
            jPanel_WavelengthsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_WavelengthsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Wave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPanel_Main.addTab("Channels", jPanel_Wavelengths);

        jPanel_DeconvolutionAlgorithm.setBorder(javax.swing.BorderFactory.createTitledBorder("Deconvolution Algorithm"));

        jComboBox_DeconvolutionAlgorithm.setMaximumRowCount(20);
        jComboBox_DeconvolutionAlgorithm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regularized Inverse Filter", "Tikhonov Regularization Inverse Filter", "Naive Inverse Filter", "Fast Iterative Shrinkage-Thresholding", "Iterative Shrinkage-Thresholding", "Landweber", "Non-Linear Least-Square", "Bounded-Variable Least Squares", "Richardson-Lucy", "Richardson-Lucy Total Variation", "Tikhonov-Miller", "Iterative Contraint Tikhonov-Miller", "Van Cittert", "Non Stablized Division" }));
        jComboBox_DeconvolutionAlgorithm.setSelectedIndex(8);
        jComboBox_DeconvolutionAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DeconvolutionAlgorithmActionPerformed(evt);
            }
        });

        jTabbedPane_DeconvolutionAlgorithm.setLayout(new CardLayout());
        jTabbedPane_DeconvolutionAlgorithm.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTabbedPane_DeconvolutionAlgorithm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel_RIF.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_RIF.setText("Regularized Inverse Filter");

        jSlider_RIF_Reg.setMajorTickSpacing(3000);
        jSlider_RIF_Reg.setMaximum(10000);
        jSlider_RIF_Reg.setMinimum(-18000);
        jSlider_RIF_Reg.setMinorTickSpacing(1000);
        jSlider_RIF_Reg.setPaintLabels(true);
        jSlider_RIF_Reg.setPaintTicks(true);
        jSlider_RIF_Reg.setValue(-1000);
        jSlider_RIF_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider_RIF_Reg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider_RIF_RegMouseDragged(evt);
            }
        });
        jSlider_RIF_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_RIF_RegMouseReleased(evt);
            }
        });
        jSlider_RIF_Reg.setLabelTable(regLabels);

        jLabel_RIF_Reg.setText("Reg. λ");

        jTextField_RIF_Reg.setText("0.1000");
        jTextField_RIF_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_RIF_RegKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_RIF_RegKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel_RIFLayout = new javax.swing.GroupLayout(jPanel_RIF);
        jPanel_RIF.setLayout(jPanel_RIFLayout);
        jPanel_RIFLayout.setHorizontalGroup(
            jPanel_RIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RIFLayout.createSequentialGroup()
                .addComponent(jLabel_RIF)
                .addGap(0, 399, Short.MAX_VALUE))
            .addGroup(jPanel_RIFLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel_RIF_Reg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider_RIF_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_RIF_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_RIFLayout.setVerticalGroup(
            jPanel_RIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RIFLayout.createSequentialGroup()
                .addComponent(jLabel_RIF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel_RIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider_RIF_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_RIF_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_RIFLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_RIF_Reg)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("RIF", jPanel_RIF);

        jLabel_TRIF.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_TRIF.setText("Tikhonov Regularization Inverse Filter");

        jSlider_TRIF_Reg.setMajorTickSpacing(3000);
        jSlider_TRIF_Reg.setMaximum(10000);
        jSlider_TRIF_Reg.setMinimum(-18000);
        jSlider_TRIF_Reg.setMinorTickSpacing(1000);
        jSlider_TRIF_Reg.setPaintLabels(true);
        jSlider_TRIF_Reg.setPaintTicks(true);
        jSlider_TRIF_Reg.setValue(-1000);
        jSlider_TRIF_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider_TRIF_Reg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider_TRIF_RegMouseDragged(evt);
            }
        });
        jSlider_TRIF_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_TRIF_RegMouseReleased(evt);
            }
        });
        jSlider_TRIF_Reg.setLabelTable(regLabels);

        jLabel_TRIF_Reg.setText("Reg. λ");

        jTextField_TRIF_Reg.setText("0.1000");
        jTextField_TRIF_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_TRIF_RegKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TRIF_RegKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel_TRIFLayout = new javax.swing.GroupLayout(jPanel_TRIF);
        jPanel_TRIF.setLayout(jPanel_TRIFLayout);
        jPanel_TRIFLayout.setHorizontalGroup(
            jPanel_TRIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TRIFLayout.createSequentialGroup()
                .addComponent(jLabel_TRIF)
                .addGap(0, 321, Short.MAX_VALUE))
            .addGroup(jPanel_TRIFLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel_TRIF_Reg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider_TRIF_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_TRIF_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_TRIFLayout.setVerticalGroup(
            jPanel_TRIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TRIFLayout.createSequentialGroup()
                .addComponent(jLabel_TRIF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel_TRIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider_TRIF_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_TRIF_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_TRIFLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_TRIF_Reg)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("TRIF", jPanel_TRIF);

        jLabel_NIF.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_NIF.setText("Naive Inverse Filter");

        jLabel_NIF_NoParameters.setText("No additional parameters needed");

        javax.swing.GroupLayout jPanel_NIFLayout = new javax.swing.GroupLayout(jPanel_NIF);
        jPanel_NIF.setLayout(jPanel_NIFLayout);
        jPanel_NIFLayout.setHorizontalGroup(
            jPanel_NIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_NIFLayout.createSequentialGroup()
                .addComponent(jLabel_NIF)
                .addGap(0, 440, Short.MAX_VALUE))
            .addGroup(jPanel_NIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_NIFLayout.createSequentialGroup()
                    .addGap(187, 187, 187)
                    .addComponent(jLabel_NIF_NoParameters)
                    .addContainerGap(188, Short.MAX_VALUE)))
        );
        jPanel_NIFLayout.setVerticalGroup(
            jPanel_NIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_NIFLayout.createSequentialGroup()
                .addComponent(jLabel_NIF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(jPanel_NIFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_NIFLayout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jLabel_NIF_NoParameters)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("NIF", jPanel_NIF);

        jLabel_FISTA.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_FISTA.setText("Fast Iterative Shrinkage-Thresholding");

        jSlider_FISTA_Reg.setMajorTickSpacing(3000);
        jSlider_FISTA_Reg.setMaximum(10000);
        jSlider_FISTA_Reg.setMinimum(-18000);
        jSlider_FISTA_Reg.setMinorTickSpacing(1000);
        jSlider_FISTA_Reg.setPaintLabels(true);
        jSlider_FISTA_Reg.setPaintTicks(true);
        jSlider_FISTA_Reg.setValue(-1000);
        jSlider_FISTA_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider_FISTA_Reg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider_FISTA_RegMouseDragged(evt);
            }
        });
        jSlider_FISTA_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_FISTA_RegMouseReleased(evt);
            }
        });
        regLabels = new Hashtable<>();
 regLabels.put(-18000, new JLabel("Off"));
 regLabels.put(-12000, new JLabel("Low"));
 regLabels.put(-6000, new JLabel("1E-6"));
 regLabels.put(0, new JLabel("1.0"));
 regLabels.put(9000, new JLabel("High"));
 jSlider_FISTA_Reg.setLabelTable(regLabels);

        jLabel_FISTA_Reg.setText("Reg. λ");

        jTextField_FISTA_Reg.setText("0.1000");
        jTextField_FISTA_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_FISTA_RegKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_FISTA_RegKeyTyped(evt);
            }
        });

        jLabel_FISTA_Iterations.setText("Iterations N");

        jSpinner_FISTA_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_FISTA_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_FISTA_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_FISTA_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_FISTA_IterationsStateChanged(evt);
            }
        });

        jSpinner_FISTA_Step.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.1d));
        jSpinner_FISTA_Step.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_FISTA_Step.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_FISTA_Step.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_FISTA_StepStateChanged(evt);
            }
        });

        jLabel_FISTA_Step.setText("Step γ");

        jLabel_FISTA_Wavelets.setText("Wavelets");

        jLabel_FISTA_Scale.setText("Scale");

        jComboBox_FISTA_Wavelets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Haar", "Spline1", "Spline3", "Spline5" }));
        jComboBox_FISTA_Wavelets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_FISTA_WaveletsActionPerformed(evt);
            }
        });

        jComboBox_FISTA_Scale.setMaximumRowCount(20);
        jComboBox_FISTA_Scale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jComboBox_FISTA_Scale.setSelectedIndex(2);
        jComboBox_FISTA_Scale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_FISTA_ScaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_FISTALayout = new javax.swing.GroupLayout(jPanel_FISTA);
        jPanel_FISTA.setLayout(jPanel_FISTALayout);
        jPanel_FISTALayout.setHorizontalGroup(
            jPanel_FISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FISTALayout.createSequentialGroup()
                .addComponent(jLabel_FISTA)
                .addGap(0, 320, Short.MAX_VALUE))
            .addGroup(jPanel_FISTALayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel_FISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_FISTALayout.createSequentialGroup()
                        .addComponent(jLabel_FISTA_Wavelets)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_FISTA_Wavelets, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel_FISTA_Scale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_FISTA_Scale, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_FISTALayout.createSequentialGroup()
                        .addGroup(jPanel_FISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel_FISTALayout.createSequentialGroup()
                                .addComponent(jLabel_FISTA_Iterations)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner_FISTA_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_FISTA_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_FISTALayout.createSequentialGroup()
                                .addComponent(jLabel_FISTA_Reg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSlider_FISTA_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel_FISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_FISTA_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner_FISTA_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_FISTALayout.setVerticalGroup(
            jPanel_FISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FISTALayout.createSequentialGroup()
                .addComponent(jLabel_FISTA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_FISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_FISTA_Iterations)
                    .addComponent(jSpinner_FISTA_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_FISTA_Step)
                    .addComponent(jSpinner_FISTA_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_FISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider_FISTA_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FISTA_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_FISTALayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_FISTA_Reg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_FISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_FISTA_Wavelets)
                    .addComponent(jComboBox_FISTA_Wavelets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_FISTA_Scale)
                    .addComponent(jComboBox_FISTA_Scale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("FISTA", jPanel_FISTA);

        jLabel_ISTA.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_ISTA.setText("Iterative Shrinkage-Thresholding");

        jSlider_ISTA_Reg.setMajorTickSpacing(3000);
        jSlider_ISTA_Reg.setMaximum(10000);
        jSlider_ISTA_Reg.setMinimum(-18000);
        jSlider_ISTA_Reg.setMinorTickSpacing(1000);
        jSlider_ISTA_Reg.setPaintLabels(true);
        jSlider_ISTA_Reg.setPaintTicks(true);
        jSlider_ISTA_Reg.setValue(-1000);
        jSlider_ISTA_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider_ISTA_Reg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider_ISTA_RegMouseDragged(evt);
            }
        });
        jSlider_ISTA_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_ISTA_RegMouseReleased(evt);
            }
        });
        jSlider_ISTA_Reg.setLabelTable(regLabels);

        jLabel_ISTA_Reg.setText("Reg. λ");

        jTextField_ISTA_Reg.setText("0.1000");
        jTextField_ISTA_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_ISTA_RegKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ISTA_RegKeyTyped(evt);
            }
        });

        jLabel_ISTA_Iterations.setText("Iterations N");

        jSpinner_ISTA_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_ISTA_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_ISTA_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_ISTA_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_ISTA_IterationsStateChanged(evt);
            }
        });

        jSpinner_ISTA_Step.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.1d));
        jSpinner_ISTA_Step.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_ISTA_Step.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_ISTA_Step.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_ISTA_StepStateChanged(evt);
            }
        });

        jLabel_ISTA_Step.setText("Step γ");

        jLabel_ISTA_Wavelets.setText("Wavelets");

        jLabel_ISTA_Scale.setText("Scale");

        jComboBox_ISTA_Wavelets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Haar", "Spline1", "Spline3", "Spline5" }));
        jComboBox_ISTA_Wavelets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ISTA_WaveletsActionPerformed(evt);
            }
        });

        jComboBox_ISTA_Scale.setMaximumRowCount(20);
        jComboBox_ISTA_Scale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jComboBox_ISTA_Scale.setSelectedIndex(2);
        jComboBox_ISTA_Scale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ISTA_ScaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ISTALayout = new javax.swing.GroupLayout(jPanel_ISTA);
        jPanel_ISTA.setLayout(jPanel_ISTALayout);
        jPanel_ISTALayout.setHorizontalGroup(
            jPanel_ISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ISTALayout.createSequentialGroup()
                .addComponent(jLabel_ISTA)
                .addGap(0, 351, Short.MAX_VALUE))
            .addGroup(jPanel_ISTALayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel_ISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ISTALayout.createSequentialGroup()
                        .addComponent(jLabel_ISTA_Wavelets)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_ISTA_Wavelets, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel_ISTA_Scale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_ISTA_Scale, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_ISTALayout.createSequentialGroup()
                        .addGroup(jPanel_ISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel_ISTALayout.createSequentialGroup()
                                .addComponent(jLabel_ISTA_Iterations)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner_ISTA_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_ISTA_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_ISTALayout.createSequentialGroup()
                                .addComponent(jLabel_ISTA_Reg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSlider_ISTA_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel_ISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_ISTA_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner_ISTA_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_ISTALayout.setVerticalGroup(
            jPanel_ISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ISTALayout.createSequentialGroup()
                .addComponent(jLabel_ISTA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_ISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ISTA_Iterations)
                    .addComponent(jSpinner_ISTA_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_ISTA_Step)
                    .addComponent(jSpinner_ISTA_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider_ISTA_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ISTA_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_ISTALayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_ISTA_Reg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ISTA_Wavelets)
                    .addComponent(jComboBox_ISTA_Wavelets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_ISTA_Scale)
                    .addComponent(jComboBox_ISTA_Scale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("ISTA", jPanel_ISTA);

        jLabel_LW.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_LW.setText("Landweber");

        jLabel_LW_Iterations.setText("Iterations N");

        jSpinner_LW_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_LW_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_LW_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_LW_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_LW_IterationsStateChanged(evt);
            }
        });

        jSpinner_LW_Step.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.1d));
        jSpinner_LW_Step.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_LW_Step.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_LW_Step.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_LW_StepStateChanged(evt);
            }
        });

        jLabel_LW_Step.setText("Step γ");

        javax.swing.GroupLayout jPanel_LWLayout = new javax.swing.GroupLayout(jPanel_LW);
        jPanel_LW.setLayout(jPanel_LWLayout);
        jPanel_LWLayout.setHorizontalGroup(
            jPanel_LWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LWLayout.createSequentialGroup()
                .addComponent(jLabel_LW)
                .addGap(0, 493, Short.MAX_VALUE))
            .addGroup(jPanel_LWLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel_LW_Iterations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_LW_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel_LW_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSpinner_LW_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_LWLayout.setVerticalGroup(
            jPanel_LWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LWLayout.createSequentialGroup()
                .addComponent(jLabel_LW, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_LWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_LW_Iterations)
                    .addComponent(jSpinner_LW_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_LW_Step)
                    .addComponent(jSpinner_LW_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("LW", jPanel_LW);

        jLabel_NNLS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_NNLS.setText("Non-Linear Least-Square");

        jLabel_NNLS_Iterations.setText("Iterations N");

        jSpinner_NNLS_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_NNLS_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_NNLS_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_NNLS_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_NNLS_IterationsStateChanged(evt);
            }
        });

        jSpinner_NNLS_Step.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.1d));
        jSpinner_NNLS_Step.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_NNLS_Step.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_NNLS_Step.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_NNLS_StepStateChanged(evt);
            }
        });

        jLabel_NNLS_Step.setText("Step γ");

        javax.swing.GroupLayout jPanel_NNLSLayout = new javax.swing.GroupLayout(jPanel_NNLS);
        jPanel_NNLS.setLayout(jPanel_NNLSLayout);
        jPanel_NNLSLayout.setHorizontalGroup(
            jPanel_NNLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_NNLSLayout.createSequentialGroup()
                .addComponent(jLabel_NNLS)
                .addGap(0, 403, Short.MAX_VALUE))
            .addGroup(jPanel_NNLSLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel_NNLS_Iterations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_NNLS_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel_NNLS_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSpinner_NNLS_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_NNLSLayout.setVerticalGroup(
            jPanel_NNLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_NNLSLayout.createSequentialGroup()
                .addComponent(jLabel_NNLS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_NNLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_NNLS_Iterations)
                    .addComponent(jSpinner_NNLS_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_NNLS_Step)
                    .addComponent(jSpinner_NNLS_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("NNLS", jPanel_NNLS);

        jLabel_BVLS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_BVLS.setText("Bounded-Variable Least Squares");

        jLabel_BVLS_Iterations.setText("Iterations N");

        jSpinner_BVLS_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_BVLS_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_BVLS_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_BVLS_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_BVLS_IterationsStateChanged(evt);
            }
        });

        jSpinner_BVLS_Step.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.1d));
        jSpinner_BVLS_Step.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_BVLS_Step.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_BVLS_Step.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_BVLS_StepStateChanged(evt);
            }
        });

        jLabel_BVLS_Step.setText("Step γ");

        javax.swing.GroupLayout jPanel_BVLSLayout = new javax.swing.GroupLayout(jPanel_BVLS);
        jPanel_BVLS.setLayout(jPanel_BVLSLayout);
        jPanel_BVLSLayout.setHorizontalGroup(
            jPanel_BVLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BVLSLayout.createSequentialGroup()
                .addComponent(jLabel_BVLS)
                .addGap(0, 353, Short.MAX_VALUE))
            .addGroup(jPanel_BVLSLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel_BVLS_Iterations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_BVLS_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel_BVLS_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSpinner_BVLS_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_BVLSLayout.setVerticalGroup(
            jPanel_BVLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BVLSLayout.createSequentialGroup()
                .addComponent(jLabel_BVLS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_BVLSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_BVLS_Iterations)
                    .addComponent(jSpinner_BVLS_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_BVLS_Step)
                    .addComponent(jSpinner_BVLS_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("BVLS", jPanel_BVLS);

        jLabel_RL.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_RL.setText("Richardson-Lucy");

        jLabel_RL_Iterations.setText("Iterations N");

        jSpinner_RL_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_RL_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_RL_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_RL_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_RL_IterationsStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel_RLLayout = new javax.swing.GroupLayout(jPanel_RL);
        jPanel_RL.setLayout(jPanel_RLLayout);
        jPanel_RLLayout.setHorizontalGroup(
            jPanel_RLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RLLayout.createSequentialGroup()
                .addComponent(jLabel_RL)
                .addGap(0, 457, Short.MAX_VALUE))
            .addGroup(jPanel_RLLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel_RL_Iterations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_RL_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );
        jPanel_RLLayout.setVerticalGroup(
            jPanel_RLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RLLayout.createSequentialGroup()
                .addComponent(jLabel_RL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_RLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_RL_Iterations)
                    .addComponent(jSpinner_RL_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("RL", jPanel_RL);

        jLabel_RLTV.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_RLTV.setText("Richardson-Lucy Total Variation");

        jSlider_RLTV_Reg.setMajorTickSpacing(3000);
        jSlider_RLTV_Reg.setMaximum(10000);
        jSlider_RLTV_Reg.setMinimum(-18000);
        jSlider_RLTV_Reg.setMinorTickSpacing(1000);
        jSlider_RLTV_Reg.setPaintLabels(true);
        jSlider_RLTV_Reg.setPaintTicks(true);
        jSlider_RLTV_Reg.setValue(-1000);
        jSlider_RLTV_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider_RLTV_Reg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider_RLTV_RegMouseDragged(evt);
            }
        });
        jSlider_RLTV_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_RLTV_RegMouseReleased(evt);
            }
        });
        jSlider_RLTV_Reg.setLabelTable(regLabels);

        jLabel_RLTV_Reg.setText("Reg. λ");

        jTextField_RLTV_Reg.setText("0.1000");
        jTextField_RLTV_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_RLTV_RegKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_RLTV_RegKeyTyped(evt);
            }
        });

        jLabel_RLTV_Iterations.setText("Iterations N");

        jSpinner_RLTV_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_RLTV_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_RLTV_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_RLTV_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_RLTV_IterationsStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel_RLTVLayout = new javax.swing.GroupLayout(jPanel_RLTV);
        jPanel_RLTV.setLayout(jPanel_RLTVLayout);
        jPanel_RLTVLayout.setHorizontalGroup(
            jPanel_RLTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RLTVLayout.createSequentialGroup()
                .addComponent(jLabel_RLTV)
                .addGap(0, 358, Short.MAX_VALUE))
            .addGroup(jPanel_RLTVLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel_RLTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_RLTVLayout.createSequentialGroup()
                        .addComponent(jLabel_RLTV_Iterations)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner_RLTV_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_RLTVLayout.createSequentialGroup()
                        .addComponent(jLabel_RLTV_Reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider_RLTV_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_RLTV_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_RLTVLayout.setVerticalGroup(
            jPanel_RLTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RLTVLayout.createSequentialGroup()
                .addComponent(jLabel_RLTV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_RLTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_RLTV_Iterations)
                    .addComponent(jSpinner_RLTV_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_RLTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider_RLTV_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_RLTV_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_RLTVLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_RLTV_Reg)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("RLTV", jPanel_RLTV);

        jLabel_TM.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_TM.setText("Tikhonov-Miller");

        jSlider_TM_Reg.setMajorTickSpacing(3000);
        jSlider_TM_Reg.setMaximum(10000);
        jSlider_TM_Reg.setMinimum(-18000);
        jSlider_TM_Reg.setMinorTickSpacing(1000);
        jSlider_TM_Reg.setPaintLabels(true);
        jSlider_TM_Reg.setPaintTicks(true);
        jSlider_TM_Reg.setValue(-1000);
        jSlider_TM_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider_TM_Reg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider_TM_RegMouseDragged(evt);
            }
        });
        jSlider_TM_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_TM_RegMouseReleased(evt);
            }
        });
        jSlider_TM_Reg.setLabelTable(regLabels);

        jLabel_TM_Reg.setText("Reg. λ");

        jTextField_TM_Reg.setText("0.1000");
        jTextField_TM_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_TM_RegKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TM_RegKeyTyped(evt);
            }
        });

        jLabel_TM_Iterations.setText("Iterations N");

        jSpinner_TM_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_TM_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_TM_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_TM_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_TM_IterationsStateChanged(evt);
            }
        });

        jSpinner_TM_Step.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.1d));
        jSpinner_TM_Step.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_TM_Step.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_TM_Step.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_TM_StepStateChanged(evt);
            }
        });

        jLabel_TM_Step.setText("Step γ");

        javax.swing.GroupLayout jPanel_TMLayout = new javax.swing.GroupLayout(jPanel_TM);
        jPanel_TM.setLayout(jPanel_TMLayout);
        jPanel_TMLayout.setHorizontalGroup(
            jPanel_TMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TMLayout.createSequentialGroup()
                .addComponent(jLabel_TM)
                .addGap(0, 468, Short.MAX_VALUE))
            .addGroup(jPanel_TMLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel_TMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_TMLayout.createSequentialGroup()
                        .addComponent(jLabel_TM_Iterations)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner_TM_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_TM_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_TMLayout.createSequentialGroup()
                        .addComponent(jLabel_TM_Reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider_TM_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel_TMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_TM_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_TM_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_TMLayout.setVerticalGroup(
            jPanel_TMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TMLayout.createSequentialGroup()
                .addComponent(jLabel_TM, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_TMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TM_Iterations)
                    .addComponent(jSpinner_TM_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_TM_Step)
                    .addComponent(jSpinner_TM_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_TMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider_TM_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_TM_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_TMLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_TM_Reg)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("TM", jPanel_TM);

        jLabel_ICTM.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_ICTM.setText("Iterative Contraint Tikhonov-Miller");

        jSlider_ICTM_Reg.setMajorTickSpacing(3000);
        jSlider_ICTM_Reg.setMaximum(10000);
        jSlider_ICTM_Reg.setMinimum(-18000);
        jSlider_ICTM_Reg.setMinorTickSpacing(1000);
        jSlider_ICTM_Reg.setPaintLabels(true);
        jSlider_ICTM_Reg.setPaintTicks(true);
        jSlider_ICTM_Reg.setValue(-1000);
        jSlider_ICTM_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider_ICTM_Reg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider_ICTM_RegMouseDragged(evt);
            }
        });
        jSlider_ICTM_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_ICTM_RegMouseReleased(evt);
            }
        });
        jSlider_ICTM_Reg.setLabelTable(regLabels);

        jLabel_ICTM_Reg.setText("Reg. λ");

        jTextField_ICTM_Reg.setText("0.1000");
        jTextField_ICTM_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_ICTM_RegKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ICTM_RegKeyTyped(evt);
            }
        });

        jLabel_ICTM_Iterations.setText("Iterations N");

        jSpinner_ICTM_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_ICTM_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_ICTM_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_ICTM_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_ICTM_IterationsStateChanged(evt);
            }
        });

        jSpinner_ICTM_Step.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.1d));
        jSpinner_ICTM_Step.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_ICTM_Step.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_ICTM_Step.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_ICTM_StepStateChanged(evt);
            }
        });

        jLabel_ICTM_Step.setText("Step γ");

        javax.swing.GroupLayout jPanel_ICTMLayout = new javax.swing.GroupLayout(jPanel_ICTM);
        jPanel_ICTM.setLayout(jPanel_ICTMLayout);
        jPanel_ICTMLayout.setHorizontalGroup(
            jPanel_ICTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ICTMLayout.createSequentialGroup()
                .addComponent(jLabel_ICTM)
                .addGap(0, 341, Short.MAX_VALUE))
            .addGroup(jPanel_ICTMLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel_ICTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_ICTMLayout.createSequentialGroup()
                        .addComponent(jLabel_ICTM_Iterations)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner_ICTM_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_ICTM_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_ICTMLayout.createSequentialGroup()
                        .addComponent(jLabel_ICTM_Reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider_ICTM_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel_ICTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_ICTM_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_ICTM_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_ICTMLayout.setVerticalGroup(
            jPanel_ICTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ICTMLayout.createSequentialGroup()
                .addComponent(jLabel_ICTM, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_ICTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ICTM_Iterations)
                    .addComponent(jSpinner_ICTM_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_ICTM_Step)
                    .addComponent(jSpinner_ICTM_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ICTMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider_ICTM_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ICTM_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_ICTMLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_ICTM_Reg)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("ICTM", jPanel_ICTM);

        jLabel_VC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_VC.setText("Van Cittert");

        jLabel_VC_Iterations.setText("Iterations N");

        jSpinner_VC_Iterations.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        jSpinner_VC_Iterations.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_VC_Iterations.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_VC_Iterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_VC_IterationsStateChanged(evt);
            }
        });

        jSpinner_VC_Step.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.1d));
        jSpinner_VC_Step.setOpaque(false);
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_VC_Step.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jSpinner_VC_Step.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_VC_StepStateChanged(evt);
            }
        });

        jLabel_VC_Step.setText("Step γ");

        javax.swing.GroupLayout jPanel_VCLayout = new javax.swing.GroupLayout(jPanel_VC);
        jPanel_VC.setLayout(jPanel_VCLayout);
        jPanel_VCLayout.setHorizontalGroup(
            jPanel_VCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_VCLayout.createSequentialGroup()
                .addComponent(jLabel_VC)
                .addGap(0, 493, Short.MAX_VALUE))
            .addGroup(jPanel_VCLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel_VC_Iterations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_VC_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel_VC_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSpinner_VC_Step, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_VCLayout.setVerticalGroup(
            jPanel_VCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_VCLayout.createSequentialGroup()
                .addComponent(jLabel_VC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_VCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_VC_Iterations)
                    .addComponent(jSpinner_VC_Iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_VC_Step)
                    .addComponent(jSpinner_VC_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("VC", jPanel_VC);

        jLabel_DIV.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_DIV.setText("Non Stablized Division");

        jLabel_NIF_NoParameters1.setText("No additional parameters needed");

        javax.swing.GroupLayout jPanel_DIVLayout = new javax.swing.GroupLayout(jPanel_DIV);
        jPanel_DIV.setLayout(jPanel_DIVLayout);
        jPanel_DIVLayout.setHorizontalGroup(
            jPanel_DIVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DIVLayout.createSequentialGroup()
                .addComponent(jLabel_DIV)
                .addGap(0, 425, Short.MAX_VALUE))
            .addGroup(jPanel_DIVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_DIVLayout.createSequentialGroup()
                    .addGap(187, 187, 187)
                    .addComponent(jLabel_NIF_NoParameters1)
                    .addContainerGap(188, Short.MAX_VALUE)))
        );
        jPanel_DIVLayout.setVerticalGroup(
            jPanel_DIVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DIVLayout.createSequentialGroup()
                .addComponent(jLabel_DIV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(jPanel_DIVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_DIVLayout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jLabel_NIF_NoParameters1)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );

        jTabbedPane_DeconvolutionAlgorithm.addTab("DIV", jPanel_DIV);

        jTabbedPane_DeconvolutionAlgorithm.setSelectedIndex(8);

        jLabel_Advanced.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Advanced.setText("Advanced");

        jLabel_Controller.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_Controller.setText("Controller");

        jLabel_Constraint.setText("Constraint");

        jComboBox_Constraint.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no", "nonnegativity", "clipped" }));

        Residu.setText("Residu");

        jCheckBox_Residu.setText(" ");
        jCheckBox_Residu.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox_Residu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_ResiduActionPerformed(evt);
            }
        });

        jTextField_Residu.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField_Residu.setText("0.01");
        jTextField_Residu.setEnabled(false);
        jTextField_Residu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ResiduKeyTyped(evt);
            }
        });

        jLabel_Processing.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_Processing.setText("Resources");

        jLabel_FFT.setText("FFT");

        jComboBox_FTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fastest", "FFTW2", "JTransforms", "Academic" }));
        jComboBox_FTT.setSelectedIndex(3);

        jLabel_Epsilon.setText("Epsilon");

        jComboBox_Epsilon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1E-0", "1E-1", "1E-2", "1E-3", "1E-4", "1E-5", "1E-6", "1E-7", "1E-8", "1E-9", "1E-10", "1E-11", "1E-12" }));
        jComboBox_Epsilon.setSelectedIndex(6);

        jLabel_Preprocessing.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_Preprocessing.setText("Preprocessing");

        jLabel_Image.setText("Image");

        jLabel_LateralXY.setText("Lateral (XY)");

        jLabel_AxialZ.setText("Axial (Z)");

        jLabel_Apodization.setText("Apodization");

        jComboBox_ApodizationXY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Uniform", "Hamming", "Hann", "Cosine", "Tukey", "Welch" }));

        jComboBox_ApodizationZ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Uniform", "Hamming", "Hann", "Cosine", "Tukey", "Welch" }));

        jLabel_PaddingExtension.setText("Padding Extension");

        jSpinner_PaddingExtensionXY.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99999, 1));
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_PaddingExtensionXY.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);

        jSpinner_PaddingExtensionZ.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99999, 1));
        ((NumberFormatter) ((JSpinner.NumberEditor) jSpinner_PaddingExtensionZ.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);

        jLabel_PaddingConstraint.setText("Padding Constraint");

        jComboBox_PaddingConstraintXY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Even", "Power of 2", "Multiple {2,3}", "Multiple {2,3,5}" }));

        jComboBox_PaddingConstraintZ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Even", "Power of 2", "Multiple {2,3}", "Multiple {2,3,5}" }));

        jLabel_PSFNormalization.setText("PSF Normalization");

        jComboBox_PSFNormalization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "10", "1000", "1E+6", "1E+9", "no" }));

        javax.swing.GroupLayout jPanel_DeconvolutionAlgorithmLayout = new javax.swing.GroupLayout(jPanel_DeconvolutionAlgorithm);
        jPanel_DeconvolutionAlgorithm.setLayout(jPanel_DeconvolutionAlgorithmLayout);
        jPanel_DeconvolutionAlgorithmLayout.setHorizontalGroup(
            jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                .addComponent(jTabbedPane_DeconvolutionAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                        .addComponent(jComboBox_DeconvolutionAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator_Deconvolution1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                .addComponent(jLabel_Advanced)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator_Deconvolution2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Controller, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Processing, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                            .addComponent(jLabel_Epsilon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBox_Epsilon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                            .addComponent(jLabel_FFT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBox_FTT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel_Constraint, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Residu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                                    .addGap(5, 5, 5)
                                                    .addComponent(jCheckBox_Residu)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextField_Residu, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jComboBox_Constraint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Preprocessing)
                                    .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                        .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel_PaddingExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel_Apodization, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel_PaddingConstraint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jComboBox_ApodizationXY, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel_LateralXY, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel_AxialZ, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jComboBox_ApodizationZ, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                                .addComponent(jComboBox_PaddingConstraintXY, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox_PaddingConstraintZ, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                                .addComponent(jSpinner_PaddingExtensionXY, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinner_PaddingExtensionZ, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                                        .addComponent(jLabel_PSFNormalization, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jComboBox_PSFNormalization, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPanel_DeconvolutionAlgorithmLayout.setVerticalGroup(
            jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DeconvolutionAlgorithmLayout.createSequentialGroup()
                .addComponent(jComboBox_DeconvolutionAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator_Deconvolution1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTabbedPane_DeconvolutionAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Advanced, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator_Deconvolution2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Controller, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Preprocessing))
                .addGap(0, 0, 0)
                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Constraint)
                    .addComponent(jComboBox_Constraint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Image)
                    .addComponent(jLabel_LateralXY)
                    .addComponent(jLabel_AxialZ))
                .addGap(6, 6, 6)
                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Residu)
                    .addComponent(jTextField_Residu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Apodization)
                    .addComponent(jComboBox_ApodizationXY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_ApodizationZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_Residu))
                .addGap(5, 5, 5)
                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Processing, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PaddingExtension)
                    .addComponent(jSpinner_PaddingExtensionXY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_PaddingExtensionZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_FFT)
                    .addComponent(jComboBox_FTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_PaddingConstraintXY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_PaddingConstraintZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PaddingConstraint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DeconvolutionAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Epsilon)
                    .addComponent(jComboBox_Epsilon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PSFNormalization)
                    .addComponent(jComboBox_PSFNormalization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        for(int i=0; i<jTabbedPane_DeconvolutionAlgorithm.getTabCount(); i++)listDeconvolution.add(jTabbedPane_DeconvolutionAlgorithm.getTitleAt(i));
        jTabbedPane_DeconvolutionAlgorithm.getAccessibleContext().setAccessibleName("");
        jTabbedPane_DeconvolutionAlgorithm.getAccessibleContext().setAccessibleDescription("");
        jLabel_LateralXY.getAccessibleContext().setAccessibleName("");
        jLabel_AxialZ.getAccessibleContext().setAccessibleName("");
        jComboBox_ApodizationXY.getAccessibleContext().setAccessibleName("");
        jComboBox_ApodizationZ.getAccessibleContext().setAccessibleName("");
        jSpinner_PaddingExtensionXY.getAccessibleContext().setAccessibleName("");
        jSpinner_PaddingExtensionZ.getAccessibleContext().setAccessibleName("");
        jComboBox_PaddingConstraintXY.getAccessibleContext().setAccessibleName("");
        jComboBox_PaddingConstraintZ.getAccessibleContext().setAccessibleName("");
        jComboBox_PSFNormalization.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel_DeconvolutionLayout = new javax.swing.GroupLayout(jPanel_Deconvolution);
        jPanel_Deconvolution.setLayout(jPanel_DeconvolutionLayout);
        jPanel_DeconvolutionLayout.setHorizontalGroup(
            jPanel_DeconvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_DeconvolutionAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
        );
        jPanel_DeconvolutionLayout.setVerticalGroup(
            jPanel_DeconvolutionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DeconvolutionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_DeconvolutionAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE))
        );

        jTabbedPanel_Main.addTab("Deconvolution", jPanel_Deconvolution);

        jButton_Save.setText("Save Settings");
        jButton_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveActionPerformed(evt);
            }
        });

        jButton_Load.setText("Load Settings");
        jButton_Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoadActionPerformed(evt);
            }
        });

        jButton_Run.setText("Run");
        jButton_Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RunActionPerformed(evt);
            }
        });

        jPanel_Status0.setBackground(new java.awt.Color(0, 255, 0));
        jPanel_Status0.setMaximumSize(new java.awt.Dimension(12, 12));

        javax.swing.GroupLayout jPanel_Status0Layout = new javax.swing.GroupLayout(jPanel_Status0);
        jPanel_Status0.setLayout(jPanel_Status0Layout);
        jPanel_Status0Layout.setHorizontalGroup(
            jPanel_Status0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel_Status0Layout.setVerticalGroup(
            jPanel_Status0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel_Status1.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel_Status1Layout = new javax.swing.GroupLayout(jPanel_Status1);
        jPanel_Status1.setLayout(jPanel_Status1Layout);
        jPanel_Status1Layout.setHorizontalGroup(
            jPanel_Status1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel_Status1Layout.setVerticalGroup(
            jPanel_Status1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel_Status2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel_Status2Layout = new javax.swing.GroupLayout(jPanel_Status2);
        jPanel_Status2.setLayout(jPanel_Status2Layout);
        jPanel_Status2Layout.setHorizontalGroup(
            jPanel_Status2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel_Status2Layout.setVerticalGroup(
            jPanel_Status2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel_Status3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel_Status3Layout = new javax.swing.GroupLayout(jPanel_Status3);
        jPanel_Status3.setLayout(jPanel_Status3Layout);
        jPanel_Status3Layout.setHorizontalGroup(
            jPanel_Status3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel_Status3Layout.setVerticalGroup(
            jPanel_Status3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jButton_Info.setText("Info");
        jButton_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPanel_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Status0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Status1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Status2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Status3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Load, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_Run, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanel_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Run)
                        .addComponent(jButton_Load)
                        .addComponent(jButton_Save))
                    .addComponent(jButton_Info, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_Status0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_Status1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_Status2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_Status3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jComboBox_PSFCalculateOrNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PSFCalculateOrNotActionPerformed
        jTabbedPane_PSFCalculateOrNot.setSelectedIndex(jComboBox_PSFCalculateOrNot.getSelectedIndex()/2);
        //jTabbedPanel_Main.setEnabledAt(2, !(jComboBox_PSFCalculateOrNot.getSelectedIndex()==2));
        jComboBox_LoadPSP (jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2);
        jCheckBox_DeletePSF.setEnabled(jCheckBox_Delete.isSelected()&&jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2); 
    }//GEN-LAST:event_jComboBox_PSFCalculateOrNotActionPerformed

    private void jCheckBox_DifferentRIOilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DifferentRIOilActionPerformed
        setOilRI_ON(jCheckBox_DifferentRIOil.isSelected());
    }//GEN-LAST:event_jCheckBox_DifferentRIOilActionPerformed

    private void jComboBox_PSFMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PSFMethodActionPerformed
        jTabbedPane_PSFMethod.setSelectedIndex(jComboBox_PSFMethod.getSelectedIndex());        // TODO add your handling code here:
        switch(jTabbedPane_PSFMethod.getSelectedIndex()){
            case 0:
                PSFMethodGL_TV(jCheckBox_DifferentRI_Sample_GL.isSelected());
                break;
            case 1:
                PSFMethodNone();
                break;
            case 2:
                PSFMethodVRIGL(jCheckBox_DifferentRI_Sample0_VRIGL.isSelected(),jCheckBox_DifferentRI_SampleZ_VRIGL.isSelected());
                break;
            case 3:
                PSFMethodNone();
                break;
            case 4:
                PSFMethodGL_TV(jCheckBox_DifferentRI_Sample_TV.isSelected());
                break;
        }
        jLabel_Accuracy.setEnabled(jComboBox_PSFMethod.getSelectedIndex() != 4);
        jComboBox_Accuracy.setEnabled(jComboBox_PSFMethod.getSelectedIndex() != 4);
    }//GEN-LAST:event_jComboBox_PSFMethodActionPerformed

    private void jTextField_NAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NAKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_NAKeyTyped

    private void jTextField_RI_Sample_GLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_Sample_GLKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_RI_Sample_GLKeyTyped

    private void jCheckBox_DifferentRI_Sample_GLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DifferentRI_Sample_GLActionPerformed
        setSampleRI_ON(jCheckBox_DifferentRI_Sample_GL.isSelected());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_DifferentRI_Sample_GLActionPerformed

    private void jTextField_Position_GLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Position_GLKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Position_GLKeyTyped

    private void jTextField_Working_GLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Working_GLKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Working_GLKeyTyped

    private void jTextField_Working_VRIGLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Working_VRIGLKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Working_VRIGLKeyTyped

    private void jTextField_Position_VRIGLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Position_VRIGLKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Position_VRIGLKeyTyped

    private void jTextField_RI_Sample0_VRIGLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_Sample0_VRIGLKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_RI_Sample0_VRIGLKeyTyped

    private void jCheckBox_DifferentRI_Sample0_VRIGLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DifferentRI_Sample0_VRIGLActionPerformed
        setSampleRI_ON(jCheckBox_DifferentRI_Sample0_VRIGL.isSelected());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_DifferentRI_Sample0_VRIGLActionPerformed

    private void jTextField_Working_TVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Working_TVKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Working_TVKeyTyped

    private void jTextField_Position_TVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Position_TVKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Position_TVKeyTyped

    private void jTextField_RI_Sample_TVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_Sample_TVKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_RI_Sample_TVKeyTyped

    private void jCheckBox_DifferentRI_Sample_TVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DifferentRI_Sample_TVActionPerformed
        setSampleRI_ON(jCheckBox_DifferentRI_Sample_TV.isSelected());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_DifferentRI_Sample_TVActionPerformed

    private void jTextField_RI_SampleZ_VRIGLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_SampleZ_VRIGLKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_RI_SampleZ_VRIGLKeyTyped

    private void jCheckBox_DifferentRI_SampleZ_VRIGLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DifferentRI_SampleZ_VRIGLActionPerformed
        setSampleRIZ_ON(jCheckBox_DifferentRI_SampleZ_VRIGL.isSelected());            // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_DifferentRI_SampleZ_VRIGLActionPerformed

    private void jTextField_RI_OilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_OilKeyReleased
        jTextField_Wave_RIOil.setText(jTextField_RI_Oil.getText());          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_RI_OilKeyReleased

    private void jTextField_RI_OilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_OilKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_RI_OilKeyTyped

    private void jTextField_RI_Sample_GLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_Sample_GLKeyReleased
        //jTextField_RI_Sample_GL.setText(jTextField_RI_Sample_GL.getText());
        jTextField_RI_Sample0_VRIGL.setText(jTextField_RI_Sample_GL.getText());
        jTextField_RI_Sample_TV.setText(jTextField_RI_Sample_GL.getText());
        jTextField_Wave_RISample.setText(jTextField_RI_Sample_GL.getText());          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_RI_Sample_GLKeyReleased

    private void jTextField_RI_Sample0_VRIGLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_Sample0_VRIGLKeyReleased
        jTextField_RI_Sample_GL.setText(jTextField_RI_Sample0_VRIGL.getText());
        //jTextField_RI_Sample0_VRIGL.setText(jTextField_RI_Sample0_VRIGL.getText());
        jTextField_RI_Sample_TV.setText(jTextField_RI_Sample0_VRIGL.getText());
        jTextField_Wave_RISample.setText(jTextField_RI_Sample0_VRIGL.getText());          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_RI_Sample0_VRIGLKeyReleased

    private void jTextField_RI_Sample_TVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_Sample_TVKeyReleased
        jTextField_RI_Sample_GL.setText(jTextField_RI_Sample_TV.getText());
        jTextField_RI_Sample0_VRIGL.setText(jTextField_RI_Sample_TV.getText());
        //jTextField_RI_Sample_TV.setText(jTextField_RI_Sample_TV.getText());
        jTextField_Wave_RISample.setText(jTextField_RI_Sample_TV.getText());          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_RI_Sample_TVKeyReleased

    private void jTextField_RI_SampleZ_VRIGLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RI_SampleZ_VRIGLKeyReleased
        jTextField_Wave_RISampleZ.setText(jTextField_RI_SampleZ_VRIGL.getText());// TODO add your handling code here:
    }//GEN-LAST:event_jTextField_RI_SampleZ_VRIGLKeyReleased

    private void jCheckBox_Brightfield8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Brightfield8ActionPerformed
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 ) jTextField_Wavelength8.setEnabled(!jCheckBox_Brightfield8.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI8.setEnabled(!jCheckBox_Brightfield8.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI8.setEnabled(!jCheckBox_Brightfield8.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI8.setEnabled(!jCheckBox_Brightfield8.isSelected());// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Brightfield8ActionPerformed

    private void jCheckBox_Brightfield7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Brightfield7ActionPerformed
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 ) jTextField_Wavelength7.setEnabled(!jCheckBox_Brightfield7.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI7.setEnabled(!jCheckBox_Brightfield7.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI7.setEnabled(!jCheckBox_Brightfield7.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI7.setEnabled(!jCheckBox_Brightfield7.isSelected());// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Brightfield7ActionPerformed

    private void jCheckBox_Brightfield6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Brightfield6ActionPerformed
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 ) jTextField_Wavelength6.setEnabled(!jCheckBox_Brightfield6.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI6.setEnabled(!jCheckBox_Brightfield6.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI6.setEnabled(!jCheckBox_Brightfield6.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI6.setEnabled(!jCheckBox_Brightfield6.isSelected());// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Brightfield6ActionPerformed

    private void jCheckBox_Brightfield5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Brightfield5ActionPerformed
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 ) jTextField_Wavelength5.setEnabled(!jCheckBox_Brightfield5.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI5.setEnabled(!jCheckBox_Brightfield5.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI5.setEnabled(!jCheckBox_Brightfield5.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI5.setEnabled(!jCheckBox_Brightfield5.isSelected());// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Brightfield5ActionPerformed

    private void jCheckBox_Brightfield4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Brightfield4ActionPerformed
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 ) jTextField_Wavelength4.setEnabled(!jCheckBox_Brightfield4.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI4.setEnabled(!jCheckBox_Brightfield4.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI4.setEnabled(!jCheckBox_Brightfield4.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI4.setEnabled(!jCheckBox_Brightfield4.isSelected());// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Brightfield4ActionPerformed

    private void jCheckBox_Brightfield3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Brightfield3ActionPerformed
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 ) jTextField_Wavelength3.setEnabled(!jCheckBox_Brightfield3.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI3.setEnabled(!jCheckBox_Brightfield3.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI3.setEnabled(!jCheckBox_Brightfield3.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI3.setEnabled(!jCheckBox_Brightfield3.isSelected());// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Brightfield3ActionPerformed

    private void jCheckBox_Brightfield2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Brightfield2ActionPerformed
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 ) jTextField_Wavelength2.setEnabled(!jCheckBox_Brightfield2.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI2.setEnabled(!jCheckBox_Brightfield2.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI2.setEnabled(!jCheckBox_Brightfield2.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI2.setEnabled(!jCheckBox_Brightfield2.isSelected());// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Brightfield2ActionPerformed

    private void jCheckBox_Brightfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Brightfield1ActionPerformed
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 ) jTextField_Wavelength1.setEnabled(!jCheckBox_Brightfield1.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRIOil.isSelected() ) jTextField_OilRI1.setEnabled(!jCheckBox_Brightfield1.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISample.isSelected() && jCheckBox_Wave_DifferentRISample.isEnabled() ) jTextField_SampleRI1.setEnabled(!jCheckBox_Brightfield1.isSelected());
        if(jComboBox_PSFCalculateOrNot.getSelectedIndex()!=2 &&  jCheckBox_Wave_DifferentRISampleZ.isSelected() && jCheckBox_Wave_DifferentRISampleZ.isEnabled() ) jTextField_SampleZRI1.setEnabled(!jCheckBox_Brightfield1.isSelected());
    }//GEN-LAST:event_jCheckBox_Brightfield1ActionPerformed

    private void jTextField_SampleZRI8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleZRI8KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleZRI8KeyTyped

    private void jTextField_SampleZRI7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleZRI7KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleZRI7KeyTyped

    private void jTextField_SampleZRI6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleZRI6KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleZRI6KeyTyped

    private void jTextField_SampleZRI5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleZRI5KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleZRI5KeyTyped

    private void jTextField_SampleZRI4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleZRI4KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleZRI4KeyTyped

    private void jTextField_SampleZRI3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleZRI3KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleZRI3KeyTyped

    private void jTextField_SampleZRI2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleZRI2KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleZRI2KeyTyped

    private void jTextField_SampleZRI1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleZRI1KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleZRI1KeyTyped

    private void jTextField_SampleRI8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleRI8KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleRI8KeyTyped

    private void jTextField_SampleRI7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleRI7KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleRI7KeyTyped

    private void jTextField_SampleRI6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleRI6KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleRI6KeyTyped

    private void jTextField_SampleRI5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleRI5KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleRI5KeyTyped

    private void jTextField_SampleRI4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleRI4KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleRI4KeyTyped

    private void jTextField_SampleRI3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleRI3KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleRI3KeyTyped

    private void jTextField_SampleRI2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleRI2KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleRI2KeyTyped

    private void jTextField_SampleRI1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SampleRI1KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_SampleRI1KeyTyped

    private void jTextField_OilRI8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OilRI8KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_OilRI8KeyTyped

    private void jTextField_OilRI7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OilRI7KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_OilRI7KeyTyped

    private void jTextField_OilRI6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OilRI6KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_OilRI6KeyTyped

    private void jTextField_OilRI5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OilRI5KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_OilRI5KeyTyped

    private void jTextField_OilRI4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OilRI4KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_OilRI4KeyTyped

    private void jTextField_OilRI3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OilRI3KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_OilRI3KeyTyped

    private void jTextField_OilRI2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OilRI2KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_OilRI2KeyTyped

    private void jTextField_OilRI1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OilRI1KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_OilRI1KeyTyped

    private void jTextField_Wavelength8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wavelength8KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wavelength8KeyTyped

    private void jTextField_Wavelength7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wavelength7KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wavelength7KeyTyped

    private void jTextField_Wavelength6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wavelength6KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wavelength6KeyTyped

    private void jTextField_Wavelength5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wavelength5KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wavelength5KeyTyped

    private void jTextField_Wavelength4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wavelength4KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wavelength4KeyTyped

    private void jTextField_Wavelength3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wavelength3KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wavelength3KeyTyped

    private void jTextField_Wavelength2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wavelength2KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wavelength2KeyTyped

    private void jTextField_Wavelength1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wavelength1KeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wavelength1KeyTyped

    private void jCheckBox_Wave_DifferentRISampleZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Wave_DifferentRISampleZActionPerformed
        setSampleRIZ_ON(jCheckBox_Wave_DifferentRISampleZ.isSelected());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Wave_DifferentRISampleZActionPerformed

    private void jCheckBox_Wave_DifferentRISampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Wave_DifferentRISampleActionPerformed
        setSampleRI_ON(jCheckBox_Wave_DifferentRISample.isSelected());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Wave_DifferentRISampleActionPerformed

    private void jCheckBox_Wave_DifferentRIOilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_Wave_DifferentRIOilActionPerformed
        setOilRI_ON(jCheckBox_Wave_DifferentRIOil.isSelected());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_Wave_DifferentRIOilActionPerformed

    private void jTextField_Wave_RISampleZKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wave_RISampleZKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wave_RISampleZKeyTyped

    private void jTextField_Wave_RISampleZKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wave_RISampleZKeyReleased
        jTextField_RI_SampleZ_VRIGL.setText(jTextField_Wave_RISampleZ.getText());// TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Wave_RISampleZKeyReleased

    private void jTextField_Wave_RISampleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wave_RISampleKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_Wave_RISampleKeyTyped

    private void jTextField_Wave_RISampleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wave_RISampleKeyReleased
        jTextField_RI_Sample_GL.setText(jTextField_Wave_RISample.getText());
        jTextField_RI_Sample0_VRIGL.setText(jTextField_Wave_RISample.getText());
        jTextField_RI_Sample_TV.setText(jTextField_Wave_RISample.getText());
        //jTextField_Wave_RISample.setText(jTextField_Wave_RISample.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Wave_RISampleKeyReleased

    private void jTextField_Wave_RIOilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wave_RIOilKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Wave_RIOilKeyTyped

    private void jTextField_Wave_RIOilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Wave_RIOilKeyReleased
        jTextField_RI_Oil.setText(jTextField_Wave_RIOil.getText());              // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Wave_RIOilKeyReleased

    private void jComboBox_ChannelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ChannelNumberActionPerformed
        activateChannel(jComboBox_ChannelNumber.getSelectedIndex());
    }//GEN-LAST:event_jComboBox_ChannelNumberActionPerformed

    private void jButton_InputPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InputPathActionPerformed
        chooser = new JFileChooser();
        workingPath=jTextField_InputPath.getText();
        while(!new File(workingPath).exists()){
            if(workingPath.lastIndexOf("\\")==-1) break;
            else workingPath=workingPath.substring(0, workingPath.lastIndexOf("\\"));
        }
        chooser.setCurrentDirectory(new File(workingPath));
        chooser.setDialogTitle("Select input directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showDialog(jPanel_IOPaths,"Select") == JFileChooser.APPROVE_OPTION){
            jTextField_InputPath.setText(chooser.getSelectedFile().toString());
            if(jCheckBox_OutputPath.isSelected()) jTextField_OutputPath.setText(chooser.getSelectedFile().toString()+"\\Output");
            if(jCheckBox_IntermediatePath.isSelected()) jTextField_IntermediatePath.setText(chooser.getSelectedFile().toString()+"\\Intermediate");
            if(jCheckBox_LogPath.isSelected()) jTextField_LogPath.setText(chooser.getSelectedFile().toString()+"\\Log");
        }
    }//GEN-LAST:event_jButton_InputPathActionPerformed

    private void jButton_OutputPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OutputPathActionPerformed
        chooser = new JFileChooser();         
        workingPath=jTextField_OutputPath.getText();
        while(!new File(workingPath).exists()){
            if(workingPath.lastIndexOf("\\")==-1) break;
            else workingPath=workingPath.substring(0, workingPath.lastIndexOf("\\"));
        }
        chooser.setCurrentDirectory(new File(workingPath));
        chooser.setDialogTitle("Select output directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showDialog(jPanel_IOPaths,"Select") == JFileChooser.APPROVE_OPTION){
            jTextField_OutputPath.setText(chooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jButton_OutputPathActionPerformed

    private void jCheckBox_OutputPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_OutputPathActionPerformed
        jTextField_OutputPath.setEnabled(!jCheckBox_OutputPath.isSelected());     
        jButton_OutputPath.setEnabled(!jCheckBox_OutputPath.isSelected());
    }//GEN-LAST:event_jCheckBox_OutputPathActionPerformed

    private void jButton_LogPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogPathActionPerformed
        chooser = new JFileChooser(); 
        workingPath=jTextField_LogPath.getText();
        while(!new File(workingPath).exists()){
            if(workingPath.lastIndexOf("\\")==-1) break;
            else workingPath=workingPath.substring(0, workingPath.lastIndexOf("\\"));
        }
        chooser.setCurrentDirectory(new File(workingPath));
        chooser.setDialogTitle("Select log directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showDialog(jPanel_IOPaths,"Select") == JFileChooser.APPROVE_OPTION){
            jTextField_LogPath.setText(chooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jButton_LogPathActionPerformed

    private void jCheckBox_LogPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_LogPathActionPerformed
        jTextField_LogPath.setEnabled(!jCheckBox_LogPath.isSelected());     
        jButton_LogPath.setEnabled(!jCheckBox_LogPath.isSelected());
    }//GEN-LAST:event_jCheckBox_LogPathActionPerformed

    private void jButton_PSFPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PSFPathActionPerformed
        chooser = new JFileChooser();
        workingPath=jTextField_PSFPath.getText();
        while(!new File(workingPath).exists()){
            if(workingPath.lastIndexOf("\\")==-1) break;
            else workingPath=workingPath.substring(0, workingPath.lastIndexOf("\\"));
        }
        chooser.setCurrentDirectory(new File(workingPath));
        chooser.setDialogTitle("Select PSF file");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showDialog(jPanel_PSF,"Select") == JFileChooser.APPROVE_OPTION){
            jTextField_PSFPath.setText(chooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jButton_PSFPathActionPerformed

    private void jCheckBox_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DeleteActionPerformed
        jCheckBox_DeletePSF.setEnabled(jCheckBox_Delete.isSelected()&&!(jComboBox_PSFCalculateOrNot.getSelectedIndex()==2));          
        jCheckBox_DeleteLog.setEnabled(jCheckBox_Delete.isSelected());          // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_DeleteActionPerformed

    private void jTabbedPanel_MainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPanel_MainStateChanged
        switch(jTabbedPanel_Main.getSelectedIndex()){
            case 1:
                jPanel_Status1.setBackground(Color.GREEN);
                break;
            case 2:
                jPanel_Status2.setBackground(Color.GREEN);
                break;
            case 3:
                jPanel_Status3.setBackground(Color.GREEN);
                break;
        }

    }//GEN-LAST:event_jTabbedPanel_MainStateChanged

    private void jCheckBox_ResiduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_ResiduActionPerformed
        jTextField_Residu.setEnabled(jCheckBox_Residu.isSelected());
    }//GEN-LAST:event_jCheckBox_ResiduActionPerformed

    private void jSpinner_VC_StepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_VC_StepStateChanged
        setStep(jSpinner_VC_Step.getValue());
    }//GEN-LAST:event_jSpinner_VC_StepStateChanged

    private void jSpinner_VC_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_VC_IterationsStateChanged
        setNIterations(jSpinner_VC_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_VC_IterationsStateChanged

    private void jSpinner_ICTM_StepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_ICTM_StepStateChanged
        setStep(jSpinner_ICTM_Step.getValue());
    }//GEN-LAST:event_jSpinner_ICTM_StepStateChanged

    private void jSpinner_ICTM_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_ICTM_IterationsStateChanged
        setNIterations(jSpinner_ICTM_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_ICTM_IterationsStateChanged

    private void jTextField_ICTM_RegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ICTM_RegKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE || evt.getKeyChar()== KeyEvent.VK_E || evt.getKeyChar() == "e".charAt(0))) evt.consume();
    }//GEN-LAST:event_jTextField_ICTM_RegKeyTyped

    private void jTextField_ICTM_RegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ICTM_RegKeyReleased
        setReg ("ICTMf",(int)(Math.log10(Double.parseDouble(jTextField_ICTM_Reg.getText()))*1000));
    }//GEN-LAST:event_jTextField_ICTM_RegKeyReleased

    private void jSlider_ICTM_RegMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_ICTM_RegMouseReleased
        setReg ("ICTMs",jSlider_ICTM_Reg.getValue());
    }//GEN-LAST:event_jSlider_ICTM_RegMouseReleased

    private void jSlider_ICTM_RegMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_ICTM_RegMouseDragged
        setReg ("ICTMs",jSlider_ICTM_Reg.getValue());
    }//GEN-LAST:event_jSlider_ICTM_RegMouseDragged

    private void jSpinner_TM_StepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_TM_StepStateChanged
        setStep(jSpinner_TM_Step.getValue());
    }//GEN-LAST:event_jSpinner_TM_StepStateChanged

    private void jSpinner_TM_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_TM_IterationsStateChanged
        setNIterations(jSpinner_TM_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_TM_IterationsStateChanged

    private void jTextField_TM_RegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TM_RegKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE || evt.getKeyChar()== KeyEvent.VK_E || evt.getKeyChar() == "e".charAt(0))) evt.consume();
    }//GEN-LAST:event_jTextField_TM_RegKeyTyped

    private void jTextField_TM_RegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TM_RegKeyReleased
        setReg ("TMf",(int)(Math.log10(Double.parseDouble(jTextField_TM_Reg.getText()))*1000));
    }//GEN-LAST:event_jTextField_TM_RegKeyReleased

    private void jSlider_TM_RegMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_TM_RegMouseReleased
        setReg ("TMs",jSlider_TM_Reg.getValue());
    }//GEN-LAST:event_jSlider_TM_RegMouseReleased

    private void jSlider_TM_RegMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_TM_RegMouseDragged
        setReg ("TMs",jSlider_TM_Reg.getValue());
    }//GEN-LAST:event_jSlider_TM_RegMouseDragged

    private void jSpinner_RLTV_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_RLTV_IterationsStateChanged
        setNIterations(jSpinner_RLTV_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_RLTV_IterationsStateChanged

    private void jTextField_RLTV_RegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RLTV_RegKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE || evt.getKeyChar()== KeyEvent.VK_E || evt.getKeyChar() == "e".charAt(0))) evt.consume();
    }//GEN-LAST:event_jTextField_RLTV_RegKeyTyped

    private void jTextField_RLTV_RegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RLTV_RegKeyReleased
        setReg ("RLTVf",(int)(Math.log10(Double.parseDouble(jTextField_RLTV_Reg.getText()))*1000));
    }//GEN-LAST:event_jTextField_RLTV_RegKeyReleased

    private void jSlider_RLTV_RegMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_RLTV_RegMouseReleased
        setReg ("RLTVs",jSlider_RLTV_Reg.getValue());
    }//GEN-LAST:event_jSlider_RLTV_RegMouseReleased

    private void jSlider_RLTV_RegMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_RLTV_RegMouseDragged
        setReg ("RLTVs",jSlider_RLTV_Reg.getValue());
    }//GEN-LAST:event_jSlider_RLTV_RegMouseDragged

    private void jSpinner_RL_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_RL_IterationsStateChanged
        setNIterations(jSpinner_RL_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_RL_IterationsStateChanged

    private void jSpinner_BVLS_StepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_BVLS_StepStateChanged
        setStep(jSpinner_BVLS_Step.getValue());
    }//GEN-LAST:event_jSpinner_BVLS_StepStateChanged

    private void jSpinner_BVLS_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_BVLS_IterationsStateChanged
        setNIterations(jSpinner_BVLS_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_BVLS_IterationsStateChanged

    private void jSpinner_NNLS_StepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_NNLS_StepStateChanged
        setStep(jSpinner_NNLS_Step.getValue());
    }//GEN-LAST:event_jSpinner_NNLS_StepStateChanged

    private void jSpinner_NNLS_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_NNLS_IterationsStateChanged
        setNIterations(jSpinner_NNLS_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_NNLS_IterationsStateChanged

    private void jSpinner_LW_StepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_LW_StepStateChanged
        setStep(jSpinner_LW_Step.getValue());
    }//GEN-LAST:event_jSpinner_LW_StepStateChanged

    private void jSpinner_LW_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_LW_IterationsStateChanged
        setNIterations(jSpinner_LW_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_LW_IterationsStateChanged

    private void jComboBox_ISTA_ScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ISTA_ScaleActionPerformed
        setScale(jComboBox_ISTA_Scale.getSelectedItem());
    }//GEN-LAST:event_jComboBox_ISTA_ScaleActionPerformed

    private void jComboBox_ISTA_WaveletsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ISTA_WaveletsActionPerformed
        setWavelets(jComboBox_ISTA_Wavelets.getSelectedItem());
    }//GEN-LAST:event_jComboBox_ISTA_WaveletsActionPerformed

    private void jSpinner_ISTA_StepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_ISTA_StepStateChanged
        setStep(jSpinner_ISTA_Step.getValue());
    }//GEN-LAST:event_jSpinner_ISTA_StepStateChanged

    private void jSpinner_ISTA_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_ISTA_IterationsStateChanged
        setNIterations(jSpinner_ISTA_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_ISTA_IterationsStateChanged

    private void jTextField_ISTA_RegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ISTA_RegKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE || evt.getKeyChar()== KeyEvent.VK_E || evt.getKeyChar() == "e".charAt(0))) evt.consume();
    }//GEN-LAST:event_jTextField_ISTA_RegKeyTyped

    private void jTextField_ISTA_RegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ISTA_RegKeyReleased
        setReg ("ISTAf",(int)(Math.log10(Double.parseDouble(jTextField_ISTA_Reg.getText()))*1000));
    }//GEN-LAST:event_jTextField_ISTA_RegKeyReleased

    private void jSlider_ISTA_RegMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_ISTA_RegMouseReleased
        setReg ("ISTAs",jSlider_ISTA_Reg.getValue());
    }//GEN-LAST:event_jSlider_ISTA_RegMouseReleased

    private void jSlider_ISTA_RegMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_ISTA_RegMouseDragged
        setReg ("ISTAs",jSlider_ISTA_Reg.getValue());
    }//GEN-LAST:event_jSlider_ISTA_RegMouseDragged

    private void jComboBox_FISTA_ScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_FISTA_ScaleActionPerformed
        setScale(jComboBox_FISTA_Scale.getSelectedItem());
    }//GEN-LAST:event_jComboBox_FISTA_ScaleActionPerformed

    private void jComboBox_FISTA_WaveletsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_FISTA_WaveletsActionPerformed
        setWavelets(jComboBox_FISTA_Wavelets.getSelectedItem());
    }//GEN-LAST:event_jComboBox_FISTA_WaveletsActionPerformed

    private void jSpinner_FISTA_StepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_FISTA_StepStateChanged
        setStep(jSpinner_FISTA_Step.getValue());
    }//GEN-LAST:event_jSpinner_FISTA_StepStateChanged

    private void jSpinner_FISTA_IterationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_FISTA_IterationsStateChanged
        setNIterations(jSpinner_FISTA_Iterations.getValue());
    }//GEN-LAST:event_jSpinner_FISTA_IterationsStateChanged

    private void jTextField_FISTA_RegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_FISTA_RegKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE || evt.getKeyChar()== KeyEvent.VK_E || evt.getKeyChar() == "e".charAt(0))) evt.consume();
    }//GEN-LAST:event_jTextField_FISTA_RegKeyTyped

    private void jTextField_FISTA_RegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_FISTA_RegKeyReleased
        setReg ("FISTAf",(int)(Math.log10(Double.parseDouble(jTextField_FISTA_Reg.getText()))*1000));
    }//GEN-LAST:event_jTextField_FISTA_RegKeyReleased

    private void jSlider_FISTA_RegMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_FISTA_RegMouseReleased
        setReg ("FISTAs",jSlider_FISTA_Reg.getValue());       // TODO add your handling code here:
    }//GEN-LAST:event_jSlider_FISTA_RegMouseReleased

    private void jSlider_FISTA_RegMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_FISTA_RegMouseDragged
        setReg ("FISTAs",jSlider_FISTA_Reg.getValue());
    }//GEN-LAST:event_jSlider_FISTA_RegMouseDragged

    private void jTextField_TRIF_RegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TRIF_RegKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE || evt.getKeyChar()== KeyEvent.VK_E || evt.getKeyChar() == "e".charAt(0))) evt.consume();
    }//GEN-LAST:event_jTextField_TRIF_RegKeyTyped

    private void jTextField_TRIF_RegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TRIF_RegKeyReleased
        setReg ("TRIFf",(int)(Math.log10(Double.parseDouble(jTextField_TRIF_Reg.getText()))*1000));
    }//GEN-LAST:event_jTextField_TRIF_RegKeyReleased

    private void jSlider_TRIF_RegMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_TRIF_RegMouseReleased
        setReg ("TRIFs",jSlider_TRIF_Reg.getValue());
    }//GEN-LAST:event_jSlider_TRIF_RegMouseReleased

    private void jSlider_TRIF_RegMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_TRIF_RegMouseDragged
        setReg ("TRIFs",jSlider_TRIF_Reg.getValue());
    }//GEN-LAST:event_jSlider_TRIF_RegMouseDragged

    private void jTextField_RIF_RegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RIF_RegKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE || evt.getKeyChar()== KeyEvent.VK_E || evt.getKeyChar() == "e".charAt(0))) evt.consume();
    }//GEN-LAST:event_jTextField_RIF_RegKeyTyped

    private void jTextField_RIF_RegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RIF_RegKeyReleased
        setReg ("RIFf",(int)(Math.log10(Double.parseDouble(jTextField_RIF_Reg.getText()))*1000));
    }//GEN-LAST:event_jTextField_RIF_RegKeyReleased

    private void jSlider_RIF_RegMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_RIF_RegMouseReleased
        setReg ("RIFs",jSlider_RIF_Reg.getValue());
    }//GEN-LAST:event_jSlider_RIF_RegMouseReleased

    private void jSlider_RIF_RegMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_RIF_RegMouseDragged
        setReg ("RIFs",jSlider_RIF_Reg.getValue());
    }//GEN-LAST:event_jSlider_RIF_RegMouseDragged

    private void jComboBox_DeconvolutionAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DeconvolutionAlgorithmActionPerformed
        jTabbedPane_DeconvolutionAlgorithm.setSelectedIndex(jComboBox_DeconvolutionAlgorithm.getSelectedIndex());        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_DeconvolutionAlgorithmActionPerformed

    private void jTextField_ResiduKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ResiduKeyTyped
        if(!(Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_PERIOD || evt.getKeyChar()== KeyEvent.VK_DELETE)) evt.consume();
    }//GEN-LAST:event_jTextField_ResiduKeyTyped

    private void jTextField_Working_GLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Working_GLKeyReleased
        jTextField_Working_VRIGL.setText(jTextField_Working_GL.getText());
        jTextField_Working_TV.setText(jTextField_Working_GL.getText());
    }//GEN-LAST:event_jTextField_Working_GLKeyReleased

    private void jTextField_Working_VRIGLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Working_VRIGLKeyReleased
        jTextField_Working_GL.setText(jTextField_Working_VRIGL.getText());
        jTextField_Working_TV.setText(jTextField_Working_VRIGL.getText()); 
    }//GEN-LAST:event_jTextField_Working_VRIGLKeyReleased

    private void jTextField_Working_TVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Working_TVKeyReleased
        jTextField_Working_GL.setText(jTextField_Working_TV.getText());
        jTextField_Working_VRIGL.setText(jTextField_Working_TV.getText()); 
    }//GEN-LAST:event_jTextField_Working_TVKeyReleased

    private void jTextField_Position_GLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Position_GLKeyReleased
        jTextField_Position_VRIGL.setText(jTextField_Position_GL.getText());
        jTextField_Position_TV.setText(jTextField_Position_GL.getText()); 
    }//GEN-LAST:event_jTextField_Position_GLKeyReleased

    private void jTextField_Position_VRIGLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Position_VRIGLKeyReleased
        jTextField_Position_GL.setText(jTextField_Position_VRIGL.getText());
        jTextField_Position_TV.setText(jTextField_Position_VRIGL.getText());
    }//GEN-LAST:event_jTextField_Position_VRIGLKeyReleased

    private void jTextField_Position_TVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Position_TVKeyReleased
        jTextField_Position_GL.setText(jTextField_Position_TV.getText());
        jTextField_Position_VRIGL.setText(jTextField_Position_TV.getText());
    }//GEN-LAST:event_jTextField_Position_TVKeyReleased

    private void jButton_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InfoActionPerformed
        
        //Info.show();        // TODO add your handling code here:
        //int a = 
        
        //jTabbedPane_PSFMethod.get
        //System.out.println(a);
        //System.out.println(listPSF.get(0));
        //for(int i=0; i<jTabbedPane_PSFMethod.getTabCount(); i++)listPSF.add(jTabbedPane_PSFMethod.getTitleAt(i));
        //System.out.println(listPSF.size());
        Info.run();
        
        try {
            readSettings(settings);
            IO.saveSettings(".\\BDsettings.dat", settings);
        } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_InfoActionPerformed

    private void jTextField_InputPathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_InputPathKeyReleased
        if(jCheckBox_OutputPath.isSelected())jTextField_OutputPath.setText(jTextField_InputPath.getText()+"\\Output");
        if(jCheckBox_IntermediatePath.isSelected())jTextField_IntermediatePath.setText(jTextField_InputPath.getText()+"\\Intermediate");
        if(jCheckBox_LogPath.isSelected())jTextField_LogPath.setText(jTextField_InputPath.getText()+"\\Log");
    }//GEN-LAST:event_jTextField_InputPathKeyReleased

    private void jCheckBox_IntermediatePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_IntermediatePathActionPerformed
        jTextField_IntermediatePath.setEnabled(!jCheckBox_IntermediatePath.isSelected());     
        jButton_IntermediatePath.setEnabled(!jCheckBox_IntermediatePath.isSelected());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_IntermediatePathActionPerformed

    private void jButton_IntermediatePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IntermediatePathActionPerformed
        chooser = new JFileChooser();         
        workingPath=jTextField_IntermediatePath.getText();
        while(!new File(workingPath).exists()){
            if(workingPath.lastIndexOf("\\")==-1) break;
            else workingPath=workingPath.substring(0, workingPath.lastIndexOf("\\"));
        }
        chooser.setCurrentDirectory(new File(workingPath));
        chooser.setDialogTitle("Select intermediate directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showDialog(jPanel_IOPaths,"Select") == JFileChooser.APPROVE_OPTION){
            jTextField_IntermediatePath.setText(chooser.getSelectedFile().toString());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_IntermediatePathActionPerformed

    private void jButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveActionPerformed
        readSettings(settings);
                
        if(settings.loadSavePath==null)workingPath=System.getProperty("user.home")+"\\BDsettings.dat";
        else workingPath = settings.loadSavePath;
        
        chooser = new JFileChooser(){
            @Override
            public void approveSelection(){
                if(getSelectedFile().exists() && getDialogType() == SAVE_DIALOG){
                    switch(JOptionPane.showConfirmDialog(this,"The file exists, overwrite?","Existing file",JOptionPane.YES_NO_CANCEL_OPTION)){
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            return;
                        case JOptionPane.NO_OPTION:
                            return;
                        case JOptionPane.CLOSED_OPTION:
                            return;
                        case JOptionPane.CANCEL_OPTION:
                            cancelSelection();
                            return;
                   }
                }
                super.approveSelection();
            }        
        };
        
        chooser.setDialogTitle("Select save file");
        chooser.setSelectedFile(new File(workingPath));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if (chooser.showSaveDialog(jTabbedPanel_Main) == JFileChooser.APPROVE_OPTION){
            workingPath=chooser.getSelectedFile().toString();
          
            try {
                IO.saveSettings (workingPath, settings);
                JOptionPane.showMessageDialog(this,"Settings saved","Saved",JOptionPane.INFORMATION_MESSAGE);
                settings.loadSavePath = workingPath;
            } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            IO.saveSettings(".\\BDsettings.dat", settings);
        } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_SaveActionPerformed

    private void jButton_LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoadActionPerformed
        if(settings.loadSavePath==null)workingPath=System.getProperty("user.home")+"\\BDsettings.dat";
        else workingPath = settings.loadSavePath;
        chooser = new JFileChooser();
        chooser.setDialogTitle("Select save file");
        chooser.setSelectedFile(new File(workingPath));
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showDialog(jTabbedPanel_Main,"Load") == JFileChooser.APPROVE_OPTION){
            workingPath=chooser.getSelectedFile().toString();
            if(new File(workingPath).exists()){
                try {
                    IO.loadSettings (workingPath, settings);
                    loadSettings(settings);
                    jPanel_Status1.setBackground(Color.GREEN);
                    jPanel_Status2.setBackground(Color.GREEN);
                    jPanel_Status3.setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(this,"Settings loaded","Loaded",JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalArgumentException | IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }   
                
            }else{
                JOptionPane.showMessageDialog(this,"File does not exist!","File does not exist!",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        try {
            readSettings(settings);
            IO.saveSettings(".\\BDsettings.dat", settings);
        } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_LoadActionPerformed

    private void jButton_RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RunActionPerformed
        try {
            readSettings(settings);
            IO.saveSettings(".\\BDsettings.dat", settings);
        } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Run.run(settings,extensions,jButton_Run);
    }//GEN-LAST:event_jButton_RunActionPerformed

    private void jTabbedPanel_MainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPanel_MainMouseClicked
        try {
            readSettings(settings);
            IO.saveSettings(".\\BDsettings.dat", settings);
        } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTabbedPanel_MainMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel Residu;
    private static javax.swing.JButton jButton_Info;
    private static javax.swing.JButton jButton_InputPath;
    private static javax.swing.JButton jButton_IntermediatePath;
    private static javax.swing.JButton jButton_Load;
    private static javax.swing.JButton jButton_LogPath;
    private static javax.swing.JButton jButton_OutputPath;
    private static javax.swing.JButton jButton_PSFPath;
    private static javax.swing.JButton jButton_Run;
    private static javax.swing.JButton jButton_Save;
    private static javax.swing.JCheckBox jCheckBox_Brightfield1;
    private static javax.swing.JCheckBox jCheckBox_Brightfield2;
    private static javax.swing.JCheckBox jCheckBox_Brightfield3;
    private static javax.swing.JCheckBox jCheckBox_Brightfield4;
    private static javax.swing.JCheckBox jCheckBox_Brightfield5;
    private static javax.swing.JCheckBox jCheckBox_Brightfield6;
    private static javax.swing.JCheckBox jCheckBox_Brightfield7;
    private static javax.swing.JCheckBox jCheckBox_Brightfield8;
    private static javax.swing.JCheckBox jCheckBox_Delete;
    private static javax.swing.JCheckBox jCheckBox_DeleteLog;
    private static javax.swing.JCheckBox jCheckBox_DeletePSF;
    private static javax.swing.JCheckBox jCheckBox_DifferentRIOil;
    private static javax.swing.JCheckBox jCheckBox_DifferentRI_Sample0_VRIGL;
    private static javax.swing.JCheckBox jCheckBox_DifferentRI_SampleZ_VRIGL;
    private static javax.swing.JCheckBox jCheckBox_DifferentRI_Sample_GL;
    private static javax.swing.JCheckBox jCheckBox_DifferentRI_Sample_TV;
    private static javax.swing.JCheckBox jCheckBox_IntermediatePath;
    private static javax.swing.JCheckBox jCheckBox_LogPath;
    private static javax.swing.JCheckBox jCheckBox_OutputPath;
    private static javax.swing.JCheckBox jCheckBox_Residu;
    private static javax.swing.JCheckBox jCheckBox_Wave_DifferentRIOil;
    private static javax.swing.JCheckBox jCheckBox_Wave_DifferentRISample;
    private static javax.swing.JCheckBox jCheckBox_Wave_DifferentRISampleZ;
    private static javax.swing.JComboBox<String> jComboBox_Accuracy;
    private static javax.swing.JComboBox<String> jComboBox_ApodizationXY;
    private static javax.swing.JComboBox<String> jComboBox_ApodizationZ;
    private static javax.swing.JComboBox<String> jComboBox_Bit;
    private static javax.swing.JComboBox<String> jComboBox_ChannelNumber;
    private static javax.swing.JComboBox<String> jComboBox_Constraint;
    private static javax.swing.JComboBox<String> jComboBox_DeconvolutionAlgorithm;
    private static javax.swing.JComboBox<String> jComboBox_Epsilon;
    private static javax.swing.JComboBox<String> jComboBox_FISTA_Scale;
    private static javax.swing.JComboBox<String> jComboBox_FISTA_Wavelets;
    private static javax.swing.JComboBox<String> jComboBox_FTT;
    private static javax.swing.JComboBox<String> jComboBox_ISTA_Scale;
    private static javax.swing.JComboBox<String> jComboBox_ISTA_Wavelets;
    private static javax.swing.JComboBox<String> jComboBox_PSFCalculateOrNot;
    private static javax.swing.JComboBox<String> jComboBox_PSFMethod;
    private static javax.swing.JComboBox<String> jComboBox_PSFNormalization;
    private static javax.swing.JComboBox<String> jComboBox_PaddingConstraintXY;
    private static javax.swing.JComboBox<String> jComboBox_PaddingConstraintZ;
    private static javax.swing.JComboBox<String> jComboBox_RIVariation;
    private static javax.swing.JLabel jLabel_Accuracy;
    private static javax.swing.JLabel jLabel_Advanced;
    private static javax.swing.JLabel jLabel_Apodization;
    private static javax.swing.JLabel jLabel_AxialZ;
    private static javax.swing.JLabel jLabel_BVLS;
    private static javax.swing.JLabel jLabel_BVLS_Iterations;
    private static javax.swing.JLabel jLabel_BVLS_Step;
    private static javax.swing.JLabel jLabel_BW;
    private static javax.swing.JLabel jLabel_Bit;
    private static javax.swing.JLabel jLabel_Brightfield;
    private static javax.swing.JLabel jLabel_Channel1;
    private static javax.swing.JLabel jLabel_Channel2;
    private static javax.swing.JLabel jLabel_Channel3;
    private static javax.swing.JLabel jLabel_Channel4;
    private static javax.swing.JLabel jLabel_Channel5;
    private static javax.swing.JLabel jLabel_Channel6;
    private static javax.swing.JLabel jLabel_Channel7;
    private static javax.swing.JLabel jLabel_Channel8;
    private static javax.swing.JLabel jLabel_ChannelNumber;
    private static javax.swing.JLabel jLabel_Constraint;
    private static javax.swing.JLabel jLabel_Controller;
    private static javax.swing.JLabel jLabel_DIV;
    private static javax.swing.JLabel jLabel_Epsilon;
    private static javax.swing.JLabel jLabel_FFT;
    private static javax.swing.JLabel jLabel_FISTA;
    private static javax.swing.JLabel jLabel_FISTA_Iterations;
    private static javax.swing.JLabel jLabel_FISTA_Reg;
    private static javax.swing.JLabel jLabel_FISTA_Scale;
    private static javax.swing.JLabel jLabel_FISTA_Step;
    private static javax.swing.JLabel jLabel_FISTA_Wavelets;
    private static javax.swing.JLabel jLabel_ICTM;
    private static javax.swing.JLabel jLabel_ICTM_Iterations;
    private static javax.swing.JLabel jLabel_ICTM_Reg;
    private static javax.swing.JLabel jLabel_ICTM_Step;
    private static javax.swing.JLabel jLabel_ISTA;
    private static javax.swing.JLabel jLabel_ISTA_Iterations;
    private static javax.swing.JLabel jLabel_ISTA_Reg;
    private static javax.swing.JLabel jLabel_ISTA_Scale;
    private static javax.swing.JLabel jLabel_ISTA_Step;
    private static javax.swing.JLabel jLabel_ISTA_Wavelets;
    private static javax.swing.JLabel jLabel_Image;
    private static javax.swing.JLabel jLabel_InputPath;
    private static javax.swing.JLabel jLabel_IntermediatePath;
    private static javax.swing.JLabel jLabel_LW;
    private static javax.swing.JLabel jLabel_LW_Iterations;
    private static javax.swing.JLabel jLabel_LW_Step;
    private static javax.swing.JLabel jLabel_LateralXY;
    private static javax.swing.JLabel jLabel_LogPath;
    private static javax.swing.JLabel jLabel_NA;
    private static javax.swing.JLabel jLabel_NIF;
    private static javax.swing.JLabel jLabel_NIF_NoParameters;
    private static javax.swing.JLabel jLabel_NIF_NoParameters1;
    private static javax.swing.JLabel jLabel_NNLS;
    private static javax.swing.JLabel jLabel_NNLS_Iterations;
    private static javax.swing.JLabel jLabel_NNLS_Step;
    private static javax.swing.JLabel jLabel_OilRI;
    private static javax.swing.JLabel jLabel_OutputPath;
    private static javax.swing.JLabel jLabel_PSFBasicParameters;
    private static javax.swing.JLabel jLabel_PSFModel;
    private static javax.swing.JLabel jLabel_PSFNormalization;
    private static javax.swing.JLabel jLabel_PSFPath;
    private static javax.swing.JLabel jLabel_PaddingConstraint;
    private static javax.swing.JLabel jLabel_PaddingExtension;
    private static javax.swing.JLabel jLabel_PositionNM_GL;
    private static javax.swing.JLabel jLabel_PositionNM_TV;
    private static javax.swing.JLabel jLabel_PositionNM_VRIGL;
    private static javax.swing.JLabel jLabel_Position_GL;
    private static javax.swing.JLabel jLabel_Position_TV;
    private static javax.swing.JLabel jLabel_Position_VRIGL;
    private static javax.swing.JLabel jLabel_Preprocessing;
    private static javax.swing.JLabel jLabel_Processing;
    private static javax.swing.JLabel jLabel_RI;
    private static javax.swing.JLabel jLabel_RIF;
    private static javax.swing.JLabel jLabel_RIF_Reg;
    private static javax.swing.JLabel jLabel_RI_Sample0_VRIGL;
    private static javax.swing.JLabel jLabel_RI_SampleZ_VRIGL;
    private static javax.swing.JLabel jLabel_RI_Sample_GL;
    private static javax.swing.JLabel jLabel_RI_Sample_TV;
    private static javax.swing.JLabel jLabel_RI_Variation_VRIGL;
    private static javax.swing.JLabel jLabel_RL;
    private static javax.swing.JLabel jLabel_RLTV;
    private static javax.swing.JLabel jLabel_RLTV_Iterations;
    private static javax.swing.JLabel jLabel_RLTV_Reg;
    private static javax.swing.JLabel jLabel_RL_Iterations;
    private static javax.swing.JLabel jLabel_RW;
    private static javax.swing.JLabel jLabel_Sample0RI;
    private static javax.swing.JLabel jLabel_SampleRI;
    private static javax.swing.JLabel jLabel_SampleZRI;
    private static javax.swing.JLabel jLabel_TM;
    private static javax.swing.JLabel jLabel_TM_Iterations;
    private static javax.swing.JLabel jLabel_TM_Reg;
    private static javax.swing.JLabel jLabel_TM_Step;
    private static javax.swing.JLabel jLabel_TRIF;
    private static javax.swing.JLabel jLabel_TRIF_Reg;
    private static javax.swing.JLabel jLabel_VC;
    private static javax.swing.JLabel jLabel_VC_Iterations;
    private static javax.swing.JLabel jLabel_VC_Step;
    private static javax.swing.JLabel jLabel_Wave_RIOil;
    private static javax.swing.JLabel jLabel_Wave_RISample;
    private static javax.swing.JLabel jLabel_Wave_RISample0;
    private static javax.swing.JLabel jLabel_Wave_RISampleZ;
    private static javax.swing.JLabel jLabel_Wavelength;
    private static javax.swing.JLabel jLabel_WorkingUM_GL;
    private static javax.swing.JLabel jLabel_WorkingUM_TV;
    private static javax.swing.JLabel jLabel_WorkingUM_VRIGL;
    private static javax.swing.JLabel jLabel_Working_GL;
    private static javax.swing.JLabel jLabel_Working_TV;
    private static javax.swing.JLabel jLabel_Working_VRIGL;
    private static javax.swing.JPanel jPanelIO;
    private static javax.swing.JPanel jPanel_BVLS;
    private static javax.swing.JPanel jPanel_CalculatePSF;
    private static javax.swing.JPanel jPanel_DIV;
    private static javax.swing.JPanel jPanel_Deconvolution;
    private static javax.swing.JPanel jPanel_DeconvolutionAlgorithm;
    private static javax.swing.JPanel jPanel_FISTA;
    private static javax.swing.JPanel jPanel_ICTM;
    private static javax.swing.JPanel jPanel_IOPaths;
    private static javax.swing.JPanel jPanel_ISTA;
    private static javax.swing.JPanel jPanel_LW;
    private static javax.swing.JPanel jPanel_LoadPSF;
    private static javax.swing.JPanel jPanel_NIF;
    private static javax.swing.JPanel jPanel_NNLS;
    private static javax.swing.JPanel jPanel_PSF;
    private static javax.swing.JPanel jPanel_PSFBasic;
    private static javax.swing.JPanel jPanel_PSF_BW;
    private static javax.swing.JPanel jPanel_PSF_RI;
    private static javax.swing.JPanel jPanel_PSF_RW;
    private static javax.swing.JPanel jPanel_PSF_TV;
    private static javax.swing.JPanel jPanel_PSF_VRIGL;
    private static javax.swing.JPanel jPanel_RIF;
    private static javax.swing.JPanel jPanel_RL;
    private static javax.swing.JPanel jPanel_RLTV;
    private static javax.swing.JPanel jPanel_Status0;
    private static javax.swing.JPanel jPanel_Status1;
    private static javax.swing.JPanel jPanel_Status2;
    private static javax.swing.JPanel jPanel_Status3;
    private static javax.swing.JPanel jPanel_TM;
    private static javax.swing.JPanel jPanel_TRIF;
    private static javax.swing.JPanel jPanel_VC;
    private static javax.swing.JPanel jPanel_Wave;
    private static javax.swing.JPanel jPanel_Wavelengths;
    private static javax.swing.JSeparator jSeparatorPSF2;
    private static javax.swing.JSeparator jSeparator_Deconvolution1;
    private static javax.swing.JSeparator jSeparator_Deconvolution2;
    private static javax.swing.JSeparator jSeparator_PSF1;
    private static javax.swing.JSlider jSlider_FISTA_Reg;
    private static javax.swing.JSlider jSlider_ICTM_Reg;
    private static javax.swing.JSlider jSlider_ISTA_Reg;
    private static javax.swing.JSlider jSlider_RIF_Reg;
    private static javax.swing.JSlider jSlider_RLTV_Reg;
    private static javax.swing.JSlider jSlider_TM_Reg;
    private static javax.swing.JSlider jSlider_TRIF_Reg;
    private static javax.swing.JSpinner jSpinner_BVLS_Iterations;
    private static javax.swing.JSpinner jSpinner_BVLS_Step;
    private static javax.swing.JSpinner jSpinner_FISTA_Iterations;
    private static javax.swing.JSpinner jSpinner_FISTA_Step;
    private static javax.swing.JSpinner jSpinner_ICTM_Iterations;
    private static javax.swing.JSpinner jSpinner_ICTM_Step;
    private static javax.swing.JSpinner jSpinner_ISTA_Iterations;
    private static javax.swing.JSpinner jSpinner_ISTA_Step;
    private static javax.swing.JSpinner jSpinner_LW_Iterations;
    private static javax.swing.JSpinner jSpinner_LW_Step;
    private static javax.swing.JSpinner jSpinner_NNLS_Iterations;
    private static javax.swing.JSpinner jSpinner_NNLS_Step;
    private static javax.swing.JSpinner jSpinner_PaddingExtensionXY;
    private static javax.swing.JSpinner jSpinner_PaddingExtensionZ;
    private static javax.swing.JSpinner jSpinner_RLTV_Iterations;
    private static javax.swing.JSpinner jSpinner_RL_Iterations;
    private static javax.swing.JSpinner jSpinner_TM_Iterations;
    private static javax.swing.JSpinner jSpinner_TM_Step;
    private static javax.swing.JSpinner jSpinner_VC_Iterations;
    private static javax.swing.JSpinner jSpinner_VC_Step;
    private static javax.swing.JTabbedPane jTabbedPane_DeconvolutionAlgorithm;
    private static javax.swing.JTabbedPane jTabbedPane_PSFCalculateOrNot;
    private static javax.swing.JTabbedPane jTabbedPane_PSFMethod;
    private static javax.swing.JTabbedPane jTabbedPanel_Main;
    private static javax.swing.JTextField jTextField_FISTA_Reg;
    private static javax.swing.JTextField jTextField_ICTM_Reg;
    private static javax.swing.JTextField jTextField_ISTA_Reg;
    private static javax.swing.JTextField jTextField_InputPath;
    private static javax.swing.JTextField jTextField_IntermediatePath;
    private static javax.swing.JTextField jTextField_LogPath;
    private static javax.swing.JTextField jTextField_NA;
    private static javax.swing.JTextField jTextField_OilRI1;
    private static javax.swing.JTextField jTextField_OilRI2;
    private static javax.swing.JTextField jTextField_OilRI3;
    private static javax.swing.JTextField jTextField_OilRI4;
    private static javax.swing.JTextField jTextField_OilRI5;
    private static javax.swing.JTextField jTextField_OilRI6;
    private static javax.swing.JTextField jTextField_OilRI7;
    private static javax.swing.JTextField jTextField_OilRI8;
    private static javax.swing.JTextField jTextField_OutputPath;
    private static javax.swing.JTextField jTextField_PSFPath;
    private static javax.swing.JTextField jTextField_Position_GL;
    private static javax.swing.JTextField jTextField_Position_TV;
    private static javax.swing.JTextField jTextField_Position_VRIGL;
    private static javax.swing.JTextField jTextField_RIF_Reg;
    private static javax.swing.JTextField jTextField_RI_Oil;
    private static javax.swing.JTextField jTextField_RI_Sample0_VRIGL;
    private static javax.swing.JTextField jTextField_RI_SampleZ_VRIGL;
    private static javax.swing.JTextField jTextField_RI_Sample_GL;
    private static javax.swing.JTextField jTextField_RI_Sample_TV;
    private static javax.swing.JTextField jTextField_RLTV_Reg;
    private static javax.swing.JTextField jTextField_Residu;
    private static javax.swing.JTextField jTextField_SampleRI1;
    private static javax.swing.JTextField jTextField_SampleRI2;
    private static javax.swing.JTextField jTextField_SampleRI3;
    private static javax.swing.JTextField jTextField_SampleRI4;
    private static javax.swing.JTextField jTextField_SampleRI5;
    private static javax.swing.JTextField jTextField_SampleRI6;
    private static javax.swing.JTextField jTextField_SampleRI7;
    private static javax.swing.JTextField jTextField_SampleRI8;
    private static javax.swing.JTextField jTextField_SampleZRI1;
    private static javax.swing.JTextField jTextField_SampleZRI2;
    private static javax.swing.JTextField jTextField_SampleZRI3;
    private static javax.swing.JTextField jTextField_SampleZRI4;
    private static javax.swing.JTextField jTextField_SampleZRI5;
    private static javax.swing.JTextField jTextField_SampleZRI6;
    private static javax.swing.JTextField jTextField_SampleZRI7;
    private static javax.swing.JTextField jTextField_SampleZRI8;
    private static javax.swing.JTextField jTextField_TM_Reg;
    private static javax.swing.JTextField jTextField_TRIF_Reg;
    private static javax.swing.JTextField jTextField_Wave_RIOil;
    private static javax.swing.JTextField jTextField_Wave_RISample;
    private static javax.swing.JTextField jTextField_Wave_RISampleZ;
    private static javax.swing.JTextField jTextField_Wavelength1;
    private static javax.swing.JTextField jTextField_Wavelength2;
    private static javax.swing.JTextField jTextField_Wavelength3;
    private static javax.swing.JTextField jTextField_Wavelength4;
    private static javax.swing.JTextField jTextField_Wavelength5;
    private static javax.swing.JTextField jTextField_Wavelength6;
    private static javax.swing.JTextField jTextField_Wavelength7;
    private static javax.swing.JTextField jTextField_Wavelength8;
    private static javax.swing.JTextField jTextField_Working_GL;
    private static javax.swing.JTextField jTextField_Working_TV;
    private static javax.swing.JTextField jTextField_Working_VRIGL;
    // End of variables declaration//GEN-END:variables
    private static JFileChooser chooser;
    private static String workingPath;
    private static Hashtable<Integer, JLabel> regLabels; 
    private static Settings settings;
    private static ArrayList<String> listPSF;
    private static ArrayList<String> listDeconvolution;
    private static ArrayList<String> extensions;
    
}
