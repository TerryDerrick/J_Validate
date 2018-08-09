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
            JParseArguments(args, ParserSettingsObject);
            // execute validation check of applied settings
            // begin parsering of files
            try 
            {
                FileProcessorMain objFileProcess = new FileProcessorMain(ParserSettingsObject, Logger);
                objFileProcess.FileProcessorRun();
            }
            catch (Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
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
    
    public static boolean JIsArgValidReturnBool(String _strArg)
    {
        boolean _bOutput = false;
            switch(_strArg.toUpperCase())
            {
                case "-I":
                    _bOutput = true;
                    break;
                    
                case "-O":
                    _bOutput = true;
                    break;
                    
                case "-E":
                    _bOutput = true;
                    break;
                    
                case "-M":
                    _bOutput = true;
                    break;
                    
                case "-S":
                    _bOutput = true;
                    break;
                    
                case "-?":
                    _bOutput = true;
                    break;
                    
                    
                default:
                    _bOutput = false;
                    break;
            }
        return _bOutput;
    }
    
    public static void JParseArguments(String[] _argtemp, parser_settings _settingObj)
    {
        for (int numArg = 0; numArg < (_argtemp.length - 1) ; numArg++) 
        {
            switch(_argtemp[numArg].toUpperCase())
            {
                case "-I":
                    numArg++;
                    if (!JIsArgValidReturnBool(_argtemp[numArg]))
                    {
                        _settingObj.strInputPath = _argtemp[numArg];
                    }
                    break;
                    
                case "-O":
                    numArg++;
                    if (!JIsArgValidReturnBool(_argtemp[numArg]))
                    {
                        _settingObj.strOutputPath = _argtemp[numArg];
                    }
                    break;
                    
                case "-E":
                    numArg++;
                    if (!JIsArgValidReturnBool(_argtemp[numArg]))
                    {
                        _settingObj.strExtractPath = _argtemp[numArg];
                    }
                    break;
                    
                case "-M":
                    numArg++;
                    if (!JIsArgValidReturnBool(_argtemp[numArg]))
                    {
                        _settingObj.strFileValidationMask = _argtemp[numArg];
                    }
                    break;
                    
                case "-S":
                    if (_argtemp.length >= 2)
                    {
                        System.out.println("-s must be the only command in use ");
                    }
                    else
                    {
                        numArg++;
                        if (!JIsArgValidReturnBool(_argtemp[numArg]))
                        {
                            _settingObj.strSettingsFile = _argtemp[numArg];
                        }

                    }
                    break;
                    
                case "-?":
                    JDisplayListofArgs(_settingObj.strSysType);
                    System.exit(0);
                    break;
                    
                    
                default:
                    System.out.println("Error detected in command - argument: " + _argtemp[numArg]);
                    break;
            }
        }
    }
    
    public static void JValidateSettings(parser_settings _settingObj)
    {
        // validate paths as valid or files can be accessed / found
    }
    
    public static void JParseSettingsFile(parser_settings _settingObj)
    {
        // parse settings from file
        // validate settings
    }
    
    
/*
    public void JParseArguments(String[] _argtemp, parser_settings _settingObj)
    {
        
        boolean bitCommandFollower = false;
        String strPrequelCommand = "";
        String strErrorResponse = "";
        boolean bErrorFlag = false;
        
        
        
        CommandLinkedList CommandParams = new CommandLinkedList();
        for (int numArg = 0; numArg < (_argtemp.length - 1) ; numArg++) 
        {
            
            

            // loop through a list of commands, if command is valid select follower params if any and jump array forward to after, and loop again
            // if command is invalid, grab invalid command and error, try and grab last valid command in case its a param that invalid
            if (CommandParams.FindCommandInListReturnValid(_argtemp[numArg]))
                    {
                        int numComCount = CommandParams.FindCommandInListReturnParams(_argtemp[numArg]);
                        strErrorResponse = _argtemp[numArg];
                        if (numComCount > 0 )
                        {    
                            // Commands here have Params
                            for (int i = 0; i < (numComCount -1); i++) 
                            {
                                numArg++;
                                if (CommandParams.FindCommandInListReturnValid(_argtemp[numArg]))
                                {
                                    bErrorFlag = true;
                                    strErrorResponse = strErrorResponse + _argtemp[numArg];
                                    break;
                                    //throw error params should not be valid here
                                }
                                else
                                {

                                }
                            }
                        }
                        else
                        {
                            // handle switches here.
                        }
                            
                        
                    }
            else
            {
                // invalid command
                bErrorFlag = true;
                
            }

            if (bErrorFlag)
            {
                String strErrorLine = "Error in: " + strErrorResponse;
                System.out.println(strErrorLine);
                break;
            }
            
            
            
        }
        
        
            
        
    }
  */  
    
}
