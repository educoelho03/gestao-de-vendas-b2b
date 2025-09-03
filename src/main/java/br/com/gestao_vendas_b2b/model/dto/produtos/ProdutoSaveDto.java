package br.com.gestao_vendas_b2b.model.dto.produtos;

import java.math.BigDecimal;

public class ProdutoSaveDto {

    private String nome;
    private BigDecimal preco;
    private Integer estoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
