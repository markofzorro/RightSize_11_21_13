package charts;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

import basesAndUtilites.ClusterCalculator;
import basesAndUtilites.D;
import basesAndUtilites.Globals;
import basesAndUtilites.RSInternalFrame;
import basesAndUtilites.RSVariations;
import cluster.ClusterDoc;

public class ClusterChartDoc
	{
		// private SRSDoc doc = null;

		private JDesktopPane desktop = null;
		private final ClusterDoc doc;
		JFreeChart Chart = null;
		ClusterTabbedChartPanel tabby = null;
		private double population = 0;
		private double proportion = 0;
		private double confidenceInterval = 0;
		private double confidenceCoefficient = 0;
		private double clusterSize = 0;
		private double clustersNeeded = 0;
		private double roh = 0;
		private double designEffect = 0;

		public ClusterChartDoc(ClusterDoc doc)
			{
				D.b("Reached ClusterChartDoc Constructor");

				// set fields/class vars
				this.doc = doc;
				this.desktop = doc.getDesktop();
				this.population = doc.getPopulation();
				this.proportion = doc.getProportion();
				this.confidenceInterval = doc.getConfidenceInterval();
				this.confidenceCoefficient = doc.getConfidenceCoefficient();
				this.clusterSize = doc.getClusterSize();
				this.roh = doc.getRoh();
				this.designEffect = doc.getDesignEffect();

				createChartFrame();

			}

		// Create a new internal frame.
		public void createChartFrame()
			{
				// RSCategoryDataset dataClass = new RSCategoryDataset();
				// CategoryDataset dataset = dataClass.createDataset();

				final RSInternalFrame chartFrame = new RSInternalFrame("Charts");

				Dimension d = desktop.getSize();
				// chartFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				// chartFrame.setSize(d); // was 1000,700. 700, 500 seem to be
				// the default.
				chartFrame.setSize(1000, 700);
				tabby = new ClusterTabbedChartPanel(this);

				chartFrame.add(tabby);
				/*
				 * JPanel testPanel = new JPanel(); JLabel label = new
				 * JLabel("Eat shit"); testPanel.add(label);
				 * testPanel.setBorder(
				 * BorderFactory.createLineBorder(Color.black));
				 * 
				 * 
				 * chartFrame.add(testPanel);
				 */

				JPanel buttonPanel = new JPanel();

				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new java.awt.Font("Lucida Grande", 0,
						Globals.TEXT_SIZE));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
						{
							chartFrame.dispose();
							// System.out.println("OK button Clicked.");
						}
				});
				cancelButton.setVisible(true);
				buttonPanel.add(cancelButton);
				buttonPanel.setVisible(true);
				chartFrame.add(buttonPanel, BorderLayout.SOUTH);

				// createDataset();
				// createChartPanels();

				// varyAssumption
				desktop.add(chartFrame);
				chartFrame.setVisible(true); // necessary as of 1.3
				// desktop.add(frame);
				try
					{
						chartFrame.setSelected(true);
					} catch (java.beans.PropertyVetoException e)
					{
					}

			}

		protected JPanel createPopulatonPanel()
			{
				JPanel panel = new JPanel();

					{
						D.b("Reached createPopulationPane()");

						double[] variedAssumption = RSVariations
								.multiplyByLogs(population);

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						for (int i = 0; i < Globals.COLS; i++)
							{
								ClusterCalculator.calculate(
										variedAssumption[i], proportion,
										confidenceInterval,
										confidenceCoefficient, clusterSize,
										roh);
								double value = ClusterCalculator
										.getClustersNeeded();
								// dataset(double value, String rowLabel, String
								// columnLabel)
								double columnLabel = variedAssumption[i];

								if (columnLabel > 10000)
									{
										DecimalFormat myFormatter = new DecimalFormat(
												"#.E0");
										String s = myFormatter
												.format(columnLabel);
										dataset.addValue(value, "population", s);
									} else
									dataset.addValue(
											value,
											"population",
											Double.toString(variedAssumption[i]));

								// D.b("xLabelArray[" + i + "] is " +
								// variedAssumption[i]);
								// D.b("dataset[" + i + "] is " + darray[i] );
							}

						JFreeChart chart = createChart(dataset);
						// chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle(
								"Effect of Size of Target Population on Sample Size."));
						CategoryPlot plot = (CategoryPlot) chart.getPlot();
						CategoryAxis xAxis = plot.getDomainAxis();
						xAxis.setLabel("Population");
						ValueAxis yAxis = plot.getRangeAxis();
						yAxis.setLabel("Clusters Needed");
						TextTitle source = new TextTitle(
								"Scientific notation shows numbers multiplied by 10.    \nThe number after the \'E\' is the number of trailing zeros.  \nExamples: 100 is 1E2, 1000 is 1E3, and 50,000 is 5E4.  ");
						source.setFont(new Font("SansSerif", Font.PLAIN, 12));
						source.setPosition(RectangleEdge.BOTTOM);
						source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
						chart.addSubtitle(source);

						return new ChartPanel(chart);
					}
			}

		
		 protected JPanel createProportionsPanel() 
			 { JPanel panel = new
		 JPanel();
		  
		  // First, let's do proportion
		  
		  // assumption is proportion {
		  
		  double[] variedAssumption = RSVariations.add(proportion);
		  
		  // create the dataset... 
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		  
		  // dataset.addValue(1.0, series1, type1);
		  
		  for (int i = 0; i < Globals.COLS; i++) 
			  {
				  
				  ClusterCalculator.calculate(
							population, variedAssumption[i],
							confidenceInterval,
							confidenceCoefficient, clusterSize,
							roh);
				  
				  double value = ClusterCalculator.getClustersNeeded();
				  
		   // dataset(double value, String rowLabel, String columnLabel) 
				  dataset.addValue(value, "proportion",
		  Double.toString(variedAssumption[i])); 
				 // D.b("xLabelArray[" + i +"] is " + variedAssumption[i]);
		  
		  
		  //D.b("dataset[" + i + "] is " +
		  //darray[i] ); 
		  
			  }
		  
		  JFreeChart chart = createChart(dataset);
		  //chart.setTitle("Proportion Title"); 
		  chart.setTitle(new
		  TextTitle("Effect of Target Population Proportions on Sample Size."
		  )); 
		  CategoryPlot plot = (CategoryPlot) chart.getPlot(); CategoryAxis
		  xAxis = plot.getDomainAxis(); xAxis.setLabel("Proportion"); ValueAxis
		  yAxis = plot.getRangeAxis(); yAxis.setLabel("Clusters Needed");
		  return new ChartPanel(chart); 
		  
			 } 
		 

		protected JPanel createConfidenceIntervalPanel()
			{
				JPanel panel = new JPanel();

				// First, let's do proportion

				// assumption is proportion {

				double[] variedAssumption = RSVariations
						.add(confidenceInterval);

				// create the dataset...
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();

				// dataset.addValue(1.0, series1, type1);

				for (int i = 0; i < Globals.COLS; i++)
					{
						ClusterCalculator.calculate(population, proportion,
								variedAssumption[i], confidenceCoefficient,
								clusterSize, roh);

						double clustersNeeded = ClusterCalculator
								.getClustersNeeded();

						dataset.addValue(clustersNeeded, "Confidence Interval",
								"\u00B1" + Double.toString(variedAssumption[i]));

						// dataset.addValue(clustersNeeded,
						// "confidenceInterval", "\u00B1" +
						// Double.toString( variedAssumption[i])); // padd
						// lus/minus sign

					}

				JFreeChart chart = createChart(dataset);
				chart.setTitle(new TextTitle(
						"Effect of Width of Confidence Interval on Sample Size."));
				CategoryPlot plot = (CategoryPlot) chart.getPlot();
				CategoryAxis xAxis = plot.getDomainAxis();
				xAxis.setLabel("Width of Confidence Interval");
				ValueAxis yAxis = plot.getRangeAxis();
				yAxis.setLabel("Clusters Needed");
				
				return new ChartPanel(chart);

			} // createconfidenceIntervalPanel?
		 
		 
/* 
		 * protected JPanel createConfidenceCoefficientPanel() { JPanel panel =
		 * new JPanel();
		 * 
		 * // First, let's do proportion
		 * 
		 * // assumption is proportion {
		 * 
		 * double[] variedAssumption = RSVariations.add(confidenceCoefficient);
		 * 
		 * // create the dataset... DefaultCategoryDataset dataset = new
		 * DefaultCategoryDataset();
		 * 
		 * // dataset.addValue(1.0, series1, type1);
		 * 
		 * for (int i = 0; i < Globals.COLS; i++) {
		 * ClusterCalculator.calculate(population, proportion,
		 * confidenceInterval, variedAssumption[i]); double value =
		 * ClusterCalculator.getN(); dataset.addValue(value,
		 * "confidenceCoefficient", Double.toString( variedAssumption[i])); }
		 * 
		 * JFreeChart chart = createChart(dataset);
		 * //chart.setTitle("Proportion Title"); chart.setTitle(new
		 * TextTitle("Effect of Confidence Coefficient on Sample Size."));
		 * CategoryPlot plot = (CategoryPlot) chart.getPlot(); CategoryAxis
		 * xAxis = plot.getDomainAxis();
		 * xAxis.setLabel("Confidence Coefficient"); ValueAxis yAxis =
		 * plot.getRangeAxis(); yAxis.setLabel("Sample Size Needed"); return new
		 * ChartPanel(chart); } }
		 */
		  
		  
		  
		/**
		 * Creates a sample chart.
		 * 
		 * @param dataset
		 *            a dataset.
		 * 
		 * @return The chart.
		 */
		private static JFreeChart createChart(CategoryDataset dataset)
			{

				// create the chart...
				JFreeChart chart = ChartFactory.createLineChart("Title", // chart
																			// title
						null, // X Axis Label or domain axis label
						null, // Y or range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						false, // include legend
						true, // tooltips
						false // urls
						);

				// chart.addSubtitle(new
				// TextTitle("Number of Classes By Release"));
				// TextTitle source = new
				// TextTitle("Source: Java In A Nutshell (5th Edition) " +
				// "by David Flanagan (O'Reilly)");
				// source.setFont(new Font("SansSerif", Font.PLAIN, 10));
				// source.setPosition(RectangleEdge.BOTTOM);
				// source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
				// chart.addSubtitle(source);

				CategoryPlot plot = (CategoryPlot) chart.getPlot();
				plot.setRangePannable(true);
				plot.setRangeGridlinesVisible(false);

				// customise the range axis...

				NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
				rangeAxis.setStandardTickUnits(NumberAxis
						.createIntegerTickUnits());

				ChartUtilities.applyCurrentTheme(chart);

				// customise the renderer...
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
						.getRenderer();
				renderer.setBaseShapesVisible(true);
				renderer.setDrawOutlines(true);
				renderer.setUseFillPaint(true);
				renderer.setBaseFillPaint(Color.white);
				renderer.setSeriesStroke(0, new BasicStroke(3.0f));
				renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0f));
				renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0, -5.0,
						10.0, 10.0));
				return chart;
			}

		/********************** Getters and Setters ************/
		/*
		 * protected JPanel getProportionsPanel() { return proportionsPanel; }
		 */

		/********* end Getters and Setters *********/

	}
