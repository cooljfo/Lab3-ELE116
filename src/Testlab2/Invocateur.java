package Testlab2;

public class Invocateur {
	
	 private Command command;

	 public void setCommand(Command command)
	   {

	       this.command = command;
	       this.command.execute();
	   }
	    
	   
	
	    
}
