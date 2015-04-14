package Testlab2;

public class MoveLeftCommand implements Command {
	Action zoom;

	public MoveLeftCommand(Action zoom) {

		this.zoom = zoom;
	}

	@Override
	public void execute() {

		zoom.moveleft();
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
		return 0;// TODO Auto-generated method stub

	}

}
