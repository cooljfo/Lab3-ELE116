package Testlab2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class Zoom extends Canvas implements ImageObserver, ActionListener{
    Image img;
    int iw;
    int ih;
 int x;
 int y;
 int adjX=0;
 int adjY=0;
 int adjW=0;
 int adjH=0;
 Dimension ds;
 
 Zoom(){
		// http://stackoverflow.com/questions/7211107/how-to-use-filedialog
		///////////////////////////////////////////////////////////////////
		Frame yourJFrame = null; //
		FileDialog fd = new FileDialog(yourJFrame, "Choose a file",FileDialog.LOAD); // on crée une nouvelle fenêtre pour choisir le fichier
		fd.setDirectory("C:\\");
		fd.setFile("*.jpg");
		fd.setVisible(true);
		String pathfile = fd.getDirectory() + fd.getFile();
		///////////////////////////////////////////////////////////////////
		img=getToolkit().getImage(pathfile);
		ds=getToolkit().getScreenSize();
		
		JMenuBar menuBar = new JMenuBar(); // création de la barre de menu

		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File"); // création du bouton file
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		// File->New, N - Mnemonic
		JMenuItem newMenuItem = new JMenuItem("livre", KeyEvent.VK_N); //création du bouton livre
		newMenuItem.addActionListener(this);
		fileMenu.add(newMenuItem);
		JMenuItem newMenuItem2 = new JMenuItem("table des matières",KeyEvent.VK_N); //création du bouton table des matières
		newMenuItem2.addActionListener(this);
		fileMenu.add(newMenuItem2);
  
 }
 
 
 public void paint(Graphics g){
 Graphics2D g2d=(Graphics2D)g;
  setImageBounds();
  g2d.translate(x,y);
  g2d.drawImage(img,0,0,iw,ih,this);
  
    
   }

 public void setImageBounds(){
  
  x=(int)ds.getWidth()/2-img.getWidth(this)/2+adjX;
  y=(int)ds.getHeight()/2-img.getHeight(this)/2+adjY;
  iw=img.getWidth(this)+adjW;
  ih=img.getHeight(this)+adjH; 
  
 }

 public void zoomIn(){
  adjX-=10;
  adjY-=10;
  adjW+=20;
  adjH+=20;
 }

 public void zoomOut(){
  if(x<(int)ds.getWidth()/2-img.getWidth(this)/2){
   adjX+=10;
   adjY+=10;
   adjW-=20;
   adjH-=20;
  }
 }
 
 public void moveleft(){
	  if(x<(int)ds.getWidth()/2-img.getWidth(this)/2){
	   adjX-=10;

	  }
	 }
 public void moveright(){
	  if(x<(int)ds.getWidth()/2-img.getWidth(this)/2){
	   adjX+=10;

	  }
	 }

public void moveup(){
	  if(x<(int)ds.getWidth()/2-img.getWidth(this)/2){

	   adjY-=10;

	  }
	 }

public void movedown(){
	  if(x<(int)ds.getWidth()/2-img.getWidth(this)/2){

	   adjY+=10;

	  }
	 }


@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}

}