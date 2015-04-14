package Testlab2;


public class MoveDownCommand implements Command {
	Action zoom;


	public MoveDownCommand(Action zoom) {
		// On copie l'image dans la commande pour pouvoir effectuer les manipulatons
		this.zoom = zoom;

	}

	@Override
	public void execute() {
	//Manipulation selon la commande lorsqu'on a appuyer sur la touche dans le Panel
		zoom.movedown();
		zoom.repaint();

	}



	@Override
	public void undo() {

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public int returnValue() {
		return 0;

	}

}
