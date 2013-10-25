package rightSize;

import javax.swing.JDesktopPane;

import org.apache.commons.math3.distribution.NormalDistribution;


/**
 * Document handles all calculations, views, and graphs for
 * SRS.<br>
 * 
 * SRS
 * @author markofzero
 * @param <RSDocBase>
 *
 */
public class SRSDoc<RSDocBase> extends DocBase
	{

		private RSChartDoc chartDoc = null;
		SRSView view = null;

		protected double n0 = 0;
		protected double n = 0;
		protected double fpc = 0;

		/**
		 * Constructor creates a view to gather input and display results. When
		 * the view is finished and OK is clicked, the view calls the doc's
		 * calculate method and hands control back to the doc.
		 * 
		 * @param desktop
		 */

		public SRSDoc(JDesktopPane desktop)
			{
				this.desktop = desktop;

				setView();
				setVariables();
			}

		/*
		 * protected void graph() { LMZChart chart = new LMZChart();
		 * 
		 * }
		 */

		// calculator = new SRSCalculator(this, population, proportion,
		// confidenceInterval, confidenceCoefficient);

		void calculate()
			{
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
				//D.b("z is " + z + " z2 is " + z2);

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
		//		D.b("n0 = " + n0);

				// Now calculate finite population correction

				// now do finite population correction
				// m_nn = RoundUp(m_dn0 / ( 1 + ((m_dn0 - 1)/m_lTargetPop ) ) );
				fpc = 1 / ((1 + ((n0 - 1) / population)));
				

				// Now that calculations are done, round the results to whole
				// numbers
				n = roundUp(n0 * fpc);
				n0 = roundUp(n0);

			//	D.b("Calculate: fpc is " + fpc + " and adjusted n = " + n);
				
			//	D.b("Calculate: n0 is" + n0 + "fpc is " + fpc + " and n = " + n);
				// showResults(n0, fpc, n);

				 view.update(n0, fpc, n);
			}

		/****************** Getters and Setters ******************/

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
		 * Loads variables into the document's class-level vars. It gets the
		 * values as strings from the input view and passes them to specialized
		 * methods for parsing and validation.
		 */
		public void setVariables()
			{
				setPop(view.getPopString());
				setProportion(view.getProportionString());
				setCI(view.getCIString());
				setCC(view.getCCString());
		//		D.b("doc:setVariables(): ");
			//	D.b("pop = " + population + ". proportion = " + proportion
			//			+ ". ci = " + confidenceInterval + " cc = "
				//		+ confidenceCoefficient);

			}
		
/*		void graph()
			{
			//	D.b("Reached SRSDoc.graph()");
				chartDoc = new RSChartDoc<Object>(this, "SRS Chart");
			}
*/
		public void getCalculationResults(double n0, double fpc, double n)
			{
				this.n0 = n0;
				this.fpc = fpc;
				this.n = n;

		//		D.b("Doc getCalculationResult(): n0 is " + n0 + " fpc = " + fpc
		//				+ "n = " + n);
				view.update(n0, fpc, n);
			}

		public double get_n0()
			{
				return n0;

			}

	} // end of SRSDocument
