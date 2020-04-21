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

import ij.measure.ResultsTable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import tools.Settings;

/**
 *
 * @author Zbigniew Baster
 */
public class Log {
    public static void create(Settings settings, TreeMap<String,String> files, TreeMap<String,int[]> seriesFrames) throws IOException{
        first = true;
        pathFinalLog=settings.logPath+"\\log.csv";
        fw = new FileWriter(pathFinalLog);
        
        for(Map.Entry<String,String> file: files.entrySet()){
            for(int sr=0; sr < seriesFrames.get(file.getValue())[0]; sr++){
                for(int fr=0; fr < seriesFrames.get(file.getValue())[1]; fr++){
                    for(int ch=0; ch < settings.channels; ch++){
                        if(settings._BF.get(ch)) continue;
                        
                        fileImg=file.getValue()+"_sr"+sr+"_fr"+fr+"_ch"+ch;
                        if(settings._PSF_calc==0)fileImg = fileImg.substring(fileImg.indexOf("_",fileImg.indexOf("_")+1)+1);
                        
                        pathLog = settings.intermediatePath+"\\Log\\stats_"+fileImg+".csv";
                        results = ResultsTable.open2(pathLog);
                        
                        if(first){
                            fw.append("File,Iterations,");
                            fw.append(results.getColumnHeadings().replace("\t",","));
                            fw.append("\n");
                            first=false;
                        }
                        
                        fw.append(fileImg+".tif");
                        fw.append(",");
                        fw.append(String.valueOf(results.size()-2));
                        fw.append(",");
                        fw.append(results.getRowAsString(results.size()-1).replace("\t",","));
                        fw.append("\n");
                        
                    }
                }
            }          
        }
        
        
        
        fw.close();
    }
    
    private static String pathFinalLog;
    private static String pathLog;
    private static String fileImg;
    private static ResultsTable results;
    private static FileWriter fw;
    private static boolean first;
    
}
