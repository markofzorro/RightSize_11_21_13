/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package cluster;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import basesAndUtilites.D;

import java.util.*;
import java.text.SimpleDateFormat;

/* ComboBoxDemo2.java requires no other files. */
public class ClusterRohComboBox extends JPanel implements ActionListener
	{
		static JFrame frame;
		JLabel result;
		String rohChoice;
		double roh;
		ClusterPanel panel = null;

		public ClusterRohComboBox(ClusterPanel panel)
			{
				this.panel = panel;
				
				setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
				String[] rohExamples = { "Demographic Variables: 0.02",
						"Prevalence of an Infectious Disease: 0.3",
						"Prevalence of Illness in General: 0.02",
						"Low Utilization of Health Cares Services: 0.1",
						"High Utilization of Health Cares Services: 0.3", };

				rohChoice = rohExamples[0];

				// Set up the UI for selecting an roh

				JLabel titleLabel1 = new JLabel(
						"Estimates of Rate of Homogeneity are based on");
				JLabel titleLabel2 = new JLabel(
						"results of previous surveys in your population.");
				JLabel titleLabel2_5 = new JLabel(
						"See tutorial for instructions.");
				
				JLabel titleLabel3 = new JLabel("Or, select one from this list.");
				// JLabel titleLabel4 = new JLabel("Select one from the list:");

				JComboBox box = new JComboBox(rohExamples);
				box.setEditable(true);
				box.addActionListener(this);

				// Create the UI for displaying result.
				JLabel resultLabel = new JLabel("Current Date/Time",
						JLabel.LEADING); // == LEFT
				result = new JLabel(" ");
				result.setForeground(Color.black);
				result.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.black),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));

				// Lay out everything.
				JPanel rohPanel = new JPanel();
				rohPanel.setLayout(new BoxLayout(rohPanel, BoxLayout.PAGE_AXIS));
				rohPanel.add(titleLabel1);
				rohPanel.add(titleLabel2);
				rohPanel.add(titleLabel3);
				// rohPanel.add(titleLabel4);
				box.setAlignmentX(Component.LEFT_ALIGNMENT);
				rohPanel.add(box);

				/*
				 * JPanel resultPanel = new JPanel(new GridLayout(0, 1));
				 * resultPanel.add(resultLabel); resultPanel.add(result);
				 */
				rohPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
				// resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

				add(rohPanel);
				add(Box.createRigidArea(new Dimension(0, 10)));
				// add(resultPanel);

				setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

				// reformat();
			} // constructor

		public void actionPerformed(ActionEvent e)
			{
				JComboBox cb = (JComboBox) e.getSource();
				rohChoice = (String) cb.getSelectedItem();

				// //Indices start at 0, so 4 specifies the pig.
				//JComboBox petList = new JComboBox(petStrings);
			//	petList.setSelectedIndex(4);
				// send the new roh to the document to be used in calculation.
				if ("Demographic Variables: 0.02".equals(rohChoice))
					panel.setRohString(0.02);
				else if ("Prevalence of an Infectious Disease: 0.3"
						.equals(rohChoice))
					roh = 0.3;
				else if ("Prevalence of Illness in General: 0.02"
						.equals(rohChoice))
					roh = 0.02;
				else if ("Low Utilization of Health Cares Services: 0.1"
						.equals(rohChoice))
					roh = 0.1;
				else if ("High Utilization of Health Cares Services: 0.3"
						.equals(rohChoice))
					roh = 0.3;
				D.b("Selected: " + rohChoice);
				D.b("rohChoice is " + roh);

			}
		
		public void setChoice(String choice)
			{
				
			}

	}
