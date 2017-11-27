package DAOGOOD;

public class Track extends DAO {
    // private int id;
    private String name;

    public Track (int id, String name) {
        setId(id);
        setName(name);
    }

    public Track(int id) {
        setId(id);
    }




    public String getName() {
        return this.name;
    }

    public void setName(String Name) {
        this.name=name;
    }



    public static void main (String[] args) {

        Track t = new Track(10, "XXXX");
        t.insert();



        Track t2 = new Track(2);

        t2.select(); // select * from Track where id=10

        System.out.println(t2.getName());
    }

}
