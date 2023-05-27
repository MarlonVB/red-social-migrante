//package com.example.redsocialmigrante.service;
//
//
//import com.example.redsocialmigrante.model.Migrante;
//import com.example.redsocialmigrante.service.generics.GenericService;
//
//import java.util.List;
//import java.util.Optional;
//
///**
//
// Esta interfaz representa el servicio para operaciones CRUD relacionadas con la entidad Migrante.
// */
//public interface MigranteService extends GenericService<Migrante,Integer> {
//
//    /**
//
//     Busca un migrante cuyo nombre contenga una subcadena especifica, ignorando mayusculas y minusculas.
//     @param nombre la subcadena a buscar dentro del nombre del migrante
//     @return un objeto Optional que contiene el migrante encontrado (si existe)
//     */
//    Optional<Migrante> findByNombreLikeIgnoreCase(String nombre);
//    /**
//
//     Busca un migrante por su profesion.
//     @param profesion la profesion del migrante a buscar
//     @return un objeto Optional que contiene el migrante encontrado (si existe)
//     */
//    Optional <Migrante> findByProfesion (String profesion);
//    /**
//
//     Busca un migrante por su edad.
//     @param edad la edad del migrante a buscar
//     @return un objeto Optional que contiene el migrante encontrado (si existe)
//     */
//    Optional <Migrante> findByEdad(Integer edad);
//    /**
//
//     Busca un migrante por su nombre.
//     @param nombre el nombre del migrante a buscar
//     @return un objeto Optional que contiene el migrante encontrado (si existe)
//     */
//    Optional <Migrante> findByNombre(String nombre);
//    /**
//
//     Busca un migrante por su apellido.
//     @param apellido el apellido del migrante a buscar
//     @return un objeto Optional que contiene el migrante encontrado (si existe)
//     */
//    Optional <Migrante> findByApellido(String apellido);
//
//    void createMigrante(Migrante migrante);
//
//    List<Migrante> findByRepresentante(Migrante migrante);
//}