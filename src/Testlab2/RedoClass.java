package Testlab2;

import java.util.ArrayList;
import java.util.List;

public class RedoClass implements Command {
	Zoom zoom;
	private List<Coordonne> previousZoom = new ArrayList<Coordonne>();
	int i=0;
	int j=0;
	public RedoClass(Zoom zoom) {
		this.zoom = zoom;
	}

	@Override
	public void execute() {
	
		previousZoom.add(this.zoom.getCoord());
		i++;
		j=previousZoom.size();
		
		
		

	}

	@Override
	public void redo() {
		j--;
	    zoom.SetXYWH(previousZoom.get(j));
		zoom.repaint();
		if (j<0)
			j=0;

	}

	@Override
	public void undo() {
	
	}

	@Override
	public int returnValue() {
		return this.j;
		
	}

}
