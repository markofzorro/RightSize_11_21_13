package rightSize;

import javax.swing.JDesktopPane;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Called by SRS doc and ClusterDoc to show charts of their data. Generates a
 * set of assumptions similar to those of the one user entered. then calculates
 * sample sizes for these and displays a line graph showing how the assumption
 * affects the required sample size.
 * 
 * @author markofzero
 * 
 */
public class RSChartDoc
	{
		private JDesktopPane desktop = null;
		private double assumption;
		private double min;
		private double max;
		int cols = 5;

		public RSChartDoc(JDesktopPane desktop, double assumption, double min,
				double max)
			{

				this.desktop = desktop;
				this.assumption = assumption;
				this.min = min;
				this.max = max;

				D.b("In RSChartDoc constructor.");
				createChartFrame();

			}

		// Create a new internal frame.
		private void createChartFrame()
			{
				DefaultCategoryDataset dataset = RSVariations.variationsAdd(
						assumption, min, max, cols);

				RSChartView frame = new RSChartView(dataset,
						"Simple Random Sample With Varied Assumptions");
				frame.setVisible(true); // necessary as of 1.3
				desktop.add(frame);
				try
					{
						frame.setSelected(true);
					} catch (java.beans.PropertyVetoException e)
					{
					}

			}

	} // end of class
