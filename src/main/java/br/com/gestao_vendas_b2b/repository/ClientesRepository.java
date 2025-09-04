package br.com.gestao_vendas_b2b.repository;

import br.com.gestao_vendas_b2b.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
    Cliente findById(int id);
}
