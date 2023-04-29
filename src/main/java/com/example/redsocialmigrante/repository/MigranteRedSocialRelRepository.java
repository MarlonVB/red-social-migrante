package com.example.redsocialmigrante.repository;

import com.example.redsocialmigrante.model.Migrante;
import com.example.redsocialmigrante.model.MigranteRedSocialRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**

 Repositorio para la entidad MigranteRedSocialRel.

 Extiende de JpaRepository.
 */
@Repository
public interface MigranteRedSocialRelRepository extends JpaRepository<MigranteRedSocialRel, Integer> {

    /**

     Metodo para buscar las relaciones de migrante con sus redes sociales.
     @param migrante objeto de la entidad Migrante.
     @return lista de MigranteRedSocialRel.
     */
    List<MigranteRedSocialRel> findByMigrante(Migrante migrante);
    /**

     Metodo para eliminar las relaciones de un migrante con sus redes sociales.
     @param migrante objeto de la entidad Migrante.
     */
    void deleteByMigrante(Migrante migrante);
}
