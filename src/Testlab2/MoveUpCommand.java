package Testlab2;

public class MoveUpCommand implements Command {
	Action zoom;

	public MoveUpCommand(Action zoom) {

		this.zoom = zoom;
	}

	@Override
	public void execute() {
		Panel.canRedo = false;

		Panel.canUndo = true;
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
