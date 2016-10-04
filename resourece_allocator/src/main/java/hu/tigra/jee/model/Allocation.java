package hu.tigra.jee.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "[a-zA-Z0-9.-]+@[a-zA-Z0-9.-].[a-zA-Z0-9.-]",message = "Wrong e-mail, pleas try again!")
    private String email;

    @NotNull
    private Date start;

    @NotNull
    private Date end;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}



