package rightSize;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class SRSResultsPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public SRSResultsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{327, 118, 234, 0};
		gridBagLayout.rowHeights = new int[]{43, 42, 42, 42, 42, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Results:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sample Size Needed");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		
		JLabel lblFinitePopulationCorrection = new JLabel("Finite Population Correction");
		lblFinitePopulationCorrection.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblFinitePopulationCorrection = new GridBagConstraints();
		gbc_lblFinitePopulationCorrection.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFinitePopulationCorrection.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinitePopulationCorrection.gridx = 0;
		gbc_lblFinitePopulationCorrection.gridy = 3;
		add(lblFinitePopulationCorrection, gbc_lblFinitePopulationCorrection);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		
		JLabel lblSampleSizeWith = new JLabel("Corrected Sample Size");
		lblSampleSizeWith.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GridBagConstraints gbc_lblSampleSizeWith = new GridBagConstraints();
		gbc_lblSampleSizeWith.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblSampleSizeWith.insets = new Insets(0, 0, 0, 5);
		gbc_lblSampleSizeWith.gridx = 0;
		gbc_lblSampleSizeWith.gridy = 4;
		add(lblSampleSizeWith, gbc_lblSampleSizeWith);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		add(textField_2, gbc_textField_2);

	}
}
