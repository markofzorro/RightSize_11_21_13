package basesAndUtilites;




/**
 * Produces an array of alternate assumptions so we can calculate points for
 * chart to compare them and see effects on final sample size
 * @author markofzero
 *
 */
public class RSVariations
	{
		static double max = 0;
		static double min = 0;
		static double assumption = 0;
	 

		public static double[] createArray(double min, double max, int cols)
			{
				double[] array = new double[cols];
			
			double distance = (max - min)/(cols - 1);
		//	System.out.println("RSVariations.createArray(): distance  is " + distance );
			for(int i = 0; i < cols; i++)
				{
					if( i == 0)
						array[i] = min;
					else if( i == cols - 1)
						array[i] = max;
					else
						array[i] = min + (distance * i);
					
					D.b("RSVariations.createArray(): i is " + i + ", array[i] is " + array[i] );
				}
			
			return array;
			}

		private static double[] createBottomHalfArray(double bottom, double assumption, int size)
			{
				
				return createArray(bottom, assumption, size);
			}
		
		private static double[] createTopHalfArray(double assumption, double top, int size)
			{
				
				return createArray(assumption + 1, top, size);
			}
		
		public static double[] createArrayAroundAssumption(double assumption, double bottom, double top, int size)
			{
				
				double[] bottomHalf = createArray(bottom, assumption, (size/2)); 
				double[] topHalf = createArray(assumption, top, (size/2) + 1);
				return concat(bottomHalf, topHalf);
				
				/*createBottomHalfArray(min, assumption, (cols/2) + 1);
				createBottomHalfArray(min, assumption, (cols/2) + 1);
				createTopHalfArray(assumption, (cols/2) + 1);
				return null;
				*/
			}
		
		private static double[] concat(double[] A, double[] B) 
			{
			   int aLen = A.length;
			   int bLen = B.length;
			   double[] C= new double[aLen+bLen];
			   System.arraycopy(A, 0, C, 0, aLen);
			   System.arraycopy(B, 0, C, aLen, bLen);
			   return C;
			}
		
		
		public static double[] proportion(double assumption)
			{
			
				//return createArray(GlobalConstants.MIN, GlobalConstants.MAX, GlobalConstants.COLS);
				return createArrayAroundAssumption(assumption, GlobalConstants.MIN, GlobalConstants.MAX, GlobalConstants.COLS);
			}
		
		
		public static double[] confidenceLevel()
			{
				return createArray(GlobalConstants.CONFIDENCE_LEVEL_MIN, GlobalConstants.CONFIDENCE_LEVEL_MAX, GlobalConstants.COLS);
			}
		
		public static double[] confidenceInterval()
			{
				return createArray(GlobalConstants.CONFIDENCE_INTERVAL_MIN, GlobalConstants.CONFIDENCE_INTERVAL_MAX, GlobalConstants.COLS);
			}
		
		public static double[] clusterSize()
			{
				return createArray(GlobalConstants.CLUSTER_SIZE_MIN, GlobalConstants.CLUSTER_SIZE_MAX, GlobalConstants.COLS);
			}
		public static double[] roh()
			{
				return createArray(GlobalConstants.ROH_MIN, GlobalConstants.ROH_MAX, GlobalConstants.COLS);	
				}
		
		public static double[]  designEffect()
			{
				return createArray(GlobalConstants.DESIGN_EFFECT_MIN, GlobalConstants.DESIGN_EFFECT_MAX, GlobalConstants.COLS);
			}
		
		
		
		
		/**
		 * Creates assumptions by adding or subtracting an interval from the
		 * initial value. It calculates the interval to fit within the max and min values.
		 * 
		 * Returns an array of the values.
		 * @param assumption
		 * @param cols
		 * @return
		 */
		static public double[] add(double assumption_arg, double min_arg, double max_arg, boolean wholeNumber)
			{
				
				min = min_arg;
				max = max_arg;
				assumption = assumption_arg;
				
				
				// Need 2D array to store values and column labels
				final double[] darray = new double[GlobalConstants.COLS];
				final double rows = GlobalConstants.COLS;
				
				
				// be sure we have odd number of columns so userVal will be in center if possible
				int remainder = GlobalConstants.COLS % 2;
				if(remainder == 0) // it is even
					{
						D.b("********* Aborting. VariationsAdd: col should be odd. Here it is " + GlobalConstants.COLS);
						System.exit(0);
					}
				
				
				int halfArraySize = GlobalConstants.COLS / 2;
			//*** 
				//	double distance = 10; // arbitrary starting point

				double top = max - assumption;
				double bottom = assumption - min;
				double distance = 0;
				if( top > bottom)
					distance = (top/halfArraySize * 2);
				else // must be closer to bottom
					distance = (top/halfArraySize * 2);
				
				// does the expansion fit the range?
			/*	if ((min + distance * GlobalConstants.COLS) > max )  // the expansion is too big
				{
						// chop the bigger segment into narray bits
					double top = max - assumption;
					double bottom = assumption - min;
					if (top >= bottom)
						distance = top / GlobalConstants.COLS;
					else
						distance = bottom / GlobalConstants.COLS;
				} // if

				// Can we vary down?
				for (int i =0 ; i < halfArraysize; i++)
					if( (assumption - distance * halfArraysize) < min)	// oops, it will run below Globals.MIN
						assumption += distance;	// move it up

				// Can we vary up?
				for (int i =0 ; i < halfArraysize; i++)
					if( (assumption + distance * halfArraysize) > max)	// oops, it will run below Globals.MIN
						assumption -= distance;	// move it down
			/*#ifdef _DEBUG
					// check to be sure it worked
				ASSERT( (userVal - halfarraysize * distance) >= Globals.MIN);
				ASSERT( (userVal + distance * halfarraysize) <= Globals.MAX);
			#endif	
				*/
				// now fill the array
				double start = assumption - distance * halfArraySize;
				for (int i = 0; i < GlobalConstants.COLS; i++)
					{
						
						if(wholeNumber)
							{
								// get rid of decimals
								double whole = Math.round(start + distance * i);
								darray[i] = whole;
												
							}
						
						darray[i] = start + distance * i;
					}

				// Debugger
			/*	D.b("RSVariations: varyAdd:");
				for (int i = 0; i < Globals.COLS; i++)
					D.b("array[" + i + "] is " + darray[i]);
				*/
				
			
				return darray;
			} // variationsAdd

		
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
				final double[] darray = new double[GlobalConstants.COLS];
				final double rows = GlobalConstants.COLS;
				
				
				// be sure we have odd number of columns so userVal will be in center if possible
				int remainder = GlobalConstants.COLS % 2;
				if(remainder == 0) // it is even
					{
					//	D.b("********* Aborting. VariationsAdd: col should be odd. Here it is " + cols);
						System.exit(0);
					}
				
				
				int halfarraysize = GlobalConstants.COLS / 2;
				double distance = 0; // arbitrary starting point

				// does the expansion fit the range?
				if ((min + distance * GlobalConstants.COLS) > max )  // the expansion is too big
				{
						// chop the bigger segment into narray bits
					double top = max - assumption;
					double bottom = assumption - min;
					if (top >= bottom)
						distance = top / GlobalConstants.COLS;
					else
						distance = bottom / GlobalConstants.COLS;
				} // if

				// Can we vary down?
				for (int i =0 ; i < halfarraysize; i++)
					if( (assumption - distance * halfarraysize) < min)	// oops, it will run below Globals.MIN
						assumption += distance;	// move it up

				// Can we vary up?
				for (int i =0 ; i < halfarraysize; i++)
					if( (assumption + distance * halfarraysize) > max)	// oops, it will run below Globals.MIN
						assumption -= distance;	// move it down
			/*#ifdef _DEBUG
					// check to be sure it worked
				ASSERT( (userVal - halfarraysize * distance) >= Globals.MIN);
				ASSERT( (userVal + distance * halfarraysize) <= Globals.MAX);
			#endif	
				*/
				// now fill the array
				double start = assumption - distance * halfarraysize;
				for (int i = 0; i < GlobalConstants.COLS; i++)
					{
						// get rid of decimals
						double wholeNum = Math.round(start + distance * i);
						darray[i] = wholeNum;
					}

				// Debugger
			/*	D.b("RSVariations: varyAdd:");
				for (int i = 0; i < Globals.COLS; i++)
					D.b("array[" + i + "] is " + darray[i]);
				*/
				return darray;
			} // variationsAdd
		
		static public double[] multiplyByLogs(double assumption)
			{
				double lowCols = GlobalConstants.COLS / 2;
				double highCols = lowCols;
				double newPoint = 0;
				
				final double[] array = new double[GlobalConstants.COLS];
				

				double denominator = Math.pow(10, lowCols);
			//	D.b("denominator is " + denominator + ". LowCols is " + lowCols);

				// Catch low assumptions
				if (assumption < GlobalConstants.POPULATION_MIN)
					assumption = GlobalConstants.POPULATION_MIN;
				// else if (assumption > max)
				// assumption = max - Math.pow(10,cols);

				// Start with values below user's assumptions
				int arrayIndex = 0; // declare up here so you can use in all the
									// loops
				for (int i = 0; i < lowCols; i++)
					{
						double thisVal = assumption / denominator;
						//// D.b("thisVal is " + i + " " + thisVal);
						if (thisVal >= GlobalConstants.POPULATION_MIN) // in acceptable range
							array[arrayIndex++] = thisVal; // assign it and
															// increment j
						else
							// don't increment j.
							highCols++; // add a column on the high end so we
										// have right column count

						// shrink denominator to get next higher log
						denominator /= 10;
						//// D.b("array + " + i + " is " + array[i]);

					}
								// Add the user assumption
				array[arrayIndex++] = assumption;

				// Add values to the high end
				double multiplier = 10;
				double thisVal = assumption;
				for (int i = arrayIndex; i < GlobalConstants.COLS; i++)
					{
						thisVal *= multiplier; // Raise value
						//// D.b("thisVal is " + i + " " + thisVal);
						if (thisVal <= GlobalConstants.POPULATION_MAX) // in acceptable range
							{
								array[arrayIndex++] = thisVal; // assign it and
																// increment
																// arrayIndex
							//	D.b("High end: arrayIndex is " + arrayIndex + ". thisval is " + thisVal);
							} else
							{
							//	D.b("RSLogVariations.vary(): Error in filling high end of array. arrayIndex is " + arrayIndex + "thisVal is " + thisVal + " max is " + Globals.POPULATION_MAX);
								System.exit(-1);
							}

					}

				return array;

			} // multiplyByLogs


		
		
	} // RSVariations

