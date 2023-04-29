package com.example.redsocialmigrante.controller;

import com.example.redsocialmigrante.dto.MigranteDTO;
import com.example.redsocialmigrante.dto.MigranteRedSocialRelDTO;
import com.example.redsocialmigrante.dto.RedSocialDTO;
import com.example.redsocialmigrante.model.Migrante;
import com.example.redsocialmigrante.model.MigranteRedSocialRel;
import com.example.redsocialmigrante.model.RedSocial;
import com.example.redsocialmigrante.service.MigranteRedSocialRelService;
import com.example.redsocialmigrante.service.impl.MigranteServiceImplement;
import com.example.redsocialmigrante.service.impl.RedSocialServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author MarlonVelez
 * @version 1.0
 * Controlador para manejar solicitudes relacionadas con los migrantes.
 */
@RestController
@RequestMapping("/migrantes")
@AllArgsConstructor
public class MigranteController {

    /** Servicio para manejar las operaciones relacionadas con los migrantes. */
    private MigranteServiceImplement migranteService;

    /** Servicio para manejar las operaciones relacionadas con las redes sociales. */
    private RedSocialServiceImplement redSocialService;

    /** Servicio para manejar las operaciones relacionadas con la entidad de relacion entre migrantes y redes sociales. */
    private MigranteRedSocialRelService migranteRedSocialRelService;

    /**
     * Busca y devuelve un migrante segun su ID.
     *
     * @param id el ID del migrante a buscar
     * @return el migrante encontrado en forma de DTO
     * @throws EntityNotFoundException si no se encuentra un migrante con el ID especificado
     */
    @GetMapping("/{id}")
    public MigranteDTO findById(@PathVariable Integer id) {
        // Buscar el migrante por ID
        Migrante migrante = migranteService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Migrante no encontrado"));

        // Convertir el migrante a DTO
        MigranteDTO migranteDTO = new MigranteDTO();
        migranteDTO.setProfesion(migrante.getProfesion());
        migranteDTO.setIngresoMensual(migrante.getIngresoMensual());
        migranteDTO.setSexo(migrante.getSexo());
        migranteDTO.setEdad(migrante.getEdad());
        migranteDTO.setGenero(migrante.getGenero());
        migranteDTO.setNombre(migrante.getNombre());
        migranteDTO.setFechaNacimiento(migrante.getFechaNacimiento());
        migranteDTO.setApellido(migrante.getApellido());
        migranteDTO.setCorreo(migrante.getCorreo());

        // Buscar las relaciones de redes sociales para el migrante
        List<RedSocialDTO> redesSociales = new ArrayList<>();
        List<MigranteRedSocialRel> migranteRedSocialRels = migranteRedSocialRelService.findByMigrante(migrante);
        List<MigranteRedSocialRelDTO> migranteRedSocialRelDTOList = new ArrayList<>();

        for (MigranteRedSocialRel migranteRedSocialRel : migranteRedSocialRels){
            MigranteRedSocialRelDTO migranteRedSocialRelDTO = new MigranteRedSocialRelDTO();
            migranteRedSocialRelDTO.setNombreUsuarioRedSocial(migranteRedSocialRel.getNombreUsuarioRed());
            migranteRedSocialRelDTO.setRedSocialId(migranteRedSocialRel.getIdMigranteRedSocialRel());
            migranteRedSocialRelDTOList.add(migranteRedSocialRelDTO);
        }

        RedSocialDTO redSocialDTO = new RedSocialDTO();
        redSocialDTO.setMigranteRedSocialRelDTOS(migranteRedSocialRelDTOList);
        redesSociales.add(redSocialDTO);

        migranteDTO.setRedesSociales(redesSociales);
        return migranteDTO;
    }

    /**
     * Metodo para guardar un nuevo migrante en la base de datos junto con sus redes sociales asociadas.
     *
     * @param migranteDTO objeto de transferencia de datos que representa el migrante que se quiere guardar
     * @return objeto de transferencia de datos que representa el migrante que se acaba de guardar
     */
    @PostMapping("/")
    public MigranteDTO save(@RequestBody MigranteDTO migranteDTO) {
        // Guardar el migrante
        Migrante migranteSave = new Migrante();

        migranteSave.setProfesion(migranteDTO.getProfesion());
        migranteSave.setIngresoMensual(migranteDTO.getIngresoMensual());
        migranteSave.setSexo(migranteDTO.getSexo());
        migranteSave.setEdad(migranteDTO.getEdad());
        migranteSave.setGenero(migranteDTO.getGenero());
        migranteSave.setNombre(migranteDTO.getNombre());
        migranteSave.setFechaNacimiento(migranteDTO.getFechaNacimiento());
        migranteSave.setApellido(migranteDTO.getApellido());
        migranteSave.setCorreo(migranteDTO.getCorreo());
        migranteService.save(migranteSave);

        // Asociar las redes sociales con el migrante a traves de la entidad de relacion
        List<MigranteRedSocialRel> migratedSocialReals = new ArrayList<>();
        for (RedSocialDTO redSocialDTO : migranteDTO.getRedesSociales()) {
            for (MigranteRedSocialRelDTO migranteRedSocialRelDTO : redSocialDTO.getMigranteRedSocialRelDTOS()){
                RedSocial redSocialExist = redSocialService.findById(migranteRedSocialRelDTO.getRedSocialId())
                        .orElseThrow(() -> new EntityNotFoundException("La red solcial no existe"));

                MigranteRedSocialRel migranteRedSocialRel = new MigranteRedSocialRel();
                migranteRedSocialRel.setMigrante(migranteSave);
                migranteRedSocialRel.setRedSocial(redSocialExist);
                migranteRedSocialRel.setNombreUsuarioRed(migranteRedSocialRelDTO.getNombreUsuarioRedSocial());
                migratedSocialReals.add(migranteRedSocialRel);
                migranteRedSocialRelService.save(migranteRedSocialRel);
            }
        }

        return migranteDTO;
    }

    /**
     * Actualiza los datos de un migrante existente en la base de datos y sus relaciones con las redes sociales.
     * @param id Identificador unico del migrante a actualizar.
     * @param migranteDTO Datos del migrante actualizados en formato DTO.
     * @return Retorna los datos actualizados del migrante en formato DTO.
     * @throws EntityNotFoundException Si el migrante no existe en la base de datos.
     */
    @PutMapping("/{id}")
    public MigranteDTO update(@PathVariable("id") Integer id, @RequestBody MigranteDTO migranteDTO) throws EntityNotFoundException {

        //Buscamos si existe el migrante con el id proporsionado
        Migrante migranteExist = migranteService.findById(id).orElseThrow(() -> new EntityNotFoundException("El migrante no existe"));
        migranteExist.setProfesion(migranteDTO.getProfesion());
        migranteExist.setIngresoMensual(migranteDTO.getIngresoMensual());
        migranteExist.setSexo(migranteDTO.getSexo());
        migranteExist.setEdad(migranteDTO.getEdad());
        migranteExist.setGenero(migranteDTO.getGenero());
        migranteExist.setNombre(migranteDTO.getNombre());
        migranteExist.setFechaNacimiento(migranteDTO.getFechaNacimiento());
        migranteExist.setApellido(migranteDTO.getApellido());
        migranteExist.setCorreo(migranteDTO.getCorreo());
        migranteService.save(migranteExist);


        //Actualizar la relaciones MigranteRedSocialRel
        List<MigranteRedSocialRel> migranteRedSocialRelList = new ArrayList<>();
        List<MigranteRedSocialRel> migranteRedSocialRelExist = migranteRedSocialRelService.findByMigrante(migranteExist);
        int count= 0;
        for (RedSocialDTO redSocialDTO : migranteDTO.getRedesSociales()){
            for (MigranteRedSocialRelDTO migranteRedSocialRelDTO : redSocialDTO.getMigranteRedSocialRelDTOS()){
                RedSocial redSocial = redSocialService.findById(migranteRedSocialRelDTO.getRedSocialId()).orElseThrow(() -> new EntityNotFoundException("La red social no existe"));

                MigranteRedSocialRel migranteRedSocialRel = migranteRedSocialRelExist.get(count);

                migranteRedSocialRel.setMigrante(migranteExist);
                migranteRedSocialRel.setRedSocial(redSocial);
                migranteRedSocialRel.setNombreUsuarioRed(migranteRedSocialRelDTO.getNombreUsuarioRedSocial());
                migranteRedSocialRelList.add(migranteRedSocialRel);

                migranteRedSocialRelService.save(migranteRedSocialRel);
                count++;
            }
        }
        return migranteDTO;
    }

    /**
     * Controlador para eliminar un migrante por su ID.
     * @param idMigrante El ID del migrante que se va a eliminar.
     * @return Una ResponseEntity que indica si se elimino correctamente el migrante o si no se encontro el ID del migrante.
     */
    @DeleteMapping("/{idMigrante}")
    public ResponseEntity<?> eliminarMigrante(@PathVariable Integer idMigrante) {
        Optional<Migrante> migranteOptional = migranteService.findById(idMigrante);

        if (migranteOptional.isPresent()) {
            Migrante migrante = migranteOptional.get();

            /*
             * Desasociar la lista de relaciones de red social del migrante para evitar problemas de eliminacion en cascada
             * @param collections.emptyList() Esta funcion retorna una lista inmutable vacia, la cual es asignada a la lista de relaciones
             * de red social del migrante, eliminando cualquier relacion existente. Esto solo aplica dentro del contexto del metodo
             * eliminarMigrante. Es importante decir que migrante.getMigranteRedSocialRelList() aun va a contener la lista origonal
             * de relaciones hasta que no termine el ciclo de vida del metodo eliminarMigrante.
             */
            migrante.setMigranteRedSocialRelList(Collections.emptyList());

            // Eliminar cada entidad MigranteRedSocialRel individualmente
            List<MigranteRedSocialRel> migranteRedSocialRels = migrante.getMigranteRedSocialRelList();
            for (MigranteRedSocialRel migranteRedSocialRel : migranteRedSocialRels){
                migranteRedSocialRelService.deleteByMigrante(migrante);
            }

            // Eliminar el migrante en si
            migranteService.deleteById(idMigrante);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
