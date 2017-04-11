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

/**
 *
 * @author Fox
 */
public class os_check
{
    // Get OS details here
    // also get CPU and thread details here
    public String OS_Name;
    public String OS_Version;
    public String OS_Arch;
    private Long numFreeMemoryInMB;
    private Long numMaxMemoryInMb;
    private Long numTotalMemoryInMb;
    
    public boolean bSysWin;
    public boolean bSysNix;
    public boolean bSysMac;
    
    public int CPU_CoreCount;
    public int CPU_ThreadCount;
    
    public os_check()
    {
        bSysWin = false;
        bSysNix = false;
        
        // Pull all data on initialization
        OS_Name = System.getProperty("os.name");
        OS_Version = System.getProperty("os.version");
        OS_Arch = System.getProperty("os.arch");
        
        CPU_CoreCount = Runtime.getRuntime().availableProcessors();
        long numFreeMemory = Runtime.getRuntime().freeMemory();
        long numMaxMemory = Runtime.getRuntime().maxMemory();
        long numTotalMemory = Runtime.getRuntime().totalMemory();
        
        numFreeMemoryInMB = (numFreeMemory / 1048576);
       
        
        
        setOSFlag();
        
        // after startup log system details to logfile
    }
    
    private void setOSFlag()
    {
        if (OS_Name.toLowerCase().contains("windows"))
        {
            bSysWin = true;
            bSysNix = false;
            bSysMac = false;
        }
        if (OS_Name.toLowerCase().contains("nix"))
        {
            bSysWin = false;
            bSysNix = true;
            bSysMac = false;
        }
        if (OS_Name.toLowerCase().contains("mac"))
        {
            bSysWin = false;
            bSysNix = false;
            bSysMac = true;
        }
        
    }
    
    public long ReturnUpdateFreeMemory()
    {
       return 0L; 
    }
    
    public int ReturnUpdateFreeMemoryInMb()
    {
        return 0;
    }
    
    private void Validate_CPU_ThreadCount()
    {
        // no support without 3rd party libs
    }
 
    // Probably a better way of handling this..
    public String[] GetSystemParams()
    {
        String strFreeMemoryInMB = numFreeMemoryInMB.toString();
        
        String [] _arrSysParam = new String[5];
            _arrSysParam[0] = OS_Name;
            _arrSysParam[1] = OS_Version;
            _arrSysParam[2] = OS_Arch;
            _arrSysParam[3] = "CPU CoreCount " + CPU_CoreCount;
            _arrSysParam[4] = "Free Memory :" + strFreeMemoryInMB + "mb";
           
        
        return _arrSysParam;
    }
}

//        //Operating system name
//        System.out.println(System.getProperty("os.name"));
//
//        //Operating system version
//        System.out.println(System.getProperty("os.version"));
//
//        //Path separator character used in java.class.path
//        System.out.println(System.getProperty("path.separator"));
//
//        //User working directory
//        System.out.println(System.getProperty("user.dir"));
//
//        //User home directory
//        System.out.println(System.getProperty("user.home"));
//
//        //User account name
//        System.out.println(System.getProperty("user.name"));
//
//        //Operating system architecture
//        System.out.println(System.getProperty("os.arch"));
//
//        //Sequence used by operating system to separate lines in text files
//        System.out.println(System.getProperty("line.separator"));
//
//        System.out.println(System.getProperty("java.version")); //JRE version number
//
//        System.out.println(System.getProperty("java.vendor.url")); //JRE vendor URL
//
//        System.out.println(System.getProperty("java.vendor")); //JRE vendor name
//
//        System.out.println(System.getProperty("java.home")); //Installation directory for Java Runtime Environment (JRE)
//
//        System.out.println(System.getProperty("java.class.path"));
//
//        System.out.println(System.getProperty("file.separator"));
//    
