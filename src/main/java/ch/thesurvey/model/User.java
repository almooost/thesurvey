package ch.thesurvey.model;

import org.springframework.ui.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sam on 23.10.16.
 */
@Entity
@Table(name = "user")
public class User extends AbstractModel {

    @Id
    private Integer usr_id;

    public User(String name){
        this.name = name;
    }

    public String addLastname(){
        return name+" Alfano";
    }
}
