
package rsTutorials;

import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesAndUtilites.D;
import basesAndUtilites.RSInternalFrame;

/**
 * Draws the internal frame and displays the tutorial
 * tree view in it.
 * @author markofzero
 *
 */
public class RSTutorialView extends RSInternalFrame
	{
		private static JDesktopPane desktop = null;
		private JPanel contentPane = null;

		public RSTutorialView(JDesktopPane desktop)
			{
				super("RSTutorialView");
				
				D.b("Reached RSTutorialView.");
				this.desktop = desktop;
				
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				// contentPane.setLayout(new BorderLayout(0, 0));
				contentPane.setLayout(new BoxLayout(contentPane,
						BoxLayout.Y_AXIS));
				setContentPane(contentPane);
				setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				

				/*
				 * Inherits box layout from RSInternalPane. this shows
				 * components vertically from top to bottom
				 */

				//initComponents();
				

				RSTreePanel treePanel = new RSTreePanel();
				treePanel.setVisible(true);
				add(treePanel);
				
				
				this.setVisible(true);
				pack();
				desktop.add(this);
				
			}

	}
