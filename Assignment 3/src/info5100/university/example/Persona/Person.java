/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

/**
 *
 * @author kal bugrara
 */
public class Person {

    private String name;

    private String personId;
    public Person (String personId, String name){
        this.name = name;
        this.personId = personId;
    }
    public String getpersonId(){
        return personId;
    }

    public boolean isMatch(String id){
        if(getpersonId().equals(id)) 
            return true;
        return false;
    }
        
    public String getName() {

        return name;
    }
    
}
