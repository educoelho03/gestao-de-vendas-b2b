package br.com.gestao_vendas_b2b.repository;

import br.com.gestao_vendas_b2b.model.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    Funcionario findByIdFuncionario(int id);
}
