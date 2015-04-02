package Testlab2;

import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
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

		zoom.repaint();
		
	
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
