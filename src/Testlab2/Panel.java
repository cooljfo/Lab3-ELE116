package Testlab2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.image.*;


class  Panel extends JFrame implements ActionListener{
	static boolean canRedo;
	static boolean canUndo = false;	 

	JButton undo;
	JButton redo;
	JButton btZoomIn;
	JButton btZoomOut;
	JButton btMoveUp;
	JButton btMoveDown;
	JButton btMoveLeft;
	JButton btMoveRight;
	JPanel panel;
	public Action z = new Action();
	static Invocateur control = new Invocateur();
	Command ZoomIn = new ZoomInCommand(z);
	Command ZoomOut = new ZoomOutCommand(z);
	Command MoveUp = new MoveUpCommand(z);
	Command MoveDown = new MoveDownCommand(z);
	Command MoveLeft = new MoveLeftCommand(z);
	Command MoveRight = new MoveRightCommand(z);
	Command Undo = new UndoCommand(z);
	Command Redo = new RedoCommand(z);
	Coordonne c = new Coordonne(z);

	Panel(){
		setTitle("Image zoom");



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

	public void actionPerformed(ActionEvent e){

		if(e.getSource()==btZoomIn)
		{
			if(z.iw-z.zoomX>=15&&z.ih-z.zoomY>=15){
				control.setCommand(Undo);
				control.setCommand(ZoomIn);
			}

			System.out.println("caca = " + control.setReturn(Redo) + control.setReturn(Undo) );
		}
		else if(e.getSource()==btZoomOut)
		{
			if((z.iw-z.adjX < z.width )||(z.ih-z.adjY < z.height ||(0 > z.adjX)||(0 > z.adjY))){
				control.setCommand(Undo);
				control.setCommand(ZoomOut);
			}
		}
		else if(e.getSource()==btMoveUp)
		{
			if((0 >z.adjY)){
				control.setCommand(Undo);
				control.setCommand(MoveUp);
			}
		}
		else if(e.getSource()==btMoveDown)
		{
			if((z.ih-z.adjY < z.height )){
				control.setCommand(Undo);
				control.setCommand(MoveDown);
			}

		}
		else if(e.getSource()==btMoveLeft)
		{
			if((0 > z.adjX)){
				control.setCommand(Undo);
				control.setCommand(MoveLeft);
			}

		}
		else if(e.getSource()==btMoveRight)
		{
			if((z.iw-z.adjX < z.width )){
				control.setCommand(Undo);
				control.setCommand(MoveRight);
			}

		}
		else if(e.getSource()==undo && Panel.canUndo == true && control.setReturn(Undo)!=0  )
		{
			System.out.println("caca = " + control.setReturn(Redo) +"   " + control.setReturn(Undo) );
			control.setCommand(Redo);
			control.setUndo(Undo);

		}
		else if(e.getSource()==redo &&  Panel.canRedo == true && control.setReturn(Redo)!=0 )
		{
			System.out.println("caca = " + control.setReturn(Redo) +"   " + control.setReturn(Undo) );
			control.setCommand(Undo);
			control.setRedo(Redo);



		}
	}


}