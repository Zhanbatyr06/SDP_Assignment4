
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Task 1
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        System.out.println("Sending Task1:");
        handler1.handleRequest("Task1");
        System.out.println("\nSending Task2:");
        handler1.handleRequest("Task2");
        System.out.println("\nSending Task3:");
        handler1.handleRequest("Task3");
        System.out.println("\nSending Task4 (Unrecognized Task):");
        handler1.handleRequest("Task4");

        //Task 2
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();
        // Turn the light ON
        remote.setCommand(lightOn);
        remote.pressButton();
        // Turn the light OFF
        remote.setCommand(lightOff);
        remote.pressButton();

        //Task 3
        // Create terminal expressions
        Expression isJava = new TerminalExpression("Java");
        Expression isPython = new TerminalExpression("Python");
        // Create or expression
        Expression isJavaOrPython = new OrExpression(isJava, isPython);
        // Create and expression
        Expression isJavaAndPython = new AndExpression(isJava, isPython);
        System.out.println("Does context contain Java or Python?");
        System.out.println(isJavaOrPython.interpret("I love Java")); // true
        System.out.println("Does context contain both Java and Python?");
        System.out.println(isJavaAndPython.interpret("I love Java and Python")); // false

        //Task 4
        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        System.out.println("Iterating through names:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //Task 5
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);
        colleague1.send("Hello, Colleague2!");
        colleague2.send("Hi, Colleague1!");

        //Task 6
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());
        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("Restored to State #1: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Restored to State #2: " + originator.getState());
    }
}