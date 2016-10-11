package hu.tigra.jee.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by h644771 on 2016. 10. 04..
 */

@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Allocation extends EqualsById implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotEmpty
    private String subject;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    //@Size(min = 1 , max = 12)
    private String start;

    @NotNull
   // @Size(min = 1 , max = 12)
    private String end;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}



