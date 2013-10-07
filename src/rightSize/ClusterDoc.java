package rightSize;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import org.apache.commons.math3.distribution.NormalDistribution;

public class ClusterDoc
{

	private JDesktopPane desktop;
	private ClusterView view = null;
	//private SRSView view;

	private double population = 100;
	private double confidenceInterval = 5;
	private double confidenceCoefficient = 95;
	private double proportion = 50;
	private double n0 = 0;
	private double n = 0;
	private double fpc = 0;
	
	
	static boolean SUCCESS = false;
	static final double POP_MAX = 100000000000000000D;
	static final double POP_MIN = 10; // No sense in trying to do survey on less
	static final int POP_MAX_DIGITS = 18;
	
	static final double PROPORTION_MAX = 99;
	static final double PROPORTION_MIN = 1;
	static final int PROPORTION_MAX_DIGITS = 2;
	
	static final double CI_MAX = 50;
	static final double CI_MIN = 1;
	static final int CI_MAX_DIGITS = 2;
	
	static final double CC_MAX = 99;
	static final double CC_MIN = 1;
	static final int CC_MAX_DIGITS = 2;
	
	
	public ClusterDoc(JDesktopPane desktop) 
	{
		this.desktop = desktop;

		view = new ClusterView(this);
		view.setVisible(true); // necessary as of 1.3
		desktop.add(view);
		//SRSResultsView resultsView = new SRSResultsView(this);
	//	resultsView.setVisible(true); // necessary as of 1.3
	//	desktop.add(resultsView);
		try
		{
			view.setSelected(true);
		} catch (java.beans.PropertyVetoException e)
		{
		}
	
	}

	public void setVariables()
		{
			setPopulation(view.inputPanel.getPopulation());
			setProportion(view.inputPanel.getProportion());
			setCI(view.inputPanel.getCI());
			setCC(view.inputPanel.getCC());
			
			if (SUCCESS)
			Calculate();
		
			//{
				// reset the variables;
			//	population = proportion = confidenceInterval = 0;
				// reset the view to defaults
			//	view.resetToDefaults();
			//}
				
			
//			D.b("pop = " + population + ". proportion = " + proportion + ". ci = " + confidenceInterval + " cc = "+ confidenceCoefficient);
		}
	
	
	private void Calculate()
		{
		  
/* Begin calculations **************/		        
/******* Formula from Cochran (1963:75) ***
 *	n0 = z2pq/e2
 *	where z2 = z squared
 *	e = confidence interval
 */
				 
				// Standard Normal Distribution has mean of 0 and SD of 1.
					NormalDistribution  nd = new NormalDistribution(0, 1); 
					
					double alpha = 1 - (confidenceCoefficient/100); // get rid of percents and calculate inverse
					D.b("alpha: " + alpha);
					
					double z =  nd.inverseCumulativeProbability((alpha/2));
				//	double z = 1 - (alpha/2);
					//z = abs(z);
					double z2 = z * z;
					D.b("z is " + z + " z2 is " + z2);
					
					double p = proportion/100;
					 double q = 1 - p;
					 double ci2 = confidenceInterval/100; // get rid of percents
					 ci2 = ci2 * ci2; // square it.
					
					 //double ciSquared  
					 D.b("ci2 is " + confidenceInterval + " squared it is " + ci2);
					 
					 D.b("p = " + p + " q = " + q + ".");
					
				//	 double n0 = (z * z * p * q ) / ciWidth * ciWidth;
					 
				//	 D.b("n0 = " + n0);
					    
					 n0 = z2 * p * q/ ci2;
					 D.b("n0 = " + n0);
					 
					 // Now calculate finite population correction
					 
					// now do finite population correction
						//m_nn = RoundUp(m_dn0 / ( 1 + ((m_dn0 - 1)/m_lTargetPop ) ) );     
					fpc = 1 / ( ( 1 + ((n0 - 1)/population ) ) );     ;                                      
					
					n = roundUp(n0 * fpc);
					D.b("n = " + n + " fpc " + fpc + " n0 = "+ n0 );
					showResults(n0, fpc, n);		
		
		}
	
	private void showResults(double show_n0, double show_fpc, double show_n  )
		{
			 JOptionPane.showMessageDialog(view,"Sample size is = " + show_n0 + "FPC is " + show_fpc + ". With FPC it is: " +show_n);
		//	SRSResultsView resultsView = new SRSResultsView();
		//	desktop.add(resultsView);
		}
	//  Weirdly I can't get hold of the version in java.math, but it is simple enough
	private double abs(double number)
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
	
	/****** end of calculations */
/** Validation and value setting and getting methods follow */
	
 	private void setPopulation(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, POP_MIN, POP_MAX, POP_MAX_DIGITS);
			
			
			if ( retval > 0)
			{
				population = retval;
				SUCCESS = true;
			}
			else
			{	
				population = 0; // mark failure
				SUCCESS = false;
			}
			
			D.b("setPop: retval is " + retval);
						
		}
 	
 	public double get_n0()
 		{
 			return n0;
 			
 		}
 	
	
	private void setProportion(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, PROPORTION_MIN, PROPORTION_MAX, PROPORTION_MAX_DIGITS);
			if ( retval > 0)
			{
				proportion = retval;
				D.b("setProportion: retval is: " + retval);
				SUCCESS = true;
			}
			else
			{	
				SUCCESS = false;
			}
						
		}
	
	private void setCI(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, CI_MIN, CI_MAX, CI_MAX_DIGITS);
			if ( retval > 0)
			{
				confidenceInterval = retval;
				D.b("setCI: retval is: " + retval);
				SUCCESS = true;
			}
			else
			{	
				confidenceInterval = 0; // mark failure
				SUCCESS = false;
			}
						
		}
	
	private void setCC(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, CC_MIN, CC_MAX, CC_MAX_DIGITS);
			if ( retval > 0)
			{
				confidenceCoefficient = retval;
				D.b("setCC: retval is: " + retval);
				SUCCESS = true;
			}
			else
			{	
				confidenceCoefficient = 0; // mark failure
				SUCCESS = false;
			}
						
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
						
						if ( SUCCESS )
							SUCCESS = false;	// mark failure
						
						return 0.0;
					}
					
		}
	
		
} // end of SRSDocument