package basesAndUtilites;




/**
 * Produces an array of alternate assumptions so we can calculate points for
 * chart to compare them and see effects on final sample size
 * @author markofzero
 *
 */
public class RSVariations
	{
		
	 

		/**
		 * Creates assumptions by adding or subtracting an interval from the
		 * initial value. It calculates the interval to fit within the max and min values.
		 * 
		 * Returns an array of the values.
		 * @param assumption
		 * @param cols
		 * @return
		 */
		static public double[] add(double assumption)
			{
				// Need 2D array to store values and column labels
				final double[] darray = new double[Globals.COLS];
				final double rows = Globals.COLS;
				
				
				// be sure we have odd number of columns so userVal will be in center if possible
				int remainder = Globals.COLS % 2;
				if(remainder == 0) // it is even
					{
					//	D.b("********* Aborting. VariationsAdd: col should be odd. Here it is " + cols);
						System.exit(0);
					}
				
				
				int halfarraysize = Globals.COLS / 2;
				double distance = 10; // arbitrary starting point

				// does the expansion fit the range?
				if ((Globals.MIN + distance * Globals.COLS) > Globals.MAX )  // the expansion is too big
				{
						// chop the bigger segment into narray bits
					double top = Globals.MAX - assumption;
					double bottom = assumption - Globals.MIN;
					if (top >= bottom)
						distance = top / Globals.COLS;
					else
						distance = bottom / Globals.COLS;
				} // if

				// Can we vary down?
				for (int i =0 ; i < halfarraysize; i++)
					if( (assumption - distance * halfarraysize) < Globals.MIN)	// oops, it will run below Globals.MIN
						assumption += distance;	// move it up

				// Can we vary up?
				for (int i =0 ; i < halfarraysize; i++)
					if( (assumption + distance * halfarraysize) > Globals.MAX)	// oops, it will run below Globals.MIN
						assumption -= distance;	// move it down
			/*#ifdef _DEBUG
					// check to be sure it worked
				ASSERT( (userVal - halfarraysize * distance) >= Globals.MIN);
				ASSERT( (userVal + distance * halfarraysize) <= Globals.MAX);
			#endif	
				*/
				// now fill the array
				double start = assumption - distance * halfarraysize;
				for (int i = 0; i < Globals.COLS; i++)
					{
						// get rid of decimals
						double wholeNum = Math.round(start + distance * i);
						darray[i] = wholeNum;
					}

				// Debugger
				D.b("RSVariations: varyAdd:");
				for (int i = 0; i < Globals.COLS; i++)
					D.b("array[" + i + "] is " + darray[i]);
				
				return darray;
			} // variationsAdd
		
		static public double[] multiplyByLogs(double assumption)
			{
				double lowCols = Globals.COLS / 2;
				double highCols = lowCols;
				double newPoint = 0;
				
				final double[] array = new double[Globals.COLS];
				

				double denominator = Math.pow(10, lowCols);
				D.b("denominator is " + denominator + ". LowCols is " + lowCols);

				// Catch low assumptions
				if (assumption < Globals.POPULATION_MIN)
					assumption = Globals.POPULATION_MIN;
				// else if (assumption > max)
				// assumption = max - Math.pow(10,cols);

				// Start with values below user's assumptions
				int arrayIndex = 0; // declare up here so you can use in all the
									// loops
				for (int i = 0; i < lowCols; i++)
					{
						double thisVal = assumption / denominator;
						// D.b("thisVal is " + i + " " + thisVal);
						if (thisVal >= Globals.POPULATION_MIN) // in acceptable range
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
				for (int i = arrayIndex; i < Globals.COLS; i++)
					{
						thisVal *= multiplier; // Raise value
						// D.b("thisVal is " + i + " " + thisVal);
						if (thisVal <= Globals.POPULATION_MAX) // in acceptable range
							{
								array[arrayIndex++] = thisVal; // assign it and
																// increment
																// arrayIndex
								D.b("High end: arrayIndex is " + arrayIndex + ". thisval is " + thisVal);
							} else
							{
								D.b("RSLogVariations.vary(): Error in filling high end of array. arrayIndex is " + arrayIndex + "thisVal is " + thisVal + " max is " + Globals.POPULATION_MAX);
								System.exit(-1);
							}

					}

				return array;

			} // multiplyByLogs
		
		
	} // RSVariations

