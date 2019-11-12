package etrt;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ETRTDriver {
	JFrame frame = new JFrame("CardLayout demo");
    JPanel panelContainer = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    JButton buttonOne = new JButton("Switch to second panel/workspace");
    JButton buttonSecond = new JButton("Switch to first panel/workspace");
    CardLayout layout = new CardLayout();
    GridLayout gLayout = new GridLayout();

    public ETRTDriver() {
    	frame.setSize(600, 400);
        
        
        panelFirst.add(buttonOne);
        panelFirst.add(new JButton("op2"));
        panelFirst.add(new JButton("op3"));
        panelFirst.add(new JButton("op4"));
        gLayout.setRows(2);
        gLayout.setColumns(2);
        gLayout.setHgap(40);
        gLayout.setVgap(40);
        panelFirst.setLayout(gLayout);
        panelFirst.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        panelSecond.add(buttonSecond);
        
        
        panelContainer.setLayout(layout);
        panelContainer.add(panelFirst, "1");
        panelContainer.add(panelSecond, "2");
        layout.show(panelContainer, "1");

        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                layout.show(panelContainer, "2");
            }
        });

        buttonSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                layout.show(panelContainer, "1");
            }
        });

        frame.add(panelContainer);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
