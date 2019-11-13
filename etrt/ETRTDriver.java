package etrt;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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

    public ETRTDriver() {
    	frame = new JFrame("CardLayout demo");
    	frame.setSize(600, 400);
    	
        //MAIN PAGE**********************************************************
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
        
        //PATIENTS PAGE**********************************************************
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
		
        //VISITS PAGE**********************************************************
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
		
        //ADD PATIENTS PAGE**********************************************************
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
		newPatientID = UUID.randomUUID().toString();
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

		
		panelContainer = new JPanel();
		CardLayout cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);
        panelContainer.add(mainPanel, "main");
        panelContainer.add(patientsPanel, "patients");
        panelContainer.add(addPatientPanel, "addPatients");
        panelContainer.add(visitsPanel, "visits");
        
        cardLayout.show(panelContainer, "main");
		
		
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
        
        visitsBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelContainer, "main");
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
        		newPatientID = UUID.randomUUID().toString();
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
