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
public class CommandObject 
{
    public String Command;
    public int ParamCount;
    public String ExampleCommandWin;
    public String ExampleCommandNix;
    public String ExampleCommandMac;
    public String CommandHelpText;
    
    public CommandObject NextCommandObject;
    public CommandObject PrevCommandObject;

    
    public CommandObject()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    public CommandObject(String _strCommand, int _intParamCount, String _strExampleString, String _strExampleStringNix, String _strExampleStringMac, String _strCommandHelpText)
    {
        Command = _strCommand;
        ParamCount = _intParamCount;
        ExampleCommandWin = _strExampleString;
        ExampleCommandNix = _strExampleStringNix;
        ExampleCommandMac = _strExampleStringMac;
        CommandHelpText = _strCommandHelpText;
    }
}
