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
public class arg_parser
{

    private String strSysType;

    public arg_parser()
    {

    }

    public void SetSysType(String _strtempsys)
    {
        if (_strtempsys != null)
        {
            if (_strtempsys.contains("win"))
            {
                strSysType = "win";
            } else if (_strtempsys.contains("win"))
            {
                strSysType = "nix";
            } else if (_strtempsys.contains("mac"))
            {
                strSysType = "mac";
            } else
            {
                strSysType = "win";
            }
        }

    }

    public void DisplayListofArgs()
    {
        switch (strSysType)
        {
            case "win":
                System.out.println("please use the following arguments to specify the program behaviour");
                System.out.println("-i <input file> \"-i C:\\data\\input\\examplefile.txt\"");
                break;

            case "nix":
                System.out.println("please use the following arguments to specify the program behaviour");
                System.out.println("-i <input file> \"-i //data/input/examplefile.txt\"");
                break;

            case "mac":
                System.out.println("Mac OS is currently not supported");

                break;

            default:

                break;
        }

    }

   

    public boolean ValidateArguments(String[] _argtemp)
    {
        // Probably not required
        return true;
    }

    public void ParseArguments(String[] _argtemp)
    {
       
    }
}
