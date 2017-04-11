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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // try catch these, log and exit on failure
        os_check OSCheck = new os_check();
        Validate_Logger Logger = new Validate_Logger();
        arg_parser ArgParser = new arg_parser();
        
        
        if (OSCheck.bSysNix)
        {
            Logger.SetLineEndings("nix");
        }
        else if (OSCheck.bSysWin)
        {
            Logger.SetLineEndings("win");
          
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
            ArgParser.DisplayListofArgs();
            System.exit(0);
        }
        else 
        {
            // Start argument parser
            
            if (ArgParser.ValidateArguments(args))
            {           
                ArgParser.ParseArguments(args);
            }
            else
            {
                 System.out.println("Error: Valid No Arguments Specified");
            try
            {
                Logger.Log("Error: No Valid Arguments Specified");
            } catch (IOException ex)
            {
               System.out.println(ex.toString());
            }
            ArgParser.DisplayListofArgs();
            System.exit(0);
            }
        }
        
    }
    
}
