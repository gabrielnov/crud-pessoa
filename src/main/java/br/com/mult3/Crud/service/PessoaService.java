package br.com.mult3.Crud.service;

import br.com.mult3.Crud.model.Pessoa;
import br.com.mult3.Crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa cadastrar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public void apagar(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Optional<Pessoa> acharPeloId(Long id) {
        return pessoaRepository.findById(id);
    }
}
