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

		public RSChartDoc(JDesktopPane desktop)
			{
				this.desktop = desktop;
				D.b("In RSChartDoc constructor.");
				createChartFrame();

			}

		// Create a new internal frame.
		private void createChartFrame()
			{

				//static public void calculate(double arg_population, double arg_proportion, double arg_confidenceInterval, double arg_confidenceCoefficient )
			//	RSCalculator.calculate(100, 50, 10, 95);
		     //    double size = RSCalculator.getN();

				DefaultCategoryDataset dataset = variationsAdd(50, 1, 99, 11);
						
						
				
			
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

		public DefaultCategoryDataset variationsAdd(double assumption, double min, double max, int cols)
			{
				//double[] array = new double[cols];
				
				// Make sure userVal is within the acceptable range.
				if((assumption < min || (assumption > max)))
					{
						D.b("RSChartDoc.variationsAdd: userVal is outside accdeptable limits. userVal is " + assumption + " min is " + min + " max is " + max);
						System.exit(-1);
					}
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();

				// be sure we have odd number of columns so userVal will be in
				// center if possible
				int remainder = cols % 2;
				if (remainder == 0) // it is even
					{
						D.b("********* Aborting. Vary: col should be odd. Here it is "
								+ cols);
						System.exit(0);
					}

				int halfarraysize = cols / 2;
				
		/*		// Arbitrary number to start the ball rolling.
				// May be able to improve by choosing intervals to i power of 10 below userVal 
				double distance = userVal;
			//	distance = distance/10; // move down 1 order of magnitude
				distance = distance - (distance % 10);	// round to nearest 10
				
				// take care of small distances
				distance = (distance <1)? 1: distance; 
			*/
				double distance = 10;
			
			/*	// ugly but it should work for everything but population
				if (distance < 10 || distance > 99)
					distance = 1;
				else if ((distance < 20) || (distance > 80))
					distance = 5;
				else 
					distance = 10;
			
				*/
				
				
				

				// does the expansion fit the range?
				if ((min + distance * cols) > max) // the expansion is too big
					{
						// chop the bigger segment into narray bits
						double top = max - assumption;
						double bottom = assumption - min;
						if (top >= bottom)
							distance = top / cols;
						else
							distance = bottom / cols;
					} // if

				// Can we vary down?
				for (int i = 0; i < halfarraysize; i++)
					if ((assumption - distance * halfarraysize) < min) // oops, it
																	// will run
																	// below min
						assumption += distance; // move it up

				// Can we vary up?
				for (int i = 0; i < halfarraysize; i++)
					{	if ((assumption + distance * halfarraysize) > max) // oops, it
																	// will run
																	// below min
						assumption -= distance; // move it down
					}
			
				/*
				 * #ifdef _DEBUG // check to be sure it worked ASSERT( (userVal
				 * - halfarraysize * distance) >= min); ASSERT( (userVal +
				 * distance * halfarraysize) <= max); #endif
				 */
				// now fill the array
				double start = assumption - distance * halfarraysize;
				
				/*
				 * You must follow the strict arg conventions or chart ignores your input
				 * 
				 * First arg is the value of the point as a double. the x value.
				 * Second is the series (the line the point belongs on)
				 * Third is the column the y value.
			*/

				for (int i = 0; i < cols; i++)
					{	
					//dataset.addValue(i * 10, "Proportion", "Category" + Integer.toString(i));
					//	calculate(double arg_population, double arg_proportion, double arg_confidenceInterval, double arg_confidenceCoefficient )
						RSCalculator.calculate(100, start, 10, 95); // for testing purposes set population at 100
					double  n = RSCalculator.getN();
				
				//	WHAT'S THIS WITH START? MAKE SURE IT CORRESPONDS WITH THE RESULT AND NOT SOMETHING ELSE
					
					D.b("RSChartDoc: n is " + n + "p is " + start + " ci is 10 + cc is 95");
					String printMe = Long.toString(Math.round(start)) + "%";
					dataset.addValue(n, "Proportion",  printMe);
					start += distance;
					//array[i] = start + distance * i;
					}
				// Debugger
			//	D.b("RSVariations: varyAdd:");
			//	for (int i = 0; i < cols; i++)
			//		D.b("array[" + i + "] is " + array[i]);

				return dataset;
			} // variationsAdd

		
	} // end of class
