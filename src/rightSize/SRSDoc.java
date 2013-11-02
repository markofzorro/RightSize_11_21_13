package rightSize;

import javax.swing.JDesktopPane;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Document handles all calculations, views, and graphs for SRS.<br>
 * 
 * SRS
 * 
 * @author markofzero
 * wxtends RSDocBase
 * 
 */
public class SRSDoc extends RSDocBase
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
				//setVariables();

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
				
				setVariables();
				
				
				D.b("SRSDoc.calculate Just called setVariables. population is " + population
						+ "  proportions is " + proportion + ". CI is "
						+ confidenceInterval + " CC is "
						+ confidenceCoefficient);
				
				RSCalculator.calculate(population, proportion,
						confidenceInterval, confidenceCoefficient);
				n0 = RSCalculator.getN0();
				n = RSCalculator.getN();
				fpc = RSCalculator.getFpc();

				D.b("SRSDoc.Calculate: n is " + n + " fpc is " + fpc
						+ " and adjusted n = " + n);

				// D.b("Calculate: n0 is" + n0 + "fpc is " + fpc + " and n = " +
				// n);
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
				// D.b("doc:setVariables(): ");
				// D.b("pop = " + population + ". proportion = " + proportion
				// + ". ci = " + confidenceInterval + " cc = "
				// + confidenceCoefficient);

			}

		/*
		 * void graph() { // D.b("Reached SRSDoc.graph()"); chartDoc = new
		 * RSChartDoc<Object>(this, "SRS Chart"); }
		 */
		public void getCalculationResults(double n0, double fpc, double n)
			{
				this.n0 = n0;
				this.fpc = fpc;
				this.n = n;

				// D.b("Doc getCalculationResult(): n0 is " + n0 + " fpc = " +
				// fpc
				// + "n = " + n);
				view.update(n0, fpc, n);
			}

		public double get_n0()
			{
				return n0;

			}

	} // end of SRSDocument
