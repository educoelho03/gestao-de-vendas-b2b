package br.com.gestao_vendas_b2b.model.mapper;

import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoDto;
import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoListDto;
import br.com.gestao_vendas_b2b.model.entities.Produto;

import java.util.function.Function;

public class ProdutoMapper {
    public final static Function<Produto, ProdutoDto> entityToDto = produto -> {
        ProdutoDto dto = new ProdutoDto();

        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setEstoque(produto.getEstoque());

        return dto;
    };

    public final static Function<Produto, ProdutoListDto> entityToListDto = produto -> {
        ProdutoListDto dto = new ProdutoListDto();

        dto.setId(produto.getId());
        dto.setName(produto.getNome());
        dto.setPrice(produto.getPreco());
        dto.setEstoque(produto.getEstoque());

        return dto;
    };
}
