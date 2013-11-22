package cluster;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import basesAndUtilites.D;
import basesAndUtilites.Globals;

import java.awt.GridLayout;

		public class ClusterPanel extends JPanel
			{
				private JTextField tfPop = null;
				private JTextField tfProportion = null;
				private JTextField tfCI = null;
				private JTextField tfCC = null;
				private JTextField tfClusterSize = null;
				private JTextField tfROH = null;
			
				// Result labels
				private JLabel lblClustersNeeded = null;
				private JLabel lblDesignEffect= null;
				private JLabel lblROH = null;
			

				/**
				 * Create the panel. Has four equal sized columns. Adds rows prn.
				 */
				public ClusterPanel()
					{
						setLayout(new GridLayout(0, 4));
						// setSize(500, 500);

						// first Row. Must fill three empty columns
						newLabel("Assumptions:", Globals.TITLE_SIZE);
						fillCols(3);

						// second row
						newLabel("Target Population Size", Globals.TEXT_SIZE);
						fillCols(1);
						tfPop = newTf("1000");
						add(tfPop);
						fillCols(1);

						// third row
						newLabel("Expected Proportion", Globals.TEXT_SIZE);
						fillCols(1);
						tfProportion = newTf("50");
						add(tfProportion);
						newLabel("%", Globals.TEXT_SIZE);

						// fourth row
						newLabel("Desired Width of Confidence Interval", Globals.TEXT_SIZE);
						JLabel lblPm = new JLabel("\u00B1"); // plus/minus sign
						lblPm.setHorizontalAlignment(SwingConstants.TRAILING);
						lblPm.setFont(new java.awt.Font("Lucida Grande", 1, Globals.TEXT_SIZE)); // NOI18N
						add(lblPm);
						tfCI = newTf("5");
						add(tfCI);
						newLabel("%", Globals.TEXT_SIZE);

						// Fifth Row
						newLabel("Desired Confidence Coeffecient", Globals.TEXT_SIZE);
						fillCols(1);
						tfCC = newTf("95");
						add(tfCC);
						newLabel("%", Globals.TEXT_SIZE);
						

						// Sixth Row
						newLabel("Desired Cluster Size", Globals.TEXT_SIZE);
						fillCols(1);
						tfClusterSize = newTf("10");
						add(tfClusterSize);
						//newLabel("%", Globals.TEXT_SIZE);
						fillCols(1);

						// Seventh Row
						newLabel("Estimated Rate of Homogeneity", Globals.TEXT_SIZE);
						fillCols(1);
						tfROH = newTf("0.02");
						add(tfROH);
						newLabel("%", Globals.TEXT_SIZE);
						

						// Draw separator across all 4 columns
						for (int i = 0; i < 4; i++)
							add(new JSeparator());

						// Results:
		/******************* Results start here ***********/
						// row 7
						JLabel lblTitle = new JLabel("Results:");
						lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, Globals.TITLE_SIZE)); // NOI18N
						add(lblTitle);
						fillCols(3);

						// Row 8
						newLabel("Clusters Needed", Globals.TEXT_SIZE);
						fillCols(1);
						lblClustersNeeded = newLabel("", Globals.TEXT_SIZE);
						lblClustersNeeded.setHorizontalAlignment(SwingConstants.TRAILING);

						fillCols(1);

						// Row 9
						newLabel("Rate of Homogeneity", Globals.TEXT_SIZE);
						fillCols(1);
						lblROH = newLabel("", Globals.TEXT_SIZE);
						lblROH.setHorizontalAlignment(SwingConstants.TRAILING);
						fillCols(1);

						// Row 9
						newLabel("Design Effect", Globals.TEXT_SIZE);
						fillCols(1);
						lblDesignEffect = newLabel("", Globals.TEXT_SIZE);
						lblDesignEffect.setHorizontalAlignment(SwingConstants.TRAILING);
						//fillCols(1);
				}

				/****************** Helper Methods ***************************/
				
				JLabel newLabel(String s, int fontSize)
					{
						JLabel label = new JLabel(s);
						label.setFont(new java.awt.Font("Lucida Grande", 1, fontSize)); // NOI18N
						add(label);

						return label;
					}

				JTextField newTf(String s)
					{
						JTextField field = new JTextField(s);
						field.setHorizontalAlignment(SwingConstants.TRAILING);
						field.setFont(new java.awt.Font("Lucida Grande", 1, Globals.TEXT_SIZE)); // NOI18N
						return field;
					}

				private void fillCols(int number)
					{
						for (int i = 0; i < number; i++)
							{
								add(new JLabel(""));
							}

					}

				/********************* Getters **************/

				public String getPopString()
					{
						D.b("panel:getPopString(). tfPopString is: " + tfPop.getText() + " "+ tfPop);
						return tfPop.getText();
					}

				public String getProportionString()
					{
						return tfProportion.getText();
					}

				public String getCIString()
					{
						return tfCI.getText();
					}

				public String getCCString()
					{
						return tfCC.getText();
					}
				
				public String getClusterSizeString()
					{
						return tfClusterSize.getText();
					}

				public String getROHString()
					{
						D.b("Panel: tfROH is " + tfROH.getText());
						return tfROH.getText();
					}
				/************** Setters ************/
				public void setLblClustersNeeded(double d)
					{
						lblClustersNeeded.setText(Double.toString(d));

					}

				public void setLblDesignEffect(double d)
					{
						lblDesignEffect.setText(Double.toString(d));

					}
				
				public void setLblROH(double d)
					{
						lblROH.setText(Double.toString(d));

					}
				
				

				
			}

	
