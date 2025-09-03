package br.com.gestao_vendas_b2b.controller;

import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoDto;
import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoListDto;
import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoSaveDto;
import br.com.gestao_vendas_b2b.service.ProdutosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    ProdutosService service;

    public ProdutosController(ProdutosService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProdutoListDto> all(){
        List<ProdutoListDto> list = service.listAll();

        if(list.isEmpty()){
            throw new RuntimeException("No content"); // TODO: criar exception personalizada
        }

        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> update(ProdutoDto dto, @PathVariable("id") int id){
        boolean flag = service.update(dto, id);

        if(flag){
            return ResponseEntity.ok().build();
        } else {
            throw new RuntimeException(); // TODO: criar exception personalizada
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(ProdutoSaveDto dto){
        int id = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
