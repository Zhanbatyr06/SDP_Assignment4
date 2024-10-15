interface Mediator {
    void sendMessage(String message, Colleague colleague);
}
class ConcreteMediator implements Mediator {
    private Colleague colleague1;
    private Colleague colleague2;
    public void setColleague1(Colleague colleague) {
        colleague1 = colleague;
    }
    public void setColleague2(Colleague colleague) {
        colleague2 = colleague;
    }
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receive(message);
        } else {
            colleague1.receive(message);
        }
    }
}
abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void send(String message);
    public abstract void receive(String message);
}
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }
    public void send(String message) {
        System.out.println("Colleague1 sends message: " + message);
        mediator.sendMessage(message, this);
    }
    public void receive(String message) {
        System.out.println("Colleague1 receives message: " + message);
    }
}
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }
    public void send(String message) {
        System.out.println("Colleague2 sends message: " + message);
        mediator.sendMessage(message, this);
    }
    public void receive(String message) {
        System.out.println("Colleague2 receives message: " + message);
    }
}

