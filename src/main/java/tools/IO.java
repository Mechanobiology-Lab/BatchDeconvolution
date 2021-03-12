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
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Zbigniew Baster
 */
public class IO {
    public static void saveSettings (String path, Settings settings) throws IOException, IllegalArgumentException, IllegalAccessException{
        fields = settings.getClass().getFields();

        if(!(new File(path).getParentFile().exists()))new File(path).getParentFile().mkdirs();
        
        fw = new FileWriter(path);
 	for (int i = 0; i < fields.length; i++) {
		fw.write(fields[i].getName()+"\t"+fields[i].get(settings)+"\n");
	}
 
	fw.close();

    }
    public static void loadSettings (String path, Settings settings) throws FileNotFoundException, IOException, IllegalArgumentException, IllegalAccessException{
        fields = settings.getClass().getFields();
        array = new ArrayList<>();
        for (Field field : fields) {
            array.add(field.getName());
        }
           
        sc=new Scanner(new FileInputStream(path));  
        while(sc.hasNextLine())  {
            line=sc.nextLine().split("\t",2);

            index=array.indexOf(line[0]);
            if(index == -1);
            else if(fields[index].getType().equals(Boolean.TYPE)){
                fields[index].set(settings,Boolean.parseBoolean(line[1]));
            }else if(fields[index].getType().equals(Double.TYPE)){
                fields[index].set(settings,Double.parseDouble(line[1]));
            }else if(fields[index].getType().equals(Integer.TYPE)){
                fields[index].set(settings,Integer.parseInt(line[1]));
            }else if(fields[index].getType().equals(String.class)){
                fields[index].set(settings,line[1]);
            }
        }  
        sc.close();     //closes the scanner   
    }
    
    public static ArrayList<String> loadExtensions () throws FileNotFoundException{
        array = new ArrayList<>();
        
        sc=new Scanner(new FileInputStream(new File("").getAbsolutePath()+"/plugins/BatchDeconvolution/extensions.dat"));
        while(sc.hasNext())  {
            array.add(sc.next());
        }
        sc.close();
        
        return array;
    }
    
    private static Field fields[];
    private static FileWriter fw;
    private static ArrayList<String> array;
    private static Scanner sc;
    private static int index;
    private static String line[];   
}
