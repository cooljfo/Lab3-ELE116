package Testlab2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.image.*;


class  Panel extends JFrame implements ActionListener{
	
	//on crée tout les boutons du JFRAME
	JButton undo;
	JButton redo;
	JButton btZoomIn;
	JButton btZoomOut;
	JButton btMoveUp;
	JButton btMoveDown;
	JButton btMoveLeft;
	JButton btMoveRight;
	JPanel panel;
	public Action z = new Action();// On crée une nouvelle instence d'action
	static Invocateur control = new Invocateur(); // On crée un nouvel invocateur de command
	// on crée une nouvelle instance de chaque commande
	Command ZoomIn = new ZoomInCommand(z);
	Command ZoomOut = new ZoomOutCommand(z);
	Command MoveUp = new MoveUpCommand(z);
	Command MoveDown = new MoveDownCommand(z);
	Command MoveLeft = new MoveLeftCommand(z);
	Command MoveRight = new MoveRightCommand(z);
	Command Undo = new MomentoCommand(z);

	Coordonne c = new Coordonne(z);

	Panel(){
		setTitle("Image zoom");


		//On édite chaque boutons et on les ajoute au action listener
		btZoomIn=new JButton("+");
		btZoomIn.addActionListener(this);
		btZoomOut=new JButton("-");
		btZoomOut.addActionListener(this);
		btMoveUp=new JButton("^");
		btMoveUp.addActionListener(this);
		btMoveDown=new JButton("v");
		btMoveDown.addActionListener(this);
		btMoveLeft=new JButton("<");
		btMoveLeft.addActionListener(this);
		btMoveRight=new JButton(">");
		btMoveRight.addActionListener(this);
		btZoomOut.setOpaque(false);
		undo=new JButton("undo");
		undo.addActionListener(this);
		redo=new JButton("redo");
		redo.addActionListener(this);
		add(z,BorderLayout.CENTER );
		panel=new JPanel();

		panel.setLayout(new FlowLayout());
		
		//on ajoute chaque boutons au panel
		panel.add(undo);
		panel.add(redo);
		panel.add(btZoomIn);
		panel.add(btZoomOut);
		panel.add(btMoveUp);
		panel.add(btMoveDown);
		panel.add(btMoveLeft);
		panel.add(btMoveRight);
		add(panel, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		setVisible(true);
	}
// Signal permettant de savoir quelle bouton est actionné
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==btZoomIn)
		{
			if(z.iw-z.zoomX>=15&&z.ih-z.zoomY>=15){	// Si on n'est pas au zoom maximum
				control.setCommand(Undo);
				control.setCommand(ZoomIn);
			}


		}
		else if(e.getSource()==btZoomOut)
		{
			if((z.iw-z.adjX < z.width )||(z.ih-z.adjY < z.height ||(0 > z.adjX)||(0 > z.adjY))){// Si on n'est pas au zoomout maximum
				control.setCommand(Undo);
				control.setCommand(ZoomOut);
			}
		}
		else if(e.getSource()==btMoveUp)
		{
			if((0 >z.adjY)){ // Si on n'est pas complètement en haut de limage
				control.setCommand(Undo);
				control.setCommand(MoveUp);
			}
		}
		else if(e.getSource()==btMoveDown)
		{
			if((z.ih-z.adjY < z.height )){// Si on n'est pas complètement en bas de limage
				control.setCommand(Undo);
				control.setCommand(MoveDown);
			}

		}
		else if(e.getSource()==btMoveLeft)
		{
			if((0 > z.adjX)){// Si on n'est pas complètement à gauche de limage
				control.setCommand(Undo);
				control.setCommand(MoveLeft);
			}

		}
		else if(e.getSource()==btMoveRight)
		{
			if((z.iw-z.adjX < z.width )){// Si on n'est pas complètement à droite de limage
				control.setCommand(Undo);
				control.setCommand(MoveRight);
			}

		}
		else if(e.getSource()==undo)
		{
			System.out.println(control.setReturn(Undo) );

			control.setUndo(Undo);

		}
		else if(e.getSource()==redo )
		{
			System.out.println( control.setReturn(Undo) );

			control.setRedo(Undo);



		}
	}


}