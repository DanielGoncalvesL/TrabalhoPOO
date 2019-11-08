package loja;

import loja.dados.IRepoProduto;
import loja.dados.IRepoVenda;
import loja.dados.RepoProdutoArray;
import loja.dados.RepoVendaArray;
import loja.negocio.Sistema;
import loja.ui.MenuPrincipal;

public class Programa {
	public static void main(String[] args) {
		IRepoProduto repoProduto = new RepoProdutoArray();
		IRepoVenda repoVenda = new RepoVendaArray();
                
		Sistema.getInstance(repoProduto, repoVenda);
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		
                menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setVisible(true);
		
	}

}