package rightSize;

import javax.swing.JDesktopPane;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * Called by SRS doc and ClusterDoc to show charts of their data.
 * Generates a set of assumptions similar to those of the one user entered. then calculates sample
 * sizes for these and displays a line graph showing how the assumption affects the required sample size.
 * 
 * @author markofzero
 *
 */
public class RSChartDoc
	{
		JDesktopPane desktop = null;
		
		
		public RSChartDoc(JDesktopPane desktop) 
			{
				this.desktop = desktop;
				D.b("In RSChartDoc constructor.");
				createChartFrame();
				
			}

		// Create a new internal frame.
				private void createChartFrame()
					{
						//RSCategoryDataset dataClass = new RSCategoryDataset();
						//CategoryDataset dataset = dataClass.createDataset();
						
						RSChartView frame = new RSChartView(createDataset());
						frame.setVisible(true); // necessary as of 1.3
						desktop.add(frame);
						try
							{
								frame.setSelected(true);
							} catch (java.beans.PropertyVetoException e)
							{
							}
							
					
					}
				
				CategoryDataset createDataset()
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
						dataset.addValue(4.0, series1, type6);
						dataset.addValue(3.0, series1, type7);
						dataset.addValue(2.0, series1, type8);

						dataset.addValue(3.0, series2, type1);
						dataset.addValue(3.0, series2, type2);
						dataset.addValue(3.0, series2, type3);
						dataset.addValue(8.0, series2, type4);
						dataset.addValue(4.0, series2, type5);
						dataset.addValue(4.0, series2, type6);
						dataset.addValue(4.0, series2, type7);
						dataset.addValue(4.0, series2, type8);

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

					
	}
