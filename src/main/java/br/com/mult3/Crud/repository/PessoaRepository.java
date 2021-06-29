package br.com.mult3.Crud.repository;

import br.com.mult3.Crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
