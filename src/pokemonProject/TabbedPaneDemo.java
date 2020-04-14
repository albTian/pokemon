/**
 *  Authors: Albert Tian, Jocelyn Su
 * Date: June 22, 2019
 * Final Project: Pokemon Game
 * Class Description: Graphics for main action panel
 * 
 *
 */
package pokemonProject;
import javax.swing.JTabbedPane;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.*;
import java.io.File;
////////////////////////////////////////////////////////
public class TabbedPaneDemo extends JPanel implements ActionListener,KeyListener,MouseListener{
  public JButton confirm;
 
  public JPanel northPanel = new JPanel();
  public JPanel oppPanel = new JPanel();
  public JPanel centerPanel = new JPanel();
  public JPanel buttonPanel = new JPanel();
  public JPanel obuttonPanel = new JPanel();
  
  public JPanel oppPane = new JPanel();    //create opponent panel
  public JPanel tabbedPane = new JPanel();
  
  public JPanel panelA1 = new JPanel();
  public JPanel panel1 = new JPanel();
  
  public JPanel textPanel = new JPanel();
  public JLabel textLabel = new JLabel("What move do you choose?");
  
  JLabel hplabel,ohplabel, mlabel;
  Image background = Toolkit.getDefaultToolkit().createImage("pokemon-battle-field-background_1779523.jpg");

  public String p1Move,p2Move;
  
  public TabbedPaneDemo() {
   
    BorderLayout layout = new BorderLayout(); //whole jframe is a border layout
    setLayout(layout);
    
    //label
    hplabel = new JLabel("HP: "+Main.p1.get().HP,null,JLabel.CENTER);
    ohplabel = new JLabel("HP: "+Main.p2.get().HP,null, JLabel.CENTER);
    mlabel = new JLabel (Main.p1.trName+ "'s turn",null,JLabel.CENTER);

    //player
    panel1.setLayout(new BorderLayout());
    buttonPanel.setLayout(new GridLayout(2,2));
    tabbedPane.setLayout(new BorderLayout());

   
   //opponent
    panelA1.setLayout(new BorderLayout());
    obuttonPanel.setLayout(new GridLayout(2,2));
    oppPane.setLayout(new BorderLayout());
    
    centerPanel.setLayout(new FlowLayout());
    textPanel.setLayout(new BorderLayout());
    
    //player buttons  
    bMaker(buttonPanel,Main.p1);    
    bMaker(obuttonPanel,Main.p2);
   
    
    //  NEXT BUTTON
    confirm =new JButton("Next text");
    confirm.setActionCommand("confirm");
    textPanel.add(confirm);
    
    //Add the tabbed pane to this panel.
    centerPanel.add(mlabel);
    panel1.add(hplabel,BorderLayout.NORTH);
    panelA1.add(ohplabel,BorderLayout.NORTH);
    
    textPanel.add(textLabel,BorderLayout.CENTER);
    textPanel.add(confirm, BorderLayout.SOUTH);
  
    //////////////////////////////add images to panel
//if both images are the same, initialize the object again
    if(Main.p1.get().pokeName.equals(Main.p2.get().pokeName)) {

      JLabel lprime= new JLabel(getIcon(Main.p1.get().pokeName));
      panelA1.add(lprime, BorderLayout.CENTER);
      
    }
    else panelA1.add(getLabel(Main.p2.get().pokeName), BorderLayout.CENTER);
    
    
    panel1.add(getLabel(Main.p1.get().pokeName),BorderLayout.CENTER);
    panelA1.add(getLabel(Main.p2.get().pokeName), BorderLayout.CENTER);
    
    oppPane.add(panelA1, BorderLayout.EAST);
    tabbedPane.add(panel1, BorderLayout.WEST);
    
    panel1.add(buttonPanel,BorderLayout.SOUTH);
    panelA1.add(obuttonPanel, BorderLayout.SOUTH);

    add(oppPane, BorderLayout.EAST);
    add(tabbedPane, BorderLayout.WEST);
    add(centerPanel,BorderLayout.CENTER);
    add(textPanel, BorderLayout.SOUTH);
    
  }
 

  /** Returns an ImageIcon, or null if the path was invalid. */
  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }

  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from
   * the event dispatch thread.
   */
  public static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("Pokemon");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    BorderLayout layout = new BorderLayout();
    frame.setLayout(layout);

    //Add content to the window.
    frame.add(new TabbedPaneDemo(), BorderLayout.SOUTH);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public ImageIcon getIcon(String e) {

      for(int i =0;i<Main.demo.uh.length;i++) {
        if((Main.demo.pokeNames[i]).equals(e))
          return Main.demo.all[i];
      }
      return null;
    }
  
  public void paintComponent(Graphics g) {
    g.drawImage(background, 0, 0, null);  // Drawing image using drawImage method
  }

  public  void actionPerformed( ActionEvent e)
  {
    //theres a ton of optimization to do here idk if ill have time to do it
    System.out.println("KIaN");
    if(Main.p1.turn) {              //player 1's turn
      for(String p: Main.p1.get().moveArr) {  //finds which button they pressed and the cooresponding move
        if(e.getActionCommand().equals(p)) {  
          textLabel.setText(Main.p1.trName+"'s "+Main.p1.get().pokeName + " uses "+ p + "!" + "\n"+
                    "   What will " + Main.p2.trName + " do?");
          p1Move=p;           
//          dies();             //clearing and replacing the pic and buttons if the pokemon died
          mlabel.setText(Main.p2.trName +"'s turn");
          tover();
//          Main.p1.turn = false;
        }
      }
    }
    
    else if(Main.p2.turn) { //player 2's turn
      for(String p: Main.p2.get().moveArr) {
        if(e.getActionCommand().equals(p)) {
          textLabel.setText(Main.p2.trName+"'s "+Main.p2.get().pokeName + " uses "+ p + "!"+
          "   What will " + Main.p1.trName + " do?");
          p2Move=p;   
//          dies();
          mlabel.setText(Main.p1.trName +"'s turn");
          tover();
//          Main.p2.turn = false;
          
          battle();
          ohplabel.setText("HP: "+Main.p2.get().HP);
          hplabel.setText("HP: "+Main.p1.get().HP);
        }
      }
    }

    
  }
  

  //returns the appropriate label for the pokemon using the pokeNames string array
  public JLabel getLabel(String e) {
    for(int n=0;n<10;n++) {
      if(e.equals(Main.demo.pokeNames[n])) {
        return Main.demo.uh[n];
      }
    }
    return Main.demo.Pikachu;
  }
  
  //Changes the turn fields for both trainers. Makes it the next turn
  public void tover() {   
    Main.p1.turnover();
    Main.p2.turnover();
  }
  
  //again, totally could have used .setText but i didnt realize and well it works
  //so dont fix it if it aint broke
  public void bMaker(JPanel r,Trainer p) {
    for(String f: p.get().moveArr) {
        JButton att = new JButton(f);
        att.addActionListener(this);
        att.setActionCommand(f);
        r.add(att);
      }
  }
  
  //ok so i realize now that you can totally just use .setText instead of deleting 
  //the buttonPanel and redrawing it
  //this method removes the dead pokemon from the trainer and redraws the buttons and pic
  public void dies() {
    if(!Main.p2.get().life) {
      
      Main.p2.trainer.remove(0);        //remove the pokemon from the arraylist
      obuttonPanel.removeAll();         //clear the buttonPanels and main panel
      panelA1.removeAll();
                            //remake the buttons
      bMaker(obuttonPanel,Main.p2);
      ohplabel = new JLabel("HP: "+Main.p2.get().HP,null,JLabel.CENTER);

      panelA1.add(ohplabel, BorderLayout.NORTH);
      panelA1.add(getLabel(Main.p2.get().pokeName),BorderLayout.CENTER);
      panelA1.add(obuttonPanel,BorderLayout.SOUTH);     
    }
    
    else if(!Main.p1.get().life) {      //if the pokemon dies,
      Main.p1.trainer.remove(0);  //remove it from the trainer arraylist,
      buttonPanel.removeAll();    //remove everything from the panel,
      panel1.removeAll();     
                      //remake the button grid layout
      bMaker(buttonPanel,Main.p1);    

      hplabel = new JLabel("HP: "+Main.p1.get().HP,null,JLabel.CENTER);
                      //add all the grabage back to panel1
      panel1.add(hplabel,BorderLayout.NORTH);
      panel1.add(getLabel(Main.p1.get().pokeName),BorderLayout.CENTER);
      panel1.add(buttonPanel,BorderLayout.SOUTH);  
    }
    
  }
  
  //uses speed to determine who attacks first. If they die then you don't get to attack
  //could for sure put dies method into the ACT method
  public void battle() {
    if(Main.p1.get().SPD > Main.p2.get().SPD) {
      Main.p1.get().ACT(p1Move, Main.p2.get());
      dies();
      Main.p2.get().ACT(p2Move, Main.p1.get());
      dies();
    }
    else {
      Main.p2.get().ACT(p2Move, Main.p1.get());
      dies();
      Main.p1.get().ACT(p1Move, Main.p2.get());
      dies();
    }
  }

  ////////////////////KEYBOARD STUFF///////////////////////////
  public void keyTyped(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
      System.out.println("");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
      System.out.println("Left typed.");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_UP ) {
      System.out.println("Up typed.");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
      System.out.println("Down typed.");
    }
    else{
      System.out.println("Key typed: " + e.getKeyChar());
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
      System.out.println("Right pressed.");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
      System.out.println("Left pressed.");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_UP ) {
      System.out.println("Up pressed.");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
      System.out.println("Down pressed.");
    }
    else{
      System.out.println("Key pressed: " + e.getKeyChar());
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
      System.out.println("");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
      System.out.println("");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_UP ) {
      System.out.println("");
    } 
    else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
      System.out.println("");
    }
    else{
      System.out.println("Key released: " + e.getKeyChar());
    }
  }
  public void mouseClicked(MouseEvent e) {
    System.out.println("");
  }

  public void mousePressed(MouseEvent e) {
    System.out.println("Mouse pressed at " + e.getX() + ", " + e.getY());
  }

  public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse released at " + e.getX() + ", " + e.getY());
  }

  public void mouseEntered(MouseEvent e) {
    System.out.println("Mouse entered at " + e.getX() + ", " + e.getY());
  }

  public void mouseExited(MouseEvent e) {
    System.out.println("Mouse exited at " + e.getX() + ", " + e.getY());
  }


  public void mouseDragged(MouseEvent e) {
    System.out.println("Mouse dragged: " + e.getX() + ", " + e.getY());
  }

  public void mouseMoved(MouseEvent e) {
    System.out.println("Mouse moved: " + e.getX() + ", " + e.getY());
  }

  
}


