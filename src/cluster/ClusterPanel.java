package cluster;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Insets;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import basesAndUtilites.D;

public class ClusterPanel extends JPanel
	{
	

	
	private static final String gbc_seperator_1 = null;
	private ClusterDoc doc = null;
	private JTextField tfPopulation;
	private JTextField tfProportion = null;
	private JTextField tfConfidenceInterval = null;
	private JTextField tfConfidencelevel = null;
	private JTextField tfClusterSize = null;
	private JTextField tfROH = null;

	// Result labels
	private JLabel lblClustersNeeded = null;
	private JLabel lblDesignEffect= null;
	private JLabel lblROH = null;

		/**
		 * Create the panel.
		 */
		public ClusterPanel(ClusterDoc doc)
			{
				this.doc = doc;

				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[] { 1, 0, 0, 0, 0, 0, 0 };
				gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 15, 0, 0, 0, 0 };
				gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
						1.0, 0.0, 0.0, 0.0 };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				setLayout(gridBagLayout);

				JLabel lblEnterYouAssumptions = new JLabel(
						"Enter You Assumptions");
				GridBagConstraints gbc_lblEnterYouAssumptions = new GridBagConstraints();
				gbc_lblEnterYouAssumptions.gridwidth = 6;
				gbc_lblEnterYouAssumptions.insets = new Insets(0, 0, 5, 5);
				gbc_lblEnterYouAssumptions.gridx = 1;
				gbc_lblEnterYouAssumptions.gridy = 0;
				add(lblEnterYouAssumptions, gbc_lblEnterYouAssumptions);

				JSeparator separator = new JSeparator();
				GridBagConstraints gbc_separator = new GridBagConstraints();
				gbc_separator.insets = new Insets(0, 0, 5, 5);
				gbc_separator.gridx = 0;
				gbc_separator.gridy = 1;
				add(separator, gbc_separator);

				JLabel lblPopulation = new JLabel("Population");
				GridBagConstraints gbc_lblPopulation = new GridBagConstraints();
				gbc_lblPopulation.anchor = GridBagConstraints.WEST;
				gbc_lblPopulation.insets = new Insets(0, 0, 5, 5);
				gbc_lblPopulation.gridx = 1;
				gbc_lblPopulation.gridy = 2;
				add(lblPopulation, gbc_lblPopulation);

				tfPopulation = new JTextField();
				tfPopulation.setText("tfPopulation goes here");
				GridBagConstraints gbc_tfPopulation = new GridBagConstraints();
				gbc_tfPopulation.insets = new Insets(0, 0, 5, 5);
				gbc_tfPopulation.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfPopulation.gridx = 3;
				gbc_tfPopulation.gridy = 2;
				add(tfPopulation, gbc_tfPopulation);
				tfPopulation.setColumns(10);

				JLabel lblProportion = new JLabel(
						"Proportion in Target Population");
				GridBagConstraints gbc_lblProportion = new GridBagConstraints();
				gbc_lblProportion.anchor = GridBagConstraints.WEST;
				gbc_lblProportion.insets = new Insets(0, 0, 5, 5);
				gbc_lblProportion.gridx = 1;
				gbc_lblProportion.gridy = 3;
				add(lblProportion, gbc_lblProportion);

				tfProportion = new JTextField();
				tfProportion.setText("proportionTf");
				GridBagConstraints gbc_tfProportion = new GridBagConstraints();
				gbc_tfProportion.insets = new Insets(0, 0, 5, 5);
				gbc_tfProportion.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfProportion.gridx = 3;
				gbc_tfProportion.gridy = 3;
				add(tfProportion, gbc_tfProportion);
				tfProportion.setColumns(10);

				JLabel lblConfidenceInterval = new JLabel(
						"Width of Confidence Interval");
				GridBagConstraints gbc_lblConfidenceInterval = new GridBagConstraints();
				gbc_lblConfidenceInterval.anchor = GridBagConstraints.WEST;
				gbc_lblConfidenceInterval.insets = new Insets(0, 0, 5, 5);
				gbc_lblConfidenceInterval.gridx = 1;
				gbc_lblConfidenceInterval.gridy = 4;
				add(lblConfidenceInterval, gbc_lblConfidenceInterval);

				JLabel lblPm = new JLabel("\u00B1"); // plus/minus signJLabel
														// lblNewLabel = new
														// JLabel(s);
				GridBagConstraints gbc_lblPm = new GridBagConstraints();
				gbc_lblPm.anchor = GridBagConstraints.EAST;
				gbc_lblPm.insets = new Insets(0, 0, 5, 5);
				gbc_lblPm.gridx = 2;
				gbc_lblPm.gridy = 4;
				add(lblPm, gbc_lblPm);

				tfConfidenceInterval = new JTextField();
				tfConfidenceInterval.setText("tfConfidenceInterval");
				GridBagConstraints gbc_tfConfidenceInterval = new GridBagConstraints();
				gbc_tfConfidenceInterval.insets = new Insets(0, 0, 5, 5);
				gbc_tfConfidenceInterval.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfConfidenceInterval.gridx = 3;
				gbc_tfConfidenceInterval.gridy = 4;
				add(tfConfidenceInterval, gbc_tfConfidenceInterval);
				tfConfidenceInterval.setColumns(10);

				JLabel lblConfidenceLevel = new JLabel("Confidence Level");
				GridBagConstraints gbc_lblConfidenceLevel = new GridBagConstraints();
				gbc_lblConfidenceLevel.anchor = GridBagConstraints.WEST;
				gbc_lblConfidenceLevel.insets = new Insets(0, 0, 5, 5);
				gbc_lblConfidenceLevel.gridx = 1;
				gbc_lblConfidenceLevel.gridy = 5;
				add(lblConfidenceLevel, gbc_lblConfidenceLevel);

				tfConfidencelevel = new JTextField();
				tfConfidencelevel.setText("tfConfidencelevel");
				GridBagConstraints gbc_tfConfidencelevel = new GridBagConstraints();
				gbc_tfConfidencelevel.insets = new Insets(0, 0, 5, 5);
				gbc_tfConfidencelevel.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfConfidencelevel.gridx = 3;
				gbc_tfConfidencelevel.gridy = 5;
				add(tfConfidencelevel, gbc_tfConfidencelevel);
				tfConfidencelevel.setColumns(10);

				JLabel label = new JLabel("%");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 4;
				gbc_label.gridy = 5;
				add(label, gbc_label);

				JLabel PercentLbl = new JLabel("");
				GridBagConstraints gbc_PercentLbl = new GridBagConstraints();
				gbc_PercentLbl.insets = new Insets(0, 0, 5, 5);
				gbc_PercentLbl.gridx = 6;
				gbc_PercentLbl.gridy = 5;
				add(PercentLbl, gbc_PercentLbl);

				JLabel lblRateOfHomogeneity = new JLabel("Rate of Homogeneity");
				GridBagConstraints gbc_lblRateOfHomogeneity = new GridBagConstraints();
				gbc_lblRateOfHomogeneity.anchor = GridBagConstraints.WEST;
				gbc_lblRateOfHomogeneity.insets = new Insets(0, 0, 5, 5);
				gbc_lblRateOfHomogeneity.gridx = 1;
				gbc_lblRateOfHomogeneity.gridy = 6;
				add(lblRateOfHomogeneity, gbc_lblRateOfHomogeneity);

				JComboBox RohcomboBox = new JComboBox();
				GridBagConstraints gbc_RohcomboBox = new GridBagConstraints();
				gbc_RohcomboBox.insets = new Insets(0, 0, 5, 5);
				gbc_RohcomboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_RohcomboBox.gridx = 3;
				gbc_RohcomboBox.gridy = 6;
				add(RohcomboBox, gbc_RohcomboBox);
				/*
				 * for separator, just make a series of drawing lines across the
				 * columns. GridBagConstraints separatorConstraint = new
				 * GridBagConstraints(); separatorConstraint.insets = new
				 * Insets(0, 0, 5, 0); separatorConstraint.gridx = 7;
				 * separatorConstraint.gridy = 0; separatorConstraint.weightx =
				 * 1.0; separatorConstraint.fill =
				 * GridBagConstraints.HORIZONTAL; separatorConstraint.gridwidth
				 * = GridBagConstraints.REMAINDER; add(new
				 * JSeparator(JSeparator.HORIZONTAL), separatorConstraint);
				 * 
				 * JSeparator separator_2 = new JSeparator(); GridBagConstraints
				 * gbc_separator_2 = new GridBagConstraints();
				 * gbc_separator_2.gridwidth = 7; gbc_separator_2.insets = new
				 * Insets(0, 0, 5, 5); gbc_separator_2.gridx = 1;
				 * gbc_separator_2.gridy = 7; add(separator_2, gbc_separator_2);
				 */
				JSeparator separator_1 = new JSeparator();
				GridBagConstraints gbc_separator_1 = new GridBagConstraints();
				gbc_separator_1.insets = new Insets(0, 0, 5, 5);
				gbc_separator_1.gridx = 1;
				gbc_separator_1.gridy = 8;
				gbc_separator.fill = JSeparator.HORIZONTAL;
				add(separator_1, gbc_separator_1);

				JLabel lblResults = new JLabel("Results");
				GridBagConstraints gbc_lblResults = new GridBagConstraints();
				gbc_lblResults.gridwidth = 5;
				gbc_lblResults.insets = new Insets(0, 0, 5, 5);
				gbc_lblResults.gridx = 1;
				gbc_lblResults.gridy = 9;
				add(lblResults, gbc_lblResults);

				JLabel lblClustersNeeded = new JLabel("Clusters Needed");
				GridBagConstraints gbc_lblClustersNeeded = new GridBagConstraints();
				gbc_lblClustersNeeded.anchor = GridBagConstraints.WEST;
				gbc_lblClustersNeeded.insets = new Insets(0, 0, 5, 5);
				gbc_lblClustersNeeded.gridx = 1;
				gbc_lblClustersNeeded.gridy = 10;
				add(lblClustersNeeded, gbc_lblClustersNeeded);

				JLabel lblClustersNeededResults = new JLabel(
						"clusters Need Goes Here");
				GridBagConstraints gbc_lblClustersNeededResults = new GridBagConstraints();
				gbc_lblClustersNeededResults.anchor = GridBagConstraints.WEST;
				gbc_lblClustersNeededResults.insets = new Insets(0, 0, 5, 5);
				gbc_lblClustersNeededResults.gridx = 3;
				gbc_lblClustersNeededResults.gridy = 10;
				add(lblClustersNeededResults, gbc_lblClustersNeededResults);

				JLabel lblDesignEffect = new JLabel("Design Effect");
				GridBagConstraints gbc_lblDesignEffect = new GridBagConstraints();
				gbc_lblDesignEffect.anchor = GridBagConstraints.WEST;
				gbc_lblDesignEffect.insets = new Insets(0, 0, 5, 5);
				gbc_lblDesignEffect.gridx = 1;
				gbc_lblDesignEffect.gridy = 11;
				add(lblDesignEffect, gbc_lblDesignEffect);

				JLabel lblDesignEffectResults = new JLabel(
						"Design Effect Goes Here");
				GridBagConstraints gbc_lblDesignEffectResults = new GridBagConstraints();
				gbc_lblDesignEffectResults.anchor = GridBagConstraints.WEST;
				gbc_lblDesignEffectResults.insets = new Insets(0, 0, 5, 5);
				gbc_lblDesignEffectResults.gridx = 3;
				gbc_lblDesignEffectResults.gridy = 11;
				add(lblDesignEffectResults, gbc_lblDesignEffectResults);

				JLabel lblTotalResponsesNeeded = new JLabel(
						"Total Responses Needed");
				GridBagConstraints gbc_lblTotalResponsesNeeded = new GridBagConstraints();
				gbc_lblTotalResponsesNeeded.anchor = GridBagConstraints.WEST;
				gbc_lblTotalResponsesNeeded.insets = new Insets(0, 0, 0, 5);
				gbc_lblTotalResponsesNeeded.gridx = 1;
				gbc_lblTotalResponsesNeeded.gridy = 12;
				add(lblTotalResponsesNeeded, gbc_lblTotalResponsesNeeded);

				JLabel lblTotalResponsesGoes = new JLabel(
						"Total Responses Goes here");
				GridBagConstraints gbc_lblTotalResponsesGoes = new GridBagConstraints();
				gbc_lblTotalResponsesGoes.anchor = GridBagConstraints.WEST;
				gbc_lblTotalResponsesGoes.insets = new Insets(0, 0, 0, 5);
				gbc_lblTotalResponsesGoes.gridx = 3;
				gbc_lblTotalResponsesGoes.gridy = 12;
				add(lblTotalResponsesGoes, gbc_lblTotalResponsesGoes);

				/*
				 * JSeparator separator_1 = new JSeparator(); GridBagConstraints
				 * gbc_separator_1 = new GridBagConstraints();
				 * gbc_separator_1.insets = new Insets(0, 0, 0, 5);
				 * //gbc_seperator_1.;// = 6; gbc_separator_1.gridx = 1;
				 * gbc_separator_1.gridy = 7; add(separator_1, gbc_separator_1);
				 */
				// Draw separator across all 4 columns
				// for (int i = 0; i < 6; i++)
				// add(new JSeparator(SwingConstants.HORIZONTAL));

				/*
				 * GridBagLayout gridBagLayout = new GridBagLayout();
				 * gridBagLayout.columnWidths = new int[]{0, 0, 0};
				 * gridBagLayout.rowHeights = new int[]{0, 0};
				 * gridBagLayout.columnWeights = new double[]{0.0, 0.0,
				 * Double.MIN_VALUE}; gridBagLayout.rowWeights = new
				 * double[]{0.0, Double.MIN_VALUE}; setLayout(gridBagLayout);
				 * 
				 * JLabel label = new JLabel("New label"); GridBagConstraints
				 * gbc_label = new GridBagConstraints(); gbc_label.gridx = 1;
				 * gbc_label.gridy = 0; add(label, gbc_label);
				 * 
				 * JLabel lblNewLabel = new JLabel("New label");
				 * add(lblNewLabel);
				 * setBorder(BorderFactory.createLineBorder(Color.black));
				 * GridBagLayout layout = new GridBagLayout();
				 * setLayout(layout);
				 * 
				 * GridBagConstraints con = new GridBagConstraints(); //public
				 * GBC(int gridx, int gridy) con.gridx = 0; con.gridy = 0;
				 * 
				 * JLabel titleLbl = new JLabel("Title"); add(titleLbl, con);
				 * GridBagConstraints con1 = new GridBagConstraints();
				 * con1.gridx = ; con1.gridy=1;
				 * 
				 * JLabel popLbl = new JLabel("Target Population"); add(popLbl,
				 * con1);
				 */

			}

		
		public String getPopulationString()
			{
				//D.b("panel:getPopString(). tfPopString is: " + tfPopulation.getText() + " "+ tfPopulation);
				return tfPopulation.getText();
			}


		public String getProportionString()
			{
				return tfProportion.getText();
			}



		public String getConfidenceIntervalString()
			{
						return tfConfidenceInterval.getText();
			}

		public void setTfConfidenceInterval(JTextField tfConfidenceInterval)
			{
				this.tfConfidenceInterval = tfConfidenceInterval;
			}

		public String getConfidenceLevelString()
			{
				return tfConfidencelevel.getText();
			}

		public void setTfConfidencelevel(JTextField tfConfidencelevel)
			{
				this.tfConfidencelevel = tfConfidencelevel;
			}

		public JTextField getTfClusterSize()
			{
				return tfClusterSize;
			}

		public void setTfClusterSize(JTextField tfClusterSize)
			{
				this.tfClusterSize = tfClusterSize;
			}

		public JTextField getTfROH()
			{
				return tfROH;
			}

		public void setTfROH(JTextField tfROH)
			{
				this.tfROH = tfROH;
			}

		public JLabel getLblClustersNeeded()
			{
				return lblClustersNeeded;
			}

		public void setLblClustersNeeded(double d)
			{
				lblClustersNeeded.setText(Double.toString(d));
			}

		public JLabel getLblDesignEffect()
			{
				return lblDesignEffect;
			}

		public void setLblDesignEffect(double d)
			{
				lblDesignEffect.setText(Double.toString(d));
			}

		public JLabel getLblROH()
			{
				return lblROH;
			}

		public void setLblROH(double d)
			{
				this.lblROH.setText(Double.toString(d));
			}
		public String getClusterSizeString()
		
			{
				//D.b("ClusterPanel.getClusterSizestring(): tfClusterSize is " + tfClusterSize.getText());
				return tfClusterSize.getText();
				
			}
		
		public String getROHString()
			{
				return tfROH.getText();
			}

		

	}
