package charts;

import javax.swing.JDesktopPane;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import srs.SRSDoc;
import basesAndUtilites.D;
import basesAndUtilites.RSInternalFrame;
import basesAndUtilites.RSVariations;


public class RSChartDoc
	{
		//private SRSDoc doc = null;
		private JDesktopPane desktop = null;
		private double population = 0;
		private double proportion = 0;
		private double confidenceInterval = 0;
		private double confidenceCoefficient = 0;
		private String choice = null;
		
		private int cols = 11;  //Number of columns in chart.
		
		
		
		
		// public RSChartDoc(JDesktopPane desktop)
		/*public RSChartDoc(JDesktopPane desktop)
			{
				// For now use dummy dummy chart
				
				this.desktop = desktop;
				D.b("In RSChartDoc constructor.");
				createChartFrame();
				
				
				
			}
		*/
		
		
		public RSChartDoc(JDesktopPane desktop, double population, double proportion, double confidenceInterval, double confidenceCoeffecient, String choice)		
		{
			//this.doc = doc; doesn't seem to work. Don't know why. desktop = doc.getDesktop();
			
			// set fields/class vars
			this.desktop = desktop;
			this.population = population;
			this.proportion = proportion;
			this.confidenceInterval = confidenceInterval;
			this.confidenceCoefficient = confidenceCoefficient;
			this.choice = new String(choice); // create a new string to be sure the argument doesn't disappear somewhere.
			
			
			
			this.desktop = desktop; 
			if("srs".equals(choice))
				;
			
			
			
			
			
			
			D.b("In RSChartDoc constructor. Choice is " + choice);
			createChartFrame();
		
			
		}

		
			

			




				// Create a new internal frame.
				public void createChartFrame()
					{
						//RSCategoryDataset dataClass = new RSCategoryDataset();
						//CategoryDataset dataset = dataClass.createDataset();
						
						RSInternalFrame internalFrame = new RSInternalFrame("Charting The Effects of Assumptions on Sample Size");
						internalFrame.setSize(800, 700);
						RSTabbedChartPanel tabby = new RSTabbedChartPanel();
						RSChartPanel chartPanel = new RSChartPanel();
						
						internalFrame.add(tabby);
						
						createDataset();
						
					//	varyAssumption
						desktop.add(internalFrame);
						internalFrame.setVisible(true); // necessary as of 1.3
					//	desktop.add(frame);
						try
							{
								internalFrame.setSelected(true);
							} catch (java.beans.PropertyVetoException e)
							{
							}
							
					
					}
				
				CategoryDataset createDataset()
					{
						varyAssumptions();
						return null;
					}
				
				
				
				CategoryDataset createDummyDataset()
					{

						// row keys...
						String series1 = "First";
						String series2 = "Second";
						String series3 = "Third";

						// column keys...
						String type1 = "Type 1";
						String type2 = "Type 2";
						String type3 = "Type 3";
						String type4 = "Type 4";
						String type5 = "Type 5";
						String type6 = "Type 6";
						String type7 = "Type 7";
						String type8 = "Type 8";

						// create the dataset...
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

						dataset.addValue(1.0, series1, type1);
						dataset.addValue(4.0, series1, type2);
						dataset.addValue(3.0, series1, type3);
						dataset.addValue(5.0, series1, type4);
						dataset.addValue(5.0, series1, type5);
						dataset.addValue(4.0, series1, type6);
						dataset.addValue(3.0, series1, type7);
						dataset.addValue(2.0, series1, type8);

						dataset.addValue(3.0, series2, type1);
						dataset.addValue(3.0, series2, type2);
						dataset.addValue(3.0, series2, type3);
						dataset.addValue(8.0, series2, type4);
						dataset.addValue(4.0, series2, type5);
						dataset.addValue(4.0, series2, type6);
						dataset.addValue(4.0, series2, type7);
						dataset.addValue(4.0, series2, type8);

						dataset.addValue(4.0, series3, type1);
						dataset.addValue(3.0, series3, type2);
						dataset.addValue(2.0, series3, type3);
						dataset.addValue(3.0, series3, type4);
						dataset.addValue(6.0, series3, type5);
						dataset.addValue(3.0, series3, type6);
						dataset.addValue(4.0, series3, type7);
						dataset.addValue(3.0, series3, type8);

						return dataset;

					}
	
				private double[] varyAssumptions()
					{
					
						// First, let's do proportion
						
						
						// assumption is proportion
						double[] retVal = RSVariations.add(proportion, cols);
						
						for (int i = 0; i < cols; i++)
							D.b("retVal array[" + i + "] is " + retVal[i]);
							
							return retVal;
					}

					
	}
