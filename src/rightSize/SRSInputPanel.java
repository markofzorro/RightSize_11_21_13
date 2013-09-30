package rightSize;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SRSInputPanel extends JPanel
{
	
	// set to defaults
	
	private GridBagConstraints gridBagConstraints_1;
	
		static final String POPULATION_DEFAULT = "1000"; 
		static final String PROPORTION_DEFAULT = "50";
		static final String CONFIDENCE_INTERVAL_DEFAULT = "5";
		static final String CONFIDENCE_LEVEL_DEFAULT = "95";
		
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    

	JTextField tfPopulation = new JTextField();
	JTextField tfProportion = new JTextField();
	JTextField tfConfidenceInterval = new JTextField();
	JTextField tfConfidenceLevel = new JTextField();
	
    

	SRSInputPanel()
		{
			setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 20)); // top,
																		// left,
																		// bottom,
																		// right

			
			setLayout(new java.awt.GridBagLayout());
			java.awt.GridBagConstraints gridBagConstraints;
			
		    

			jLabel1 = new javax.swing.JLabel();
			// tfPopulation = new javax.swing.JTextField();
			jLabel2 = new javax.swing.JLabel();
			jLabel4 = new javax.swing.JLabel();
			jLabel5 = new javax.swing.JLabel();
			jLabel6 = new javax.swing.JLabel();
			jLabel7 = new javax.swing.JLabel();
			jLabel3 = new javax.swing.JLabel();
			jLabel8 = new javax.swing.JLabel();
			jLabel9 = new javax.swing.JLabel();

			jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
			jLabel1.setText("Target Population Size");
			jLabel1.setToolTipText("The estimated size of the target population you are sampling from.");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 2;
			gridBagConstraints.gridheight = 2;
			gridBagConstraints.ipadx = 144;
			gridBagConstraints.ipady = 15;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(39, 38, 5, 5);
			add(jLabel1, gridBagConstraints);

			tfPopulation.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
			tfPopulation
					.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
			tfPopulation
					.setToolTipText("The target populaton can range from 100 to billions (at the request of the China FETP). The earth's population at this writing is about 7 billion. ");
			tfPopulation.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt)
					{
						tfPopulationActionPerformed(evt);
					}
			});
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 4;
			gridBagConstraints.gridy = 2;
			gridBagConstraints.gridwidth = 8;
			gridBagConstraints.ipadx = 236;
			gridBagConstraints.ipady = 3;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(37, 46, 5, 5);
			add(tfPopulation, gridBagConstraints);

			jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
			jLabel2.setText("Enter Your Assumptions");
			gridBagConstraints_1 = new java.awt.GridBagConstraints();
			gridBagConstraints_1.insets = new Insets(0, 0, 5, 5);
			gridBagConstraints_1.gridx = 0;
			gridBagConstraints_1.gridy = 0;
			gridBagConstraints_1.gridwidth = 5;
			gridBagConstraints_1.gridheight = 2;
			gridBagConstraints_1.ipadx = 330;
			gridBagConstraints_1.ipady = -10;
			gridBagConstraints_1.anchor = java.awt.GridBagConstraints.NORTHWEST;
			add(jLabel2, gridBagConstraints_1);

			jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
			jLabel4.setText("Desired Confidence Coefficient");
			jLabel4.setToolTipText("The probability that the true population value is within the above confidence interval.");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 10;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.gridheight = 3;
			gridBagConstraints.ipadx = 53;
			gridBagConstraints.ipady = 15;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(47, 38, 0, 5);
			add(jLabel4, gridBagConstraints);

			jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
			jLabel5.setText("Width of Desired Confidence Interval");
			jLabel5.setToolTipText("The probability that your resulting proportion will be within the confidence interval. Usually 95% chance.");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 7;
			gridBagConstraints.gridwidth = 3;
			gridBagConstraints.gridheight = 3;
			gridBagConstraints.ipadx = 66;
			gridBagConstraints.ipady = 15;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(35, 38, 5, 5);
			add(jLabel5, gridBagConstraints);

			jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
			jLabel6.setText("Proportion");
			jLabel6.setToolTipText("Estimated true value of the characteristic (example: immunized children)  you are estimating.");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 4;
			gridBagConstraints.gridwidth = 3;
			gridBagConstraints.gridheight = 3;
			gridBagConstraints.ipadx = 393;
			gridBagConstraints.ipady = 15;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(37, 38, 5, 5);
			add(jLabel6, gridBagConstraints);

			jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
			jLabel7.setText("%");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 12;
			gridBagConstraints.gridy = 4;
			gridBagConstraints.gridheight = 2;
			gridBagConstraints.ipady = 10;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(40, 1, 5, 0);
			add(jLabel7, gridBagConstraints);

			jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
			jLabel3.setText("<html>&plusmn</html>");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 8;
			gridBagConstraints.gridy = 7;
			gridBagConstraints.gridheight = 3;
			gridBagConstraints.ipady = 29;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(21, 52, 5, 5);
			add(jLabel3, gridBagConstraints);

			jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
			jLabel8.setText("%");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 12;
			gridBagConstraints.gridy = 7;
			gridBagConstraints.gridheight = 2;
			gridBagConstraints.ipady = 10;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(38, 1, 5, 0);
			add(jLabel8, gridBagConstraints);

			jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
			jLabel9.setText("%");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 12;
			gridBagConstraints.gridy = 10;
			gridBagConstraints.ipady = 10;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(41, 1, 5, 0);
			add(jLabel9, gridBagConstraints);

			tfConfidenceLevel
					.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
			tfConfidenceLevel
					.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
			// //
			tfConfidenceLevel
					.setToolTipText("<html>This is the inverse of &#945.<br><br>A 95% confidence interval means that there is a 5% (or p = 0.05) chance<br> that the true population proportion is outside the confidence interval.");
			tfConfidenceLevel
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(
								java.awt.event.ActionEvent evt)
							{
								tfConfidenceLevelActionPerformed(evt);
							}
					});
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 9;
			gridBagConstraints.gridy = 10;
			gridBagConstraints.gridheight = 2;
			gridBagConstraints.ipadx = 31;
			gridBagConstraints.ipady = 3;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(39, 0, 5, 5);
			add(tfConfidenceLevel, gridBagConstraints);

			tfProportion.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
			tfProportion
					.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
			tfProportion
					.setToolTipText("The largest sample size will be required if this is 50%");
			tfProportion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt)
					{
						tfProportionActionPerformed(evt);
					}
			});
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 9;
			gridBagConstraints.gridy = 4;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.ipadx = 31;
			gridBagConstraints.ipady = 3;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(33, 1, 5, 5);
			add(tfProportion, gridBagConstraints);

			tfConfidenceInterval.setFont(new java.awt.Font("Lucida Grande", 0,
					24)); // NOI18N
			tfConfidenceInterval
					.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
			tfConfidenceInterval
					.setToolTipText("<html>Narrower confidence intervals require <strong>much larger</strong> sample sizes<br>and higher costs.</html>");
			tfConfidenceInterval
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(
								java.awt.event.ActionEvent evt)
							{
								tfConfidenceIntervalActionPerformed(evt);
							}
					});
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 9;
			gridBagConstraints.gridy = 7;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.ipadx = 31;
			gridBagConstraints.ipady = 3;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new Insets(31, 1, 5, 5);
			add(tfConfidenceInterval, gridBagConstraints);

		}
	
	//Action Methods
    private void tfPopulationActionPerformed(java.awt.event.ActionEvent evt)                                          
    {    
    		
    		// don't seem to reach here, but WTF is works. 
    		
       // D.b("!!!---After change, population is: " + tfPopulation.getText());
    }                                        
    private void tfConfidenceIntervalActionPerformed(java.awt.event.ActionEvent evt)                                                      
    {                                                          
        // TODO add your handling code here:
    }                                                     

    private void tfProportionActionPerformed(java.awt.event.ActionEvent evt)                                              
    {                                                  
        // TODO add your handling code here:
    }                                             

    private void tfConfidenceLevelActionPerformed(java.awt.event.ActionEvent evt)                                                  
    {                                                      
        // TODO add your handling code here:
    }

    /***end Action Methods **
     * 
     */
    
    /*********Begin Getters and Setters *******/
 /******** Getters and Setters ************************/
    
    /*public javax.swing.JTextField getTfPopulation() {
		return tfPopulation;
	}
	*/
    public String getPopulation()
    	{
    		//System.out.println("getpop: the string is " + tfPopulation.toString());
    		return tfPopulation.getText();
    	}

    public String getProportion() 
    	{
    		return tfProportion.getText();
    	}
    
    public String getCI() 
    	{
    		return tfConfidenceInterval.getText();
    	}
    
    public String getCC() 
    	{
    		return tfConfidenceLevel.getText();
    	}

	

/****** End Getters and Setters **/
     
	
	/**
     * public void setDefaultValues()
     * Sets the text fields to the default values
     */
    public void setDefaultValues()
    	{
    		
    		
    		
    		
    		
    		tfPopulation.setText(POPULATION_DEFAULT);
    		tfProportion.setText(PROPORTION_DEFAULT);
    		tfConfidenceLevel.setText(CONFIDENCE_LEVEL_DEFAULT);
    		tfConfidenceInterval.setText(CONFIDENCE_INTERVAL_DEFAULT);
    		
    		
    	}

}