package Testlab2;

public class Coordonne  {
	 int adjX = 0;
	 int adjY = 0;
	 int adjW = 0;
	 int adjH = 0;
	public Coordonne(Zoom zoom) {
		this.adjX = zoom.adjX;
		this.adjY = zoom.adjY;
		this.adjW = zoom.adjW;
		this.adjH = zoom.adjH;
	}
	public void SetCoordonne(Zoom zoom) {
		this.adjX = zoom.adjX;
		this.adjY = zoom.adjY;
		this.adjW = zoom.adjW;
		this.adjH = zoom.adjH;
	}
}
