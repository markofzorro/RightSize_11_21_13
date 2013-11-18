package srs;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import org.apache.commons.math3.distribution.NormalDistribution;

import basesAndUtilites.D;
import basesAndUtilites.RSCalculator;
import basesAndUtilites.RSDocBase;
import charts.RSChartDoc;

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
	//	protected double assumption = 0;
		protected static double min = 1;
		protected static double max = 99;
		private JDesktopPane desktop = null;

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
		public JDesktopPane getDesktop()
			{
				D.b("SRSDoc:getDesktop: desktop is " + desktop);
				return desktop;
				
			}
		
		
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

				 D.b("Doc getCalculationResult(): n0 is " + n0 + " fpc = " +
				 fpc
				+ "n = " + n);
				view.update(n0, fpc, n);
			}

		public double get_n0()
			{
				return n0;

			}

		public void chart()
			{	
					D.b("SRSDoc.chart: confidenceCoefficient is " + confidenceCoefficient);
					RSChartDoc chartDoc = new RSChartDoc(desktop, population, proportion, confidenceInterval, confidenceCoefficient, "srs");
				
				 
					
			}
		
		
		
		/************ ERnd Getters and Setters **********/
	} // end of SRSDocument
