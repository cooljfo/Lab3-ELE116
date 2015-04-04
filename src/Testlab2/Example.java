package Testlab2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.image.*;


 class  MainInter extends JFrame implements ActionListener{
	 
	 JButton btZoomIn;
	 JButton undo;
	 JButton redo;
	 JButton btZoomOut;
	 JButton btMoveUp;
	 JButton btMoveDown;
	 JButton btMoveLeft;
	 JButton btMoveRight;
	 JPanel panel;
	 public Zoom z = new Zoom();
	 static Invocateur control = new Invocateur();
	 Command ZoomIn = new ZoomInCommand(z);
	 Command ZoomOut = new ZoomOutCommand(z);
	 Command MoveUp = new MoveUpCommand(z);
	 Command MoveDown = new MoveDownCommand(z);
	 Command MoveLeft = new MoveLeftCommand(z);
	 Command MoveRight = new MoveRightCommand(z);
	 Command Undo = new UndoCommand(z);
	 Command Redo = new RedoClass(z);
	 Coordonne c = new Coordonne(z);
	 MainInter(){
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
	  panel.add(btZoomIn);
	  panel.add(undo);
	  panel.add(redo);
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
		   	control.setCommand(Undo);
		    control.setCommand(ZoomIn);
	    }
	   else if(e.getSource()==btZoomOut)
	    {
		   control.setCommand(Undo);
		   control.setCommand(ZoomOut);
	    }
	   else if(e.getSource()==btMoveUp)
	    {
		   control.setCommand(Undo);
		   control.setCommand(MoveUp);
	    }
	   else if(e.getSource()==btMoveDown)
	    {
		   control.setCommand(Undo);
		   control.setCommand(MoveDown);
	    }
	   else if(e.getSource()==btMoveLeft)
	    {
		   control.setCommand(Undo);
		   control.setCommand(MoveLeft);
	    }
	   else if(e.getSource()==btMoveRight)
	    {
		   control.setCommand(Undo);
		   control.setCommand(MoveRight);
	    }
	   else if(e.getSource()==undo)
	    {
		   control.setCommand(Redo);
		   control.setUndo(Undo);

	    }
	   else if(e.getSource()==redo)
	    {
		   control.setCommand(Undo);
		   control.setRedo(Redo);
		   
		   
		   
	    }
	  }


}