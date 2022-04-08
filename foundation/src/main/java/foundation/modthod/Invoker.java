package foundation.modthod;

public class Invoker {
    private Command command = null;
    Invoker(Command command){
        this.command =  command;
    }

    public void  action(){
        command.execute();
    }
}
