package br.com.gestao_vendas_b2b.service;

import br.com.gestao_vendas_b2b.model.dto.clientes.ClienteDto;
import br.com.gestao_vendas_b2b.model.dto.clientes.ClienteListDto;
import br.com.gestao_vendas_b2b.model.dto.clientes.ClienteSaveDto;
import br.com.gestao_vendas_b2b.model.entities.Cliente;
import br.com.gestao_vendas_b2b.model.mapper.ClientesMapper;
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

    public List<ClienteListDto> listAll() {
        List<ClienteListDto> list = repo.findAll().stream()
                .map(ClientesMapper.entityToListDto)
                .collect(Collectors.toList());

        return list;
    }

    @Transactional
    public int create(ClienteSaveDto clientes) {
        Cliente entity = new Cliente();

        entity.setNome(clientes.getNome());
        entity.setCnpj(clientes.getCnpj());
        entity.setEmail(clientes.getEmail());
        entity.setPhone(clientes.getPhone());

        repo.save(entity);

        return entity.getId();
    }

    @Transactional
    public boolean update(ClienteDto dto, int id){
        Cliente entity = repo.findById(id);

        if(entity == null){
            return false;
        }

        entity.setNome(dto.getNome());
        entity.setCnpj(dto.getCnpj());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        repo.save(entity);

        ClientesMapper.entityToDto.apply(entity);

        return true;

    }

}
