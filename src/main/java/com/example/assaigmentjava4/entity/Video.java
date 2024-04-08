package com.example.assaigmentjava4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "video")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_video")
    private Integer id;

    @Column(name = "title", columnDefinition = "NVARCHAR(255)")
    private String title;

    @Column(name = "poster")
    private String poster;

    @Column(name = "name_video")
    private String videoName;

    @Column(name = "description" , columnDefinition = "NVARCHAR(255)")
    private String description;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<Favorite> listFavorite;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<Share> listShare;
}
