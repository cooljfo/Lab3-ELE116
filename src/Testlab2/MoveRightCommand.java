package Testlab2;

public class MoveRightCommand implements Command {
	Action zoom;

	public MoveRightCommand(Action zoom) {

		this.zoom = zoom;
	}

	@Override
	public void execute() {

		zoom.moveright();
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
		return 0;

	}

}
