package br.com.gestao_vendas_b2b.controller;

import br.com.gestao_vendas_b2b.model.dto.clientes.ClienteDto;
import br.com.gestao_vendas_b2b.model.dto.clientes.ClienteListDto;
import br.com.gestao_vendas_b2b.model.dto.clientes.ClienteSaveDto;
import br.com.gestao_vendas_b2b.service.ClientesService;
import br.com.gestao_vendas_b2b.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    ClientesService clienteService;
    EmailService emailService;

    public ClientesController(ClientesService clienteService, EmailService emailService) {
        this.clienteService = clienteService;
        this.emailService = emailService;
    }

    @GetMapping
    public List<ClienteListDto> all(){
        List<ClienteListDto> list = clienteService.listAll();

        if(list.isEmpty()){
            throw new RuntimeException("No content"); // TODO: criar exception personalizada
        }

        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> update(ClienteDto dto, @PathVariable("id") int id){
        boolean flag = clienteService.update(dto, id);

        if(flag){
            return ResponseEntity.ok().build();
        } else {
            throw new RuntimeException("No content"); // TODO: criar exception personalizada
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(ClienteSaveDto dto){
        int id = clienteService.create(dto);

        String subject = "🚀 Bem-vindo(a) ao Sistema de Gestão de Vendas! - Cliente";
        String body = "Olá, Seja bem-vindo(a) ao nosso Sistema de Gestão de Vendas! ";

        emailService.sendMail(dto.getEmail(), subject, body);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

}
