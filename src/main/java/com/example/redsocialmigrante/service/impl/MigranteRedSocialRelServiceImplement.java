//package com.example.redsocialmigrante.service.impl;
//
//import com.example.redsocialmigrante.model.Migrante;
//import com.example.redsocialmigrante.model.MigranteRedSocialRel;
//import com.example.redsocialmigrante.repository.MigranteRedSocialRelRepository;
//import com.example.redsocialmigrante.service.MigranteRedSocialRelService;
//import com.example.redsocialmigrante.service.generics.impl.GenericServiceImplement;
//import lombok.AllArgsConstructor;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
///**
//
// Implementacion del servicio MigranteRedSocialRelService que extiende de GenericServiceImplement.
//
// Encargado de proveer los metodos de persistencia para la entidad MigranteRedSocialRel.
// */
//@Service
//@AllArgsConstructor
//public class MigranteRedSocialRelServiceImplement extends GenericServiceImplement<MigranteRedSocialRel, Integer> implements MigranteRedSocialRelService {
//
//    private final MigranteRedSocialRelRepository migranteRedSocialRelRepository;
//
//    /**
//
//     Implementacion del metodo abstracto "crudRepository()" heredado de la clase GenericServiceImplement.
//     Retorna el repositorio que se usara para las operaciones de persistencia en la base de datos.
//     @return El repositorio para la entidad MigranteRedSocialRel.
//     */
//    @Override
//    public CrudRepository<MigranteRedSocialRel, Integer> crudRepository(){
//        return migranteRedSocialRelRepository;
//    }
//    /**
//
//     Implementacien del metodo para buscar las relaciones de red social asociadas a un migrante especifico.
//     @param migrante El migrante del que se desea obtener las relaciones de red social.
//     @return Una lista de objetos MigranteRedSocialRel asociados al migrante proporcionado.
//     */
//    @Override
//    public List<MigranteRedSocialRel> findByMigrante(Migrante migrante) {
//        return migranteRedSocialRelRepository.findByMigrante(migrante);
//    }
//    /**
//
//     Implementacion del metodo para eliminar las relaciones de red social asociadas a un migrante especifico.
//     @param migrante El migrante del que se desean eliminar las relaciones de red social.
//     */
//    @Override
//    @Transactional
//    public void deleteByMigrante(Migrante migrante) {
//        migranteRedSocialRelRepository.deleteByMigrante(migrante);
//    }
//}
