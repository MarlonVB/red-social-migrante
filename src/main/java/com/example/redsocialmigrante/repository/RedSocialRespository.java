package com.example.redsocialmigrante.repository;

import com.example.redsocialmigrante.model.RedSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad RedSocial, que extiende de JpaRepository proporcionando todas las operaciones CRUD basicas.
 */
@Repository
public interface RedSocialRespository extends JpaRepository<RedSocial, Integer> {
}

