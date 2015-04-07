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
	public int width;
	public int height;
	private Boolean imageCreated = false;

	BufferedImage bi;
	//int first=0;
	

	Zoom(){

	}
	public void fileChooser(){

		//		img=getToolkit().getImage(setPathFile());
		ds=getToolkit().getScreenSize();
		try{
			bi = ImageIO.read(new File(setPathFile()));
			int type = bi.getType() == 0? BufferedImage.TYPE_INT_ARGB : bi.getType();
			//	System.out.println(((Zoom.adjX*-1))+" "+((Zoom.adjY*-1))+" "+(Zoom.adjW)+" "+(Zoom.adjH));

			width=bi.getWidth();
			height=bi.getHeight();
			imageCreated=true;
			System.out.println(width+" "+height	);
		}catch(IOException f){
			System.out.println(width+height	);
		}
	
		
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



	public void zoomIn(){
		adjX-=10;
		adjY-=10;
		adjW+=20;
		adjH+=20;
	}

	public void zoomOut(){
		//	 System.out.println(width-(adjW)+adjX+" < "+width);
		//	 if((0 < adjX*-1 ) || (width-(adjW)+adjX)<width){
		if((iw-adjX < width )||(ih-adjY < height ||(0 > adjX)||(0 > adjY))){
			System.out.println("allo");
			if((0 > adjX) )
				adjX+=10;
			if(0 > adjY)
				adjY+=10;
			if(iw-adjX+10 < width ){
				adjW-=20;
			}
			else{ 
				adjW-=20;
				adjX+=10;
			}
			if(ih-adjY+10 < height ){
				adjH-=20;
			}
			else {
				adjH-=20;
				adjY+=10;
			}
		}
	}

	public void moveleft(){
		//  if(x<(int)ds.getWidth()/2-bi.getWidth(this)/2){
		if((0 > adjX))
			adjX+=10;

		//  }
	}
	public void moveright(){

		if((iw-adjX < width ))
			adjX-=10;

		//  }
	}

	public void moveup(){
		//  if(x<(int)ds.getWidth()/2-bi.getWidth(this)/2){
		System.out.println(adjY+" < "+height);

		if((0 > adjY))

			adjY+=10;


		//  }
	}

	public void movedown(){

		// if(x<(int)ds.getWidth()/2-bi.getWidth(this)/2){
		System.out.println((ih+adjY)+" < "+height);
		if((ih-adjY < height ))
			adjY-=10;
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
