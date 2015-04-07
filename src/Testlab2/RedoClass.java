package Testlab2;

import java.util.ArrayList;
import java.util.List;

public class RedoClass implements Command {
	Zoom zoom;
	private List<Coordonne> previousZoom = new ArrayList<Coordonne>();
	int i;
	int j;
	public RedoClass(Zoom zoom) {
		this.zoom = zoom;
	}

	@Override
	public void execute() {
		i++;
		j=i;
		previousZoom.add(this.zoom.getCoord());
		

	}

	@Override
	public void redo() {
		j--;
		if(j>0 && Panel.canRedo == true )
			zoom.SetXYWH(previousZoom.get(j));
		zoom.repaint();
		

	}

	@Override
	public void undo() {
	
	}

}
