package srs;

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

import basesAndUtilites.D;
import basesAndUtilites.GlobalConstants;
import basesAndUtilites.RSInternalFrame;
import basesAndUtilites.RSVariations;

/**
 * Holds data and calculates values for chart. Gets values to calculate from
 * RSVariations then calls SRSCalculator to find populations needed. Values come
 * in an array of doubles. Converts these to strings of in the form of XX.XX
 * which are used by chart to draw x axis.
 * 
 * @author markofzero
 * 
 */
public class SRSChartDoc
	{
		// private SRSDoc doc = null;
		
		private JDesktopPane desktop = null;
		JFreeChart Chart = null;
		SRSTabbedChartPanel tabby = null;
		private double population = 0;
		private double proportion = 0;
		private double confidenceInterval = 0;
		private double confidenceLevel = 0;
		private String choice = null;
	//	private int Globals. = Globals.COLS;
		

		// JPanel proportionsPanel = null;

		//private int cols = 11; // Number of columns in chart.

				public SRSChartDoc(JDesktopPane desktop, double population, double proportion, double confidenceInterval, double confidenceLevel, String choice)
			{
				// this.doc = doc; doesn't seem to work. Don't know why. desktop
				// = doc.getDesktop();

				// set fields/class vars
				this.desktop = desktop;
				this.population = population;
				this.proportion = proportion;
				this.confidenceInterval = confidenceInterval;
				this.confidenceLevel = confidenceLevel;
				this.choice = new String(choice); // create a new string to be
													// sure the argument doesn't
													// disappear somewhere.

				this.desktop = desktop;
			//	if ("srs".equals(choice))
				//	;
			//	// D.b("In RSChartDoc constructor. confidenceConfidencient is " + confidenceLevel);
			//	// D.b("In RSChartDoc constructor. Choice is " + choice);
				createChartFrame();

			}

		// Create a new internal frame.
		public void createChartFrame()
			{
				// RSCategoryDataset dataClass = new RSCategoryDataset();
				// CategoryDataset dataset = dataClass.createDataset();

				final RSInternalFrame chartFrame = new RSInternalFrame("Charts");
			

				
				Dimension d = desktop.getSize();
				//chartFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				//chartFrame.setSize(d); // was 1000,700. 700, 500 seem to be the default.
				chartFrame.setSize(1100,800);
				tabby = new SRSTabbedChartPanel(this);

				chartFrame.add(tabby);
			/*	JPanel testPanel = new JPanel();
				JLabel label  = new JLabel("Eat shit");
				testPanel.add(label);
				testPanel.setBorder(BorderFactory.createLineBorder(Color.black));


				chartFrame.add(testPanel);
				*/
				
				JPanel buttonPanel = new JPanel();
				
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, GlobalConstants.TEXT_SIZE));
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
						// D.b("Reached createPopulationPane()");
						
						
						double[] variedAssumption = RSVariations.multiplyByLogs(population);

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						for (int i = 0; i < GlobalConstants.COLS; i++)
							{
								SRSCalculator.calculate(variedAssumption[i], proportion, confidenceInterval, confidenceLevel);
								double value = SRSCalculator.getN();
								// dataset(double value, String rowLabel, String columnLabel)
								double columnLabel = variedAssumption[i];
								 
								if (columnLabel > 10000)
									{	
										DecimalFormat myFormatter = new DecimalFormat("#.E0");
										String s = myFormatter.format(columnLabel);
										dataset.addValue(value, "population", s);
									} else
										dataset.addValue(value, "population", Double.toString(variedAssumption[i]));
									
								
								
								// D.b("xLabelArray[" + i + "] is " + variedAssumption[i]);
								//// D.b("dataset[" + i + "] is " + darray[i] );
							}
						
						JFreeChart chart = createChart(dataset);
						//chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle("Effect of Size of Target Population on Sample Size."));
						CategoryPlot plot = (CategoryPlot) chart.getPlot();
					    CategoryAxis xAxis = plot.getDomainAxis();
					    xAxis.setLabel("Population");
					    ValueAxis yAxis = plot.getRangeAxis();
					    yAxis.setLabel("Sample Size Needed");
					    TextTitle source = new TextTitle("Scientific notation shows numbers multiplied by 10.    \n"
					    		+ "The number after the \'E\' is the number of trailing zeros.  \nExamples: 100 is 1.E2,"
					    		+ " 1,000 is 1.E3, and 40,000 is 4.E4.  ");
						source.setFont(new Font("SansSerif", Font.PLAIN, 12));
						source.setPosition(RectangleEdge.BOTTOM);
						source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
						chart.addSubtitle(source);

						return new ChartPanel(chart);
					}
			}

		protected JPanel createProportionsPanel()
			{
				JPanel panel = new JPanel();

					// First, let's do proportion

					// assumption is proportion
					{
						
						double[] variedAssumption = RSVariations.proportion(proportion);
						
						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						
						for (int i = 0; i < GlobalConstants.COLS; i++)
							{
								SRSCalculator.calculate(population, variedAssumption[i], confidenceInterval, confidenceLevel);
								double sampleSize = SRSCalculator.getN();
								
								double columnLabel = variedAssumption[i];		
								DecimalFormat myFormatter = new DecimalFormat(
										"#.##");
								String s = myFormatter
										.format(columnLabel);
								dataset.addValue(sampleSize,
										"confidenceLevel", s);
						//	  D.
								
								// dataset(double value, String rowLabel, String columnLabel)			
							//	dataset.addValue(sampleSize, "proportion", Double.toString(variedAssumption[i]));
								// D.b("xLabelArray[" + i + "] is " + variedAssumption[i]);
								//// D.b("dataset[" + i + "] is " + darray[i] );
							}
						
						JFreeChart chart = createChart(dataset);
						//chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle("Effect of Target Population Proportions on Sample Size."));
						CategoryPlot plot = (CategoryPlot) chart.getPlot();
					    CategoryAxis xAxis = plot.getDomainAxis();
					    xAxis.setLabel("Proportion");
					    ValueAxis yAxis = plot.getRangeAxis();
					    yAxis.setLabel("Sample Size Needed");
						return new ChartPanel(chart);
					}
			}

		protected JPanel createConfidenceIntervalPanel()
			{
				JPanel panel = new JPanel();

					// First, let's do proportion

					// assumption is proportion
					{
						
						double[] variedAssumption = RSVariations.confidenceInterval(confidenceInterval);

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);
						
						D.b("/************** Reached createConficenceInterval****************/");

						for (int i = 0; i < GlobalConstants.COLS; i++)
							{
								
								SRSCalculator.calculate(population, proportion, variedAssumption[i], confidenceLevel);
								double value = SRSCalculator.getN();			
								//dataset.addValue(value, "confidenceInterval", "\u00B1" + Double.toString( variedAssumption[i])); // padd lus/minus sign
							
								double columnLabel = variedAssumption[i];
								DecimalFormat myFormatter = new DecimalFormat(
										"#.##");
								String s = "\u00B1" + myFormatter
										.format(columnLabel);
								
								dataset.addValue(value, "Clusters Needed",  s);
								
								
							}
						
						JFreeChart chart = createChart(dataset);
						//chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle("Effect of Width of Confidence Interval on Sample Size."));
						CategoryPlot plot = (CategoryPlot) chart.getPlot();
					    CategoryAxis xAxis = plot.getDomainAxis();
					    xAxis.setLabel("Width of Confidence Interval");
					    ValueAxis yAxis = plot.getRangeAxis();
					    yAxis.setLabel("Sample Size Needed");
						return new ChartPanel(chart);
					}
			}

		protected JPanel createConfidenceLevelPanel()
			{
				JPanel panel = new JPanel();

					// First, let's do proportion

					// assumption is proportion
					{

						double[] variedAssumption = RSVariations
								.confidenceLevel(confidenceLevel);

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						for (int i = 0; i < GlobalConstants.COLS; i++)
							{

								// dataset.addValue(value, "population", s);
								SRSCalculator
										.calculate(population, proportion,
												confidenceInterval,
												variedAssumption[i]);
								double value = SRSCalculator.getN();

								double columnLabel = variedAssumption[i];

								if (columnLabel > GlobalConstants.CONFIDENCE_LEVEL_MIN)
									{
										DecimalFormat myFormatter = new DecimalFormat(
												"#.##");
										String s = myFormatter
												.format(columnLabel);
										dataset.addValue(value,
												"confidenceLevel", s);
									} else
									dataset.addValue(
											value,
											"confidenceLevel",
											Double.toString(variedAssumption[i]));

						//		D.b("SSChartDoc.createConfdenceLevel: i is "
							//			+ i + " columnLabel is " + columnLabel);
							}

						JFreeChart chart = createChart(dataset);
						// chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle(
								"Effect of Confidence Level on Sample Size."));
						CategoryPlot plot = (CategoryPlot) chart.getPlot();
						CategoryAxis xAxis = plot.getDomainAxis();
						xAxis.setLabel("Confidence Level");
						ValueAxis yAxis = plot.getRangeAxis();
						yAxis.setLabel("Sample Size Needed");
						return new ChartPanel(chart);
					}
			}
			

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

			//	chart.addSubtitle(new TextTitle("Number of Classes By Release"));
			//	TextTitle source = new TextTitle("Source: Java In A Nutshell (5th Edition) " + "by David Flanagan (O'Reilly)");
			//	source.setFont(new Font("SansSerif", Font.PLAIN, 10));
			//	source.setPosition(RectangleEdge.BOTTOM);
			//	source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			//	chart.addSubtitle(source);

				CategoryPlot plot = (CategoryPlot) chart.getPlot();
				plot.setRangePannable(true);
				plot.setRangeGridlinesVisible(false);
			
				
				// customise the range axis...
				 
				 
				NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
				rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

				ChartUtilities.applyCurrentTheme(chart);

				// customise the renderer...
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
				renderer.setBaseShapesVisible(true);
				renderer.setDrawOutlines(true);
				renderer.setUseFillPaint(true);
				renderer.setBaseFillPaint(Color.white);
				renderer.setSeriesStroke(0, new BasicStroke(3.0f));
				renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0f));
				renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));
				return chart;
			}

		/********************** Getters and Setters ************/
		/*
		 * protected JPanel getProportionsPanel() { return proportionsPanel; }
		 */

		/********* end Getters and Setters *********/

	}
