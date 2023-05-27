package com.example.redsocialmigrante.service.impl.fundacion;

import com.example.redsocialmigrante.model.fundacion.Fundacion;
import com.example.redsocialmigrante.repository.fundacion.FundacionReopository;
import com.example.redsocialmigrante.service.fundacion.FundaciónService;
import com.example.redsocialmigrante.service.generics.impl.GenericServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FundacionServiceImplements extends GenericServiceImplement<Fundacion, Integer> implements FundaciónService {


    private final FundacionReopository fundacionReopository;

    @Override
    public CrudRepository<Fundacion, Integer> crudRepository() {
        return fundacionReopository;
    }

}
