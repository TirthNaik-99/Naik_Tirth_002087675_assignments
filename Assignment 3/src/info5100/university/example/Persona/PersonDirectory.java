/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
      ArrayList<Person> personlist ;
    
      public PersonDirectory (){
          
       personlist = new ArrayList();

    }

    public Person newPerson(String personId) {

        Person p = new Person(personId, personId);
        personlist.add(p);
        return p;
    }

    public Person findPerson(String personId) {

        for (Person p : personlist) {

            if (p.isMatch(personId)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
