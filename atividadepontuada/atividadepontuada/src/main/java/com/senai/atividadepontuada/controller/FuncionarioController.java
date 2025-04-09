package com.senai.atividadepontuada.controller;

import com.senai.atividadepontuada.models.Funcionario;
import com.senai.atividadepontuada.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/listar")
    public List<Funcionario> listarTodos(){
        return funcionarioService.listarTodos();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","Funcionario cadastrado com sucesso"));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario atualizado.");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        funcionarioService.excluir(id);
        return ResponseEntity.ok().body("Funcionario deletado");
    }
}
