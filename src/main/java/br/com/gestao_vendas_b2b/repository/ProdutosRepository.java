package br.com.gestao_vendas_b2b.repository;

import br.com.gestao_vendas_b2b.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
    Produto findById(int id);
}
