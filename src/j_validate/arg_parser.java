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
    private String[] ErrorArgs;
    
    public arg_parser()
    {
        
    }
    
    public void DisplayListofArgs()
    {
        System.out.println("please use the following arguments to specify the program behaviour");
        System.out.println("-i:<input file> \"-i=//data/input/examplefile.txt\"");
    }
    
    public boolean ValidateArguments(String[] _argtemp)
    {
        
        return true;
    }
    
    public void InvalidErrorOutput()
    {
        if ((ErrorArgs == null) || (ErrorArgs.length < 1))
                {
                    System.out.println("Unspecified Invalid Arguments");
                }
        else
        {
            InvalidErrorOutput(ErrorArgs);
        }
        
    }
    
    public void InvalidErrorOutput(String[] _argerr)
    {
        System.out.println("Invalid Arguments");
    }
    
    public void ParseArguments(String[] _argtemp)
    {
        
    }
}
