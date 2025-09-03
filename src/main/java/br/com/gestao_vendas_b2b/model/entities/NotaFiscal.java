package br.com.gestao_vendas_b2b.model.entities;

import br.com.gestao_vendas_b2b.model.enums.StatusNFe;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notas_ficais")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    private String numero;

    private LocalDate dataEmissao;

    @Enumerated(EnumType.STRING)
    private StatusNFe status; // AUTORIZADA, REJEITADA, CANCELADA

    private String xml;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public StatusNFe getStatus() {
        return status;
    }

    public void setStatus(StatusNFe status) {
        this.status = status;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
