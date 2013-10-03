/**
 * 
 */
package rightSize;

import javax.swing.JDesktopPane;

/**
 * @author markofzero
 *
 */
public class ClusterDoc extends SRSDoc
{
	//JDesktopPane desktop;
	

	/**
	 * 
	 */
	public ClusterDoc(JDesktopPane desktop)
		{
			super(desktop);
			this.desktop = desktop;
			
		//	srsViewview = new ClusterFuckView(this);
			D.b("reached Clusterfuck().");
			
			
		}
	
	protected void setView()
		{
			view = new ClusterView(this, "Cluster Sample");
			view.setVisible(true); // necessary as of 1.3
			D.b("CFDoc: view is " + view);
			desktop.add(view);
			try
				{
					view.setSelected(true);
				} catch (java.beans.PropertyVetoException e)
				{
				}
		}

}
