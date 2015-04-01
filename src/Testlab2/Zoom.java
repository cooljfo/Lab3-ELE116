package Testlab2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

class Zoom extends Canvas implements ImageObserver{

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
	   adjX+=10;

	  }
	 }
 public void moveright(){
	  if(x<(int)ds.getWidth()/2-img.getWidth(this)/2){
	   adjX-=10;

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




}
