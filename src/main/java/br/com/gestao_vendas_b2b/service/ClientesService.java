package br.com.gestao_vendas_b2b.service;

import br.com.gestao_vendas_b2b.model.dto.ClientesDto;
import br.com.gestao_vendas_b2b.model.dto.ClientesListDto;
import br.com.gestao_vendas_b2b.model.dto.ClientesSaveDto;
import br.com.gestao_vendas_b2b.model.entities.ClientesB2B;
import br.com.gestao_vendas_b2b.model.mapper.PedidosMapper;
import br.com.gestao_vendas_b2b.repository.ClientesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesService {

    public ClientesRepository repo;

    public ClientesService(ClientesRepository repo) {
        this.repo = repo;
    }

    public List<ClientesListDto> listAll() {
        List<ClientesListDto> list = repo.findAll().stream()
                .map(ClientesMapper.entityToDtoList)
                .collect(Collectors.toList());

        return list;
    }

    @Transactional
    public int create(ClientesSaveDto clientes) {
        ClientesB2B entity = new ClientesB2B();

        entity.setNomeEmpresa(clientes.getNomeEmpresa());
        entity.setCnpj(clientes.getCnpj());
        entity.setEmail(clientes.getEmail());
        entity.setPhone(clientes.getPhone());

        repo.save(entity);

        return entity.getId();
    }

    @Transactional
    public boolean update(ClientesDto dto, int id){
        ClientesB2B entity = repo.findByIdCliente(id);

        if(entity == null){
            return false;
        }

        entity.setNomeEmpresa(dto.getNomeEmpresa());
        entity.setCnpj(dto.getCnpj());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        repo.save(entity);

        PedidosMapper.entityToDto.apply(entity);

        return true;

    }

}
