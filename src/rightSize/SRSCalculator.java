package rightSize;

import org.apache.commons.math3.distribution.NormalDistribution;

public class SRSCalculator
	{	
		private SRSDoc doc = null;
		protected double population = 100;
		protected double confidenceInterval = 5;
		protected double confidenceCoefficient = 95;
		protected double proportion = 50;
		protected double n0 = 0;
		protected double n = 0;
		protected double fpc = 0;
		
		
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
		static final double CC_MIN = 90;
		static final int CC_MAX_DIGITS = 2;
		

		public SRSCalculator(SRSDoc doc, double pop, double proportion, double ConfidenceInterval, double  confidenceCoeffecient)
			{
				// load up class-level vars
				
				this.doc = doc;
				this.population = pop;
				this.proportion = proportion;
				this.confidenceInterval = confidenceInterval;
				this.confidenceCoefficient = confidenceCoeffecient;
				
				
				calculate();
				if(n>0 && n>0 && fpc != 0)
					doc.getCalculationResults(n0, fpc, n);				
				
			}
		

		private void calculate()
		{
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
				 
				 D.b("p = " + p + ", q = " + q + ", z " + z + ", CI2 " + ci2 + ".");
				
			//	 double n0 = (z * z * p * q ) / ciWidth * ciWidth;
				 
			//	 D.b("n0 = " + n0);
				    
				 n0 = z2 * p * q/ ci2;
				 D.b("n0 = " + n0);
				 
				 // Now calculate finite population correction
				 
				// now do finite population correction
					//m_nn = RoundUp(m_dn0 / ( 1 + ((m_dn0 - 1)/m_lTargetPop ) ) );     
				fpc = 1 / ( ( 1 + ((n0 - 1)/population ) ) );     ;                                      
				
				// Now that calculations are done, round the results to whole numbers
				n = roundUp(n0 * fpc);
				n0 = roundUp(n0);
				
				
				D.b("Calculate: fpc is " + fpc + " and adjucted n = " + n);
			//	showResults(n0, fpc, n);
				
				
	
	}
	
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

/****** end of calculations */
/** Validation and value setting and getting methods follow */
	}
