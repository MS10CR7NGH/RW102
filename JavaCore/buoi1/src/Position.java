public class Position {
    int id;
    PositionName name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PositionName getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = name;
    }

    public void getProfile(){
        System.out.println("Thông tin: " + id + " - " + name);
    }
}
