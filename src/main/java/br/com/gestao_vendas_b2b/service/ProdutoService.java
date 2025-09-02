package br.com.gestao_vendas_b2b.service;

import br.com.gestao_vendas_b2b.model.dto.PedidosDto;
import br.com.gestao_vendas_b2b.model.dto.PedidosListDto;
import br.com.gestao_vendas_b2b.model.dto.PedidosSaveDto;
import br.com.gestao_vendas_b2b.model.entities.Pedidos;
import br.com.gestao_vendas_b2b.model.mapper.PedidosMapper;
import br.com.gestao_vendas_b2b.repository.PedidosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    PedidosRepository repo;

    public ProdutoService(PedidosRepository repository) {
        this.repo = repository;
    }

    public List<PedidosListDto> listAll() {
        List<PedidosListDto> list = repo.findAll().stream()
                .map(PedidosMapper.entityToDtoList)
                .collect(Collectors.toList());

        return list;
    }

    @Transactional
    public int create(PedidosSaveDto pedido) {
        Pedidos entity = new Pedidos();

        entity.setId(pedido.getId());
        entity.setClientes(pedido.getClientes());
        entity.setDate(LocalDate.now());
        entity.setTotal(pedido.getTotal());
        entity.setStatusPedido(pedido.getStatusPedido());

        if (entity.getTotal() == null) {
            entity.setTotal(0.0);
        }

        repo.save(entity);

        return entity.getId();
    }

    @Transactional
    public boolean update(PedidosDto dto, int id){
        Pedidos entity = repo.findByIdPedido(id);

        if(entity == null){
            return false;
        }

        repo.findById(id);

        entity.setClientes(dto.getClientes());
        entity.setDate(dto.getDate());
        entity.setTotal(dto.getTotal());
        entity.setStatusPedido(dto.getStatusPedido());

        repo.save(entity);

        PedidosMapper.entityToDto.apply(entity);

        return true;

    }
}
