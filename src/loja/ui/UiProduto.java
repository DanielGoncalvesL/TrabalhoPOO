package loja.ui;

import java.util.Scanner;

import loja.negocio.Produto;
import loja.negocio.Sistema;

public class UiProduto {

	private Scanner scn;

	private Sistema sis;

	public UiProduto() {
		sis = Sistema.getInstance();
		scn = new Scanner(System.in);
	}

	public void inserir() {
		System.out.println("-- INSERIR PRODUTO --\nInforme o nome:");
		String nome = scn.next();
		while (nome.equals("")) {
			System.out.println("Informe o nome novamente: ");
			nome = scn.next();
		}
		System.out.println("Informe uma descricao para esse produto:");
		String descricao = scn.next();
		while (descricao.equals("")) {
			System.out.println("Informe a descricao novamente!!");
			descricao = scn.next();
		}
		System.out.println("Informe o preco do Produto: ");
		double preco = scn.nextDouble();
		while (preco <= 0) {
			System.out.println("Informe o preco novamente:");
			preco = scn.nextDouble();
		}

		System.out.println("Informe a quantidade em estoque:");
		double quantEstoque = scn.nextDouble();
		while (quantEstoque <= 0) {
			System.out.println("Informe a quantidade de estoque novamente:");
			quantEstoque = scn.nextDouble();
		}
		Produto produto = new Produto(nome, descricao, preco, quantEstoque);
		if (sis.inserir(produto)) {
			System.out.println("Produto Inserido com sucesso!!");
		} else {
			System.out.println("Produto Nao Inserido!!");
		}
	}

	public void excluir() {
		System.out.println("-- EXCLUIR PRODUTO --\nInforme o codigo do produto que deseja excluir:");
		int codigo = scn.nextInt();
		while (codigo < 0) {
			System.out.println("Informe o codigo novamente:");
			codigo = scn.nextInt();
		}
		if (sis.excluir(codigo)) {
			System.out.println("Produto Excluido com Sucesso!!");
		} else {
			System.out.println("Falha ao excluir!!");
		}
	}

	public void alterar() {
		System.out.println("-- ALTERAR DADOS --/nInforme o codigo do produto que deseja fazer as modificacoes:");
		int codigo = scn.nextInt();
		while (codigo < 0) {
			System.out.println("Informe o codigo novamente:");
			codigo = scn.nextInt();
		}
		Produto produto1 = sis.buscar(codigo);
		System.out.println("Informe o novo nome:");
		produto1.setNome(scn.next());
		while (produto1.getNome().equals("")) {
			System.out.println("Informe o nome novamente: ");
			produto1.setNome(scn.next());
		}
		System.out.println("Informe a nova descricao:");
		produto1.setDescricao(scn.next());
		while (produto1.getDescricao().equals("")) {
			System.out.println("Informe a descricao novamente:");
			produto1.setDescricao(scn.next());
		}
		System.out.println("Informe o novo preco do Produto: ");
		produto1.setPreco(scn.nextDouble());
		while (produto1.getPreco() <= 0) {
			System.out.println("Informe o preco novamente:");
			produto1.setPreco(scn.nextDouble());
		}

		System.out.println("Informe a nova quantidade em estoque:");
		produto1.setQuantEstoque(scn.nextInt());
		while (produto1.getQuantEstoque() <= 0) {
			System.out.println("Informe a quantidade de estoque novamente:");
			produto1.setQuantEstoque(scn.nextInt());
		}
		if (sis.alterar(produto1, codigo)) {
			System.out.println("Produto Alterado com Sucesso!!");
		} else {
			System.out.println("Falha ao Alterar Produto");
		}
	}

	public void buscar() {
		System.out.println("Informe o codigo do produto que deseja buscar:");
		int codigo = scn.nextInt();
		while (codigo < 0) {
			System.out.println("Informe o codigo novamente:");
			codigo = scn.nextInt();
		}
		Produto produto = sis.buscar(codigo);
		if (produto != null) {
			System.out.println("Codigo\tNome\tDescricao\tPreco\tQuantidade em Estoque\n" + produto.getCodigo() + "\t"
					+ produto.getNome() + "\t" + produto.getDescricao() + "\t" + produto.getPreco() + "\t"
					+ produto.getQuantEstoque());
		} else {
			System.out.println("Produto nao foi identificado no sistema!!(Faca o cadastro primeiro)");
		}
	}

	public void listar() {
		Produto[] produtos = sis.listar();
		if (produtos != null) {
			System.out.println("Codigo\tNome\tPreco\tMarca\tQuantidade em Estoque");
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i] != null && produtos[i].getExcluido() != 1) {
					System.out.println(produtos[i].getCodigo() + "\t" + produtos[i].getNome() + "\t"
							+ produtos[i].getPreco() + "\t" + produtos[i].getDescricao() + "\t" + produtos[i].getQuantEstoque());
				}
			}
		} else {
			System.out.println("Impossivel listar todos!");
		}
	}

	public void listarNome() {
		Produto[] produtos = sis.listarNome();
		if (produtos != null) {
			System.out.println("Codigo\tNome\tPreco\tQuantidade em Estoque");
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i] != null && produtos[i].getExcluido() != 1) {
					System.out.println(produtos[i].getCodigo() + "\t" + produtos[i].getNome() + "\t"
							+ produtos[i].getPreco() + "\t" + produtos[i].getQuantEstoque());
				}
			}
		} else {
			System.out.println("Impossivel listar todos!");
		}
	}
}
