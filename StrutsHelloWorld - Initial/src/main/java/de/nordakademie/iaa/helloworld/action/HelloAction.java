package de.nordakademie.iaa.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import java.util.HashSet;
import java.util.Set;

public class HelloAction extends ActionSupport implements Preparable{

    private Set<String> blackList = new HashSet<>();

    // input data
    private String name;

    // output data
    private String greeting;

    public String execute(){
        addActionMessage("OK cool!");
        greeting = String.format(getText("action.helloworld.greeting"), name);

        return SUCCESS;
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

    @Override
    public void prepare() throws Exception {
        blackList.add("Friedhelm");
        blackList.add("Kornelius");
    }

    @Override
    public void validate() {
        if(blackList.contains(name)){
            addActionError("Nicht cool!");
            addFieldError("name", getText("message.error.blacklist"));
        }
    }
}
