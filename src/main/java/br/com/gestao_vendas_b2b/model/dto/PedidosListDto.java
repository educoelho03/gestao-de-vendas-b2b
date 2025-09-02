package br.com.gestao_vendas_b2b.model.dto;

import br.com.gestao_vendas_b2b.model.entities.ClientesB2B;
import br.com.gestao_vendas_b2b.model.enums.StatusPedido;

import java.time.LocalDate;

public class PedidosListDto {

    private int id;
    private ClientesB2B clientes;
    private LocalDate date;
    private Double total;
    private StatusPedido statusPedido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientesB2B getClientes() {
        return clientes;
    }

    public void setClientes(ClientesB2B clientes) {
        this.clientes = clientes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
