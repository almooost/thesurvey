package ch.thesurvey.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by sam on 23.10.16.
 */
public class AbstractModel implements IModel {


    protected Integer id;
    protected String name;
    protected Date datetime;
    protected Integer status;

    @Override
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @Column(name="name")
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Column(name = "timestamp")
    public Date getTimestamp() {
        return datetime;
    }

    @Override
    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    @Column(name="status")
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString(){
        return "ID: "+getId()+", Name: "+getName()+", Status: "+getStatus()+", Timestamp: "+getTimestamp();
    }
}
