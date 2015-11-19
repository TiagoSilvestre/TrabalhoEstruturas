
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    
    private static List<Produto> lista;
     
    public static List<Produto> getInstance(){
        if(lista == null) lista = new ArrayList<>();
        
        return lista;
    }    
}
