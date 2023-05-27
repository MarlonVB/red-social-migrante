package com.example.redsocialmigrante.controller;

import com.example.redsocialmigrante.dto.fundacion.FundacionDTO;
import com.example.redsocialmigrante.service.impl.fundacion.FundacionServiceImplements;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fundacion")
@AllArgsConstructor
public class FundacionController {

    private final FundacionServiceImplements fundacionService;

    @PostMapping
    public ResponseEntity<?> saveDataFundacion(FundacionDTO fundacionDTO){
        return null;
    }
}
