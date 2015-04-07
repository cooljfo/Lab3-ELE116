package Testlab2;

public class MoveLeftCommand implements Command {
	Zoom zoom;
	
	public MoveLeftCommand(Zoom zoom) {

		this.zoom = zoom;
	}

	@Override
	public void execute() {
		Panel.canRedo = false;
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

}
