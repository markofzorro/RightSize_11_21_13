package cluster;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import basesAndUtilites.D;
import basesAndUtilites.Globals;

public class ClusterPanel extends JPanel
	{
	

	
	//private static final String gbc_seperator_1 = null;
	private ClusterDoc doc = null;
	private JTextField tfPopulation;
	private JTextField tfProportion = null;
	private JTextField tfConfidenceInterval = null;
	private JTextField tfConfidencelevel = null;
	private JTextField tfClusterSize = null;
	private String rohString= null;

	// Result labels
//	private JLabel lblClustersNeeded = null;
//	private JLabel lblDesignEffect= null;
	//private JLabel lblROH = null;
	
	private JLabel lblClustersNeededResult = null;
	private JLabel lblTotalResponsesNeededResult = null;
	private JLabel lblDesignEffectResult = null;
	//private JLabel lblTotalResponsesNeededResult = null;
	
	
	
	

		/**
		 * Create the panel.
		 */
		public ClusterPanel(ClusterDoc doc)
			{
				this.doc = doc;

				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[] { 1, 0, 0, 0, 0, 0, 0 };
				gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 15, 0, 0, 0, 0 };
				gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
						1.0, 0.0, 0.0, 0.0 };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				setLayout(gridBagLayout);

				JLabel lblEnterYouAssumptions = new JLabel(
						"Enter You Assumptions");
				lblEnterYouAssumptions.setFont(new java.awt.Font("Lucida Grande", 1, Globals.TITLE_SIZE)); // NOI18N
				GridBagConstraints gbc_lblEnterYouAssumptions = new GridBagConstraints();
				gbc_lblEnterYouAssumptions.gridwidth = 6;
				gbc_lblEnterYouAssumptions.insets = new Insets(0, 0, 5, 0);
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
				tfPopulation.setText("1000");
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
				tfProportion.setText("50");
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
				tfConfidenceInterval.setText("10");
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
				tfConfidencelevel.setText("95");
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
				gbc_PercentLbl.insets = new Insets(0, 0, 5, 0);
				gbc_PercentLbl.gridx = 6;
				gbc_PercentLbl.gridy = 5;
				add(PercentLbl, gbc_PercentLbl);

				JLabel lblDesiredClusterSize = new JLabel(
						"Desired Cluster Size");
				GridBagConstraints gbc_lblDesiredClusterSize = new GridBagConstraints();
				gbc_lblDesiredClusterSize.anchor = GridBagConstraints.WEST;
				gbc_lblDesiredClusterSize.insets = new Insets(0, 0, 5, 5);
				gbc_lblDesiredClusterSize.gridx = 1;
				gbc_lblDesiredClusterSize.gridy = 6;
				add(lblDesiredClusterSize, gbc_lblDesiredClusterSize);

				tfClusterSize = new JTextField();
				tfClusterSize.setText("10");
				GridBagConstraints gbc_txttfClusterSize = new GridBagConstraints();
				gbc_txttfClusterSize.insets = new Insets(0, 0, 5, 5);
				gbc_txttfClusterSize.fill = GridBagConstraints.HORIZONTAL;
				gbc_txttfClusterSize.gridx = 3;
				gbc_txttfClusterSize.gridy = 6;
				add(tfClusterSize, gbc_txttfClusterSize);
				tfClusterSize.setColumns(10);
				
				JLabel lblRateOfHomogeneity = new JLabel("Rate of Homogeneity");
				GridBagConstraints gbc_lblRateOfHomogeneity = new GridBagConstraints();
				gbc_lblRateOfHomogeneity.anchor = GridBagConstraints.WEST;
				gbc_lblRateOfHomogeneity.insets = new Insets(0, 0, 5, 5);
				gbc_lblRateOfHomogeneity.gridx = 1;
				gbc_lblRateOfHomogeneity.gridy = 7;
				add(lblRateOfHomogeneity, gbc_lblRateOfHomogeneity);

				// Set default value for roh
				rohString = "0.02";
				ClusterRohComboBox clusterRohComboBox = new ClusterRohComboBox(
						this);
				GridBagConstraints gbc_clusterRohComboBox = new GridBagConstraints();
				gbc_clusterRohComboBox.anchor = GridBagConstraints.EAST;
				gbc_clusterRohComboBox.insets = new Insets(0, 0, 5, 5);
				gbc_clusterRohComboBox.fill = GridBagConstraints.VERTICAL;
				gbc_clusterRohComboBox.gridx = 3;
				gbc_clusterRohComboBox.gridy = 7;
				add(clusterRohComboBox, gbc_clusterRohComboBox);

				/**************** Results ************************/

				
				
				JLabel lblResults = new JLabel("Results");
				lblResults.setFont(new java.awt.Font("Lucida Grande", 1, Globals.TITLE_SIZE)); // NOI18N
				GridBagConstraints gbc_lblResults = new GridBagConstraints();
				gbc_lblResults.gridwidth = 5;
				gbc_lblResults.insets = new Insets(0, 0, 5, 5);
				gbc_lblResults.gridx = 1;
				gbc_lblResults.gridy = 10;
				add(lblResults, gbc_lblResults);

				JLabel lblClustersNeeded = new JLabel("Clusters Needed");
				GridBagConstraints gbc_lblClustersNeeded = new GridBagConstraints();
				gbc_lblClustersNeeded.anchor = GridBagConstraints.WEST;
				gbc_lblClustersNeeded.insets = new Insets(0, 0, 5, 5);
				gbc_lblClustersNeeded.gridx = 1;
				gbc_lblClustersNeeded.gridy = 11;
				add(lblClustersNeeded, gbc_lblClustersNeeded);

				lblClustersNeededResult = new JLabel("");
			//	D.b("ClusterPanel: getClustersNeeded(); returns: " + doc.getClustersNeeded());
				GridBagConstraints gbc_lblClustersNeededResults = new GridBagConstraints();
				gbc_lblClustersNeededResults.anchor = GridBagConstraints.WEST;
				gbc_lblClustersNeededResults.insets = new Insets(0, 0, 5, 5);
				gbc_lblClustersNeededResults.gridx = 3;
				gbc_lblClustersNeededResults.gridy = 11;
				add(lblClustersNeededResult, gbc_lblClustersNeededResults);

				JLabel lblDesignEffect = new JLabel("Design Effect");
				GridBagConstraints gbc_lblDesignEffect = new GridBagConstraints();
				gbc_lblDesignEffect.anchor = GridBagConstraints.WEST;
				gbc_lblDesignEffect.insets = new Insets(0, 0, 5, 5);
				gbc_lblDesignEffect.gridx = 1;
				gbc_lblDesignEffect.gridy = 12;
				add(lblDesignEffect, gbc_lblDesignEffect);

				lblDesignEffectResult = new JLabel(
						"");
				GridBagConstraints gbc_lblDesignEffectResults = new GridBagConstraints();
				gbc_lblDesignEffectResults.anchor = GridBagConstraints.WEST;
				gbc_lblDesignEffectResults.insets = new Insets(0, 0, 5, 5);
				gbc_lblDesignEffectResults.gridx = 3;
				gbc_lblDesignEffectResults.gridy = 12;
				add(lblDesignEffectResult, gbc_lblDesignEffectResults);

				lblTotalResponsesNeededResult = new JLabel("Total Responses Needed");
				GridBagConstraints gbc_lblTotalResponsesNeeded = new GridBagConstraints();
				gbc_lblTotalResponsesNeeded.anchor = GridBagConstraints.WEST;
				gbc_lblTotalResponsesNeeded.insets = new Insets(0, 0, 0, 5);
				gbc_lblTotalResponsesNeeded.gridx = 1;
				gbc_lblTotalResponsesNeeded.gridy = 13;
				add(lblTotalResponsesNeededResult, gbc_lblTotalResponsesNeeded);

				lblTotalResponsesNeededResult = new JLabel(
						"");
				GridBagConstraints gbc_lblTotalResponsesNeededResult = new GridBagConstraints();
				gbc_lblTotalResponsesNeededResult.anchor = GridBagConstraints.WEST;
				gbc_lblTotalResponsesNeededResult.insets = new Insets(0, 0, 0, 5);
				gbc_lblTotalResponsesNeededResult.gridx = 3;
				gbc_lblTotalResponsesNeededResult.gridy = 13;
				add(lblTotalResponsesNeededResult, gbc_lblTotalResponsesNeededResult);

				
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

		
		public String getConfidenceLevelString()
			{
				return tfConfidencelevel.getText();
			}

		
		public void setLblClustersNeededResult(double d)
			{
				DecimalFormat df = new DecimalFormat("#");
		        String s = df.format(d);
				lblClustersNeededResult.setText(s);
			}

		
		public void setDesignEffect(double d)
			{
				 DecimalFormat df = new DecimalFormat("#.##");
			        //System.out.print(df.format(d));
			        String s = df.format(d);
			        lblDesignEffectResult.setText(s);
			}

		public void setTotalResponsesNeededResult(double d)
			{
				DecimalFormat df = new DecimalFormat("#");
		        String s = df.format(d);
				
				lblTotalResponsesNeededResult.setText(s);
			}
		
		public void setRohString(String arg_rohString)
			{
				rohString = arg_rohString;
			}
		public String getClusterSizeString()
		
			{
		//		D.b("ClusterPanel.getClusterSizestring(): tfClusterSize is " + tfClusterSize.getText());
				return tfClusterSize.getText();
				
			}
		
		public String getROHString()
			{
				D.b("ClusterPanel.getRohString: rohString is " + rohString);
				return rohString;
			}


		public void setRohString(double d)
			{
				rohString = Double.toString(d);
				
			}

		

	}
