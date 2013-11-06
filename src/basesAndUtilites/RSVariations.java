package basesAndUtilites;




/**
 * 
 * @author markofzero
 *
 */
public class RSVariations
	{
		
	 

		static public double[] add(double assumption, int cols)
			{
				final double[] darray = new double[cols];			
				
				
				// be sure we have odd number of columns so userVal will be in center if possible
				int remainder = cols % 2;
				if(remainder == 0) // it is even
					{
						D.b("********* Aborting. VariationsAdd: col should be odd. Here it is " + cols);
						System.exit(0);
					}
				
				
				int halfarraysize = cols / 2;
				double distance = 10; // arbitrary starting point

				// does the expansion fit the range?
				if ((Globals.MIN + distance * cols) > Globals.MAX )  // the expansion is too big
				{
						// chop the bigger segment into narray bits
					double top = Globals.MAX - assumption;
					double bottom = assumption - Globals.MIN;
					if (top >= bottom)
						distance = top / cols;
					else
						distance = bottom / cols;
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
				for (int i = 0; i < cols; i++)
					darray[i] = start + distance * i;

				// Debugger
				D.b("RSVariations: varyAdd:");
				for (int i = 0; i < cols; i++)
					D.b("array[" + i + "] is " + darray[i]);
				
				return darray;
			} // variationsAdd

	} // RSVariations

