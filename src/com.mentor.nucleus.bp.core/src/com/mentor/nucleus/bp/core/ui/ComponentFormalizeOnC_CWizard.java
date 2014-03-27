package com.mentor.nucleus.bp.core.ui;
//====================================================================
//
// File:    ComponentFormalizeOnC_CWizard.java
//
// WARNING: Do not edit this generated file
// Generated by arc/wizard.inc
//
// (c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.
//
//====================================================================
import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.*;
import org.eclipse.ui.IWorkbench;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.*;
import com.mentor.nucleus.bp.core.util.TransactionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ComponentFormalizeOnC_CWizard class
 */
public class ComponentFormalizeOnC_CWizard extends Wizard {
	public static final String copyright = "(c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.";

	// workbench selection when the wizard was started
	protected IStructuredSelection m_selection;

	// the workbench instance
	protected IWorkbench m_workbench;

	// the viewer the wizard was started from. This must be replaced with a listener system
	protected Viewer m_viewer;

	// Pages stack
	protected Stack m_pagesStack = new Stack();

	// wizard pages
	ComponentFormalizeOnC_CWizardPage3 C_C_ComponentFormalizePage3;

	// wizard state
	// constants
	protected static final int INITIAL_WIZARD_STATE = -1;
	protected static final int C_C_COMPONENTFORMALIZE0_WIZARD_STATE = 0;
	// member
	protected int m_state = INITIAL_WIZARD_STATE;
	// end wizard state

	// cache for contextual selections (public for use by unit tests)
	public Component_c v_component = null;

	// cache for the users selections (public for use by unit tests)
	public Domain_c v_Domain = null;

	/**
	 * Constructor for ComponentFormalizeOnC_CWizard.
	 */
	public ComponentFormalizeOnC_CWizard() {
		super();
	}

	/**
	 * See field.
	 */
	public IStructuredSelection getSelection() {
		return m_selection;
	}

	public void addPages() {
		C_C_ComponentFormalizePage3 = new ComponentFormalizeOnC_CWizardPage3(
				"ComponentFormalizeOnC_CWizardPage3");
		addPage(C_C_ComponentFormalizePage3);
	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection,
			Viewer viewer) {
		this.m_workbench = workbench;
		this.m_selection = selection;
		this.m_viewer = viewer;
		for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
			Object context = iterator.next();
			if (context instanceof Component_c) {
				v_component = (Component_c) context;
			}
		}
	}

	public boolean canFinish() {
		boolean pagesComplete = true;
		pagesComplete = pagesComplete
				&& C_C_ComponentFormalizePage3.isPageComplete();
		return pagesComplete;
	}

	public IWizardPage getNextPage(IWizardPage page) {
		List pages = new ArrayList(getPages().length);
		for (int i = 0; i < getPages().length; i++) {
			pages.add(getPages()[i]);
		}
		switch (pages.indexOf(page)) {
			case C_C_COMPONENTFORMALIZE0_WIZARD_STATE :
				return null;
		}
		return null;
	}

	public IWizardPage getPreviousPage(IWizardPage page) {
		if (m_pagesStack.empty()) {
			return null;
		} else {
			List pages = new ArrayList(getPages().length);
			for (int i = 0; i < getPages().length; i++) {
				pages.add(getPages()[i]);
			}
			m_state = pages.indexOf((IWizardPage) m_pagesStack.peek());
			((PtWizardPage) m_pagesStack.peek()).onPageEntry();
			return (IWizardPage) m_pagesStack.pop();
		}
	}

	public boolean performFinish() {
		TransactionUtil.TransactionGroup transactionGroup = null;
		ModelRoot modelRoot = v_component.getModelRoot();
		try {
			transactionGroup = TransactionUtil
					.startTransactionsOnSelectedModelRoots("Component Formalize"); //$NON-NLS-1$
			if (((v_component != null))) {

				ComponentPackage_c v_componentPackage = ComponentPackage_c
						.getOneCP_CPOnR4604(v_component);

				if (((v_componentPackage == null))) {

					Component_c v_componentParent = Component_c
							.getOneC_COnR4202(ComponentInComponent_c
									.getOneCN_CICOnR4203(v_component));

					while (((v_componentPackage == null))) {

						v_componentPackage = ComponentPackage_c
								.getOneCP_CPOnR4604(v_componentParent);

						v_componentParent = Component_c
								.getOneC_COnR4202(ComponentInComponent_c
										.getOneCN_CICOnR4203(v_componentParent));

					}

				}

				if ((!(v_componentPackage == null))) {

					SystemModel_c v_system = SystemModel_c
							.getOneS_SYSOnR4606(v_componentPackage);

					if (v_component != null) {
						v_component.Formalize(v_Domain.getDom_id());
					} else {
						Throwable t = new Throwable();
						t.fillInStackTrace();
						CorePlugin
								.logError(
										"Attempted to call an operation on a null instance.",
										t);
					}

				}

			}

			// catch all exceptions and cancel the transaction
		} catch (Exception e) {
			if (transactionGroup != null)
				TransactionUtil.cancelTransactions(transactionGroup, e);
			CorePlugin.logError("Transaction: Component Formalize failed", e);//$NON-NLS-1$
			// return true so that the wizard will
			// close
			return true;
		}
		if (transactionGroup != null)
			TransactionUtil.endTransactions(transactionGroup);
		if (m_viewer != null) {
			if (m_viewer instanceof StructuredViewer) {
				((StructuredViewer) m_viewer).refresh(v_component);
			} else {
				m_viewer.refresh();
			}
		}
		return true;
	}
}