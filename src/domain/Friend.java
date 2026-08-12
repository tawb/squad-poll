package domain;

public class Friend {
    private final String name;

    public Friend(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
