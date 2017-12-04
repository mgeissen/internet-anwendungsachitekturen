package de.nordakademie.iaa.helloworld.action;

public class HelloAction {

    // input data
    private String name;

    // output data
    private String greeting;

    public String execute(){
        greeting = String.format("Hello %s, how are you? ", name);

        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
