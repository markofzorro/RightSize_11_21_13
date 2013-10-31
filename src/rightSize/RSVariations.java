package rightSize;

//import varyChartVals.D;

public class RSVariations
	{

		// dummy constructor. Delete when turn to static stone
		/**
		 * 
		 */
		
		  public RSVariations() 
			  {
		  
				  variationsAdd(5, 1, 99, 10, 5);
		  }
		 

		public float[] variationsAdd(float userVal, float min, float max, int varyby, int cols)
			{
				float[] array = new float[cols];
				
				
				// be sure we have odd number of columns so userVal will be in center if possible
				int remainder = cols % 2;
				if(remainder == 0) // it is even
					{
						D.b("********* Aborting. Vary: col should be odd. Here it is " + cols);
						System.exit(0);
					}
				
				
				int halfarraysize = cols / 2;
				float distance = varyby;

				// does the expansion fit the range?
				if ((min + distance * cols) > max )  // the expansion is too big
				{
						// chop the bigger segment into narray bits
					float top = max - userVal;
					float bottom = userVal - min;
					if (top >= bottom)
						distance = top / cols;
					else
						distance = bottom / cols;
				} // if

				// Can we vary down?
				for (int i =0 ; i < halfarraysize; i++)
					if( (userVal - distance * halfarraysize) < min)	// oops, it will run below min
						userVal += distance;	// move it up

				// Can we vary up?
				for (int i =0 ; i < halfarraysize; i++)
					if( (userVal + distance * halfarraysize) > max)	// oops, it will run below min
						userVal -= distance;	// move it down
			/*#ifdef _DEBUG
					// check to be sure it worked
				ASSERT( (userVal - halfarraysize * distance) >= min);
				ASSERT( (userVal + distance * halfarraysize) <= max);
			#endif	
				*/
				// now fill the array
				float start = userVal - distance * halfarraysize;
				for (int i = 0; i < cols; i++)
					array[i] = start + distance * i;

				// Debugger
				D.b("RSVariations: varyAdd:");
				for (int i = 0; i < cols; i++)
					D.b("array[" + i + "] is " + array[i]);
				
				return array;
			} // variationsAdd

	} // RSVariations

