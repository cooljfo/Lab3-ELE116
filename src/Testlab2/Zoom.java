package Testlab2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage;
import java.awt.Color; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Zoom extends Canvas implements ImageObserver{

public static String pathfile;
public static	Image img;
public static    int iw;
 public static    int ih;
 int x;
 int y;
 public static int adjX=0;
 public static int adjY=0;
 public static int adjW=0;
 public static int adjH=0;
 public static Dimension ds;
 public static int width;
 public static int height;
 
 BufferedImage bi;
 //int first=0;
 
 Zoom(){

//		img=getToolkit().getImage(setPathFile());
		ds=getToolkit().getScreenSize();
		try{
		bi = ImageIO.read(new File(setPathFile()));
		int type = bi.getType() == 0? BufferedImage.TYPE_INT_ARGB : bi.getType();
	//	System.out.println(((Zoom.adjX*-1))+" "+((Zoom.adjY*-1))+" "+(Zoom.adjW)+" "+(Zoom.adjH));
		
        width=bi.getWidth();
        height=bi.getHeight();
		System.out.println(width+" "+height	);
		}catch(IOException f){
			System.out.println(width+height	);
		}

 }
 
 
 public void paint(Graphics g){

	 Graphics2D g2d=(Graphics2D)g;
	 setImageBounds();
	 System.out.println(((adjX*-1))+" "+((adjY*-1))+" "+iw+" "+ih);
	 BufferedImage bibackup = bi.getSubimage(Zoom.adjX*-1, Zoom.adjY*-1,Zoom.width-Zoom.adjW,Zoom.height-Zoom.adjH);
//	 BufferedImage bibackup = bi.getSubimage(adjX*-1, adjY*-1,iw,ih);
	 System.out.println("allo");

  //g2d.translate(x,y);
  g2d.drawImage(bibackup,0,0,500,500,null);
	System.out.println(width+" "+height	);
  

    
   }
 



public String setPathFile(){
		// http://stackoverflow.com/questions/7211107/how-to-use-filedialog
		///////////////////////////////////////////////////////////////////
		Frame yourJFrame = null; //
		FileDialog fd = new FileDialog(yourJFrame, "Choose a file",FileDialog.LOAD); // on crée une nouvelle fenêtre pour choisir le fichier
		fd.setDirectory("C:\\");
		fd.setFile("*.jpg");
		fd.setVisible(true);
		String pathfile = fd.getDirectory() + fd.getFile();
		///////////////////////////////////////////////////////////////////
		this.pathfile=pathfile;
		return pathfile;
 }

 public void setImageBounds(){
  
  x=adjX;
  y=adjY;
  iw=width+adjW;
  ih=height+adjH; 
  
 }

 public void zoomIn(){
  adjX-=10;
  adjY-=10;
  adjW+=20;
  adjH+=20;
 }

 public void zoomOut(){
  if(x<(int)ds.getWidth()/2-bi.getWidth(this)/2){
   adjX+=10;
   adjY+=10;
   adjW-=20;
   adjH-=20;
  }
 }
 
 public void moveleft(){
	//  if(x<(int)ds.getWidth()/2-bi.getWidth(this)/2){
	   adjX+=10;

	//  }
	 }
 public void moveright(){
	//  if(x<(int)ds.getWidth()/2-bi.getWidth(this)/2){
	   adjX-=10;

	//  }
	 }

public void moveup(){
	//  if(x<(int)ds.getWidth()/2-bi.getWidth(this)/2){

	   adjY-=10;

	//  }
	 }

public void movedown(){
	//  if(x<(int)ds.getWidth()/2-bi.getWidth(this)/2){

	   adjY+=10;

	//  }
	 }
public void SetXYWH(Coordonne coordonne){
	adjY = coordonne.adjY;
	adjX = coordonne.adjX;
	adjH = coordonne.adjH;
	adjW = coordonne.adjW;
}
public Coordonne getCoord(){
	return new Coordonne(this);
}


}
