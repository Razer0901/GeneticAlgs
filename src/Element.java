/**
 * Created by student on 11/17/17.
 */
public class Element {
    private int id;
    private boolean active;

    public Element(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public int getWeight(){
        return Population.elements[id][0];
    }
    public int getValue(){
        return Population.elements[id][1];
    }
}
