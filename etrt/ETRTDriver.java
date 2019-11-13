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
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ETRTDriver {
	private JFrame frame;
    private JPanel panelContainer;
    
    //main page
    private JPanel mainPanel;
    private JButton mainPatientsButton;
    private JButton mainVisitsButton;
    private JButton mainAnalyticsButton;
    private JButton mainOtherButton;
    
    //patients page
    private JPanel patientsPanel;
    private JButton patientsBack;
    private JButton patientsAddNew;
    private JButton patientsViewEdit;
    
    //add patients page
    private String newPatientID;
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
	
	//visits page
    private JPanel visitsPanel;
    private JButton visitsBack;
    private JButton visitsAddNew;
    private JButton visitsViewEdit;
    
    //add visits page
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
	private JButton avBtnSave;
	private JButton avBtnCancel;
	
	//other page
	private JPanel otherPanel;
	private JButton oBtnBack;

    public ETRTDriver() {
    	frame = new JFrame("CardLayout demo");
    	frame.setSize(600, 400);
    	
        //MAIN PAGE********************************************************************************************************************
    	mainPanel = new JPanel();
        mainPatientsButton = new JButton("Patients");
        mainVisitsButton = new JButton("Visits");
        mainAnalyticsButton = new JButton("Analytics");
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
        
        //PATIENTS PAGE********************************************************************************************************************
        patientsPanel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{140, 140, 20, 140, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 61, 100, 61, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_apBtnEditview = new GridBagConstraints();
		gbc_apBtnEditview.fill = GridBagConstraints.BOTH;
		gbc_apBtnEditview.insets = new Insets(0, 0, 5, 5);
		gbc_apBtnEditview.gridx = 3;
		gbc_apBtnEditview.gridy = 2;
		patientsPanel.add(patientsViewEdit, gbc_apBtnEditview);
		
        //VISITS PAGE********************************************************************************************************************
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
		GridBagConstraints gbc_vBtnEditview = new GridBagConstraints();
		gbc_vBtnEditview.fill = GridBagConstraints.BOTH;
		gbc_vBtnEditview.insets = new Insets(0, 0, 5, 5);
		gbc_vBtnEditview.gridx = 3;
		gbc_vBtnEditview.gridy = 2;
		visitsPanel.add(visitsViewEdit, gbc_vBtnEditview);
		
		//ADD VISITS PAGE********************************************************************************************************************
		addVisitPanel = new JPanel();
		GridBagLayout gbl_addVisitPanel = new GridBagLayout();
		gbl_addVisitPanel.columnWidths = new int[]{0, 160, 0, 100, 55, 50, 0};
		gbl_addVisitPanel.rowHeights = new int[]{0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_addVisitPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_addVisitPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addVisitPanel.setLayout(gbl_addVisitPanel);
		
		JLabel lblVisitId = new JLabel("Visit ID ");
		GridBagConstraints gbc_lblVisitId = new GridBagConstraints();
		gbc_lblVisitId.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisitId.anchor = GridBagConstraints.EAST;
		gbc_lblVisitId.gridx = 0;
		gbc_lblVisitId.gridy = 0;
		addVisitPanel.add(lblVisitId, gbc_lblVisitId);
		
		avTextField = new JTextField();
		GridBagConstraints gbc_avTextField = new GridBagConstraints();
		gbc_avTextField.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField.gridx = 1;
		gbc_avTextField.gridy = 0;
		addVisitPanel.add(avTextField, gbc_avTextField);
		avTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		addVisitPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		avTextField_1 = new JTextField();
		GridBagConstraints gbc_avTextField_1 = new GridBagConstraints();
		gbc_avTextField_1.gridwidth = 3;
		gbc_avTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_avTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_1.gridx = 3;
		gbc_avTextField_1.gridy = 0;
		addVisitPanel.add(avTextField_1, gbc_avTextField_1);
		avTextField_1.setColumns(10);
		
		JLabel lblPatient = new JLabel("Patient ");
		GridBagConstraints gbc_lblPatient = new GridBagConstraints();
		gbc_lblPatient.anchor = GridBagConstraints.EAST;
		gbc_lblPatient.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatient.gridx = 0;
		gbc_lblPatient.gridy = 1;
		addVisitPanel.add(lblPatient, gbc_lblPatient);
		
		avTextField_2 = new JTextField();
		GridBagConstraints gbc_avTextField_2 = new GridBagConstraints();
		gbc_avTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_2.gridx = 1;
		gbc_avTextField_2.gridy = 1;
		addVisitPanel.add(avTextField_2, gbc_avTextField_2);
		avTextField_2.setColumns(10);
		
		JLabel lblThc = new JLabel("THC# ");
		GridBagConstraints gbc_lblThc = new GridBagConstraints();
		gbc_lblThc.anchor = GridBagConstraints.EAST;
		gbc_lblThc.insets = new Insets(0, 0, 5, 5);
		gbc_lblThc.gridx = 2;
		gbc_lblThc.gridy = 1;
		addVisitPanel.add(lblThc, gbc_lblThc);
		
		avTextField_4 = new JTextField();
		GridBagConstraints gbc_avTextField_4 = new GridBagConstraints();
		gbc_avTextField_4.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_4.gridx = 3;
		gbc_avTextField_4.gridy = 1;
		addVisitPanel.add(avTextField_4, gbc_avTextField_4);
		avTextField_4.setColumns(10);
		
		JLabel lblVisitNo = new JLabel("Visit no. ");
		GridBagConstraints gbc_lblVisitNo = new GridBagConstraints();
		gbc_lblVisitNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisitNo.anchor = GridBagConstraints.EAST;
		gbc_lblVisitNo.gridx = 4;
		gbc_lblVisitNo.gridy = 1;
		addVisitPanel.add(lblVisitNo, gbc_lblVisitNo);
		
		avTextField_3 = new JTextField();
		GridBagConstraints gbc_avTextField_3 = new GridBagConstraints();
		gbc_avTextField_3.insets = new Insets(0, 0, 5, 0);
		gbc_avTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_3.gridx = 5;
		gbc_avTextField_3.gridy = 1;
		addVisitPanel.add(avTextField_3, gbc_avTextField_3);
		avTextField_3.setColumns(10);
		
		JPanel avSecondGroup = new JPanel();
		GridBagConstraints gbc_avSecondGroup = new GridBagConstraints();
		gbc_avSecondGroup.gridwidth = 6;
		gbc_avSecondGroup.insets = new Insets(0, 0, 5, 0);
		gbc_avSecondGroup.fill = GridBagConstraints.BOTH;
		gbc_avSecondGroup.gridx = 0;
		gbc_avSecondGroup.gridy = 2;
		addVisitPanel.add(avSecondGroup, gbc_avSecondGroup);
		avSecondGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton avBtnInterview = new JButton("Interview");
		avSecondGroup.add(avBtnInterview);
		
		JButton avBtnAudiology = new JButton("Audiology");
		avSecondGroup.add(avBtnAudiology);
		
		JButton avBtnMedical = new JButton("Medical Other");
		avSecondGroup.add(avBtnMedical);
		
		JButton avBtnDiagnose = new JButton("Diagnose");
		avSecondGroup.add(avBtnDiagnose);
		
		JLabel lblNewLabel_1 = new JLabel("Problem ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		addVisitPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		avTextField_5 = new JTextField();
		GridBagConstraints gbc_avTextField_5 = new GridBagConstraints();
		gbc_avTextField_5.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_5.gridx = 1;
		gbc_avTextField_5.gridy = 3;
		addVisitPanel.add(avTextField_5, gbc_avTextField_5);
		avTextField_5.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category ");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.EAST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 2;
		gbc_lblCategory.gridy = 3;
		addVisitPanel.add(lblCategory, gbc_lblCategory);
		
		avTextField_6 = new JTextField();
		GridBagConstraints gbc_avTextField_6 = new GridBagConstraints();
		gbc_avTextField_6.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_6.gridx = 3;
		gbc_avTextField_6.gridy = 3;
		addVisitPanel.add(avTextField_6, gbc_avTextField_6);
		avTextField_6.setColumns(10);
		
		JLabel lblProtocol = new JLabel("Protocol ");
		GridBagConstraints gbc_lblProtocol = new GridBagConstraints();
		gbc_lblProtocol.anchor = GridBagConstraints.EAST;
		gbc_lblProtocol.insets = new Insets(0, 0, 5, 5);
		gbc_lblProtocol.gridx = 0;
		gbc_lblProtocol.gridy = 4;
		addVisitPanel.add(lblProtocol, gbc_lblProtocol);
		
		avTextField_7 = new JTextField();
		GridBagConstraints gbc_avTextField_7 = new GridBagConstraints();
		gbc_avTextField_7.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_7.gridx = 1;
		gbc_avTextField_7.gridy = 4;
		addVisitPanel.add(avTextField_7, gbc_avTextField_7);
		avTextField_7.setColumns(10);
		
		JLabel lblFu = new JLabel("FU ");
		GridBagConstraints gbc_lblFu = new GridBagConstraints();
		gbc_lblFu.anchor = GridBagConstraints.EAST;
		gbc_lblFu.insets = new Insets(0, 0, 5, 5);
		gbc_lblFu.gridx = 2;
		gbc_lblFu.gridy = 4;
		addVisitPanel.add(lblFu, gbc_lblFu);
		
		avTextField_8 = new JTextField();
		GridBagConstraints gbc_avTextField_8 = new GridBagConstraints();
		gbc_avTextField_8.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_8.gridx = 3;
		gbc_avTextField_8.gridy = 4;
		addVisitPanel.add(avTextField_8, gbc_avTextField_8);
		avTextField_8.setColumns(10);
		
		JLabel lblInstrument = new JLabel("Instrument ");
		GridBagConstraints gbc_lblInstrument = new GridBagConstraints();
		gbc_lblInstrument.anchor = GridBagConstraints.EAST;
		gbc_lblInstrument.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstrument.gridx = 0;
		gbc_lblInstrument.gridy = 5;
		addVisitPanel.add(lblInstrument, gbc_lblInstrument);
		
		avTextField_9 = new JTextField();
		GridBagConstraints gbc_avTextField_9 = new GridBagConstraints();
		gbc_avTextField_9.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_9.gridx = 1;
		gbc_avTextField_9.gridy = 5;
		addVisitPanel.add(avTextField_9, gbc_avTextField_9);
		avTextField_9.setColumns(10);
		
		JLabel lblRem = new JLabel("REM ");
		GridBagConstraints gbc_lblRem = new GridBagConstraints();
		gbc_lblRem.anchor = GridBagConstraints.EAST;
		gbc_lblRem.insets = new Insets(0, 0, 5, 5);
		gbc_lblRem.gridx = 2;
		gbc_lblRem.gridy = 5;
		addVisitPanel.add(lblRem, gbc_lblRem);
		
		JCheckBox avChckbxREM = new JCheckBox("");
		GridBagConstraints gbc_avChckbxREM = new GridBagConstraints();
		gbc_avChckbxREM.anchor = GridBagConstraints.WEST;
		gbc_avChckbxREM.insets = new Insets(0, 0, 5, 5);
		gbc_avChckbxREM.gridx = 3;
		gbc_avChckbxREM.gridy = 5;
		addVisitPanel.add(avChckbxREM, gbc_avChckbxREM);
		
		JLabel lblComments = new JLabel("Comments ");
		GridBagConstraints gbc_lblComments = new GridBagConstraints();
		gbc_lblComments.anchor = GridBagConstraints.EAST;
		gbc_lblComments.insets = new Insets(0, 0, 5, 5);
		gbc_lblComments.gridx = 0;
		gbc_lblComments.gridy = 6;
		addVisitPanel.add(lblComments, gbc_lblComments);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		addVisitPanel.add(scrollPane, gbc_scrollPane);
		
		JTextArea avTextAreaComments = new JTextArea();
		scrollPane.setViewportView(avTextAreaComments);
		
		JLabel lblNextVisit = new JLabel("Next Visit ");
		GridBagConstraints gbc_lblNextVisit = new GridBagConstraints();
		gbc_lblNextVisit.anchor = GridBagConstraints.EAST;
		gbc_lblNextVisit.insets = new Insets(0, 0, 5, 5);
		gbc_lblNextVisit.gridx = 0;
		gbc_lblNextVisit.gridy = 7;
		addVisitPanel.add(lblNextVisit, gbc_lblNextVisit);
		
		avTextField_10 = new JTextField();
		GridBagConstraints gbc_avTextField_10 = new GridBagConstraints();
		gbc_avTextField_10.insets = new Insets(0, 0, 5, 5);
		gbc_avTextField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_avTextField_10.gridx = 1;
		gbc_avTextField_10.gridy = 7;
		addVisitPanel.add(avTextField_10, gbc_avTextField_10);
		avTextField_10.setColumns(10);
		
		JPanel avFourthGroup = new JPanel();
		GridBagConstraints gbc_avFourthGroup = new GridBagConstraints();
		gbc_avFourthGroup.insets = new Insets(0, 0, 5, 0);
		gbc_avFourthGroup.gridwidth = 6;
		gbc_avFourthGroup.fill = GridBagConstraints.BOTH;
		gbc_avFourthGroup.gridx = 0;
		gbc_avFourthGroup.gridy = 8;
		addVisitPanel.add(avFourthGroup, gbc_avFourthGroup);
		avFourthGroup.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton avBtnInstrumentDetails = new JButton("Instrument Details");
		avFourthGroup.add(avBtnInstrumentDetails);
		
		JButton avBtnRemDetails = new JButton("REM Details");
		avFourthGroup.add(avBtnRemDetails);
		
		JButton avBtnCounselingDetails = new JButton("Counseling Details");
		avFourthGroup.add(avBtnCounselingDetails);
		
		JButton avBtnRecommendTreatment = new JButton("Recommend Treatment");
		avFourthGroup.add(avBtnRecommendTreatment);
		
		avBtnSave = new JButton("Save");
		GridBagConstraints gbc_avBtnSave = new GridBagConstraints();
		gbc_avBtnSave.insets = new Insets(0, 0, 0, 5);
		gbc_avBtnSave.gridx = 4;
		gbc_avBtnSave.gridy = 9;
		addVisitPanel.add(avBtnSave, gbc_avBtnSave);
		
		avBtnCancel = new JButton("Cancel");
		GridBagConstraints gbc_avBtnCancel = new GridBagConstraints();
		gbc_avBtnCancel.gridx = 5;
		gbc_avBtnCancel.gridy = 9;
		addVisitPanel.add(avBtnCancel, gbc_avBtnCancel);
		addVisitPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
        //ADD PATIENTS PAGE********************************************************************************************************************
        addPatientPanel = new JPanel();
		GridBagLayout gbl_addPatientPanel = new GridBagLayout();
		gbl_addPatientPanel.columnWidths = new int[]{0, 0, 87, 90, 0, 0};
		gbl_addPatientPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_addPatientPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_addPatientPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addPatientPanel.setLayout(gbl_addPatientPanel);
		
		apLblThi = new JLabel("THC ");
		GridBagConstraints gbc_apLblThi = new GridBagConstraints();
		gbc_apLblThi.anchor = GridBagConstraints.EAST;
		gbc_apLblThi.insets = new Insets(0, 0, 5, 5);
		gbc_apLblThi.gridx = 0;
		gbc_apLblThi.gridy = 0;
		addPatientPanel.add(apLblThi, gbc_apLblThi);
		
		apTxtUuidHere = new JTextField();
		newPatientID = UUID.randomUUID().toString();	//NEED TO REPLACE TO DB AUTOFILL
		apTxtUuidHere.setText(newPatientID);
		apTxtUuidHere.setEditable(false);
		GridBagConstraints gbc_txtUuidHere = new GridBagConstraints();
		gbc_txtUuidHere.gridwidth = 4;
		gbc_txtUuidHere.insets = new Insets(0, 0, 5, 0);
		gbc_txtUuidHere.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUuidHere.gridx = 1;
		gbc_txtUuidHere.gridy = 0;
		addPatientPanel.add(apTxtUuidHere, gbc_txtUuidHere);
		apTxtUuidHere.setColumns(10);
		
		apLblFirstName = new JLabel("Last Name ");
		GridBagConstraints gbc_apLblFirstName = new GridBagConstraints();
		gbc_apLblFirstName.anchor = GridBagConstraints.EAST;
		gbc_apLblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_apLblFirstName.gridx = 0;
		gbc_apLblFirstName.gridy = 1;
		addPatientPanel.add(apLblFirstName, gbc_apLblFirstName);
		
		apTextField_1 = new JTextField();
		GridBagConstraints gbc_apTextField_1 = new GridBagConstraints();
		gbc_apTextField_1.gridwidth = 4;
		gbc_apTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_1.gridx = 1;
		gbc_apTextField_1.gridy = 1;
		addPatientPanel.add(apTextField_1, gbc_apTextField_1);
		apTextField_1.setColumns(10);
		
		apLblFirstName_1 = new JLabel("First Name ");
		GridBagConstraints gbc_apLblFirstName_1 = new GridBagConstraints();
		gbc_apLblFirstName_1.anchor = GridBagConstraints.EAST;
		gbc_apLblFirstName_1.insets = new Insets(0, 0, 5, 5);
		gbc_apLblFirstName_1.gridx = 0;
		gbc_apLblFirstName_1.gridy = 2;
		addPatientPanel.add(apLblFirstName_1, gbc_apLblFirstName_1);
		
		apTextField_2 = new JTextField();
		GridBagConstraints gbc_apTextField_2 = new GridBagConstraints();
		gbc_apTextField_2.gridwidth = 4;
		gbc_apTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_2.gridx = 1;
		gbc_apTextField_2.gridy = 2;
		addPatientPanel.add(apTextField_2, gbc_apTextField_2);
		apTextField_2.setColumns(10);
		
		apLblMiddleName = new JLabel("Middle Name ");
		GridBagConstraints gbc_apLblMiddleName = new GridBagConstraints();
		gbc_apLblMiddleName.anchor = GridBagConstraints.EAST;
		gbc_apLblMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_apLblMiddleName.gridx = 0;
		gbc_apLblMiddleName.gridy = 3;
		addPatientPanel.add(apLblMiddleName, gbc_apLblMiddleName);
		
		apTextField_3 = new JTextField();
		GridBagConstraints gbc_apTextField_3 = new GridBagConstraints();
		gbc_apTextField_3.gridwidth = 4;
		gbc_apTextField_3.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_3.gridx = 1;
		gbc_apTextField_3.gridy = 3;
		addPatientPanel.add(apTextField_3, gbc_apTextField_3);
		apTextField_3.setColumns(10);
		
		apLblDateOfBirth = new JLabel("Date of Birth ");
		GridBagConstraints gbc_apLblDateOfBirth = new GridBagConstraints();
		gbc_apLblDateOfBirth.anchor = GridBagConstraints.EAST;
		gbc_apLblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_apLblDateOfBirth.gridx = 0;
		gbc_apLblDateOfBirth.gridy = 4;
		addPatientPanel.add(apLblDateOfBirth, gbc_apLblDateOfBirth);
		
		apTextField_4 = new JTextField();
		GridBagConstraints gbc_apTextField_4 = new GridBagConstraints();
		gbc_apTextField_4.gridwidth = 4;
		gbc_apTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_4.gridx = 1;
		gbc_apTextField_4.gridy = 4;
		addPatientPanel.add(apTextField_4, gbc_apTextField_4);
		apTextField_4.setColumns(10);
		
		apLblSsn = new JLabel("SSN ");
		GridBagConstraints gbc_apLblSsn = new GridBagConstraints();
		gbc_apLblSsn.anchor = GridBagConstraints.EAST;
		gbc_apLblSsn.insets = new Insets(0, 0, 5, 5);
		gbc_apLblSsn.gridx = 0;
		gbc_apLblSsn.gridy = 5;
		addPatientPanel.add(apLblSsn, gbc_apLblSsn);
		
		apTextField_5 = new JTextField();
		GridBagConstraints gbc_apTextField_5 = new GridBagConstraints();
		gbc_apTextField_5.gridwidth = 4;
		gbc_apTextField_5.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_5.gridx = 1;
		gbc_apTextField_5.gridy = 5;
		addPatientPanel.add(apTextField_5, gbc_apTextField_5);
		apTextField_5.setColumns(10);
		
		apLblInsurance = new JLabel("Insurance ");
		GridBagConstraints gbc_apLblInsurance = new GridBagConstraints();
		gbc_apLblInsurance.anchor = GridBagConstraints.EAST;
		gbc_apLblInsurance.insets = new Insets(0, 0, 5, 5);
		gbc_apLblInsurance.gridx = 0;
		gbc_apLblInsurance.gridy = 6;
		addPatientPanel.add(apLblInsurance, gbc_apLblInsurance);
		
		apTextField_6 = new JTextField();
		GridBagConstraints gbc_apTextField_6 = new GridBagConstraints();
		gbc_apTextField_6.gridwidth = 4;
		gbc_apTextField_6.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_6.gridx = 1;
		gbc_apTextField_6.gridy = 6;
		addPatientPanel.add(apTextField_6, gbc_apTextField_6);
		apTextField_6.setColumns(10);
		
		apBtnSave = new JButton("Save");
		GridBagConstraints gbc_apBtnSave = new GridBagConstraints();
		gbc_apBtnSave.anchor = GridBagConstraints.EAST;
		gbc_apBtnSave.insets = new Insets(0, 0, 0, 5);
		gbc_apBtnSave.gridx = 2;
		gbc_apBtnSave.gridy = 7;
		addPatientPanel.add(apBtnSave, gbc_apBtnSave);
		
		apBtnAddVisit = new JButton("Add Visit");
		GridBagConstraints gbc_apBtnAddVisit = new GridBagConstraints();
		gbc_apBtnAddVisit.insets = new Insets(0, 0, 0, 5);
		gbc_apBtnAddVisit.gridx = 3;
		gbc_apBtnAddVisit.gridy = 7;
		addPatientPanel.add(apBtnAddVisit, gbc_apBtnAddVisit);
		
		apBtnCancel = new JButton("Cancel");
		GridBagConstraints gbc_apBtnCanel = new GridBagConstraints();
		gbc_apBtnCanel.anchor = GridBagConstraints.WEST;
		gbc_apBtnCanel.gridx = 4;
		gbc_apBtnCanel.gridy = 7;
		addPatientPanel.add(apBtnCancel, gbc_apBtnCanel);
		addPatientPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//OTHER PAGE********************************************************************************************************************
		otherPanel = new JPanel();
		GridBagLayout gbl_otherPanel = new GridBagLayout();
		gbl_otherPanel.columnWidths = new int[]{0, 0, 220, 220, 50, 0};
		gbl_otherPanel.rowHeights = new int[]{0, 50, 0, 0, 0, 50, 0};
		gbl_otherPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_otherPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		otherPanel.setLayout(gbl_otherPanel);
		
		oBtnBack = new JButton("Back");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		otherPanel.add(oBtnBack, gbc_button);
		
		JButton btnNewButton = new JButton("Location Data");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		otherPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnDemographicsData = new JButton("Demographics Data");
		GridBagConstraints gbc_btnDemographicsData = new GridBagConstraints();
		gbc_btnDemographicsData.fill = GridBagConstraints.BOTH;
		gbc_btnDemographicsData.insets = new Insets(0, 0, 5, 5);
		gbc_btnDemographicsData.gridx = 3;
		gbc_btnDemographicsData.gridy = 2;
		otherPanel.add(btnDemographicsData, gbc_btnDemographicsData);
		
		JButton btnNewButton_1 = new JButton("Medical Data");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 3;
		otherPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnPharmacologyData = new JButton("Pharmacology Data");
		GridBagConstraints gbc_btnPharmacologyData = new GridBagConstraints();
		gbc_btnPharmacologyData.fill = GridBagConstraints.BOTH;
		gbc_btnPharmacologyData.insets = new Insets(0, 0, 5, 5);
		gbc_btnPharmacologyData.gridx = 3;
		gbc_btnPharmacologyData.gridy = 3;
		otherPanel.add(btnPharmacologyData, gbc_btnPharmacologyData);
		
		JButton btnInstruments = new JButton("Instruments");
		GridBagConstraints gbc_btnInstruments = new GridBagConstraints();
		gbc_btnInstruments.fill = GridBagConstraints.BOTH;
		gbc_btnInstruments.insets = new Insets(0, 0, 5, 0);
		gbc_btnInstruments.gridwidth = 2;
		gbc_btnInstruments.gridx = 2;
		gbc_btnInstruments.gridy = 4;
		otherPanel.add(btnInstruments, gbc_btnInstruments);
		
		//add views********************************************************************************************************************
		panelContainer = new JPanel();
		CardLayout cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);
        panelContainer.add(mainPanel, "main");
        panelContainer.add(patientsPanel, "patients");
        panelContainer.add(addPatientPanel, "addPatients");
        panelContainer.add(visitsPanel, "visits");
        panelContainer.add(addVisitPanel, "addVisits");
        panelContainer.add(otherPanel, "other");
        
        cardLayout.show(panelContainer, "main");
		
		//switch view********************************************************************************************************************
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

        patientsBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "main");
            }
        });
        
        patientsAddNew.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) {
        		newPatientID = UUID.randomUUID().toString();	//NEED TO REPLACE WITH DB AUTOFILL
        		apTxtUuidHere.setText(newPatientID);
                cardLayout.show(panelContainer, "addPatients");
            }
        });
        
        apBtnCancel.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "main");
            }
        });

        avBtnCancel.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "main");
            }
        });
        
        oBtnBack.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "main");
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
