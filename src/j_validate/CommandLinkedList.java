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
public class CommandLinkedList 
{
    public CommandObject ListStart;
    
    public void CommandLinkedList()
    {
        // throws null pointer exception
    }
    
    public void InsertCommandIntoList(String _strCommand, int _intParamCount, String _strExampleString)
    {
        CommandObject NewCommandObject = new CommandObject(_strCommand,_intParamCount,_strExampleString);
        CommandObject TempObject = ListStart;
        if (TempObject == null)
        {
            TempObject = NewCommandObject;
        }
        else    
        {
            TempObject = FindLastObjectInList(ListStart);
            TempObject.NextCommandObject = NewCommandObject;
        }
    }
    
    
    public boolean FindCommandInListReturnValid(String _strSearchString)
    {
        if (FindObjectInList(_strSearchString) != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int FindCommandInListReturnParams(String _strSearchString)
    {
        if (FindObjectInList(_strSearchString) != null)
        {
            CommandObject _temp = FindObjectInList(_strSearchString);
            return _temp.ParamCount;
        }
        else
        {
            return 0;
        }
    }
    
    private CommandObject FindObjectInList(String _strSearch)
    {
       CommandObject CommandObjectHolder;
       CommandObjectHolder = ListStart;
       
       while(CommandObjectHolder != null)
       {
           if (CommandObjectHolder.Command.toUpperCase().equals(_strSearch.toUpperCase()))
           {
               return CommandObjectHolder;
           }
           else
           {
                CommandObjectHolder = CommandObjectHolder.NextCommandObject;
           }
       }
       // Return null if no object matching the search is found.
        return null;
    }
    
    private CommandObject FindLastObjectInList(CommandObject _tempObject)
    {
        while (_tempObject != null)
        {
          if (_tempObject.NextCommandObject != null)
          {
              _tempObject = _tempObject.NextCommandObject;
          }
         
        }
        return _tempObject;
    }
}
