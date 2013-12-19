package cluster;

import javax.swing.JDesktopPane;

import basesAndUtilites.D;
import basesAndUtilites.GlobalConstants;

public class ClusterDoc
{

	private JDesktopPane desktop;
	private ClusterView view = null;
	//private SRSView view;

	private double population = 1000;
	private double confidenceInterval = 5;
	private double confidenceCoefficient = 95;
	private double proportion = 20;
	
	private double clusterSize = 20;
	private double clustersNeeded = 0; 
	private double designEffect = 0;
	private double roh = 0;
	private double totalResponsesNeeded = 0;
	
	
	
	public ClusterDoc(JDesktopPane desktop) 
	{
		this.desktop = desktop;
				 
		view = new ClusterView(this, "Cluster Sample");
		view.setVisible(true); // necessary as of 1.3
		desktop.add(view);
	
		try
		{
			view.setSelected(true);
		} catch (java.beans.PropertyVetoException e)
		{
		}
		
	}

	public void setVariables()
		{
			setPopulation(view.getPopString());
			setProportion(view.getProportionString());
			setCI(view.getConfidenceIntervalString());
			setCC(view.getConfidenceLevelString());
			setClusterSize(view.getClusterSizeString());
			setROH(view.getROHString());
			D.b("ClusterDoc.setVariables after call to setRoh: roh is: " + roh); 
			setClustersNeeded(view.getClustersNeeded());
		//	D.b("ClusterDoc:setVariables: clustersNeeded is " + clustersNeeded + " confidenceCoefficient is " + confidenceCoefficient + ". roh is " + roh + ". Clustersize is " + clusterSize);
			
		}
	
	public void calculate()
		{
			setVariables();
			
			D.b("clusterdoc.calculate after call to setVariables: roh is " + roh);
		
					
			ClusterCalculator.calculate(population, proportion, 
						confidenceInterval, confidenceCoefficient, clusterSize, roh );
			
			clustersNeeded = ClusterCalculator.getClustersNeeded();
			designEffect = ClusterCalculator.getDesignEffect();
			totalResponsesNeeded = ClusterCalculator.getTotalResponsesNeeded();
			
		//	clusterSize = ClusterCalculator.getClusterSize();
			
				
			view.update(clustersNeeded, roh, designEffect, totalResponsesNeeded);
					
				
		}
	

	
	public void chart()
		{	
			//	D.b("Reached ClusterDoc.chart.");
				ClusterChartDoc chartDoc = new ClusterChartDoc(this);
			
			 
				
		}
	
/** Validation and value setting and getting methods follow */
	
 	private void setPopulation(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, GlobalConstants.POPULATION_MIN, GlobalConstants.POPULATION_MAX, GlobalConstants.POPULATION_MAX_DIGITS);
			//Double stringToDouble(String s_in, Double in_min , Double in_max, int in_max_digits)
			
			
			if ( retval > 0)
			{
				population = retval;
				
			}
			else
			{	
				population = 0; // mark failure
				
			}
			
		//	D.b("setPop: retval is " + retval);
						
		}
 	
 
 
	
	private void setProportion(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, GlobalConstants.MIN, GlobalConstants.MAX, GlobalConstants.MAX_DIGITS);
			if ( retval > 0)
			{
				proportion = retval;
		//		D.b("setProportion: retval is: " + retval);
			}
			else
			{	
				proportion = 0; // Mark failure
			}
						
		}
	
	String DoubleToString(double d)
		{
			long l = (long) d;
			String s = Long.toString(l);
		//	D.b("s = " + s);
			
			return s;
		}
	
	/************************* Setters and Getters *******/
	
	
	public JDesktopPane getDesktop()
		{
			return desktop;
		}

	public void setDesktop(JDesktopPane desktop)
		{
			this.desktop = desktop;
		}

	
	public ClusterView getView()
		{
			return view;
		}

	public void setView(ClusterView view)
		{
			this.view = view;
		}

	public double getPopulation()
		{
			return (long)population;
		}

	public void setPopulation(double population)
		{
			this.population = population;
		}

	public double getConfidenceInterval()
		{
			return confidenceInterval;
		}

	public void setConfidenceInterval(double confidenceInterval)
		{
			this.confidenceInterval = confidenceInterval;
		}

	public double getConfidenceCoefficient()
		{
			return confidenceCoefficient;
		}

	public void setConfidenceCoefficient(double confidenceCoefficient)
		{
			this.confidenceCoefficient = confidenceCoefficient;
		}

	public double getProportion()
		{
			return proportion;
		}

	public void setProportion(double proportion)
		{
			this.proportion = proportion;
		}

	public double getClusterSize()
		{
			return clusterSize;
		}

	public void setClusterSize(double clusterSize)
		{
			this.clusterSize = clusterSize;
		}

	public double getClustersNeeded()
		{
			return clustersNeeded;
		}

	public void setClustersNeeded(double clustersNeeded)
		{
			this.clustersNeeded = clustersNeeded;
		}

	public double getDesignEffect()
		{
			return designEffect;
		}

	public void setDesignEffect(double designEffect)
		{
			this.designEffect = designEffect;
		}

	public double getRoh()
		{
			return roh;
		}

	public void setRoh(double roh)
		{
			this.roh = roh;
		}

		private void setCI(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, GlobalConstants.CONFIDENCE_INTERVAL_MIN, GlobalConstants.CONFIDENCE_INTERVAL_MAX, GlobalConstants.MAX_DIGITS);
			if ( retval > 0)
			{
				confidenceInterval = retval;
		//		D.b("setCI: retval is: " + retval);
				
			}
			else
			{	
				confidenceInterval = 0; // mark failure
				
			}
						
		}
	
	private void setCC(String s)
		{
			double retval = 0;
			retval = stringToDouble(s, GlobalConstants.MIN, GlobalConstants.MAX, GlobalConstants.MAX_DIGITS);
			if ( retval > 0)
			{
				confidenceCoefficient = retval;
	//			D.b("ClusterDoc.setCC():  retval is: " + retval);
			}
			else
			{	D.b("ClusterDoc.setCC():  FAILED! retval is: " + retval);
				confidenceCoefficient = 0; // mark failure
				
			}
						
		}
	
	private void setClusterSize(String s)
	{
		double retVal = stringToDouble(s, GlobalConstants.MIN, GlobalConstants.MAX, GlobalConstants.MAX_DIGITS);
		
		if ( retVal > 0)
			{
				clusterSize = retVal;
		//		D.b("setClusterSize: retval is: " + retVal);
				
			}
			
		
	}
	
	private void setROH(String s)
		{
			double retVal = stringToDouble(s, GlobalConstants.ROH_MIN, GlobalConstants.ROH_MAX, GlobalConstants.ROH_MAX_DIGITS);
			D.b("Doc: setRoh: roh is " + retVal);
			if ( retVal >= 0)
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

	
	
		
} // end of ClusterDocument
