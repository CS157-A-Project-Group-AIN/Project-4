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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
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
	private JButton oBtnPharmData;
	
	//pharmacology data page
	private JPanel pharmDataPanel;
	private JButton pdBtnBack;
	private JButton pdBtnAEChemical;
	private JButton pdBtnAEGeneric; 
	private JButton pdBtnAEDisease; 
	private JButton pdBtnAEMedication; 
	
	//Add/Edit Chemicals page
	private JPanel aeChemDataPanel;
	private JTextField chmTextField;
	private JTextField chmTextField_1;
	private JTextField chmTextField_2;
	private JTextField chmTextField_3;
	private JTextField chmTextField_4;
	private JTextField chmTextField_5;
	private JTable chmResTable;
	private JButton chmBtnBack;
	
	//Add/Edit Generics page
	private JPanel aeGenDataPanel;
	private JTextField genTextField;
	private JTextField genTextField_1;
	private JTextField genTextField_2;
	private JTextField genTextField_3;
	private JTextField genTextField_4;
	private JTextField genTextField_5;
	private JTable genResTable;
	private JButton genBtnBack;
	
	//Add/Edit Disease page
	private JPanel aeDisDataPanel;
	private JTextField disTextField;
	private JTextField disTextField_1;
	private JTextField disTextField_2;
	private JTextField disTextField_3;
	private JTextField disTextField_4;
	private JTextField disTextField_5;
	private JTable disResTable;
	private JButton disBtnBack;

    public ETRTDriver() {
    	frame = new JFrame("CardLayout demo");
    	frame.setSize(600, 400);
    	
        //MAIN PAGE********************************************************************************************************************
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
		patientsViewEdit.setEnabled(false);
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
		visitsViewEdit.setEnabled(false);
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
		avBtnInterview.setEnabled(false);
		avSecondGroup.add(avBtnInterview);
		
		JButton avBtnAudiology = new JButton("Audiology");
		avSecondGroup.add(avBtnAudiology);
		
		JButton avBtnMedical = new JButton("Pharmocology");
		avSecondGroup.add(avBtnMedical);
		
		JButton avBtnDiagnose = new JButton("Diagnose");
		avBtnDiagnose.setEnabled(false);
		avSecondGroup.add(avBtnDiagnose);
		
		JLabel lblNewLabel_1 = new JLabel("Problem ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		addVisitPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		avTextField_5 = new JTextField();
		avTextField_5.setEditable(false);
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
		avTextField_6.setEditable(false);
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
		avTextField_7.setEditable(false);
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
		avTextField_8.setEditable(false);
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
		avTextField_9.setEditable(false);
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
		avChckbxREM.setEnabled(false);
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
		avTextAreaComments.setEditable(false);
		scrollPane.setViewportView(avTextAreaComments);
		
		JLabel lblNextVisit = new JLabel("Next Visit ");
		GridBagConstraints gbc_lblNextVisit = new GridBagConstraints();
		gbc_lblNextVisit.anchor = GridBagConstraints.EAST;
		gbc_lblNextVisit.insets = new Insets(0, 0, 5, 5);
		gbc_lblNextVisit.gridx = 0;
		gbc_lblNextVisit.gridy = 7;
		addVisitPanel.add(lblNextVisit, gbc_lblNextVisit);
		
		avTextField_10 = new JTextField();
		avTextField_10.setEditable(false);
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
		apTextField_1.setEditable(false);
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
		apTextField_2.setEditable(false);
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
		apTextField_3.setEditable(false);
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
		apTextField_4.setEditable(false);
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
		apTextField_5.setEditable(false);
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
		apTextField_6.setEditable(false);
		GridBagConstraints gbc_apTextField_6 = new GridBagConstraints();
		gbc_apTextField_6.gridwidth = 4;
		gbc_apTextField_6.insets = new Insets(0, 0, 5, 0);
		gbc_apTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_apTextField_6.gridx = 1;
		gbc_apTextField_6.gridy = 6;
		addPatientPanel.add(apTextField_6, gbc_apTextField_6);
		apTextField_6.setColumns(10);
		
		apBtnSave = new JButton("Save");
		apBtnSave.setEnabled(false);
		GridBagConstraints gbc_apBtnSave = new GridBagConstraints();
		gbc_apBtnSave.anchor = GridBagConstraints.EAST;
		gbc_apBtnSave.insets = new Insets(0, 0, 0, 5);
		gbc_apBtnSave.gridx = 2;
		gbc_apBtnSave.gridy = 7;
		addPatientPanel.add(apBtnSave, gbc_apBtnSave);
		
		apBtnAddVisit = new JButton("Add Visit");
		apBtnAddVisit.setEnabled(false);
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
		
		//PHARMACOLOGY DATA PAGE********************************************************************************************************************
		pharmDataPanel = new JPanel();
		GridBagLayout gbl_pharmDataPanel = new GridBagLayout();
		gbl_pharmDataPanel.columnWidths = new int[]{0, 0, 220, 220, 50, 0};
		gbl_pharmDataPanel.rowHeights = new int[]{0, 50, 0, 0, 50, 0};
		gbl_pharmDataPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pharmDataPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
		//CHEMICAL ADD/EDIT PAGE********************************************************************************************************************
		aeChemDataPanel = new JPanel();
		GridBagLayout gbl_aeChemDataPanel = new GridBagLayout();
		gbl_aeChemDataPanel.columnWidths = new int[]{0, 0};
		gbl_aeChemDataPanel.rowHeights = new int[]{0, 0, 0};
		gbl_aeChemDataPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_aeChemDataPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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
		gbl_addChemPanel.columnWidths = new int[]{0, 0, 0};
		gbl_addChemPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_addChemPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_addChemPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		addChemPanel.setLayout(gbl_addChemPanel);
		
		JLabel chmlblId = new JLabel("ID ");
		GridBagConstraints gbc_chmlblId = new GridBagConstraints();
		gbc_chmlblId.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblId.anchor = GridBagConstraints.EAST;
		gbc_chmlblId.gridx = 0;
		gbc_chmlblId.gridy = 0;
		addChemPanel.add(chmlblId, gbc_chmlblId);
		
		chmTextField = new JTextField();
		GridBagConstraints gbc_chmTextField = new GridBagConstraints();
		gbc_chmTextField.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField.gridx = 1;
		gbc_chmTextField.gridy = 0;
		addChemPanel.add(chmTextField, gbc_chmTextField);
		chmTextField.setColumns(10);
		
		JLabel chmlblName = new JLabel("Name ");
		GridBagConstraints gbc_chmlblName = new GridBagConstraints();
		gbc_chmlblName.anchor = GridBagConstraints.EAST;
		gbc_chmlblName.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblName.gridx = 0;
		gbc_chmlblName.gridy = 1;
		addChemPanel.add(chmlblName, gbc_chmlblName);
		
		chmTextField_1 = new JTextField();
		GridBagConstraints gbc_chmTextField_1 = new GridBagConstraints();
		gbc_chmTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_1.gridx = 1;
		gbc_chmTextField_1.gridy = 1;
		addChemPanel.add(chmTextField_1, gbc_chmTextField_1);
		chmTextField_1.setColumns(10);
		
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
		
		JTextArea textArea = new JTextArea();
		chmscrollPane.setViewportView(textArea);
		
		JButton chmBtnAdd = new JButton("Add");
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
		gbl_editChemPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_editChemPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_editChemPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_editChemPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		editChemPanel.setLayout(gbl_editChemPanel);
		
		JLabel chmlblId_1 = new JLabel("ID ");
		GridBagConstraints gbc_chmlblId_1 = new GridBagConstraints();
		gbc_chmlblId_1.anchor = GridBagConstraints.EAST;
		gbc_chmlblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblId_1.gridx = 0;
		gbc_chmlblId_1.gridy = 0;
		editChemPanel.add(chmlblId_1, gbc_chmlblId_1);
		
		chmTextField_3 = new JTextField();
		GridBagConstraints gbc_chmTextField_3 = new GridBagConstraints();
		gbc_chmTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_chmTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_3.gridx = 1;
		gbc_chmTextField_3.gridy = 0;
		editChemPanel.add(chmTextField_3, gbc_chmTextField_3);
		chmTextField_3.setColumns(10);
		
		JLabel chmlblName_1 = new JLabel("Name");
		GridBagConstraints gbc_chmlblName_1 = new GridBagConstraints();
		gbc_chmlblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblName_1.anchor = GridBagConstraints.EAST;
		gbc_chmlblName_1.gridx = 2;
		gbc_chmlblName_1.gridy = 0;
		editChemPanel.add(chmlblName_1, gbc_chmlblName_1);
		
		chmTextField_2 = new JTextField();
		GridBagConstraints gbc_chmTextField_2 = new GridBagConstraints();
		gbc_chmTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_2.gridx = 3;
		gbc_chmTextField_2.gridy = 0;
		editChemPanel.add(chmTextField_2, gbc_chmTextField_2);
		chmTextField_2.setColumns(10);
		
		JButton chmBtnSearch = new JButton("Search");
		GridBagConstraints gbc_chmBtnSearch = new GridBagConstraints();
		gbc_chmBtnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_chmBtnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmBtnSearch.gridwidth = 3;
		gbc_chmBtnSearch.gridx = 1;
		gbc_chmBtnSearch.gridy = 1;
		editChemPanel.add(chmBtnSearch, gbc_chmBtnSearch);
		
		JScrollPane chmscrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_chmscrollPane_2 = new GridBagConstraints();
		gbc_chmscrollPane_2.gridwidth = 3;
		gbc_chmscrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_chmscrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_chmscrollPane_2.gridx = 1;
		gbc_chmscrollPane_2.gridy = 2;
		editChemPanel.add(chmscrollPane_2, gbc_chmscrollPane_2);
		
		//RESULT TABLE HERE***************************
		chmResTable = new JTable();
		chmResTable.setFillsViewportHeight(true);
		chmscrollPane_2.setViewportView(chmResTable);
		
		JLabel chmlblId_2 = new JLabel("ID ");
		GridBagConstraints gbc_chmlblId_2 = new GridBagConstraints();
		gbc_chmlblId_2.anchor = GridBagConstraints.EAST;
		gbc_chmlblId_2.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblId_2.gridx = 0;
		gbc_chmlblId_2.gridy = 3;
		editChemPanel.add(chmlblId_2, gbc_chmlblId_2);
		
		chmTextField_4 = new JTextField();
		GridBagConstraints gbc_chmTextField_4 = new GridBagConstraints();
		gbc_chmTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField_4.gridwidth = 3;
		gbc_chmTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_4.gridx = 1;
		gbc_chmTextField_4.gridy = 3;
		editChemPanel.add(chmTextField_4, gbc_chmTextField_4);
		chmTextField_4.setColumns(10);
		
		JLabel chmlblName_2 = new JLabel("Name ");
		GridBagConstraints gbc_chmlblName_2 = new GridBagConstraints();
		gbc_chmlblName_2.anchor = GridBagConstraints.EAST;
		gbc_chmlblName_2.insets = new Insets(0, 0, 5, 5);
		gbc_chmlblName_2.gridx = 0;
		gbc_chmlblName_2.gridy = 4;
		editChemPanel.add(chmlblName_2, gbc_chmlblName_2);
		
		chmTextField_5 = new JTextField();
		GridBagConstraints gbc_chmTextField_5 = new GridBagConstraints();
		gbc_chmTextField_5.insets = new Insets(0, 0, 5, 0);
		gbc_chmTextField_5.gridwidth = 3;
		gbc_chmTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmTextField_5.gridx = 1;
		gbc_chmTextField_5.gridy = 4;
		editChemPanel.add(chmTextField_5, gbc_chmTextField_5);
		chmTextField_5.setColumns(10);
		
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
		
		JTextArea textArea_1 = new JTextArea();
		chmscrollPane_1.setViewportView(textArea_1);
		
		JButton chmBtnSubmit = new JButton("Submit");
		GridBagConstraints gbc_chmBtnSubmit = new GridBagConstraints();
		gbc_chmBtnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_chmBtnSubmit.gridwidth = 4;
		gbc_chmBtnSubmit.gridx = 0;
		gbc_chmBtnSubmit.gridy = 6;
		editChemPanel.add(chmBtnSubmit, gbc_chmBtnSubmit);
		
		
		//GENERIC ADD/EDIT PAGE********************************************************************************************************************
		aeGenDataPanel = new JPanel();
		GridBagLayout gbl_aeGenDataPanel = new GridBagLayout();
		gbl_aeGenDataPanel.columnWidths = new int[]{0, 0};
		gbl_aeGenDataPanel.rowHeights = new int[]{0, 0, 0};
		gbl_aeGenDataPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_aeGenDataPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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
		gbl_addgenPanel.columnWidths = new int[]{0, 0, 0};
		gbl_addgenPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_addgenPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_addgenPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		addgenPanel.setLayout(gbl_addgenPanel);
		
		JLabel genlblId = new JLabel("ID ");
		GridBagConstraints gbc_genlblId = new GridBagConstraints();
		gbc_genlblId.insets = new Insets(0, 0, 5, 5);
		gbc_genlblId.anchor = GridBagConstraints.EAST;
		gbc_genlblId.gridx = 0;
		gbc_genlblId.gridy = 0;
		addgenPanel.add(genlblId, gbc_genlblId);
		
		genTextField = new JTextField();
		GridBagConstraints gbc_genTextField = new GridBagConstraints();
		gbc_genTextField.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField.gridx = 1;
		gbc_genTextField.gridy = 0;
		addgenPanel.add(genTextField, gbc_genTextField);
		genTextField.setColumns(10);
		
		JLabel genlblName = new JLabel("Name ");
		GridBagConstraints gbc_genlblName = new GridBagConstraints();
		gbc_genlblName.anchor = GridBagConstraints.EAST;
		gbc_genlblName.insets = new Insets(0, 0, 5, 5);
		gbc_genlblName.gridx = 0;
		gbc_genlblName.gridy = 1;
		addgenPanel.add(genlblName, gbc_genlblName);
		
		genTextField_1 = new JTextField();
		GridBagConstraints gbc_genTextField_1 = new GridBagConstraints();
		gbc_genTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_1.gridx = 1;
		gbc_genTextField_1.gridy = 1;
		addgenPanel.add(genTextField_1, gbc_genTextField_1);
		genTextField_1.setColumns(10);
		
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
		
		JTextArea gentextArea = new JTextArea();
		genscrollPane.setViewportView(gentextArea);
		
		JButton genBtnAdd = new JButton("Add");
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
		gbl_editgenPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_editgenPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_editgenPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_editgenPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		editgenPanel.setLayout(gbl_editgenPanel);
		
		JLabel genlblId_1 = new JLabel("ID ");
		GridBagConstraints gbc_genlblId_1 = new GridBagConstraints();
		gbc_genlblId_1.anchor = GridBagConstraints.EAST;
		gbc_genlblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_genlblId_1.gridx = 0;
		gbc_genlblId_1.gridy = 0;
		editgenPanel.add(genlblId_1, gbc_genlblId_1);
		
		genTextField_3 = new JTextField();
		GridBagConstraints gbc_genTextField_3 = new GridBagConstraints();
		gbc_genTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_genTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_3.gridx = 1;
		gbc_genTextField_3.gridy = 0;
		editgenPanel.add(genTextField_3, gbc_genTextField_3);
		genTextField_3.setColumns(10);
		
		JLabel genlblName_1 = new JLabel("Name");
		GridBagConstraints gbc_genlblName_1 = new GridBagConstraints();
		gbc_genlblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_genlblName_1.anchor = GridBagConstraints.EAST;
		gbc_genlblName_1.gridx = 2;
		gbc_genlblName_1.gridy = 0;
		editgenPanel.add(genlblName_1, gbc_genlblName_1);
		
		genTextField_2 = new JTextField();
		GridBagConstraints gbc_genTextField_2 = new GridBagConstraints();
		gbc_genTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_2.gridx = 3;
		gbc_genTextField_2.gridy = 0;
		editgenPanel.add(genTextField_2, gbc_genTextField_2);
		genTextField_2.setColumns(10);
		
		JButton genBtnSearch = new JButton("Search");
		GridBagConstraints gbc_genBtnSearch = new GridBagConstraints();
		gbc_genBtnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_genBtnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_genBtnSearch.gridwidth = 3;
		gbc_genBtnSearch.gridx = 1;
		gbc_genBtnSearch.gridy = 1;
		editgenPanel.add(genBtnSearch, gbc_genBtnSearch);
		
		JScrollPane genscrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_genscrollPane_2 = new GridBagConstraints();
		gbc_genscrollPane_2.gridwidth = 3;
		gbc_genscrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_genscrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_genscrollPane_2.gridx = 1;
		gbc_genscrollPane_2.gridy = 2;
		editgenPanel.add(genscrollPane_2, gbc_genscrollPane_2);
		
		//RESULT TABLE HERE***************************
		genResTable = new JTable();
		genResTable.setFillsViewportHeight(true);
		genscrollPane_2.setViewportView(genResTable);
		
		JLabel genlblId_2 = new JLabel("ID ");
		GridBagConstraints gbc_genlblId_2 = new GridBagConstraints();
		gbc_genlblId_2.anchor = GridBagConstraints.EAST;
		gbc_genlblId_2.insets = new Insets(0, 0, 5, 5);
		gbc_genlblId_2.gridx = 0;
		gbc_genlblId_2.gridy = 3;
		editgenPanel.add(genlblId_2, gbc_genlblId_2);
		
		genTextField_4 = new JTextField();
		GridBagConstraints gbc_genTextField_4 = new GridBagConstraints();
		gbc_genTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField_4.gridwidth = 3;
		gbc_genTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_4.gridx = 1;
		gbc_genTextField_4.gridy = 3;
		editgenPanel.add(genTextField_4, gbc_genTextField_4);
		genTextField_4.setColumns(10);
		
		JLabel genlblName_2 = new JLabel("Name ");
		GridBagConstraints gbc_genlblName_2 = new GridBagConstraints();
		gbc_genlblName_2.anchor = GridBagConstraints.EAST;
		gbc_genlblName_2.insets = new Insets(0, 0, 5, 5);
		gbc_genlblName_2.gridx = 0;
		gbc_genlblName_2.gridy = 4;
		editgenPanel.add(genlblName_2, gbc_genlblName_2);
		
		genTextField_5 = new JTextField();
		GridBagConstraints gbc_genTextField_5 = new GridBagConstraints();
		gbc_genTextField_5.insets = new Insets(0, 0, 5, 0);
		gbc_genTextField_5.gridwidth = 3;
		gbc_genTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_genTextField_5.gridx = 1;
		gbc_genTextField_5.gridy = 4;
		editgenPanel.add(genTextField_5, gbc_genTextField_5);
		genTextField_5.setColumns(10);
		
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
		
		JTextArea gentextArea_1 = new JTextArea();
		genscrollPane_1.setViewportView(gentextArea_1);
		
		JButton genBtnSubmit = new JButton("Submit");
		GridBagConstraints gbc_genBtnSubmit = new GridBagConstraints();
		gbc_genBtnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_genBtnSubmit.gridwidth = 4;
		gbc_genBtnSubmit.gridx = 0;
		gbc_genBtnSubmit.gridy = 6;
		editgenPanel.add(genBtnSubmit, gbc_genBtnSubmit);
		
		
		//DISEASE ADD/EDIT PAGE********************************************************************************************************************
		aeDisDataPanel = new JPanel();
		GridBagLayout gbl_aeDisDataPanel = new GridBagLayout();
		gbl_aeDisDataPanel.columnWidths = new int[]{0, 0};
		gbl_aeDisDataPanel.rowHeights = new int[]{0, 0, 0};
		gbl_aeDisDataPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_aeDisDataPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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
		gbl_addDisPanel.columnWidths = new int[]{0, 0, 0};
		gbl_addDisPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_addDisPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_addDisPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		addDisPanel.setLayout(gbl_addDisPanel);
		
		JLabel dislblId = new JLabel("ID ");
		GridBagConstraints gbc_dislblId = new GridBagConstraints();
		gbc_dislblId.insets = new Insets(0, 0, 5, 5);
		gbc_dislblId.anchor = GridBagConstraints.EAST;
		gbc_dislblId.gridx = 0;
		gbc_dislblId.gridy = 0;
		addDisPanel.add(dislblId, gbc_dislblId);
		
		disTextField = new JTextField();
		GridBagConstraints gbc_disTextField = new GridBagConstraints();
		gbc_disTextField.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField.gridx = 1;
		gbc_disTextField.gridy = 0;
		addDisPanel.add(disTextField, gbc_disTextField);
		disTextField.setColumns(10);
		
		JLabel dislblName = new JLabel("Name ");
		GridBagConstraints gbc_dislblName = new GridBagConstraints();
		gbc_dislblName.anchor = GridBagConstraints.EAST;
		gbc_dislblName.insets = new Insets(0, 0, 5, 5);
		gbc_dislblName.gridx = 0;
		gbc_dislblName.gridy = 1;
		addDisPanel.add(dislblName, gbc_dislblName);
		
		disTextField_1 = new JTextField();
		GridBagConstraints gbc_disTextField_1 = new GridBagConstraints();
		gbc_disTextField_1.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_1.gridx = 1;
		gbc_disTextField_1.gridy = 1;
		addDisPanel.add(disTextField_1, gbc_disTextField_1);
		disTextField_1.setColumns(10);
		
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
		
		JTextArea distextArea = new JTextArea();
		disscrollPane.setViewportView(distextArea);
		
		JButton disBtnAdd = new JButton("Add");
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
		gbl_editDisPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_editDisPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_editDisPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_editDisPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		editDisPanel.setLayout(gbl_editDisPanel);
		
		JLabel dislblId_1 = new JLabel("ID ");
		GridBagConstraints gbc_dislblId_1 = new GridBagConstraints();
		gbc_dislblId_1.anchor = GridBagConstraints.EAST;
		gbc_dislblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_dislblId_1.gridx = 0;
		gbc_dislblId_1.gridy = 0;
		editDisPanel.add(dislblId_1, gbc_dislblId_1);
		
		disTextField_3 = new JTextField();
		GridBagConstraints gbc_disTextField_3 = new GridBagConstraints();
		gbc_disTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_disTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_3.gridx = 1;
		gbc_disTextField_3.gridy = 0;
		editDisPanel.add(disTextField_3, gbc_disTextField_3);
		disTextField_3.setColumns(10);
		
		JLabel dislblName_1 = new JLabel("Name");
		GridBagConstraints gbc_dislblName_1 = new GridBagConstraints();
		gbc_dislblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_dislblName_1.anchor = GridBagConstraints.EAST;
		gbc_dislblName_1.gridx = 2;
		gbc_dislblName_1.gridy = 0;
		editDisPanel.add(dislblName_1, gbc_dislblName_1);
		
		disTextField_2 = new JTextField();
		GridBagConstraints gbc_disTextField_2 = new GridBagConstraints();
		gbc_disTextField_2.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_2.gridx = 3;
		gbc_disTextField_2.gridy = 0;
		editDisPanel.add(disTextField_2, gbc_disTextField_2);
		disTextField_2.setColumns(10);
		
		JButton disBtnSearch = new JButton("Search");
		GridBagConstraints gbc_disBtnSearch = new GridBagConstraints();
		gbc_disBtnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_disBtnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_disBtnSearch.gridwidth = 3;
		gbc_disBtnSearch.gridx = 1;
		gbc_disBtnSearch.gridy = 1;
		editDisPanel.add(disBtnSearch, gbc_disBtnSearch);
		
		JScrollPane disscrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_disscrollPane_2 = new GridBagConstraints();
		gbc_disscrollPane_2.gridwidth = 3;
		gbc_disscrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_disscrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_disscrollPane_2.gridx = 1;
		gbc_disscrollPane_2.gridy = 2;
		editDisPanel.add(disscrollPane_2, gbc_disscrollPane_2);
		
		//RESULT TABLE HERE***************************
		disResTable = new JTable();
		disResTable.setFillsViewportHeight(true);
		disscrollPane_2.setViewportView(disResTable);
		
		JLabel dislblId_2 = new JLabel("ID ");
		GridBagConstraints gbc_dislblId_2 = new GridBagConstraints();
		gbc_dislblId_2.anchor = GridBagConstraints.EAST;
		gbc_dislblId_2.insets = new Insets(0, 0, 5, 5);
		gbc_dislblId_2.gridx = 0;
		gbc_dislblId_2.gridy = 3;
		editDisPanel.add(dislblId_2, gbc_dislblId_2);
		
		disTextField_4 = new JTextField();
		GridBagConstraints gbc_disTextField_4 = new GridBagConstraints();
		gbc_disTextField_4.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField_4.gridwidth = 3;
		gbc_disTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_4.gridx = 1;
		gbc_disTextField_4.gridy = 3;
		editDisPanel.add(disTextField_4, gbc_disTextField_4);
		disTextField_4.setColumns(10);
		
		JLabel dislblName_2 = new JLabel("Name ");
		GridBagConstraints gbc_dislblName_2 = new GridBagConstraints();
		gbc_dislblName_2.anchor = GridBagConstraints.EAST;
		gbc_dislblName_2.insets = new Insets(0, 0, 5, 5);
		gbc_dislblName_2.gridx = 0;
		gbc_dislblName_2.gridy = 4;
		editDisPanel.add(dislblName_2, gbc_dislblName_2);
		
		disTextField_5 = new JTextField();
		GridBagConstraints gbc_disTextField_5 = new GridBagConstraints();
		gbc_disTextField_5.insets = new Insets(0, 0, 5, 0);
		gbc_disTextField_5.gridwidth = 3;
		gbc_disTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_disTextField_5.gridx = 1;
		gbc_disTextField_5.gridy = 4;
		editDisPanel.add(disTextField_5, gbc_disTextField_5);
		disTextField_5.setColumns(10);
		
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
		
		JTextArea distextArea_1 = new JTextArea();
		disscrollPane_1.setViewportView(distextArea_1);
		
		JButton disBtnSubmit = new JButton("Submit");
		GridBagConstraints gbc_disBtnSubmit = new GridBagConstraints();
		gbc_disBtnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_disBtnSubmit.gridwidth = 4;
		gbc_disBtnSubmit.gridx = 0;
		gbc_disBtnSubmit.gridy = 6;
		editDisPanel.add(disBtnSubmit, gbc_disBtnSubmit);
		
		
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
        panelContainer.add(pharmDataPanel, "pharmData");
        panelContainer.add(aeChemDataPanel, "chemData");
        panelContainer.add(aeGenDataPanel, "genData");
        panelContainer.add(aeDisDataPanel, "disData");
        
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
                cardLayout.show(panelContainer, "patients");
            }
        });

        avBtnCancel.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "visits");
            }
        });
        
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

            }
        });
        
        chmBtnBack.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "pharmData");
                
            }
        });
        
        genBtnBack.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "pharmData");
                
            }
        });
        
        disBtnBack.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "pharmData");
                
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
