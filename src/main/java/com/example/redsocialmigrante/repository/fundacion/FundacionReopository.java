package com.example.redsocialmigrante.repository.fundacion;

import com.example.redsocialmigrante.model.fundacion.Fundacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundacionReopository extends JpaRepository<Fundacion, Integer> {


}
