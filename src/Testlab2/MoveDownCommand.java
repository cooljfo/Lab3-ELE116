package Testlab2;


public class MoveDownCommand implements Command {
	Action zoom;


	public MoveDownCommand(Action zoom) {

		this.zoom = zoom;




	}

	@Override
	public void execute() {
		Panel.canRedo = false;

		Panel.canUndo = true;
		zoom.movedown();
		zoom.repaint();

	}



	@Override
	public void undo() {

		zoom.repaint();


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
