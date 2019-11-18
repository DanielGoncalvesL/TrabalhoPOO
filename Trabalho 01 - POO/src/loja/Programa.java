package loja;

import loja.dados.IRepoMarca;
import loja.dados.IRepoProduto;
import loja.dados.IRepoUsuario;
import loja.dados.IRepoVenda;
import loja.dados.RepoMarca;
import loja.dados.RepoProdutoArray;
import loja.dados.RepoUsuario;
import loja.dados.RepoVendaArray;
import loja.negocio.Sistema;
import loja.ui.TelaLogin;

public class Programa {
	public static void main(String[] args) {
		IRepoProduto repoProduto = new RepoProdutoArray();
		IRepoVenda repoVenda = new RepoVendaArray();
                IRepoMarca repoMarca = new RepoMarca();
                IRepoUsuario repoUsuario = new RepoUsuario();
                
		Sistema.getInstance(repoProduto, repoVenda, repoMarca, repoUsuario);
		
                TelaLogin menuPrincipal = new TelaLogin();
                menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setVisible(true);
		
	}

}