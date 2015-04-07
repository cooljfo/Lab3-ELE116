package Testlab2;


public class MoveDownCommand implements Command {
	Zoom zoom;

	
	public MoveDownCommand(Zoom zoom) {
		
		this.zoom = zoom;
		

		
		
	}

	@Override
	public void execute() {
		Panel.canRedo = false;
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
