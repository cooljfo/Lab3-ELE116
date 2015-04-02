package Testlab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Testlab2.MainInter;
public class Jframe implements ActionListener {

	Jframe() {
		
		JMenuBar menuBar = new JMenuBar(); // création de la barre de menu
		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File"); // création du bouton file
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		
		// File->New, N - Mnemonic
		JMenuItem openMenuItem = new JMenuItem("Open", KeyEvent.VK_N); //création du bouton livre
		openMenuItem.addActionListener(this);
		fileMenu.add(openMenuItem);
		
		// File->New, N - Mnemonic
		JMenuItem saveMenuItem = new JMenuItem("Save", KeyEvent.VK_N); //création du bouton livre
		saveMenuItem.addActionListener(this);
		fileMenu.add(saveMenuItem);

		
		// File Menu, F - Mnemonic
		JMenu editMenu = new JMenu("Edit"); // création du bouton file
		editMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(editMenu);
		
		// File->New, N - Mnemonic
		JMenuItem undoMenuItem = new JMenuItem("Undo", KeyEvent.VK_N); //création du bouton livre
		undoMenuItem.addActionListener(this);
		editMenu.add(undoMenuItem);
		
		// File->New, N - Mnemonic
		JMenuItem redoMenuItem = new JMenuItem("Redo", KeyEvent.VK_N); //création du bouton livre
		redoMenuItem.addActionListener(this);
		editMenu.add(redoMenuItem);

		
		MainInter i = new MainInter();
		  i.setJMenuBar(menuBar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Open")) {
			System.out.println("Open");
		//	MainInter.z=new Zoom();

		}

		else if (e.getActionCommand().equals("Save")) {
			System.out.println("Save");
		}
		
		if (e.getActionCommand().equals("Undo")) {
			   MainInter.control.setCommand(MainInter.Redo);
			   MainInter.control.setUndo(MainInter.Undo);
			

		}

		else if (e.getActionCommand().equals("Redo")) {
			 MainInter.control.setCommand( MainInter.Undo);
			 MainInter.control.setRedo( MainInter.Redo);
		}


		
	}
	
}
