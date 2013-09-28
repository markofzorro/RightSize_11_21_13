/**
 * 
 */
package rightSize;

import java.awt.BorderLayout;

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
			super(title + " " + (++openFrameCount), true, // resizable
					true, // closable
					true, // maximizable
					true);// iconifiable

			// ...Create the GUI and put it in the window...
			
			JPanel contentPane = new JPanel(new BorderLayout());
			setContentPane(contentPane);

			// ...Then set the window size or call pack...
			setSize(600, 600);

			// Set the window's location.
			setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		
			// maybe this belongs in SRSView. etc.
			setVisible(true);
		}

	
	}
