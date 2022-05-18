package com.csi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    private double userSalary;
    private long userContactNo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date userDOB;
    private  String userEmailId;
    private String userPassword;
}
