package cluster;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import java.math.*;

import org.apache.commons.math3.distribution.NormalDistribution;

import basesAndUtilites.D;

public class ClusterDoc
{

	private JDesktopPane desktop;
	private ClusterView view = null;
	//private SRSView view;

	private double population = 100;
	private double confidenceInterval = 5;
	private double confidenceCoefficient = 95;
	private double proportion = 50;

	
	
	private double clusterSize = 0;
	private double clustersNeeded = 0; 
	private double designEffect = 0;
	private double roh = 0;
	
	
	//static boolean SUCCESS = false;
	static final double POP_MAX = 100000000000000000D;
	static final double POP_MIN = 1000; // No sense in trying to do cluster survey on less
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
	
	static final double CLUSTER_SIZE_MAX = 100;
	static final double CLUSTER_SIZE_MIN = 1;
	static final int CLUSTER_SIZE_MAX_DIGITS = 2;
	
	static final double ROH_SIZE_MAX = 99;
	static final double ROH_SIZE_MIN = 0;
	static final int ROH_SIZE_MAX_DIGITS = 100;
	
	
	public ClusterDoc(JDesktopPane desktop) 
	{
		this.desktop = desktop;
		//Calculate();

		/* temporarily skip these steps while I test the formula*/
		  
		 
		view = new ClusterView(this, "cluster Sample");
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
		//* add some of these back when calculation works. */
	}

	public void setVariables()
		{
			setPopulation(view.getPopString());
			setProportion(view.getProportionString());
			setCI(view.getCIString());
			setCC(view.getCCString());
			setClusterSize(view.getClusterSizeString());
			setROH(view.getROHString());
			D.b("Doc:setVariables: roh is " + roh);
			
		//	if (SUCCESS)
//			calculate();
		
			//{
				// reset the variables;
			//	population = proportion = confidenceInterval = 0;
				// reset the view to defaults
			//	view.resetToDefaults();
			//}
				
			
//			D.b("pop = " + population + ". proportion = " + proportion + ". ci = " + confidenceInterval + " cc = "+ confidenceCoefficient);
		}
	
/**
 *  Formula from Bennett, WHO Stat Quartery 44(3), 98-106, 1991	
 */
	public void calculate()
		{
			 
			setVariables();
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
					 
			/***** Begin cluster sample-specific calculations ***/
					 
			// Set vars to match example
					 
					 /*
					  * Formula from Bennett:
					  * D = 1 + (b - 1)* roh
					  * Where: 
					  * 	D = design effect
					  * 	b = clusterSize (number of responses per cluster
					  * 	roh or rate of homogeneity, is a given  based on estimates. 0.2 is a big one. 
					  * 
					  * the number of clusters required is c = p*q*D/(s squared *b)
					  * 
					  * Example:
					  * b = 20
					  * p = 20%
					  * roh = 0.2
					  * ci 5%
					  *
					  * requires 18 clusters
					  *
					  * 
					  * 
					  */
					// clusterSize = 20;
					// roh = 0.02;
					// p = 0.2;
					 //confidenceInterval = 5;
					 
					 double ci = confidenceInterval/100; // get rid of percents
				
					 
					 // this is the right one  
				//	 double standardError = (ci) / z;
					
					 double standardError = ci/2;
					 D.b("calculate: s is " + standardError);
					 
					 // for testing
					// double standardError = 0.025;
					 designEffect = 1 +(clusterSize - 1) * roh;
					 
					 
					 
					 clustersNeeded = (p * (1 - p) * designEffect)/((square(standardError) * clusterSize));
					 
					 clustersNeeded = roundUp(clustersNeeded);
					 
					 D.b("Standard Error is " + standardError + " clustersNeeded is " + clustersNeeded + 
							 ". designEffect is " + designEffect + ". roh is " + roh + ".clusterSize is " + 
							 clusterSize + "CI Width is " + confidenceInterval + ".");
					 
					 
					 
					 
////////////////////////// PUT UPDATE CALL HERE //////////////////////////	
					 view.update(clustersNeeded, roh, designEffect);
					
				
		}
	
	private double square(double d )
	{
		return (d * d);
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
				
			}
			else
			{	
				population = 0; // mark failure
				
			}
			
			D.b("setPop: retval is " + retval);
						
		}
 	
 
 
	
	private void setProportion(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, PROPORTION_MIN, PROPORTION_MAX, PROPORTION_MAX_DIGITS);
			if ( retval > 0)
			{
				proportion = retval;
				D.b("setProportion: retval is: " + retval);
			}
			else
			{	
				proportion = 0; // Mark failure
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
				
			}
			else
			{	
				confidenceInterval = 0; // mark failure
				
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
			}
			else
			{	
				confidenceCoefficient = 0; // mark failure
				
			}
						
		}
	
	private void setClusterSize(String s)
	{
		double retVal = stringToDouble(s, CLUSTER_SIZE_MIN, CLUSTER_SIZE_MAX, CLUSTER_SIZE_MAX_DIGITS);
		
		if ( retVal > 0)
			{
				clusterSize = retVal;
				D.b("setClusterSize: retval is: " + retVal);
				
			}
			
		
	}
	
	private void setROH(String s)
		{
			double retVal = stringToDouble(s, ROH_SIZE_MIN, ROH_SIZE_MAX, ROH_SIZE_MAX_DIGITS);
			D.b("Doc: setRoh: roh is " + retVal);
			if ( retVal > 0)
				{
					roh = retVal;
					D.b("setROH: retval is: " + retVal);
					
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
						
						
						return 0.0;
					}
					
		}
	
		
} // end of SRSDocument
