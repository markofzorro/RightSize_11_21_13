package rightSize;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Declare static so won't have the overhead of creating new object every time you
 * repetively 
 * @author markofzero
 *
 */
public class RSCalculator
	{
		static private double population = 0;
		static private double proportion = 0;
		static private double confidenceInterval = 0;
		static private double  confidenceCoefficient = 0;
		static private double n0 = 0;
		static private double fpc = 0;
		static private double n = 0;
		
		private double roh = 0;
		private double designEffect = 0;
		
		
		
		static public void calculate(double arg_population, double arg_proportion, double arg_confidenceInterval, double arg_confidenceCoefficient )
			{
				
				
				// Assign class-level vars
				population = arg_population;
				proportion = arg_proportion;
				confidenceInterval = arg_confidenceInterval;
				confidenceCoefficient = arg_confidenceCoefficient;
				
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
			//	D.b("alpha: " + alpha);

				double z = nd.inverseCumulativeProbability((alpha / 2));
				// double z = 1 - (alpha/2);
				// z = abs(z);
				double z2 = z * z;
				D.b("z is " + z + " z2 is " + z2);

				double p = proportion / 100;
				double q = 1 - p;
				double ci2 = confidenceInterval / 100; // get rid of percents
				ci2 = ci2 * ci2; // square it.

				// double ciSquared
			//	D.b("ci2 is " + confidenceInterval + " squared it is " + ci2);

				//D.b("p = " + p + ", q = " + q + ", z " + z + ", CI2 " + ci2 + ".");

				// double n0 = (z * z * p * q ) / ciWidth * ciWidth;

				// D.b("n0 = " + n0);

				n0 = z2 * p * q / ci2;
				D.b("n0 = " + n0);

				// Now calculate finite population correction

				// now do finite population correction
				// m_nn = RoundUp(m_dn0 / ( 1 + ((m_dn0 - 1)/m_lTargetPop ) ) );
				fpc = 1 / ((1 + ((n0 - 1) / population)));
				

				// Now that calculations are done, round the results to whole
				// numbers
				n = Math.ceil(n0 * fpc);
				n0 = Math.ceil(n0);

			//	D.b("Calculate: fpc is " + fpc + " and adjusted n = " + n);
				
				D.b("Calculate: n0 is" + n0 + "fpc is " + fpc + " and n = " + n);
				// showResults(n0, fpc, n);

//				 view.update(n0, fpc, n);
				
				/**RETURN CONTROL TO DOCUMENT *******/
			}

		
		/** for SRS */

		static public double getN0() // for SRS
			{
				
				return n0 > 0? n0: 0;
			}
		static public double getFpc() // For SRS
			{
				return fpc > 0? fpc: 0;
			}
		static public double getN()	// For SRS
			{
				return n > 0? n: 0;
			}
		
/**** For Cluster ******/
		
	}
