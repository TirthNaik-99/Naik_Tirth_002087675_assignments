/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.workareas;

import info5100.university.example.Persona.Person;

/**
 *
 * @author kal bugrara
 */
public class WorkRequest {
    String task;
    Person performer;
    Person originator;
    
       public WorkRequest(Person originator, Person performer, String task) {
        this.originator = originator;
        this.performer = performer;
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Person getPerformer() {
        return performer;
    }

    public void setPerformer(Person performer) {
        this.performer = performer;
    }

    public Person getOriginator() {
        return originator;
    }

    public void setOriginator(Person originator) {
        this.originator = originator;
    }
}
    

