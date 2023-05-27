//package com.example.redsocialmigrante.service.impl;
//
//import com.example.redsocialmigrante.model.GrupoFamiliar;
//import com.example.redsocialmigrante.model.Migrante;
//import com.example.redsocialmigrante.repository.GrupoFamiliarRespository;
//import com.example.redsocialmigrante.repository.MigranteRepository;
//import com.example.redsocialmigrante.service.MigranteService;
//import com.example.redsocialmigrante.service.generics.impl.GenericServiceImplement;
//import lombok.AllArgsConstructor;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
///**
//
// Implementacion de la interfaz MigranteService que proporciona metodos para interactuar con la entidad Migrante en la base de datos.
// */
//@Service
//@AllArgsConstructor
//public class MigranteServiceImplement extends GenericServiceImplement<Migrante, Integer> implements MigranteService {
//
//    private final MigranteRepository migranteRepository;
//    private final GrupoFamiliarRespository grupoFamiliarRepository;
//
//    /**
//
//     Busca un migrante por nombre ignorando mayusculas y minusculas.
//     @param nombre el nombre a buscar
//     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
//     */
//    @Override
//    public Optional<Migrante> findByNombreLikeIgnoreCase(String nombre) {
//        return migranteRepository.findByNombreLikeIgnoreCase(nombre);
//    }
//    /**
//
//     Busca un migrante por profesion.
//     @param profesion la profesion a buscar
//     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
//     */
//    @Override
//    public Optional<Migrante> findByProfesion(String profesion) {
//        return migranteRepository.findByProfesion(profesion);
//    }
//    /**
//
//     Busca un migrante por edad.
//     @param edad la edad a buscar
//     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
//     */
//    @Override
//    public Optional<Migrante> findByEdad(Integer edad) {
//        return migranteRepository.findByEdad(edad);
//    }
//    /**
//
//     Busca un migrante por nombre.
//     @param nombre el nombre a buscar
//     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
//     */
//    @Override
//    public Optional<Migrante> findByNombre(String nombre) {
//        return migranteRepository.findByNombre(nombre);
//    }
//    /**
//
//     Busca un migrante por apellido.
//     @param apellido el apellido a buscar
//     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
//     */
//    @Override
//    public Optional<Migrante> findByApellido(String apellido) {
//        return migranteRepository.findByApellido(apellido);
//    }
//
//    /**
//
//     Retorna el repositorio Crud para la entidad Migrante.
//     @return el repositorio Crud para la entidad Migrante.
//     */
//    @Override
//    public CrudRepository<Migrante, Integer> crudRepository() {
//        return migranteRepository;
//    }
//
//
//    @Transactional
//    @Override
//    public void createMigrante(Migrante migrante) {
//
//        if (migrante.getRepresentante() != null && migrante.getRepresentante().getIdMigrante() != null) {
//            Optional<Migrante> representanteOptional = migranteRepository.findById(migrante.getRepresentante().getIdMigrante());
//            if (representanteOptional.isPresent()) {
//                Migrante representante = representanteOptional.get();
//                migrante.setRepresentante(representante);
//                migrante.setGrupoFamiliar(representante.getGrupoFamiliar());
//                migrante.setEstadoRepresentante(false);
//            }
//        } else {
//            migrante.setRepresentante(migrante);
//            migrante.setEstadoRepresentante(true);
//        }
//
//        Migrante savedMigrante = migranteRepository.save(migrante);
//
//        if (savedMigrante.getRepresentante().equals(savedMigrante)) {
//            GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
//            grupoFamiliar.setRepresentante(savedMigrante);
//            grupoFamiliarRepository.save(grupoFamiliar);
//            savedMigrante.setGrupoFamiliar(grupoFamiliar);
//            migranteRepository.save(savedMigrante);
//        }
//
//    }
//
//    @Override
//    public List<Migrante> findByRepresentante(Migrante migrante) {
//        return migranteRepository.findByRepresentante(migrante);
//    }
//}
