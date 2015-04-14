package Testlab2;

public class MoveUpCommand implements Command {
	Action zoom;

	public MoveUpCommand(Action zoom) {
		// On copie l'image dans la commande pour pouvoir effectuer les manipulatons
		this.zoom = zoom;
	}

	@Override
	public void execute() {
		//Manipulation selon la commande lorsqu'on a appuyer sur la touche dans le Panel
		zoom.moveup();
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
