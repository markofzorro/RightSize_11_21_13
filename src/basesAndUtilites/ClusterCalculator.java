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
		static private double totalSubjectsNeeded = 0;
		
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
				 
				
				// Standard Normal Distribution has mean of 0 and SD of 1.
				NormalDistribution nd = new NormalDistribution(0, 1);

				double alpha = 1 - (confidenceCoefficient / 100); // get rid of
																	// percents
																	// and
																	// calculate
																	// inverse
			//	//D.b("alpha: " + alpha);

				double z = nd.inverseCumulativeProbability((alpha / 2));
				z = Math.abs(z);  // get abs value to get rid of negative z, which yields madness
				// double z = 1 - (alpha/2);
				// z = abs(z);
			//	double z2 = z * z;
			//	//D.b("z is " + z + " z2 is " + z2);

				//double p = proportion / 100;
				//double q = 1 - p;
				//double ci2 = confidenceInterval / 100; // get rid of percents
				//ci2 = ci2 * ci2; // square it.

				
				
				// get rid of percents
				proportion = proportion/100; 
				double ci = confidenceInterval/100; // get rid of percents
			
				//double dPrevalence = (double)m_nProportion / 100;  // convert from percents
				
				// CI = SE * dz_alpha, so SE = CI / dz_alpha  
				// convert integer Confidence Coeffecient to floating proportion
			//	double dalpha = (100 - (double)m_nConfidenceLevel)/ 100; 
				// get two sided z value
				// double dz_alpha = invprob ( dalpha / 2 ); // divide by 2 for 2 sided  z	
			//	SetZValue(dalpha);	// get two sided z value
				// calculate standard error
				double standardError = (confidenceInterval/ 100) / z;   
			
				designEffect = (double)(1 + (clusterSize - 1) * roh);
				
				clustersNeeded = ( proportion * (1 - proportion) * designEffect ) / ( standardError * standardError  * clusterSize );
		    
				// round up if there is a fractional part to fClusters
		    
				clustersNeeded = Math.ceil(clustersNeeded);
				
				totalSubjectsNeeded = clustersNeeded * clusterSize;
				 D.b("ClusterCalculator.calculate(): Standard Error is " + standardError + " clustersNeeded is " + clustersNeeded + 
						 ". designEffect is " + designEffect + ". roh is " + roh + ".clusterSize is " + 
						 clusterSize + "CI Width is " + confidenceInterval + ".");
				
			}

		
		
		/***************** Getters and setters ****/
		public static double getClustersNeeded()
			{
				return clustersNeeded;
			}


		public static double getDesignEffect()
			{
				
				return designEffect;
			}



		public static double getClusterSize()
			{
				// TODO Auto-generated method stub
				return clusterSize;
			}


/*		public static double getClustersNeeded()
			{
				// TODO Auto-generated method stub
				return 0;
			}
*/
		
		
	


	}
