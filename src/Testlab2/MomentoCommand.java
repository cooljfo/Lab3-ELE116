package Testlab2;

import java.util.ArrayList;
import java.util.List;

public class MomentoCommand implements Command {
	Action zoom;
	// Initialisation de la liste des états pour le memento
	public static List<Coordonne> previousZoom = new ArrayList<Coordonne>();
	//Index de la liste
	int j=0 ;
	public MomentoCommand(Action zoom) {
		this.zoom = zoom;
	}
	@Override
	public void execute() {
		previousZoom.subList(j,previousZoom.size()).clear();
		//On remplit la liste pour les états précédents
		previousZoom.add(this.zoom.getCoord());
		j=previousZoom.size();
	}
	//Commande Undo activée
	@Override
	public void undo() {
		j--;
		// On configure l'image avec les coordonnées de l'état d'avant.
		zoom.SetXYWH(previousZoom.get(j));
		// On redéssine l'image avec les coordonnées configurer précedemment
		zoom.repaint();
		//On regarde si on est au début de la liste;
		if (j==0){
			j=1;
			//previousZoom.removeAll(previousZoom);
		}
	}
	//Commande Redo activée
	@Override
	public void redo() {
		//On regarde si on est au bout de la liste
		if(j>previousZoom.size())
			j =previousZoom.size();
		//On peut maintenant configurer les coordonnées de l'image selon celles de l'image avant le Undo;
		zoom.SetXYWH(previousZoom.get(j));
		j++;
		// On redéssine l'image avec les coordonnées configurer précedemment
		zoom.repaint();

	}
	@Override
	public int returnValue() {
		return j;

	}


}
