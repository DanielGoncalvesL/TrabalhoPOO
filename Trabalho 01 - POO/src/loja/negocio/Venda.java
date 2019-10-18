package loja.negocio;

import java.util.Date;
import java.util.List;

public class Venda {

    private int codigo;
    private Date data;
    private List<Item> itensVendidos;
    private double valorVenda;

    public Venda(int codigoVenda, Date data, List<Item> itens, String nomeCliente) {
        this.codigo = codigoVenda;
        this.data = data;
        this.itensVendidos = itens;
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValorVenda() {
        valorVenda = 0;
        for (int i = 0; i < itensVendidos.size(); i++) {
            valorVenda += itensVendidos.get(i).getPreco();
        }
        return valorVenda;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    private String nomeCliente;

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

    public List<Item> getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(List<Item> itensVendidos) {
        this.itensVendidos = itensVendidos;
    }
}
