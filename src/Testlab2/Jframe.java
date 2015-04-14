package Testlab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;







import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;







import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;






public class Jframe implements ActionListener {
	Panel i = new Panel();


	private Jframe() {

		JMenuBar menuBar = new JMenuBar(); // création de la barre de menu
		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File"); // création du bouton file
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		// File->New, N - Mnemonic
		JMenuItem openMenuItem = new JMenuItem("Open"); //création du bouton livre
		//set shortcut CTRL+H (command+h on mac os)
		KeyStroke ctrlO = KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

		//set the accelerator
		openMenuItem.setAccelerator(ctrlO);

		openMenuItem.addActionListener(this);
		fileMenu.add(openMenuItem);

		// File->New, N - Mnemonic
		JMenuItem saveMenuItem = new JMenuItem("Save"); //création du bouton livre
		KeyStroke ctrlS = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

		//set the accelerator
		saveMenuItem.setAccelerator(ctrlS);
		saveMenuItem.addActionListener(this);
		fileMenu.add(saveMenuItem);




		// File Menu, F - Mnemonic
		JMenu editMenu = new JMenu("Edit"); // création du bouton file
		editMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(editMenu);

		// File->New, N - Mnemonic
		JMenuItem undoMenuItem = new JMenuItem("Undo"); //création du bouton livre
		KeyStroke ctrlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

		//set the accelerator
		undoMenuItem.setAccelerator(ctrlZ);
		undoMenuItem.addActionListener(this);
		editMenu.add(undoMenuItem);

		// File->New, N - Mnemonic
		JMenuItem redoMenuItem = new JMenuItem("Redo"); //création du bouton livre
		KeyStroke ctrlY = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

		//set the accelerator
		redoMenuItem.setAccelerator(ctrlY);
		redoMenuItem.addActionListener(this);
		editMenu.add(redoMenuItem);



		i.setJMenuBar(menuBar);
		i.setSize(500,500);	
	}

	private static Jframe JframeInstence = new Jframe();

	public static Jframe getJframeInstance()
	{	
		return JframeInstence;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Open")) {

			i.z.zoomX=0;
			i.z.zoomY=0;
			i.z.adjX=0;
			i.z.adjY=0;
			i.z.adjW=0;
			i.z.adjH=0;
			Panel.canUndo = false;
			MomentoCommand.previousZoom.removeAll(MomentoCommand.previousZoom);
			Panel.canRedo = false;


			i.z.fileChooser();
			i.setSize(i.z.width+16,i.z.height+98);	


		}

		else if (e.getActionCommand().equals("Save")) {
			System.out.println("Save");

			i.z.save();

		}

		if (e.getActionCommand().equals("Undo" )&& Panel.canUndo == true ) {

			Panel.control.setUndo(i.Undo);


		}

		else if (e.getActionCommand().equals("Redo")) {
			Panel.control.setCommand( i.Undo);

		}



	}

}
