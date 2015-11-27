
import static java.lang.System.out;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Crud {

    public void inserir(Produto prod) {
        //verifica se existe a categoria 
        boolean existe = categoriaExiste(prod.getCategoria());

        //caso exista, adiciona um novo elemento
        if (existe) {
            Estoque.getInstance().get(prod.getCategoria()).offer(prod);
            return;
        }
        //senão instancia uma nova lista e adiciona o elemento 
        Queue<Produto> list = new ArrayDeque<>();
        list.offer(prod);
        Estoque.getInstance().put(prod.getCategoria(), list);
    }

    public void delete(Categoria categoria, int codigo) {
        boolean existe = categoriaExiste(categoria);

        if (!existe) {
            return;
        }

        Queue<Produto> produtos = get(categoria);
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtos.remove(produto);
            }
        }
    }

    public Queue<Produto> get(Categoria categoria) {
        return Estoque.getInstance().getOrDefault(categoria, null);
    }

    public Produto get(Categoria categoria, int codigo) {
        boolean existe = categoriaExiste(categoria);

        if (existe) {
            Queue<Produto> produtos = Estoque.getInstance().get(categoria);
            for (Produto p : produtos) {
                if (p.getCodigo() == codigo) {
                    return p;
                }
            }
        }

        return null;
    }

    //verifica se existe a categoria 
    private boolean categoriaExiste(Categoria categoria) {
        return Estoque.getInstance().containsKey(categoria);
    }

    //imprime todos os dados de todas as categorias
    public void imprimir() {
        for (Queue<Produto> produtos : Estoque.getInstance().values()) {
            for (Produto p : produtos) {
                out.println(p.getCategoria());
                out.println(p.toString());
            }
        }
    }
}
