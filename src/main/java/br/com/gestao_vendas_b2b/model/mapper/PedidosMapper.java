package br.com.gestao_vendas_b2b.model.mapper;

import br.com.gestao_vendas_b2b.model.dto.PedidosDto;
import br.com.gestao_vendas_b2b.model.dto.PedidosListDto;
import br.com.gestao_vendas_b2b.model.entities.Pedidos;

import java.util.function.Function;

public class PedidosMapper {

    public final static Function<Pedidos, PedidosDto> entityToDto = pedidos -> {
        PedidosDto dto = new PedidosDto();

        dto.setId(pedidos.getId());
        dto.setClientes(pedidos.getClientes());
        dto.setDate(pedidos.getDate());
        dto.setTotal(pedidos.getTotal());
        dto.setStatusPedido(pedidos.getStatusPedido());

        return dto;

    };

    public final static Function<Pedidos, PedidosListDto> entityToDtoList = pedidos -> {
        PedidosListDto dto = new PedidosListDto();

        dto.setId(pedidos.getId());
        dto.setClientes(pedidos.getClientes());
        dto.setDate(pedidos.getDate());
        dto.setTotal(pedidos.getTotal());
        dto.setStatusPedido(pedidos.getStatusPedido());

        return dto;

    };

}
