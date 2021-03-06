package com.mentor.nucleus.bp.ui.graphics.requests;
//=====================================================================
//
// File:      $RCSfile: TextEditPartChangeBoundsRequest.java,v $
// Version:   $Revision: 1.2.188.1 $
// Modified:  $Date: 2013/01/29 22:09:40 $
//
//
//=====================================================================
// © 2013 Mentor Graphics Corporation
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//=====================================================================

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;

public class TextEditPartChangeBoundsRequest extends ChangeBoundsRequest {

	private GraphicalEditPart target;

	public TextEditPartChangeBoundsRequest(String type, GraphicalEditPart target) {
		super(type);
		this.target = target;
	}

	public GraphicalEditPart getTarget() {
		return target;
	}
}
