package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.SurveyContactInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Single entity of a linked survey contact
 * @author Samuel Alfano
 * @date 21.11.2016
 * @version v0.1
 */
@Entity
@Table(name = "survey_contact")
public class SurveyContact implements SurveyContactInterface, Serializable {

    private Integer id;
    private SurveyInterface survey;
    private ContactInterface contact;
    private String token;
    private Date tokenUntil;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = Survey.class)
    @JoinColumn(name = "survey_id", insertable = false, updatable = false, referencedColumnName = "id")
    public SurveyInterface getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyInterface survey) {
        this.survey = survey;
    }

    @Column(name = "survey_id")
    public Integer getSurveyId(){return survey.getId();}

    public void setSurveyId(Integer surveyId){}

    @ManyToOne(targetEntity = Contact.class)
    @JoinColumn(name = "contact_id", insertable = false, updatable = false, referencedColumnName = "id")
    public ContactInterface getContact() {
        return contact;
    }

    public void setContact(ContactInterface contact) {this.contact = contact;}

    @Column(name = "contact_id")
    public Integer getContactId(){return contact.getId();}

    public void setContactId(Integer contactId){}

    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "token_until")
    public Date getTokenUntil() {
        return tokenUntil;
    }

    public void setTokenUntil(Date tokenUntil) {
        this.tokenUntil = tokenUntil;
    }

    @Transient
    public String getName() {return null;}

    public void setName(String name) {}

    @Transient
    public Integer getStatus() {
        return null;
    }

    public void setStatus(Integer status) {}

    @Transient
    public Date getTimestamp() {
        return null;
    }

    public void setTimestamp(Date datetime) {}
}
