package Testlab2;

import java.util.ArrayList;
import java.util.List;



public class ZoomInCommand implements Command {
	Action zoom;
	int i;
	int j;
	private List<Integer> previousZoom = new ArrayList<Integer>();
	public ZoomInCommand(Action zoom)
	{

		i++;
		j=i;
		previousZoom.add(zoom.adjY);
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
