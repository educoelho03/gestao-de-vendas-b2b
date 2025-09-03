package br.com.gestao_vendas_b2b.model.mapper;

import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioListDto;
import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoDto;
import br.com.gestao_vendas_b2b.model.dto.produtos.ProdutoListDto;
import br.com.gestao_vendas_b2b.model.entities.Funcionario;
import br.com.gestao_vendas_b2b.model.entities.Produto;

import java.util.function.Function;

public class FuncionarioMapper {
    public final static Function<Funcionario, FuncionarioDto> entityToDto = funcionario -> {
        FuncionarioDto dto = new FuncionarioDto();

        dto.setNome(funcionario.getNome());
        dto.setEmail(funcionario.getEmail());
        dto.setSenha(funcionario.getSenha());
        dto.setCargo(funcionario.getCargo());

        return dto;
    };

    public final static Function<Funcionario, FuncionarioListDto> entityToListDto = funcionario -> {
        FuncionarioListDto dto = new FuncionarioListDto();

        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setEmail(funcionario.getEmail());
        dto.setSenha(funcionario.getSenha());

        return dto;
    };
}
