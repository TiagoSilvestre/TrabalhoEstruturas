
import java.util.List;


public class Crud 
{

    public void insert(Produto prod){
        Estoque.getInstance().add(prod);
    }
    
    public void delete(int id){
        Produto p = searchById(id);
        Estoque.getInstance().remove(p);
    }
    
    
    public void update(Produto produto){
        int index = getIndex(produto.getCodigo());
        Estoque.getInstance().set(index, produto);
    }
    
    public List<Produto> list(){
        return Estoque.getInstance();
    }
    
    public Produto searchById(int id){
        for(Produto p: Estoque.getInstance()){
            if(p.getCodigo() == id) return p;
        }
        
        return null;
    }
    
    public int getIndex(int id){
        for(int i = 0; i < Estoque.getInstance().size(); i++)
            if(Estoque.getInstance().get(i).getCodigo() == id) return i;
        
        return -1;
    }
       
}
