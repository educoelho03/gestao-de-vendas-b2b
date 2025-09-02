package br.com.gestao_vendas_b2b.controller;

import br.com.gestao_vendas_b2b.model.dto.ClientesDto;
import br.com.gestao_vendas_b2b.model.dto.ClientesListDto;
import br.com.gestao_vendas_b2b.model.dto.ClientesSaveDto;
import br.com.gestao_vendas_b2b.service.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    ClientesService service;

    public ClientesController(ClientesService service) {
        this.service = service;
    }


    @GetMapping
    public List<ClientesListDto> all(){
        List<ClientesListDto> list = service.listAll();

        if(list.isEmpty()){
            throw new RuntimeException("No content"); // TODO: criar exception personalizada
        }

        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> update(ClientesDto dto, @PathVariable("id") int id){
        boolean flag = service.update(dto, id);

        if(flag){
            return ResponseEntity.ok().build();
        } else {
            throw new RuntimeException(); // TODO: criar exception personalizada
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(ClientesSaveDto dto){
        int id = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

}
