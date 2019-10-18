package com.pessoas.springjpapessoas.endpoint;

import com.pessoas.springjpapessoas.entity.Pessoa;
import com.pessoas.springjpapessoas.repository.PessoaRepository;
import com.pessoas.springjpapessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaEndpoint {

//    private final PessoaRepository pessoaDAO; //Repositório de Pessoa

    @Autowired
    private PessoaService pessoaService;

//    @Autowired
//    public PessoaEndpoint(PessoaRepository pessoaDAO) {
//        this.pessoaDAO = pessoaDAO;
//    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(pessoaService.listarTodasAsPessoas(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPessoaById(@PathVariable("id") Long id) {
//        Optional<Pessoa> pessoa = pessoaDAO.findById(id);
        return new ResponseEntity<>(pessoaService.buscarPessoaPorId(id), HttpStatus.OK);
    }

    @GetMapping(path = "/findByApelido/{apelido}")
    public ResponseEntity<?> getListaPessoasByApelido(@PathVariable("apelido") String apelido) {
//        List<Pessoa> listaPessoasPorApelido = pessoaDAO.findPessoasByApelido(apelido);
        return new ResponseEntity<>(pessoaService.buscarPessoaPorApelido(apelido), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaService.cadastrarPessoa(pessoa), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
//        pessoaDAO.deleteById(id);
        pessoaService.deletarPessoa(id);
        return new ResponseEntity<>(HttpStatus.OK); //pq não consigo deixar o delete dentro do ResponseEntity<> ??
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Pessoa pessoa) {
        pessoaService.cadastrarPessoa(pessoa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}