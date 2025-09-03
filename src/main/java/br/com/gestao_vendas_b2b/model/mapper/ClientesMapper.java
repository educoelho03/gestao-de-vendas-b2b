package br.com.gestao_vendas_b2b.model.mapper;

import br.com.gestao_vendas_b2b.model.dto.clientes.ClienteDto;
import br.com.gestao_vendas_b2b.model.dto.clientes.ClienteListDto;
import br.com.gestao_vendas_b2b.model.entities.Cliente;

import java.util.function.Function;

public class ClientesMapper {
    public final static Function<Cliente, ClienteDto> entityToDto = clientes -> {
        ClienteDto dto = new ClienteDto();

        dto.setNome(clientes.getNome());
        dto.setCnpj(clientes.getCnpj());
        dto.setEmail(clientes.getEmail());
        dto.setPhone(clientes.getPhone());

        return dto;
    };

    public final static Function<Cliente, ClienteListDto> entityToListDto = clientes -> {
        ClienteListDto dto = new ClienteListDto();

        dto.setId(clientes.getId());
        dto.setNome(clientes.getNome());
        dto.setCnpj(clientes.getCnpj());
        dto.setEmail(clientes.getEmail());
        dto.setPhone(clientes.getPhone());

        return dto;
    };
}
