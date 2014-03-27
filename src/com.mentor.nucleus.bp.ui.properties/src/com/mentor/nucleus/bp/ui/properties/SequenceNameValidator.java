//======================================================================
//
// File: SequenceNameValidator.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/BuildPropertySource.arc
// Version:      $Revision: 1.66 $
//
// (c) Copyright 2006-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================

package com.mentor.nucleus.bp.ui.properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.mentor.nucleus.bp.core.Sequence_c;
import com.mentor.nucleus.bp.core.ui.RenameAction;
import com.mentor.nucleus.bp.core.ui.Selection;

public class SequenceNameValidator implements ICellEditorValidator {

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.jface.viewers.ICellEditorValidator#isValid(java.lang.Object)
     */
    public String isValid(Object value) {
        String New_name = (String) value;
        final IStructuredSelection structuredSelection = Selection.getInstance().getStructuredSelection();
        if (structuredSelection.size() > 1) {
            return "Can't happen: selection size > 1";
        }
        Object context = structuredSelection.getFirstElement();
        if (!(context instanceof Sequence_c) ) {
            return "Can't happen: Sequences not selected";
        }
        Sequence_c element = null;
        if (context instanceof Sequence_c) {
            element = (Sequence_c) context;
        }
        IStatus name_ok = RenameAction.validateComponentName(element, New_name);
        if ( !name_ok.isOK() ){
            return name_ok.getMessage();
        }
        return null;
    }

}