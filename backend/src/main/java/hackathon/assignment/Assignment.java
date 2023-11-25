package edu.tucn.scd.hackathon.assignment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date creationDate;

    private Date deadline;
    private String descriere;
    private String profesor;
    private String materie;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String steps = "";
}
