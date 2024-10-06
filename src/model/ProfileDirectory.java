/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tirthnaik
 */
public class ProfileDirectory {
    private ArrayList<Profile> profiles;

    // Constructor with ArrayList<Profile>
    public ProfileDirectory(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }

    // Default constructor
    public ProfileDirectory() {
        this.profiles = new ArrayList<>();
    }


    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }
    
    public Profile addProfile(){
        Profile p = new Profile();
        profiles.add(p);
        return(p);
    }
    
        public void deleteProfile(Profile profile){
        profiles.remove(profile);
    }
        
        public Profile searchProfile(String ssn) {
        for (Profile p : profiles) {
            if (p.getSsn().contains(ssn)){
                return p;
            }
        }
        return null;
    }
}
