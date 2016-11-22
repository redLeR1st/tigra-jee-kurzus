package hu.tigra.jee.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by h644771 on 2016. 10. 04..
 */

@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class Allocation extends EqualsById implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

   // @NotNull
 //   @NotEmpty
   // private String teremTipus;

    @NotNull
    @NotEmpty
    private String subject;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    //@Size(min = 1 , max = 12)
    private Date start;

    @NotNull
   // @Size(min = 1 , max = 12)
    private Date end;
    /*
    @NotNull
    @Size(min = 1 , max = 12)
    private String startMonth;

    @NotNull
    @Size(min = 1 , max = 12)
    private String  endMonth;

    @NotNull
    @Size(min = 1 , max = 31)
    private String startDay;

    @NotNull
    @Size(min = 1 , max = 31)
    private String endDay;
*/


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
/*
    public int getStartMonth() {
        return Integer.parseInt(startMonth);
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = String.valueOf(startMonth);
    }

    public int getEndMonth() {
        return Integer.parseInt(endDay);
    }

    public void setEndMonth(int endMonth) {
        this.endDay = String.valueOf(endMonth);
    }

    public int getStartDay() {
        return Integer.parseInt(startDay);
    }

    public void setStartDay(int startDay) {
        this.startDay = String.valueOf(startDay);
    }

    public int getEndDay() {
        return Integer.parseInt(endDay);
    }

    public void setEndDay(int endDay) {
        this.endDay = String.valueOf(endDay);
    }*/

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
       this.start=start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end){
        this.end = end;


    }
  /*
    public String getTeremTipus() {
        return teremTipus;
    }

    public void setTeremTipus(String teremTipus) {
        this.teremTipus = teremTipus;
    }   */
}



