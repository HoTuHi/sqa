package com.sqa.Insurance.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String name;

    private String cccd;

    private String type;

    private Long salary;

    private Date birthday;

    private String address;

    private String phone;

    private String img_front;

    private String img_back;

    private String password;

    private Boolean is_active;

    private String payment_date;

    private String due_date;

    @Transient
    public String getImgFrontPath() {
        if (img_front == null || id == null) return null;
        return "/user-photos/" + id + "/" + img_front;
    }
    @Transient
    public String getImgBackPath() {
        if (img_back == null || id == null) return null;
        return "/user-photos/" + id + "/" + img_back;
    }
}
