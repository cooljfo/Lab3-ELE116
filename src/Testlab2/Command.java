package Testlab2;
// Interface pour chaque commande de l'application
public interface Command {

	public void execute();
	public void undo();
	public void redo();
	public int returnValue();

}
