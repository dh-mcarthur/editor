//========================================================================
//
//File:      $RCSfile: ShowLayerAction.java,v $
//Version:   $Revision: 1.5.12.2 $
//Modified:  $Date: 2013/01/29 22:09:21 $
//
//
//========================================================================
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
//======================================================================== 
package com.mentor.nucleus.bp.ui.graphics.actions;

import org.eclipse.jface.action.Action;

import com.mentor.nucleus.bp.core.CorePlugin;
import com.mentor.nucleus.bp.core.common.ClassQueryInterface_c;
import com.mentor.nucleus.bp.core.common.Transaction;
import com.mentor.nucleus.bp.core.common.TransactionManager;
import com.mentor.nucleus.bp.ui.canvas.Layer_c;
import com.mentor.nucleus.bp.ui.canvas.Model_c;
import com.mentor.nucleus.bp.ui.canvas.Ooaofgraphics;
import com.mentor.nucleus.bp.ui.graphics.editor.GraphicalEditor;
import com.mentor.nucleus.bp.ui.graphics.layers.UserDefinedLayer;
import com.mentor.nucleus.bp.ui.graphics.parts.DiagramEditPart;

public class ShowLayerAction extends Action {

	private String layerName;
	private Model_c model;

	public ShowLayerAction(String layerName, Model_c model) {
		this.layerName = layerName;
		this.model = model;
	}

	@Override
	public void run() {
		Layer_c layer = Layer_c.getOneGD_LAYOnR34(model,
				new ClassQueryInterface_c() {

					@Override
					public boolean evaluate(Object candidate) {
						return ((Layer_c) candidate).getLayer_name().equals(
								layerName);
					}
				});
		if (layer != null) {
			Transaction transaction = null;
			TransactionManager manager = TransactionManager.getSingleton();
			try {
				transaction = manager.startTransaction("Show layer",
						Ooaofgraphics.getDefaultInstance());
				layer.setVisible(true);
				// if editing is enabled, disable it
				DiagramEditPart diagramPart = ((DiagramEditPart) GraphicalEditor.getEditor(model)
						.getGraphicalViewer().getContents());
				UserDefinedLayer.getLayer(layer, diagramPart).setEditing(false);
				diagramPart.getFigure().repaint();
				manager.endTransaction(transaction);
				GraphicalEditor.redrawAll();
			} catch (Exception e) {
				if (transaction != null) {
					manager.cancelTransaction(transaction);
				}
				CorePlugin.logError("Unable to toggle layer visibility.", e);
			}
		}
	}

}
