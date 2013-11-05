package charts;

import java.awt.Color;
import basesAndUtilites.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.ShapeUtilities;

public class RSChartPanel extends JPanel
	{

		/**
		 * Create the panel.
		 */
		public RSChartPanel()
			{
				D.b("Reached RSChartPanel constructor");
				JFreeChart chart = createChart(createDataset());
				JPanel chartPanel = new ChartPanel(chart);
				add(chartPanel);
			}

		/**
		 * 
		 * @return a sample dataset.
		 */
		private static CategoryDataset createDataset()
			{

				// row keys...
				String series1 = "First";
				String series2 = "Second";
				String series3 = "Third";

				// column keys...
				String type1 = "Type 1";
				String type2 = "Type 2";
				String type3 = "Type 3";
				String type4 = "Type 4";
				String type5 = "Type 5";
				String type6 = "Type 6";
				String type7 = "Type 7";
				String type8 = "Type 8";

				// create the dataset...
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();

				dataset.addValue(1.0, series1, type1);
				dataset.addValue(4.0, series1, type2);
				dataset.addValue(3.0, series1, type3);
				dataset.addValue(5.0, series1, type4);
				dataset.addValue(5.0, series1, type5);
				dataset.addValue(7.0, series1, type6);
				dataset.addValue(7.0, series1, type7);
				dataset.addValue(8.0, series1, type8);

				dataset.addValue(5.0, series2, type1);
				dataset.addValue(7.0, series2, type2);
				dataset.addValue(6.0, series2, type3);
				dataset.addValue(8.0, series2, type4);
				dataset.addValue(4.0, series2, type5);
				dataset.addValue(4.0, series2, type6);
				dataset.addValue(2.0, series2, type7);
				dataset.addValue(1.0, series2, type8);

				dataset.addValue(4.0, series3, type1);
				dataset.addValue(3.0, series3, type2);
				dataset.addValue(2.0, series3, type3);
				dataset.addValue(3.0, series3, type4);
				dataset.addValue(6.0, series3, type5);
				dataset.addValue(3.0, series3, type6);
				dataset.addValue(4.0, series3, type7);
				dataset.addValue(3.0, series3, type8);

				return dataset;

			}

		/**
		 * Creates a sample chart.
		 * 
		 * @param dataset
		 *            the dataset.
		 * 
		 * @return a chart.
		 */

		/**
		 * Creates a panel for the demo (used by SuperDemo.java).
		 * 
		 * @return A panel.
		 */
		public JPanel createDemoPanel()
			{
				JFreeChart chart = createChart(createDataset());
				return new ChartPanel(chart);
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
				JFreeChart chart = ChartFactory.createLineChart("Line Chart Demo 7", // chart
																						// title
						"Category", // domain axis label
						"Count", // range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						true, // include legend
						true, // tooltips
						false // urls
						);

				CategoryPlot plot = (CategoryPlot) chart.getPlot();

				// customise the range axis...
				NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
				rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

				// customise the renderer...
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
				renderer.setSeriesShapesVisible(0, true);
				renderer.setSeriesShapesVisible(1, false);
				renderer.setSeriesShapesVisible(2, true);
				renderer.setSeriesLinesVisible(2, false);
				renderer.setSeriesShape(2, ShapeUtilities.createDiamond(4.0f));
				renderer.setDrawOutlines(true);
				renderer.setUseFillPaint(true);
				renderer.setBaseFillPaint(Color.white);

				return chart;
			}

	}
