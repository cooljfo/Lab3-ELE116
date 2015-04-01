package Testlab2;

import java.util.List;
import java.util.ArrayList;
public class MoveDownCommand implements Command {
	Zoom zoom;
	int i ;
	private List<Zoom> history = new ArrayList<Zoom>();
	public MoveDownCommand(Zoom zoom) {
		this.history.add(this.zoom);
		this.zoom = zoom;
		
	}

	@Override
	public void execute() {
		zoom.movedown();
		zoom.repaint();

	}

	@Override
	public void undo() {
		i++;
		this.zoom = history.get(i);
		
	}

}
