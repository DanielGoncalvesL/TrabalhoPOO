package loja.dados;

import java.util.ArrayList;
import java.util.List;
import loja.negocio.Item;
import loja.negocio.Produto;
import loja.negocio.Venda;

public class RepoProdutoArray {

    private final List<Produto> produtos = new ArrayList<>();
    private int codigo = 1;

    public boolean inserir(Produto produto) {
        if (produto != null) {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equals(produto.getNome())) {
                    return false;
                }
            }
            produto.setCodigo(codigo);
            produtos.add(produto);
            codigo++;
            return true;
        }
        return false;
    }

    public boolean excluir(int codigo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo && produtos.get(i).getVendido() != 1) {
                produtos.remove(i);
                return true;
            } else {
                if (produtos.get(i).getCodigo() == codigo && produtos.get(i).getVendido() == 1) {
                    produtos.get(i).setExcluido(1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean alterar(Produto produto, int codigo) {
        if (produto != null) {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getCodigo() == codigo) {
                    produtos.add(produto);
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public Produto buscar(int codigo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                return produtos.get(i);
            }
        }
        return null;
    }

    public List<Produto> listar() {
        if (produtos != null) {
            produtos.forEach((_item) -> {
                for (int i = 0; i < produtos.size() - 1; i++) {
                    if (produtos.get(i + 1) != null
                            && produtos.get(i).getCodigo() > produtos.get(i + 1).getCodigo()) {
                        Produto aux = produtos.get(i);
                        produtos.set(i, produtos.get(i + 1));
                        produtos.set(i + 1, aux);
                    }
                }
            });
            return produtos;
        } else {
            return null;
        }
    }

    public List<Produto> listarNome() {
        produtos.forEach((_item) -> {
            for (int i = 0; i < produtos.size() - 1; i++) {
                if (produtos.get(i).getNome().compareToIgnoreCase(produtos.get(i + 1).getNome()) > 0) {
                    Produto aux = produtos.get(i);
                    produtos.set(i, produtos.get(i + 1));
                    produtos.set(i + 1, aux);
                }
            }
        });
        return produtos;
    }

    public Produto buscarNome(String nome) {
        if (nome != null) {
            for (Produto produto : produtos) {
                if (produto != null && produto.getNome().equals(nome)) {
                    return produto;
                }
            }
        }
        return null;
    }

    public boolean abaterEstoque(Venda abaterEstoque) {
        if (abaterEstoque != null && produtos != null) {
            int abateu = 0;
            for (Item itensVendido : abaterEstoque.getItensVendidos()) {
                for (Produto produto : produtos) {
                    if (itensVendido != null && produto != null && itensVendido.getProduto().getNome().equals(produto.getNome()) && itensVendido.getQuantidade() <= produto.getQuantEstoque()) {
                        produto.setQuantEstoque(produto.getQuantEstoque() - itensVendido.getQuantidade());
                        abateu = 1;
                    }
                }
            }
            if (abateu == 1) {
                return true;
            }
        }
        return false;
    }

}
