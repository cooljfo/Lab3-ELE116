package Testlab2;

public class Coordonne  {
	 int adjX;
	 int adjY;
	 int adjW;
	 int adjH;
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
