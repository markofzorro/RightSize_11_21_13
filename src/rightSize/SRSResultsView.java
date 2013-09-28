/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rightSize;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 *
 * @author markofzero
 */
public class SRSResultsView extends RSInternalFrame 
{
	SRSDoc doc;
	SRSResultsPanel resultsPanel = new SRSResultsPanel();

    /**
     * Creates new form SRSResultsPanel
     */
    public SRSResultsView(SRSDoc doc)
    	{
        super("Simple Random Sample Results");
        this.doc = doc;
        
        setLayout(new BorderLayout());
    		initComponents();
    }

     private void initComponents() 
     {
    	add(resultsPanel, BorderLayout.CENTER);
    	pack();
     }                       

              
}
