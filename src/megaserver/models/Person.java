/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megaserver.models;

/**
 *
 * @author Fahad-PC
 */
public class Person {
    private int person_id;
    private String person_name;
    
    private int category_id;
    private int gender;

    public Person(int person_id, String person_name, int category_id, int gender) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.category_id = category_id;
        this.gender = gender;
    }

    
    
    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    
    
    
    
}
