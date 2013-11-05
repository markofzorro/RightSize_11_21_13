

package charts;

import javax.swing.JInternalFrame;
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

import java.awt.event.*;
import java.awt.*;

/**
 * An RSInternalFrame that creates a line graph using data passed to
 * it by RSChartDoc
 * @author markofzero
 *
 */
public class RSChartView extends JPanel
	{
		private CategoryDataset dataset = null;
		
//		static int openFrameCount = 0;
//		static final int xOffset = 30,  yOffset = 30;

		public RSChartView(CategoryDataset dataset)
			{
			//	super("Testing RSChartFrame");
				
				this.dataset = dataset;
					setSize(1300, 900);
				JPanel chartPanel = createDemoPanel();
				chartPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
			//* works	add(chartPanel);
				
				RSTabbedChartPanel tabPanel = new RSTabbedChartPanel();
				add(tabPanel);
				
				
			}
		/**
		 * Creates a chart panel
		 * 
		 * @return a panel.
		 */
		public  JPanel createDemoPanel()
			{
				// Here's where we externalize dataset. Next it has to go to document.
			//	ChartDataset dataset = new ChartDataset();
				JFreeChart chart = createChart(dataset);
				return new ChartPanel(chart);
			}

		

		/**
		 * Creates a sample chart, but needs to be fed data.
		 * 
		 * @param dataset
		 *            a dataset.
		 * 
		 * @return The chart.
		 */
		private static JFreeChart createChart(CategoryDataset dataset)
			{

				// create the chart...
				JFreeChart chart = ChartFactory.createLineChart(
						"I'm in an RSChartView", // chart title
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
				rangeAxis.setStandardTickUnits(NumberAxis
						.createIntegerTickUnits());

				// customise the renderer...
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
						.getRenderer();
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
