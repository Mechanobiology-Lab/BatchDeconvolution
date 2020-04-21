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
import ij.Macro;
import ij.plugin.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                Run.run(settings, IO.loadExtensions(), null);
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
