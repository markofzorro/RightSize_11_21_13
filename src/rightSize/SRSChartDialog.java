package rightSize;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class SRSChartDialog extends JInternalFrame
	{

		/**
		 * Launch the application.
		 */
		public static void main(String[] args)
			{
				EventQueue.invokeLater(new Runnable() {
					public void run()
						{
							try
								{
									SRSChartDialog frame = new SRSChartDialog();
									frame.setVisible(true);
								} catch (Exception e)
								{
									e.printStackTrace();
								}
						}
				});
			}

		/**
		 * Create the frame.
		 */
		public SRSChartDialog()
			{
				setBounds(100, 100, 450, 300);
				add(new JLabel("InternalFrameDialog"));

			}

	}
