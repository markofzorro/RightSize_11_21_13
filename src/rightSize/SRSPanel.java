package rightSize;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JProgressBar;

public class SRSPanel extends JPanel 
{
	private JTextField tfProportion;
	private JTextField tfCI;
	private JTextField tfCC;
	private JTextField tfPop;
	private JTextField tfCorrectedN;

	private JTextField tfFpc;
	private JTextField tf_N0;
	private JTextField textField;
	
	
	/*public void setTfN(double d)
		{
			tfN.setText(Double.toString(d));
		}
*/
	public void setTfCorrectedN(double d)
		{
			this.tfCorrectedN.setText(Double.toString(d));
		}

	public void setTfFpc1(double d)
		{
			this.tfFpc.setText(Double.toString(d));
		}

	public void setTf_N0(double d)
		{
			this.tf_N0.setText(Double.toString(d));
		}
	
	
	
	/********************* Getters **************/
	
	public String getPopString() {
		return tfPop.getText();
	}

	public String getProportionString() {
		return tfProportion.getText();
	}

	public String getCIString() {
		return tfCI.getText();
	}

	public String getCCString() {
		return tfCC.getText();
	}
	
	/********** end getters *********************/
	
	/************** Setters ************/
	public void setTfN0(double d)
		{
			tfPop.setText(Double.toString(d));
			
		}
	
	
	public void setTfFpc(double d)
		{
			tfFpc.setText(Double.toString(d));
			
		}
	
	public void setTfN(double d)
		{
			tfN.setText(Double.toString(d));
			
		}

	

	
	/**
	 * Create the panel.
	 */
	public SRSPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{239, 123, 19, 71, 87, 215, 16, 0};
		gridBagLayout.rowHeights = new int[]{38, 30, 42, 42, 42, 1, 31, 42, 42, 42, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_4 = new JLabel("Assumptions:");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblTarget = new JLabel("Target Population");
		lblTarget.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblTarget = new GridBagConstraints();
		gbc_lblTarget.anchor = GridBagConstraints.NORTH;
		gbc_lblTarget.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTarget.insets = new Insets(0, 0, 5, 5);
		gbc_lblTarget.gridx = 0;
		gbc_lblTarget.gridy = 1;
		add(lblTarget, gbc_lblTarget);
		
		tfPop =new JTextField();
		tfPop.setText("100");
		tfPop.setHorizontalAlignment(SwingConstants.TRAILING);
		tfPop.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfPop.setColumns(10);
		GridBagConstraints gbc_tfPop = new GridBagConstraints();
		gbc_tfPop.anchor = GridBagConstraints.SOUTH;
		gbc_tfPop.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPop.insets = new Insets(0, 0, 5, 5);
		gbc_tfPop.gridx = 4;
		gbc_tfPop.gridy = 1;
		add(tfPop, gbc_tfPop);
		
		JLabel lblNewLabel_5 = new JLabel("Expected Proportion");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.gridwidth = 2;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		tfProportion = new JTextField();
		tfProportion.setHorizontalAlignment(SwingConstants.TRAILING);
		tfProportion.setText("50");
		tfProportion.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfProportion.setColumns(10);
		GridBagConstraints gbc_tfProportion = new GridBagConstraints();
		gbc_tfProportion.anchor = GridBagConstraints.NORTH;
		gbc_tfProportion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProportion.insets = new Insets(0, 0, 5, 5);
		gbc_tfProportion.gridx = 4;
		gbc_tfProportion.gridy = 2;
		add(tfProportion, gbc_tfProportion);
		
		JLabel label_4 = new JLabel("%");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 5;
		gbc_label_4.gridy = 2;
		add(label_4, gbc_label_4);
		
		JLabel lblNewLabel_1 = new JLabel("Desired Confidence Interval");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfCI = new JTextField();
		tfCI.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCI.setText("5");
		tfCI.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCI.setColumns(10);
		GridBagConstraints gbc_tfCI = new GridBagConstraints();
		gbc_tfCI.anchor = GridBagConstraints.NORTH;
		gbc_tfCI.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCI.insets = new Insets(0, 0, 5, 5);
		gbc_tfCI.gridx = 4;
		gbc_tfCI.gridy = 3;
		add(tfCI, gbc_tfCI);
		
		JLabel label_1 = new JLabel("%");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		JLabel lblDesiredConfidenceCoefficient = new JLabel("Desired Confidence Coefficient");
		lblDesiredConfidenceCoefficient.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblDesiredConfidenceCoefficient = new GridBagConstraints();
		gbc_lblDesiredConfidenceCoefficient.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDesiredConfidenceCoefficient.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesiredConfidenceCoefficient.gridwidth = 3;
		gbc_lblDesiredConfidenceCoefficient.gridx = 0;
		gbc_lblDesiredConfidenceCoefficient.gridy = 4;
		add(lblDesiredConfidenceCoefficient, gbc_lblDesiredConfidenceCoefficient);
		
		JLabel lblNewLabel = new JLabel("\u00B1");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		tfCC = new JTextField();
		tfCC.setText("95");
		tfCC.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCC.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCC.setColumns(10);
		GridBagConstraints gbc_tfCC = new GridBagConstraints();
		gbc_tfCC.anchor = GridBagConstraints.NORTH;
		gbc_tfCC.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCC.insets = new Insets(0, 0, 5, 5);
		gbc_tfCC.gridx = 4;
		gbc_tfCC.gridy = 4;
		add(tfCC, gbc_tfCC);
		
		JLabel lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
	
		JLabel lblNewLabel_3 = new JLabel("Results:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridheight = 2;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridwidth = 5;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 5;
		add(separator, gbc_separator);
		
				
		JLabel label_3 = new JLabel("%");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 6;
		gbc_label_3.gridy = 6;
		add(label_3, gbc_label_3);
		
		JLabel lblSampleSize = new JLabel("Sample Size");
		lblSampleSize.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblSampleSize = new GridBagConstraints();
		gbc_lblSampleSize.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSampleSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblSampleSize.gridwidth = 2;
		gbc_lblSampleSize.gridx = 0;
		gbc_lblSampleSize.gridy = 7;
		add(lblSampleSize, gbc_lblSampleSize);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 7;
		add(textField, gbc_textField);
		
		JLabel lblFinitePopulationCorrection = new JLabel("Finite Population Correction");
		lblFinitePopulationCorrection.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblFinitePopulationCorrection = new GridBagConstraints();
		gbc_lblFinitePopulationCorrection.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFinitePopulationCorrection.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinitePopulationCorrection.gridwidth = 2;
		gbc_lblFinitePopulationCorrection.gridx = 0;
		gbc_lblFinitePopulationCorrection.gridy = 8;
		add(lblFinitePopulationCorrection, gbc_lblFinitePopulationCorrection);
		
		tfFpc = new JTextField();
		tfFpc.setHorizontalAlignment(SwingConstants.TRAILING);
		tfFpc.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfFpc.setColumns(10);
		GridBagConstraints gbc_tfFpc = new GridBagConstraints();
		gbc_tfFpc.anchor = GridBagConstraints.NORTH;
		gbc_tfFpc.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFpc.insets = new Insets(0, 0, 5, 5);
		gbc_tfFpc.gridx = 4;
		gbc_tfFpc.gridy = 8;
		add(tfFpc, gbc_tfFpc);
		
		JLabel lblCorrectedSampleSize = new JLabel("Corrected Sample Size");
		lblCorrectedSampleSize.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCorrectedSampleSize = new GridBagConstraints();
		gbc_lblCorrectedSampleSize.anchor = GridBagConstraints.WEST;
		gbc_lblCorrectedSampleSize.insets = new Insets(0, 0, 0, 5);
		gbc_lblCorrectedSampleSize.gridwidth = 2;
		gbc_lblCorrectedSampleSize.gridx = 0;
		gbc_lblCorrectedSampleSize.gridy = 9;
		add(lblCorrectedSampleSize, gbc_lblCorrectedSampleSize);
		
		
		
		tfCorrectedN = new JTextField();
		tfCorrectedN.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCorrectedN.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCorrectedN.setColumns(10);
		GridBagConstraints gbc_tfCorrectedN = new GridBagConstraints();
		gbc_tfCorrectedN.anchor = GridBagConstraints.NORTH;
		gbc_tfCorrectedN.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCorrectedN.insets = new Insets(0, 0, 0, 5);
		gbc_tfCorrectedN.gridx = 4;
		gbc_tfCorrectedN.gridy = 9;
		add(tfCorrectedN, gbc_tfCorrectedN);

	}
}
