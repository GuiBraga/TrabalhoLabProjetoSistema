package br.com.lab.dev.system.timeControl.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lab.dev.system.timeControl.domain.Dia;

@Repository
public interface DiaRepository extends CrudRepository<Dia, Integer> {
}
