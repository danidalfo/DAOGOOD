package DAOGOOD;

public class Singer extends DAO{
    private String name;

    public Singer(String name) {
        this.setName(name);
    }

    public void setName(String name)  {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static void main (String[] args) {
        Singer s = new Singer( "XXXX");
        s.insert();
    }


}
