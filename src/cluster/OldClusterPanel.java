package cluster;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import basesAndUtilites.D;
import basesAndUtilites.Globals;
import basesAndUtilites.RSDoubleToLongToString;

		public class OldClusterPanel extends JPanel
			{
				private ClusterDoc doc = null;
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
				public OldClusterPanel(ClusterDoc doc)
					{
						setLayout(new GridLayout(0, 4));
						
						this.doc = doc;

						// first Row. Must fill three empty columns
						newLabel("Assumptions:", Globals.TITLE_SIZE);
						fillCols(3);

						// second row
						newLabel("Target Population Size", Globals.TEXT_SIZE);
						fillCols(1);
						tfPop = newTf(RSDoubleToLongToString.convert(doc.getPopulation()));
						//tfPop = newTf(Double.toString(doc.getPopulation()));
						add(tfPop);
						fillCols(1);

						// third row
						newLabel("Expected Proportion", Globals.TEXT_SIZE);
						fillCols(1);
						tfProportion = newTf(RSDoubleToLongToString.convert(doc.getProportion()));
						add(tfProportion);
						newLabel("%", Globals.TEXT_SIZE);

						// fourth row
						newLabel("Desired Width of Confidence Interval", Globals.TEXT_SIZE);
						JLabel lblPm = new JLabel("\u00B1"); // plus/minus sign
						lblPm.setHorizontalAlignment(SwingConstants.TRAILING);
						lblPm.setFont(new java.awt.Font("Lucida Grande", 1, Globals.TEXT_SIZE)); // NOI18N
						add(lblPm);
						tfCI = newTf(RSDoubleToLongToString.convert(doc.getConfidenceInterval()));
						add(tfCI);
						newLabel("%", Globals.TEXT_SIZE);

						// Fifth Row
						newLabel("Desired Confidence Coeffecient", Globals.TEXT_SIZE);
						fillCols(1);
						tfCC = newTf(RSDoubleToLongToString.convert(doc.getConfidenceCoefficient()));
						add(tfCC);
						newLabel("%", Globals.TEXT_SIZE);
						

						// Sixth Row
						newLabel("Desired Cluster Size", Globals.TEXT_SIZE);
						fillCols(1);
						tfClusterSize = newTf(RSDoubleToLongToString.convert(doc.getClusterSize()));
						add(tfClusterSize);
						//newLabel("%", Globals.TEXT_SIZE);
						fillCols(1);

						// Seventh Row
						newLabel("Estimated Rate of Homogeneity", Globals.TEXT_SIZE);
						fillCols(1);
						tfROH = newTf(Double.toString(doc.getRoh()));
						add(tfROH);
						newLabel("%", Globals.TEXT_SIZE);
						
						// Eighth Row
						ClusterRohComboBox cb = new ClusterRohComboBox();
						add(cb);
						

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
						D.b("ClusterPanel.getCCSizestring(): tfCC is " + tfCC.getText());
						return tfCC.getText();
					}
				
				public String getClusterSizeString()
					
					{D.b("ClusterPanel.getClusterSizestring(): tfClusterSize is " + tfClusterSize.getText());
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

	
