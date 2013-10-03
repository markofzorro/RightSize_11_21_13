/**
 * 
 */
package rightSize;

import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * @author zero
 * 
 */
/*
 * 
 * 
 * import javax.swing.JInternalFrame;
 * 
 * import java.awt.event.*; import java.awt.*;
 * 
 * /* Used by InternalFrameDemo.java.
 */
public class RSInternalFrame extends JInternalFrame
{
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;

	public RSInternalFrame(String title)
		{
			super("Sample Number " + (++openFrameCount) +  ": A " + title, true, // resizable
					true, // closable
					true, // maximizable
					true);// iconifiable

			// ...Create the GUI and put it in the window...
			
			JPanel contentPane = new JPanel();
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));  // default will display components vertically
			setContentPane(contentPane);

			// ...Then set the window size or call pack...
			setSize(1000, 500);

			// Set the window's location.
			setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		
			// maybe this belongs in SRSView. etc.
		//	setVisible(true);
		}

	
	}
