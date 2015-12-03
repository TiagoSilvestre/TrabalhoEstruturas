
import static java.lang.System.out;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Crud {

    public void inserir(Produto prod) {
        boolean existe = categoriaExiste(prod.getCategoria());

        if (!existe) {
            Estoque.getInstance().put(prod.getCategoria(), new ArrayList<>());
        }

        get(prod.getCategoria()).add(prod);

        if (get(prod.getCategoria()).size() > 1) {
            ordenarPorVencimento(prod.getCategoria());
        }

        out.println("Produto inserido com sucesso! :D");
    }

    public void deletarPorVencimento() {
        Set<Categoria> categorias = Estoque.getInstance().keySet();

        if (categorias.isEmpty()) {
            System.out.println("Não há produtos. :/\n");
            return;
        }

        for (Categoria categoria : categorias) {
            List<Produto> produtosVencidos = getProdutosVencidos(categoria),
                    produtos = get(categoria);

            boolean deletados = produtos.removeAll(produtosVencidos);
            if (deletados) {
                out.println("Categoria: " + categoria);
                out.println("Produtos Vencidos Deletados: ");
                for (Produto produtoVencido : produtosVencidos) {
                    System.out.println(produtoVencido.toString());
                }
                continue;
            }

            System.out.println("Não há produto(s) vencido(s) na categoria: " + categoria);
        }

    }

    public void deletar(Categoria categoria, int codigo) {
        List<Produto> produtos = get(categoria);
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtos.remove(produto);
                System.out.println("Produto " + produto.getNome() + " eliminado com sucesso! :D");
                return;
            }
        }
    }

    public void imprimirTodosProdutos() {
        Collection<List<Produto>> values = Estoque.getInstance().values();

        if (values.isEmpty()) {
            out.println("Não há produtos. :|\n");
        }

        for (List<Produto> produtos : values) {
            for (Produto p : produtos) {
                out.println(p.getCategoria());
                out.println(p.toString());
                out.println();
            }
        }
    }

    public void imprimirProdutosVencidos() {
        Set<Categoria> categorias = Estoque.getInstance().keySet();

        if (categorias.isEmpty()) {
            System.out.println("Não há produtos. :/\n");
            return;
        }

        for (Categoria categoria : categorias) {
            out.println("Produtos vencidos:");
            out.println("Categoria: " + categoria);

            List<Produto> vencidos = getProdutosVencidos(categoria);

            if (vencidos.isEmpty()) {
                System.out.println("Não há produtos vencidos na categoria: " + categoria + "\n");
                continue;
            }

            for (Produto vencido : vencidos) {
                out.println(vencido.toString());
            }

        }

    }

    private List<Produto> get(Categoria categoria) {
        return Estoque.getInstance().getOrDefault(categoria, null);
    }

    private void ordenarPorVencimento(Categoria categoria) {
        Collections.sort(get(categoria), new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return p1.getVencimento().compareTo(p2.getVencimento());
            }
        });
    }

    private List<Produto> getProdutosVencidos(Categoria c) {
        List<Produto> produtosVencidos = new ArrayList<>();

        for (Produto p : get(c)) {
            if (p.getVencimento().compareTo(Calendar.getInstance()) < 0) {
                produtosVencidos.add(p);
                continue;
            }

            break;
        }

        return produtosVencidos;
    }

    private boolean categoriaExiste(Categoria categoria) {
        return Estoque.getInstance().containsKey(categoria);
    }

}
