package charts2D;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import net.sourceforge.chart2d.Chart2D;
import net.sourceforge.chart2d.Chart2DProperties;
import net.sourceforge.chart2d.Dataset;
import net.sourceforge.chart2d.GraphChart2DProperties;
import net.sourceforge.chart2d.GraphProperties;
import net.sourceforge.chart2d.LBChart2D;
import net.sourceforge.chart2d.LegendProperties;
import net.sourceforge.chart2d.MultiColorsProperties;
import net.sourceforge.chart2d.Object2DProperties;

public class LMZChart extends JInternalFrame
	{

		final static int X_AXIS_SIZE = 11;

		//private JFrame frame;

		/**
		 * Launch the application.
		 */
/*		public static void main(String[] args)
			{
				EventQueue.invokeLater(new Runnable() {
					public void run()
						{
							try
								{
									LMZChart window = new LMZChart();
									window.frame.setVisible(true);
								} catch (Exception e)
								{
									e.printStackTrace();
								}
						}
				});
			}
*/
		/**
		 * Create the chart.
		 */
		public LMZChart()
			{
				initialize();
			}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize()
			{
				setSize(1000, 1000);
				//frame = new JFrame();
			//	setBounds(1000, 10000, 4500, 3000);
			//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// LBChart2DFrameDemo demo = new LBChart2DFrameDemo();
				// frame.add(demo);
				// frame.add(getChart2DDemoA()); // works

				// LBChart2DFrameDemo demo = new LBChart2DFrameDemo();
				Chart2D lineChart = getLineChart();
				add(lineChart);

			}

		/**
		 * Builds the demo chart.
		 * 
		 * @return The demo chart.
		 */
		private Chart2D getLineChart()
			{

				// <-- Begin Chart2D configuration -->

				// Configure object properties
				Object2DProperties object2DProps = new Object2DProperties();
				object2DProps
						.setObjectTitleText("Sample Size Needed for Simple Random Surveys");

				// Configure chart properties
				Chart2DProperties chart2DProps = new Chart2DProperties();

				// Configure legend properties
				LegendProperties legendProps = new LegendProperties();
				// String[] legendLabels = {"SRS", "Cluster", "LQAS"};
				// legendProps.setLegendLabelsTexts (legendLabels);

				legendProps.setLegendExistence(false);
				// Configure graph chart properties
				GraphChart2DProperties graphChart2DProps = new GraphChart2DProperties();

				/**
				 * Original String[] labelsAxisLabels =
				 * 
				 * {"1990", "1991", "1992", "1993", "1994", "1995", "1996",
				 * "1997", "1998", "1999", "2001", "2002"};
				 */

				String[] labelsAxisLabels = new String[X_AXIS_SIZE];

				for (int i = 0; i < X_AXIS_SIZE; i++)
					labelsAxisLabels[i] = Integer.toString((i) * 10);
				
				
				//GraphChart2DProperties graph2DProps = new GraphChart2DProperties();

				graphChart2DProps.setLabelsAxisLabelsTexts(labelsAxisLabels);
				graphChart2DProps
						.setLabelsAxisTitleText("Proportion (%)");
				graphChart2DProps
						.setNumbersAxisTitleText("Respondents Required");
				graphChart2DProps.setChartDatasetCustomizeGreatestValue(true);
				graphChart2DProps.setChartDatasetCustomGreatestValue(70);
				graphChart2DProps
						.setLabelsAxisTicksAlignment(graphChart2DProps.CENTERED);

				// Configure graph properties
				GraphProperties graphProps = new GraphProperties();
				graphProps.setGraphBarsExistence(false);
				graphProps.setGraphLinesExistence(true);
				graphProps.setGraphOutlineComponentsExistence(true);
				graphProps.setGraphAllowComponentAlignment(true);

				// Configure dataset
				// In this dataset the first column is 3 sets, one for each line.
				// the second column is the categories per set, which is 12.
				// The tutorial suggests up to 24 is a good number.
				// The third column is the number of items/category.
				// So this dataset has 3 sets, each of which has points for 12
				// years. there is 1 point for each category(year).
				//
				Dataset dataset = new Dataset(1, X_AXIS_SIZE, 1);
				dataset.set(0, 0, 0, 10f); // 1990
				dataset.set(0, 1, 0, 20f); // 1991
				dataset.set(0, 2, 0, 30f); // 1992
				dataset.set(0, 3, 0, 40f); // 1993
				dataset.set(0, 4, 0, 50f); // 1994
				dataset.set(0, 5, 0, 60f); // 1995
				dataset.set(0, 6, 0, 50f); // 1996
				dataset.set(0, 7, 0, 40f); // 1997
				dataset.set(0, 8, 0, 30f); // 1998
				dataset.set(0, 9, 0, 20f); // 1999
				dataset.set(0, 10, 0, 10f); // 2000
			//	dataset.set(0, 11, 0, 10f); // 2001
			
// We start the second set here				
/*				dataset.set(1, 0, 0, 0f); // 1990
				dataset.set(1, 1, 0, 0f); // 1991
				dataset.set(1, 2, 0, 0f); // 1992
				dataset.set(1, 3, 0, 100f); // 1993
				dataset.set(1, 4, 0, 200f); // 1994
				dataset.set(1, 5, 0, 400f); // 1995
				dataset.set(1, 6, 0, 500f); // 1996
				dataset.set(1, 7, 0, 700f); // 1997
				dataset.set(1, 8, 0, 900f); // 1998
				dataset.set(1, 9, 0, 100f); // 1999
				dataset.set(1, 10, 0, 200f); // 2000
				dataset.set(1, 11, 0, 300f); // 2001
// and the third here.			
				dataset.set(2, 0, 0, 0f); // 1990
				dataset.set(2, 1, 0, 0f); // 1991
				dataset.set(2, 2, 0, 0f); // 1992
				dataset.set(2, 3, 0, 0f); // 1993
				dataset.set(2, 4, 0, 100f); // 1994
				dataset.set(2, 5, 0, 200f); // 1995
				dataset.set(2, 6, 0, 300f); // 1996
				dataset.set(2, 7, 0, 400f); // 1997
				dataset.set(2, 8, 0, 500f); // 1998
				dataset.set(2, 9, 0, 100f); // 1999
				dataset.set(2, 10, 0, 300f); // 2000
				dataset.set(2, 11, 0, 900f); // 2001
*/
				// Configure graph component colors
				MultiColorsProperties multiColorsProps = new MultiColorsProperties();

				// Configure chart
				LBChart2D chart2D = new LBChart2D();
				chart2D.setObject2DProperties(object2DProps);
				chart2D.setChart2DProperties(chart2DProps);
				chart2D.setLegendProperties(legendProps);
				chart2D.setGraphChart2DProperties(graphChart2DProps);
				chart2D.addGraphProperties(graphProps);
				chart2D.addDataset(dataset);
				chart2D.addMultiColorsProperties(multiColorsProps);

				// Optional validation: Prints debug messages if invalid only.
				if (!chart2D.validate(false))
					chart2D.validate(true);

				// <-- End Chart2D configuration -->

				return chart2D;
			}

	}
