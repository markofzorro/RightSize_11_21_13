package charts;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

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

import basesAndUtilites.D;
import basesAndUtilites.Globals;
import basesAndUtilites.RSCalculator;
import basesAndUtilites.RSInternalFrame;
import basesAndUtilites.RSLogVariations;
import basesAndUtilites.RSVariations;

public class RSChartDoc
	{
		// private SRSDoc doc = null;
		
		private JDesktopPane desktop = null;
		JFreeChart Chart = null;
		RSTabbedChartPanel tabby = null;
		private double population = 0;
		private double proportion = 0;
		private double confidenceInterval = 0;
		private double confidenceCoefficient = 0;
		private String choice = null;
		private int cols = Globals.COLS;
		

		// JPanel proportionsPanel = null;

		//private int cols = 11; // Number of columns in chart.

				public RSChartDoc(JDesktopPane desktop, double population, double proportion, double confidenceInterval, double confidenceCoefficient, String choice)
			{
				// this.doc = doc; doesn't seem to work. Don't know why. desktop
				// = doc.getDesktop();

				// set fields/class vars
				this.desktop = desktop;
				this.population = population;
				this.proportion = proportion;
				this.confidenceInterval = confidenceInterval;
				this.confidenceCoefficient = confidenceCoefficient;
				this.choice = new String(choice); // create a new string to be
													// sure the argument doesn't
													// disappear somewhere.

				this.desktop = desktop;
				if ("srs".equals(choice))
					;
			//	D.b("In RSChartDoc constructor. confidenceConfidencient is " + confidenceCoefficient);
			//	D.b("In RSChartDoc constructor. Choice is " + choice);
				createChartFrame();

			}

		// Create a new internal frame.
		public void createChartFrame()
			{
				// RSCategoryDataset dataClass = new RSCategoryDataset();
				// CategoryDataset dataset = dataClass.createDataset();

				final RSInternalFrame chartFrame = new RSInternalFrame("Charts");
				chartFrame.setLayout(new BorderLayout());
				//chartFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				chartFrame.setSize(800, 700);
				tabby = new RSTabbedChartPanel(this);

				chartFrame.add(tabby, BorderLayout.NORTH);

				
				JPanel buttonPanel = new JPanel();
				
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, Globals.TEXT_SIZE));
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

		/*
		 * CategoryDataset createDataset() { CategoryDataset dataset =
		 * varyAssumptions(); return dataset; }
		 */

		// JFreeChart chart = createChart(createDataset());
		private void createChartPanels()
			{

				// JPanel panel = new JPanel();

				// Now add the panels to tabbed panel
			//	JPanel proportionPanel = createProportionsPanel();

			}
		protected JPanel createPopulatonPanel()
			{
				JPanel panel = new JPanel();
					
					{
						D.b("Reached createPopulationPane()");
						double[] variedAssumption = RSLogVariations.add();

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						for (int i = 0; i < cols; i++)
							{
								RSCalculator.calculate(population, variedAssumption[i], confidenceInterval, confidenceCoefficient);
								double value = RSCalculator.getN();
								// dataset(double value, String rowLabel, String columnLabel)			
								dataset.addValue(value, "population", Double.toString(variedAssumption[i]));
								D.b("xLabelArray[" + i + "] is " + variedAssumption[i]);
								//D.b("dataset[" + i + "] is " + darray[i] );
							}
						
						JFreeChart chart = createChart(dataset);
						//chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle("Effect of Estimates of Proportions on Sample Size."));
						CategoryPlot plot = (CategoryPlot) chart.getPlot();
					    CategoryAxis xAxis = plot.getDomainAxis();
					    xAxis.setLabel("Population");
					    ValueAxis yAxis = plot.getRangeAxis();
					    yAxis.setLabel("Sample Size Needed");
						return new ChartPanel(chart);
					}
			}

		protected JPanel createProportionsPanel()
			{
				JPanel panel = new JPanel();

					// First, let's do proportion

					// assumption is proportion
					{
						
						double[] variedAssumption = RSVariations.add(proportion, cols);

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						for (int i = 0; i < cols; i++)
							{
								RSCalculator.calculate(population, variedAssumption[i], confidenceInterval, confidenceCoefficient);
								double value = RSCalculator.getN();
								// dataset(double value, String rowLabel, String columnLabel)			
								dataset.addValue(value, "proportion", Double.toString(variedAssumption[i]));
								D.b("xLabelArray[" + i + "] is " + variedAssumption[i]);
								//D.b("dataset[" + i + "] is " + darray[i] );
							}
						
						JFreeChart chart = createChart(dataset);
						//chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle("Effect of Estimates of Proportions on Sample Size."));
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
						
						double[] variedAssumption = RSVariations.add(confidenceInterval, cols);

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						for (int i = 0; i < cols; i++)
							{
								RSCalculator.calculate(population, proportion, variedAssumption[i], confidenceCoefficient);
								double value = RSCalculator.getN();			
								dataset.addValue(value, "confidenceInterval", "\u00B1" + Double.toString( variedAssumption[i])); // padd lus/minus sign
							
								
							}
						
						JFreeChart chart = createChart(dataset);
						//chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle("Effect of Estimated Width of Confidence Interval on Sample Size."));
						CategoryPlot plot = (CategoryPlot) chart.getPlot();
					    CategoryAxis xAxis = plot.getDomainAxis();
					    xAxis.setLabel("Width of Confidence Interval");
					    ValueAxis yAxis = plot.getRangeAxis();
					    yAxis.setLabel("Sample Size Needed");
						return new ChartPanel(chart);
					}
			}

		protected JPanel createConfidenceCoefficientPanel()
			{
				JPanel panel = new JPanel();

					// First, let's do proportion

					// assumption is proportion
					{
						
						double[] variedAssumption = RSVariations.add(confidenceCoefficient, cols);

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						for (int i = 0; i < cols; i++)
							{
								RSCalculator.calculate(population, proportion, confidenceInterval, variedAssumption[i]);
								double value = RSCalculator.getN();			
								dataset.addValue(value, "confidenceCoefficient", Double.toString( variedAssumption[i]));	
							}
						
						JFreeChart chart = createChart(dataset);
						//chart.setTitle("Proportion Title");
						chart.setTitle(new TextTitle("Effect of Estimated Confidence Coefficient on Sample Size."));
						CategoryPlot plot = (CategoryPlot) chart.getPlot();
					    CategoryAxis xAxis = plot.getDomainAxis();
					    xAxis.setLabel("Confidence Coefficient");
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
