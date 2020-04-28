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

import calculations.Run;
import ij.IJ;
import ij.Macro;
import ij.plugin.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tools.*;

/**
 *
 * @author Zbigniew Baster
 */
public class BatchDeconvolution implements PlugIn {
    /**
     *
     * @param arg
     */
    @Override
    public void run(String arg) {
        arguments = Macro.getOptions();
        if(arguments!=null && new File(arguments).exists() && new File(arguments).isFile()){
            try {
            settings = new Settings();
                IO.loadSettings(arguments, settings);
                settings._BF();
                settings.lambda();
                settings.oil_RI();
                settings.sample_RI();
                settings.sampleZ_RI();
                settings._BF();
                IO.loadExtensions();
                
                if(!new File("plugins\\PSFGenerator\\PSFGenerator.jar").exists()){
                    IJ.log("PSFGenerator.jar not found! PSFGenerator.jar standalone version is available at http://bigwww.epfl.ch/algorithms/psfgenerator/. Place the file in Fiji folder as plugins/PSFGenerator/PSFGenerator.jar and restart BatchDeconvolution plugin.");
                    JOptionPane.showMessageDialog(null,"PSFGenerator.jar not found!\n"
                            + "PSFGenerator.jar standalone version is available at http://bigwww.epfl.ch/algorithms/psfgenerator/.\n"
                            + "Place the file in Fiji folder as plugins/PSFGenerator/PSFGenerator.jar\n"
                            + "and restart BatchDeconvolution plugin.","PSFGenerator.jar not found!",JOptionPane.ERROR_MESSAGE);
                }
                else if(!new File("plugins\\DeconvolutionLab2\\DeconvolutionLab_2.jar").exists()){
                    IJ.log("DeconvolutionLab_2.jar not found! DeconvolutionLab_2.jar is available at http://bigwww.epfl.ch/algorithms/psfgenerator/. Place the file in Fiji folder as plugins/DeconvolutionLab/DeconvolutionLab_2.jar and restart BatchDeconvolution plugin.");
                    JOptionPane.showMessageDialog(null,"DeconvolutionLab_2.jar not found!\n"
                            + "DeconvolutionLab_2.jar is available at http://bigwww.epfl.ch/deconvolution/deconvolutionlab2/,\n"
                            + "Place the file in Fiji folder as plugins/DeconvolutionLab/DeconvolutionLab_2.jar\n"
                            + "and restart BatchDeconvolution plugin.","DeconvolutionLab_2.jar not found!",JOptionPane.ERROR_MESSAGE);
                }
                else{

                    if(!new File("plugins\\DeconvolutionLab2\\FFTW").exists()){
                        IJ.log("FFTW not found in plugins\\DeconvolutionLab2\\ directory! FFTW2 Fourier transform algorithm might be unavailable. FFTW.zip is available at http://bigwww.epfl.ch/deconvolution/deconvolutionlab2/. Unpack in Fiji folder as plugins/DeconvolutionLab/FFTW/\"inclued files\" and restart BatchDeconvolution plugin.");
                        JOptionPane.showMessageDialog(null,"FFTW not found in plugins\\DeconvolutionLab2\\ directory!\n"
                                + "FFTW2 Fourier transform algorithm might be unavailable.\n"
                                + "FFTW.zip is available at http://bigwww.epfl.ch/deconvolution/deconvolutionlab2/.\n"
                                + "Unpack in Fiji folder as plugins/DeconvolutionLab/FFTW/\"inclued files\"\n"
                                + "and restart BatchDeconvolution plugin.","FFTW not found!",JOptionPane.WARNING_MESSAGE);
                    }
                    Run.run(settings, IO.loadExtensions(), null);
                }
                
            } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(BatchDeconvolution.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            new Menu().setVisible(true);
        }
    }
    Settings settings;
    String arguments;
}


