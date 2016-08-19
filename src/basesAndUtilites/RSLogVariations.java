package basesAndUtilites;

public class RSLogVariations
	{

		static private double assumption = 1000;
		static private double min = GlobalConstants.POPULATION_MIN;
		static private double max = GlobalConstants.POPULATION_MAX;
		static private int cols = GlobalConstants.COLS;
		static private double[] array = new double[cols];

		/**
		 * Method begins with user's assumption and attempts to find points
		 * above and below so assumption is in the center. If this runs over min
		 * or max, the method chooses points as close to limits as possible and
		 * creates the extra point or points on the other side of the array.
		 * 
		 * 
		 * Used to make array for populations.
		 * 
		 * @return
		 */
		static public double[] multiplyLogs()
			{
				double lowCols = cols / 2;
				double highCols = lowCols;
				double newPoint = 0;

				double denominator = Math.pow(10, lowCols);
				D.b("denominator is " + denominator + ". LowCols is " + lowCols);

				// Catch low assumptions
				if (assumption < min)
					assumption = min;
				// else if (assumption > max)
				// assumption = max - Math.pow(10,cols);

				// Start with values below user's assumptions
				int arrayIndex = 0; // declare up here so you can use in all the
									// loops
				for (int i = 0; i < lowCols; i++)
					{
						double thisVal = assumption / denominator;
						// D.b("thisVal is " + i + " " + thisVal);
						if (thisVal >= min) // in acceptable range
							array[arrayIndex++] = thisVal; // assign it and
															// increment j
						else
							// don't increment j.
							highCols++; // add a column on the high end so we
										// have right column count

						// shrink denominator to get next higher log
						denominator /= 10;
						// D.b("array + " + i + " is " + array[i]);

					}
								// Add the user assumption
				array[arrayIndex++] = assumption;

				// Add values to the high end
				double multiplier = 10;
				double thisVal = assumption;
				for (int i = arrayIndex; i < cols; i++)
					{
						thisVal *= multiplier; // Raise value
						// D.b("thisVal is " + i + " " + thisVal);
						if (thisVal <= max) // in acceptable range
							{
								array[arrayIndex++] = thisVal; // assign it and
																// increment
																// arrayIndex
								D.b("High end: arrayIndex is " + arrayIndex + ". thisval is " + thisVal);
							} else
							{
								D.b("RSLogVariations.vary(): Error in filling high end of array. arrayIndex is " + arrayIndex + "thisVal is " + thisVal + " max is " + max);
								System.exit(-1);
							}

					}

				return array;

			} // add

		private static void printArray()
			{
				D.b("***********Printing array*************");
				for (int i = 0; i < cols; i++)
					D.b("Array[" + i + "] is " + array[i]);
			}

		

	}
