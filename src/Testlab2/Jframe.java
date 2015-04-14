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
	Panel i = new Panel(); // on cr�e une nouvelle instance de panel


	private Jframe() {

		JMenuBar menuBar = new JMenuBar(); // cr�ation de la barre de menu
		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File"); // cr�ation du bouton file
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		// File->New, N - Mnemonic
		JMenuItem openMenuItem = new JMenuItem("Open"); //cr�ation du bouton livre
		//set shortcut CTRL+H (command+h on mac os)
		KeyStroke ctrlO = KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

		//set the accelerator
		openMenuItem.setAccelerator(ctrlO);

		openMenuItem.addActionListener(this);
		fileMenu.add(openMenuItem);

		// File->New, N - Mnemonic
		JMenuItem saveMenuItem = new JMenuItem("Save"); //cr�ation du bouton livre
		KeyStroke ctrlS = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

		//set the accelerator
		saveMenuItem.setAccelerator(ctrlS);
		saveMenuItem.addActionListener(this);
		fileMenu.add(saveMenuItem);




		// File Menu, F - Mnemonic
		JMenu editMenu = new JMenu("Edit"); // cr�ation du bouton file
		editMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(editMenu);

		// File->New, N - Mnemonic
		JMenuItem undoMenuItem = new JMenuItem("Undo"); //cr�ation du bouton livre
		KeyStroke ctrlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

		//set the accelerator
		undoMenuItem.setAccelerator(ctrlZ);
		undoMenuItem.addActionListener(this);
		editMenu.add(undoMenuItem);

		// File->New, N - Mnemonic
		JMenuItem redoMenuItem = new JMenuItem("Redo"); //cr�ation du bouton livre
		KeyStroke ctrlY = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

		//set the accelerator
		redoMenuItem.setAccelerator(ctrlY);
		redoMenuItem.addActionListener(this);
		editMenu.add(redoMenuItem);



		i.setJMenuBar(menuBar);
		i.setSize(500,500);	// on set la grosseur par d�faut du frame
	}

	/////////// implementation du singleton///////////
	private static Jframe JframeInstence = new Jframe();

	public static Jframe getJframeInstance()
	{	
		return JframeInstence;
	}
	
	/////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Open")) {
			///////// si on ouvre une nouvelle image on r�intialise toutes la valeurs//////////
			i.z.zoomX=0;
			i.z.zoomY=0;
			i.z.adjX=0;
			i.z.adjY=0;
			i.z.adjW=0;
			i.z.adjH=0;

			MomentoCommand.previousZoom.removeAll(MomentoCommand.previousZoom);
			/////////////////////////////////////////////////////////////


			i.z.fileChooser();
			i.setSize(i.z.width+16,i.z.height+98);	// on ajuste le frame � la grosseur de l'image


		}

		else if (e.getActionCommand().equals("Save")) {
			System.out.println("Save");

			i.z.save();// on enregistre l'Image

		}

		if (e.getActionCommand().equals("Undo" ) ) {

			Panel.control.setUndo(i.Undo); 


		}

		else if (e.getActionCommand().equals("Redo")) {
			Panel.control.setRedo(i.Undo);

		}



	}

}
