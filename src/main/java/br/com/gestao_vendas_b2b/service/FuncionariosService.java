package br.com.gestao_vendas_b2b.service;

import br.com.gestao_vendas_b2b.event.FuncionarioCadastradoEvent;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioListDto;
import br.com.gestao_vendas_b2b.model.dto.funcionarios.FuncionarioSaveDto;
import br.com.gestao_vendas_b2b.model.entities.Funcionario;
import br.com.gestao_vendas_b2b.model.enums.Cargo;
import br.com.gestao_vendas_b2b.model.mapper.FuncionarioMapper;
import br.com.gestao_vendas_b2b.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionariosService {

    FuncionarioRepository repo;
    PasswordEncoder passwordEncoder;
    ApplicationEventPublisher eventPublisher;

    public FuncionariosService(FuncionarioRepository repo, PasswordEncoder passwordEncoder, ApplicationEventPublisher eventPublisher) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.eventPublisher = eventPublisher;
    }

    public FuncionariosService(FuncionarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
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
        entity.setSenha(passwordEncoder.encode(funcionario.getSenha()));
        entity.setCargo(Cargo.VENDEDOR);

        repo.save(entity);

        eventPublisher.publishEvent(new FuncionarioCadastradoEvent(this, entity.getEmail(), entity.getNome())); // disparamos o email apos ele ser salvo no banco

        return entity.getId();
    }

    @Transactional
    public boolean update(FuncionarioDto dto, int id){
        Funcionario entity = repo.findById(id);

        if(entity == null){
            return false;
        }

        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());

        // Só atualiza a senha se foi fornecida uma nova
        if (dto.getSenha() != null && !dto.getSenha().trim().isEmpty()) {
            entity.setSenha(passwordEncoder.encode(dto.getSenha()));
        }

        entity.setCargo(dto.getCargo());

        repo.save(entity);

        FuncionarioMapper.entityToDto.apply(entity);

        return true;

    }
}
