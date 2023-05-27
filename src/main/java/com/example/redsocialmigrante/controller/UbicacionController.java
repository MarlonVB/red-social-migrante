package com.example.redsocialmigrante.controller;

import com.example.redsocialmigrante.dto.fundacion.UbicacionDTO;
import com.example.redsocialmigrante.model.fundacion.Canton;
import com.example.redsocialmigrante.model.fundacion.Parroquia;
import com.example.redsocialmigrante.model.fundacion.Provincia;
import com.example.redsocialmigrante.model.fundacion.Ubicacion;
import com.example.redsocialmigrante.service.impl.fundacion.CantonServiceImplement;
import com.example.redsocialmigrante.service.impl.fundacion.ParroquiaServiceImplement;
import com.example.redsocialmigrante.service.impl.fundacion.ProvinciaServiceImplement;
import com.example.redsocialmigrante.service.impl.fundacion.UbicacionServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("ubicacion")
@AllArgsConstructor
public class UbicacionController {

    private final UbicacionServiceImplement ubicacionService;
    private final ProvinciaServiceImplement provinciaService;
    private final CantonServiceImplement cantonService;
    private final ParroquiaServiceImplement parroquiaService;


    @GetMapping
    public ResponseEntity<?> verDataUbicacion() {
        Iterable<Ubicacion> dataUbicacion = ubicacionService.findAll();
        UbicacionDTO ubicacionDTO = new UbicacionDTO();
        // Verificar si dataUbicacion está vacío
        if (StreamSupport.stream(dataUbicacion.spliterator(), false).findAny().isPresent()) {
            StreamSupport.stream(dataUbicacion.spliterator(), false).forEach(ubicacion -> {
                        ubicacionDTO.setZona(ubicacion.getZona());
                        ubicacionDTO.setDistrito(ubicacion.getDistrito());
                        ubicacionDTO.setNombreProvincia(ubicacion.getProvincia().getNombre());
                        ubicacionDTO.setNombreCanton(ubicacion.getCanton().getNombre());
                        ubicacionDTO.setNombreParroquia(ubicacion.getParroquia().getNombre());
                    }
            );
            return ResponseEntity.ok(ubicacionDTO);

        } else {
            return new ResponseEntity<>("No hay información que mostrar", HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveDataUbcacion(UbicacionDTO ubicacionDTO) {

        // * Validamos que exista la provincia con el nombre que madamos como parametro en el DTO
        Provincia provinciaExist = provinciaService.findByNombreLike(ubicacionDTO.getNombreProvincia()).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Provincia no encontrada"));

        // * Validamos que exista el canton con el nombre que madamos como parametro en el DTO
        Canton cantonExist = cantonService.findByNombreLike(ubicacionDTO.getNombreCanton()).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Canton no encontrado"));

        // * Validamos que exista la parroquia con el nombre que madamos como parametro en el DTO
        Parroquia parroquiaExist = parroquiaService.findByNombreLike(ubicacionDTO.getNombreParroquia()).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Parroquia no encontrada"));

        // * Una vez validado lo anterior ya podremos settear los campos propios de Ubicacion
        Ubicacion ubicacionSave = new Ubicacion();

        ubicacionSave.setDistrito(ubicacionDTO.getDistrito());
        ubicacionSave.setZona(ubicacionDTO.getZona());
        ubicacionSave.setProvincia(provinciaExist);
        ubicacionSave.setCanton(cantonExist);
        ubicacionSave.setParroquia(parroquiaExist);

        // * Guardamos la data de ubicacion
        ubicacionService.save(ubicacionSave);

        return new ResponseEntity<>("Ubicacion guardada", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDataUbicacion(@PathVariable("id") Integer id, @RequestBody UbicacionDTO ubicacionDTO){

        Ubicacion ubicacionExist = ubicacionService.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El ristro solicitado no fue encontrado"));

        // * Validamos que exista la provincia con el nombre que madamos como parametro en el DTO
        Provincia provinciaExist = provinciaService.findByNombreLike(ubicacionDTO.getNombreProvincia()).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Provincia no encontrada"));

        // * Validamos que exista el canton con el nombre que madamos como parametro en el DTO
        Canton cantonExist = cantonService.findByNombreLike(ubicacionDTO.getNombreCanton()).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Canton no encontrado"));

        // * Validamos que exista la parroquia con el nombre que madamos como parametro en el DTO
        Parroquia parroquiaExist = parroquiaService.findByNombreLike(ubicacionDTO.getNombreParroquia()).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Parroquia no encontrada"));

        ubicacionExist.setDistrito(ubicacionDTO.getDistrito());
        ubicacionExist.setZona(ubicacionDTO.getZona());
        ubicacionExist.setProvincia(provinciaExist);
        ubicacionExist.setCanton(cantonExist);
        ubicacionExist.setParroquia(parroquiaExist);

        ubicacionService.save(ubicacionExist);

        return new ResponseEntity<>("Ubicacion actualizada", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUbicacion(@PathVariable("id") Integer id){

        Ubicacion ubicacionExist = ubicacionService.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El ristro solicitado no fue encontrado"));

        ubicacionService.deleteById(id);

        return new ResponseEntity<>("Ubicacion eliminada", HttpStatus.OK);
    }

}
