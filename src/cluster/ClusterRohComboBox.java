package cluster;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import basesAndUtilites.D;

import java.util.*;
import java.text.SimpleDateFormat;

/* ComboBoxDemo2.java requires no other files. */
public class ClusterRohComboBox extends JPanel
                           implements ActionListener {
    static JFrame frame;
    JLabel result;
    String rohChoice;
    double roh;

    public ClusterRohComboBox() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        String[] rohExamples = {
        		"Demographic Variables: 0.02",
        		"Prevalence of an Infectious Disease: 0.3",
        		"Prevalence of Illness in General: 0.02",
        		"Low Utilization of Health Cares Services: 0.1",
                 "High Utilization of Health Cares Services: 0.3",
                 };

        rohChoice = rohExamples[0];

        //Set up the UI for selecting an roh
        
        JLabel titleLabel1 = new JLabel("Estimates of Rate of Homogenaity are based on");
        JLabel titleLabel2 = new JLabel("results of previous surveys in your population,");
        JLabel titleLabel3 = new JLabel("or select one from this list.");
        //JLabel titleLabel4 = new JLabel("Select one from the list:");
        
        JComboBox box = new JComboBox(rohExamples);
        box.setEditable(true);
        box.addActionListener(this);

        //Create the UI for displaying result.
        JLabel resultLabel = new JLabel("Current Date/Time",
                                        JLabel.LEADING); //== LEFT
        result = new JLabel(" ");
        result.setForeground(Color.black);
        result.setBorder(BorderFactory.createCompoundBorder(
             BorderFactory.createLineBorder(Color.black),
             BorderFactory.createEmptyBorder(5,5,5,5)
        ));

        //Lay out everything.
        JPanel rohPanel = new JPanel();
        rohPanel.setLayout(new BoxLayout(rohPanel,
                               BoxLayout.PAGE_AXIS));
        rohPanel.add(titleLabel1);
        rohPanel.add(titleLabel2);
        rohPanel.add(titleLabel3);
   //     rohPanel.add(titleLabel4);
        box.setAlignmentX(Component.LEFT_ALIGNMENT);
        rohPanel.add(box);

        /*JPanel resultPanel = new JPanel(new GridLayout(0, 1));
        resultPanel.add(resultLabel);
        resultPanel.add(result);
*/
        rohPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
     //   resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(rohPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
//        add(resultPanel);

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

      //  reformat();
    } //constructor

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        rohChoice = (String)cb.getSelectedItem();
      
        
        
        
        // send the new roh to the document to be used in calculation. 
       if("Demographic Variables: 0.02".equals(rohChoice))
    		  roh = 0.02;
       else if("Prevalence of an Infectious Disease: 0.3".equals(rohChoice))
    		   roh = 0.3;
       else if("Prevalence of Illness in General: 0.02".equals(rohChoice))
		   roh = 0.02;
       else if("Low Utilization of Health Cares Services: 0.1".equals(rohChoice))
		   roh = 0.1;
       else if("High Utilization of Health Cares Services: 0.3".equals(rohChoice))
		   roh = 0.3;
       D.b("Selected: " + rohChoice);
       D.b("rohChoice is " + roh);
        
    }

  
   }
