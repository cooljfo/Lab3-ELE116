package Testlab2;

import java.util.Stack;

public class ZoomInCommand implements Command {
	Zoom zoom;

    public ZoomInCommand(Zoom zoom)
    {
        this.zoom = zoom;
    }
    
    public void execute()
    {
        zoom.zoomIn();
        zoom.repaint();
    }

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
    
}
