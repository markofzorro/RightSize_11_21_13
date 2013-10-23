/* -------------------
 * LineChartDemo1.java
 * -------------------
 * (C) Copyright 2002-2011, by Object Refinery Limited.
 *
 */

package jFreeChart;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

import rightSize.RSInternalFrame;

/**
 * A simple demonstration application showing how to create a line chart using
 * data from a {@link CategoryDataset}.
 */
public class RSLineChart extends RSInternalFrame
	{

		/**
		 * Creates a new demo.
		 * 
		 * @param title
		 *            the frame title.
		 */
		public RSLineChart(String title)
			{
				super(title);
				JPanel chartPanel = createChartPanel();
				chartPanel.setPreferredSize(new Dimension(500, 270));
				setContentPane(chartPanel);
			}

		/**
		 * Creates a sample dataset.
		 * 
		 * @return The dataset.
		 */
		private static CategoryDataset createDataset()
			{
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				dataset.addValue(212, "Classes", "JDK 1.0");
				dataset.addValue(504, "Classes", "JDK 1.1");
				dataset.addValue(1520, "Classes", "JDK 1.2");
				dataset.addValue(1842, "Classes", "JDK 1.3");
				dataset.addValue(2991, "Classes", "JDK 1.4");
				dataset.addValue(3500, "Classes", "JDK 1.5");
				return dataset;
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
				JFreeChart chart = ChartFactory.createLineChart(
						"Simple Random Sample", // chart title
						"Sample Size", // domain axis label
						"Proportion", // range axis label
						dataset, // data
						PlotOrientation.VERTICAL, // orientation
						false, // include legend
						true, // tooltips
						false // urls
						);

				// Add subtitle.
				chart.addSubtitle(new TextTitle("Sample Sizes for Various Proportions"));
				
				// Place subtitle AT BOTTOM. Cool feature.
				TextTitle source = new TextTitle(
						"Put Parameters here.");
				source.setFont(new Font("SansSerif", Font.PLAIN, 10));
				source.setPosition(RectangleEdge.BOTTOM);
				source.setHorizontalAlignment(HorizontalAlignment.CENTER);
				chart.addSubtitle(source);

				
				CategoryPlot plot = (CategoryPlot) chart.getPlot();
				plot.setRangePannable(true);
				plot.setRangeGridlinesVisible(false);
				URL imageURL = RSLineChart.class.getClassLoader()
						.getResource("OnBridge11small.png");
				if (imageURL != null)
					{
						ImageIcon temp = new ImageIcon(imageURL);
						// use ImageIcon because it waits for the image to
						// load...
						chart.setBackgroundImage(temp.getImage());
						plot.setBackgroundPaint(null);
					}
				// customise the range axis so it only shows even ticks
				NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
				rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

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

		/**
		 * Creates a panel for the demo (used by SuperDemo.java).
		 * 
		 * @return A panel.
		 */
		public static JPanel createChartPanel()
			{
				JFreeChart chart = createChart(createDataset());
				ChartPanel panel = new ChartPanel(chart);
				panel.setMouseWheelEnabled(true);
				return panel;
			}

		/**
		 * Starting point for the demonstration application.
		 * 
		 * @param args
		 *            ignored.
		 */
		public static void main(String[] args)
			{
				EventQueue.invokeLater(new Runnable() {
					public void run()
						{
							try
								{
									EatMe frame = new EatMe();
									frame.setVisible(true);
								} catch (Exception e)
								{
									e.printStackTrace();
								}
						}
				});
			}

		/**
		 * Create the frame.
		 */
		public RSLineChart()
			{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
			}


	}

public class MainFrame extends JFrame
{
	
}