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
	 JButton btZoomOut;
	 JButton btMoveUp;
	 JButton btMoveDown;
	 JButton btMoveLeft;
	 JButton btMoveRight;
	 JPanel panel;
	 Zoom z;
	 MainInter(){
	  setTitle("Image zoom");
	  z=new Zoom();
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
	  add(z,BorderLayout.CENTER );
	  panel=new JPanel();
	  panel.setLayout(new FlowLayout());
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
		 Invocateur control = new Invocateur();
		 Command ZoomIn = new ZoomInCommand(z);
		 Command ZoomOut = new ZoomOutCommand(z);
		 Command MoveUp = new MoveUpCommand(z);
		 Command MoveDown = new MoveDownCommand(z);
		 Command MoveLeft = new MoveLeftCommand(z);
		 Command MoveRight = new MoveRightCommand(z);
	   if(e.getSource()==btZoomIn)
	    {
		    control.setCommand(ZoomIn);
	    }
	   else if(e.getSource()==btZoomOut)
	    {
		   control.setCommand(ZoomOut);
	    }
	   else if(e.getSource()==btMoveUp)
	    {
		   control.setCommand(MoveUp);
	    }
	   else if(e.getSource()==btMoveDown)
	    {
		   control.setCommand(MoveDown);
	    }
	   else if(e.getSource()==btMoveLeft)
	    {
		   control.setCommand(MoveLeft);
	    }
	   else if(e.getSource()==btMoveRight)
	    {
		   control.setCommand(MoveRight);
	    }
	  }


	}