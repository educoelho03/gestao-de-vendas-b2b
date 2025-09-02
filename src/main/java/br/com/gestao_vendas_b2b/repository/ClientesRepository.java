package br.com.gestao_vendas_b2b.repository;

import br.com.gestao_vendas_b2b.model.entities.ClientesB2B;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesB2B, Integer> {
    ClientesB2B findByIdCliente(int id);
}
