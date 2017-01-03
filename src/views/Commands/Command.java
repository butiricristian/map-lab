package views.Commands;

public abstract class Command {
    String key, desc;

    public Command(String key, String desc){
        this.key = key;
        this.desc = desc;
    }

    public String getKey(){
        return key;
    }
    public String getDesc(){
        return desc;
    }
    public abstract void execute();
}
