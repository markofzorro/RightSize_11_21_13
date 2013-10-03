/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rightSize;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author markwhite
 */
public class SRSView extends RSInternalFrame
  {
	SRSDoc doc = null;
	SRSResultsPanel resultsPanel = null;
	SRSInputPanel inputPanel = null;
	
	//SRSButtonPanel pb = null; Not a class
	// begin variable declarations
	
	 private javax.swing.JButton okButton;
	    private javax.swing.JButton cancelButton;
	   
	
	
	
	
	
	
    private JPanel buttonPanel;
    
   
    //end variable declarations
	
   
    /**
     * Creates new Internal Frame for user interactions for simple random sample calculations. 
     */
    public SRSView(SRSDoc doc)
      {
    	 super("Simple Random Sample"); // Sets the title of RSInternalFrame. this allows us to keep count of the panels
    	  
    	  // super("Simple Random Sample");
    	//  setTitle("Simple Random Sample");
        this.doc = doc;
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      
        
   /*
    * Inherits box layout from RSInternalPane. this shows components vertically from top to bottom
    */
        
        inputPanel = new SRSInputPanel();
        this.add(inputPanel);
        resultsPanel = new SRSResultsPanel();
        this.add(resultsPanel);
        initComponents();
    	
    			 
    			
    }


   

private void initButtonPanel()
    {
    	buttonPanel = new JPanel();
    	buttonPanel.setLayout(new FlowLayout());
    	cancelButton = new JButton("Cancel");
    	cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 24));
    	cancelButton.addActionListener( new ActionListener()
    	{
    	    public void actionPerformed(ActionEvent e)
    	    {
    	    	dispose();
    	        // System.out.println("OK button Clicked.");
    	    }
    	});
    	buttonPanel.add(cancelButton);
    	
    	
    	// add buttonPanel to internal frame
    	
    	
    	okButton = new JButton("OK");
    	okButton.setFont(new java.awt.Font("Lucida Grande", 0, 24));
    	okButton.addActionListener( new ActionListener()
    	{
    	    public void actionPerformed(ActionEvent e)
    	    {
    	      
    	    		doc.setVariables();
    	    	
    	     
    	    }
    	});
    	buttonPanel.add(okButton);
    	
    	
    }	
   
   
    
    private void initComponents()
    {
    	initButtonPanel();
    	getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
    
    public void update(double n0, double n)
    	{
    		resultsPanel.set_n0Label(n0);
    		resultsPanel.set_nLabel(n);
    		
    	}
    
    


    /***************getters and setters *********************/
    public String getPopString()
    {
    	return inputPanel.getPopString();
    }
    
   public String getProportionString()
    	{
    		return inputPanel.getProportionString();
    	}
    
    public String getCIString()
    	{
    		return inputPanel.getCIString();
    	}
    
    public String getCCString()
    	{
    		return inputPanel.getCCString();
    	}
    
    public void set_n0(double n0)
    	{
    		resultsPanel.set_n0Label(n0);
    	}
    
    public void set_n(double n)
    	{
    		resultsPanel.set_nLabel(n);
    	}
    
    
/*	setProportion(view.getProportion());
	setCI(view.getCI());
	setCC(view.getCC());
  */  
	                                              

/*******end getters and setters *****************/
  
    /**
     * @param args the command line arguments
     */
  	 
  }
