package cluster;

import org.apache.commons.math3.distribution.NormalDistribution;

import basesAndUtilites.D;

/**
 * Declare static so won't have the overhead of creating new object every time
 * you use repetitively.<br>
 * 
 * Calculates sample size as SRS, then calculates design effect and multiply
 * SRS sample size by design effect.
 * 
 * 
 * @author markofzero
 * 
 */
public class ClusterCalculator
	{
		static private double population = 0;
		static private double proportion = 0;
		static private double confidenceInterval = 0;
		static private double confidenceCoefficient = 0;
		static private double n0 = 0;
		//static private double fpc = 0;
		static private double n = 0;

		static private double clusterSize = 0;
		static private double roh = 0;
		static private double designEffect = 0;
		static private double clustersNeeded = 0;

		static public void calculate(double arg_population,
				double arg_proportion, double arg_confidenceInterval,
				double arg_confidenceCoefficient, double arg_culsterSize,
				double arg_roh)
			{

				// Assign class-level vars
				population = arg_population;
				proportion = arg_proportion;
				confidenceInterval = arg_confidenceInterval;
				confidenceCoefficient = arg_confidenceCoefficient;
				clusterSize = arg_culsterSize;
				roh = arg_roh;

				/*******
				 * Formula from Cochran (1963:75) *** n0 = z2pq/e2 where z2 = z
				 * squared e = confidence interval
				 */

				// Standard Normal Distribution has mean of 0 and SD of 1.
				NormalDistribution nd = new NormalDistribution(0, 1);

				double alpha = 1 - (confidenceCoefficient / 100); // get rid of
																	// percents
																	// and
																	// calculate
																	// inverse

				double z = nd.inverseCumulativeProbability((alpha/2));
			//	D.b("invCumulativePropabilty says: alpha is " + alpha + " z is " + z );
			//	z = 1.96; //debugger/
				
				double z2 = z * z;
				double p = proportion / 100;
				double q = 1 - p;
				double ci2 = confidenceInterval / 100; // get rid of percents
				ci2 = ci2 * ci2; // square it.

				n0 = z2 * p * q / ci2;
				n0 = Math.ceil(n0);

				// Now just multiply SRS calculation by design effect.
				
				designEffect = 1 + (clusterSize - 1) * roh;
				n = n0 * designEffect;

				n = Math.ceil(n);
				clustersNeeded = n / clusterSize;
				clustersNeeded = Math.ceil(clustersNeeded);

				/** RETURN CONTROL TO DOCUMENT *******/
			}

		/***************** Getters and setters ****/
	

		static public double getN0() // for SRS
			{

				return n0 > 0 ? n0 : 0;
			}

		static public double getN() // For SRS
			{
				return n > 0 ? n : 0;
			}

		static public double getDesignEffect()
			{
				return designEffect;
			}

		static public double getClustersNeeded()
			{
				return clustersNeeded;
			}
/*
		
		public static void main(String[] args)
			{
				// SRSCalculator calc = new SRSCalculator();
				ClusterCalculator.calculate(1000, 50, 5, 95, 20, 0.02);
				D.b("n0 is " + ClusterCalculator.getN0() + " D is "
						+ ClusterCalculator.getDesignEffect() + " n is: " + ClusterCalculator.getN()
						+ " we need " + ClusterCalculator.getClustersNeeded() + " clusters");

			}
*/
		
	}
