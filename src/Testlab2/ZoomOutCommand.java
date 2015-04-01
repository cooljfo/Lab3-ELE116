package Testlab2;

public class ZoomOutCommand implements Command {
	Zoom zoom;
	 
    public ZoomOutCommand(Zoom zoom)
    {
        this.zoom = zoom;
    }
    
    public void execute()
    {
        zoom.zoomOut();
        zoom.repaint();
    }

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
