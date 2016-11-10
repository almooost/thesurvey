package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.IUser;
import ch.thesurvey.utility.GrantedAuthorityImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Represents a user
 * @author Samuel Alfano
 * @date 05.11.2016
 * @version v0.1
 */
@Entity
@Table(name = "user")
public class User implements IUser{

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * @param roel
     */
    public void setRole(String roel){
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
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
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
