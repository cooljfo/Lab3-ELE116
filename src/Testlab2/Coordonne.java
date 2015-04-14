package Testlab2;
// Class permettant de storer l'état d'un image sous forme de coordonnées
public class Coordonne  {
	int adjX = 0;
	int adjY = 0;
	int adjW = 0;
	int adjH = 0;
	public Coordonne(Action zoom) {
		this.adjX = zoom.adjX;
		this.adjY = zoom.adjY;
		this.adjW = zoom.adjW;
		this.adjH = zoom.adjH;
	}

}
