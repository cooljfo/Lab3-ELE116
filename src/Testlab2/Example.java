package Testlab2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



 class  MainInter extends JFrame implements ActionListener{
	 
	 JButton btZoomIn;
	 JButton btZoomOut;
	 JButton btMoveUp;
	 JButton btMoveDown;
	 JButton btMoveLeft;
	 JButton btMoveRight;
	public static JPanel panel;

	 static Zoom z=new Zoom();
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
	  add(z,BorderLayout.CENTER );
	  panel=new JPanel();
	  panel.setSize(200,200);
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
		   if(e.getSource()==btZoomIn)
		    {
		    z.zoomIn();
		    z.repaint();
		    }
		   else if(e.getSource()==btZoomOut)
		    {
		    z.zoomOut();
		    z.repaint();
		    }
		   else if(e.getSource()==btMoveUp)
		    {
		    z.movedown();
		    z.repaint();
		    }
		   else if(e.getSource()==btMoveDown)
		    {
		    z.moveup();
		    z.repaint();
		    }
		   else if(e.getSource()==btMoveLeft)
		    {
		    z.moveleft();
		    z.repaint();
		    }
		   else if(e.getSource()==btMoveRight)
		    {
		    z.moveright();
		    z.repaint();
		    }
		  } 



}