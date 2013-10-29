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
		private JDesktopPane desktop = null;
		private int TOTAL_COLS = 8;
		
		
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
						
						RSChartView frame = new RSChartView(createDataset(), "Simple Random Sample With Varied Assumptions");
						frame.setVisible(true); // necessary as of 1.3
						desktop.add(frame);
						try
							{
								frame.setSelected(true);
							} catch (java.beans.PropertyVetoException e)
							{
							}
							
					
					}
				
				private void Variations()
				{
					double startVal = 50;
					double maxVal = 100;
					double minVal = 0;
					
					
					double iTop = maxVal - startVal;
					double iBottom = startVal - minVal;
					double interval = (iTop > iBottom)? iTop: iBottom;
					
					
				}
				
				/**
				 * Creates a dataset with a single series, though could add more easily.
				 * @return
				 */
				CategoryDataset createDataset()
					{

						
						// row keys...
						String series1 = "First";
					//	String series2 = "Second";
					//	String series3 = "Third";

						// column keys...
						String col1 = "col 1";
						String col2 = "col 2";
						String col3 = "col 3";
						String col4 = "col 4";
						String col5 = "col 5";
						String col6 = "col 6";
						String col7 = "col 7";
						String col8 = "col 8";

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
						double startVal = 50;
						double maxVal = 100;
						double minVal = 0;
						
						/// Choose interval to vary the starting value by
						double iTop = maxVal - startVal;
						double iBottom = startVal - minVal;
						// choose the smaller of the two distances so everything fits well on the graph.
						double interval = (iTop < iBottom)? iTop: iBottom;
						
						
						for( int i = 0, j = (int)startVal; i < TOTAL_COLS; i++)
							{
								 
								RSCalculator.calculate(100, j, 10, 95);
								double size = RSCalculator.getN();
								
								String column = Integer.toString(i);
								
								dataset.addValue(size, series1, column);
								j+=startVal;
								
							}
						
						

				/*		dataset.addValue(1.0, series1, col1);
						dataset.addValue(4.0, series1, col2);
						dataset.addValue(3.0, series1, col3);
						dataset.addValue(5.0, series1, col4);
						dataset.addValue(5.0, series1, col5);
						dataset.addValue(4.0, series1, col6);
						dataset.addValue(3.0, series1, col7);
						dataset.addValue(2.0, series1, col8);

					/*	dataset.addValue(3.0, series2, col1);
						dataset.addValue(3.0, series2, col2);
						dataset.addValue(3.0, series2, col3);
						dataset.addValue(8.0, series2, col4);
						dataset.addValue(4.0, series2, col5);
						dataset.addValue(4.0, series2, col6);
						dataset.addValue(4.0, series2, col7);
						dataset.addValue(4.0, series2, col8);

						dataset.addValue(4.0, series3, col1);
						dataset.addValue(3.0, series3, col2);
						dataset.addValue(2.0, series3, col3);
						dataset.addValue(3.0, series3, col4);
						dataset.addValue(6.0, series3, col5);
						dataset.addValue(3.0, series3, col6);
						dataset.addValue(4.0, series3, col7);
						dataset.addValue(3.0, series3, col8);
*/
						return dataset;

					}

					
	}
