
package rsTutorials;

import javax.swing.JDesktopPane;

import basesAndUtilites.D;


/**
 * This controls the tutorial and it's view.
 * @author markofzero
 *
 */
public class RSTutorialDoc
{
	private JDesktopPane desktop = null;

		public RSTutorialDoc(JDesktopPane desktop)
			{
				this.desktop = desktop;
				D.b("Reached RSTutorialDoc.");
				RSTutorialView view = new RSTutorialView(desktop);

			}
}