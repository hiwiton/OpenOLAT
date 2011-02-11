/**
* OLAT - Online Learning and Training<br>
* http://www.olat.org
* <p>
* Licensed under the Apache License, Version 2.0 (the "License"); <br>
* you may not use this file except in compliance with the License.<br>
* You may obtain a copy of the License at
* <p>
* http://www.apache.org/licenses/LICENSE-2.0
* <p>
* Unless required by applicable law or agreed to in writing,<br>
* software distributed under the License is distributed on an "AS IS" BASIS, <br>
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br>
* See the License for the specific language governing permissions and <br>
* limitations under the License.
* <p>
* Copyright (c) 1999-2006 at Multimedia- & E-Learning Services (MELS),<br>
* University of Zurich, Switzerland.
* <p>
*/ 

package org.olat.core.gui.control.winmgr;

import org.json.JSONException;
import org.json.JSONObject;
import org.olat.core.logging.AssertException;

/**
 * Description:<br>
 * Initial Date:  28.03.2006 <br>
 *
 * @author Felix Jost
 */
public class CommandFactory {
	
	/**
	 * tells the ajax-command interpreter to reload the main (=ajax's parent) window
	 * @param redirectURL e.g. /olat/m/10001/
	 * @return the generated command
	 */
	public static Command createParentRedirectTo(String redirectURL) {
		JSONObject root = new JSONObject();
		try {
			root.put("rurl", redirectURL);
		} catch (JSONException e) {
			throw new AssertException("wrong data put into json object", e);
		}
		Command c = new Command(3);
		c.setSubJSON(root);
		return c;
	}
	
	/**
	 * command to replace sub tree of the dom with html-fragments and execute the script-tags of the fragments
	 * @return
	 */
	public static Command createDirtyComponentsCommand() {
		return new Command(2);
	}
	
	/**
	 * command to calculate the needed js lib to add, the needed css to include, and the needed css to hide/remove
	 * @return
	 */
	public static Command createJSCSSCommand() {
		return new Command(7);
	}
	

	/**
	 * - resets the js flag which is set when the user changes form data and is checked when an other link is clicked.(to prevent form data loss).<br>
	 * @return the command 
	 */
	public static Command createPrepareClientCommand(String businessControlPath) {
		JSONObject root = new JSONObject();
		try {
			root.put("bc", businessControlPath==null? "":businessControlPath);
		} catch (JSONException e) {
			throw new AssertException("wrong data put into json object", e);
		}
		Command c = new Command(6);
		c.setSubJSON(root);
		return c;		
	}

	/**
	 * @param res
	 * @return
	 */
	public static Command createParentRedirectForExternalResource(String redirectMapperURL) {
		JSONObject root = new JSONObject();
		try {
			root.put("rurl", redirectMapperURL);
		} catch (JSONException e) {
			throw new AssertException("wrong data put into json object", e);
		}
		Command c = new Command(5);
		c.setSubJSON(root);
		return c;
	}	
	
}


