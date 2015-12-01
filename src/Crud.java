
import static java.lang.System.out;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Crud {

    public void inserir(Produto prod) {
        //verifica se existe a categoria 
        boolean existe = categoriaExiste(prod.getCategoria());

        //caso exista, adiciona um novo elemento
        if (existe) {
            get(prod.getCategoria()).add(prod);
            ordenarPorVencimento(prod.getCategoria());
            return;
        }
        //senão instancia uma nova lista e adiciona o elemento 
        List<Produto> list = new ArrayList<>();
        list.add(prod);
        Estoque.getInstance().put(prod.getCategoria(), list);
    }

    public void delete(Categoria categoria, int codigo) {
        boolean existe = categoriaExiste(categoria);

        if (!existe) {
            return;
        }

        List<Produto> produtos = get(categoria);
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtos.remove(produto);
            }
        }
    }

    public List<Produto> get(Categoria categoria) {
        return Estoque.getInstance().getOrDefault(categoria, null);
    }

    private void ordenarPorVencimento(Categoria categoria){
        Collections.sort(get(categoria), new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
               return p2.getVencimento().compareTo(p1.getVencimento());
            }
        });
    }

    //verifica se existe a categoria 
    private boolean categoriaExiste(Categoria categoria) {
        return Estoque.getInstance().containsKey(categoria);
    }

    //imprime todos os dados de todas as categorias
    public void imprimir() {
        for (List<Produto> produtos : Estoque.getInstance().values()) {
            for (Produto p : produtos) {
                out.println(p.getCategoria());
                out.println(p.toString());
            }
        }
    }
}
