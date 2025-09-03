package br.com.gestao_vendas_b2b.repository;

import br.com.gestao_vendas_b2b.model.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    Funcionario findByIdFuncionario(int id);
    Optional<Funcionario> findByEmail(String email);
}
