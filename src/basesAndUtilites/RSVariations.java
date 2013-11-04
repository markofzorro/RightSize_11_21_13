package basesAndUtilites;

//import varyChartVals.D;

//package rightSize;

import javax.swing.JDesktopPane;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import charts.RSChartView;

/**
 * Called by SRS doc and ClusterDoc to show charts of their data. Generates a
 * set of assumptions similar to those of the one user entered. then calculates
 * sample sizes for these and displays a line graph showing how the assumption
 * affects the required sample size.
 * 
 * @author markofzero
 * 
 */
public class RSVariations // can be directly imported into RightSize as
							// RSChartDoc
	{
		private JDesktopPane desktop = null;

		public RSVariations(JDesktopPane desktop)
			{
				this.desktop = desktop;
				D.b("In RSChartDoc constructor.");
				createChartFrame();

			}

		// Create a new internal frame.
		private void createChartFrame()
			{

				// static public void calculate(double arg_population, double
				// arg_proportion, double arg_confidenceInterval, double
				// arg_confidenceCoefficient )
				// RSCalculator.calculate(100, 50, 10, 95);
				// double size = RSCalculator.getN();

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

		public static DefaultCategoryDataset variationsAdd(double assumption,
				double min, double max, int cols)
			{

				DefaultCategoryDataset dataset = new DefaultCategoryDataset();

				// Make sure userVal is within the acceptable range.
				if ((assumption < min || (assumption > max)))
					{
						D.b("RSVariations.variationsAdd: assumption is outside acceptable limits. userVal is "
								+ assumption
								+ " min is "
								+ min
								+ " max is "
								+ max);
						System.exit(-1);
					}

				// be sure we have odd number of columns so userVal will be in center
				int remainder = cols % 2;
				if (remainder == 0) // it is even
					{
						D.b("********* Aborting. Vary: col should be odd. Here it is "
								+ cols);
						System.exit(0);
					}

				int halfarraysize = cols / 2;

				// Arbitrary number to start the ball rolling.
				double distance = 10;

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
						if ((assumption - distance * halfarraysize) < min) 
					// oops, it will run below min, move it up:
					
				// Can we vary up?
				for (i = 0; i < halfarraysize; i++)
					{
						if ((assumption + distance * halfarraysize) > max) 
							// oops, it will run below min, so move it down
							assumption -= distance; 
					}

				// now fill the array
				/*
				 * You must follow the strict arg conventions or chart ignores
				 * your input
				 * 
				 * First arg is the value of the point as a double. the x value.
				 * Second is the series (the line the point belongs on) Third is
				 * the column the y value.
				 */

				double start = assumption - distance * halfarraysize;

				for (int i = 0; i < cols; i++)
					{
						
						RSCalculator.calculate(100, start, 10, 95); // for
																	// testing
																	// purposes
																	// set
																	// population
																	// at 100
						double n = RSCalculator.getN();

						// WHAT'S THIS WITH START? MAKE SURE IT CORRESPONDS WITH
						// THE RESULT AND NOT SOMETHING ELSE

						D.b("RSChartDoc: n is " + n + "p is " + start
								+ " ci is 10 + cc is 95");
						String printMe = Long.toString(Math.round(start)) + "%";
						dataset.addValue(n, "Proportion", printMe);
						start += distance;
						D.b("RSVariations.variationsAdd: dataset[" + i
								+ "]: should have: " + n + ", "
								+ "Proportion, " + printMe);

					}

				return dataset;
			} // variationsAdd

	} // end of class

