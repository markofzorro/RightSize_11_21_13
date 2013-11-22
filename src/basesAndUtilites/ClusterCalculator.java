package basesAndUtilites;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Declare static so won't have the overhead of creating new object every time you
 * repetively 
 * @author markofzero
 *
 */
public class ClusterCalculator
	{
		static private double population = 0;
		static private double proportion = 0;
		static private double confidenceInterval = 0;
		static private double confidenceCoefficient = 0;
		static private double clusterSize = 0;
		static private double clustersNeeded = 0;
		static private double n = 0;
		static private double roh = 0;
		static private double designEffect = 0;
		
		//static private double clustersNeeded = 0;
		
		
		
		
		static public void calculate(double arg_population, double arg_proportion, 
				double arg_confidenceInterval, double arg_confidenceCoefficient, double arg_clusterSize, double arg_roh )
			{
				
				D.b("Reached ClusterCalculator.calculate.");
				// Assign class-level vars
				population = arg_population;
				proportion = arg_proportion;
				confidenceInterval = arg_confidenceInterval;
				confidenceCoefficient = arg_confidenceCoefficient;
				
				clusterSize = arg_clusterSize;
				roh = arg_roh;
				
				 
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
				 
				// get rid of percents
				proportion = proportion/100; 
				double ci = confidenceInterval/100; // get rid of percents
			
				 
				 // this is the right one  
			//	 double standardError = (ci) / z;
				
				 double standardError = ci/2;
				 D.b("calculate: s is " + standardError);
				 
				 // for testing
				// double standardError = 0.025;
				 designEffect = 1 +(clusterSize - 1) * roh;
				 
				 
				 
				 double numerator =  (proportion * (1 - proportion) * designEffect);
				 double denominator = (standardError * standardError * clusterSize);
				 clustersNeeded = numerator/denominator;
				 
				 clustersNeeded = Math.ceil(clustersNeeded);
				 
				 D.b("ClusterCalculator.calculate(): Standard Error is " + standardError + " clustersNeeded is " + clustersNeeded + 
						 ". designEffect is " + designEffect + ". roh is " + roh + ".clusterSize is " + 
						 clusterSize + "CI Width is " + confidenceInterval + ".");
				 
		
				
				
				
				
				
				
				
				
				
			}

		
/*		static public void calculate(double arg_population, double arg_proportion, 
				double arg_confidenceInterval, double arg_confidenceCoefficient )
			{
				
				
				// Assign class-level vars
				population = arg_population;
				proportion = arg_proportion;
				confidenceInterval = arg_confidenceInterval;
				confidenceCoefficient = arg_confidenceCoefficient;
				
				/*******
				 * Formula from Cochran (1963:75) *** n0 = z2pq/e2 where z2 = z
				 * squared e = confidence interval
				 *

				// Standard Normal Distribution has mean of 0 and SD of 1.
				NormalDistribution nd = new NormalDistribution(0, 1);

				double alpha = 1 - (confidenceCoefficient / 100); // get rid of
																	// percents
																	// and
																	// calculate
																	// inverse
			//	//D.b("alpha: " + alpha);

				double z = nd.inverseCumulativeProbability((alpha / 2));
				// double z = 1 - (alpha/2);
				// z = abs(z);
				double z2 = z * z;
			//	//D.b("z is " + z + " z2 is " + z2);

				double p = proportion / 100;
				double q = 1 - p;
				double ci2 = confidenceInterval / 100; // get rid of percents
				ci2 = ci2 * ci2; // square it.

				// double ciSquared
			//	//D.b("ci2 is " + confidenceInterval + " squared it is " + ci2);

				////D.b("p = " + p + ", q = " + q + ", z " + z + ", CI2 " + ci2 + ".");

				// double n0 = (z * z * p * q ) / ciWidth * ciWidth;

				// //D.b("n0 = " + n0);

				n0 = z2 * p * q / ci2;
			//	//D.b(" SRSCalculator: Before fpc: n0 = " + n0);

				// Now calculate finite population correction

				// now do finite population correction
				// m_nn = RoundUp(m_dn0 / ( 1 + ((m_dn0 - 1)/m_lTargetPop ) ) );
				fpc = 1 / ((1 + ((n0 - 1) / population)));
				
				n = n0 * fpc;
				// Now that calculations are done, round the results to whole
				// numbers
				n = Math.ceil(n0 * fpc);
				n0 = Math.ceil(n0);
				//D.b("n is " + n);

			//	//D.b("Calculate: fpc is " + fpc + " and adjusted n = " + n);
				
				//D.b("SRSCalculator.calculate: n0 is" + n0 + "f pc is " + fpc + " and n = " + n);
				// showResults(n0, fpc, n);

//				 view.update(n0, fpc, n);
				
				/**RETURN CONTROL TO DOCUMENT *******
			}
	*/	
		
		/***************** Getters and setters ****/
		public static double getClustersNeeded()
			{
				return clustersNeeded;
			}


		public static double getDesignEffect()
			{
				
				return designEffect;
			}


/*		public static double getClustersNeeded()
			{
				// TODO Auto-generated method stub
				return 0;
			}
*/
		
		
	


	}
