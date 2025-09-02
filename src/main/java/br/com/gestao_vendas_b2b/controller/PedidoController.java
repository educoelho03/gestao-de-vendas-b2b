package br.com.gestao_vendas_b2b.controller;

import br.com.gestao_vendas_b2b.model.dto.PedidosDto;
import br.com.gestao_vendas_b2b.model.dto.PedidosListDto;
import br.com.gestao_vendas_b2b.model.dto.PedidosSaveDto;
import br.com.gestao_vendas_b2b.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class PedidoController {

    PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PedidosListDto> all(){
        List<PedidosListDto> list = service.listAll();

        if (list.isEmpty()){
            throw new RuntimeException("NO CONTENT"); // todo: criar exception personalizada
        }

        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> update(PedidosDto dto, @PathVariable("id") int id){
        boolean flag = service.update(dto, id);

        if(flag){
            return ResponseEntity.ok().build();
            } else {
                throw new RuntimeException("NOT FOUND");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(PedidosSaveDto dto){
        Integer id = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

}
