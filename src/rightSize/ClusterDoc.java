package rightSize;

import javax.swing.JDesktopPane;

public class ClusterDoc
{
	ClusterView view;
	private JDesktopPane desktop;

	public ClusterDoc(JDesktopPane desktop)
		{
			this.desktop = desktop;
			//super(desktop);
			setView();
			
		//	view = new ClusterView(this);
			//view.setVisible(true); // necessary as of 1.3
		//	desktop.add(view);
		//	
			//D.b("ClusterDoc: pop is: " + population);
			// TODO Auto-generated constructor stub
		}
	
	protected void setView()
		{
			
			view = new ClusterView(this);
			D.b("In setView view is " + view);
			try
				{
					view.setSelected(true);
				} catch (java.beans.PropertyVetoException e)
				{
				}
			view.setVisible(true); // necessary as of 1.3
			desktop.add(view);
		}

}
