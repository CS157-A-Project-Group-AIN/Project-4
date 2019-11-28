package etrt;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ResponseObjects.*;
import QueryHandlers.Handlers;

public class ETRTDriver {
	// ******************************************All global variables are
	// here******************************************************
	private JFrame frame;
	private JPanel panelContainer;

	// main page
	private JPanel mainPanel;
	private JButton mainPatientsButton;
	private JButton mainVisitsButton;
	private JButton mainAnalyticsButton;
	private JButton mainOtherButton;

	// patients page
	private JPanel patientsPanel;
	private JButton patientsBack;
	private JButton patientsAddNew;
	private JButton patientsViewEdit;

	// add patients page
	private JPanel addPatientPanel;
	private JLabel apLblThi;
	private JLabel apLblFirstName;
	private JLabel apLblFirstName_1;
	private JLabel apLblMiddleName;
	private JLabel apLblDateOfBirth;
	private JLabel apLblSsn;
	private JLabel apLblInsurance;
	private JTextField apTxtUuidHere;
	private JTextField apTextField_1;
	private JTextField apTextField_2;
	private JTextField apTextField_3;
	private JTextField apTextField_4;
	private JTextField apTextField_5;
	private JTextField apTextField_6;
	private JButton apBtnSave;
	private JButton apBtnAddVisit;
	private JButton apBtnCancel;
	private JButton apBtnBack;

	// visits page
	private JPanel visitsPanel;
	private JButton visitsBack;
	private JButton visitsAddNew;
	private JButton visitsViewEdit;

	// add visits page
	private JPanel addVisitPanel;
	private JTextField avTextField;
	private JTextField avTextField_1;
	private JTextField avTextField_2;
	private JTextField avTextField_3;
	private JTextField avTextField_4;
	private JTextField avTextField_5;
	private JTextField avTextField_6;
	private JTextField avTextField_7;
	private JTextField avTextField_8;
	private JTextField avTextField_9;
	private JTextField avTextField_10;
	private JButton avBtnBack;
	private JButton avBtnSave;
	private JButton avBtnCancel;
	private JButton avBtnPharm;
	private JButton avBtnAudiology;

	// visit Pharmacology page
	private JPanel visPharmPanel;
	private JTextField vpTextField;
	private JTextField vpTextField_1;
	private JTextField vpTextField_2;
	private JTable vpTable;
	private JTextField vpTextField_3;
	private JTextField vpTextField_4;
	private JButton vpBtnBack;
	private JButton vpBtnCancel;

	// other page
	private JPanel otherPanel;
	private JButton oBtnBack;
	private JButton oBtnPharmData;

	// pharmacology data page
	private JPanel pharmDataPanel;
	private JButton pdBtnBack;
	private JButton pdBtnAEChemical;
	private JButton pdBtnAEGeneric;
	private JButton pdBtnAEDisease;
	private JButton pdBtnAEMedication;

	// Add/Edit Chemicals page
	private JPanel aeChemDataPanel;
	private JTextField chmTextField_id;
	private JTextField chmTextField_name;
	private JTextArea chmTextArea_desc;
	private JTextField chmTextField_nameSearch;
	private JTextField chmTextField_idSearch;
	private JTextField chmTextField_resID;
	private JTextField chmTextField_resName;
	private JTextArea chmTextArea_resDesc;
	private DefaultTableModel chmResModel;
	private JTable chmResTable;
	private JButton chmBtnBack;
	private JButton chmBtnAdd;
	private JButton chmBtnSearch;

	// Add/Edit Generics page
	private JPanel aeGenDataPanel;
	private JTextField genTextField_id;
	private JTextField genTextField_name;
	private JTextArea genTextArea_desc;
	private JTextField genTextField_nameSearch;
	private JTextField genTextField_idSearch;
	private JTextField genTextField_resID;
	private JTextField genTextField_resName;
	private JTextArea genTextArea_resDesc;
	private DefaultTableModel genResModel;
	private JTable genResTable;
	private JButton genBtnBack;
	private JButton genBtnAdd;
	private JButton genBtnSearch;
	private JButton genBtnSubmit;


	// Add/Edit Disease page
	private JPanel aeDisDataPanel;
	private JTextField disTextField_id;
	private JTextField disTextField_name;
	private JTextArea disTextArea_desc;
	private JTextField disTextField_nameSearch;
	private JTextField disTextField_idSearch;
	private JTextField disTextField_resID;
	private JTextField disTextField_resName;
	private JTextArea disTextArea_resDesc;
	private JTable disResTable;
	private DefaultTableModel disResModel;
	private JButton disBtnBack;
	private JButton disBtnAdd;
	private JButton disBtnSearch;
	private JButton disBtnSubmit;

	// Add/Edit Medication page
	private JPanel aeMedDataPanel;
	private JTextField medTextField_id;
	private JTextField medTextField_name;
	private JTextArea medTextArea_desc;
	private JTextField medTextField_dose;
	private JTextField medTextField_nameSearch;
	private JTextField medTextField_idSearch;
	private JTextField medTextField_resID;
	private JTextField medTextField_resName;
	private JTextArea medTextArea_resDesc;
	private DefaultTableModel medResModel;
	private JTable medResTable;
	private JTextField medTextField_resDose;
	private JComboBox medcomboBox_generic;
	private JComboBox medcomboBox_chemical;
	private JComboBox medcomboBox_disease;
	private JComboBox medcomboBox_resGen;
	private JComboBox medcomboBox_resChm;
	private JComboBox medcomboBox_resDis;

	private JButton medBtnBack;
	private JButton medBtnAdd;
	private JButton medBtnSearch;

	// audiology page
	private JPanel audioPanel;
	private JTextField[] audPrePopTextFields;
	private JTextField[] audInpTextFields;
	private JButton audBtnBack;

	final Handlers handlers = new Handlers();

	public ETRTDriver() {
		frame = new JFrame("ETRT System");
		frame.setSize(600, 400);

		// ******************************************This section contains all GUI code*************************************************
		// If you need to read or push data to/from a component in a view, look for its
		// label in the section below. Change it from a local
		// variable to a global by putting its declaration in the header above this
		// constructor. Some are already there by default. Then
		// you can use that variable in the ActionListener section.
		// Note that any variables with the prefix gbl_ or gbc_ are constraints for the
		// GUI, and will not be used functionally
		// *****************************************************************************************************************************

		// MAIN PAGE********************************************************************************************************************
		mainPanel = new JPanel();
		mainPatientsButton = new JButton("Patients");
		mainVisitsButton = new JButton("Visits");
		mainAnalyticsButton = new JButton("Analytics");
		mainAnalyticsButton.setEnabled(false);
		mainOtherButton = new JButton("Other");
		mainPanel.add(mainPatientsButton);
		mainPanel.add(mainVisitsButton);
		mainPanel.add(mainAnalyticsButton);
		mainPanel.add(mainOtherButton);
		GridLayout mainLayout = new GridLayout();
		mainLayout.setRows(2);
		mainLayout.setColumns(2);
		mainLayout.setHgap(40);
		mainLayout.setVgap(40);
		mainPanel.setLayout(mainLayout);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

		// PATIENTS PAGE********************************************************************************************************************
		patientsPanel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 140, 140, 20, 140, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 61, 100, 61, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		patientsPanel.setLayout(gbl_panel);

		patientsBack = new JButton("Back");
		GridBagConstraints gbc_apBtnBack = new GridBagConstraints();
		gbc_apBtnBack.anchor = GridBagConstraints.WEST;
		gbc_apBtnBack.insets = new Insets(0, 0, 5, 5);
		gbc_apBtnBack.gridx = 0;
		gbc_apBtnBack.gridy = 0;
		patientsPanel.add(patientsBack, gbc_apBtnBack);

		patientsAddNew = new JButton("Add New Patient");
		GridBagConstraints gbc_apBtnAddNew = new GridBagConstraints();
		gbc_apBtnAddNew.fill = GridBagConstraints.BOTH;
		gbc_apBtnAddNew.insets = new Insets(0, 0, 5, 5);
		gbc_apBtnAddNew.gridx = 1;
		gbc_apBtnAddNew.gridy = 2;
		patientsPanel.add(patientsAddNew, gbc_apBtnAddNew);

		patientsViewEdit = new JButton("View/Edit Patients");
		patientsViewEdit.setEnabled(false);
		GridBagConstraints gbc_apBtnEditview = new GridBagConstraints();
		gbc_apBtnEditview.fill = GridBagConstraints.BOTH;
		gbc_apBtnEditview.insets = new Insets(0, 0, 5, 5);
		gbc_apBtnEditview.gridx = 3;
		gbc_apBtnEditview.gridy = 2;
		patientsPanel.add(patientsViewEdit, gbc_apBtnEditview);

		// ADD PATIENTS PAGE********************************************************************************************************************
		addPatientPanel = new JPanel();
		GridBagLayout gbl_addPatientPanel = new GridBagLayout();
		gbl_addPatientPanel.columnWidths = new int[] { 0, 0, 87, 90, 0, 0 };
		gbl_addPatientPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_addPatientPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_addPatientPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		addPatientPanel.setLayout(gbl_addPatientPanel);

		apBtnBack = new JButton("Back");
		GridBagConstraints gbc_apbtnBack = new GridBagConstraints();
		gbc_apbtnBack.anchor = GridBagConstraints.WEST;
		gbc_apbtnBack.insets = new Insets(0, 0, 5, 5);
		gbc_apbtnBack.gridx = 0;
		gbc_apbtnBack.gridy = 0;
		addPatientPanel.add(apBtnBack, gbc_apbtnBack);

		apLblThi = new JLabel("THC ");
		GridBagConstraints gbc_apLblThi = new GridBagConstraints();
		gbc_apLblThi.anchor = GridBagConstraints.EAST;
		gbc_apLblThi.insets = new Insets(0, 0, 5, 5);
		gbc_apLblThi.gridx = 0;
		gbc_apLblThi.gridy = 1;
		addPatientPanel.add(apLblThi, gbc_apLblThi);

		apTxtUuidHere = new JTextField();
		apTxtUuidHere.setEditable(false);
		GridBagConstraints gbc_txtUuidHere = new GridBagConstraints();
		gbc_txtUuidHere.gridwidth = 4;
		gbc_txtUuidHere.insets = new Insets(0, 0, 5, 0);
		gbc_txtUuidHere.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUuidHere.gridx = 1;
		gbc_txtUuidHere.gridy = 1;
		addPatientPanel.add(apTxtUuidHere, gbc_txtUuidHere);
		apTxtUuidHere.setColumns(10);

		apLblFirstName = new JLabel("Last Name ");
		GridBagConstraints gbc_apLblFirstName = new GridBagConstraints();
		gbc_apLblFirstName.anchor = GridBagConstraints.EAST;
		gbc_apLblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_apLblFirstName.gridx = 0;
		gbc_apLblFirstName.gridy = 2;
		addPatientPanel.add(apLblFirstName, gbc_apLblFirstName);

		apTextField_1 = new JTextField();
		apTextField_1.setEditable(false);
		GridBagConstraints gbc_apTextField_1 = new GridBagConstraints();
		gbc_apTextField_1.gridwidth = 4;
		gbc_apTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_1.gridx = 1;
		gbc_apTextField_1.gridy = 2;
		addPatientPanel.add(apTextField_1, gbc_apTextField_1);
		apTextField_1.setColumns(10);

		apLblFirstName_1 = new JLabel("First Name ");
		GridBagConstraints gbc_apLblFirstName_1 = new GridBagConstraints();
		gbc_apLblFirstName_1.anchor = GridBagConstraints.EAST;
		gbc_apLblFirstName_1.insets = new Insets(0, 0, 5, 5);
		gbc_apLblFirstName_1.gridx = 0;
		gbc_apLblFirstName_1.gridy = 3;
		addPatientPanel.add(apLblFirstName_1, gbc_apLblFirstName_1);

		apTextField_2 = new JTextField();
		apTextField_2.setEditable(false);
		GridBagConstraints gbc_apTextField_2 = new GridBagConstraints();
		gbc_apTextField_2.gridwidth = 4;
		gbc_apTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_2.gridx = 1;
		gbc_apTextField_2.gridy = 3;
		addPatientPanel.add(apTextField_2, gbc_apTextField_2);
		apTextField_2.setColumns(10);

		apLblMiddleName = new JLabel("Middle Name ");
		GridBagConstraints gbc_apLblMiddleName = new GridBagConstraints();
		gbc_apLblMiddleName.anchor = GridBagConstraints.EAST;
		gbc_apLblMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_apLblMiddleName.gridx = 0;
		gbc_apLblMiddleName.gridy = 4;
		addPatientPanel.add(apLblMiddleName, gbc_apLblMiddleName);

		apTextField_3 = new JTextField();
		apTextField_3.setEditable(false);
		GridBagConstraints gbc_apTextField_3 = new GridBagConstraints();
		gbc_apTextField_3.gridwidth = 4;
		gbc_apTextField_3.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_3.gridx = 1;
		gbc_apTextField_3.gridy = 4;
		addPatientPanel.add(apTextField_3, gbc_apTextField_3);
		apTextField_3.setColumns(10);

		apLblDateOfBirth = new JLabel("Date of Birth ");
		GridBagConstraints gbc_apLblDateOfBirth = new GridBagConstraints();
		gbc_apLblDateOfBirth.anchor = GridBagConstraints.EAST;
		gbc_apLblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_apLblDateOfBirth.gridx = 0;
		gbc_apLblDateOfBirth.gridy = 5;
		addPatientPanel.add(apLblDateOfBirth, gbc_apLblDateOfBirth);

		apTextField_4 = new JTextField();
		apTextField_4.setEditable(false);
		GridBagConstraints gbc_apTextField_4 = new GridBagConstraints();
		gbc_apTextField_4.gridwidth = 4;
		gbc_apTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_4.gridx = 1;
		gbc_apTextField_4.gridy = 5;
		addPatientPanel.add(apTextField_4, gbc_apTextField_4);
		apTextField_4.setColumns(10);

		apLblSsn = new JLabel("SSN ");
		GridBagConstraints gbc_apLblSsn = new GridBagConstraints();
		gbc_apLblSsn.anchor = GridBagConstraints.EAST;
		gbc_apLblSsn.insets = new Insets(0, 0, 5, 5);
		gbc_apLblSsn.gridx = 0;
		gbc_apLblSsn.gridy = 6;
		addPatientPanel.add(apLblSsn, gbc_apLblSsn);

		apTextField_5 = new JTextField();
		apTextField_5.setEditable(false);
		GridBagConstraints gbc_apTextField_5 = new GridBagConstraints();
		gbc_apTextField_5.gridwidth = 4;
		gbc_apTextField_5.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_5.gridx = 1;
		gbc_apTextField_5.gridy = 6;
		addPatientPanel.add(apTextField_5, gbc_apTextField_5);
		apTextField_5.setColumns(10);

		apLblInsurance = new JLabel("Insurance ");
		GridBagConstraints gbc_apLblInsurance = new GridBagConstraints();
		gbc_apLblInsurance.anchor = GridBagConstraints.EAST;
		gbc_apLblInsurance.insets = new Insets(0, 0, 5, 5);
		gbc_apLblInsurance.gridx = 0;
		gbc_apLblInsurance.gridy = 7;
		addPatientPanel.add(apLblInsurance, gbc_apLblInsurance);

		apTextField_6 = new JTextField();
		apTextField_6.setEditable(false);
		GridBagConstraints gbc_apTextField_6 = new GridBagConstraints();
		gbc_apTextField_6.gridwidth = 4;
		gbc_apTextField_6.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_6.gridx = 1;
		gbc_apTextField_6.gridy = 7;
		addPatientPanel.add(apTextField_6, gbc_apTextField_6);
		apTextField_6.setColumns(10);

		apBtnSave = new JButton("Save");
		apBtnSave.setEnabled(false);
		GridBagConstraints gbc_apBtnSave = new GridBagConstraints();
		gbc_apBtnSave.anchor = GridBagConstraints.EAST;
		gbc_apBtnSave.insets = new Insets(0, 0, 0, 5);
		gbc_apBtnSave.gridx = 2;
		gbc_apBtnSave.gridy = 8;
		addPatientPanel.add(apBtnSave, gbc_apBtnSave);

		apBtnAddVisit = new JButton("Add Visit");
		apBtnAddVisit.setEnabled(false);
		GridBagConstraints gbc_apBtnAddVisit = new GridBagConstraints();
		gbc_apBtnAddVisit.insets = new Insets(0, 0, 0, 5);
		gbc_apBtnAddVisit.gridx = 3;
		gbc_apBtnAddVisit.gridy = 8;
		addPatientPanel.add(apBtnAddVisit, gbc_apBtnAddVisit);

		apBtnCancel = new JButton("Cancel");
		GridBagConstraints gbc_apBtnCanel = new GridBagConstraints();
		gbc_apBtnCanel.anchor = GridBagConstraints.WEST;
		gbc_apBtnCanel.gridx = 4;
		gbc_apBtnCanel.gridy = 8;
		addPatientPanel.add(apBtnCancel, gbc_apBtnCanel);

		// VISITS PAGE********************************************************************************************************************
		visitsPanel = new JPanel();
		visitsPanel.setLayout(gbl_panel);

		visitsBack = new JButton("Back");
		GridBagConstraints gbc_vBtnBack = new GridBagConstraints();
		gbc_vBtnBack.anchor = GridBagConstraints.WEST;
		gbc_vBtnBack.insets = new Insets(0, 0, 5, 5);
		gbc_vBtnBack.gridx = 0;
		gbc_vBtnBack.gridy = 0;
		visitsPanel.add(visitsBack, gbc_vBtnBack);

		visitsAddNew = new JButton("Add New Visit");
		GridBagConstraints gbc_vBtnAddNew = new GridBagConstraints();
		gbc_vBtnAddNew.fill = GridBagConstraints.BOTH;
		gbc_vBtnAddNew.insets = new Insets(0, 0, 5, 5);
		gbc_vBtnAddNew.gridx = 1;
		gbc_vBtnAddNew.gridy = 2;
		visitsPanel.add(visitsAddNew, gbc_vBtnAddNew);

		visitsViewEdit = new JButton("View/Edit Visits");
		visitsViewEdit.setEnabled(false);
		GridBagConstraints gbc_vBtnEditview = new GridBagConstraints();
		gbc_vBtnEditview.fill = GridBagConstraints.BOTH;
		gbc_vBtnEditview.insets = new Insets(0, 0, 5, 5);
		gbc_vBtnEditview.gridx = 3;
		gbc_vBtnEditview.gridy = 2;
		visitsPanel.add(visitsViewEdit, gbc_vBtnEditview);

		// ADD VISITS PAGE********************************************************************************************************************
		addVisitPanel = new JPanel();
		GridBagLayout gbl_addVisitPanel = new GridBagLayout();
		gbl_addVisitPanel.columnWidths = new int[] { 0, 160, 0, 100, 55, 50, 0 };
		gbl_addVisitPanel.rowHeights = new int[] { 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_addVisitPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_addVisitPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		addVisitPanel.setLayout(gbl_addVisitPanel);

		avBtnBack = new JButton("Back");
		GridBagConstraints gbc_avBtnBack = new GridBagConstraints();
		gbc_avBtnBack.anchor = GridBagConstraints.WEST;
		gbc_avBtnBack.insets = new Insets(0, 0, 5, 0);
		gbc_avBtnBack.gridx = 0;
		gbc_avBtnBack.gridy = 0;
		addVisitPanel.add(avBtnBack, gbc_avBtnBack);

		JLabel lblVisitId = new JLabel("Visit ID ");
		GridBagConstraints gbc_lblVisitId = new GridBagConstraints();
		gbc_lblVisitId.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisitId.anchor = GridBagConstraints.EAST;
		gbc_lblVisitId.gridx = 0;
		gbc_lblVisitId.gridy = 1;
		addVisitPanel.add(lblVisitId, gbc_lblVisitId);

		avTextField = new JTextField();
		avTextField.setEditable(false);
		GridBagConstraints gbc_avTextField = new GridBagConstraints();
		gbc_avTextField.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField.gridx = 1;
		gbc_avTextField.gridy = 1;
		addVisitPanel.add(avTextField, gbc_avTextField);
		avTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Date ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		addVisitPanel.add(lblNewLabel, gbc_lblNewLabel);

		avTextField_1 = new JTextField();
		avTextField_1.setEditable(false);
		GridBagConstraints gbc_avTextField_1 = new GridBagConstraints();
		gbc_avTextField_1.gridwidth = 3;
		gbc_avTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_avTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_1.gridx = 3;
		gbc_avTextField_1.gridy = 1;
		addVisitPanel.add(avTextField_1, gbc_avTextField_1);
		avTextField_1.setColumns(10);

		JLabel lblPatient = new JLabel("Patient ");
		GridBagConstraints gbc_lblPatient = new GridBagConstraints();
		gbc_lblPatient.anchor = GridBagConstraints.EAST;
		gbc_lblPatient.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatient.gridx = 0;
		gbc_lblPatient.gridy = 2;
		addVisitPanel.add(lblPatient, gbc_lblPatient);

		avTextField_2 = new JTextField();
		avTextField_2.setEditable(false);
		GridBagConstraints gbc_avTextField_2 = new GridBagConstraints();
		gbc_avTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_2.gridx = 1;
		gbc_avTextField_2.gridy = 2;
		addVisitPanel.add(avTextField_2, gbc_avTextField_2);
		avTextField_2.setColumns(10);

		JLabel lblThc = new JLabel("THC# ");
		GridBagConstraints gbc_lblThc = new GridBagConstraints();
		gbc_lblThc.anchor = GridBagConstraints.EAST;
		gbc_lblThc.insets = new Insets(0, 0, 5, 5);
		gbc_lblThc.gridx = 2;
		gbc_lblThc.gridy = 2;
		addVisitPanel.add(lblThc, gbc_lblThc);

		avTextField_4 = new JTextField();
		avTextField_4.setEditable(false);
		GridBagConstraints gbc_avTextField_4 = new GridBagConstraints();
		gbc_avTextField_4.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_4.gridx = 3;
		gbc_avTextField_4.gridy = 2;
		addVisitPanel.add(avTextField_4, gbc_avTextField_4);
		avTextField_4.setColumns(10);

		JLabel lblVisitNo = new JLabel("Visit no. ");
		GridBagConstraints gbc_lblVisitNo = new GridBagConstraints();
		gbc_lblVisitNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisitNo.anchor = GridBagConstraints.EAST;
		gbc_lblVisitNo.gridx = 4;
		gbc_lblVisitNo.gridy = 2;
		addVisitPanel.add(lblVisitNo, gbc_lblVisitNo);

		avTextField_3 = new JTextField();
		avTextField_3.setEditable(false);
		GridBagConstraints gbc_avTextField_3 = new GridBagConstraints();
		gbc_avTextField_3.insets = new Insets(0, 0, 5, 0);
		gbc_avTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_3.gridx = 5;
		gbc_avTextField_3.gridy = 2;
		addVisitPanel.add(avTextField_3, gbc_avTextField_3);
		avTextField_3.setColumns(10);

		JPanel avSecondGroup = new JPanel();
		GridBagConstraints gbc_avSecondGroup = new GridBagConstraints();
		gbc_avSecondGroup.gridwidth = 6;
		gbc_avSecondGroup.insets = new Insets(0, 0, 5, 0);
		gbc_avSecondGroup.fill = GridBagConstraints.BOTH;
		gbc_avSecondGroup.gridx = 0;
		gbc_avSecondGroup.gridy = 3;
		addVisitPanel.add(avSecondGroup, gbc_avSecondGroup);
		avSecondGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton avBtnInterview = new JButton("Interview");
		avBtnInterview.setEnabled(false);
		avSecondGroup.add(avBtnInterview);

		avBtnAudiology = new JButton("Audiology");
		avSecondGroup.add(avBtnAudiology);

		avBtnPharm = new JButton("Pharmocology");
		avSecondGroup.add(avBtnPharm);

		JButton avBtnDiagnose = new JButton("Diagnose");
		avBtnDiagnose.setEnabled(false);
		avSecondGroup.add(avBtnDiagnose);

		JLabel lblNewLabel_1 = new JLabel("Problem ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		addVisitPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		avTextField_5 = new JTextField();
		avTextField_5.setEditable(false);
		GridBagConstraints gbc_avTextField_5 = new GridBagConstraints();
		gbc_avTextField_5.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_5.gridx = 1;
		gbc_avTextField_5.gridy = 4;
		addVisitPanel.add(avTextField_5, gbc_avTextField_5);
		avTextField_5.setColumns(10);

		JLabel lblCategory = new JLabel("Category ");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.EAST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 2;
		gbc_lblCategory.gridy = 4;
		addVisitPanel.add(lblCategory, gbc_lblCategory);

		avTextField_6 = new JTextField();
		avTextField_6.setEditable(false);
		GridBagConstraints gbc_avTextField_6 = new GridBagConstraints();
		gbc_avTextField_6.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_6.gridx = 3;
		gbc_avTextField_6.gridy = 4;
		addVisitPanel.add(avTextField_6, gbc_avTextField_6);
		avTextField_6.setColumns(10);

		JLabel lblProtocol = new JLabel("Protocol ");
		GridBagConstraints gbc_lblProtocol = new GridBagConstraints();
		gbc_lblProtocol.anchor = GridBagConstraints.EAST;
		gbc_lblProtocol.insets = new Insets(0, 0, 5, 5);
		gbc_lblProtocol.gridx = 0;
		gbc_lblProtocol.gridy = 5;
		addVisitPanel.add(lblProtocol, gbc_lblProtocol);

		avTextField_7 = new JTextField();
		avTextField_7.setEditable(false);
		GridBagConstraints gbc_avTextField_7 = new GridBagConstraints();
		gbc_avTextField_7.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_7.gridx = 1;
		gbc_avTextField_7.gridy = 5;
		addVisitPanel.add(avTextField_7, gbc_avTextField_7);
		avTextField_7.setColumns(10);

		JLabel lblFu = new JLabel("FU ");
		GridBagConstraints gbc_lblFu = new GridBagConstraints();
		gbc_lblFu.anchor = GridBagConstraints.EAST;
		gbc_lblFu.insets = new Insets(0, 0, 5, 5);
		gbc_lblFu.gridx = 2;
		gbc_lblFu.gridy = 5;
		addVisitPanel.add(lblFu, gbc_lblFu);

		avTextField_8 = new JTextField();
		avTextField_8.setEditable(false);
		GridBagConstraints gbc_avTextField_8 = new GridBagConstraints();
		gbc_avTextField_8.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_8.gridx = 3;
		gbc_avTextField_8.gridy = 5;
		addVisitPanel.add(avTextField_8, gbc_avTextField_8);
		avTextField_8.setColumns(10);

		JLabel lblInstrument = new JLabel("Instrument ");
		GridBagConstraints gbc_lblInstrument = new GridBagConstraints();
		gbc_lblInstrument.anchor = GridBagConstraints.EAST;
		gbc_lblInstrument.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstrument.gridx = 0;
		gbc_lblInstrument.gridy = 6;
		addVisitPanel.add(lblInstrument, gbc_lblInstrument);

		avTextField_9 = new JTextField();
		avTextField_9.setEditable(false);
		GridBagConstraints gbc_avTextField_9 = new GridBagConstraints();
		gbc_avTextField_9.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_9.gridx = 1;
		gbc_avTextField_9.gridy = 6;
		addVisitPanel.add(avTextField_9, gbc_avTextField_9);
		avTextField_9.setColumns(10);

		JLabel lblRem = new JLabel("REM ");
		GridBagConstraints gbc_lblRem = new GridBagConstraints();
		gbc_lblRem.anchor = GridBagConstraints.EAST;
		gbc_lblRem.insets = new Insets(0, 0, 5, 5);
		gbc_lblRem.gridx = 2;
		gbc_lblRem.gridy = 6;
		addVisitPanel.add(lblRem, gbc_lblRem);

		JCheckBox avChckbxREM = new JCheckBox("");
		avChckbxREM.setEnabled(false);
		GridBagConstraints gbc_avChckbxREM = new GridBagConstraints();
		gbc_avChckbxREM.anchor = GridBagConstraints.WEST;
		gbc_avChckbxREM.insets = new Insets(0, 0, 5, 5);
		gbc_avChckbxREM.gridx = 3;
		gbc_avChckbxREM.gridy = 6;
		addVisitPanel.add(avChckbxREM, gbc_avChckbxREM);

		JLabel lblComments = new JLabel("Comments ");
		GridBagConstraints gbc_lblComments = new GridBagConstraints();
		gbc_lblComments.anchor = GridBagConstraints.EAST;
		gbc_lblComments.insets = new Insets(0, 0, 5, 5);
		gbc_lblComments.gridx = 0;
		gbc_lblComments.gridy = 7;
		addVisitPanel.add(lblComments, gbc_lblComments);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 7;
		addVisitPanel.add(scrollPane, gbc_scrollPane);

		JTextArea avTextAreaComments = new JTextArea();
		avTextAreaComments.setEditable(false);
		scrollPane.setViewportView(avTextAreaComments);

		JLabel lblNextVisit = new JLabel("Next Visit ");
		GridBagConstraints gbc_lblNextVisit = new GridBagConstraints();
		gbc_lblNextVisit.anchor = GridBagConstraints.EAST;
		gbc_lblNextVisit.insets = new Insets(0, 0, 5, 5);
		gbc_lblNextVisit.gridx = 0;
		gbc_lblNextVisit.gridy = 8;
		addVisitPanel.add(lblNextVisit, gbc_lblNextVisit);

		avTextField_10 = new JTextField();
		avTextField_10.setEditable(false);
		GridBagConstraints gbc_avTextField_10 = new GridBagConstraints();
		gbc_avTextField_10.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_10.gridx = 1;
		gbc_avTextField_10.gridy = 8;
		addVisitPanel.add(avTextField_10, gbc_avTextField_10);
		avTextField_10.setColumns(10);

		JPanel avFourthGroup = new JPanel();
		GridBagConstraints gbc_avFourthGroup = new GridBagConstraints();
		gbc_avFourthGroup.insets = new Insets(0, 0, 5, 0);
		gbc_avFourthGroup.gridwidth = 6;
		gbc_avFourthGroup.fill = GridBagConstraints.BOTH;
		gbc_avFourthGroup.gridx = 0;
		gbc_avFourthGroup.gridy = 9;
		addVisitPanel.add(avFourthGroup, gbc_avFourthGroup);
		avFourthGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton avBtnInstrumentDetails = new JButton("Instrument Details");
		avBtnInstrumentDetails.setEnabled(false);
		avFourthGroup.add(avBtnInstrumentDetails);

		JButton avBtnRemDetails = new JButton("REM Details");
		avBtnRemDetails.setEnabled(false);
		avFourthGroup.add(avBtnRemDetails);

		JButton avBtnCounselingDetails = new JButton("Counseling Details");
		avBtnCounselingDetails.setEnabled(false);
		avFourthGroup.add(avBtnCounselingDetails);

		JButton avBtnRecommendTreatment = new JButton("Recommend Treatment");
		avBtnRecommendTreatment.setEnabled(false);
		avFourthGroup.add(avBtnRecommendTreatment);

		avBtnSave = new JButton("Save");
		GridBagConstraints gbc_avBtnSave = new GridBagConstraints();
		gbc_avBtnSave.insets = new Insets(0, 0, 0, 5);
		gbc_avBtnSave.gridx = 4;
		gbc_avBtnSave.gridy = 10;
		addVisitPanel.add(avBtnSave, gbc_avBtnSave);

		avBtnCancel = new JButton("Cancel");
		GridBagConstraints gbc_avBtnCancel = new GridBagConstraints();
		gbc_avBtnCancel.gridx = 5;
		gbc_avBtnCancel.gridy = 10;
		addVisitPanel.add(avBtnCancel, gbc_avBtnCancel);

		// VISIT PHARMACOLOGY PAGE********************************************************************************************************************
		visPharmPanel = new JPanel();
		GridBagLayout gbl_visPharmPanel = new GridBagLayout();
		gbl_visPharmPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_visPharmPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_visPharmPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_visPharmPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		visPharmPanel.setLayout(gbl_visPharmPanel);

		vpBtnBack = new JButton("Back");
		GridBagConstraints gbc_vpBtnBack = new GridBagConstraints();
		gbc_vpBtnBack.insets = new Insets(0, 0, 5, 5);
		gbc_vpBtnBack.gridx = 0;
		gbc_vpBtnBack.gridy = 0;
		visPharmPanel.add(vpBtnBack, gbc_vpBtnBack);

		JLabel vplblPatient = new JLabel("Patient ");
		GridBagConstraints gbc_vplblPatient = new GridBagConstraints();
		gbc_vplblPatient.anchor = GridBagConstraints.EAST;
		gbc_vplblPatient.insets = new Insets(0, 0, 5, 5);
		gbc_vplblPatient.gridx = 0;
		gbc_vplblPatient.gridy = 1;
		visPharmPanel.add(vplblPatient, gbc_vplblPatient);

		vpTextField_1 = new JTextField();
		vpTextField_1.setEditable(false);
		GridBagConstraints gbc_vpTextField_1 = new GridBagConstraints();
		gbc_vpTextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_vpTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_vpTextField_1.gridx = 1;
		gbc_vpTextField_1.gridy = 1;
		visPharmPanel.add(vpTextField_1, gbc_vpTextField_1);
		vpTextField_1.setColumns(10);

		JLabel vplblThc = new JLabel("THC# ");
		GridBagConstraints gbc_vplblThc = new GridBagConstraints();
		gbc_vplblThc.insets = new Insets(0, 0, 5, 5);
		gbc_vplblThc.anchor = GridBagConstraints.EAST;
		gbc_vplblThc.gridx = 2;
		gbc_vplblThc.gridy = 1;
		visPharmPanel.add(vplblThc, gbc_vplblThc);

		vpTextField = new JTextField();
		vpTextField.setEditable(false);
		GridBagConstraints gbc_vpTextField = new GridBagConstraints();
		gbc_vpTextField.insets = new Insets(0, 0, 5, 0);
		gbc_vpTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_vpTextField.gridx = 3;
		gbc_vpTextField.gridy = 1;
		visPharmPanel.add(vpTextField, gbc_vpTextField);
		vpTextField.setColumns(10);

		JLabel vplblVisitId = new JLabel("Visit ID ");
		GridBagConstraints gbc_vplblVisitId = new GridBagConstraints();
		gbc_vplblVisitId.anchor = GridBagConstraints.EAST;
		gbc_vplblVisitId.insets = new Insets(0, 0, 5, 5);
		gbc_vplblVisitId.gridx = 0;
		gbc_vplblVisitId.gridy = 2;
		visPharmPanel.add(vplblVisitId, gbc_vplblVisitId);

		vpTextField_2 = new JTextField();
		vpTextField_2.setEditable(false);
		GridBagConstraints gbc_vpTextField_2 = new GridBagConstraints();
		gbc_vpTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_vpTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_vpTextField_2.gridx = 1;
		gbc_vpTextField_2.gridy = 2;
		visPharmPanel.add(vpTextField_2, gbc_vpTextField_2);
		vpTextField_2.setColumns(10);

		JLabel vplblCurrentMedications = new JLabel("Current Medications");
		GridBagConstraints gbc_vplblCurrentMedications = new GridBagConstraints();
		gbc_vplblCurrentMedications.gridwidth = 4;
		gbc_vplblCurrentMedications.insets = new Insets(0, 0, 5, 0);
		gbc_vplblCurrentMedications.gridx = 0;
		gbc_vplblCurrentMedications.gridy = 3;
		visPharmPanel.add(vplblCurrentMedications, gbc_vplblCurrentMedications);

		JScrollPane vpscrollPane = new JScrollPane();
		GridBagConstraints gbc_vpscrollPane = new GridBagConstraints();
		gbc_vpscrollPane.gridwidth = 4;
		gbc_vpscrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_vpscrollPane.fill = GridBagConstraints.BOTH;
		gbc_vpscrollPane.gridx = 0;
		gbc_vpscrollPane.gridy = 4;
		visPharmPanel.add(vpscrollPane, gbc_vpscrollPane);

		vpTable = new JTable();
		vpTable.setFillsViewportHeight(true);
		vpscrollPane.setViewportView(vpTable);

		JLabel vplblAddMedication = new JLabel("Add Medication");
		GridBagConstraints gbc_vplblAddMedication = new GridBagConstraints();
		gbc_vplblAddMedication.gridwidth = 4;
		gbc_vplblAddMedication.insets = new Insets(0, 0, 5, 5);
		gbc_vplblAddMedication.gridx = 0;
		gbc_vplblAddMedication.gridy = 5;
		visPharmPanel.add(vplblAddMedication, gbc_vplblAddMedication);

		JLabel vplblMedication = new JLabel("Medication ");
		GridBagConstraints gbc_vplblMedication = new GridBagConstraints();
		gbc_vplblMedication.anchor = GridBagConstraints.EAST;
		gbc_vplblMedication.insets = new Insets(0, 0, 5, 5);
		gbc_vplblMedication.gridx = 0;
		gbc_vplblMedication.gridy = 6;
		visPharmPanel.add(vplblMedication, gbc_vplblMedication);

		JComboBox vpcomboBox = new JComboBox();
		GridBagConstraints gbc_vpcomboBox = new GridBagConstraints();
		gbc_vpcomboBox.insets = new Insets(0, 0, 5, 5);
		gbc_vpcomboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_vpcomboBox.gridx = 1;
		gbc_vpcomboBox.gridy = 6;
		visPharmPanel.add(vpcomboBox, gbc_vpcomboBox);

		JLabel vplblDose = new JLabel("Dose ");
		GridBagConstraints gbc_vplblDose = new GridBagConstraints();
		gbc_vplblDose.anchor = GridBagConstraints.EAST;
		gbc_vplblDose.insets = new Insets(0, 0, 5, 5);
		gbc_vplblDose.gridx = 2;
		gbc_vplblDose.gridy = 6;
		visPharmPanel.add(vplblDose, gbc_vplblDose);

		vpTextField_3 = new JTextField();
		GridBagConstraints gbc_vpTextField_3 = new GridBagConstraints();
		gbc_vpTextField_3.insets = new Insets(0, 0, 5, 0);
		gbc_vpTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_vpTextField_3.gridx = 3;
		gbc_vpTextField_3.gridy = 6;
		visPharmPanel.add(vpTextField_3, gbc_vpTextField_3);
		vpTextField_3.setColumns(10);

		JLabel vplblDuration = new JLabel("Duration ");
		GridBagConstraints gbc_vplblDuration = new GridBagConstraints();
		gbc_vplblDuration.anchor = GridBagConstraints.EAST;
		gbc_vplblDuration.insets = new Insets(0, 0, 5, 5);
		gbc_vplblDuration.gridx = 0;
		gbc_vplblDuration.gridy = 7;
		visPharmPanel.add(vplblDuration, gbc_vplblDuration);

		vpTextField_4 = new JTextField();
		GridBagConstraints gbc_vpTextField_4 = new GridBagConstraints();
		gbc_vpTextField_4.insets = new Insets(0, 0, 5, 5);
		gbc_vpTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_vpTextField_4.gridx = 1;
		gbc_vpTextField_4.gridy = 7;
		visPharmPanel.add(vpTextField_4, gbc_vpTextField_4);
		vpTextField_4.setColumns(10);

		JLabel vplblComments = new JLabel("Comments ");
		GridBagConstraints gbc_vplblComments = new GridBagConstraints();
		gbc_vplblComments.anchor = GridBagConstraints.EAST;
		gbc_vplblComments.insets = new Insets(0, 0, 5, 5);
		gbc_vplblComments.gridx = 0;
		gbc_vplblComments.gridy = 8;
		visPharmPanel.add(vplblComments, gbc_vplblComments);

		JScrollPane vpscrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_vpscrollPane_1 = new GridBagConstraints();
		gbc_vpscrollPane_1.gridwidth = 3;
		gbc_vpscrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_vpscrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_vpscrollPane_1.gridx = 1;
		gbc_vpscrollPane_1.gridy = 8;
		visPharmPanel.add(vpscrollPane_1, gbc_vpscrollPane_1);

		JTextArea vpTextArea = new JTextArea();
		vpscrollPane_1.setViewportView(vpTextArea);

		JButton vpBtnSave = new JButton("Add");
		GridBagConstraints gbc_vpBtnSave = new GridBagConstraints();
		gbc_vpBtnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_vpBtnSave.insets = new Insets(0, 0, 0, 5);
		gbc_vpBtnSave.gridx = 1;
		gbc_vpBtnSave.gridy = 9;
		visPharmPanel.add(vpBtnSave, gbc_vpBtnSave);

		vpBtnCancel = new JButton("Cancel");
		GridBagConstraints gbc_vpBtnCancel = new GridBagConstraints();
		gbc_vpBtnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_vpBtnCancel.gridx = 3;
		gbc_vpBtnCancel.gridy = 9;
		visPharmPanel.add(vpBtnCancel, gbc_vpBtnCancel);

		// OTHER PAGE********************************************************************************************************************
		otherPanel = new JPanel();
		GridBagLayout gbl_otherPanel = new GridBagLayout();
		gbl_otherPanel.columnWidths = new int[] { 0, 0, 220, 220, 50, 0 };
		gbl_otherPanel.rowHeights = new int[] { 0, 50, 0, 0, 0, 50, 0 };
		gbl_otherPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_otherPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		otherPanel.setLayout(gbl_otherPanel);

		oBtnBack = new JButton("Back");
		GridBagConstraints gbc_oBtnBack = new GridBagConstraints();
		gbc_oBtnBack.insets = new Insets(0, 0, 5, 5);
		gbc_oBtnBack.gridx = 0;
		gbc_oBtnBack.gridy = 0;
		otherPanel.add(oBtnBack, gbc_oBtnBack);

		JButton oBtnLocatData = new JButton("Location Data");
		oBtnLocatData.setEnabled(false);
		GridBagConstraints gbc_oBtnLocatData = new GridBagConstraints();
		gbc_oBtnLocatData.fill = GridBagConstraints.BOTH;
		gbc_oBtnLocatData.insets = new Insets(0, 0, 5, 5);
		gbc_oBtnLocatData.gridx = 2;
		gbc_oBtnLocatData.gridy = 2;
		otherPanel.add(oBtnLocatData, gbc_oBtnLocatData);

		JButton btnDemographicsData = new JButton("Demographics Data");
		btnDemographicsData.setEnabled(false);
		GridBagConstraints gbc_btnDemographicsData = new GridBagConstraints();
		gbc_btnDemographicsData.fill = GridBagConstraints.BOTH;
		gbc_btnDemographicsData.insets = new Insets(0, 0, 5, 5);
		gbc_btnDemographicsData.gridx = 3;
		gbc_btnDemographicsData.gridy = 2;
		otherPanel.add(btnDemographicsData, gbc_btnDemographicsData);

		JButton oBtnMedData = new JButton("Medical Data");
		oBtnMedData.setEnabled(false);
		GridBagConstraints gbc_oBtnMedData = new GridBagConstraints();
		gbc_oBtnMedData.fill = GridBagConstraints.BOTH;
		gbc_oBtnMedData.insets = new Insets(0, 0, 5, 5);
		gbc_oBtnMedData.gridx = 2;
		gbc_oBtnMedData.gridy = 3;
		otherPanel.add(oBtnMedData, gbc_oBtnMedData);

		oBtnPharmData = new JButton("Pharmacology Data");
		GridBagConstraints gbc_oBtnPharmData = new GridBagConstraints();
		gbc_oBtnPharmData.fill = GridBagConstraints.BOTH;
		gbc_oBtnPharmData.insets = new Insets(0, 0, 5, 5);
		gbc_oBtnPharmData.gridx = 3;
		gbc_oBtnPharmData.gridy = 3;
		otherPanel.add(oBtnPharmData, gbc_oBtnPharmData);

		JButton btnInstruments = new JButton("Instruments");
		btnInstruments.setEnabled(false);
		GridBagConstraints gbc_btnInstruments = new GridBagConstraints();
		gbc_btnInstruments.fill = GridBagConstraints.BOTH;
		gbc_btnInstruments.insets = new Insets(0, 0, 5, 0);
		gbc_btnInstruments.gridwidth = 2;
		gbc_btnInstruments.gridx = 2;
		gbc_btnInstruments.gridy = 4;
		otherPanel.add(btnInstruments, gbc_btnInstruments);

		// PHARMACOLOGY DATA PAGE********************************************************************************************************************
		pharmDataPanel = new JPanel();
		GridBagLayout gbl_pharmDataPanel = new GridBagLayout();
		gbl_pharmDataPanel.columnWidths = new int[] { 0, 0, 220, 220, 50, 0 };
		gbl_pharmDataPanel.rowHeights = new int[] { 0, 50, 0, 0, 50, 0 };
		gbl_pharmDataPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_pharmDataPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		pharmDataPanel.setLayout(gbl_pharmDataPanel);

		pdBtnBack = new JButton("Back");
		GridBagConstraints gbc_pdBtnBack = new GridBagConstraints();
		gbc_pdBtnBack.insets = new Insets(0, 0, 5, 5);
		gbc_pdBtnBack.gridx = 0;
		gbc_pdBtnBack.gridy = 0;
		pharmDataPanel.add(pdBtnBack, gbc_pdBtnBack);

		pdBtnAEMedication = new JButton("Add/Edit Medication");
		GridBagConstraints gbc_pdBtnAEMedication = new GridBagConstraints();
		gbc_pdBtnAEMedication.fill = GridBagConstraints.BOTH;
		gbc_pdBtnAEMedication.insets = new Insets(0, 0, 5, 5);
		gbc_pdBtnAEMedication.gridx = 2;
		gbc_pdBtnAEMedication.gridy = 2;
		pharmDataPanel.add(pdBtnAEMedication, gbc_pdBtnAEMedication);

		pdBtnAEGeneric = new JButton("Add/Edit Generic");
		GridBagConstraints gbc_pdBtnAEGeneric = new GridBagConstraints();
		gbc_pdBtnAEGeneric.fill = GridBagConstraints.BOTH;
		gbc_pdBtnAEGeneric.insets = new Insets(0, 0, 5, 5);
		gbc_pdBtnAEGeneric.gridx = 3;
		gbc_pdBtnAEGeneric.gridy = 2;
		pharmDataPanel.add(pdBtnAEGeneric, gbc_pdBtnAEGeneric);

		pdBtnAEDisease = new JButton("Add/Edit Disease");
		GridBagConstraints gbc_pdBtnAEDisease = new GridBagConstraints();
		gbc_pdBtnAEDisease.fill = GridBagConstraints.BOTH;
		gbc_pdBtnAEDisease.insets = new Insets(0, 0, 5, 5);
		gbc_pdBtnAEDisease.gridx = 2;
		gbc_pdBtnAEDisease.gridy = 3;
		pharmDataPanel.add(pdBtnAEDisease, gbc_pdBtnAEDisease);

		pdBtnAEChemical = new JButton("Add/Edit Chemical Category");
		GridBagConstraints gbc_pdBtnAEChemical = new GridBagConstraints();
		gbc_pdBtnAEChemical.fill = GridBagConstraints.BOTH;
		gbc_pdBtnAEChemical.insets = new Insets(0, 0, 5, 5);
		gbc_pdBtnAEChemical.gridx = 3;
		gbc_pdBtnAEChemical.gridy = 3;
		pharmDataPanel.add(pdBtnAEChemical, gbc_pdBtnAEChemical);

		// CHEMICAL PAGE********************************************************************************************************************
		aeChemDataPanel = new JPanel();
		GridBagLayout gbl_aeChemDataPanel = new GridBagLayout();
		gbl_aeChemDataPanel.columnWidths = new int[] { 0, 0 };
		gbl_aeChemDataPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_aeChemDataPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_aeChemDataPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		aeChemDataPanel.setLayout(gbl_aeChemDataPanel);

		chmBtnBack = new JButton("Back");
		GridBagConstraints gbc_chmBtnBack = new GridBagConstraints();
		gbc_chmBtnBack.anchor = GridBagConstraints.WEST;
		gbc_chmBtnBack.insets = new Insets(0, 0, 5, 0);
		gbc_chmBtnBack.gridx = 0;
		gbc_chmBtnBack.gridy = 0;
		aeChemDataPanel.add(chmBtnBack, gbc_chmBtnBack);

		JTabbedPane chmTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_chmTabbedPane = new GridBagConstraints();
		gbc_chmTabbedPane.fill = GridBagConstraints.BOTH;
		gbc_chmTabbedPane.gridx = 0;
		gbc_chmTabbedPane.gridy = 1;
		aeChemDataPanel.add(chmTabbedPane, gbc_chmTabbedPane);

		JPanel addChemPanel = new JPanel();
		chmTabbedPane.addTab("Add Chemical", null, addChemPanel, null);
		GridBagLayout gbl_addChemPanel = new GridBagLayout();
		gbl_addChemPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_addChemPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_addChemPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_addChemPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		addChemPanel.setLayout(gbl_addChemPanel);

		JLabel chmlblId = new JLabel("ID ");
		GridBagConstraints gbc_chmlblId = new GridBagConstraints();
		gbc_chmlblId.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblId.anchor = GridBagConstraints.EAST;
		gbc_chmlblId.gridx = 0;
		gbc_chmlblId.gridy = 0;
		addChemPanel.add(chmlblId, gbc_chmlblId);

		chmTextField_id = new JTextField();
		GridBagConstraints gbc_chmTextField = new GridBagConstraints();
		gbc_chmTextField.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField.gridx = 1;
		gbc_chmTextField.gridy = 0;
		addChemPanel.add(chmTextField_id, gbc_chmTextField);
		chmTextField_id.setColumns(10);

		JLabel chmlblName = new JLabel("Name ");
		GridBagConstraints gbc_chmlblName = new GridBagConstraints();
		gbc_chmlblName.anchor = GridBagConstraints.EAST;
		gbc_chmlblName.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblName.gridx = 0;
		gbc_chmlblName.gridy = 1;
		addChemPanel.add(chmlblName, gbc_chmlblName);

		chmTextField_name = new JTextField();
		GridBagConstraints gbc_chmTextField_1 = new GridBagConstraints();
		gbc_chmTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_1.gridx = 1;
		gbc_chmTextField_1.gridy = 1;
		addChemPanel.add(chmTextField_name, gbc_chmTextField_1);
		chmTextField_name.setColumns(10);

		JLabel chmlblDescription = new JLabel("Description ");
		GridBagConstraints gbc_chmlblDescription = new GridBagConstraints();
		gbc_chmlblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblDescription.gridx = 0;
		gbc_chmlblDescription.gridy = 2;
		addChemPanel.add(chmlblDescription, gbc_chmlblDescription);

		JScrollPane chmscrollPane = new JScrollPane();
		GridBagConstraints gbc_chmscrollPane = new GridBagConstraints();
		gbc_chmscrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_chmscrollPane.fill = GridBagConstraints.BOTH;
		gbc_chmscrollPane.gridx = 1;
		gbc_chmscrollPane.gridy = 2;
		addChemPanel.add(chmscrollPane, gbc_chmscrollPane);

		chmTextArea_desc = new JTextArea();
		chmscrollPane.setViewportView(chmTextArea_desc);

		chmBtnAdd = new JButton("Add");
		GridBagConstraints gbc_chmBtnAdd = new GridBagConstraints();
		gbc_chmBtnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmBtnAdd.gridwidth = 2;
		gbc_chmBtnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_chmBtnAdd.gridx = 0;
		gbc_chmBtnAdd.gridy = 3;
		addChemPanel.add(chmBtnAdd, gbc_chmBtnAdd);

		JPanel editChemPanel = new JPanel();
		chmTabbedPane.addTab("Edit Chemical", null, editChemPanel, null);
		GridBagLayout gbl_editChemPanel = new GridBagLayout();
		gbl_editChemPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_editChemPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_editChemPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_editChemPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		editChemPanel.setLayout(gbl_editChemPanel);

		JLabel chmlblId_1 = new JLabel("ID ");
		GridBagConstraints gbc_chmlblId_1 = new GridBagConstraints();
		gbc_chmlblId_1.anchor = GridBagConstraints.EAST;
		gbc_chmlblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblId_1.gridx = 0;
		gbc_chmlblId_1.gridy = 0;
		editChemPanel.add(chmlblId_1, gbc_chmlblId_1);

		chmTextField_idSearch = new JTextField();
		GridBagConstraints gbc_chmTextField_3 = new GridBagConstraints();
		gbc_chmTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_chmTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_3.gridx = 1;
		gbc_chmTextField_3.gridy = 0;
		editChemPanel.add(chmTextField_idSearch, gbc_chmTextField_3);
		chmTextField_idSearch.setColumns(10);

		JLabel chmlblName_1 = new JLabel("Name ");
		GridBagConstraints gbc_chmlblName_1 = new GridBagConstraints();
		gbc_chmlblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblName_1.anchor = GridBagConstraints.EAST;
		gbc_chmlblName_1.gridx = 2;
		gbc_chmlblName_1.gridy = 0;
		editChemPanel.add(chmlblName_1, gbc_chmlblName_1);

		chmTextField_nameSearch = new JTextField();
		GridBagConstraints gbc_chmTextField_2 = new GridBagConstraints();
		gbc_chmTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_2.gridx = 3;
		gbc_chmTextField_2.gridy = 0;
		editChemPanel.add(chmTextField_nameSearch, gbc_chmTextField_2);
		chmTextField_nameSearch.setColumns(10);

		chmBtnSearch = new JButton("Search");
		GridBagConstraints gbc_chmBtnSearch = new GridBagConstraints();
		gbc_chmBtnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_chmBtnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmBtnSearch.gridwidth = 4;
		gbc_chmBtnSearch.gridx = 0;
		gbc_chmBtnSearch.gridy = 1;
		editChemPanel.add(chmBtnSearch, gbc_chmBtnSearch);

		JScrollPane chmscrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_chmscrollPane_2 = new GridBagConstraints();
		gbc_chmscrollPane_2.gridwidth = 4;
		gbc_chmscrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_chmscrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_chmscrollPane_2.gridx = 0;
		gbc_chmscrollPane_2.gridy = 2;
		editChemPanel.add(chmscrollPane_2, gbc_chmscrollPane_2);

		// RESULT TABLE HERE***************************
		// https://www.youtube.com/watch?v=uJUXyhya3YM

		chmResTable = new JTable();
		chmResModel = new DefaultTableModel();
		chmResModel.setColumnIdentifiers(new String[]{"id", "name", "description"});
		chmResTable.setModel(chmResModel);
		chmResTable.setFillsViewportHeight(true);
		chmscrollPane_2.setViewportView(chmResTable);
		chmResTable.setRowSelectionAllowed(true);
		chmResTable.setDefaultEditor(Object.class, null);

		JLabel chmlblId_2 = new JLabel("ID ");
		GridBagConstraints gbc_chmlblId_2 = new GridBagConstraints();
		gbc_chmlblId_2.anchor = GridBagConstraints.EAST;
		gbc_chmlblId_2.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblId_2.gridx = 0;
		gbc_chmlblId_2.gridy = 3;
		editChemPanel.add(chmlblId_2, gbc_chmlblId_2);

		chmTextField_resID = new JTextField();
		GridBagConstraints gbc_chmTextField_4 = new GridBagConstraints();
		gbc_chmTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField_4.gridwidth = 3;
		gbc_chmTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_4.gridx = 1;
		gbc_chmTextField_4.gridy = 3;
		editChemPanel.add(chmTextField_resID, gbc_chmTextField_4);
		chmTextField_resID.setColumns(10);

		JLabel chmlblName_2 = new JLabel("Name ");
		GridBagConstraints gbc_chmlblName_2 = new GridBagConstraints();
		gbc_chmlblName_2.anchor = GridBagConstraints.EAST;
		gbc_chmlblName_2.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblName_2.gridx = 0;
		gbc_chmlblName_2.gridy = 4;
		editChemPanel.add(chmlblName_2, gbc_chmlblName_2);

		chmTextField_resName = new JTextField();
		GridBagConstraints gbc_chmTextField_5 = new GridBagConstraints();
		gbc_chmTextField_5.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField_5.gridwidth = 3;
		gbc_chmTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_5.gridx = 1;
		gbc_chmTextField_5.gridy = 4;
		editChemPanel.add(chmTextField_resName, gbc_chmTextField_5);
		chmTextField_resName.setColumns(10);

		JLabel chmlblDescription_1 = new JLabel("Description");
		GridBagConstraints gbc_chmlblDescription_1 = new GridBagConstraints();
		gbc_chmlblDescription_1.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblDescription_1.gridx = 0;
		gbc_chmlblDescription_1.gridy = 5;
		editChemPanel.add(chmlblDescription_1, gbc_chmlblDescription_1);

		JScrollPane chmscrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_chmscrollPane_1 = new GridBagConstraints();
		gbc_chmscrollPane_1.gridwidth = 3;
		gbc_chmscrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_chmscrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_chmscrollPane_1.gridx = 1;
		gbc_chmscrollPane_1.gridy = 5;
		editChemPanel.add(chmscrollPane_1, gbc_chmscrollPane_1);

		chmTextArea_resDesc = new JTextArea();
		chmscrollPane_1.setViewportView(chmTextArea_resDesc);

		JButton chmBtnSubmit = new JButton("Submit");
		GridBagConstraints gbc_chmBtnSubmit = new GridBagConstraints();
		gbc_chmBtnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmBtnSubmit.gridwidth = 4;
		gbc_chmBtnSubmit.gridx = 0;
		gbc_chmBtnSubmit.gridy = 6;
		editChemPanel.add(chmBtnSubmit, gbc_chmBtnSubmit);

		// GENERIC PAGE********************************************************************************************************************
		aeGenDataPanel = new JPanel();
		GridBagLayout gbl_aeGenDataPanel = new GridBagLayout();
		gbl_aeGenDataPanel.columnWidths = new int[] { 0, 0 };
		gbl_aeGenDataPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_aeGenDataPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_aeGenDataPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		aeGenDataPanel.setLayout(gbl_aeGenDataPanel);

		genBtnBack = new JButton("Back");
		GridBagConstraints gbc_genBtnBack = new GridBagConstraints();
		gbc_genBtnBack.anchor = GridBagConstraints.WEST;
		gbc_genBtnBack.insets = new Insets(0, 0, 5, 0);
		gbc_genBtnBack.gridx = 0;
		gbc_genBtnBack.gridy = 0;
		aeGenDataPanel.add(genBtnBack, gbc_genBtnBack);

		JTabbedPane genTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_genTabbedPane = new GridBagConstraints();
		gbc_genTabbedPane.fill = GridBagConstraints.BOTH;
		gbc_genTabbedPane.gridx = 0;
		gbc_genTabbedPane.gridy = 1;
		aeGenDataPanel.add(genTabbedPane, gbc_genTabbedPane);

		JPanel addgenPanel = new JPanel();
		genTabbedPane.addTab("Add Generic", null, addgenPanel, null);
		GridBagLayout gbl_addgenPanel = new GridBagLayout();
		gbl_addgenPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_addgenPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_addgenPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_addgenPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		addgenPanel.setLayout(gbl_addgenPanel);

		JLabel genlblId = new JLabel("ID ");
		GridBagConstraints gbc_genlblId = new GridBagConstraints();
		gbc_genlblId.insets = new Insets(0, 0, 5, 5);
		gbc_genlblId.anchor = GridBagConstraints.EAST;
		gbc_genlblId.gridx = 0;
		gbc_genlblId.gridy = 0;
		addgenPanel.add(genlblId, gbc_genlblId);

		genTextField_id = new JTextField();
		GridBagConstraints gbc_genTextField = new GridBagConstraints();
		gbc_genTextField.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField.gridx = 1;
		gbc_genTextField.gridy = 0;
		addgenPanel.add(genTextField_id, gbc_genTextField);
		genTextField_id.setColumns(10);

		JLabel genlblName = new JLabel("Name ");
		GridBagConstraints gbc_genlblName = new GridBagConstraints();
		gbc_genlblName.anchor = GridBagConstraints.EAST;
		gbc_genlblName.insets = new Insets(0, 0, 5, 5);
		gbc_genlblName.gridx = 0;
		gbc_genlblName.gridy = 1;
		addgenPanel.add(genlblName, gbc_genlblName);

		genTextField_name = new JTextField();
		GridBagConstraints gbc_genTextField_1 = new GridBagConstraints();
		gbc_genTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_1.gridx = 1;
		gbc_genTextField_1.gridy = 1;
		addgenPanel.add(genTextField_name, gbc_genTextField_1);
		genTextField_name.setColumns(10);

		JLabel genlblDescription = new JLabel("Description ");
		GridBagConstraints gbc_genlblDescription = new GridBagConstraints();
		gbc_genlblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_genlblDescription.gridx = 0;
		gbc_genlblDescription.gridy = 2;
		addgenPanel.add(genlblDescription, gbc_genlblDescription);

		JScrollPane genscrollPane = new JScrollPane();
		GridBagConstraints gbc_genscrollPane = new GridBagConstraints();
		gbc_genscrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_genscrollPane.fill = GridBagConstraints.BOTH;
		gbc_genscrollPane.gridx = 1;
		gbc_genscrollPane.gridy = 2;
		addgenPanel.add(genscrollPane, gbc_genscrollPane);

		genTextArea_desc = new JTextArea();
		genscrollPane.setViewportView(genTextArea_desc);

		genBtnAdd = new JButton("Add");
		GridBagConstraints gbc_genBtnAdd = new GridBagConstraints();
		gbc_genBtnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_genBtnAdd.gridwidth = 2;
		gbc_genBtnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_genBtnAdd.gridx = 0;
		gbc_genBtnAdd.gridy = 3;
		addgenPanel.add(genBtnAdd, gbc_genBtnAdd);

		JPanel editgenPanel = new JPanel();
		genTabbedPane.addTab("Edit Generic", null, editgenPanel, null);
		GridBagLayout gbl_editgenPanel = new GridBagLayout();
		gbl_editgenPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_editgenPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_editgenPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_editgenPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		editgenPanel.setLayout(gbl_editgenPanel);

		JLabel genlblId_1 = new JLabel("ID ");
		GridBagConstraints gbc_genlblId_1 = new GridBagConstraints();
		gbc_genlblId_1.anchor = GridBagConstraints.EAST;
		gbc_genlblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_genlblId_1.gridx = 0;
		gbc_genlblId_1.gridy = 0;
		editgenPanel.add(genlblId_1, gbc_genlblId_1);

		genTextField_idSearch = new JTextField();
		GridBagConstraints gbc_genTextField_3 = new GridBagConstraints();
		gbc_genTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_genTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_3.gridx = 1;
		gbc_genTextField_3.gridy = 0;
		editgenPanel.add(genTextField_idSearch, gbc_genTextField_3);
		genTextField_idSearch.setColumns(10);

		JLabel genlblName_1 = new JLabel("Name");
		GridBagConstraints gbc_genlblName_1 = new GridBagConstraints();
		gbc_genlblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_genlblName_1.anchor = GridBagConstraints.EAST;
		gbc_genlblName_1.gridx = 2;
		gbc_genlblName_1.gridy = 0;
		editgenPanel.add(genlblName_1, gbc_genlblName_1);

		genTextField_nameSearch = new JTextField();
		GridBagConstraints gbc_genTextField_2 = new GridBagConstraints();
		gbc_genTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_2.gridx = 3;
		gbc_genTextField_2.gridy = 0;
		editgenPanel.add(genTextField_nameSearch, gbc_genTextField_2);
		genTextField_nameSearch.setColumns(10);

		genBtnSearch = new JButton("Search");
		GridBagConstraints gbc_genBtnSearch = new GridBagConstraints();
		gbc_genBtnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_genBtnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_genBtnSearch.gridwidth = 4;
		gbc_genBtnSearch.gridx = 0;
		gbc_genBtnSearch.gridy = 1;
		editgenPanel.add(genBtnSearch, gbc_genBtnSearch);

		JScrollPane genscrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_genscrollPane_2 = new GridBagConstraints();
		gbc_genscrollPane_2.gridwidth = 4;
		gbc_genscrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_genscrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_genscrollPane_2.gridx = 0;
		gbc_genscrollPane_2.gridy = 2;
		editgenPanel.add(genscrollPane_2, gbc_genscrollPane_2);

		genResTable = new JTable();
		genResModel = new DefaultTableModel();
		genResModel.setColumnIdentifiers(new String[]{"id", "name", "description"});
		genResTable.setModel(genResModel);
		genResTable.setFillsViewportHeight(true);
		genscrollPane_2.setViewportView(genResTable);
		genResTable.setRowSelectionAllowed(true);
		genResTable.setDefaultEditor(Object.class, null);

		JLabel genlblId_2 = new JLabel("ID ");
		GridBagConstraints gbc_genlblId_2 = new GridBagConstraints();
		gbc_genlblId_2.anchor = GridBagConstraints.EAST;
		gbc_genlblId_2.insets = new Insets(0, 0, 5, 5);
		gbc_genlblId_2.gridx = 0;
		gbc_genlblId_2.gridy = 3;
		editgenPanel.add(genlblId_2, gbc_genlblId_2);

		genTextField_resID = new JTextField();
		GridBagConstraints gbc_genTextField_4 = new GridBagConstraints();
		gbc_genTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField_4.gridwidth = 3;
		gbc_genTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_4.gridx = 1;
		gbc_genTextField_4.gridy = 3;
		editgenPanel.add(genTextField_resID, gbc_genTextField_4);
		genTextField_resID.setColumns(10);
		genTextField_resID.setEditable(false);

		JLabel genlblName_2 = new JLabel("Name ");
		GridBagConstraints gbc_genlblName_2 = new GridBagConstraints();
		gbc_genlblName_2.anchor = GridBagConstraints.EAST;
		gbc_genlblName_2.insets = new Insets(0, 0, 5, 5);
		gbc_genlblName_2.gridx = 0;
		gbc_genlblName_2.gridy = 4;
		editgenPanel.add(genlblName_2, gbc_genlblName_2);

		genTextField_resName = new JTextField();
		GridBagConstraints gbc_genTextField_5 = new GridBagConstraints();
		gbc_genTextField_5.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField_5.gridwidth = 3;
		gbc_genTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_5.gridx = 1;
		gbc_genTextField_5.gridy = 4;
		editgenPanel.add(genTextField_resName, gbc_genTextField_5);
		genTextField_resName.setColumns(10);

		JLabel genlblDescription_1 = new JLabel("Description");
		GridBagConstraints gbc_genlblDescription_1 = new GridBagConstraints();
		gbc_genlblDescription_1.insets = new Insets(0, 0, 5, 5);
		gbc_genlblDescription_1.gridx = 0;
		gbc_genlblDescription_1.gridy = 5;
		editgenPanel.add(genlblDescription_1, gbc_genlblDescription_1);

		JScrollPane genscrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_genscrollPane_1 = new GridBagConstraints();
		gbc_genscrollPane_1.gridwidth = 3;
		gbc_genscrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_genscrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_genscrollPane_1.gridx = 1;
		gbc_genscrollPane_1.gridy = 5;
		editgenPanel.add(genscrollPane_1, gbc_genscrollPane_1);

		genTextArea_resDesc = new JTextArea();
		genscrollPane_1.setViewportView(genTextArea_resDesc);

		genBtnSubmit = new JButton("Submit");
		GridBagConstraints gbc_genBtnSubmit = new GridBagConstraints();
		gbc_genBtnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_genBtnSubmit.gridwidth = 4;
		gbc_genBtnSubmit.gridx = 0;
		gbc_genBtnSubmit.gridy = 6;
		editgenPanel.add(genBtnSubmit, gbc_genBtnSubmit);

		// DISEASE PAGE********************************************************************************************************************
		aeDisDataPanel = new JPanel();
		GridBagLayout gbl_aeDisDataPanel = new GridBagLayout();
		gbl_aeDisDataPanel.columnWidths = new int[] { 0, 0 };
		gbl_aeDisDataPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_aeDisDataPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_aeDisDataPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		aeDisDataPanel.setLayout(gbl_aeDisDataPanel);

		disBtnBack = new JButton("Back");
		GridBagConstraints gbc_disBtnBack = new GridBagConstraints();
		gbc_disBtnBack.anchor = GridBagConstraints.WEST;
		gbc_disBtnBack.insets = new Insets(0, 0, 5, 0);
		gbc_disBtnBack.gridx = 0;
		gbc_disBtnBack.gridy = 0;
		aeDisDataPanel.add(disBtnBack, gbc_disBtnBack);

		JTabbedPane disTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_disTabbedPane = new GridBagConstraints();
		gbc_disTabbedPane.fill = GridBagConstraints.BOTH;
		gbc_disTabbedPane.gridx = 0;
		gbc_disTabbedPane.gridy = 1;
		aeDisDataPanel.add(disTabbedPane, gbc_disTabbedPane);

		JPanel addDisPanel = new JPanel();
		disTabbedPane.addTab("Add Disease", null, addDisPanel, null);
		GridBagLayout gbl_addDisPanel = new GridBagLayout();
		gbl_addDisPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_addDisPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_addDisPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_addDisPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		addDisPanel.setLayout(gbl_addDisPanel);

		JLabel dislblId = new JLabel("ID ");
		GridBagConstraints gbc_dislblId = new GridBagConstraints();
		gbc_dislblId.insets = new Insets(0, 0, 5, 5);
		gbc_dislblId.anchor = GridBagConstraints.EAST;
		gbc_dislblId.gridx = 0;
		gbc_dislblId.gridy = 0;
		addDisPanel.add(dislblId, gbc_dislblId);

		disTextField_id = new JTextField();
		GridBagConstraints gbc_disTextField = new GridBagConstraints();
		gbc_disTextField.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField.gridx = 1;
		gbc_disTextField.gridy = 0;
		addDisPanel.add(disTextField_id, gbc_disTextField);
		disTextField_id.setColumns(10);

		JLabel dislblName = new JLabel("Name ");
		GridBagConstraints gbc_dislblName = new GridBagConstraints();
		gbc_dislblName.anchor = GridBagConstraints.EAST;
		gbc_dislblName.insets = new Insets(0, 0, 5, 5);
		gbc_dislblName.gridx = 0;
		gbc_dislblName.gridy = 1;
		addDisPanel.add(dislblName, gbc_dislblName);

		disTextField_name = new JTextField();
		GridBagConstraints gbc_disTextField_1 = new GridBagConstraints();
		gbc_disTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_1.gridx = 1;
		gbc_disTextField_1.gridy = 1;
		addDisPanel.add(disTextField_name, gbc_disTextField_1);
		disTextField_name.setColumns(10);

		JLabel dislblDescription = new JLabel("Description ");
		GridBagConstraints gbc_dislblDescription = new GridBagConstraints();
		gbc_dislblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_dislblDescription.gridx = 0;
		gbc_dislblDescription.gridy = 2;
		addDisPanel.add(dislblDescription, gbc_dislblDescription);

		JScrollPane disscrollPane = new JScrollPane();
		GridBagConstraints gbc_disscrollPane = new GridBagConstraints();
		gbc_disscrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_disscrollPane.fill = GridBagConstraints.BOTH;
		gbc_disscrollPane.gridx = 1;
		gbc_disscrollPane.gridy = 2;
		addDisPanel.add(disscrollPane, gbc_disscrollPane);

		disTextArea_desc = new JTextArea();
		disscrollPane.setViewportView(disTextArea_desc);

		disBtnAdd = new JButton("Add");
		GridBagConstraints gbc_disBtnAdd = new GridBagConstraints();
		gbc_disBtnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_disBtnAdd.gridwidth = 2;
		gbc_disBtnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_disBtnAdd.gridx = 0;
		gbc_disBtnAdd.gridy = 3;
		addDisPanel.add(disBtnAdd, gbc_disBtnAdd);

		JPanel editDisPanel = new JPanel();
		disTabbedPane.addTab("Edit Disease", null, editDisPanel, null);
		GridBagLayout gbl_editDisPanel = new GridBagLayout();
		gbl_editDisPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_editDisPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_editDisPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_editDisPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		editDisPanel.setLayout(gbl_editDisPanel);

		JLabel dislblId_1 = new JLabel("ID ");
		GridBagConstraints gbc_dislblId_1 = new GridBagConstraints();
		gbc_dislblId_1.anchor = GridBagConstraints.EAST;
		gbc_dislblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_dislblId_1.gridx = 0;
		gbc_dislblId_1.gridy = 0;
		editDisPanel.add(dislblId_1, gbc_dislblId_1);

		disTextField_idSearch = new JTextField();
		GridBagConstraints gbc_disTextField_3 = new GridBagConstraints();
		gbc_disTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_disTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_3.gridx = 1;
		gbc_disTextField_3.gridy = 0;
		editDisPanel.add(disTextField_idSearch, gbc_disTextField_3);
		disTextField_idSearch.setColumns(10);

		JLabel dislblName_1 = new JLabel("Name");
		GridBagConstraints gbc_dislblName_1 = new GridBagConstraints();
		gbc_dislblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_dislblName_1.anchor = GridBagConstraints.EAST;
		gbc_dislblName_1.gridx = 2;
		gbc_dislblName_1.gridy = 0;
		editDisPanel.add(dislblName_1, gbc_dislblName_1);

		disTextField_nameSearch = new JTextField();
		GridBagConstraints gbc_disTextField_2 = new GridBagConstraints();
		gbc_disTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_2.gridx = 3;
		gbc_disTextField_2.gridy = 0;
		editDisPanel.add(disTextField_nameSearch, gbc_disTextField_2);
		disTextField_nameSearch.setColumns(10);

		disBtnSearch = new JButton("Search");
		GridBagConstraints gbc_disBtnSearch = new GridBagConstraints();
		gbc_disBtnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_disBtnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_disBtnSearch.gridwidth = 4;
		gbc_disBtnSearch.gridx = 0;
		gbc_disBtnSearch.gridy = 1;
		editDisPanel.add(disBtnSearch, gbc_disBtnSearch);

		JScrollPane disscrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_disscrollPane_2 = new GridBagConstraints();
		gbc_disscrollPane_2.gridwidth = 4;
		gbc_disscrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_disscrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_disscrollPane_2.gridx = 0;
		gbc_disscrollPane_2.gridy = 2;
		editDisPanel.add(disscrollPane_2, gbc_disscrollPane_2);

		// RESULT TABLE HERE***************************
		// 		genResTable = new JTable();
		//		genResModel = new DefaultTableModel();
		//		genResModel.setColumnIdentifiers(new String[]{"id", "name", "description"});
		//		genResTable.setModel(genResModel);
		//		genResTable.setFillsViewportHeight(true);
		//		genscrollPane_2.setViewportView(genResTable);
		//		genResTable.setRowSelectionAllowed(true);
		//		genResTable.setDefaultEditor(Object.class, null);
		disResTable = new JTable();
		disResModel = new DefaultTableModel();
		disResModel.setColumnIdentifiers(new String[]{"id", "name", "description"});
		disResTable.setModel(disResModel);
		disResTable.setFillsViewportHeight(true);
		disscrollPane_2.setViewportView(disResTable);
		disResTable.setRowSelectionAllowed(true);
		disResTable.setDefaultEditor(Object.class, null);

		JLabel dislblId_2 = new JLabel("ID ");
		GridBagConstraints gbc_dislblId_2 = new GridBagConstraints();
		gbc_dislblId_2.anchor = GridBagConstraints.EAST;
		gbc_dislblId_2.insets = new Insets(0, 0, 5, 5);
		gbc_dislblId_2.gridx = 0;
		gbc_dislblId_2.gridy = 3;
		editDisPanel.add(dislblId_2, gbc_dislblId_2);

		disTextField_resID = new JTextField();
		GridBagConstraints gbc_disTextField_4 = new GridBagConstraints();
		gbc_disTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField_4.gridwidth = 3;
		gbc_disTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_4.gridx = 1;
		gbc_disTextField_4.gridy = 3;
		editDisPanel.add(disTextField_resID, gbc_disTextField_4);
		disTextField_resID.setColumns(10);

		JLabel dislblName_2 = new JLabel("Name ");
		GridBagConstraints gbc_dislblName_2 = new GridBagConstraints();
		gbc_dislblName_2.anchor = GridBagConstraints.EAST;
		gbc_dislblName_2.insets = new Insets(0, 0, 5, 5);
		gbc_dislblName_2.gridx = 0;
		gbc_dislblName_2.gridy = 4;
		editDisPanel.add(dislblName_2, gbc_dislblName_2);

		disTextField_resName = new JTextField();
		GridBagConstraints gbc_disTextField_5 = new GridBagConstraints();
		gbc_disTextField_5.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField_5.gridwidth = 3;
		gbc_disTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_5.gridx = 1;
		gbc_disTextField_5.gridy = 4;
		editDisPanel.add(disTextField_resName, gbc_disTextField_5);
		disTextField_resName.setColumns(10);

		JLabel dislblDescription_1 = new JLabel("Description");
		GridBagConstraints gbc_dislblDescription_1 = new GridBagConstraints();
		gbc_dislblDescription_1.insets = new Insets(0, 0, 5, 5);
		gbc_dislblDescription_1.gridx = 0;
		gbc_dislblDescription_1.gridy = 5;
		editDisPanel.add(dislblDescription_1, gbc_dislblDescription_1);

		JScrollPane disscrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_disscrollPane_1 = new GridBagConstraints();
		gbc_disscrollPane_1.gridwidth = 3;
		gbc_disscrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_disscrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_disscrollPane_1.gridx = 1;
		gbc_disscrollPane_1.gridy = 5;
		editDisPanel.add(disscrollPane_1, gbc_disscrollPane_1);

		disTextArea_resDesc = new JTextArea();
		disscrollPane_1.setViewportView(disTextArea_resDesc);

		disBtnSubmit = new JButton("Submit");
		GridBagConstraints gbc_disBtnSubmit = new GridBagConstraints();
		gbc_disBtnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_disBtnSubmit.gridwidth = 4;
		gbc_disBtnSubmit.gridx = 0;
		gbc_disBtnSubmit.gridy = 6;
		editDisPanel.add(disBtnSubmit, gbc_disBtnSubmit);

		// AUDIOLOGY PAGE********************************************************************************************************************
		audioPanel = new JPanel();
		audioPanel.setLayout(new BorderLayout(0, 0));

		audPrePopTextFields = new JTextField[4];
		audInpTextFields = new JTextField[61];
		JScrollPane audMainScrollPane = new JScrollPane();
		audMainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		audioPanel.add(audMainScrollPane, BorderLayout.CENTER);

		JPanel audInnerPanel = new JPanel();
		audMainScrollPane.setViewportView(audInnerPanel);
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel1.rowHeights = new int[] { 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 30, 0, 0, 30, 0, 0, 0, 30, 0, 0, 0, 0, 30, 0,
				0, 0, 0, 0, 0, 60, 0, 0 };
		gbl_panel1.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		audInnerPanel.setLayout(gbl_panel1);

		audBtnBack = new JButton("Back");
		GridBagConstraints gbc_audBtn = new GridBagConstraints();
		gbc_audBtn.anchor = GridBagConstraints.WEST;
		gbc_audBtn.insets = new Insets(0, 0, 5, 5);
		gbc_audBtn.gridx = 0;
		gbc_audBtn.gridy = 0;
		audInnerPanel.add(audBtnBack, gbc_audBtn);

		JLabel audLabel = new JLabel("VisitID ");
		GridBagConstraints gbc_audlbl = new GridBagConstraints();
		gbc_audlbl.anchor = GridBagConstraints.EAST;
		gbc_audlbl.insets = new Insets(0, 0, 5, 5);
		gbc_audlbl.gridx = 0;
		gbc_audlbl.gridy = 1;
		audInnerPanel.add(audLabel, gbc_audlbl);

		audPrePopTextFields[0] = new JTextField();
		audPrePopTextFields[0].setEditable(false);
		audPrePopTextFields[0].setColumns(10);
		GridBagConstraints gbc_audTextField = new GridBagConstraints();
		gbc_audTextField.gridwidth = 3;
		gbc_audTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_audTextField.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField.gridx = 1;
		gbc_audTextField.gridy = 1;
		audInnerPanel.add(audPrePopTextFields[0], gbc_audTextField);

		JLabel audLabel_1 = new JLabel("Date ");
		GridBagConstraints gbc_audlbl_1 = new GridBagConstraints();
		gbc_audlbl_1.anchor = GridBagConstraints.EAST;
		gbc_audlbl_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlbl_1.gridx = 4;
		gbc_audlbl_1.gridy = 1;
		audInnerPanel.add(audLabel_1, gbc_audlbl_1);

		audPrePopTextFields[1] = new JTextField();
		audPrePopTextFields[1].setEditable(false);
		audPrePopTextFields[1].setColumns(10);
		GridBagConstraints gbc_audTextField_1 = new GridBagConstraints();
		gbc_audTextField_1.gridwidth = 3;
		gbc_audTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_audTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_1.gridx = 5;
		gbc_audTextField_1.gridy = 1;
		audInnerPanel.add(audPrePopTextFields[1], gbc_audTextField_1);

		JLabel audLabel_2 = new JLabel("Name ");
		GridBagConstraints gbc_audlbl_2 = new GridBagConstraints();
		gbc_audlbl_2.anchor = GridBagConstraints.EAST;
		gbc_audlbl_2.insets = new Insets(0, 0, 5, 5);
		gbc_audlbl_2.gridx = 0;
		gbc_audlbl_2.gridy = 2;
		audInnerPanel.add(audLabel_2, gbc_audlbl_2);

		audPrePopTextFields[2] = new JTextField();
		audPrePopTextFields[2].setEditable(false);
		audPrePopTextFields[2].setColumns(10);
		GridBagConstraints gbc_audTextField_2 = new GridBagConstraints();
		gbc_audTextField_2.gridwidth = 3;
		gbc_audTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_audTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_2.gridx = 1;
		gbc_audTextField_2.gridy = 2;
		audInnerPanel.add(audPrePopTextFields[2], gbc_audTextField_2);

		JLabel audLabel_3 = new JLabel("THC# ");
		GridBagConstraints gbc_audlbl_3 = new GridBagConstraints();
		gbc_audlbl_3.anchor = GridBagConstraints.EAST;
		gbc_audlbl_3.insets = new Insets(0, 0, 5, 5);
		gbc_audlbl_3.gridx = 4;
		gbc_audlbl_3.gridy = 2;
		audInnerPanel.add(audLabel_3, gbc_audlbl_3);

		audPrePopTextFields[3] = new JTextField();
		audPrePopTextFields[3].setEditable(false);
		audPrePopTextFields[3].setColumns(10);
		GridBagConstraints gbc_audTextField_3 = new GridBagConstraints();
		gbc_audTextField_3.gridwidth = 3;
		gbc_audTextField_3.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_audTextField_3.gridx = 5;
		gbc_audTextField_3.gridy = 2;
		audInnerPanel.add(audPrePopTextFields[3], gbc_audTextField_3);

		JLabel lblPuretoneAudiogramTests = new JLabel("Pure-tone audiogram tests for the right (R) and left (L) ear");
		GridBagConstraints gbc_audlblPuretoneAudiogramTests = new GridBagConstraints();
		gbc_audlblPuretoneAudiogramTests.insets = new Insets(0, 0, 5, 0);
		gbc_audlblPuretoneAudiogramTests.gridwidth = 8;
		gbc_audlblPuretoneAudiogramTests.gridx = 0;
		gbc_audlblPuretoneAudiogramTests.gridy = 3;
		audInnerPanel.add(lblPuretoneAudiogramTests, gbc_audlblPuretoneAudiogramTests);

		JLabel lblR = new JLabel("R.25 ");
		GridBagConstraints gbc_audlblR = new GridBagConstraints();
		gbc_audlblR.anchor = GridBagConstraints.EAST;
		gbc_audlblR.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR.gridx = 0;
		gbc_audlblR.gridy = 4;
		audInnerPanel.add(lblR, gbc_audlblR);

		audInpTextFields[0] = new JTextField();
		GridBagConstraints gbc_audTextField_4 = new GridBagConstraints();
		gbc_audTextField_4.anchor = GridBagConstraints.WEST;
		gbc_audTextField_4.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_4.gridx = 1;
		gbc_audTextField_4.gridy = 4;
		audInnerPanel.add(audInpTextFields[0], gbc_audTextField_4);
		audInpTextFields[0].setColumns(5);

		JLabel lblR_1 = new JLabel("R.50 ");
		GridBagConstraints gbc_audlblR_1 = new GridBagConstraints();
		gbc_audlblR_1.anchor = GridBagConstraints.EAST;
		gbc_audlblR_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_1.gridx = 2;
		gbc_audlblR_1.gridy = 4;
		audInnerPanel.add(lblR_1, gbc_audlblR_1);

		audInpTextFields[1] = new JTextField();
		audInpTextFields[1].setColumns(5);
		GridBagConstraints gbc_audTextField_5 = new GridBagConstraints();
		gbc_audTextField_5.anchor = GridBagConstraints.WEST;
		gbc_audTextField_5.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_5.gridx = 3;
		gbc_audTextField_5.gridy = 4;
		audInnerPanel.add(audInpTextFields[1], gbc_audTextField_5);

		JLabel lblR_2 = new JLabel("R1 ");
		GridBagConstraints gbc_audlblR_2 = new GridBagConstraints();
		gbc_audlblR_2.anchor = GridBagConstraints.EAST;
		gbc_audlblR_2.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_2.gridx = 4;
		gbc_audlblR_2.gridy = 4;
		audInnerPanel.add(lblR_2, gbc_audlblR_2);

		audInpTextFields[2] = new JTextField();
		audInpTextFields[2].setColumns(5);
		GridBagConstraints gbc_audTextField_6 = new GridBagConstraints();
		gbc_audTextField_6.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_6.anchor = GridBagConstraints.WEST;
		gbc_audTextField_6.gridx = 5;
		gbc_audTextField_6.gridy = 4;
		audInnerPanel.add(audInpTextFields[2], gbc_audTextField_6);

		JLabel lblR_3 = new JLabel("R2 ");
		GridBagConstraints gbc_audlblR_3 = new GridBagConstraints();
		gbc_audlblR_3.anchor = GridBagConstraints.EAST;
		gbc_audlblR_3.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_3.gridx = 6;
		gbc_audlblR_3.gridy = 4;
		audInnerPanel.add(lblR_3, gbc_audlblR_3);

		audInpTextFields[3] = new JTextField();
		audInpTextFields[3].setColumns(5);
		GridBagConstraints gbc_audTextField_7 = new GridBagConstraints();
		gbc_audTextField_7.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_7.anchor = GridBagConstraints.WEST;
		gbc_audTextField_7.gridx = 7;
		gbc_audTextField_7.gridy = 4;
		audInnerPanel.add(audInpTextFields[3], gbc_audTextField_7);

		JLabel lblR_4 = new JLabel("R3 ");
		GridBagConstraints gbc_audlblR_4 = new GridBagConstraints();
		gbc_audlblR_4.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_4.anchor = GridBagConstraints.EAST;
		gbc_audlblR_4.gridx = 0;
		gbc_audlblR_4.gridy = 5;
		audInnerPanel.add(lblR_4, gbc_audlblR_4);

		audInpTextFields[4] = new JTextField();
		audInpTextFields[4].setColumns(5);
		GridBagConstraints gbc_audTextField_8 = new GridBagConstraints();
		gbc_audTextField_8.anchor = GridBagConstraints.WEST;
		gbc_audTextField_8.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_8.gridx = 1;
		gbc_audTextField_8.gridy = 5;
		audInnerPanel.add(audInpTextFields[4], gbc_audTextField_8);

		JLabel lblR_5 = new JLabel("R4 ");
		GridBagConstraints gbc_audlblR_5 = new GridBagConstraints();
		gbc_audlblR_5.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_5.anchor = GridBagConstraints.EAST;
		gbc_audlblR_5.gridx = 2;
		gbc_audlblR_5.gridy = 5;
		audInnerPanel.add(lblR_5, gbc_audlblR_5);

		audInpTextFields[5] = new JTextField();
		audInpTextFields[5].setColumns(5);
		GridBagConstraints gbc_audTextField_9 = new GridBagConstraints();
		gbc_audTextField_9.anchor = GridBagConstraints.WEST;
		gbc_audTextField_9.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_9.gridx = 3;
		gbc_audTextField_9.gridy = 5;
		audInnerPanel.add(audInpTextFields[5], gbc_audTextField_9);

		JLabel lblR_6 = new JLabel("R6 ");
		GridBagConstraints gbc_audlblR_6 = new GridBagConstraints();
		gbc_audlblR_6.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_6.anchor = GridBagConstraints.EAST;
		gbc_audlblR_6.gridx = 4;
		gbc_audlblR_6.gridy = 5;
		audInnerPanel.add(lblR_6, gbc_audlblR_6);

		audInpTextFields[6] = new JTextField();
		audInpTextFields[6].setColumns(5);
		GridBagConstraints gbc_audTextField_10 = new GridBagConstraints();
		gbc_audTextField_10.anchor = GridBagConstraints.WEST;
		gbc_audTextField_10.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_10.gridx = 5;
		gbc_audTextField_10.gridy = 5;
		audInnerPanel.add(audInpTextFields[6], gbc_audTextField_10);

		JLabel lblR_7 = new JLabel("R8 ");
		GridBagConstraints gbc_audlblR_7 = new GridBagConstraints();
		gbc_audlblR_7.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_7.anchor = GridBagConstraints.EAST;
		gbc_audlblR_7.gridx = 6;
		gbc_audlblR_7.gridy = 5;
		audInnerPanel.add(lblR_7, gbc_audlblR_7);

		audInpTextFields[7] = new JTextField();
		audInpTextFields[7].setColumns(5);
		GridBagConstraints gbc_audTextField_11 = new GridBagConstraints();
		gbc_audTextField_11.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_11.anchor = GridBagConstraints.WEST;
		gbc_audTextField_11.gridx = 7;
		gbc_audTextField_11.gridy = 5;
		audInnerPanel.add(audInpTextFields[7], gbc_audTextField_11);

		JLabel lblR_8 = new JLabel("R10 ");
		GridBagConstraints gbc_audlblR_8 = new GridBagConstraints();
		gbc_audlblR_8.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_8.anchor = GridBagConstraints.EAST;
		gbc_audlblR_8.gridx = 0;
		gbc_audlblR_8.gridy = 6;
		audInnerPanel.add(lblR_8, gbc_audlblR_8);

		audInpTextFields[8] = new JTextField();
		audInpTextFields[8].setColumns(5);
		GridBagConstraints gbc_audTextField_12 = new GridBagConstraints();
		gbc_audTextField_12.anchor = GridBagConstraints.WEST;
		gbc_audTextField_12.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_12.gridx = 1;
		gbc_audTextField_12.gridy = 6;
		audInnerPanel.add(audInpTextFields[8], gbc_audTextField_12);

		JLabel lblR_9 = new JLabel("R12 ");
		GridBagConstraints gbc_audlblR_9 = new GridBagConstraints();
		gbc_audlblR_9.insets = new Insets(0, 0, 5, 5);
		gbc_audlblR_9.anchor = GridBagConstraints.EAST;
		gbc_audlblR_9.gridx = 2;
		gbc_audlblR_9.gridy = 6;
		audInnerPanel.add(lblR_9, gbc_audlblR_9);

		audInpTextFields[9] = new JTextField();
		audInpTextFields[9].setColumns(5);
		GridBagConstraints gbc_audTextField_13 = new GridBagConstraints();
		gbc_audTextField_13.anchor = GridBagConstraints.WEST;
		gbc_audTextField_13.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_13.gridx = 3;
		gbc_audTextField_13.gridy = 6;
		audInnerPanel.add(audInpTextFields[9], gbc_audTextField_13);

		JLabel lblL = new JLabel("L.25 ");
		GridBagConstraints gbc_audlblL = new GridBagConstraints();
		gbc_audlblL.anchor = GridBagConstraints.EAST;
		gbc_audlblL.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL.gridx = 0;
		gbc_audlblL.gridy = 7;
		audInnerPanel.add(lblL, gbc_audlblL);

		audInpTextFields[10] = new JTextField();
		audInpTextFields[10].setColumns(5);
		GridBagConstraints gbc_audTextField_14 = new GridBagConstraints();
		gbc_audTextField_14.anchor = GridBagConstraints.WEST;
		gbc_audTextField_14.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_14.gridx = 1;
		gbc_audTextField_14.gridy = 7;
		audInnerPanel.add(audInpTextFields[10], gbc_audTextField_14);

		JLabel lblL_1 = new JLabel("L.50 ");
		GridBagConstraints gbc_audlblL_1 = new GridBagConstraints();
		gbc_audlblL_1.anchor = GridBagConstraints.EAST;
		gbc_audlblL_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL_1.gridx = 2;
		gbc_audlblL_1.gridy = 7;
		audInnerPanel.add(lblL_1, gbc_audlblL_1);

		audInpTextFields[11] = new JTextField();
		audInpTextFields[11].setColumns(5);
		GridBagConstraints gbc_audTextField_15 = new GridBagConstraints();
		gbc_audTextField_15.anchor = GridBagConstraints.WEST;
		gbc_audTextField_15.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_15.gridx = 3;
		gbc_audTextField_15.gridy = 7;
		audInnerPanel.add(audInpTextFields[11], gbc_audTextField_15);

		JLabel lblL_2 = new JLabel("L1 ");
		GridBagConstraints gbc_audlblL_2 = new GridBagConstraints();
		gbc_audlblL_2.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL_2.anchor = GridBagConstraints.EAST;
		gbc_audlblL_2.gridx = 4;
		gbc_audlblL_2.gridy = 7;
		audInnerPanel.add(lblL_2, gbc_audlblL_2);

		audInpTextFields[12] = new JTextField();
		audInpTextFields[12].setColumns(5);
		GridBagConstraints gbc_audTextField_16 = new GridBagConstraints();
		gbc_audTextField_16.anchor = GridBagConstraints.WEST;
		gbc_audTextField_16.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_16.gridx = 5;
		gbc_audTextField_16.gridy = 7;
		audInnerPanel.add(audInpTextFields[12], gbc_audTextField_16);

		JLabel lblL_3 = new JLabel("L2 ");
		GridBagConstraints gbc_audlblL_3 = new GridBagConstraints();
		gbc_audlblL_3.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL_3.anchor = GridBagConstraints.EAST;
		gbc_audlblL_3.gridx = 6;
		gbc_audlblL_3.gridy = 7;
		audInnerPanel.add(lblL_3, gbc_audlblL_3);

		audInpTextFields[13] = new JTextField();
		audInpTextFields[13].setColumns(5);
		GridBagConstraints gbc_audTextField_17 = new GridBagConstraints();
		gbc_audTextField_17.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_17.anchor = GridBagConstraints.WEST;
		gbc_audTextField_17.gridx = 7;
		gbc_audTextField_17.gridy = 7;
		audInnerPanel.add(audInpTextFields[13], gbc_audTextField_17);

		JLabel lblL_4 = new JLabel("L3 ");
		GridBagConstraints gbc_audlblL_4 = new GridBagConstraints();
		gbc_audlblL_4.anchor = GridBagConstraints.EAST;
		gbc_audlblL_4.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL_4.gridx = 0;
		gbc_audlblL_4.gridy = 8;
		audInnerPanel.add(lblL_4, gbc_audlblL_4);

		audInpTextFields[14] = new JTextField();
		audInpTextFields[14].setColumns(5);
		GridBagConstraints gbc_audTextField_18 = new GridBagConstraints();
		gbc_audTextField_18.anchor = GridBagConstraints.WEST;
		gbc_audTextField_18.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_18.gridx = 1;
		gbc_audTextField_18.gridy = 8;
		audInnerPanel.add(audInpTextFields[14], gbc_audTextField_18);

		JLabel lblNewLabel1 = new JLabel("L4 ");
		GridBagConstraints gbc_audlblNewLabel = new GridBagConstraints();
		gbc_audlblNewLabel.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc_audlblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_audlblNewLabel.gridx = 2;
		gbc_audlblNewLabel.gridy = 8;
		audInnerPanel.add(lblNewLabel1, gbc_audlblNewLabel);

		audInpTextFields[15] = new JTextField();
		audInpTextFields[15].setColumns(5);
		GridBagConstraints gbc_audTextField_19 = new GridBagConstraints();
		gbc_audTextField_19.anchor = GridBagConstraints.WEST;
		gbc_audTextField_19.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_19.gridx = 3;
		gbc_audTextField_19.gridy = 8;
		audInnerPanel.add(audInpTextFields[15], gbc_audTextField_19);

		JLabel lblL_5 = new JLabel("L6 ");
		GridBagConstraints gbc_audlblL_5 = new GridBagConstraints();
		gbc_audlblL_5.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL_5.anchor = GridBagConstraints.EAST;
		gbc_audlblL_5.gridx = 4;
		gbc_audlblL_5.gridy = 8;
		audInnerPanel.add(lblL_5, gbc_audlblL_5);

		audInpTextFields[16] = new JTextField();
		audInpTextFields[16].setColumns(5);
		GridBagConstraints gbc_audTextField_20 = new GridBagConstraints();
		gbc_audTextField_20.anchor = GridBagConstraints.WEST;
		gbc_audTextField_20.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_20.gridx = 5;
		gbc_audTextField_20.gridy = 8;
		audInnerPanel.add(audInpTextFields[16], gbc_audTextField_20);

		JLabel lblL_6 = new JLabel("L8 ");
		GridBagConstraints gbc_audlblL_6 = new GridBagConstraints();
		gbc_audlblL_6.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL_6.anchor = GridBagConstraints.EAST;
		gbc_audlblL_6.gridx = 6;
		gbc_audlblL_6.gridy = 8;
		audInnerPanel.add(lblL_6, gbc_audlblL_6);

		audInpTextFields[17] = new JTextField();
		audInpTextFields[17].setColumns(5);
		GridBagConstraints gbc_audTextField_21 = new GridBagConstraints();
		gbc_audTextField_21.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_21.anchor = GridBagConstraints.WEST;
		gbc_audTextField_21.gridx = 7;
		gbc_audTextField_21.gridy = 8;
		audInnerPanel.add(audInpTextFields[17], gbc_audTextField_21);

		JLabel lblL_7 = new JLabel("L10 ");
		GridBagConstraints gbc_audlblL_7 = new GridBagConstraints();
		gbc_audlblL_7.anchor = GridBagConstraints.EAST;
		gbc_audlblL_7.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL_7.gridx = 0;
		gbc_audlblL_7.gridy = 9;
		audInnerPanel.add(lblL_7, gbc_audlblL_7);

		audInpTextFields[18] = new JTextField();
		audInpTextFields[18].setColumns(5);
		GridBagConstraints gbc_audTextField_22 = new GridBagConstraints();
		gbc_audTextField_22.anchor = GridBagConstraints.WEST;
		gbc_audTextField_22.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_22.gridx = 1;
		gbc_audTextField_22.gridy = 9;
		audInnerPanel.add(audInpTextFields[18], gbc_audTextField_22);

		JLabel lblL_8 = new JLabel("L12 ");
		GridBagConstraints gbc_audlblL_8 = new GridBagConstraints();
		gbc_audlblL_8.anchor = GridBagConstraints.EAST;
		gbc_audlblL_8.insets = new Insets(0, 0, 5, 5);
		gbc_audlblL_8.gridx = 2;
		gbc_audlblL_8.gridy = 9;
		audInnerPanel.add(lblL_8, gbc_audlblL_8);

		audInpTextFields[19] = new JTextField();
		audInpTextFields[19].setColumns(5);
		GridBagConstraints gbc_audTextField_23 = new GridBagConstraints();
		gbc_audTextField_23.anchor = GridBagConstraints.WEST;
		gbc_audTextField_23.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_23.gridx = 3;
		gbc_audTextField_23.gridy = 9;
		audInnerPanel.add(audInpTextFields[19], gbc_audTextField_23);

		JLabel lblRightEarTinnitus = new JLabel("Right ear Tinnitus");
		GridBagConstraints gbc_audlblRightEarTinnitus = new GridBagConstraints();
		gbc_audlblRightEarTinnitus.insets = new Insets(0, 0, 5, 0);
		gbc_audlblRightEarTinnitus.gridwidth = 8;
		gbc_audlblRightEarTinnitus.gridx = 0;
		gbc_audlblRightEarTinnitus.gridy = 10;
		audInnerPanel.add(lblRightEarTinnitus, gbc_audlblRightEarTinnitus);

		JLabel lblPitchMatch = new JLabel("Pitch Match ");
		GridBagConstraints gbc_audlblPitchMatch = new GridBagConstraints();
		gbc_audlblPitchMatch.anchor = GridBagConstraints.EAST;
		gbc_audlblPitchMatch.gridwidth = 3;
		gbc_audlblPitchMatch.insets = new Insets(0, 0, 5, 5);
		gbc_audlblPitchMatch.gridx = 0;
		gbc_audlblPitchMatch.gridy = 11;
		audInnerPanel.add(lblPitchMatch, gbc_audlblPitchMatch);

		audInpTextFields[20] = new JTextField();
		audInpTextFields[20].setColumns(5);
		GridBagConstraints gbc_audTextField_24 = new GridBagConstraints();
		gbc_audTextField_24.anchor = GridBagConstraints.WEST;
		gbc_audTextField_24.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_24.gridx = 3;
		gbc_audTextField_24.gridy = 11;
		audInnerPanel.add(audInpTextFields[20], gbc_audTextField_24);

		JLabel lblMatchType = new JLabel("Match Type ");
		GridBagConstraints gbc_audlblMatchType = new GridBagConstraints();
		gbc_audlblMatchType.anchor = GridBagConstraints.EAST;
		gbc_audlblMatchType.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMatchType.gridx = 4;
		gbc_audlblMatchType.gridy = 11;
		audInnerPanel.add(lblMatchType, gbc_audlblMatchType);

		audInpTextFields[21] = new JTextField();
		audInpTextFields[21].setColumns(5);
		GridBagConstraints gbc_audTextField_25 = new GridBagConstraints();
		gbc_audTextField_25.anchor = GridBagConstraints.WEST;
		gbc_audTextField_25.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_25.gridx = 5;
		gbc_audTextField_25.gridy = 11;
		audInnerPanel.add(audInpTextFields[21], gbc_audTextField_25);

		JLabel lblLoudness = new JLabel("Loudness  ");
		GridBagConstraints gbc_audlblLoudness = new GridBagConstraints();
		gbc_audlblLoudness.anchor = GridBagConstraints.EAST;
		gbc_audlblLoudness.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLoudness.gridx = 6;
		gbc_audlblLoudness.gridy = 11;
		audInnerPanel.add(lblLoudness, gbc_audlblLoudness);

		audInpTextFields[22] = new JTextField();
		audInpTextFields[22].setColumns(5);
		GridBagConstraints gbc_audTextField_26 = new GridBagConstraints();
		gbc_audTextField_26.anchor = GridBagConstraints.WEST;
		gbc_audTextField_26.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_26.gridx = 7;
		gbc_audTextField_26.gridy = 11;
		audInnerPanel.add(audInpTextFields[22], gbc_audTextField_26);

		JLabel lblThresholdOfHearing = new JLabel("Threshold of Hearing, Th R ");
		GridBagConstraints gbc_audlblThresholdOfHearing = new GridBagConstraints();
		gbc_audlblThresholdOfHearing.anchor = GridBagConstraints.EAST;
		gbc_audlblThresholdOfHearing.gridwidth = 3;
		gbc_audlblThresholdOfHearing.insets = new Insets(0, 0, 5, 5);
		gbc_audlblThresholdOfHearing.gridx = 0;
		gbc_audlblThresholdOfHearing.gridy = 12;
		audInnerPanel.add(lblThresholdOfHearing, gbc_audlblThresholdOfHearing);

		audInpTextFields[23] = new JTextField();
		audInpTextFields[23].setColumns(5);
		GridBagConstraints gbc_audTextField_27 = new GridBagConstraints();
		gbc_audTextField_27.anchor = GridBagConstraints.WEST;
		gbc_audTextField_27.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_27.gridx = 3;
		gbc_audTextField_27.gridy = 12;
		audInnerPanel.add(audInpTextFields[23], gbc_audTextField_27);

		JLabel lblTrls = new JLabel("TRLs ");
		GridBagConstraints gbc_audlblTrls = new GridBagConstraints();
		gbc_audlblTrls.anchor = GridBagConstraints.EAST;
		gbc_audlblTrls.insets = new Insets(0, 0, 5, 5);
		gbc_audlblTrls.gridx = 4;
		gbc_audlblTrls.gridy = 12;
		audInnerPanel.add(lblTrls, gbc_audlblTrls);

		audInpTextFields[24] = new JTextField();
		audInpTextFields[24].setColumns(5);
		GridBagConstraints gbc_audTextField_28 = new GridBagConstraints();
		gbc_audTextField_28.anchor = GridBagConstraints.WEST;
		gbc_audTextField_28.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_28.gridx = 5;
		gbc_audTextField_28.gridy = 12;
		audInnerPanel.add(audInpTextFields[24], gbc_audTextField_28);

		JLabel lblLeftEarTinnitus = new JLabel("Left ear Tinnitus");
		GridBagConstraints gbc_audlblLeftEarTinnitus = new GridBagConstraints();
		gbc_audlblLeftEarTinnitus.insets = new Insets(0, 0, 5, 0);
		gbc_audlblLeftEarTinnitus.gridwidth = 8;
		gbc_audlblLeftEarTinnitus.gridx = 0;
		gbc_audlblLeftEarTinnitus.gridy = 13;
		audInnerPanel.add(lblLeftEarTinnitus, gbc_audlblLeftEarTinnitus);

		JLabel lblPitchMatch_1 = new JLabel("Pitch Match ");
		GridBagConstraints gbc_audlblPitchMatch_1 = new GridBagConstraints();
		gbc_audlblPitchMatch_1.anchor = GridBagConstraints.EAST;
		gbc_audlblPitchMatch_1.gridwidth = 3;
		gbc_audlblPitchMatch_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlblPitchMatch_1.gridx = 0;
		gbc_audlblPitchMatch_1.gridy = 14;
		audInnerPanel.add(lblPitchMatch_1, gbc_audlblPitchMatch_1);

		audInpTextFields[25] = new JTextField();
		audInpTextFields[25].setColumns(5);
		GridBagConstraints gbc_audTextField_29 = new GridBagConstraints();
		gbc_audTextField_29.anchor = GridBagConstraints.WEST;
		gbc_audTextField_29.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_29.gridx = 3;
		gbc_audTextField_29.gridy = 14;
		audInnerPanel.add(audInpTextFields[25], gbc_audTextField_29);

		JLabel audLabel_4 = new JLabel("Match Type ");
		GridBagConstraints gbc_audlbl_4 = new GridBagConstraints();
		gbc_audlbl_4.insets = new Insets(0, 0, 5, 5);
		gbc_audlbl_4.anchor = GridBagConstraints.EAST;
		gbc_audlbl_4.gridx = 4;
		gbc_audlbl_4.gridy = 14;
		audInnerPanel.add(audLabel_4, gbc_audlbl_4);

		audInpTextFields[26] = new JTextField();
		audInpTextFields[26].setColumns(5);
		GridBagConstraints gbc_audTextField_30 = new GridBagConstraints();
		gbc_audTextField_30.anchor = GridBagConstraints.WEST;
		gbc_audTextField_30.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_30.gridx = 5;
		gbc_audTextField_30.gridy = 14;
		audInnerPanel.add(audInpTextFields[26], gbc_audTextField_30);

		JLabel lblLoudness_1 = new JLabel("Loudness ");
		GridBagConstraints gbc_audlblLoudness_1 = new GridBagConstraints();
		gbc_audlblLoudness_1.anchor = GridBagConstraints.EAST;
		gbc_audlblLoudness_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLoudness_1.gridx = 6;
		gbc_audlblLoudness_1.gridy = 14;
		audInnerPanel.add(lblLoudness_1, gbc_audlblLoudness_1);

		audInpTextFields[27] = new JTextField();
		audInpTextFields[27].setColumns(5);
		GridBagConstraints gbc_audTextField_31 = new GridBagConstraints();
		gbc_audTextField_31.anchor = GridBagConstraints.WEST;
		gbc_audTextField_31.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_31.gridx = 7;
		gbc_audTextField_31.gridy = 14;
		audInnerPanel.add(audInpTextFields[27], gbc_audTextField_31);

		JLabel lblThresholdOfHearing_1 = new JLabel("Threshold of Hearing, Th L ");
		GridBagConstraints gbc_audlblThresholdOfHearing_1 = new GridBagConstraints();
		gbc_audlblThresholdOfHearing_1.anchor = GridBagConstraints.EAST;
		gbc_audlblThresholdOfHearing_1.gridwidth = 3;
		gbc_audlblThresholdOfHearing_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlblThresholdOfHearing_1.gridx = 0;
		gbc_audlblThresholdOfHearing_1.gridy = 15;
		audInnerPanel.add(lblThresholdOfHearing_1, gbc_audlblThresholdOfHearing_1);

		audInpTextFields[28] = new JTextField();
		audInpTextFields[28].setColumns(5);
		GridBagConstraints gbc_audTextField_32 = new GridBagConstraints();
		gbc_audTextField_32.anchor = GridBagConstraints.WEST;
		gbc_audTextField_32.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_32.gridx = 3;
		gbc_audTextField_32.gridy = 15;
		audInnerPanel.add(audInpTextFields[28], gbc_audTextField_32);

		JLabel lblNewLabel_11 = new JLabel("T Ls ");
		GridBagConstraints gbc_audlblNewLabel_1 = new GridBagConstraints();
		gbc_audlblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_audlblNewLabel_1.gridx = 4;
		gbc_audlblNewLabel_1.gridy = 15;
		audInnerPanel.add(lblNewLabel_11, gbc_audlblNewLabel_1);

		audInpTextFields[29] = new JTextField();
		audInpTextFields[29].setColumns(5);
		GridBagConstraints gbc_audTextField_33 = new GridBagConstraints();
		gbc_audTextField_33.anchor = GridBagConstraints.WEST;
		gbc_audTextField_33.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_33.gridx = 5;
		gbc_audTextField_33.gridy = 15;
		audInnerPanel.add(audInpTextFields[29], gbc_audTextField_33);

		JLabel lblWnr = new JLabel("WNR ");
		GridBagConstraints gbc_audlblWnr = new GridBagConstraints();
		gbc_audlblWnr.insets = new Insets(0, 0, 5, 5);
		gbc_audlblWnr.anchor = GridBagConstraints.EAST;
		gbc_audlblWnr.gridx = 2;
		gbc_audlblWnr.gridy = 16;
		audInnerPanel.add(lblWnr, gbc_audlblWnr);

		audInpTextFields[30] = new JTextField();
		audInpTextFields[30].setColumns(5);
		GridBagConstraints gbc_audTextField_34 = new GridBagConstraints();
		gbc_audTextField_34.anchor = GridBagConstraints.WEST;
		gbc_audTextField_34.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_34.gridx = 3;
		gbc_audTextField_34.gridy = 16;
		audInnerPanel.add(audInpTextFields[30], gbc_audTextField_34);

		JLabel lblWnl = new JLabel("WNL ");
		GridBagConstraints gbc_audlblWnl = new GridBagConstraints();
		gbc_audlblWnl.anchor = GridBagConstraints.EAST;
		gbc_audlblWnl.insets = new Insets(0, 0, 5, 5);
		gbc_audlblWnl.gridx = 4;
		gbc_audlblWnl.gridy = 16;
		audInnerPanel.add(lblWnl, gbc_audlblWnl);

		audInpTextFields[31] = new JTextField();
		audInpTextFields[31].setColumns(5);
		GridBagConstraints gbc_audTextField_35 = new GridBagConstraints();
		gbc_audTextField_35.anchor = GridBagConstraints.WEST;
		gbc_audTextField_35.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_35.gridx = 5;
		gbc_audTextField_35.gridy = 16;
		audInnerPanel.add(audInpTextFields[31], gbc_audTextField_35);

		JLabel lblMinimalMaskingLevel = new JLabel("Minimal Masking Level");
		GridBagConstraints gbc_audlblMinimalMaskingLevel = new GridBagConstraints();
		gbc_audlblMinimalMaskingLevel.insets = new Insets(0, 0, 5, 0);
		gbc_audlblMinimalMaskingLevel.gridwidth = 8;
		gbc_audlblMinimalMaskingLevel.gridx = 0;
		gbc_audlblMinimalMaskingLevel.gridy = 17;
		audInnerPanel.add(lblMinimalMaskingLevel, gbc_audlblMinimalMaskingLevel);

		JLabel lblNewLabel_2 = new JLabel("MRR ");
		GridBagConstraints gbc_audlblNewLabel_2 = new GridBagConstraints();
		gbc_audlblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_audlblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_audlblNewLabel_2.gridx = 2;
		gbc_audlblNewLabel_2.gridy = 18;
		audInnerPanel.add(lblNewLabel_2, gbc_audlblNewLabel_2);

		audInpTextFields[32] = new JTextField();
		audInpTextFields[32].setColumns(5);
		GridBagConstraints gbc_audTextField_36 = new GridBagConstraints();
		gbc_audTextField_36.anchor = GridBagConstraints.WEST;
		gbc_audTextField_36.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_36.gridx = 3;
		gbc_audTextField_36.gridy = 18;
		audInnerPanel.add(audInpTextFields[32], gbc_audTextField_36);

		JLabel lblMrb = new JLabel("MRL ");
		GridBagConstraints gbc_audlblMrb = new GridBagConstraints();
		gbc_audlblMrb.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMrb.anchor = GridBagConstraints.EAST;
		gbc_audlblMrb.gridx = 4;
		gbc_audlblMrb.gridy = 18;
		audInnerPanel.add(lblMrb, gbc_audlblMrb);

		audInpTextFields[33] = new JTextField();
		audInpTextFields[33].setColumns(5);
		GridBagConstraints gbc_audTextField_37 = new GridBagConstraints();
		gbc_audTextField_37.anchor = GridBagConstraints.WEST;
		gbc_audTextField_37.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_37.gridx = 5;
		gbc_audTextField_37.gridy = 18;
		audInnerPanel.add(audInpTextFields[33], gbc_audTextField_37);

		JLabel lblMbr = new JLabel("MRB ");
		GridBagConstraints gbc_audlblMbr = new GridBagConstraints();
		gbc_audlblMbr.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMbr.anchor = GridBagConstraints.EAST;
		gbc_audlblMbr.gridx = 6;
		gbc_audlblMbr.gridy = 18;
		audInnerPanel.add(lblMbr, gbc_audlblMbr);

		audInpTextFields[34] = new JTextField();
		audInpTextFields[34].setColumns(5);
		GridBagConstraints gbc_audTextField_38 = new GridBagConstraints();
		gbc_audTextField_38.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_38.anchor = GridBagConstraints.WEST;
		gbc_audTextField_38.gridx = 7;
		gbc_audTextField_38.gridy = 18;
		audInnerPanel.add(audInpTextFields[34], gbc_audTextField_38);

		JLabel lblMrl = new JLabel("MLR ");
		GridBagConstraints gbc_audlblMrl = new GridBagConstraints();
		gbc_audlblMrl.anchor = GridBagConstraints.EAST;
		gbc_audlblMrl.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMrl.gridx = 2;
		gbc_audlblMrl.gridy = 19;
		audInnerPanel.add(lblMrl, gbc_audlblMrl);

		audInpTextFields[35] = new JTextField();
		audInpTextFields[35].setColumns(5);
		GridBagConstraints gbc_audTextField_39 = new GridBagConstraints();
		gbc_audTextField_39.anchor = GridBagConstraints.WEST;
		gbc_audTextField_39.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_39.gridx = 3;
		gbc_audTextField_39.gridy = 19;
		audInnerPanel.add(audInpTextFields[35], gbc_audTextField_39);

		JLabel lblMlb = new JLabel("MLL ");
		GridBagConstraints gbc_audlblMlb = new GridBagConstraints();
		gbc_audlblMlb.anchor = GridBagConstraints.EAST;
		gbc_audlblMlb.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMlb.gridx = 4;
		gbc_audlblMlb.gridy = 19;
		audInnerPanel.add(lblMlb, gbc_audlblMlb);

		audInpTextFields[36] = new JTextField();
		audInpTextFields[36].setColumns(5);
		GridBagConstraints gbc_audTextField_40 = new GridBagConstraints();
		gbc_audTextField_40.anchor = GridBagConstraints.WEST;
		gbc_audTextField_40.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_40.gridx = 5;
		gbc_audTextField_40.gridy = 19;
		audInnerPanel.add(audInpTextFields[36], gbc_audTextField_40);

		JLabel lblMbl = new JLabel("MLB ");
		GridBagConstraints gbc_audlblMbl = new GridBagConstraints();
		gbc_audlblMbl.anchor = GridBagConstraints.EAST;
		gbc_audlblMbl.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMbl.gridx = 6;
		gbc_audlblMbl.gridy = 19;
		audInnerPanel.add(lblMbl, gbc_audlblMbl);

		audInpTextFields[37] = new JTextField();
		audInpTextFields[37].setColumns(5);
		GridBagConstraints gbc_audTextField_41 = new GridBagConstraints();
		gbc_audTextField_41.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_41.anchor = GridBagConstraints.WEST;
		gbc_audTextField_41.gridx = 7;
		gbc_audTextField_41.gridy = 19;
		audInnerPanel.add(audInpTextFields[37], gbc_audTextField_41);

		JLabel lblMBl = new JLabel("MBR ");
		GridBagConstraints gbc_audlblMBl = new GridBagConstraints();
		gbc_audlblMBl.anchor = GridBagConstraints.EAST;
		gbc_audlblMBl.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMBl.gridx = 2;
		gbc_audlblMBl.gridy = 20;
		audInnerPanel.add(lblMBl, gbc_audlblMBl);

		audInpTextFields[38] = new JTextField();
		audInpTextFields[38].setColumns(5);
		GridBagConstraints gbc_audTextField_42 = new GridBagConstraints();
		gbc_audTextField_42.anchor = GridBagConstraints.WEST;
		gbc_audTextField_42.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_42.gridx = 3;
		gbc_audTextField_42.gridy = 20;
		audInnerPanel.add(audInpTextFields[38], gbc_audTextField_42);

		JLabel lblMBb = new JLabel("M BL ");
		GridBagConstraints gbc_audlblMBb = new GridBagConstraints();
		gbc_audlblMBb.anchor = GridBagConstraints.EAST;
		gbc_audlblMBb.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMBb.gridx = 4;
		gbc_audlblMBb.gridy = 20;
		audInnerPanel.add(lblMBb, gbc_audlblMBb);

		audInpTextFields[39] = new JTextField();
		audInpTextFields[39].setColumns(5);
		GridBagConstraints gbc_audTextField_43 = new GridBagConstraints();
		gbc_audTextField_43.anchor = GridBagConstraints.WEST;
		gbc_audTextField_43.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_43.gridx = 5;
		gbc_audTextField_43.gridy = 20;
		audInnerPanel.add(audInpTextFields[39], gbc_audTextField_43);

		JLabel lblMBbb = new JLabel("M BB ");
		GridBagConstraints gbc_audlblMBbb = new GridBagConstraints();
		gbc_audlblMBbb.anchor = GridBagConstraints.EAST;
		gbc_audlblMBbb.insets = new Insets(0, 0, 5, 5);
		gbc_audlblMBbb.gridx = 6;
		gbc_audlblMBbb.gridy = 20;
		audInnerPanel.add(lblMBbb, gbc_audlblMBbb);

		audInpTextFields[40] = new JTextField();
		audInpTextFields[40].setColumns(5);
		GridBagConstraints gbc_audTextField_a = new GridBagConstraints();
		gbc_audTextField_a.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_a.anchor = GridBagConstraints.WEST;
		gbc_audTextField_a.gridx = 7;
		gbc_audTextField_a.gridy = 20;
		audInnerPanel.add(audInpTextFields[40], gbc_audTextField_a);

		JLabel lblRsd = new JLabel("RSD ");
		GridBagConstraints gbc_audlblRsd = new GridBagConstraints();
		gbc_audlblRsd.anchor = GridBagConstraints.EAST;
		gbc_audlblRsd.insets = new Insets(0, 0, 5, 5);
		gbc_audlblRsd.gridx = 2;
		gbc_audlblRsd.gridy = 21;
		audInnerPanel.add(lblRsd, gbc_audlblRsd);

		audInpTextFields[41] = new JTextField();
		audInpTextFields[41].setColumns(5);
		GridBagConstraints gbc_audTextField_44 = new GridBagConstraints();
		gbc_audTextField_44.anchor = GridBagConstraints.WEST;
		gbc_audTextField_44.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_44.gridx = 3;
		gbc_audTextField_44.gridy = 21;
		audInnerPanel.add(audInpTextFields[41], gbc_audTextField_44);

		JLabel lblLsd = new JLabel("LSD ");
		GridBagConstraints gbc_audlblLsd = new GridBagConstraints();
		gbc_audlblLsd.anchor = GridBagConstraints.EAST;
		gbc_audlblLsd.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLsd.gridx = 4;
		gbc_audlblLsd.gridy = 21;
		audInnerPanel.add(lblLsd, gbc_audlblLsd);

		audInpTextFields[42] = new JTextField();
		audInpTextFields[42].setColumns(5);
		GridBagConstraints gbc_audTextField_45 = new GridBagConstraints();
		gbc_audTextField_45.anchor = GridBagConstraints.WEST;
		gbc_audTextField_45.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_45.gridx = 5;
		gbc_audTextField_45.gridy = 21;
		audInnerPanel.add(audInpTextFields[42], gbc_audTextField_45);

		JLabel lblPuretoneLoudnessDiscomfort = new JLabel(
				"Pure-tone Loudness Discomfort Levels (LDL) tests for the right (R)");
		GridBagConstraints gbc_audlblPuretoneLoudnessDiscomfort = new GridBagConstraints();
		gbc_audlblPuretoneLoudnessDiscomfort.insets = new Insets(0, 0, 5, 0);
		gbc_audlblPuretoneLoudnessDiscomfort.gridwidth = 8;
		gbc_audlblPuretoneLoudnessDiscomfort.gridx = 0;
		gbc_audlblPuretoneLoudnessDiscomfort.gridy = 22;
		audInnerPanel.add(lblPuretoneLoudnessDiscomfort, gbc_audlblPuretoneLoudnessDiscomfort);

		JLabel lblLr = new JLabel("LR.50 ");
		GridBagConstraints gbc_audlblLr = new GridBagConstraints();
		gbc_audlblLr.anchor = GridBagConstraints.EAST;
		gbc_audlblLr.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLr.gridx = 0;
		gbc_audlblLr.gridy = 23;
		audInnerPanel.add(lblLr, gbc_audlblLr);

		audInpTextFields[43] = new JTextField();
		audInpTextFields[43].setColumns(5);
		GridBagConstraints gbc_audTextField_46 = new GridBagConstraints();
		gbc_audTextField_46.anchor = GridBagConstraints.WEST;
		gbc_audTextField_46.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_46.gridx = 1;
		gbc_audTextField_46.gridy = 23;
		audInnerPanel.add(audInpTextFields[43], gbc_audTextField_46);

		JLabel lblLr_1 = new JLabel("LR1 ");
		GridBagConstraints gbc_audlblLr_1 = new GridBagConstraints();
		gbc_audlblLr_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLr_1.anchor = GridBagConstraints.EAST;
		gbc_audlblLr_1.gridx = 2;
		gbc_audlblLr_1.gridy = 23;
		audInnerPanel.add(lblLr_1, gbc_audlblLr_1);

		audInpTextFields[44] = new JTextField();
		audInpTextFields[44].setColumns(5);
		GridBagConstraints gbc_audTextField_47 = new GridBagConstraints();
		gbc_audTextField_47.anchor = GridBagConstraints.WEST;
		gbc_audTextField_47.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_47.gridx = 3;
		gbc_audTextField_47.gridy = 23;
		audInnerPanel.add(audInpTextFields[44], gbc_audTextField_47);

		JLabel lblLr_2 = new JLabel("LR2 ");
		GridBagConstraints gbc_audlblLr_2 = new GridBagConstraints();
		gbc_audlblLr_2.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLr_2.anchor = GridBagConstraints.EAST;
		gbc_audlblLr_2.gridx = 4;
		gbc_audlblLr_2.gridy = 23;
		audInnerPanel.add(lblLr_2, gbc_audlblLr_2);

		audInpTextFields[45] = new JTextField();
		audInpTextFields[45].setColumns(5);
		GridBagConstraints gbc_audTextField_48 = new GridBagConstraints();
		gbc_audTextField_48.anchor = GridBagConstraints.WEST;
		gbc_audTextField_48.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_48.gridx = 5;
		gbc_audTextField_48.gridy = 23;
		audInnerPanel.add(audInpTextFields[45], gbc_audTextField_48);

		JLabel lblLr_3 = new JLabel("LR3 ");
		GridBagConstraints gbc_audlblLr_3 = new GridBagConstraints();
		gbc_audlblLr_3.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLr_3.anchor = GridBagConstraints.EAST;
		gbc_audlblLr_3.gridx = 6;
		gbc_audlblLr_3.gridy = 23;
		audInnerPanel.add(lblLr_3, gbc_audlblLr_3);

		audInpTextFields[46] = new JTextField();
		audInpTextFields[46].setColumns(5);
		GridBagConstraints gbc_audTextField_49 = new GridBagConstraints();
		gbc_audTextField_49.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_49.anchor = GridBagConstraints.WEST;
		gbc_audTextField_49.gridx = 7;
		gbc_audTextField_49.gridy = 23;
		audInnerPanel.add(audInpTextFields[46], gbc_audTextField_49);

		JLabel lblLr_4 = new JLabel("LR4 ");
		GridBagConstraints gbc_audlblLr_4 = new GridBagConstraints();
		gbc_audlblLr_4.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLr_4.anchor = GridBagConstraints.EAST;
		gbc_audlblLr_4.gridx = 0;
		gbc_audlblLr_4.gridy = 24;
		audInnerPanel.add(lblLr_4, gbc_audlblLr_4);

		audInpTextFields[47] = new JTextField();
		audInpTextFields[47].setColumns(5);
		GridBagConstraints gbc_audTextField_50 = new GridBagConstraints();
		gbc_audTextField_50.anchor = GridBagConstraints.WEST;
		gbc_audTextField_50.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_50.gridx = 1;
		gbc_audTextField_50.gridy = 24;
		audInnerPanel.add(audInpTextFields[47], gbc_audTextField_50);

		JLabel lblLr_5 = new JLabel("LR6 ");
		GridBagConstraints gbc_audlblLr_5 = new GridBagConstraints();
		gbc_audlblLr_5.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLr_5.anchor = GridBagConstraints.EAST;
		gbc_audlblLr_5.gridx = 2;
		gbc_audlblLr_5.gridy = 24;
		audInnerPanel.add(lblLr_5, gbc_audlblLr_5);

		audInpTextFields[48] = new JTextField();
		audInpTextFields[48].setColumns(5);
		GridBagConstraints gbc_audTextField_51 = new GridBagConstraints();
		gbc_audTextField_51.anchor = GridBagConstraints.WEST;
		gbc_audTextField_51.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_51.gridx = 3;
		gbc_audTextField_51.gridy = 24;
		audInnerPanel.add(audInpTextFields[48], gbc_audTextField_51);

		JLabel lblLr_6 = new JLabel("LR8 ");
		GridBagConstraints gbc_audlblLr_6 = new GridBagConstraints();
		gbc_audlblLr_6.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLr_6.anchor = GridBagConstraints.EAST;
		gbc_audlblLr_6.gridx = 4;
		gbc_audlblLr_6.gridy = 24;
		audInnerPanel.add(lblLr_6, gbc_audlblLr_6);

		audInpTextFields[49] = new JTextField();
		audInpTextFields[49].setColumns(5);
		GridBagConstraints gbc_audTextField_52 = new GridBagConstraints();
		gbc_audTextField_52.anchor = GridBagConstraints.WEST;
		gbc_audTextField_52.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_52.gridx = 5;
		gbc_audTextField_52.gridy = 24;
		audInnerPanel.add(audInpTextFields[49], gbc_audTextField_52);

		JLabel lblLr_7 = new JLabel("LR12 ");
		GridBagConstraints gbc_audlblLr_7 = new GridBagConstraints();
		gbc_audlblLr_7.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLr_7.anchor = GridBagConstraints.EAST;
		gbc_audlblLr_7.gridx = 6;
		gbc_audlblLr_7.gridy = 24;
		audInnerPanel.add(lblLr_7, gbc_audlblLr_7);

		audInpTextFields[50] = new JTextField();
		audInpTextFields[50].setColumns(5);
		GridBagConstraints gbc_audTextField_53 = new GridBagConstraints();
		gbc_audTextField_53.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_53.anchor = GridBagConstraints.WEST;
		gbc_audTextField_53.gridx = 7;
		gbc_audTextField_53.gridy = 24;
		audInnerPanel.add(audInpTextFields[50], gbc_audTextField_53);

		JLabel lblLrtp = new JLabel("LRTP ");
		GridBagConstraints gbc_audlblLrtp = new GridBagConstraints();
		gbc_audlblLrtp.anchor = GridBagConstraints.EAST;
		gbc_audlblLrtp.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLrtp.gridx = 0;
		gbc_audlblLrtp.gridy = 25;
		audInnerPanel.add(lblLrtp, gbc_audlblLrtp);

		audInpTextFields[51] = new JTextField();
		audInpTextFields[51].setColumns(5);
		GridBagConstraints gbc_audTextField_54 = new GridBagConstraints();
		gbc_audTextField_54.anchor = GridBagConstraints.WEST;
		gbc_audTextField_54.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_54.gridx = 1;
		gbc_audTextField_54.gridy = 25;
		audInnerPanel.add(audInpTextFields[51], gbc_audTextField_54);

		JLabel lblLl = new JLabel("LL.50 ");
		GridBagConstraints gbc_audlblLl = new GridBagConstraints();
		gbc_audlblLl.anchor = GridBagConstraints.EAST;
		gbc_audlblLl.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLl.gridx = 0;
		gbc_audlblLl.gridy = 26;
		audInnerPanel.add(lblLl, gbc_audlblLl);

		audInpTextFields[52] = new JTextField();
		audInpTextFields[52].setColumns(5);
		GridBagConstraints gbc_audTextField_55 = new GridBagConstraints();
		gbc_audTextField_55.anchor = GridBagConstraints.WEST;
		gbc_audTextField_55.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_55.gridx = 1;
		gbc_audTextField_55.gridy = 26;
		audInnerPanel.add(audInpTextFields[52], gbc_audTextField_55);

		JLabel lblLl_1 = new JLabel("LL1 ");
		GridBagConstraints gbc_audlblLl_1 = new GridBagConstraints();
		gbc_audlblLl_1.anchor = GridBagConstraints.EAST;
		gbc_audlblLl_1.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLl_1.gridx = 2;
		gbc_audlblLl_1.gridy = 26;
		audInnerPanel.add(lblLl_1, gbc_audlblLl_1);

		audInpTextFields[53] = new JTextField();
		audInpTextFields[53].setColumns(5);
		GridBagConstraints gbc_audTextField_56 = new GridBagConstraints();
		gbc_audTextField_56.anchor = GridBagConstraints.WEST;
		gbc_audTextField_56.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_56.gridx = 3;
		gbc_audTextField_56.gridy = 26;
		audInnerPanel.add(audInpTextFields[53], gbc_audTextField_56);

		JLabel lblLl_2 = new JLabel("LL2 ");
		GridBagConstraints gbc_audlblLl_2 = new GridBagConstraints();
		gbc_audlblLl_2.anchor = GridBagConstraints.EAST;
		gbc_audlblLl_2.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLl_2.gridx = 4;
		gbc_audlblLl_2.gridy = 26;
		audInnerPanel.add(lblLl_2, gbc_audlblLl_2);

		audInpTextFields[54] = new JTextField();
		audInpTextFields[54].setColumns(5);
		GridBagConstraints gbc_audTextField_57 = new GridBagConstraints();
		gbc_audTextField_57.anchor = GridBagConstraints.WEST;
		gbc_audTextField_57.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_57.gridx = 5;
		gbc_audTextField_57.gridy = 26;
		audInnerPanel.add(audInpTextFields[54], gbc_audTextField_57);

		JLabel lblLl_3 = new JLabel("LL3 ");
		GridBagConstraints gbc_audlblLl_3 = new GridBagConstraints();
		gbc_audlblLl_3.anchor = GridBagConstraints.EAST;
		gbc_audlblLl_3.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLl_3.gridx = 6;
		gbc_audlblLl_3.gridy = 26;
		audInnerPanel.add(lblLl_3, gbc_audlblLl_3);

		audInpTextFields[55] = new JTextField();
		audInpTextFields[55].setColumns(5);
		GridBagConstraints gbc_audTextField_58 = new GridBagConstraints();
		gbc_audTextField_58.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_58.anchor = GridBagConstraints.WEST;
		gbc_audTextField_58.gridx = 7;
		gbc_audTextField_58.gridy = 26;
		audInnerPanel.add(audInpTextFields[55], gbc_audTextField_58);

		JLabel lblLl_4 = new JLabel("LL4 ");
		GridBagConstraints gbc_audlblLl_4 = new GridBagConstraints();
		gbc_audlblLl_4.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLl_4.anchor = GridBagConstraints.EAST;
		gbc_audlblLl_4.gridx = 0;
		gbc_audlblLl_4.gridy = 27;
		audInnerPanel.add(lblLl_4, gbc_audlblLl_4);

		audInpTextFields[56] = new JTextField();
		audInpTextFields[56].setColumns(5);
		GridBagConstraints gbc_audTextField_59 = new GridBagConstraints();
		gbc_audTextField_59.anchor = GridBagConstraints.WEST;
		gbc_audTextField_59.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_59.gridx = 1;
		gbc_audTextField_59.gridy = 27;
		audInnerPanel.add(audInpTextFields[56], gbc_audTextField_59);

		JLabel lblLl_5 = new JLabel("LL6 ");
		GridBagConstraints gbc_audlblLl_5 = new GridBagConstraints();
		gbc_audlblLl_5.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLl_5.anchor = GridBagConstraints.EAST;
		gbc_audlblLl_5.gridx = 2;
		gbc_audlblLl_5.gridy = 27;
		audInnerPanel.add(lblLl_5, gbc_audlblLl_5);

		audInpTextFields[57] = new JTextField();
		audInpTextFields[57].setColumns(5);
		GridBagConstraints gbc_audTextField_60 = new GridBagConstraints();
		gbc_audTextField_60.anchor = GridBagConstraints.WEST;
		gbc_audTextField_60.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_60.gridx = 3;
		gbc_audTextField_60.gridy = 27;
		audInnerPanel.add(audInpTextFields[57], gbc_audTextField_60);

		JLabel lblLl_6 = new JLabel("LL8 ");
		GridBagConstraints gbc_audlblLl_6 = new GridBagConstraints();
		gbc_audlblLl_6.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLl_6.anchor = GridBagConstraints.EAST;
		gbc_audlblLl_6.gridx = 4;
		gbc_audlblLl_6.gridy = 27;
		audInnerPanel.add(lblLl_6, gbc_audlblLl_6);

		audInpTextFields[58] = new JTextField();
		audInpTextFields[58].setColumns(5);
		GridBagConstraints gbc_audTextField_61 = new GridBagConstraints();
		gbc_audTextField_61.anchor = GridBagConstraints.WEST;
		gbc_audTextField_61.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_61.gridx = 5;
		gbc_audTextField_61.gridy = 27;
		audInnerPanel.add(audInpTextFields[58], gbc_audTextField_61);

		JLabel lblLl_7 = new JLabel("LL12 ");
		GridBagConstraints gbc_audlblLl_7 = new GridBagConstraints();
		gbc_audlblLl_7.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLl_7.anchor = GridBagConstraints.EAST;
		gbc_audlblLl_7.gridx = 6;
		gbc_audlblLl_7.gridy = 27;
		audInnerPanel.add(lblLl_7, gbc_audlblLl_7);

		audInpTextFields[59] = new JTextField();
		audInpTextFields[59].setColumns(5);
		GridBagConstraints gbc_audTextField_62 = new GridBagConstraints();
		gbc_audTextField_62.insets = new Insets(0, 0, 5, 0);
		gbc_audTextField_62.anchor = GridBagConstraints.WEST;
		gbc_audTextField_62.gridx = 7;
		gbc_audTextField_62.gridy = 27;
		audInnerPanel.add(audInpTextFields[59], gbc_audTextField_62);

		JLabel lblLltp = new JLabel("LLTP ");
		GridBagConstraints gbc_audlblLltp = new GridBagConstraints();
		gbc_audlblLltp.anchor = GridBagConstraints.EAST;
		gbc_audlblLltp.insets = new Insets(0, 0, 5, 5);
		gbc_audlblLltp.gridx = 0;
		gbc_audlblLltp.gridy = 28;
		audInnerPanel.add(lblLltp, gbc_audlblLltp);

		audInpTextFields[60] = new JTextField();
		audInpTextFields[60].setColumns(5);
		GridBagConstraints gbc_audTextField_63 = new GridBagConstraints();
		gbc_audTextField_63.anchor = GridBagConstraints.WEST;
		gbc_audTextField_63.insets = new Insets(0, 0, 5, 5);
		gbc_audTextField_63.gridx = 1;
		gbc_audTextField_63.gridy = 28;
		audInnerPanel.add(audInpTextFields[60], gbc_audTextField_63);

		JLabel lblComments1 = new JLabel("Comments ");
		GridBagConstraints gbc_audlblComments = new GridBagConstraints();
		gbc_audlblComments.insets = new Insets(0, 0, 5, 5);
		gbc_audlblComments.gridx = 0;
		gbc_audlblComments.gridy = 29;
		audInnerPanel.add(lblComments1, gbc_audlblComments);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_audScrollPane_1 = new GridBagConstraints();
		gbc_audScrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_audScrollPane_1.gridwidth = 7;
		gbc_audScrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_audScrollPane_1.gridx = 1;
		gbc_audScrollPane_1.gridy = 29;
		audInnerPanel.add(scrollPane_1, gbc_audScrollPane_1);

		JTextArea audTextArea = new JTextArea();
		audTextArea.setLineWrap(true);
		scrollPane_1.setViewportView(audTextArea);

		JButton audBtnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.gridwidth = 3;
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 30;
		audInnerPanel.add(audBtnSubmit, gbc_btnSave);

		JButton audBtnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 3;
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 30;
		audInnerPanel.add(audBtnCancel, gbc_btnCancel);

		// MEDICAMENT PAGE********************************************************************************************************************

		aeMedDataPanel = new JPanel();
		GridBagLayout gbl_aeMedDataPanel = new GridBagLayout();
		gbl_aeMedDataPanel.columnWidths = new int[] { 0, 0 };
		gbl_aeMedDataPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_aeMedDataPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_aeMedDataPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		aeMedDataPanel.setLayout(gbl_aeMedDataPanel);

		medBtnBack = new JButton("Back");
		GridBagConstraints gbc_medBtnBack = new GridBagConstraints();
		gbc_medBtnBack.anchor = GridBagConstraints.WEST;
		gbc_medBtnBack.insets = new Insets(0, 0, 5, 0);
		gbc_medBtnBack.gridx = 0;
		gbc_medBtnBack.gridy = 0;
		aeMedDataPanel.add(medBtnBack, gbc_medBtnBack);

		JTabbedPane medTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_medTabbedPane = new GridBagConstraints();
		gbc_medTabbedPane.fill = GridBagConstraints.BOTH;
		gbc_medTabbedPane.gridx = 0;
		gbc_medTabbedPane.gridy = 1;
		aeMedDataPanel.add(medTabbedPane, gbc_medTabbedPane);

		JPanel addMedPanel = new JPanel();
		medTabbedPane.addTab("Add Medication", null, addMedPanel, null);
		GridBagLayout gbl_addMedPanel = new GridBagLayout();
		gbl_addMedPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_addMedPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_addMedPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_addMedPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		addMedPanel.setLayout(gbl_addMedPanel);

		JLabel medlblId = new JLabel("ID ");
		GridBagConstraints gbc_medlblId = new GridBagConstraints();
		gbc_medlblId.insets = new Insets(0, 0, 5, 5);
		gbc_medlblId.anchor = GridBagConstraints.EAST;
		gbc_medlblId.gridx = 0;
		gbc_medlblId.gridy = 0;
		addMedPanel.add(medlblId, gbc_medlblId);

		medTextField_id = new JTextField();
		GridBagConstraints gbc_medTextField = new GridBagConstraints();
		gbc_medTextField.insets = new Insets(0, 0, 5, 5);
		gbc_medTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_medTextField.gridx = 1;
		gbc_medTextField.gridy = 0;
		addMedPanel.add(medTextField_id, gbc_medTextField);
		medTextField_id.setColumns(10);

		JLabel medlblName = new JLabel("Name ");
		GridBagConstraints gbc_medlblName = new GridBagConstraints();
		gbc_medlblName.anchor = GridBagConstraints.EAST;
		gbc_medlblName.insets = new Insets(0, 0, 5, 5);
		gbc_medlblName.gridx = 2;
		gbc_medlblName.gridy = 0;
		addMedPanel.add(medlblName, gbc_medlblName);

		medTextField_name = new JTextField();
		GridBagConstraints gbc_medTextField_1 = new GridBagConstraints();
		gbc_medTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_medTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_medTextField_1.gridx = 3;
		gbc_medTextField_1.gridy = 0;
		addMedPanel.add(medTextField_name, gbc_medTextField_1);
		medTextField_name.setColumns(10);

		JLabel medlblDescription = new JLabel("Description ");
		GridBagConstraints gbc_medlblDescription = new GridBagConstraints();
		gbc_medlblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_medlblDescription.gridx = 0;
		gbc_medlblDescription.gridy = 1;
		addMedPanel.add(medlblDescription, gbc_medlblDescription);

		JScrollPane medscrollPane = new JScrollPane();
		GridBagConstraints gbc_medscrollPane = new GridBagConstraints();
		gbc_medscrollPane.gridwidth = 3;
		gbc_medscrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_medscrollPane.fill = GridBagConstraints.BOTH;
		gbc_medscrollPane.gridx = 1;
		gbc_medscrollPane.gridy = 1;
		addMedPanel.add(medscrollPane, gbc_medscrollPane);

		medTextArea_desc = new JTextArea();
		medscrollPane.setViewportView(medTextArea_desc);

		JLabel medlblUsualDose = new JLabel("Usual Dose ");
		GridBagConstraints gbc_medlblUsualDose = new GridBagConstraints();
		gbc_medlblUsualDose.anchor = GridBagConstraints.EAST;
		gbc_medlblUsualDose.insets = new Insets(0, 0, 5, 5);
		gbc_medlblUsualDose.gridx = 0;
		gbc_medlblUsualDose.gridy = 2;
		addMedPanel.add(medlblUsualDose, gbc_medlblUsualDose);

		medTextField_dose = new JTextField();
		GridBagConstraints gbc_medTextField_2 = new GridBagConstraints();
		gbc_medTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_medTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_medTextField_2.gridx = 1;
		gbc_medTextField_2.gridy = 2;
		addMedPanel.add(medTextField_dose, gbc_medTextField_2);
		medTextField_dose.setColumns(10);

		JLabel medlblGenericId = new JLabel("Generic ");
		GridBagConstraints gbc_medlblGenericId = new GridBagConstraints();
		gbc_medlblGenericId.anchor = GridBagConstraints.EAST;
		gbc_medlblGenericId.insets = new Insets(0, 0, 5, 5);
		gbc_medlblGenericId.gridx = 2;
		gbc_medlblGenericId.gridy = 2;
		addMedPanel.add(medlblGenericId, gbc_medlblGenericId);

		medcomboBox_generic = new JComboBox();
		GridBagConstraints gbc_medcomboBox = new GridBagConstraints();
		gbc_medcomboBox.insets = new Insets(0, 0, 5, 0);
		gbc_medcomboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_medcomboBox.gridx = 3;
		gbc_medcomboBox.gridy = 2;
		addMedPanel.add(medcomboBox_generic, gbc_medcomboBox);

		JLabel medlblChemicalCategory = new JLabel("Chemical Category ");
		GridBagConstraints gbc_medlblChemicalCategory = new GridBagConstraints();
		gbc_medlblChemicalCategory.anchor = GridBagConstraints.EAST;
		gbc_medlblChemicalCategory.insets = new Insets(0, 0, 5, 5);
		gbc_medlblChemicalCategory.gridx = 0;
		gbc_medlblChemicalCategory.gridy = 3;
		addMedPanel.add(medlblChemicalCategory, gbc_medlblChemicalCategory);

		medcomboBox_chemical = new JComboBox();
		GridBagConstraints gbc_medcomboBox_1 = new GridBagConstraints();
		gbc_medcomboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_medcomboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_medcomboBox_1.gridx = 1;
		gbc_medcomboBox_1.gridy = 3;
		addMedPanel.add(medcomboBox_chemical, gbc_medcomboBox_1);

		JLabel medlblDisease = new JLabel("Disease ");
		GridBagConstraints gbc_medlblDisease = new GridBagConstraints();
		gbc_medlblDisease.anchor = GridBagConstraints.EAST;
		gbc_medlblDisease.insets = new Insets(0, 0, 5, 5);
		gbc_medlblDisease.gridx = 2;
		gbc_medlblDisease.gridy = 3;
		addMedPanel.add(medlblDisease, gbc_medlblDisease);

		medcomboBox_disease = new JComboBox();
		GridBagConstraints gbc_medcomboBox_2 = new GridBagConstraints();
		gbc_medcomboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_medcomboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_medcomboBox_2.gridx = 3;
		gbc_medcomboBox_2.gridy = 3;
		addMedPanel.add(medcomboBox_disease, gbc_medcomboBox_2);

		medBtnAdd = new JButton("Add");
		GridBagConstraints gbc_medBtnAdd = new GridBagConstraints();
		gbc_medBtnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_medBtnAdd.gridwidth = 4;
		gbc_medBtnAdd.gridx = 0;
		gbc_medBtnAdd.gridy = 4;
		addMedPanel.add(medBtnAdd, gbc_medBtnAdd);

		JPanel editMedPanel = new JPanel();
		medTabbedPane.addTab("Edit Medication", null, editMedPanel, null);
		GridBagLayout gbl_editMedPanel = new GridBagLayout();
		gbl_editMedPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_editMedPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_editMedPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_editMedPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		editMedPanel.setLayout(gbl_editMedPanel);

		JLabel medlblId_1 = new JLabel("ID ");
		GridBagConstraints gbc_medlblId_1 = new GridBagConstraints();
		gbc_medlblId_1.anchor = GridBagConstraints.EAST;
		gbc_medlblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_medlblId_1.gridx = 0;
		gbc_medlblId_1.gridy = 0;
		editMedPanel.add(medlblId_1, gbc_medlblId_1);

		medTextField_idSearch = new JTextField();
		GridBagConstraints gbc_medTextField_3 = new GridBagConstraints();
		gbc_medTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_medTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_medTextField_3.gridx = 1;
		gbc_medTextField_3.gridy = 0;
		editMedPanel.add(medTextField_idSearch, gbc_medTextField_3);
		medTextField_idSearch.setColumns(10);

		JLabel medlblName_1 = new JLabel("Name ");
		GridBagConstraints gbc_medlblName_1 = new GridBagConstraints();
		gbc_medlblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_medlblName_1.anchor = GridBagConstraints.EAST;
		gbc_medlblName_1.gridx = 2;
		gbc_medlblName_1.gridy = 0;
		editMedPanel.add(medlblName_1, gbc_medlblName_1);

		medTextField_nameSearch = new JTextField();
		GridBagConstraints gbc_medTextField_4 = new GridBagConstraints();
		gbc_medTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_medTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_medTextField_4.gridx = 3;
		gbc_medTextField_4.gridy = 0;
		editMedPanel.add(medTextField_nameSearch, gbc_medTextField_4);
		medTextField_nameSearch.setColumns(10);

		medBtnSearch = new JButton("Search");
		GridBagConstraints gbc_medBtnSearch = new GridBagConstraints();
		gbc_medBtnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_medBtnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_medBtnSearch.gridwidth = 4;
		gbc_medBtnSearch.gridx = 0;
		gbc_medBtnSearch.gridy = 1;
		editMedPanel.add(medBtnSearch, gbc_medBtnSearch);

		JScrollPane medscrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_medscrollPane_2 = new GridBagConstraints();
		gbc_medscrollPane_2.gridwidth = 4;
		gbc_medscrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_medscrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_medscrollPane_2.gridx = 0;
		gbc_medscrollPane_2.gridy = 2;
		editMedPanel.add(medscrollPane_2, gbc_medscrollPane_2);

		// RESULT TABLE HERE***************************
		medResTable = new JTable();
		medResModel = new DefaultTableModel();
		medResModel.setColumnIdentifiers(new String[]{"id", "name", "description", "dose", "generic", "chemical", "disease"});
		medResTable.setModel(medResModel);
		medResTable.setFillsViewportHeight(true);
		medscrollPane_2.setViewportView(medResTable);
		medResTable.setRowSelectionAllowed(true);
		medResTable.setDefaultEditor(Object.class, null);

		JLabel medlblId_2 = new JLabel("ID ");
		GridBagConstraints gbc_medlblId_2 = new GridBagConstraints();
		gbc_medlblId_2.anchor = GridBagConstraints.EAST;
		gbc_medlblId_2.insets = new Insets(0, 0, 5, 5);
		gbc_medlblId_2.gridx = 0;
		gbc_medlblId_2.gridy = 3;
		editMedPanel.add(medlblId_2, gbc_medlblId_2);

		medTextField_resID = new JTextField();
		GridBagConstraints gbc_medTextField_5 = new GridBagConstraints();
		gbc_medTextField_5.insets = new Insets(0, 0, 5, 5);
		gbc_medTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_medTextField_5.gridx = 1;
		gbc_medTextField_5.gridy = 3;
		editMedPanel.add(medTextField_resID, gbc_medTextField_5);
		medTextField_resID.setColumns(10);

		JLabel medlblName_2 = new JLabel("Name ");
		GridBagConstraints gbc_medlblName_2 = new GridBagConstraints();
		gbc_medlblName_2.anchor = GridBagConstraints.EAST;
		gbc_medlblName_2.insets = new Insets(0, 0, 5, 5);
		gbc_medlblName_2.gridx = 2;
		gbc_medlblName_2.gridy = 3;
		editMedPanel.add(medlblName_2, gbc_medlblName_2);

		medTextField_resName = new JTextField();
		GridBagConstraints gbc_medTextField_6 = new GridBagConstraints();
		gbc_medTextField_6.insets = new Insets(0, 0, 5, 0);
		gbc_medTextField_6.gridwidth = 3;
		gbc_medTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_medTextField_6.gridx = 3;
		gbc_medTextField_6.gridy = 3;
		editMedPanel.add(medTextField_resName, gbc_medTextField_6);
		medTextField_resName.setColumns(10);

		JLabel medlblDescription_1 = new JLabel("Description ");
		GridBagConstraints gbc_medlblDescription_1 = new GridBagConstraints();
		gbc_medlblDescription_1.anchor = GridBagConstraints.EAST;
		gbc_medlblDescription_1.insets = new Insets(0, 0, 5, 5);
		gbc_medlblDescription_1.gridx = 0;
		gbc_medlblDescription_1.gridy = 4;
		editMedPanel.add(medlblDescription_1, gbc_medlblDescription_1);

		JScrollPane medscrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_medscrollPane_1 = new GridBagConstraints();
		gbc_medscrollPane_1.gridwidth = 3;
		gbc_medscrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_medscrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_medscrollPane_1.gridx = 1;
		gbc_medscrollPane_1.gridy = 4;
		editMedPanel.add(medscrollPane_1, gbc_medscrollPane_1);

		medTextArea_resDesc = new JTextArea();
		medscrollPane_1.setViewportView(medTextArea_resDesc);

		JLabel medlblUsualDose_2 = new JLabel("Usual Dose ");
		GridBagConstraints gbc_medlblUsualDose_2 = new GridBagConstraints();
		gbc_medlblUsualDose_2.anchor = GridBagConstraints.EAST;
		gbc_medlblUsualDose_2.insets = new Insets(0, 0, 5, 5);
		gbc_medlblUsualDose_2.gridx = 0;
		gbc_medlblUsualDose_2.gridy = 5;
		editMedPanel.add(medlblUsualDose_2, gbc_medlblUsualDose_2);

		medTextField_resDose = new JTextField();
		medTextField_resDose.setColumns(10);
		GridBagConstraints gbc_medTextField_7 = new GridBagConstraints();
		gbc_medTextField_7.insets = new Insets(0, 0, 5, 5);
		gbc_medTextField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_medTextField_7.gridx = 1;
		gbc_medTextField_7.gridy = 5;
		editMedPanel.add(medTextField_resDose, gbc_medTextField_7);

		JLabel medlblGeneric = new JLabel("Generic ");
		GridBagConstraints gbc_medlblGeneric = new GridBagConstraints();
		gbc_medlblGeneric.anchor = GridBagConstraints.EAST;
		gbc_medlblGeneric.insets = new Insets(0, 0, 5, 5);
		gbc_medlblGeneric.gridx = 2;
		gbc_medlblGeneric.gridy = 5;
		editMedPanel.add(medlblGeneric, gbc_medlblGeneric);

		medcomboBox_resGen = new JComboBox();
		GridBagConstraints gbc_medcomboBox_3 = new GridBagConstraints();
		gbc_medcomboBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_medcomboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_medcomboBox_3.gridx = 3;
		gbc_medcomboBox_3.gridy = 5;
		editMedPanel.add(medcomboBox_resGen, gbc_medcomboBox_3);

		JLabel medlblChemicalCategory_1 = new JLabel("Chemical Category ");
		GridBagConstraints gbc_medlblChemicalCategory_1 = new GridBagConstraints();
		gbc_medlblChemicalCategory_1.anchor = GridBagConstraints.EAST;
		gbc_medlblChemicalCategory_1.insets = new Insets(0, 0, 5, 5);
		gbc_medlblChemicalCategory_1.gridx = 0;
		gbc_medlblChemicalCategory_1.gridy = 6;
		editMedPanel.add(medlblChemicalCategory_1, gbc_medlblChemicalCategory_1);

		medcomboBox_resChm = new JComboBox();
		GridBagConstraints gbc_medcomboBox_4 = new GridBagConstraints();
		gbc_medcomboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_medcomboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_medcomboBox_4.gridx = 1;
		gbc_medcomboBox_4.gridy = 6;
		editMedPanel.add(medcomboBox_resChm, gbc_medcomboBox_4);

		JLabel medlblDisease_1 = new JLabel("Disease ");
		GridBagConstraints gbc_medlblDisease_1 = new GridBagConstraints();
		gbc_medlblDisease_1.anchor = GridBagConstraints.EAST;
		gbc_medlblDisease_1.insets = new Insets(0, 0, 5, 5);
		gbc_medlblDisease_1.gridx = 2;
		gbc_medlblDisease_1.gridy = 6;
		editMedPanel.add(medlblDisease_1, gbc_medlblDisease_1);

		medcomboBox_resDis = new JComboBox();
		GridBagConstraints gbc_medcomboBox_5 = new GridBagConstraints();
		gbc_medcomboBox_5.insets = new Insets(0, 0, 5, 0);
		gbc_medcomboBox_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_medcomboBox_5.gridx = 3;
		gbc_medcomboBox_5.gridy = 6;
		editMedPanel.add(medcomboBox_resDis, gbc_medcomboBox_5);

		JButton medBtnSubmit = new JButton("Submit");
		GridBagConstraints gbc_medBtnSubmit = new GridBagConstraints();
		gbc_medBtnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_medBtnSubmit.gridwidth = 4;
		gbc_medBtnSubmit.gridx = 0;
		gbc_medBtnSubmit.gridy = 7;
		editMedPanel.add(medBtnSubmit, gbc_medBtnSubmit);

		// add views********************************************************************************************************************
		panelContainer = new JPanel();
		CardLayout cardLayout = new CardLayout();
		panelContainer.setLayout(cardLayout);
		panelContainer.add(mainPanel, "main");
		panelContainer.add(patientsPanel, "patients");
		panelContainer.add(addPatientPanel, "addPatients");
		panelContainer.add(visitsPanel, "visits");
		panelContainer.add(addVisitPanel, "addVisits");
		panelContainer.add(otherPanel, "other");
		panelContainer.add(pharmDataPanel, "pharmData");
		panelContainer.add(aeChemDataPanel, "chemData");
		panelContainer.add(aeGenDataPanel, "genData");
		panelContainer.add(aeDisDataPanel, "disData");
		panelContainer.add(aeMedDataPanel, "medData");
		panelContainer.add(visPharmPanel, "visPharm");
		panelContainer.add(audioPanel, "visAudio");

		// **************************************This section contains all action listeners*********************************************
		// Here you can attach action listeners to GUI components. If you want to access
		// a database, use the handlers in the handlers
		// package. Try to keep the action listeners grouped by the page they belong to.
		// *****************************************************************************************************************************
		cardLayout.show(panelContainer, "main");

		// MAIN PAGE LISTENERS
		mainPatientsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "patients");
			}
		});

		mainVisitsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "visits");
			}
		});

		mainOtherButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "other");
			}
		});

		// PATIENT PAGE LISTENERS
		patientsBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "main");
			}
		});

		patientsAddNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "addPatients");
			}
		});

		// ADD PATIENT PAGE LISTENERS
		apBtnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "patients");
			}
		});

		apBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "patients");
			}
		});

		// VISIT PAGE LISTENERS
		visitsBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "main");
			}
		});

		visitsAddNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "addVisits");
			}
		});

		// ADD VISIT PAGE LISTENERS
		avBtnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "visits");
			}
		});

		avBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "visits");
			}
		});

		avBtnAudiology.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
				PatientResponse res = handlers.patientHandler.firstPatientEntry();
                audPrePopTextFields[0].setText("1");
                audPrePopTextFields[1].setText(dtf.format(now));
                audPrePopTextFields[2].setText(res.first_name + " " + res.middle_name + " " + res.sur_name);
                audPrePopTextFields[3].setText(res.thc);
			    cardLayout.show(panelContainer, "visAudio");
			}
		});

		avBtnPharm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "visPharm");
			}
		});

		//VISIT AUDIOLOGY LISTENERS
		audBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "addVisits");
			}
		});
		audBtnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] audiologyReport = new String[audInpTextFields.length];
				for (int i = 0; i < audiologyReport.length; i++) {
					if(audInpTextFields[i].getText().length() == 0) {
						audiologyReport[i] = "" + 0;
					} else {
						audiologyReport[i] = audInpTextFields[i].getText();
					}
				}

				handlers.audiologyHandler.insertAudioLogy(audPrePopTextFields[0].getText(),audTextArea.getText(), audiologyReport);
			}
		});

		// VISIT PHARMACOLOGY LISTENERS
		vpBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "addVisits");
			}
		});

		vpBtnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "addVisits");
			}
		});

		// OPTION PAGE LISTENERS
		oBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "main");
			}
		});

		oBtnPharmData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "pharmData");
			}
		});

// PHARMACOLOGY DATA PAGE
		pdBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "other");
			}
		});

		pdBtnAEChemical.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "chemData");
			}
		});

		pdBtnAEGeneric.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "genData");
			}
		});
		pdBtnAEDisease.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "disData");
			}
		});
		pdBtnAEMedication.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "medData");

				medcomboBox_generic.removeAllItems();
				medcomboBox_resGen.removeAllItems();
				medcomboBox_resChm.removeAllItems();
				medcomboBox_chemical.removeAllItems();
				medcomboBox_disease.removeAllItems();
				medcomboBox_resDis.removeAllItems();

				String[] gens = handlers.genericRefHandler.getAllGenericNames();
				for(int i =0; i < gens.length; i++) {
					medcomboBox_generic.addItem(gens[i]);
					medcomboBox_resGen.addItem(gens[i]);
				}

				String[] chems = handlers.chemicalRefHandler.getAllChemicalNames();
				for(int i =0; i < chems.length; i++)  {
					medcomboBox_chemical.addItem(chems[i]);
					medcomboBox_resChm.addItem(chems[i]);
				}

				String[] dis = handlers.diseaseRefHandler.getAllDiseaseNames();
				for(int i=0; i <dis.length; i++) {
					medcomboBox_disease.addItem(dis[i]);
					medcomboBox_resDis.addItem(dis[i]);
				}
			}
		});


		// CHEMICAL DATA PAGE
		chmBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chmTextField_id.setText("");
				chmTextField_name.setText("");
				chmTextArea_desc.setText("");
				chmTextField_resID.setText("");
				chmTextField_resName.setText("");
				chmTextArea_resDesc.setText("");
				chmResModel.setRowCount(0);
				chmTextField_idSearch.setText("");
				chmTextField_nameSearch.setText("");
				cardLayout.show(panelContainer, "pharmData");

			}
		});

		chmBtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = chmTextField_id.getText();
				String name = chmTextField_name.getText();
				String description = chmTextArea_desc.getText();
				try {
					handlers.chemicalRefHandler.insertChemical(id, name, description);
					chmTextField_id.setText("");
					chmTextField_name.setText("");
					chmTextArea_desc.setText("");

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		chmBtnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = chmTextField_idSearch.getText();
				String name = chmTextField_nameSearch.getText();
				ChemicalRefResponse res = new ChemicalRefResponse(0, "", "");
				Object[][] results;
				try {
					if (id.length() > 0)
						res = handlers.chemicalRefHandler.finById(id);
					else if (name.length() > 0)
						res = handlers.chemicalRefHandler.finByName(name);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("GET:" + res.chemical_id + " " + res.name);
				chmResModel.setRowCount(0);
				chmResModel.addRow(new Object[]{res.chemical_id, res.name, res.description});
				chmResTable.setVisible(true);
				chmResModel.fireTableDataChanged();
			}
		});

		chmResTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (chmResTable.getSelectedRow() > -1) {
					chmTextField_resID.setText(chmResTable.getValueAt(chmResTable.getSelectedRow(), 0).toString());
					chmTextField_resName.setText(chmResTable.getValueAt(chmResTable.getSelectedRow(), 1).toString());
					chmTextArea_resDesc.setText(chmResTable.getValueAt(chmResTable.getSelectedRow(), 2).toString());
				}
			}
		});

		chmBtnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = chmTextField_resID.getText();
				String name = chmTextField_resName.getText();
				String description = chmTextArea_resDesc.getText();
				try {
					handlers.chemicalRefHandler.updateChemical(id, name, description);
					chmTextField_resID.setText("");
					chmTextField_resName.setText("");
					chmTextArea_resDesc.setText("");
					chmResModel.setRowCount(0);
					chmTextField_idSearch.setText("");
					chmTextField_nameSearch.setText("");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		// GENERIC DATA PAGE
		genBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				genTextField_id.setText("");
				genTextField_name.setText("");
				genTextArea_desc.setText("");
				genTextField_resID.setText("");
				genTextField_resName.setText("");
				genTextArea_resDesc.setText("");
				genResModel.setRowCount(0);
				genTextField_idSearch.setText("");
				genTextField_nameSearch.setText("");
				cardLayout.show(panelContainer, "pharmData");
			}
		});

		genBtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = genTextField_id.getText();
				String name = genTextField_name.getText();
				String description = genTextArea_desc.getText();
				try {
					//Generic handler insert
					handlers.genericRefHandler.insertGeneric(id, name, description);
					genTextField_id.setText("");
					genTextField_name.setText("");
					genTextArea_desc.setText("");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		genBtnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = genTextField_idSearch.getText();
				String name = genTextField_nameSearch.getText();
				GenericRefResponse res = new GenericRefResponse(0, "", "");
				Object[][] results;
				try {
					if (id.length() > 0)
						res = handlers.genericRefHandler.finById(id);
					else if (name.length() > 0)
						res = handlers.genericRefHandler.finByName(name);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("GET:" + res.generic_id + " " + res.name);
				genResModel.setRowCount(0);
				genResModel.addRow(new Object[]{res.generic_id, res.name, res.description});
				genResTable.setVisible(true);
				genResModel.fireTableDataChanged();
			}
		});

		genResTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (genResTable.getSelectedRow() > -1) {
					genTextField_resID.setText(genResTable.getValueAt(genResTable.getSelectedRow(), 0).toString());
					genTextField_resName.setText(genResTable.getValueAt(genResTable.getSelectedRow(), 1).toString());
					genTextArea_resDesc.setText(genResTable.getValueAt(genResTable.getSelectedRow(), 2).toString());
				}
			}
		});

		genBtnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = genTextField_resID.getText();
				String name = genTextField_resName.getText();
				String description = genTextArea_resDesc.getText();
				try {
					handlers.genericRefHandler.updateGeneric(id, name, description);
					genTextField_resID.setText("");
					genTextField_resName.setText("");
					genTextArea_resDesc.setText("");
					genResModel.setRowCount(0);
					genTextField_idSearch.setText("");
					genTextField_nameSearch.setText("");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		// DISEASE DATA PAGE
		disBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				disTextField_id.setText("");
				disTextField_name.setText("");
				disTextArea_desc.setText("");
				disTextField_resID.setText("");
				disTextField_resName.setText("");
				disTextArea_resDesc.setText("");
				disResModel.setRowCount(0);
				disTextField_idSearch.setText("");
				disTextField_nameSearch.setText("");
				cardLayout.show(panelContainer, "pharmData");

			}
		});

		disBtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = disTextField_id.getText();
				String name = disTextField_name.getText();
				String description = disTextArea_desc.getText();
				try {
					//Generic handler insert
					handlers.diseaseRefHandler.insertDisease(id, name, description);
					disTextField_id.setText("");
					disTextField_name.setText("");
					disTextArea_desc.setText("");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		disBtnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = disTextField_idSearch.getText();
				String name = disTextField_nameSearch.getText();
				DiseaseRefResponse res = new DiseaseRefResponse(0, "", "");
				Object[][] results;
				try {
					if (id.length() > 0)
						res = handlers.diseaseRefHandler.finById(id);
					else if (name.length() > 0)
						res = handlers.diseaseRefHandler.finByName(name);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("GET:" + res.disease_id + " " + res.name);
				disResModel.setRowCount(0);
				disResModel.addRow(new Object[]{res.disease_id, res.name, res.description});
				disResTable.setVisible(true);
				disResModel.fireTableDataChanged();
			}
		});

		disResTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (disResTable.getSelectedRow() > -1) {
					disTextField_resID.setText(disResTable.getValueAt(disResTable.getSelectedRow(), 0).toString());
					disTextField_resName.setText(disResTable.getValueAt(disResTable.getSelectedRow(), 1).toString());
					disTextArea_resDesc.setText(disResTable.getValueAt(disResTable.getSelectedRow(), 2).toString());
				}
			}
		});

		disBtnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = disTextField_resID.getText();
				String name = disTextField_resName.getText();
				String description = disTextArea_resDesc.getText();
				try {
					handlers.diseaseRefHandler.updateDisease(id, name, description);
					disTextField_resID.setText("");
					disTextField_resName.setText("");
					disTextArea_resDesc.setText("");
					disResModel.setRowCount(0);
					disTextField_idSearch.setText("");
					disTextField_nameSearch.setText("");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		// MEDICAMENT DATA PAGE
		medBtnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(panelContainer, "pharmData");

			}
		});

		medBtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = medTextField_id.getText();
				String name = medTextField_name.getText();
				String description = medTextArea_desc.getText();
				String dose = medTextField_dose.getText();
				GenericRefResponse gen = new GenericRefResponse(0, "", "");
				ChemicalRefResponse chm = new ChemicalRefResponse(0, "", "");
				DiseaseRefResponse dis = new DiseaseRefResponse(0, "", "");
				try {
					//Generic handler insert
					gen = handlers.genericRefHandler.finByName(medcomboBox_generic.getSelectedItem().toString());
					chm = handlers.chemicalRefHandler.finByName(medcomboBox_chemical.getSelectedItem().toString());
					dis = handlers.diseaseRefHandler.finByName(medcomboBox_disease.getSelectedItem().toString());
					//Generic handler insert
					handlers.medicamentRefHandler.insertMedicament(id, name, description, dose, gen.generic_id + "", chm.chemical_id + "", dis.disease_id + "");

					//handlers.diseaseRefHandler.insertDisease(id, name, description);
					medTextField_id.setText("");
					medTextField_name.setText("");
					medTextArea_desc.setText("");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		medBtnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = medTextField_idSearch.getText();
				String name = medTextField_nameSearch.getText();
				MedicamentRefResponse res = new MedicamentRefResponse(0, "", "", 0, 0,0,0);
				Object[][] results;
				String resGenName = "";
				String resChmName = "";
				String resDisName = "";
				try {
					if (id.length() > 0)
						res = handlers.medicamentRefHandler.finById(id);
					else if (name.length() > 0)
						res = handlers.medicamentRefHandler.finByName(name);
					resGenName = handlers.genericRefHandler.finById(res.generic_id + "").name;
					resChmName = handlers.chemicalRefHandler.finById(res.chem_id + "").name;
					resDisName = handlers.diseaseRefHandler.finById(res.disease_id + "").name;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("GET:" + res.medicament_id + " " + res.name);
				medResModel.setRowCount(0);
				medResModel.addRow(new Object[]{res.medicament_id, res.name, res.description, res.usual_dose, resGenName, resChmName, resDisName});
				medResTable.setVisible(true);
				medResModel.fireTableDataChanged();
			}
		});

		medResTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (medResTable.getSelectedRow() > -1) {
					medTextField_resID.setText(medResTable.getValueAt(medResTable.getSelectedRow(), 0).toString());
					medTextField_resName.setText(medResTable.getValueAt(medResTable.getSelectedRow(), 1).toString());
					medTextArea_resDesc.setText(medResTable.getValueAt(medResTable.getSelectedRow(), 2).toString());
					medTextField_resDose.setText(medResTable.getValueAt(medResTable.getSelectedRow(), 3).toString());
					medcomboBox_resGen.setSelectedItem(medResTable.getValueAt(medResTable.getSelectedRow(), 4));
					medcomboBox_resChm.setSelectedItem(medResTable.getValueAt(medResTable.getSelectedRow(), 5));
					medcomboBox_resDis.setSelectedItem(medResTable.getValueAt(medResTable.getSelectedRow(), 6));

				}
			}
		});

		medBtnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = medTextField_resID.getText();
				String name = medTextField_resName.getText();
				String description = medTextArea_resDesc.getText();
				String dose = medTextField_resDose.getText();
				GenericRefResponse gen = new GenericRefResponse(0, "", "");
				ChemicalRefResponse chm = new ChemicalRefResponse(0, "", "");
				DiseaseRefResponse dis = new DiseaseRefResponse(0, "", "");
				try {
					gen = handlers.genericRefHandler.finByName(medcomboBox_resGen.getSelectedItem().toString());
					chm = handlers.chemicalRefHandler.finByName(medcomboBox_resChm.getSelectedItem().toString());
					dis = handlers.diseaseRefHandler.finByName(medcomboBox_resDis.getSelectedItem().toString());
					handlers.medicamentRefHandler.updateMedicament(id, name, description, dose, gen.generic_id + "", chm.chemical_id + "", dis.disease_id + "");
					medTextField_resID.setText("");
					medTextField_resName.setText("");
					medTextArea_resDesc.setText("");
					medTextField_dose.setText("");
					medResModel.setRowCount(0);
					medTextField_idSearch.setText("");
					medTextField_nameSearch.setText("");
					medcomboBox_resGen.setSelectedIndex(0);
					medcomboBox_resChm.setSelectedIndex(0);
					medcomboBox_resDis.setSelectedIndex(0);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		frame.add(panelContainer);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ETRTDriver();
			}
		});
	}
}
