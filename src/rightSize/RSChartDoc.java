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
						
						// Get data set for chart
						//RSVariations v = new RSVariations();
								
						//DefaultCategoryDataset dataset =  new DefaultCategoryDataset();//v.variationsAdd(50, 1, 99, 5, 5);
					 //   DefaultCategoryDataset dataset = new DefaultCategoryDataset();
							
					        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					        dataset.addValue(21, "Series 1", "Category 1");
					        dataset.addValue(50, "Series 1", "Category 2");
					        dataset.addValue(152, "Series 1", "Category 3");
					        dataset.addValue(184, "Series 1", "Category 4");
					        dataset.addValue(299, "Series 1", "Category 5");
					        dataset.addValue(275, "Series 2", "Category 1");
					        dataset.addValue(121, "Series 2", "Category 2");
					        dataset.addValue(98, "Series 2", "Category 3");
					        dataset.addValue(103, "Series 2", "Category 4");
					        dataset.addValue(210, "Series 2", "Category 5");
					        dataset.addValue(198, "Series 3", "Category 1");
					        dataset.addValue(165, "Series 3", "Category 2");
					        dataset.addValue(55, "Series 3", "Category 3");
					        dataset.addValue(34, "Series 3", "Category 4");
					        dataset.addValue(77, "Series 3", "Category 5");
						
						
						
						
						
						
						
						RSChartView frame = new RSChartView(dataset, "Simple Random Sample With Varied Assumptions");
						frame.setVisible(true); // necessary as of 1.3
						desktop.add(frame);
						try
							{
								frame.setSelected(true);
							} catch (java.beans.PropertyVetoException e)
							{
							}
							
					
					}
					}
			/*	
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
				 *
				CategoryDataset createDataset()
					{

						
						// row keys...
						String series1 = "First";
					

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
						double center = 50;
						double max = 100;
						double min = 0;
						int cols = 5;
						
						double top = 0;
						// Choose the interval
						double interval = center * 0.4; //arbitrary val Refine this.
						int halfCols = (cols - 1)/2;
						D.b("halfCols is " + halfCols);
						
						D.b("interval is " + interval);
						double floor = center - (interval * halfCols);
						D.b("floor is " + floor);
						
						double j = floor;
							for( int i = 0; i < cols; i++)
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
*/
					
	//}
