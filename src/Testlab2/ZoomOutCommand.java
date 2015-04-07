package Testlab2;

public class ZoomOutCommand implements Command {
	Zoom zoom;
	 
    public ZoomOutCommand(Zoom zoom)
    {

        this.zoom = zoom;
    }
    
    public void execute()
    {
    	Panel.canRedo = false;
        zoom.zoomOut();
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
