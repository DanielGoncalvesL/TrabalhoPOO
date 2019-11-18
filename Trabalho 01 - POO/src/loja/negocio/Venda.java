package loja.negocio;

import java.util.Date;

public class Venda {

    private int codigo;
    private Date data;
    private double valorVenda;
    private String nomeCliente;

    public Venda(int codigoVenda, Date data, double valorVenda, String nomeCliente) {
        this.codigo = codigoVenda;
        this.data = data;
        this.valorVenda = valorVenda;
        this.nomeCliente = nomeCliente;
    }

    public Venda(Date data, double valorTotal, String nomeCliente) {
        this.data = data;
        this.valorVenda = valorTotal;
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
