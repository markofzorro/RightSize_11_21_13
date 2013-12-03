package basesAndUtilites;


/**
 * An abstract base class for documents
 * Each document must declare and implement its own view
 * @author markofzero
 *
 */
public class RSDocBase
	{
	//	protected JDesktopPane desktop;
		
		
		protected double population = 100;
		protected double confidenceInterval = 5;
		protected double confidenceCoefficient = 95;
		protected double proportion = 50;
		
		protected static final double POP_MAX = 100000000000000000D;
		
		static final double POP_MIN = 10; // No sense in trying to do survey on less
		static final int POP_MAX_DIGITS = 18;
		
		static final double PROPORTION_MAX = 99;
		static final double PROPORTION_MIN = 1;
		static final int PROPORTION_MAX_DIGITS = 2;
		
		static final double CI_MAX = 50;
		static final double CI_MIN = 1;
		static final int CI_MAX_DIGITS = 2;
		
		static final double CC_MAX = 99;
		static final double CC_MIN = 90;
		static final int CC_MAX_DIGITS = 2;
		
		
		
		
		/*** Helper functions for calculate() *********/
		//  Weirdly I can't get hold of the version in java.math, but it is simple enough
		protected double abs(double number)
			{
				double abs_number = (number < 0) ? -number : number;
				return abs_number;
			}

		double roundUp( double d )      
			{
				long l = (long)d;
				double dremainder = d - l;
				if ( dremainder > 0.0 )
					l++;

				return l;
			}
		
		/******************** end helper functions ***/
		

	/************ Getters and Setters ************/	
		
		
		
		protected void setPop(String s)
			{
				
				double retval = stringToDouble(s, POP_MIN, POP_MAX, POP_MAX_DIGITS);
		
				
				
				if ( retval <= 0)
					population = 0; // mark failure
				else 
					population = retval;
				
				//D.b("RSDocBase setPop: retval is " + retval);
							
			}
		
		public double getPop()
			{
				return population;
			}
		
		protected void setProportion(String s)
			{
		
				double retval = stringToDouble(s, PROPORTION_MIN, PROPORTION_MAX, PROPORTION_MAX_DIGITS);
				if ( retval <= 0)	
					proportion = 0; // mark failure
				else
					proportion = retval;
					
				//D.b("RSDocBase setProportion: retval is " + retval);
			}
		
		public double getProportion()
			{
				return proportion;
			}
		
		protected void setCI(String s)
			{
				
				double retval = stringToDouble(s, CI_MIN, CI_MAX, CI_MAX_DIGITS);
				if ( retval <= 0)
					confidenceInterval = 0; // mark failure
				else
					confidenceInterval = retval;
					
				//D.b("RSDocBase setCI: retval is " + retval);
							
			}
		
		public double getCI()
			{
				return confidenceInterval;
			}
		
		protected void setCC(String s)
			{
				double retval = 0;
				retval = stringToDouble(s, CC_MIN, CC_MAX, CC_MAX_DIGITS);
				if ( retval <= 0)
					confidenceInterval = 0; // mark failure
				else
					confidenceCoefficient = retval;
					
				//D.b("RSDocBase setCC: retval is " + retval);
							
			}
		
		public double getCC()
			{
				return confidenceCoefficient;
			}
		
		/************ END OF SETTERS AND GETTERS ************/
		
		
		
		Double stringToDouble(String s_in, Double in_min , Double in_max, int in_max_digits)
			{
				String s = s_in;
				Double min = in_min;
				Double max = in_max;
				int maxDigits = in_max_digits;
				
				// get rid of leading or trailing spaces.
				s = s_in.trim();
				
				
				// first, we must remove all the non-numeric chars. Note that it also removes commas.
				StringBuilder sb = new StringBuilder();  // to hold new string with only numbers
				for(int counter =0; counter < s.length(); counter++)
					{
						char c = s.charAt(counter);
		 
						if((c >= '0' && c <= '9') ||( c == '.')) // it's a digit or a dot
							sb.append(c);
						
					}
				 // catch empty strings
				////D.b("stringbuffer is " + sb);
				
				if((sb.length() == 0) || (sb.toString().isEmpty()))
				{
				//	JOptionPane.showMessageDialog(view,"Oops, you entered a blank. Try again.");
					return 0.0; // mark failure to convert
				}
				
				
				// are there too many digits to be a Double 
				if(sb.length() > maxDigits)
					{	
			//		JOptionPane.showMessageDialog(view,"Oops. You entered too many digits. "+ " The value must be between " + in_min + " and " + in_max);
						return 0.0;
					}
				
				
				// OK to convert string since all characters are now numeric	
				Double retval = 0.0;
				try {	retval= Double.parseDouble(sb.toString()); }
			catch (NumberFormatException e) 
					{ 
//						JOptionPane.showMessageDialog(view,"<HTML>Oops, SRSdocument has Internal error converting string to Double. <br>Please contact TEPHINET office or"
//								+ " Mark White at mark@markewhite.com to report this error. <br>Thanks. Try again. Be sure to enter a valid number.</HTML>");
					}
				 
					////D.b("stringtoDouble: retval is " + retval  + " min = " + min + ". max = " + max);
						if (retval >= min && retval <= max)  // Check range.
							{	
							// debuggger	
						//	JOptionPane.showMessageDialog(view,"stringToDouble: retval is " + retval);
								return retval; // conversion successful

							
							
							}
						else // not in range
						{
//							JOptionPane.showMessageDialog(view,"Oops, You entered: " + retval + ". The value must be between" + in_min + " and " + in_max);
							
							return 0.0;
						}
						
			}

		

	}
