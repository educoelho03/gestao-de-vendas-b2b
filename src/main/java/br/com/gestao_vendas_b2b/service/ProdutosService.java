package br.com.gestao_vendas_b2b.service;

import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoDto;
import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoListDto;
import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoSaveDto;
import br.com.gestao_vendas_b2b.model.entities.Produto;
import br.com.gestao_vendas_b2b.model.mapper.ProdutoMapper;
import br.com.gestao_vendas_b2b.repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutosService {

    ProdutosRepository repo;

    public ProdutosService(ProdutosRepository repo) {
        this.repo = repo;
    }

    public List<ProdutoListDto> listAll() {
        List<ProdutoListDto> list = repo.findAll().stream()
                .map(ProdutoMapper.entityToListDto)
                .collect(Collectors.toList());

        return list;
    }

    @Transactional
    public int create(ProdutoSaveDto produtos) {
        Produto entity = new Produto();

        entity.setNome(produtos.getNome());
        entity.setPreco(produtos.getPreco());
        entity.setEstoque(produtos.getEstoque());

        repo.save(entity);

        return entity.getId();
    }

    @Transactional
    public boolean update(ProdutoDto dto, int id){
        Produto entity = repo.findByIdProduto(id);

        if(entity == null){
            return false;
        }

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setEstoque(dto.getEstoque());

        repo.save(entity);

        ProdutoMapper.entityToDto.apply(entity);

        return true;

    }

}
