package Testlab2;

import java.util.ArrayList;
import java.util.List;

public class UndoCommand implements Command {
	Zoom zoom;
	private List<Coordonne> previousZoom = new ArrayList<Coordonne>();
	int i;
	int j;
	public UndoCommand(Zoom zoom) {
		
		this.zoom = zoom;
	}
	@Override
	public void execute() {
		
//		MainInter.c.SetCoordonne(zoom);
//		y= MainInter.c;
		i++;
		j=i;
		previousZoom.add(this.zoom.getCoord());
		

	}
	@Override
	public void undo() {
		Panel.canRedo = true;
		j--;
		if(j>0)
			zoom.SetXYWH(previousZoom.get(j));
		zoom.repaint();
		
	}
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}


}
