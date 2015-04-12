package Testlab2;

public class Invocateur {

	private Command command;

	public void setCommand(Command command)
	{

		this.command = command;
		this.command.execute();
		System.out.println(" = " + Panel.canRedo);
	}
	public void setUndo(Command command){
		this.command = command;
		this.command.undo();
	}

	public void setRedo(Command command){
		this.command = command;
		this.command.redo();
	}
	public int setReturn(Command command){
		this.command = command;
		return this.command.returnValue();
	}


}
