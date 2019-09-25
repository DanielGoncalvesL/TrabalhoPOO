package loja.negocio;

import java.util.Date;

public class Venda {

	private int codigo;
	private Date data;
	private Item[] itensVendidos;
	public String getNomeCliente() {
		return nomeCliente;
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

	public Item[] getItensVendidos() {
		return itensVendidos;
	}

	public void setItensVendidos(Item[] itensVendidos) {
		this.itensVendidos = itensVendidos;
	}
}
