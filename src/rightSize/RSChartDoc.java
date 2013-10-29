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
						int cols = 13;
						/// Choose interval to vary the starting value by
						double iTop = maxVal - startVal;
						double iBottom = startVal - minVal;
						// choose the smaller of the two distances so everything fits well on the graph.
						double interval = (iTop < iBottom)? iTop: iBottom;
						D.b("Before division interval is " + interval); 
						interval = interval/cols; // fit interval to chart
						D.b("After division interval is " + interval);
						
						startVal = startVal - (interval * cols/2); 
						for( int i = 0, j = (int)startVal; i < cols; i++)
							{
								 
				
								D.b("j is " + j);
								RSCalculator.calculate(100, j, 10, 95);
								double size = RSCalculator.getN();
								
								String column = Integer.toString(i);
								
								dataset.addValue(size, series1, (Comparable)j);
								j+=interval;
								
							}
						
						
						return dataset;

					}

					
	}
