//package com.example.redsocialmigrante.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// Esta clase representa una entidad RedSocial en la base de datos, con su respectiva informacion y relaciones con otras entidades.
// */
//@Entity
//@Data
//public class RedSocial {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idRedSocial;
//
//    private String nombreRedSocial;
//
////    @ManyToMany(mappedBy = "redesSociales", cascade = CascadeType.ALL)
////    private List<Migrante> redSocialList;
//
//    @OneToMany(mappedBy = "redSocial", cascade = CascadeType.ALL)
//    private List<MigranteRedSocialRel> migranteRedSocialRelList;
//}
