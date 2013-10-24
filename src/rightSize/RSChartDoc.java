package rightSize;

import javax.swing.JDesktopPane;


public class RSChartDoc<RSDocBase> extends DocBase
{
	private  ChartView view = null;
	
//	private Calculator calculator = null;
	
	
	
	/**
	 * Constructor creates a view to gather input and display results.
	 * When the view is finished and OK is clicked, the view calls the
	 * doc's calculate method and hands control back to the doc. 
	 * 
	 * @param desktop
	 */
	
	// Debugger
	public RSChartDoc()
		{
			D.b("Reached ChartDoc no arg constructor.");
		}
	
	public RSChartDoc(SRSDoc srsDoc) 
	{
		//this.desktop = desktop;
		D.b("Reached ChartDoc srsDoc constructor.");
		
	//	setView();
		
	}
	
	// Overloading constructor seems to work.
	public RSChartDoc(ClusterDoc clusterDoc)
		{
			
		}
	
	protected void setView()
		{
			view = new ChartView(this, "ChartView");
			view.setVisible(true); // necessary as of 1.3
			desktop.add(view);
			try
				{
					view.setSelected(true);
				} catch (java.beans.PropertyVetoException e)
				{
				}
		}
	
	/************** Getters ****************/
	
//	private get
	
	
}