package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.UserInterface;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a user
 * @author Samuel Alfano
 * @date 05.11.2016
 * @version v0.1
 */
@Entity
@Table(name = "user")
public class User implements UserInterface {

    private Integer id;
    private String username;
    private String password;

    private String givenname;
    private String lastname;
    private String role;

    private Date datetime;
    private Integer status;


    public User(){}

    public User(String username){
        this.username = username;
    }

    public User(String username, String password){
        setUsername(username);
        setPassword(password);
    }

    public User(String username, String password, String role) {
        setUsername(username);
        setPassword(password);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Integer getId(){
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name ="username")
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password")
    public String getPassword(){ return password; }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="role", columnDefinition = "varchar not null")
    public String getRole(){
        return role;
    }

    /**
     * Set new role for user
     * @param role
     */
    public void setRole(String role){
        this.role = role;
    }

    @Column(name="givenname")
    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    @Column(name="lastname")
    public String getName() {
        return lastname;
    }

    public void setName(String lastname) {
        this.lastname = lastname;
    }

    @Column(name ="tstamp")
    public Date getTimestamp() {
        return datetime;
    }

    public void setTimestamp(Date datetime) { this.datetime = datetime; }

    @Column(name ="status")
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) { this.status = status; }

}
