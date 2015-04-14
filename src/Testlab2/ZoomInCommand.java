package Testlab2;

import java.util.ArrayList;
import java.util.List;



public class ZoomInCommand implements Command {
	Action zoom;

	public ZoomInCommand(Action zoom)
	{
		// On copie l'image dans la commande pour pouvoir effectuer les manipulatons
	
		this.zoom = zoom;
	}

	public void execute()
	{
		//Manipulation selon la commande lorsqu'on a appuyer sur la touche dans le Panel
		zoom.zoomIn();
		zoom.repaint();
	}



	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public int returnValue() {
		// TODO Auto-generated method stub
		return 0;
	}



}
