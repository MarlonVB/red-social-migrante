package com.example.redsocialmigrante.service.impl;

import com.example.redsocialmigrante.model.Migrante;
import com.example.redsocialmigrante.repository.MigranteRepository;
import com.example.redsocialmigrante.service.MigranteService;
import com.example.redsocialmigrante.service.generics.impl.GenericServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**

 Implementacion de la interfaz MigranteService que proporciona metodos para interactuar con la entidad Migrante en la base de datos.
 */
@Service
@AllArgsConstructor
public class MigranteServiceImplement extends GenericServiceImplement<Migrante, Integer> implements MigranteService {

    private final MigranteRepository migranteRepository;

    /**

     Busca un migrante por nombre ignorando mayusculas y minusculas.
     @param nombre el nombre a buscar
     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
     */
    @Override
    public Optional<Migrante> findByNombreLikeIgnoreCase(String nombre) {
        return migranteRepository.findByNombreLikeIgnoreCase(nombre);
    }
    /**

     Busca un migrante por profesion.
     @param profesion la profesion a buscar
     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
     */
    @Override
    public Optional<Migrante> findByProfesion(String profesion) {
        return migranteRepository.findByProfesion(profesion);
    }
    /**

     Busca un migrante por edad.
     @param edad la edad a buscar
     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
     */
    @Override
    public Optional<Migrante> findByEdad(Integer edad) {
        return migranteRepository.findByEdad(edad);
    }
    /**

     Busca un migrante por nombre.
     @param nombre el nombre a buscar
     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
     */
    @Override
    public Optional<Migrante> findByNombre(String nombre) {
        return migranteRepository.findByNombre(nombre);
    }
    /**

     Busca un migrante por apellido.
     @param apellido el apellido a buscar
     @return una Optional que puede contener el migrante encontrado o vacio si no se encuentra.
     */
    @Override
    public Optional<Migrante> findByApellido(String apellido) {
        return migranteRepository.findByApellido(apellido);
    }
    /**

     Retorna el repositorio Crud para la entidad Migrante.
     @return el repositorio Crud para la entidad Migrante.
     */
    @Override
    public CrudRepository<Migrante, Integer> crudRepository() {
        return migranteRepository;
    }
}
