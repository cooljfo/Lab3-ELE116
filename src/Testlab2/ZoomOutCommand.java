package Testlab2;

public class ZoomOutCommand implements Command {
	Action zoom;

	public ZoomOutCommand(Action zoom)
	{
		// On copie l'image dans la commande pour pouvoir effectuer les manipulatons
		this.zoom = zoom;
	}

	public void execute()
	{
		//Manipulation selon la commande lorsqu'on a appuyer sur la touche dans le Panel
		zoom.zoomOut();
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
