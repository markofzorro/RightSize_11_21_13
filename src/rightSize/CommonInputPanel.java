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

public class CommonInputPanel extends JPanel {
	private JTextField tfPopSize;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfCI;

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
		
		textField = new JTextField();
		textField.setText("100");
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		
		JLabel label_2 = new JLabel("Expected Proportion");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTH;
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		add(label_2, gbc_label_2);
		
		tfPopSize = new JTextField();
		tfPopSize.setHorizontalAlignment(SwingConstants.TRAILING);
		tfPopSize.setText("50");
		tfPopSize.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_tfPopSize = new GridBagConstraints();
		gbc_tfPopSize.fill = GridBagConstraints.BOTH;
		gbc_tfPopSize.insets = new Insets(0, 0, 5, 5);
		gbc_tfPopSize.gridx = 4;
		gbc_tfPopSize.gridy = 3;
		add(tfPopSize, gbc_tfPopSize);
		tfPopSize.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_1.setText("5");
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		
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
		
		tfCI = new JTextField();
		tfCI.setText("5");
		tfCI.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCI.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCI.setColumns(10);
		GridBagConstraints gbc_tfCI = new GridBagConstraints();
		gbc_tfCI.fill = GridBagConstraints.BOTH;
		gbc_tfCI.insets = new Insets(0, 0, 0, 5);
		gbc_tfCI.gridx = 4;
		gbc_tfCI.gridy = 5;
		add(tfCI, gbc_tfCI);
		
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
