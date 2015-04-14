package Testlab2;

public class ZoomOutCommand implements Command {
	Action zoom;

	public ZoomOutCommand(Action zoom)
	{

		this.zoom = zoom;
	}

	public void execute()
	{
		Panel.canRedo = false;
		RedoCommand.previousZoom.removeAll(RedoCommand.previousZoom);
		Panel.canUndo = true;
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
