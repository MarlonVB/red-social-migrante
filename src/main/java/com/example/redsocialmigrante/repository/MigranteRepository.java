//package com.example.redsocialmigrante.repository;
//
//
//import com.example.redsocialmigrante.model.Migrante;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
///**
// * Esta interfaz proporciona metodos para acceder y manipular los datos de la entidad Migrante en la base de datos.
// */
//@Repository
//public interface MigranteRepository extends JpaRepository<Migrante,Integer> {
//
//    /**
//     * Busca y devuelve un Migrante cuyo nombre se asemeje al proporcionado, sin importar mayusculas o minusculas.
//     *
//     * @param nombre el nombre del Migrante a buscar.
//     * @return un objeto Optional que contiene el Migrante encontrado, si existe.
//     */
//    Optional<Migrante> findByNombreLikeIgnoreCase(String nombre);
//
//    /**
//     * Busca y devuelve un Migrante cuya profesion coincida con la proporcionada.
//     *
//     * @param profesion la profesion del Migrante a buscar.
//     * @return un objeto Optional que contiene el Migrante encontrado, si existe.
//     */
//    Optional <Migrante> findByProfesion (String profesion);
//
//    /**
//     * Busca y devuelve un Migrante cuya edad coincida con la proporcionada.
//     *
//     * @param edad la edad del Migrante a buscar.
//     * @return un objeto Optional que contiene el Migrante encontrado, si existe.
//     */
//    Optional <Migrante> findByEdad(Integer edad);
//
//    /**
//     * Busca y devuelve un Migrante cuyo nombre coincida exactamente con el proporcionado.
//     *
//     * @param nombre el nombre del Migrante a buscar.
//     * @return un objeto Optional que contiene el Migrante encontrado, si existe.
//     */
//    Optional <Migrante> findByNombre(String nombre);
//
//    /**
//     * Busca y devuelve un Migrante cuyo apellido coincida exactamente con el proporcionado.
//     *
//     * @param Apellido el apellido del Migrante a buscar.
//     * @return un objeto Optional que contiene el Migrante encontrado, si existe.
//     */
//    Optional <Migrante> findByApellido(String Apellido);
//
//    List<Migrante> findByRepresentante(Migrante representante);
//}
//
