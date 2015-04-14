package Testlab2;

import java.util.ArrayList;
import java.util.List;

public class MomentoCommand implements Command {
	Action zoom;
	public static List<Coordonne> previousZoom = new ArrayList<Coordonne>();

	int j=0 ;
	public MomentoCommand(Action zoom) {

		this.zoom = zoom;
	}
	@Override
	public void execute() {
		previousZoom.subList(j,previousZoom.size()).clear();
		previousZoom.add(this.zoom.getCoord());
		j=previousZoom.size();



	}


	@Override
	public void undo() {
		

		
		j--;
		zoom.SetXYWH(previousZoom.get(j));

		zoom.repaint();
		if (j==0){
			j=1;
			//previousZoom.removeAll(previousZoom);
		}
		

	}
	@Override
	public void redo() {

		if(j>previousZoom.size())
			j =previousZoom.size();
		zoom.SetXYWH(previousZoom.get(j));
		j++;
		zoom.repaint();

	}
	@Override
	public int returnValue() {
		return j;

	}


}
