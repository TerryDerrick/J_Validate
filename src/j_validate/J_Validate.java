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

import java.io.IOException;

/**
 *
 * @author Fox
 */

public class J_Validate
{
   // public parser_settings ParserSettingsObject; 
     
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // try catch these, log and exit on failure
        os_check OSCheck = new os_check();
        Validate_Logger Logger = new Validate_Logger();
        //arg_parser ArgParser = new arg_parser();
        parser_settings ParserSettingsObject = new parser_settings();
        
        
        if (OSCheck.bSysNix)
        {
            Logger.SetLineEndings("nix");
            ParserSettingsObject.strSysType = "nix";
        }
        else if (OSCheck.bSysWin)
        {
            Logger.SetLineEndings("win");
            ParserSettingsObject.strSysType = "win";
          
        }
        
        try
        {
            Logger.Log("Logging Started");
            Logger.Log(OSCheck.GetSystemParams());
        } catch (IOException ex)
        {
            System.out.println(ex.toString());
        }
        // Handline command line input here
        if (args.length < 1)
        {
            System.out.println("Error: No Arguments Specified");
            
            try
            {
                Logger.Log("Error: No Arguments Specified");
            } catch (IOException ex)
            {
               System.out.println(ex.toString());
            }
            JDisplayListofArgs(ParserSettingsObject.strSysType);
            System.exit(0);
        }
        else 
        {
            // Start argument parser
            
            
            try
            {
                Logger.Log("Error: No Valid Arguments Specified");
            } catch (IOException ex)
            {
               System.out.println(ex.toString());
            }
            JDisplayListofArgs(ParserSettingsObject.strSysType);
            System.exit(0);
            
        }
        
    }
    
   
    
    public static void JDisplayListofArgs(String _strSysType)
    {
        
        switch (_strSysType)
        {
            case "win":
                System.out.println("please use the following arguments to specify the program behaviour");
                System.out.println("-i <input file> \"-i C:\\data\\input\\inputfile.txt\"");
                System.out.println("-o <output file> \"-o C:\\data\\output\\outputfile.txt\"");
                System.out.println("-e <extract file> \"-e C:\\data\\output\\extractsfile.txt\"");
                System.out.println("");
                System.out.println("For Use with a Settings File only Use the -s switch");
                System.out.println("-s <jsettings.ini> \"-e C:\\data\\output\\jsettings.ini\"");
                break;

            case "nix":
                System.out.println("please use the following arguments to specify the program behaviour");
                System.out.println("-i <input file> \"-i //data/input/inputfile.txt\"");
                System.out.println("-o <output file> \"-o //data/output/outputfile.txt\"");
                System.out.println("-e <extract file> \"-e //data/output/extractsfile.txt\"");
                System.out.println("");
                System.out.println("For Use with a Settings File only Use the -s switch");
                System.out.println("-s <jsettings.ini> \"-e //data/output/jsettings.ini\"");
                break;

            case "mac":
                System.out.println("Mac OS is currently not supported");

                break;

            default:

                break;
        }

    }
    
    

    public void JParseArguments(String[] _argtemp, parser_settings _settingObj)
    {
        
        boolean bitCommandFollower = false;
        String strPrequelCommand = "";
        String strErrorResponse = "";
        boolean bErrorFlag = false;
        
        
        for (int numArg = 0; numArg < (_argtemp.length - 1) ; numArg++) 
        {
            
            

            // loop through a list of commands, if command is valid select follower params if any and jump array forward to after, and loop again
            // if command is invalid, grab invalid command and error, try and grab last valid command in case its a param that invalid
            
            
            /*
                switch (_argtemp[numArg].toUpperCase())
                {
                    case "-I":
                        bitCommandFollower  = true;
                        strPrequelCommand = "I";
                    break;
                        
                    case "-O":
                        bitCommandFollower  = true;
                        strPrequelCommand = "O";
                        break;
                        
                    case "-M":
                        bitCommandFollower  = true;
                        strPrequelCommand = "M";
                        break;
                        
                    case "-E":
                        bitCommandFollower  = true;
                        strPrequelCommand = "E";
                        break;
                    
                    case "-?":
                        bitCommandFollower  = false;
                        strPrequelCommand = "";
                        //DisplayListofArgs();
                        System.exit(0);
                        break;
                    
                    case "-S":
                        // check for len, if more then 2 commands (S switch + filepath) then exit with error
                        
                    default:
                        if (bitCommandFollower)
                        {
                            switch (strPrequelCommand)
                            {
                                case "I":
                                    _settingObj.strInputPath = _argtemp[numArg];
                                    break;
                                    
                                case "O":
                                    _settingObj.strOutputPath = _argtemp[numArg];
                                    break;
                                
                                case "M":
                                    _settingObj.strFileValidationMask = _argtemp[numArg];
                                    break;
                                
                                case "E":
                                    _settingObj.strExtractPath = _argtemp[numArg];
                                default:
                                
                                    break;
                            }
                        }
                        else 
                        {
                            // Not a valid command
                            bErrorFlag = true;
                            strErrorResponse = "[ " + _argtemp[numArg] + " ] Is not a valid command!";
                        }
                    break;
                    
                
                }
            
               if (bErrorFlag)
               {
                   break;
               }
            */
        }
        
        
            
        
    }
    
    public boolean TestValidCommand(String _strTempCommand)
    {
        boolean bValidCommand = false;
    
            switch (_strTempCommand.toUpperCase())
                {
                    case "-I":
                      bValidCommand = true;
                    break;
                        
                    case "-O":
                        bValidCommand = true;
                        break;
                        
                    case "-M":
                        bValidCommand = true;
                        break;
                        
                    case "-E":
                        bValidCommand = true;
                        break;
                    
                    case "-?":
                         bValidCommand = true;
                        //JDisplayListofArgs();
                        //System.exit(0);
                        break;
                    
                    case "-S":
                        // check for len, if more then 2 commands (S switch + filepath) then exit with error
                         bValidCommand = true;
                    break;
                    default:
                         bValidCommand = false;
                        break;
                }
            return  bValidCommand;
    }
    
}
