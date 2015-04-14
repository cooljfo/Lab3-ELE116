package Testlab2;

import java.util.ArrayList;
import java.util.List;

public class UndoCommand implements Command {
	Action zoom;
	public static List<Coordonne> previousZoom = new ArrayList<Coordonne>();
	int i=1;
	static int j=0 ;
	public UndoCommand(Action zoom) {

		this.zoom = zoom;
	}
	@Override
	public void execute() {
		previousZoom.add(this.zoom.getCoord());
		i++;
		j=previousZoom.size();



	}


	@Override
	public void undo() {
		if(j!=1)
		previousZoom.add(this.zoom.getCoord());
		Panel.canRedo = true;
		j--;
		zoom.SetXYWH(previousZoom.get(j));

		zoom.repaint();
		if (j==0){
			j=1;
			previousZoom.removeAll(previousZoom);
		}
		

	}
	@Override
	public void redo() {
		
		zoom.SetXYWH(previousZoom.get(j));
		j++;

	}
	@Override
	public int returnValue() {
		return j;

	}


}
