
import java.util.ArrayList;
import java.util.List;
class Memento {
    private String state;
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
class Originator {
    private String state;
    public void setState(String state) {
        System.out.println("Setting state to " + state);
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public Memento saveStateToMemento() {
        System.out.println("Saving state to memento: " + state);
        return new Memento(state);
    }
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("Restored state from memento: " + state);
    }
}
class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();
    public void add(Memento state) {
        mementoList.add(state);
    }
    public Memento get(int index) {
        return mementoList.get(index);
    }
}