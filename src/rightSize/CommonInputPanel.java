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

public class CommonInputPanel extends JPanel 
{
	private JTextField tfPop;
	private JTextField tfProportion;
	private JTextField tfCI;
	private JTextField tfCC;
	
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

	
	/**
	 * Create the panel.
	 */
	public CommonInputPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{46, 340, 53, 108, 47, 23, 0};
		gridBagLayout.rowHeights = new int[]{38, 48, 30, 30, 30, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Assumptions");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label = new JLabel("Target Population Size");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		tfPop = new JTextField();
		tfPop.setText("100");
		tfPop.setHorizontalAlignment(SwingConstants.TRAILING);
		tfPop.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfPop.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(tfPop, gbc_textField);
		
		JLabel label_2 = new JLabel("Expected Proportion");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTH;
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		add(label_2, gbc_label_2);
		
		tfProportion = new JTextField();
		tfProportion.setHorizontalAlignment(SwingConstants.TRAILING);
		tfProportion.setText("50");
		tfProportion.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_tfPopSize = new GridBagConstraints();
		gbc_tfPopSize.fill = GridBagConstraints.BOTH;
		gbc_tfPopSize.insets = new Insets(0, 0, 5, 5);
		gbc_tfPopSize.gridx = 4;
		gbc_tfPopSize.gridy = 3;
		add(tfProportion, gbc_tfPopSize);
		tfProportion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Desired Confidence Interval");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfCI = new JTextField();
		tfCI.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCI.setText("5");
		tfCI.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCI.setColumns(10);
		GridBagConstraints gbc_tftfCC = new GridBagConstraints();
		gbc_tftfCC.fill = GridBagConstraints.BOTH;
		gbc_tftfCC.insets = new Insets(0, 0, 5, 5);
		gbc_tftfCC.gridx = 4;
		gbc_tftfCC.gridy = 4;
		add(tfCI, gbc_tftfCC);
		
		JLabel label_1 = new JLabel("%");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTH;
		gbc_label_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 4;
		add(label_1, gbc_label_1);
		
		JLabel lblDesiredConfidenceCoefficient = new JLabel("Desired Confidence Coefficient");
		lblDesiredConfidenceCoefficient.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblDesiredConfidenceCoefficient = new GridBagConstraints();
		gbc_lblDesiredConfidenceCoefficient.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblDesiredConfidenceCoefficient.insets = new Insets(0, 0, 0, 5);
		gbc_lblDesiredConfidenceCoefficient.gridwidth = 2;
		gbc_lblDesiredConfidenceCoefficient.gridx = 1;
		gbc_lblDesiredConfidenceCoefficient.gridy = 5;
		add(lblDesiredConfidenceCoefficient, gbc_lblDesiredConfidenceCoefficient);
		
		tfCC = new JTextField();
		tfCC.setText("95");
		tfCC.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCC.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCC.setColumns(10);
		GridBagConstraints gbc_tfCC = new GridBagConstraints();
		gbc_tftfCC.fill = GridBagConstraints.BOTH;
		gbc_tftfCC.insets = new Insets(0, 0, 0, 5);
		gbc_tftfCC.gridx = 4;
		gbc_tftfCC.gridy = 5;
		add(tfCC, gbc_tftfCC);
		
		JLabel label_4 = new JLabel("%");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.NORTH;
		gbc_label_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_4.gridx = 5;
		gbc_label_4.gridy = 5;
		add(label_4, gbc_label_4);

	}
}
