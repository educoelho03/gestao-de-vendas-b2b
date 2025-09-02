package br.com.gestao_vendas_b2b.model.mapper;

import br.com.gestao_vendas_b2b.model.dto.ClientesDto;
import br.com.gestao_vendas_b2b.model.dto.ClientesListDto;
import br.com.gestao_vendas_b2b.model.entities.ClientesB2B;

import java.util.function.Function;

public class ClientesMapper {
    public final static Function<ClientesB2B, ClientesDto> entityToDto = clientes -> {
        ClientesDto dto = new ClientesDto();

        dto.setNomeEmpresa(clientes.getNomeEmpresa());
        dto.setCnpj(clientes.getCnpj());
        dto.setEmail(clientes.getEmail());
        dto.setPhone(clientes.getPhone());

        return dto;
    };

    public final static Function<ClientesB2B, ClientesListDto> entityToListDto =  clientes -> {
        ClientesListDto dto = new ClientesListDto();

        dto.setId(clientes.getId());
        dto.setNomeEmpresa(clientes.getNomeEmpresa());
        dto.setCnpj(clientes.getCnpj());
        dto.setEmail(clientes.getEmail());
        dto.setPhone(clientes.getPhone());

        return dto;
    };
}
