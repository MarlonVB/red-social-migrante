package com.example.redsocialmigrante.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Clase de entidad que representa la relacion entre un Migrante y una Red Social.
 * Contiene el ID de la relacion, el objeto Migrante, el objeto Red Social y el nombre de usuario del migrante en esa red social.
 */
@Entity
@Data
public class MigranteRedSocialRel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMigranteRedSocialRel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idMigrante")
    private Migrante migrante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idRedSocial")
    private RedSocial redSocial;

    private String nombreUsuarioRed;

}

