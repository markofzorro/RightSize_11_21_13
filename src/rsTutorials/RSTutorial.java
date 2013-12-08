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

package rsTutorials;

/**
 * This application that requires the following additional files:
 *   TreeDemoHelp.html
 *    arnold.html
 *    bloch.html
 *    chan.html
 *    jls.html
 *    swingtutorial.html
 *    tutorial.html
 *    tutorialcont.html
 *    vm.html
 */
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;

public class RSTutorial extends JPanel
                      implements TreeSelectionListener 
{
	private static JDesktopPane desktop = null;
	private JEditorPane htmlPane;
    private JTree tree;
    private URL helpURL;
    private static boolean DEBUG = false;

    //Optionally play with line styles.  Possible values are
    //"Angled" (the default), "Horizontal", and "None".
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    
    //Optionally set the look and feel.
    private static boolean useSystemLookAndFeel = false;

		public RSTutorial(JDesktopPane desktop_arg)
			{
				super(new GridLayout(1, 0));
				this.desktop = desktop_arg;
			       desktop.add(this);
			       this.setVisible(true);
				

				// Create the nodes.
				DefaultMutableTreeNode top = new DefaultMutableTreeNode(
						"RightSize Turorial");
				createNodes(top);

				// Create a tree that allows one selection at a time.
				tree = new JTree(top);
				tree.getSelectionModel().setSelectionMode(
						TreeSelectionModel.SINGLE_TREE_SELECTION);

				// Listen for when the selection changes.
				tree.addTreeSelectionListener(this);

				if (playWithLineStyle)
					{
						System.out.println("line style = " + lineStyle);
						tree.putClientProperty("JTree.lineStyle", lineStyle);
					}

				// Create the scroll pane and add the tree to it.
				JScrollPane treeView = new JScrollPane(tree);

				// Create the HTML viewing pane.
				htmlPane = new JEditorPane();
				htmlPane.setEditable(false);
				initHelp();
				JScrollPane htmlView = new JScrollPane(htmlPane);

				// Add the scroll panes to a split pane.
				JSplitPane splitPane = new JSplitPane(
						JSplitPane.HORIZONTAL_SPLIT);
				splitPane.setTopComponent(treeView);
				splitPane.setBottomComponent(htmlView);

				Dimension minimumSize = new Dimension(200, 100);
				htmlView.setMinimumSize(minimumSize);
				treeView.setMinimumSize(minimumSize);
				splitPane.setDividerLocation(250);
				splitPane.setPreferredSize(new Dimension(1200, 600));

				// Add the split pane to this panel.
				add(splitPane);

				createAndShowGUI();
			}

    /** Required by TreeSelectionListener interface. */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            PageInfo book = (PageInfo)nodeInfo;
            displayURL(book.pageURL);
            if (DEBUG) {
                System.out.print(book.pageURL + ":  \n    ");
            }
        } else {
            displayURL(helpURL); 
        }
        if (DEBUG) {
            System.out.println(nodeInfo.toString());
        }
    }

    private class PageInfo {
        public String pageName;
        public URL pageURL;

        public PageInfo(String page, String filename) {
            pageName = page;
            pageURL = getClass().getResource(filename);
            if (pageURL == null) {
                System.err.println("Couldn't find file: "
                                   + filename);
            }
        }

        public String toString() {
            return pageName;
        }
    }

    private void initHelp() {
        String s = "/htmls/Welcome.html";
        helpURL = getClass().getResource(s);
        if (helpURL == null) {
            System.err.println("Couldn't open help file: " + s);
        } else if (DEBUG) {
            System.out.println("Help URL is " + helpURL);
        }

        displayURL(helpURL);
    }

    private void displayURL(URL url) {
        try {
            if (url != null) {
                htmlPane.setPage(url);
            } else { //null url
		htmlPane.setText("File Not Found");
                if (DEBUG) {
                    System.out.println("Attempted to display a null URL.");
                }
            }
        } catch (IOException e) {
            System.err.println("Attempted to read a bad URL: " + url);
        }
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode page = null;

        category = new DefaultMutableTreeNode("Formulas");
        top.add(category);

      
        page = new DefaultMutableTreeNode(new PageInfo("Simple Random Sample Formula", "/htmls/Simple-Random-Samples.html"));
        category.add(page);

        //Tutorial Continued
        /*
        //JFC Swing Tutorial
        page = new DefaultMutableTreeNode(new PageInfo
            ("The JFC Swing Tutorial: A Guide to Constructing GUIs",
            "swingtutorial.html"));
        category.add(page);

        //Bloch
        page = new DefaultMutableTreeNode(new PageInfo
            ("Effective Java Programming Language Guide",
	     "bloch.html"));
        category.add(page);

        //Arnold/Gosling
        page = new DefaultMutableTreeNode(new PageInfo
            ("The Java Programming Language", "arnold.html"));
        category.add(page);

        //Chan
        page = new DefaultMutableTreeNode(new PageInfo
            ("The Java Developers Almanac",
             "chan.html"));
        category.add(page);

        category = new DefaultMutableTreeNode("Blah, blah, blady-blah");
        top.add(category);
*/
        category = new DefaultMutableTreeNode("Camotes are Good for Youu");
        top.add(category);

        page = new DefaultMutableTreeNode(new PageInfo
                ("Try Other Veggies, Why Don't You?", "/htmls/OtherVegetables.html"));
            category.add(page);
            
            page = new DefaultMutableTreeNode(new PageInfo
                    ("Pass the Camotes",
                     "/htmls/blah-blah.html"));
                category.add(page);

/*
        //VM
        page = new DefaultMutableTreeNode(new PageInfo
            ("The Java Virtual Machine Specification",
             "vm.html"));
        category.add(page);

        //Language Spec
        page = new DefaultMutableTreeNode(new PageInfo
            ("The Java Language Specification",
             "jls.html"));
        category.add(page);
  */
    }
        
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
            
     
        }

        //Create and set up the window.
      //  JFrame frame = new JFrame("Tutorals");
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           }

 /*   public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    */
}
