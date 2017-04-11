/*
 * Copyright (C) 2017 Fox
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package j_validate;

import java.io.BufferedWriter;
import java.io.Writer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;

/**
 *
 * @author Fox
 */
public class Validate_Logger
{
    public String strLogFileName;
    
    private Writer wtrLogWriter;
    
    private String strNewLineCharNix = "\n";
    
    private String strNewLineCharWin = "\r\n";
    
    private String strNewLineChar;
    
    public Validate_Logger()
    {
        // Generate File name
        strLogFileName = "Validation_Log.txt";


        // Check if File exists, if so erase
        File f = new File(strLogFileName);
        if(f.exists() && !f.isDirectory()) 
        { 
           try
                    {
                      f.delete();
                    }
           catch(Exception e)
                   {
                       System.out.println("Error: " + e.getMessage());
                   }
        }
        
       
        // create new log with initial startup data
        try
        {
            wtrLogWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(strLogFileName), "utf-8"));
           
           
        }
        catch (FileNotFoundException | UnsupportedEncodingException exWriter)
        {
            System.out.println("Error: " + exWriter.getMessage());
        }
        

        
    }
    
    public void SetLineEndings(String _temp)
    {
        if ("win".equals(_temp))
        {
            strNewLineChar = strNewLineCharWin;
        }
        else
        {
            strNewLineChar = strNewLineCharNix;
        }
    }
    
    public void Log(String _strLogTemp) throws IOException
    {
        ZonedDateTime zdt = ZonedDateTime.now();
        java.util.Date date = java.util.Date.from( zdt.toInstant() );
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        wtrLogWriter.write(sdf.format(date) + " - " + _strLogTemp);
        wtrLogWriter.write(strNewLineChar);
        wtrLogWriter.flush();
    }
    
    public void Log(String[] _strLogTemp) throws IOException
    {
        ZonedDateTime zdt = ZonedDateTime.now();
        java.util.Date date = java.util.Date.from( zdt.toInstant() );
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        for (String _strLogTemp1 : _strLogTemp)
        {
            wtrLogWriter.write(sdf.format(date) + " - " + _strLogTemp1);
            wtrLogWriter.write(strNewLineChar);
            
        }
        wtrLogWriter.flush();
    }
    
//    
//    try {
//    Files.write(Paths.get("file1.bin"), data);
//    Files.write(Paths.get("file2.bin"), data,
//            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//    Files.write(Paths.get("file3.txt"), "content".getBytes());
//    Files.write(Paths.get("file4.txt"), "content".getBytes(utf8));
//    Files.write(Paths.get("file5.txt"), lines, utf8);
//    Files.write(Paths.get("file6.txt"), lines, utf8,
//            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//} catch (IOException e) {
//    e.printStackTrace();
//}

}
