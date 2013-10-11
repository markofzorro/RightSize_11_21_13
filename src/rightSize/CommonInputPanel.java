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
		
		JLabel lblTitleLabel = new JLabel("Assumptions");
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		
		JLabel label = new JLabel("Target Population Size");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		tfPop = new JTextField();
		tfPop.setText("100");
		tfPop.setHorizontalAlignment(SwingConstants.TRAILING);
		tfPop.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfPop.setColumns(10);
		
		JLabel label_2 = new JLabel("Expected Proportion");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		tfProportion = new JTextField();
		tfProportion.setHorizontalAlignment(SwingConstants.TRAILING);
		tfProportion.setText("50");
		tfProportion.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfProportion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1 = new JLabel("Desired Confidence Interval");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		tfCI = new JTextField();
		tfCI.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCI.setText("5");
		tfCI.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCI.setColumns(10);
		
		JLabel label_1 = new JLabel("%");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblDesiredConfidenceCoefficient = new JLabel("Desired Confidence Coefficient");
		lblDesiredConfidenceCoefficient.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		tfCC = new JTextField();
		tfCC.setText("95");
		tfCC.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCC.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		tfCC.setColumns(10);
		
		JLabel label_4 = new JLabel("%");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(236)
					.addComponent(lblTitleLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(label)
					.addGap(73)
					.addComponent(tfPop, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblDesiredConfidenceCoefficient)
					.addGap(124)
					.addComponent(tfCC, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
					.addGap(149)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(tfCI, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tfProportion, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblTitleLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(tfPop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(lblNewLabel_2)
						.addComponent(tfProportion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(tfCI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tfCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblDesiredConfidenceCoefficient))
						.addComponent(label_4))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
