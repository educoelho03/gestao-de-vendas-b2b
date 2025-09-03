package br.com.gestao_vendas_b2b.controller;

import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioListDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioSaveDto;
import br.com.gestao_vendas_b2b.service.FuncionariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController { // TODO: CRIAR AUTENTICACAO DOS USUARIOS, SOMENTE CERTOS USUARIOS PODEM ACESSAR CERTAS FUNCIONALIDADES, DIFERENCIANDO PERFIL ADMIN E VENDENDOR

    FuncionariosService service;

    public FuncionarioController(FuncionariosService service) {
        this.service = service;
    }

    @GetMapping
    public List<FuncionarioListDto> all(){
        List<FuncionarioListDto> list = service.listAll();

        if(list.isEmpty()){
            throw new RuntimeException("No content"); // TODO: criar exception personalizada
        }

        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> update(FuncionarioDto dto, @PathVariable("id") int id){
        boolean flag = service.update(dto, id);

        if(flag){
            return ResponseEntity.ok().build();
        } else {
            throw new RuntimeException("No content"); // TODO: criar exception personalizada
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(FuncionarioSaveDto dto){
        int id = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

}
