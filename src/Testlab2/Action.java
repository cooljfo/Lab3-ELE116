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
			BufferedImage bibuffer = ImageIO.read(new File(setPathFile())); // on envoie l'image recu dans une bufferimage
			int type = bibuffer.getType() == 0? BufferedImage.TYPE_INT_ARGB : bibuffer.getType();

			width=bibuffer.getWidth(); // on r�cup�re la largeur de l'image
			height=bibuffer.getHeight();// on r�cup�re la hauteur de l'image

			bi=bibuffer; // l'image est enregistre dans une variable global
			if(scalingZoom(width)>100) // si la largeur est un nombre premier
			{
				bi=bibuffer.getSubimage(0,0,width-1,height); // on enl�ve une colone de pixel � l'image
			}

			if(scalingZoom(height)>100) // si la hauteur est un nombre premier
			{
				bi=bibuffer.getSubimage(0,0,width,height-1); // on enl�ve une rang�e de pixel � l'image			
			}	

			width=bi.getWidth();// on r�cup�re la nouvelle largeur de l'image
			height=bi.getHeight();// on r�cup�re la nouvelle hauteur de l'image

			zoomX=width/scalingZoom(width); // on choisit l'incr�ment du d�placement de l'axe des X

			zoomY=height/scalingZoom(height);// on choisit l'incr�ment du d�placement de l'axe des Y
			imageCreated=true;
		}catch(IOException f){
			System.out.println(width+height	);
		}


	}

    public void save(){// m�thode pour enregistrer l'image
		try{

			BufferedImage originalImage = ImageIO.read(new File(pathfile));
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			BufferedImage out = originalImage.getSubimage(adjX*-1, adjY*-1,width-adjW,height-adjH);

			Frame yourJFrame = null; //
			FileDialog fd = new FileDialog(yourJFrame, "Choose a file",FileDialog.SAVE); // on cr�e une nouvelle fen�tre pour choisir le fichier
			fd.setDirectory("C:\\");
			fd.setFile("Image.jpg");
			fd.setVisible(true);
			String pathfile = fd.getDirectory() + fd.getFile();

			ImageIO.write(out, "jpg", new File(pathfile));

		}
		catch(IOException f){
			System.out.println("erreur");
		}
    }


	public String setPathFile(){
		// http://stackoverflow.com/questions/7211107/how-to-use-filedialog
		///////////////////////////////////////////////////////////////////
		Frame yourJFrame = null; //
		FileDialog fd = new FileDialog(yourJFrame, "Choose a file",FileDialog.LOAD); // on cr�e une nouvelle fen�tre pour choisir le fichier
		fd.setDirectory("C:\\");
		fd.setFile("*.jpg");
		fd.setVisible(true);
		String pathfile = fd.getDirectory() + fd.getFile();
		///////////////////////////////////////////////////////////////////
		this.pathfile=pathfile;
		return pathfile;
	}

	public void paint(Graphics g){
		if (imageCreated){ // si l'image est cr��
			Graphics2D g2d=(Graphics2D)g;

			BufferedImage bibackup = bi.getSubimage(adjX*-1, adjY*-1,width-adjW,height-adjH); // on cr�e la nouvelle image avec les nouvelles coordonn�es

			iw=bibackup.getWidth(); // on enregistre les nouvelles dimentions de l'image
			ih=bibackup.getHeight();

			g2d.drawImage(bibackup,0,0,width,height,null); // on affiche la nouvelle image
		}

	}

	public void zoomIn(){

		adjX-=zoomX;
		adjY-=zoomY;
		adjW+=zoomX*2;
		adjH+=zoomY*2;

	}

	public void zoomOut(){ // on r�agrandie l'image et si on arrive au bout de l'image on la red�cale dans le sens opos�

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

	private static int scalingZoom(int input){ // m�thode pour trouver l'incr�ment de d�placement de l'image sur les axes
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
