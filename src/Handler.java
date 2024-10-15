interface Handler {
    void setNext(Handler handler);
    void handleRequest(String request);
}
class ConcreteHandler1 implements Handler {
    private Handler next;
    public void setNext(Handler handler) {
        next = handler;
    }
    public void handleRequest(String request) {
        if (request.equals("Task1")) {
            System.out.println("Handled by Handler1");
        } else if (next != null) {
            System.out.println("Handler1 passing the request to next handler");
            next.handleRequest(request);
        } else {
            System.out.println("Request cannot be handled");
        }
    }
}
class ConcreteHandler2 implements Handler {
    private Handler next;
    public void setNext(Handler handler) {
        next = handler;
    }
    public void handleRequest(String request) {
        if (request.equals("Task2")) {
            System.out.println("Handled by Handler2");
        } else if (next != null) {
            System.out.println("Handler2 passing the request to next handler");
            next.handleRequest(request);
        } else {
            System.out.println("Request cannot be handled");
        }
    }
}
class ConcreteHandler3 implements Handler {
    private Handler next;
    public void setNext(Handler handler) {
        next = handler;
    }
    public void handleRequest(String request) {
        if (request.equals("Task3")) {
            System.out.println("Handled by Handler3");
        } else if (next != null) {
            System.out.println("Handler3 passing the request to next handler");
            next.handleRequest(request);
        } else {
            System.out.println("Request cannot be handled");
        }
    }
}

