//package com.example.redsocialmigrante.controller;
//
//import com.example.redsocialmigrante.dto.MigranteDTO;
//import com.example.redsocialmigrante.dto.MigranteRedSocialRelDTO;
//import com.example.redsocialmigrante.dto.RedSocialDTO;
//import com.example.redsocialmigrante.dto.RepresentanteDTO;
//import com.example.redsocialmigrante.model.Migrante;
//import com.example.redsocialmigrante.model.MigranteRedSocialRel;
//import com.example.redsocialmigrante.model.RedSocial;
//import com.example.redsocialmigrante.service.MigranteRedSocialRelService;
//import com.example.redsocialmigrante.service.impl.MigranteServiceImplement;
//import com.example.redsocialmigrante.service.impl.RedSocialServiceImplement;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.persistence.EntityNotFoundException;
//import javax.transaction.Transactional;
//import java.util.*;
//
///**
// * @author MarlonVelez
// * @version 1.0
// * Controlador para manejar solicitudes relacionadas con los migrantes.
// */
//@RestController
//@RequestMapping("/migrantes")
//@AllArgsConstructor
//public class MigranteController {
//
//    /** Servicio para manejar las operaciones relacionadas con los migrantes. */
//    private MigranteServiceImplement migranteService;
//
//    /** Servicio para manejar las operaciones relacionadas con las redes sociales. */
//    private RedSocialServiceImplement redSocialService;
//
//    /** Servicio para manejar las operaciones relacionadas con la entidad de relacion entre migrantes y redes sociales. */
//    private MigranteRedSocialRelService migranteRedSocialRelService;
//
//    /**
//     * Busca y devuelve un migrante segun su ID.
//     *
//     * @param id el ID del migrante a buscar
//     * @return el migrante encontrado en forma de DTO
//     * @throws EntityNotFoundException si no se encuentra un migrante con el ID especificado
//     */
//    @GetMapping("/{id}")
//    public MigranteDTO findById(@PathVariable Integer id) {
//        // Buscar el migrante por ID
//        Migrante migrante = migranteService.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Migrante no encontrado"));
//
//        // Convertir el migrante a DTO
//        MigranteDTO migranteDTO = new MigranteDTO();
//        migranteDTO.setProfesion(migrante.getProfesion());
//        migranteDTO.setIngresoMensual(migrante.getIngresoMensual());
//        migranteDTO.setSexo(migrante.getSexo());
//        migranteDTO.setEdad(migrante.getEdad());
//        migranteDTO.setGenero(migrante.getGenero());
//        migranteDTO.setNombre(migrante.getNombre());
//        migranteDTO.setFechaNacimiento(migrante.getFechaNacimiento());
//        migranteDTO.setApellido(migrante.getApellido());
//        migranteDTO.setCorreo(migrante.getCorreo());
//
//        // Buscar las relaciones de redes sociales para el migrante
//        List<RedSocialDTO> redesSociales = new ArrayList<>();
//        List<MigranteRedSocialRel> migranteRedSocialRels = migranteRedSocialRelService.findByMigrante(migrante);
//        List<MigranteRedSocialRelDTO> migranteRedSocialRelDTOList = new ArrayList<>();
//
//        for (MigranteRedSocialRel migranteRedSocialRel : migranteRedSocialRels){
//            MigranteRedSocialRelDTO migranteRedSocialRelDTO = new MigranteRedSocialRelDTO();
//            migranteRedSocialRelDTO.setNombreUsuarioRedSocial(migranteRedSocialRel.getNombreUsuarioRed());
//            migranteRedSocialRelDTO.setRedSocialId(migranteRedSocialRel.getIdMigranteRedSocialRel());
//            migranteRedSocialRelDTOList.add(migranteRedSocialRelDTO);
//        }
//
//        RedSocialDTO redSocialDTO = new RedSocialDTO();
//        redSocialDTO.setMigranteRedSocialRelDTOS(migranteRedSocialRelDTOList);
//        redesSociales.add(redSocialDTO);
//
//        migranteDTO.setRedesSociales(redesSociales);
//
//        // Si el migrante tiene un representante, obtener los datos del representante y asignarlos a un objeto RepresentanteDTO
//        if (migrante.getRepresentante() != null && !Objects.equals(migrante.getRepresentante().getIdMigrante(), id)) {
//            Migrante representante = migrante.getRepresentante();
//            RepresentanteDTO representanteDTO = new RepresentanteDTO();
//            migranteDTO.setIdRepresentante(representante.getIdMigrante());
//            representanteDTO.setNombre(representante.getNombre());
//            representanteDTO.setApellido(representante.getApellido());
//            representanteDTO.setCorreo(representante.getCorreo());
//            migranteDTO.setRepresentanteDTO(representanteDTO);
//        } else {
//            // Si el migrante no tiene representante, asignar el mensaje "No cuenta con representante"
//            migranteDTO.setRepresentanteDTO("Se representa a si mismo");
//        }
//
//        return migranteDTO;
//    }
//
//
//
//    /**
//     * Metodo para guardar un nuevo migrante en la base de datos junto con sus redes sociales asociadas.
//     *
//     * @param migranteDTO objeto de transferencia de datos que representa el migrante que se quiere guardar
//     * @return objeto de transferencia de datos que representa el migrante que se acaba de guardar
//     */
//    @PostMapping("/")
//    @Transactional
//    public MigranteDTO save(@RequestBody MigranteDTO migranteDTO) {
//        Migrante migranteSave = new Migrante();
//        try{
//
//            migranteSave.setProfesion(migranteDTO.getProfesion());
//            migranteSave.setIngresoMensual(migranteDTO.getIngresoMensual());
//            migranteSave.setSexo(migranteDTO.getSexo());
//            migranteSave.setEdad(migranteDTO.getEdad());
//            migranteSave.setGenero(migranteDTO.getGenero());
//            migranteSave.setNombre(migranteDTO.getNombre());
//            migranteSave.setFechaNacimiento(migranteDTO.getFechaNacimiento());
//            migranteSave.setApellido(migranteDTO.getApellido());
//            migranteSave.setCorreo(migranteDTO.getCorreo());
//
//            // Verificar si el migrante tiene un representante asignado
//            if (migranteDTO.getIdRepresentante() != null) {
//                // Buscar al representante en la base de datos
//                Optional<Migrante> representanteOptional = migranteService.findById(migranteDTO.getIdRepresentante());
//                if (representanteOptional.isPresent()) {
//                    // Asignar el representante al migrante
//                    Migrante representante = representanteOptional.get();
//                    migranteSave.setRepresentante(representante);
//                }
//            }
//
//            migranteService.createMigrante(migranteSave);
//
//        }catch (Exception e){
//            throw new RuntimeException("Error al guardar el registro del migrante "+" "+migranteDTO.getNombre()+" "+migranteDTO.getApellido(), e);
//        }
//
//        // Asociar las redes sociales con el migrante a traves de la entidad de relacion
//        List<MigranteRedSocialRel> migratedSocialReals = new ArrayList<>();
//        for (RedSocialDTO redSocialDTO : migranteDTO.getRedesSociales()) {
//            for (MigranteRedSocialRelDTO migranteRedSocialRelDTO : redSocialDTO.getMigranteRedSocialRelDTOS()) {
//                try {
//                    RedSocial redSocialExist = redSocialService.findById(migranteRedSocialRelDTO.getRedSocialId())
//                            .orElseThrow(() -> new EntityNotFoundException("La red social no existe"));
//
//                    MigranteRedSocialRel migranteRedSocialRel = new MigranteRedSocialRel();
//                    migranteRedSocialRel.setMigrante(migranteSave);
//                    migranteRedSocialRel.setRedSocial(redSocialExist);
//                    migranteRedSocialRel.setNombreUsuarioRed(migranteRedSocialRelDTO.getNombreUsuarioRedSocial());
//                    migratedSocialReals.add(migranteRedSocialRel);
//                    migranteRedSocialRelService.save(migranteRedSocialRel);
//                } catch (Exception e) {
//                    // Lanzar una excepción personalizada para que Spring maneje el rollback de la transacción
//                    throw new RuntimeException("Error al guardar la relación entre el migrante y las redes sociales", e);
//                }
//            }
//        }
//        return migranteDTO;
//    }
//
//
//    /**
//     * Actualiza los datos de un migrante existente en la base de datos y sus relaciones con las redes sociales.
//     * @param id Identificador unico del migrante a actualizar.
//     * @param migranteDTO Datos del migrante actualizados en formato DTO.
//     * @return Retorna los datos actualizados del migrante en formato DTO.
//     * @throws EntityNotFoundException Si el migrante no existe en la base de datos.
//     */
//    @PutMapping("/{id}")
//    @Transactional
//    public MigranteDTO update(@PathVariable("id") Integer id, @RequestBody MigranteDTO migranteDTO) throws EntityNotFoundException {
//
//        //Buscamos si existe el migrante con el id proporsionado
//        Migrante migranteExist = migranteService.findById(id).orElseThrow(() -> new EntityNotFoundException("El migrante no existe"));
//        migranteExist.setProfesion(migranteDTO.getProfesion());
//        migranteExist.setIngresoMensual(migranteDTO.getIngresoMensual());
//        migranteExist.setSexo(migranteDTO.getSexo());
//        migranteExist.setEdad(migranteDTO.getEdad());
//        migranteExist.setGenero(migranteDTO.getGenero());
//        migranteExist.setNombre(migranteDTO.getNombre());
//        migranteExist.setFechaNacimiento(migranteDTO.getFechaNacimiento());
//        migranteExist.setApellido(migranteDTO.getApellido());
//        migranteExist.setCorreo(migranteDTO.getCorreo());
//        migranteService.save(migranteExist);
//
//        // Actualizar al representante del migrante
//        if (migranteDTO.getIdRepresentante() != null) {
//            Migrante representanteExist = migranteService.findById(migranteDTO.getIdRepresentante())
//                    .orElseThrow(() -> new EntityNotFoundException("El representante no existe"));
//            migranteExist.setRepresentante(representanteExist);
//            migranteService.createMigrante(migranteExist);
//        }
//
//        //Actualizar la relaciones MigranteRedSocialRel
//        List<MigranteRedSocialRel> migranteRedSocialRelList = new ArrayList<>();
//        List<MigranteRedSocialRel> migranteRedSocialRelExist = migranteRedSocialRelService.findByMigrante(migranteExist);
//        int count= 0;
//        for (RedSocialDTO redSocialDTO : migranteDTO.getRedesSociales()){
//            for (MigranteRedSocialRelDTO migranteRedSocialRelDTO : redSocialDTO.getMigranteRedSocialRelDTOS()){
//                RedSocial redSocial = redSocialService.findById(migranteRedSocialRelDTO.getRedSocialId()).orElseThrow(() -> new EntityNotFoundException("La red social no existe"));
//
//                MigranteRedSocialRel migranteRedSocialRel = migranteRedSocialRelExist.get(count);
//
//                migranteRedSocialRel.setMigrante(migranteExist);
//                migranteRedSocialRel.setRedSocial(redSocial);
//                migranteRedSocialRel.setNombreUsuarioRed(migranteRedSocialRelDTO.getNombreUsuarioRedSocial());
//                migranteRedSocialRelList.add(migranteRedSocialRel);
//
//                migranteRedSocialRelService.save(migranteRedSocialRel);
//                count++;
//            }
//        }
//        return migranteDTO;
//    }
//
//    /**
//     * Controlador para eliminar un migrante por su ID.
//     * @param idMigrante El ID del migrante que se va a eliminar.
//     * @return Una ResponseEntity que indica si se elimino correctamente el migrante o si no se encontro el ID del migrante.
//     */
//    @DeleteMapping("/{idMigrante}")
//    @Transactional
//    public ResponseEntity<?> eliminarMigrante(@PathVariable Integer idMigrante) {
//        Optional<Migrante> migranteOptional = migranteService.findById(idMigrante);
//
//        if (migranteOptional.isPresent()) {
//
//            // Desasociar a los migrantes asociados de un representante antes de eliminarlo
//            List<Migrante> migrantesAsociados = migranteService.findByRepresentante(migranteOptional.get());
//            for (Migrante migranteAsociado : migrantesAsociados) {
//                migranteAsociado.setRepresentante(null);
//                migranteService.save(migranteAsociado);
//            }
//
//            Migrante migrante = migranteOptional.get();
//            migrante.setMigranteRedSocialRelList(Collections.emptyList());
//
//
//            /*
//             * Desasociar la lista de relaciones de red social del migrante para evitar problemas de eliminacion en cascada
//             * @param collections.emptyList() Esta funcion retorna una lista inmutable vacia, la cual es asignada a la lista de relaciones
//             * de red social del migrante, eliminando cualquier relacion existente. Esto solo aplica dentro del contexto del metodo
//             * eliminarMigrante. Es importante decir que migrante.getMigranteRedSocialRelList() aun va a contener la lista origonal
//             * de relaciones hasta que no termine el ciclo de vida del metodo eliminarMigrante.
//             */
//            System.out.println("A1 "+migrante.getMigranteRedSocialRelList().size());
//
//
//            // Eliminar cada entidad MigranteRedSocialRel individualmente
//            System.out.println("A2 "+migrante.getMigranteRedSocialRelList().size());
//            List<MigranteRedSocialRel> migranteRedSocialRels = migrante.getMigranteRedSocialRelList();
//            for (MigranteRedSocialRel migranteRedSocialRel : migranteRedSocialRels){
//                System.out.println("B");
//                migranteRedSocialRelService.deleteByMigrante(migrante);
//            }
//
//            // Eliminar el migrante en si
//            System.out.println("C");
//            migranteService.deleteById(idMigrante);
//            System.out.println("D");
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//}
