package Testlab2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.BufferedImage; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Action extends Canvas implements ImageObserver{

	public String pathfile;
	public int iw;
	public int ih;
	int zoomX;
	int zoomY;
	public  int adjX=0;
	public  int adjY=0;
	public  int adjW=0;
	public  int adjH=0;
	public int width;
	public int height;
	private Boolean imageCreated = false;

	BufferedImage bi;



	Action(){}
	
	public void fileChooser(){

		try{
			BufferedImage bibuffer = ImageIO.read(new File(setPathFile()));
			int type = bibuffer.getType() == 0? BufferedImage.TYPE_INT_ARGB : bibuffer.getType();

			width=bibuffer.getWidth();
			height=bibuffer.getHeight();

			bi=bibuffer;
			if(scalingZoom(width)>100)
			{
				bi=bibuffer.getSubimage(0,0,width-1,height);	
			}

			if(scalingZoom(height)>100)
			{
				bi=bibuffer.getSubimage(0,0,width,height-1);			
			}	

			width=bi.getWidth();
			height=bi.getHeight();

			zoomX=width/scalingZoom(width);

			zoomY=height/scalingZoom(height);
			imageCreated=true;
		}catch(IOException f){
			System.out.println(width+height	);
		}


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

	public void paint(Graphics g){
		if (imageCreated){
			Graphics2D g2d=(Graphics2D)g;

			BufferedImage bibackup = bi.getSubimage(adjX*-1, adjY*-1,width-adjW,height-adjH);

			iw=bibackup.getWidth();
			ih=bibackup.getHeight();

			g2d.drawImage(bibackup,0,0,width,height,null);
		}

	}

	public void zoomIn(){

		System.out.println((ih-zoomY));
		adjX-=zoomX;
		adjY-=zoomY;
		adjW+=zoomX*2;
		adjH+=zoomY*2;

	}

	public void zoomOut(){

		if((0 > adjX) )
			adjX+=zoomX;
		if(0 > adjY)
			adjY+=zoomY;
		if(iw-adjX+zoomX < width ){
			adjW-=zoomX*2;
		}
		else{ 
			adjW-=zoomX*2;
			adjX+=zoomX;
		}
		if(ih-adjY+zoomY < height ){
			adjH-=zoomY*2;
		}
		else {
			adjH-=zoomY*2;
			adjY+=zoomY;
		}
	}

	public void moveleft(){
		adjX+=zoomX;
	}
	public void moveright(){
		adjX-=zoomX;
	}

	public void moveup(){
		adjY+=zoomY;
	}

	public void movedown(){
		adjY-=zoomY;
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

	private static int scalingZoom(int input){
		int i=input-1;
		while (input%i != 0){
			i--;
		}
		input= input/ i;
		int output = 0;
		i=0;
		while (output<100){
			output=input*i;
			i++;
		}
		return output;

	}

}
