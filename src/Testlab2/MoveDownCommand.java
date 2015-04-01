package Testlab2;

public class MoveDownCommand implements Command {
	Zoom zoom;
	
	public MoveDownCommand(Zoom zoom) {
		this.zoom = zoom;
	}

	@Override
	public void execute() {
		zoom.movedown();
		zoom.repaint();

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
