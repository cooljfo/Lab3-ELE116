package Testlab2;

public class MoveUpCommand implements Command {
	Zoom zoom;
	
	public MoveUpCommand(Zoom zoom) {
		this.zoom = zoom;
	}

	@Override
	public void execute() {
		zoom.moveup();
		zoom.repaint();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
