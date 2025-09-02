package br.com.gestao_vendas_b2b.repository;

import br.com.gestao_vendas_b2b.model.entities.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
    Pedidos findByIdPedido(int id);
}
