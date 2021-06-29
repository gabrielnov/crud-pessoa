package br.com.mult3.Crud.controller;

import br.com.mult3.Crud.model.Pessoa;
import br.com.mult3.Crud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid Pessoa pessoa){
        pessoaService.cadastrar(pessoa);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>> listar(){
        return ResponseEntity.ok().body(pessoaService.listarPessoas());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Pessoa> acharPessoaPeloId(@PathVariable Long id) {
        return pessoaService.acharPeloId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody @Valid Pessoa pessoa) {
        pessoa.setId(id);
        return pessoaService.cadastrar(pessoa);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> apagar(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.acharPeloId(id);

        if(pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        pessoaService.apagar(id);
        return ResponseEntity.ok().build();

    }
}
