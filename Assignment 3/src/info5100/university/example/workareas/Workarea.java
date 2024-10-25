/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.workareas;

import info5100.university.example.Persona.Person;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Workarea {
    
    private Person person; // Owner
    private ArrayList<WorkRequest> inQueue;
    private ArrayList<WorkRequest> outQueue;
    
    public Workarea(Person p) {
        this.person = p;
        this.inQueue = new ArrayList<>();
        this.outQueue = new ArrayList<>();
    }
    
    public void addInRequest(WorkRequest workRequest) {
        inQueue.add(workRequest);
    }

    public void addOutRequest(WorkRequest workRequest) {
        outQueue.add(workRequest);
    }

    public ArrayList<WorkRequest> getInQueue() {
        return inQueue;
    }

    public ArrayList<WorkRequest> getOutQueue() {
        return outQueue;
    }
}
