package loja.ui;

import java.util.Scanner;

public class UiPrincipal {
	private Scanner scn;

	private UiVenda uiVenda;

	private UiProduto uiProduto;

	public UiPrincipal() {
		scn = new Scanner(System.in);
		uiVenda = new UiVenda();
		uiProduto = new UiProduto();
	}

	public void InterfaceInicial() {
		int x = 0;
		do {
			System.out.println("----------Lojinha DaniLet----------\n1- Administrador\n2- Atendente\n0- Sair");
			int o = scn.nextInt();
			switch (o) {
			case 1:
				int y = 0;
				do {
					System.out.println(
							"1- Inserir Produtos\n2- Excluir Produtos\n3- Alterar Dados de um Produto\n4- Exibir todos os produtos\n5- Exibir todas as vendas realizadas\n6- Exibir vendas em um dia\n7- Exibir vendas atraves do codigo\n0- Sair");
					int i = scn.nextInt();
					switch (i) {
					case 1:
						uiProduto.inserir();
						break;
					case 2:
						uiProduto.excluir();
						break;
					case 3:
						uiProduto.alterar();
						break;
					case 4:
						uiProduto.listar();
						break;
					case 5:
						uiVenda.listar();
						break;
					case 6:
						uiVenda.listarData();
						break;
					case 7:
						uiVenda.listarCodigo();
					case 0:
						y = 1;
						break;
					}
				} while (y == 0);
				break;
			case 2:
				uiVenda.Menu();
				break;
			case 0:
				x = 1;
				break;
			}
		} while (x == 0);
	}

}
