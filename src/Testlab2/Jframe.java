package Testlab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Testlab2.MainInter;


public class Jframe implements ActionListener {
	MainInter i = new MainInter();
	
	Jframe() {
		
		JMenuBar menuBar = new JMenuBar(); // cr�ation de la barre de menu
		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File"); // cr�ation du bouton file
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		
		// File->New, N - Mnemonic
		JMenuItem openMenuItem = new JMenuItem("Open", KeyEvent.VK_N); //cr�ation du bouton livre
		openMenuItem.addActionListener(this);
		fileMenu.add(openMenuItem);
		
		// File->New, N - Mnemonic
		JMenuItem saveMenuItem = new JMenuItem("Save", KeyEvent.VK_N); //cr�ation du bouton livre
		saveMenuItem.addActionListener(this);
		fileMenu.add(saveMenuItem);

		
		// File Menu, F - Mnemonic
		JMenu editMenu = new JMenu("Edit"); // cr�ation du bouton file
		editMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(editMenu);
		
		// File->New, N - Mnemonic
		JMenuItem undoMenuItem = new JMenuItem("Undo", KeyEvent.VK_N); //cr�ation du bouton livre
		undoMenuItem.addActionListener(this);
		editMenu.add(undoMenuItem);
		
		// File->New, N - Mnemonic
		JMenuItem redoMenuItem = new JMenuItem("Redo", KeyEvent.VK_N); //cr�ation du bouton livre
		redoMenuItem.addActionListener(this);
		editMenu.add(redoMenuItem);

		

		  i.setJMenuBar(menuBar);
		  i.setSize(i.z.width+16,i.z.height+98);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Open")) {
			System.out.println("Open");
		//	MainInter.z=new Zoom();
			

		}

		else if (e.getActionCommand().equals("Save")) {
			System.out.println("Save");

			
			try{
				
			BufferedImage originalImage = ImageIO.read(new File(i.z.pathfile));
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			System.out.println(((i.z.adjX*-1))+" "+((i.z.adjY*-1))+" "+(i.z.adjW)+" "+(i.z.adjH));
			BufferedImage out = originalImage.getSubimage(i.z.adjX*-1, i.z.adjY*-1,i.z.width-i.z.adjW,i.z.height-i.z.adjH);// i.z.adjW-2*i.z.adjX*-1, i.z.adjH-2*i.z.adjY*-1);
		//	BufferedImage out = originalImage.getSubimage(100, 100, 30, 30);
			
			ImageIO.write(out, "jpg", new File("F:/Users/Jean-Fran�ois/Desktop/pipi.jpg"));
			
			}catch(IOException f){
				System.out.println("caca");
			}
		}
		
		if (e.getActionCommand().equals("Undo")) {
			   MainInter.control.setCommand(i.Redo);
			   MainInter.control.setUndo(i.Undo);
			

		}

		else if (e.getActionCommand().equals("Redo")) {
			 MainInter.control.setCommand( i.Undo);
			 MainInter.control.setRedo(i.Redo);
		}


		
	}
	
}
