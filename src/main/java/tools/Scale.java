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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Zbigniew Baster
 */
public class Scale {
    public static double nm(double val, String unit) throws FileNotFoundException{
        units = new TreeMap<>();
        
        sc=new Scanner(new FileInputStream(new File("").getAbsolutePath()+"\\plugins\\BatchDeconvolution\\units.dat"));
        while(sc.hasNextLine())  {
            line=sc.nextLine().split("\t",2);
            if(line.length>0) units.put(line[0], Double.parseDouble(line[1]));
        }
        sc.close();
        return val*units.get("nm")/units.get(unit);
    }
    
    private static TreeMap<String,Double> units;
    private static Scanner sc;
    private static String[] line;
}
