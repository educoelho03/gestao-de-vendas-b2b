package br.com.gestao_vendas_b2b.controller;

import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioListDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioSaveDto;
import br.com.gestao_vendas_b2b.service.EmailService;
import br.com.gestao_vendas_b2b.service.FuncionariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController { // TODO: CRIAR AUTENTICACAO DOS USUARIOS, SOMENTE CERTOS USUARIOS PODEM ACESSAR CERTAS FUNCIONALIDADES, DIFERENCIANDO PERFIL ADMIN E VENDENDOR

    FuncionariosService funcionariosService;
    EmailService emailService;

    public FuncionarioController(FuncionariosService funcionariosService, EmailService emailService) {
        this.funcionariosService = funcionariosService;
        this.emailService = emailService;
    }

    @GetMapping
    public List<FuncionarioListDto> all(){
        List<FuncionarioListDto> list = funcionariosService.listAll();

        if(list.isEmpty()){
            throw new RuntimeException("No content"); // TODO: criar exception personalizada
        }

        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> update(FuncionarioDto dto, @PathVariable("id") int id){
        boolean flag = funcionariosService.update(dto, id);

        if(flag){
            return ResponseEntity.ok().build();
        } else {
            throw new RuntimeException("No content"); // TODO: criar exception personalizada
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(FuncionarioSaveDto dto){
        int id = funcionariosService.create(dto);

        String subject = "🚀 Bem-vindo(a) ao Sistema de Gestão de Vendas! - Funcionario";
        String body = "Olá, Seja bem-vindo(a) ao nosso Sistema de Gestão de Vendas! ";

        emailService.sendMail(dto.getEmail(), subject, body);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

}
