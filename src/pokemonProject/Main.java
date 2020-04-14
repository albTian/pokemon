/**
 *  Authors: Albert Tian, Jocelyn Su
 * Date: June 22, 2019
 * Final Project: Pokemon Game
 * Class Description: initializes the two trainer objects and displays the frames
 * 
 *
 */
package pokemonProject;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;

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
import java.awt.event.KeyEvent;
import java.io.File;

public class Main extends JFrame {
  
  public static int cnt =0;
  public static Trainer p1 = new Trainer("p one",true);
  public static Trainer p2 = new Trainer("p two",false);
  public static Pikachu test = new Pikachu();
  public static Choose demo = new Choose("Pick your pokemon");

  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while(cnt==0) {
      Choose.imagePanel.addMouseListener(demo);
      Choose.imagePanel.requestFocusInWindow();
        demo.setSize(1500, 800);
        demo.setVisible(true);
    }
    
    demo.dispose();
    TabbedPaneDemo.createAndShowGUI();  //shows battle panel

      
  }


}
