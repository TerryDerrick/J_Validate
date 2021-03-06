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
public class parser_settings
{
    public String strInputPath;
    
    public String strOutputPath;
    
    public String strFileValidationMask;
    
    public String strSettingsFile;
    
    public String strExtractPath;
    
    public String strSysType;
    
    public parser_settings()
    {
        
    }
    
    public boolean GetSettingsFromSettingsFile()
    {
        // Read from settings file inh object
        // Read each setting in the file and populate the objects feilds after validating them
        // Return true if success / return false if failed for any reason
        
        return false; //if failed
    }
}
