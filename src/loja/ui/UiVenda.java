package loja.ui;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import loja.negocio.Carrinho;
import loja.negocio.Item;
import loja.negocio.Produto;
import loja.negocio.Sistema;
import loja.negocio.Venda;

public class UiVenda {

	private Scanner scn;

	private Sistema sis;

	public UiVenda() {
		sis = Sistema.getInstance();
		scn = new Scanner(System.in);
	}

	public void listar() {
		Venda[] vendas = sis.listarVenda();
		if (vendas != null) {
			System.out.println("Codigo Venda\tData Venda\tValor da Venda");
			for (int i = 0; i < vendas.length; i++) {
				if (vendas[i] != null) {
					double valorVenda = 0;
					for (int j = 0; j < vendas[i].getItensVendidos().length; j++) {
						if (vendas[i].getItensVendidos()[j] != null) {
							Item item = vendas[i].getItensVendidos()[j];
							valorVenda += item.getPreco();
						}
					}
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					System.out.println("\n" + vendas[i].getCodigo() + "\t" + sdf.format(vendas[i].getData()) + "\t R$"
							+ valorVenda);
				}
			}
		}
	}

	public void listarData() {
		System.out.println("Informe a data que deseja pesquisar as vendas:");
		String data = scn.next();
		while (data.equals("")) {
			System.out.println("Informe a data novamente:");
			data = scn.next();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Venda[] vendas = sis.listarData(data);
		if (vendas != null) {
			System.out.println("Codigo Venda\tData Venda\tValor da Venda");
			for (int i = 0; i < vendas.length; i++) {
				if (vendas[i] != null) {
					double valorVenda = 0;
					for (int j = 0; j < vendas[i].getItensVendidos().length; j++) {
						if (vendas[i].getItensVendidos()[j] != null) {
							Item item = vendas[i].getItensVendidos()[j];
							valorVenda += item.getPreco();
						}
					}
					System.out.println("\n" + vendas[i].getCodigo() + "\t" + sdf.format(vendas[i].getData()) + "\t R$"
							+ valorVenda);
				}
			}
		}
	}

	public void listarCodigo() {
		System.out.println("Informe o código da venda que deseja buscar:");
		int codigo = scn.nextInt();
		while (codigo < 0) {
			System.out.println("Informe um valor válido:");
			codigo = scn.nextInt();
		}
		Venda venda = sis.listarCodigo(codigo);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (venda != null) {
			System.out.println("Codigo Venda\tData Venda\tValor da Venda\tNome Cliente");
			double valorVenda = 0;
			for (int j = 0; j < venda.getItensVendidos().length; j++) {
				if (venda.getItensVendidos()[j] != null) {
					Item item = venda.getItensVendidos()[j];
					valorVenda += item.getPreco();
				}
			}
			System.out.println("\n" + venda.getCodigo() + "\t" + sdf.format(venda.getData()) + "\t R$" + valorVenda
					+ "\t" + venda.getNomeCliente() + "\n");
			for(int i = 0; i < venda.getItensVendidos().length; i++) {
				if(venda.getItensVendidos()[i] != null) {
					System.out.println("Produtos Vendidos\tQuantidade\t" + "\n" + venda.getItensVendidos()[i].getProduto().getNome() + "\t" + venda.getItensVendidos()[i].getQuantidade());
				}
			}
		}
	}

	public void Menu() {
		int controlador = 0;
		double somaCarrinho = 0;
		while (controlador == 0) {
			System.out.println("Informe o nome do produto que deseja adicionar ao carrinho: ");
			String nome = scn.next();
			while (nome.equals("")) {
				System.out.println("Informe um nome válido:");
				nome = scn.next();
			}

			Produto produto = sis.buscarNome(nome);

			if (produto != null) {
				System.out.println("Produto Encontrado\nO preço do produto é: R$" + produto.getPreco() + ". Tem "
						+ produto.getQuantEstoque() + " no estoque\nDeseja adicionar ao carrinho(s/n)?");
				String o = scn.next();
				while (!o.equals("s") && !o.equals("n")) {
					System.out.println("Opcao Invalida!!!\nInforme uma opcao valida: ");
					o = scn.next();
				}
				if (o.equals("s")) {
					System.out.println("Informe a quantidade que deseja adicionar ao carrinho:");
					double quantidade = scn.nextDouble();
					while (quantidade <= 0 || quantidade >= produto.getQuantEstoque()) {
						System.out.println("Quantidade Inválida!!!\nInforme novamente:");
						quantidade = scn.nextDouble();
					}

					Item item = sis.criarItem(produto, quantidade);
					if (item != null) {
						if (sis.inserirCarrinho(item)) {
							int controladorSwitch = 0;
							somaCarrinho = item.getPreco() + somaCarrinho;
							System.out.println(
									"Item inserido com sucesso no carrinho!!\nSeu carrinho tem: R$" + somaCarrinho);
							do {
								System.out.println(
										"1- Adicionar outro produto no carrinho\n2- Concluir a venda\n3- Listar Carrinho\n4- Excluir Item do Carrinho\n0- Cancelar e sair");
								int opcao = scn.nextInt();
								while (opcao != 1 && opcao != 2 && opcao != 0 && opcao != 3) {
									System.out.println("Opção Invalida!!\nInforme uma opcao valida:");
									opcao = scn.nextInt();
								}
								switch (opcao) {
								case 1:
									controladorSwitch = 1;
									break;
								case 2:
									System.out.println("Informe o nome do cliente:");
									String nomeCliente = scn.next();
									if (sis.concluirVenda(nomeCliente)) {
										System.out.println("Venda realizada com sucesso!!");
										controlador = 1;
									}
									controladorSwitch = 1;
									break;
								case 3:
									Carrinho carrinho = sis.listarCarrinho();
									if (carrinho != null) {
										System.out.println("Nome do Item\tPreço do item\tQuantidade");
										for (int i = 0; i < carrinho.getItens().length; i++) {
											if (carrinho.getItens()[i] != null) {
												System.out.println("\n" + carrinho.getItens()[i].getProduto().getNome()
														+ "\tR$" + carrinho.getItens()[i].getPreco() + "\t"
														+ carrinho.getItens()[i].getQuantidade());
											}
										}
									}
									break;
								case 0:
									controladorSwitch = 1;
									controlador = 1;
									break;
								}
							} while (controladorSwitch == 0);
						} else {
							System.out.println("Nao foi possivel adicionar ao carrinho!!");
						}
					} else {
						System.out.println("Nao foi possivel adicionar ao carrinho!!");
					}
				} else {
					System.out.println("Saindo...");
					controlador = 1;
				}
			}
		}
	}
}
