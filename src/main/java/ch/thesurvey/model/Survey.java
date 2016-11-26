package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Model for Survey, handles all survey relevant objects
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
@Entity
@Table(name="survey")
public class Survey implements SurveyInterface {

    private Integer id;
    private String name;
    private String description;
    private String author;
    private Date start_date;
    private Date end_date;
    private Integer status;

    private Integer points;
    private Date datetime;

    //private List<ContactInterface> contacts;
    private List<SurveyQuestionInterface> surveyQuestions;
    private List<SurveyContactInterface> surveyContacts;
    private EvaluationInterface evaluation;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Column(name="description")
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    @Column(name = "date_start")
    public Date getStartDate() {
        return start_date;
    }

    @Override
    public void setStartDate(Date date) {
        this.start_date = date;
    }

    @Override
    @Column(name = "date_end")
    public Date getEndDate() {
        return end_date;
    }

    @Override
    public void setEndDate(Date date) {
        this.end_date = date;
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

    @Column(name="points")
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Column(name="tstamp")
    public Date getTimestamp() {
        return datetime;
    }

    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

    //@OneToMany(cascade = CascadeType.ALL, targetEntity = SurveyContact.class, fetch = FetchType.EAGER)
    //@Fetch(org.hibernate.annotations.FetchMode.SELECT)
    //@JoinTable(name = "survey_contact", joinColumns =  {@JoinColumn(name = "survey_id") } , inverseJoinColumns =  {@JoinColumn(name = "contact_id")} )
    //@OneToMany(targetEntity = SurveyContact.class,  mappedBy = "surveyId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "survey", targetEntity = SurveyContact.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<SurveyContactInterface> getSurveyContacts(){return surveyContacts;}

    @Override
    public void setSurveyContacts(List<SurveyContactInterface> surveyContacts) {this.surveyContacts = surveyContacts;}

    @Transient
    public void addSurveyContact(SurveyContactInterface surveyContact){surveyContacts.add(surveyContact);}
/*
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Contact.class, fetch = FetchType.EAGER)
    @Fetch(org.hibernate.annotations.FetchMode.SELECT)
    @JoinTable(name = "survey_contact", joinColumns = { @JoinColumn(name = "survey_id") }, inverseJoinColumns = { @JoinColumn(name = "contact_id") })
    public List<ContactInterface> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactInterface> contacts) {
        this.contacts = contacts;
    }

    public void addContact(ContactInterface contact){
        contacts.add(contact);
    }

*/
    //@ManyToMany(cascade = CascadeType.ALL, targetEntity = Question.class, fetch = FetchType.EAGER)
    //@Fetch(org.hibernate.annotations.FetchMode.SELECT)
    //@JoinTable(name = "survey_question", joinColumns =  {@JoinColumn(name = "question_id", referencedColumnName = "id") } , inverseJoinColumns =  {@JoinColumn(name = "survey_id", referencedColumnName = "id")} )
    //@JoinTable(name = "survey_question", joinColumns = @JoinColumn(name = "survey_id"), inverseJoinColumns = @JoinColumn(name = "question_id") )


    /*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Question.class)
    @JoinTable(name = "survey_question", joinColumns = {
            @JoinColumn(name = "question_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id",
                    nullable = false, updatable = false) })
                    */
    @OneToMany(mappedBy = "survey", targetEntity = SurveyQuestion.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<SurveyQuestionInterface> getSurveyQuestions() {
        return surveyQuestions;
    }

    @Override
    public void setSurveyQuestions(List<SurveyQuestionInterface> surveyQuestions) {this.surveyQuestions = surveyQuestions;}

    @Override
    @Transient
    public void addSurveyQuestion(SurveyQuestionInterface surveyQuestion) {this.surveyQuestions.add(surveyQuestion);}

    @OneToOne(targetEntity = Evaluation.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    public EvaluationInterface getEvaluation() {
        return evaluation;
    }

    @Override
    public void setEvaluation(EvaluationInterface evaluation) {
        this.evaluation = evaluation;
    }

    @Transient
    public boolean execute() throws MessagingException
    {

        // Set mailserver settings
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        Properties mailProperties = System.getProperties();
        mailProperties.put("mail.smtp.host", "smtp.inetworx.ch");        mailProperties.put("mail.smtp.port", "587");
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Create email
        System.out.println("\n\n 2nd ===> get Mail Session..");
        Session mailSession = Session.getDefaultInstance(mailProperties, null);
        /*
        Session mailSession = Session.getDefaultInstance(mailProperties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("alfano.eth0", "M@1à4TestingProbs!Really");
            }
        });
        */
        MimeMessage mimeMessage = new MimeMessage(mailSession);
        mimeMessage.setSender(new InternetAddress("alfano@eth0.ch"));
        mimeMessage.setFrom(new InternetAddress("alfano@eth0.ch"));

        /*
        for (SurveyContactInterface surveyContact: getSurveyContacts()) {
            if(!surveyContact.getContact().getEmail().contentEquals(""))
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(surveyContact.getContact().getEmail()));

        }
*/
//        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("sam.almost@gmail.com"));
        mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("samuel.alfano@students.ffhs.ch"));


        mimeMessage.setSubject("Test Subject von The Survey");
        String emailBody = "Test email body " + "<br><br> Regards, <br>Sam Ori";
        mimeMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

        // create new trasnport for sending
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = mailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.inetworx.ch", "alfano.eth0", "Ma1l4AppTestingPurposes!");

        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("\n\n 4rd ===> E-Mails sent! Proceeding");

        // Set status to running/executed
        setStatus(8);

        return true;

    }

}
