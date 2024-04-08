package com.example.assaigmentjava4.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name", columnDefinition = "nvarchar(50)")
    private String fullName;


    @Column(name = "admin")
    private Boolean admin;

    @OneToMany(mappedBy = "users" , cascade = {
            CascadeType.ALL
    })
    private List<Favorite> listFavorite;

    @OneToMany(mappedBy = "users" , cascade = CascadeType.ALL)
    private List<Share> listShare;


}
