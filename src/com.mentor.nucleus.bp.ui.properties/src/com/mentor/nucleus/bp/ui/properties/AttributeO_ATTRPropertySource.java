//======================================================================
//
// File: AttributeO_ATTRPropertySource.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/BuildPropertySource.arc
// Version:      $Revision: 1.66 $
//
// (c) Copyright 2006-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================

package com.mentor.nucleus.bp.ui.properties;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.eclipse.ui.views.properties.*;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.*;
import com.mentor.nucleus.bp.core.sorter.MetadataSortingManager;
import com.mentor.nucleus.bp.core.ui.cells.editors.*;
import com.mentor.nucleus.bp.core.util.DimensionsUtil;

public class AttributeO_ATTRPropertySource implements IPropertySource {
	private Attribute_c m_inst;
	private String[] m_DataTypeType;
	private ReferentialAttribute_c[] m_ReferentialAttribute;
	private ClassIdentifierAttribute_c[] m_Identifier;
	private DerivedBaseAttribute_c[] m_DerivedAttribute;
	private NewBaseAttribute_c[] m_NonDerivedAttribute;
	private AttributeReferenceInClass_c[] m_Reference;
	private PropertyDescriptor[] m_propertyDescriptors;
	private String[] Pfx_Mode_vals = {"No Prefix", "Prefix",
			"Referred To Prefix"};
	MetadataSortingManager sorter = MetadataSortingManager.createDefault();

	public AttributeO_ATTRPropertySource(Attribute_c inst) {
		m_inst = inst;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
	public Object getEditableValue() {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang.Object)
	 */
	public boolean isPropertySet(Object id) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java.lang.Object)
	 */
	public void resetPropertyValue(Object id) {
		// do nothing
	}

	public String toString() {
		return m_inst.getName();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (m_inst == null || m_inst.isOrphaned())
			return new IPropertyDescriptor[0];
		int num_children = 0;
		ReferentialAttribute_c[] v_referentialattribute = ReferentialAttribute_c
				.getManyO_RATTRsOnR106((Attribute_c) m_inst);

		m_ReferentialAttribute = v_referentialattribute;
		num_children += m_ReferentialAttribute.length;

		sorter.sort(v_referentialattribute);
		ClassIdentifierAttribute_c[] v_identifier = ClassIdentifierAttribute_c
				.getManyO_OIDAsOnR105((Attribute_c) m_inst);

		m_Identifier = v_identifier;
		num_children += m_Identifier.length;

		sorter.sort(v_identifier);
		DerivedBaseAttribute_c[] v_derivedattribute = DerivedBaseAttribute_c
				.getManyO_DBATTRsOnR107(BaseAttribute_c
						.getManyO_BATTRsOnR106((Attribute_c) m_inst));

		m_DerivedAttribute = v_derivedattribute;
		num_children += m_DerivedAttribute.length;

		sorter.sort(v_derivedattribute);
		NewBaseAttribute_c[] v_nonderivedattribute = NewBaseAttribute_c
				.getManyO_NBATTRsOnR107(BaseAttribute_c
						.getManyO_BATTRsOnR106((Attribute_c) m_inst));

		m_NonDerivedAttribute = v_nonderivedattribute;
		num_children += m_NonDerivedAttribute.length;

		sorter.sort(v_nonderivedattribute);
		AttributeReferenceInClass_c[] v_reference = AttributeReferenceInClass_c
				.getManyO_REFsOnR108(ReferentialAttribute_c
						.getManyO_RATTRsOnR106((Attribute_c) m_inst));

		m_Reference = v_reference;
		num_children += m_Reference.length;

		sorter.sort(v_reference);
		if (m_propertyDescriptors == null
				|| 8 + num_children != m_propertyDescriptors.length) {
			m_propertyDescriptors = new PropertyDescriptor[8 + num_children];
			boolean readonly = false;

			m_propertyDescriptors[0] = new PropertyDescriptor("Name",
					"Attribute Name");
			m_propertyDescriptors[0]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[1] = new DescriptionPropertyDescriptor(
					"Descrip", "Description", m_inst);
			m_propertyDescriptors[1]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[2] = new TextPropertyDescriptor("Prefix",
					"Attribute Name Prefix");
			m_propertyDescriptors[2]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[3] = new TextPropertyDescriptor("Root_Nam",
					"Attribute Root Name");
			m_propertyDescriptors[3]
					.setValidator(new ModelElementNameValidator(m_inst));
			m_propertyDescriptors[3]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[4] = new EnumPropertyDescriptor("Pfx_Mode",
					"Prefix Mode", Pfx_Mode_vals, readonly);
			m_propertyDescriptors[4]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[5] = new DimensionsPropertyDescriptor(
					"Dimensions", "Array Dimensions", readonly);
			m_propertyDescriptors[5].setValidator(new DimensionsValidator(
					(NonRootModelElement) m_inst));
			m_propertyDescriptors[5].setDescription(DimensionsValidator
					.getDimensionsHelpText(readonly));
			m_propertyDescriptors[5]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[6] = new TextPropertyDescriptor(
					"DefaultValue", "Default Value");
			m_propertyDescriptors[6]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);

			int d_index = 7;
			// create combobox descriptor for Data Type
			DataType_c[] set16 = new DataType_c[0];
			DataType_c[] set16_2 = new DataType_c[0];
			// Note that datatypes our handled by the dt chooser dialog
			List list17 = new ArrayList(set16.length + set16_2.length);
			for (int i = 0; i < set16.length; ++i) {
				if (m_inst.Isallowedtype(set16[i].getName())) {
					list17.add(set16[i].getName());
				}
			}
			Collections.sort(list17, new Comparator() {
				Collator coll = Collator.getInstance(Locale.getDefault());
				public int compare(Object a, Object b) {
					return coll.compare((String) a, (String) b);
				}
			});
			m_DataTypeType = new String[list17.size()];
			for (int i = 0; i < list17.size(); ++i) {
				m_DataTypeType[i] = (String) list17.get(i);
			}
			if (!readonly) {
				readonly = (m_ReferentialAttribute.length != 0);
			}
			m_propertyDescriptors[d_index] = new ChooserPropertyDescriptor(
					"DataType",
					"Type",
					m_inst,
					"com.mentor.nucleus.bp.core.ui.actions.SetTypeOnO_ATTRAction",
					readonly);
			m_propertyDescriptors[d_index]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			++d_index;
			for (int i = 0; i < m_ReferentialAttribute.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"ReferentialAttribute." + String.valueOf(i),
						"Referential Attribute");
				m_propertyDescriptors[d_index]
						.setCategory("Referential Attribute");
				++d_index;
			}

			for (int i = 0; i < m_Identifier.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"Identifier." + String.valueOf(i),
						"Class Identifier Attribute");
				m_propertyDescriptors[d_index].setCategory("Identifier");
				++d_index;
			}

			for (int i = 0; i < m_DerivedAttribute.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"DerivedAttribute." + String.valueOf(i),
						"Derived Base Attribute");
				m_propertyDescriptors[d_index].setCategory("Derived Attribute");
				++d_index;
			}

			for (int i = 0; i < m_NonDerivedAttribute.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"NonDerivedAttribute." + String.valueOf(i),
						"New Base Attribute");
				m_propertyDescriptors[d_index]
						.setCategory("Non Derived Attribute");
				++d_index;
			}

			for (int i = 0; i < m_Reference.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"Reference." + String.valueOf(i),
						"Attribute Reference in Class");
				m_propertyDescriptors[d_index].setCategory("Reference");
				++d_index;
			}

		}
		return m_propertyDescriptors;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {
		if (m_inst.isOrphaned()) {
			return "";
		}
		if (id.equals("Name")) {
			return m_inst.getName();
		} else if (id.equals("Descrip")) {
			return m_inst.getDescrip().replace('\n', '/');
		} else if (id.equals("Prefix")) {
			return m_inst.getPrefix();
		} else if (id.equals("Root_Nam")) {
			return m_inst.getRoot_nam();
		} else if (id.equals("Pfx_Mode")) {
			return Pfx_Mode_vals[m_inst.getPfx_mode()];
		} else if (id.equals("Dimensions")) {
			return m_inst.getDimensions();
		} else if (id.equals("DefaultValue")) {
			return m_inst.getDefaultvalue();
		}
		int d_index = 7;
		// getPropertyValue for combobox for Data Type
		if (id.equals("DataType")) {
			DataType_c val = DataType_c.getOneS_DTOnR114((Attribute_c) m_inst);

			ReferentialAttribute_c rattr = ReferentialAttribute_c
					.getOneO_RATTROnR106((Attribute_c) m_inst);
			if (rattr != null) {
				Attribute_c base_attr = Attribute_c
						.getOneO_ATTROnR106(BaseAttribute_c
								.getOneO_BATTROnR113(rattr));
				if (((base_attr == null))) {
					return "same_as<Base_Attribute>";
				} else {
					DataType_c base_dt = DataType_c.getOneS_DTOnR114(base_attr);
					return base_dt.getName();
				}
			} else {
				return val.getName();
			}
		}
		++d_index;
		for (int i = 0; i < m_ReferentialAttribute.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ReferentialAttributeO_RATTRPropertySource(
						m_ReferentialAttribute[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_Identifier.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new IdentifierO_OIDAPropertySource(m_Identifier[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_DerivedAttribute.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new DerivedAttributeO_DBATTRPropertySource(
						m_DerivedAttribute[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_NonDerivedAttribute.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new NonDerivedAttributeO_NBATTRPropertySource(
						m_NonDerivedAttribute[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_Reference.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ReferenceO_REFPropertySource(m_Reference[i]);
			}
			++d_index;
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
		boolean value_changed = false;
		String trans_name = "";
		Transaction tr = null;
		Ooaofooa modelRoot = (Ooaofooa) m_inst.getModelRoot();
		TransactionManager tm = TransactionManager.getSingleton();
		try {
			if (id.equals("Descrip")) {
				if (!value.toString().equals(m_inst.getDescrip())) {
					trans_name = "Change in property: 'Descrip' of Attribute";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setDescrip(value.toString());
				}
			} else if (id.equals("Prefix")) {
				if (!value.toString().equals(m_inst.getPrefix())) {
					trans_name = "Change in property: 'Prefix' of Attribute";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setPrefix(value.toString());
				}
			} else if (id.equals("Root_Nam")) {
				if (!value.toString().equals(m_inst.getRoot_nam())) {
					trans_name = "Change in property: 'Root_Nam' of Attribute";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setRoot_nam(value.toString());
				}
			} else if (id.equals("Pfx_Mode")) {
				int new_val = Integer.parseInt(value.toString());
				if (new_val != m_inst.getPfx_mode()) {
					trans_name = "Change in property: 'Pfx_Mode' of Attribute";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setPfx_mode(new_val);
				}
			} else if (id.equals("Dimensions")) {
				if (!value.toString().equals(m_inst.getDimensions())) {
					trans_name = "Change in property: 'Dimensions' of Attribute";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					Vector dims = DimensionsUtil.getDimensionsData(
							value.toString(), m_inst);
					if (dims.size() > 0) {
						for (int i = 0; i < dims.size(); i++) {
							int numElements = ((Integer) dims.get(i))
									.intValue();
							m_inst.Resizedimensions(i, numElements, dims.size());
						}
					} else {
						m_inst.Resizedimensions(0, 0, 0);
					}
					m_inst.setDimensions(value.toString());
				}
			} else if (id.equals("DefaultValue")) {
				if (!value.toString().equals(m_inst.getDefaultvalue())) {
					trans_name = "Change in property: 'DefaultValue' of Attribute";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setDefaultvalue(value.toString());
				}
			}

			int d_index = 7;
			if (id.equals("DataType")) {
				DataType_c val = DataType_c
						.getOneS_DTOnR114((Attribute_c) m_inst);

				if (!value.equals(val.getName())) {
					DataType_c[] set18_1 = new DataType_c[0];
					DataType_c[] set18_2 = new DataType_c[0];
					if (m_inst.isInGenericPackage()) {
						Package_c pkg = m_inst.getFirstParentPackage();
						Component_c component = m_inst
								.getFirstParentComponent();
						if ((pkg != null)) {
							pkg.Clearscope();
							pkg.Collectvisibleelementsforname(false,
									Gd_c.Null_unique_id(), false, "",
									pkg.getPackage_id(),
									Elementtypeconstants_c.DATATYPE);

							class SearchResultSet_test24870_c
									implements
										ClassQueryInterface_c {
								public boolean evaluate(Object candidate) {
									SearchResultSet_c selected = (SearchResultSet_c) candidate;
									return selected.getName().equals("")
											&& selected.getType() == Elementtypeconstants_c.DATATYPE;
								}
							}
							SearchResultSet_c v_resultSet = SearchResultSet_c
									.getOnePE_SRSOnR8005(pkg,
											new SearchResultSet_test24870_c());

							set18_2 = DataType_c
									.getManyS_DTsOnR8001(PackageableElement_c
											.getManyPE_PEsOnR8002(ElementVisibility_c
													.getManyPE_VISsOnR8006(v_resultSet)));
						} else {
							if (component != null) {
								component.Clearscope();
								component.Collectvisibleelementsforname(false,
										Gd_c.Null_unique_id(), "",
										component.getId(),
										Elementtypeconstants_c.DATATYPE);

								class ComponentResultSet_test24870_c
										implements
											ClassQueryInterface_c {
									public boolean evaluate(Object candidate) {
										ComponentResultSet_c selected = (ComponentResultSet_c) candidate;
										return selected.getName().equals("")
												&& selected.getType() == Elementtypeconstants_c.DATATYPE;
									}
								}
								ComponentResultSet_c v_resultSet = ComponentResultSet_c
										.getOnePE_CRSOnR8007(
												component,
												new ComponentResultSet_test24870_c());

								set18_2 = DataType_c
										.getManyS_DTsOnR8001(PackageableElement_c
												.getManyPE_PEsOnR8004(ComponentVisibility_c
														.getManyPE_CVSsOnR8008(v_resultSet)));

							} else {
								// only throw an error the the element owning
								// this property source, are expected to not
								// have a package or component (the cases that
								// are not are UDTs that are built in)  Note that
								// the tool will behave properly, as the field
								// for these are read-only.
								if (!m_inst.selfIsCoreDataType()) {
									Throwable t = new Throwable();
									t.fillInStackTrace();
									CorePlugin
											.logError(
													"Attempted to call an operation on a null instance.",
													t);
								}
							}

						}
					}

					else {
						Domain_c domain = Domain_c
								.getOneS_DOMOnR1(Subsystem_c.getOneS_SSOnR2(ModelClass_c
										.getOneO_OBJOnR102((Attribute_c) m_inst)));
						set18_1 = DataType_c.getManyS_DTsOnR14(domain);
						set18_2 = DataType_c
								.getManyS_DTsOnR4401(SystemDatatypeInPackage_c.getManySLD_SDINPsOnR4402(SystemModel_c
										.getManyS_SYSsOnR4606(ComponentPackage_c
												.getManyCP_CPsOnR4608(Component_c
														.getManyC_CsOnR4204(DomainAsComponent_c
																.getManyCN_DCsOnR4204(domain))))));
					} // end isInGenericPackage
						// copy the system level data types into the
						// domain level data types array
					DataType_c[] set18_3 = new DataType_c[0];
					if (((SystemModel_c) m_inst.getRoot()).getUseglobals() == true) {
						set18_3 = DataType_c
								.getManyS_DTsOnR8001(PackageableElement_c
										.getManyPE_PEsOnR9100(GlobalElementInSystem_c
												.getManyG_EISsOnR9100((SystemModel_c) this.m_inst
														.getRoot())));
					}
					DataType_c[] set18 = new DataType_c[set18_1.length
							+ set18_2.length + +set18_3.length];
					System.arraycopy(set18_1, 0, set18, 0, set18_1.length);
					System.arraycopy(set18_2, 0, set18, set18_1.length,
							set18_2.length);
					System.arraycopy(set18_3, 0, set18, set18_1.length
							+ set18_2.length, set18_3.length);
					for (int i = 0; i < set18.length; ++i) {
						if (value.equals(set18[i].getName())) {
							trans_name = "Change in property: 'Type' of Attribute"; //$NON-NLS-1$
							tr = tm.startTransaction(trans_name,
									Ooaofooa.getDefaultInstance());
							m_inst.unrelateAcrossR114From(val);
							m_inst.relateAcrossR114To(set18[i]);
							value_changed = true;
							break;
						}
					}
				}
			}
			++d_index;

			// catch all exceptions and cancel the transaction
		} catch (Exception e) {
			// this can be null if there was
			// an exception starting the
			// transaction
			if (tr != null) {
				tm.cancelTransaction(tr, e);
				tr = null;
			}
			CorePlugin.logError("Transaction: " + trans_name
					+ " could not complete", e);
		}
		if (tr != null) {
			if (value_changed)
				tm.endTransaction(tr);
			else
				tm.cancelTransaction(tr);
		}
	}
}