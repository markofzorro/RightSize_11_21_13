package charts;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SRSChartDialog extends JInternalFrame
	{
		JPanel buttonPanel = null;
	

		public SRSChartDialog()
		{
			setBounds(100, 100, 450, 300);
			add(new JLabel("InternalFrameDialog"));
			
			initButtonPanel();
			buttonPanel.setVisible(true);
			add(buttonPanel);
		}
			private void initButtonPanel()
				{
					buttonPanel = new JPanel();
					buttonPanel.setLayout(new FlowLayout());
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 24));
					cancelButton.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e)
							{
								//dispose();
								System.out.println("OK button Clicked.");
							}
					});
					buttonPanel.add(cancelButton);
				}
			
							
		
		

		
		
		
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


	}
	
