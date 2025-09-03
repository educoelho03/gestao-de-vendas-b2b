package br.com.gestao_vendas_b2b.service;

import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioListDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioSaveDto;
import br.com.gestao_vendas_b2b.model.entities.Funcionario;
import br.com.gestao_vendas_b2b.model.enums.Cargo;
import br.com.gestao_vendas_b2b.model.mapper.FuncionarioMapper;
import br.com.gestao_vendas_b2b.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionariosService {

    FuncionarioRepository repo;

    public FuncionariosService(FuncionarioRepository repo) {
        this.repo = repo;
    }


    public List<FuncionarioListDto> listAll() {
        List<FuncionarioListDto> list = repo.findAll().stream()
                .map(FuncionarioMapper.entityToListDto)
                .collect(Collectors.toList());

        return list;
    }

    @Transactional
    public int create(FuncionarioSaveDto funcionario) {
        Funcionario entity = new Funcionario();

        entity.setNome(funcionario.getNome());
        entity.setEmail(funcionario.getEmail());
        entity.setSenha(funcionario.getEmail());
        entity.setCargo(Cargo.VENDEDOR);

        repo.save(entity);

        return entity.getId();
    }

    @Transactional
    public boolean update(FuncionarioDto dto, int id){
        Funcionario entity = repo.findByIdFuncionario(id);

        if(entity == null){
            return false;
        }

        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setCargo(dto.getCargo());

        repo.save(entity);

        FuncionarioMapper.entityToDto.apply(entity);

        return true;

    }
}
