package com.mentor.nucleus.bp.ui.explorer.adapters;
//======================================================================
//
// File: com/mentor/nucleus/bp/ui/explorer/adapters/IncomingReturnMessagesAdapter.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/create_adapters.inc
// Version:      $Revision: 1.31 $
//
// (c) Copyright 2006-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================
//
// This class is responsible for decoupling the client model entity
// class ReturnMessage_c from the tree viewer and the hierarchy
// it imposes.
//
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import com.mentor.nucleus.bp.core.*;

import com.mentor.nucleus.bp.ui.explorer.*;
/**
 * This file adapts the meta-model entity; 'ReturnMessage_c'
 * so that it works with the Eclipse JFace user interface components.
 * <p>
 * Do not edit this class, it was created using the Mentor 
 * Graphics MC-Java code generator product.
 * </p>
 */
public class IncomingReturnMessagesAdapter implements ITreeContentProvider {
	static IncomingReturnMessagesAdapter incomingreturnmessagesadapter = null;
	/**
	 * Returns the adapters singleton instance. If this
	 * is the first time, the instance is created.
	 */
	public static IncomingReturnMessagesAdapter getInstance() {
		if (incomingreturnmessagesadapter == null) {
			incomingreturnmessagesadapter = new IncomingReturnMessagesAdapter();
		}
		return incomingreturnmessagesadapter;
	}
	/**
	 * @see IContentProvider#inputChanged(Viewer, Object, Object)
	 * Called when the tree's input has been changed
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing to do
	}
	/**
	 * @see IContentProvider#dispose()
	 * Called when this viewer is no longer needed
	 */
	public void dispose() {
		// Nothing to dispose
	}
	/**
	 * @see ITreeContentProvider#getParent(Object)
	 * Returns the parent of this node
	 */
	public Object getParent(Object arg) {
		ClassInstanceParticipant_c result105 = ClassInstanceParticipant_c
				.getOneSQ_CIPOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)));
		if (result105 != null) {
			return result105;
		}
		ClassInstanceParticipant_c result106 = ClassInstanceParticipant_c
				.getOneSQ_CIPOnR930(InteractionParticipant_c.getOneSQ_POnR940(Lifespan_c.getOneSQ_LSOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)))));
		if (result106 != null) {
			return result106;
		}
		ClassParticipant_c result107 = ClassParticipant_c
				.getOneSQ_CPOnR930(InteractionParticipant_c.getOneSQ_POnR940(Lifespan_c.getOneSQ_LSOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)))));
		if (result107 != null) {
			return result107;
		}
		ClassParticipant_c result108 = ClassParticipant_c
				.getOneSQ_CPOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)));
		if (result108 != null) {
			return result108;
		}
		ExternalEntityParticipant_c result109 = ExternalEntityParticipant_c
				.getOneSQ_EEPOnR930(InteractionParticipant_c.getOneSQ_POnR940(Lifespan_c.getOneSQ_LSOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)))));
		if (result109 != null) {
			return result109;
		}
		ExternalEntityParticipant_c result110 = ExternalEntityParticipant_c
				.getOneSQ_EEPOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)));
		if (result110 != null) {
			return result110;
		}
		FunctionPackageParticipant_c result111 = FunctionPackageParticipant_c
				.getOneSQ_FPPOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)));
		if (result111 != null) {
			return result111;
		}
		FunctionPackageParticipant_c result112 = FunctionPackageParticipant_c
				.getOneSQ_FPPOnR930(InteractionParticipant_c.getOneSQ_POnR940(Lifespan_c.getOneSQ_LSOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)))));
		if (result112 != null) {
			return result112;
		}
		PackageParticipant_c result113 = PackageParticipant_c
				.getOneSQ_PPOnR930(InteractionParticipant_c.getOneSQ_POnR940(Lifespan_c.getOneSQ_LSOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)))));
		if (result113 != null) {
			return result113;
		}
		PackageParticipant_c result114 = PackageParticipant_c
				.getOneSQ_PPOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)));
		if (result114 != null) {
			return result114;
		}
		ActorParticipant_c result115 = ActorParticipant_c
				.getOneSQ_APOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)));
		if (result115 != null) {
			return result115;
		}
		ActorParticipant_c result116 = ActorParticipant_c
				.getOneSQ_APOnR930(InteractionParticipant_c.getOneSQ_POnR940(Lifespan_c.getOneSQ_LSOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)))));
		if (result116 != null) {
			return result116;
		}
		ComponentParticipant_c result117 = ComponentParticipant_c
				.getOneSQ_COPOnR930(InteractionParticipant_c.getOneSQ_POnR940(Lifespan_c.getOneSQ_LSOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)))));
		if (result117 != null) {
			return result117;
		}
		ComponentParticipant_c result118 = ComponentParticipant_c
				.getOneSQ_COPOnR930(InteractionParticipant_c
						.getOneSQ_POnR1007(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)));
		if (result118 != null) {
			return result118;
		}
		Communication_c result119 = Communication_c
				.getOneCOMM_COMMOnR1135(MessageInCommunication_c
						.getOneCOMM_MICOnR1135(Message_c
								.getOneMSG_MOnR1018((ReturnMessage_c) arg)));
		if (result119 != null) {
			return result119;
		}
		return null;
	}
	/**
	 * @see IStructuredContentProvider#getElements(Object)
	 * Returns the elements below this node
	 */
	public Object[] getElements(Object arg) {
		return getChildren(arg);
	}

	/**
	 * @see ITreeContentProvider#getChildren(Object)
	 * Returns the children of this node
	 */
	public Object[] getChildren(Object arg) {
		int resultSize = 0;
		MessageArgument_c[] informalmessagearguments_1018_1 = MessageArgument_c
				.getManyMSG_AsOnR1000(Message_c
						.getManyMSG_MsOnR1018((ReturnMessage_c) arg));

		ModelContentProvider.sort(informalmessagearguments_1018_1);
		resultSize += informalmessagearguments_1018_1.length;

		Object[] result = new Object[resultSize];
		int count = 0;
		for (int i = 0; i < informalmessagearguments_1018_1.length; i++) {
			result[count] = informalmessagearguments_1018_1[i];
			count++;
		}
		return result;
	}
	/**
	 * @see ITreeContentProvider#hasChildren(Object)
	 * Returns true if this node has any children
	 */
	public boolean hasChildren(Object arg) {
		MessageArgument_c[] informalmessagearguments_1018_1 = MessageArgument_c
				.getManyMSG_AsOnR1000(Message_c
						.getManyMSG_MsOnR1018((ReturnMessage_c) arg));

		if (informalmessagearguments_1018_1.length > 0)
			return true;
		return false;
	}
}