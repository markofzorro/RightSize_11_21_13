package rightSize;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import org.apache.commons.math3.distribution.NormalDistribution;

public class SRSDoc
{

	protected JDesktopPane desktop;
	protected SRSView view = null;
	private SRSCalculator calculator = null;

	protected double population = 100;
	protected double confidenceInterval = 5;
	protected double confidenceCoefficient = 95;
	protected double proportion = 50;
	protected double n0 = 0;
	protected double n = 0;
	protected double fpc = 0;
	
	
	private static final double POP_MAX = 100000000000000000D;
	
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
	
	/**
	 * Constructor creates a view to gather input and display results.
	 * When the view is finished and OK is clicked, the view calls the
	 * doc's calculate method and hands control back to the doc. 
	 * 
	 * @param desktop
	 */
	
	public SRSDoc(JDesktopPane desktop) 
	{
		this.desktop = desktop;

		setView();
	}
	
	protected void setView()
	{
		view = new SRSView(this, "Simple Random Sample");
		view.setVisible(true); // necessary as of 1.3
		desktop.add(view);
		try
			{
				view.setSelected(true);
			} catch (java.beans.PropertyVetoException e)
			{
			}
	}
	
	
	/**
	 * Loads variables into the document's class-level vars.
	 * It gets the values as strings from the input view and passes them
	 * to specialized methods for parsing and validation.
	 */
		public void setVariables()
		{
			setPop(view.getPopString());
			setProportion(view.getProportionString());
			setCI(view.getCIString());
			setCC(view.getCCString());
			D.b("doc:setVariables(): "); 
					D.b("pop = " + population + ". proportion = " + proportion + ". ci = " + confidenceInterval + " cc = "+ confidenceCoefficient);

				

		}
		
		public void graph()
			{
				D.b("Reached graph()");
			}
	
	
	protected void calculate()
		{
			setVariables();
			calculator = new SRSCalculator(this, population, proportion, confidenceInterval, confidenceCoefficient);
			
		}	
	
	public void getCalculationResults(double n0, double fpc, double n)
	{
		this.n0 =  n0;
		this.fpc = fpc;
		this.n = n;
		
		D.b("Doc getCalculationResult(): n0 is " + n0 + " fpc = " + fpc + "n = " + n);
		view.update(n0, fpc, n);
	}

	
 	protected void setPop(String s)
		{
			
			double retval = stringToDouble(s, POP_MIN, POP_MAX, POP_MAX_DIGITS);
	
			
			
			if ( retval <= 0)
				population = 0; // mark failure
			else 
				population = retval;
			
			D.b("Doc setPop: retval is " + retval);
						
		}
 	
 	public double get_n0()
 		{
 			return n0;
 			
 		}
 	
	
	protected void setProportion(String s)
		{
	
			double retval = stringToDouble(s, PROPORTION_MIN, PROPORTION_MAX, PROPORTION_MAX_DIGITS);
			if ( retval <= 0)	
				proportion = 0; // mark failure
			else
				proportion = retval;
				
			D.b("Doc setProportion: retval is " + retval);
		}
	
	protected void setCI(String s)
		{
			
			double retval = stringToDouble(s, CI_MIN, CI_MAX, CI_MAX_DIGITS);
			if ( retval <= 0)
				confidenceInterval = 0; // mark failure
			else
				confidenceInterval = retval;
				
			D.b("Doc setCI: retval is " + retval);
						
		}
	
	protected void setCC(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, CC_MIN, CC_MAX, CC_MAX_DIGITS);
			if ( retval <= 0)
				confidenceInterval = 0; // mark failure
			else
				confidenceCoefficient = retval;
				
			D.b("Doc setCC: retval is " + retval);
						
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
			//D.b("stringbuffer is " + sb);
			
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
//					JOptionPane.showMessageDialog(view,"<HTML>Oops, SRSdocument has Internal error converting string to Double. <br>Please contact TEPHINET office or"
//							+ " Mark White at mark@markewhite.com to report this error. <br>Thanks. Try again. Be sure to enter a valid number.</HTML>");
				}
			 
				//D.b("stringtoDouble: retval is " + retval  + " min = " + min + ". max = " + max);
					if (retval >= min && retval <= max)  // Check range.
						{	
						// debuggger	
					//	JOptionPane.showMessageDialog(view,"stringToDouble: retval is " + retval);
							return retval; // conversion successful

						
						
						}
					else // not in range
					{
//						JOptionPane.showMessageDialog(view,"Oops, You entered: " + retval + ". The value must be between" + in_min + " and " + in_max);
						
						return 0.0;
					}
					
		}
	
		
} // end of SRSDocument
