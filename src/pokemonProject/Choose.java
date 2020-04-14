/**
 *  Authors: Albert Tian, Jocelyn Su
 * Date: June 22, 2019
 * Final Project: Pokemon Game
 * Class Description: The first display panel where the each player selects 3 pokemon which is added to an array list
 * 
 *
 */
package pokemonProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Choose extends JFrame implements ActionListener,KeyListener,MouseListener
{
  int count =0;
  JPanel namePanel = new JPanel();
  public static JPanel imagePanel = new JPanel();
  public JLabel poke1,resp1;
  
  
  
//  public static BufferedImage pika = ImageIO.read(new File("pikapika.jpeg"));
		  
		  //ImageIcon("pikapika.png");
  public static ImageIcon pika = new ImageIcon("pikapika.png");
  public static ImageIcon shuc = new ImageIcon("shuckle.png");
  public static ImageIcon bulba = new ImageIcon("bulb.png");
  public static ImageIcon psy = new ImageIcon("psyduck.png");
  public static ImageIcon charm = new ImageIcon("charmander.png");
  public static ImageIcon dit = new ImageIcon("ditto.png");
  public static ImageIcon pid = new ImageIcon("pidgey.png");
  public static ImageIcon cub = new ImageIcon("cubone.png");
  public static ImageIcon squ = new ImageIcon("Squirtle.png");
  public static ImageIcon jig = new ImageIcon("jigglypuff.png");

  public static JLabel Pikachu = new JLabel(pika);
  public static JLabel Shuckle = new JLabel(shuc);
  public static JLabel Bulbasaur = new JLabel(bulba);
  public static JLabel Psyduck = new JLabel(psy);
  public static JLabel Charmander = new JLabel(charm);
  public static JLabel Ditto = new JLabel(dit);
  public static JLabel Pidgey = new JLabel(pid);
  public static JLabel Cubone = new JLabel(cub);
  public static JLabel Squirtle = new JLabel(squ);
  public static JLabel Jigglypuff = new JLabel(jig);
//  
  public String pokeNames[]=  {"Pikachu","Shuckle","Bulbasaur","Psyduck","Charmander","Ditto","Pidgey","Cubone","Squirtle","Jigglypuff"};
  public JLabel uh[]=       {Pikachu,Shuckle,Bulbasaur,Psyduck,Charmander,Ditto,Pidgey,Cubone,Squirtle,Jigglypuff};  
  public  ImageIcon all[]=    {pika,shuc,bulba, psy, charm, dit, pid,cub,squ,jig};



  public Choose(String title)
  {
    super(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    imagePanel.setLayout(new GridLayout(2,6));
    namePanel.setLayout(new BorderLayout());

    poke1 = new JLabel("Player 1, Pick 3 pokemon.");
    resp1 = new JLabel("Player 2, don't look");


    BorderLayout layout = new BorderLayout();
    setLayout(layout);

    namePanel.add(poke1,BorderLayout.NORTH);
 
    
    namePanel.add(resp1);




    //adding the pokemon buttons to the panel
    for(int i=0;i<10;i++) {
      JButton button = new JButton(all[i]);
      button.addActionListener(this);
      button.setActionCommand(pokeNames[i]);
      imagePanel.add(button);
    }
    add(imagePanel, BorderLayout.NORTH);
    add(namePanel, BorderLayout.CENTER);

  }

  

//displays which pokemon you have chosen
  public void actionPerformed(ActionEvent e)
  {
  if(count<3) {
      for(String p:pokeNames) {
        if(e.getActionCommand().equals(p)) {
          Main.p1.add(p);					//adds chosen pokemon to arrayList 
          poke1.setText("Player 1 chose "+Main.p1.toString());
          count++;
        }
      }
    }
  else if(count<6) {
      for(String p:pokeNames) {
        if(e.getActionCommand().equals(p)) {
          Main.p2.add(p);
          resp1.setText("Player 2 chose "+Main.p2.toString());
          count++;
        }
      }
    }
  if(count==3) {
    poke1.setText("Player 1 done picking, player 2's turn");
    resp1.setText("Player 2, pick 3 pokemon.");
  }
  else if(count==6) {
    poke1.setText(Main.p1.toString());
    resp1.setText(Main.p2.toString());
    
    //switches to next frame
    Main.cnt++;
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
    count++;
    System.out.println("KIAN ABBOTT");
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


