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
		gridBagLayout.columnWidths = new int[]{414, 103, 81, 92, 0};
		gridBagLayout.rowHeights = new int[]{35, 82, 42, 42, 42, 42, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitleLabel = new JLabel("Assumptions:");
		lblTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		GridBagConstraints gbc_lblTitleLabel = new GridBagConstraints();
		gbc_lblTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_lblTitleLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleLabel.gridx = 0;
		gbc_lblTitleLabel.gridy = 0;
		add(lblTitleLabel, gbc_lblTitleLabel);
		
		JLabel lblTarget = new JLabel("Target Population");
		lblTarget.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblTarget = new GridBagConstraints();
		gbc_lblTarget.anchor = GridBagConstraints.WEST;
		gbc_lblTarget.insets = new Insets(0, 0, 5, 5);
		gbc_lblTarget.gridx = 0;
		gbc_lblTarget.gridy = 2;
		add(lblTarget, gbc_lblTarget);
		
		tfPop = new JTextField();
		tfPop.setText("100");
		tfPop.setHorizontalAlignment(SwingConstants.TRAILING);
		tfPop.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfPop.setColumns(10);
		GridBagConstraints gbc_tfPop = new GridBagConstraints();
		gbc_tfPop.anchor = GridBagConstraints.NORTH;
		gbc_tfPop.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPop.insets = new Insets(0, 0, 5, 5);
		gbc_tfPop.gridx = 2;
		gbc_tfPop.gridy = 2;
		add(tfPop, gbc_tfPop);
		
		JLabel label_2 = new JLabel("Expected Proportion");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.SOUTH;
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		add(label_2, gbc_label_2);
		
		tfProportion = new JTextField();
		tfProportion.setHorizontalAlignment(SwingConstants.TRAILING);
		tfProportion.setText("50");
		tfProportion.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfProportion.setColumns(10);
		GridBagConstraints gbc_tfProportion = new GridBagConstraints();
		gbc_tfProportion.anchor = GridBagConstraints.NORTH;
		gbc_tfProportion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProportion.insets = new Insets(0, 0, 5, 5);
		gbc_tfProportion.gridx = 2;
		gbc_tfProportion.gridy = 3;
		add(tfProportion, gbc_tfProportion);
		
		JLabel label_4 = new JLabel("%");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 3;
		add(label_4, gbc_label_4);
		
		JLabel lblNewLabel_1 = new JLabel("Desired Confidence Interval");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
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
		gbc_tfCI.gridx = 2;
		gbc_tfCI.gridy = 4;
		add(tfCI, gbc_tfCI);
		
		JLabel lblNewLabel = new JLabel("\u00B1");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label_1 = new JLabel("%");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 4;
		add(label_1, gbc_label_1);
		
		JLabel lblDesiredConfidenceCoefficient = new JLabel("Desired Confidence Coefficient");
		lblDesiredConfidenceCoefficient.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblDesiredConfidenceCoefficient = new GridBagConstraints();
		gbc_lblDesiredConfidenceCoefficient.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDesiredConfidenceCoefficient.insets = new Insets(0, 0, 0, 5);
		gbc_lblDesiredConfidenceCoefficient.gridx = 0;
		gbc_lblDesiredConfidenceCoefficient.gridy = 5;
		add(lblDesiredConfidenceCoefficient, gbc_lblDesiredConfidenceCoefficient);
		
		tfCC = new JTextField();
		tfCC.setText("95");
		tfCC.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCC.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCC.setColumns(10);
		GridBagConstraints gbc_tfCC = new GridBagConstraints();
		gbc_tfCC.anchor = GridBagConstraints.NORTH;
		gbc_tfCC.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCC.insets = new Insets(0, 0, 0, 5);
		gbc_tfCC.gridx = 2;
		gbc_tfCC.gridy = 5;
		add(tfCC, gbc_tfCC);
		
		JLabel lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

	}
}
