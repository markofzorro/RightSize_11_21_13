package charts;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

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
import basesAndUtilites.RSCalculator;
import basesAndUtilites.RSInternalFrame;
import basesAndUtilites.RSVariations;

public class RSChartDoc
	{
		// private SRSDoc doc = null;
		JFreeChart Chart = null;
		private JDesktopPane desktop = null;
		private double population = 0;
		private double proportion = 0;
		private double confidenceInterval = 0;
		private double confidenceCoefficient = 0;
		private String choice = null;

		// JPanel proportionsPanel = null;

		private int cols = 11; // Number of columns in chart.

		// public RSChartDoc(JDesktopPane desktop)
		/*
		 * public RSChartDoc(JDesktopPane desktop) { // For now use dummy dummy
		 * chart
		 * 
		 * this.desktop = desktop; D.b("In RSChartDoc constructor.");
		 * createChartFrame();
		 * 
		 * 
		 * 
		 * }
		 */

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
				D.b("In RSChartDoc constructor. confidenceConfidencient is " + confidenceCoefficient);
				D.b("In RSChartDoc constructor. Choice is " + choice);
				createChartFrame();

			}

		// Create a new internal frame.
		public void createChartFrame()
			{
				// RSCategoryDataset dataClass = new RSCategoryDataset();
				// CategoryDataset dataset = dataClass.createDataset();

				RSInternalFrame internalFrame = new RSInternalFrame("Charts");
				internalFrame.setSize(800, 700);
				RSTabbedChartPanel tabby = new RSTabbedChartPanel(this);

				internalFrame.add(tabby);

				// createDataset();
				// createChartPanels();

				// varyAssumption
				desktop.add(internalFrame);
				internalFrame.setVisible(true); // necessary as of 1.3
				// desktop.add(frame);
				try
					{
						internalFrame.setSelected(true);
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
				JPanel proportionPanel = createProportionsPanel();

			}

		protected JPanel createProportionsPanel()
			{
				JPanel panel = new JPanel();

					// First, let's do proportion

					// assumption is proportion
					{
						
						double[] xLabelsArray = RSVariations.add(proportion, cols);

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						// dataset.addValue(1.0, series1, type1);

						for (int i = 0; i < cols; i++)
							{
								RSCalculator.calculate(population, xLabelsArray[i], confidenceInterval, confidenceCoefficient);
								double value = RSCalculator.getN();
								// dataset(double value, String rowLabel, String columnLabel)			
								dataset.addValue(value, "proportion", Double.toString(xLabelsArray[i]));
								D.b("xLabelArray[" + i + "] is " + xLabelsArray[i]);
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
				JFreeChart chart = ChartFactory.createLineChart("Java Standard Class Library", // chart
																								// title
						null, // domain axis label
						"Class Count", // range axis label
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
