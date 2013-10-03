package rightSize;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// ERASEME: TOWER GITHUB TEST!
public class ClusterView extends SRSView
{	
	ClusterDoc doc;
	
	
	public ClusterView(ClusterDoc doc, String title)
		{
			super(doc, title);
			//super.setTitle("Cluster Sample");
			this.doc = doc;
			D.b("Reached ClusterView(): doc is " + doc);
			
			
			
		}

}
