package rightSize;

import javax.swing.JDesktopPane;


public class ChartDoc extends DocBase
{

	
	private  ChartView view = null;
//	private RSChart chart = null;
	
	
	
	
	/**
	 * Constructor creates a view to gather input and display results.
	 * When the view is finished and OK is clicked, the view calls the
	 * doc's calculate method and hands control back to the doc. 
	 * 
	 * @param desktop
	 */
	
	public ChartDoc(JDesktopPane desktop) 
	{
		this.desktop = desktop;
		D.b("Reached ChartDoc constructor.");
		setView();
		
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
}