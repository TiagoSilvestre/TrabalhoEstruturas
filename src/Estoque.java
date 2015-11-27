
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Estoque {
    
    private static Map<Categoria, Queue<Produto>> estoque;
     
    public static Map<Categoria, Queue<Produto>> getInstance(){
        if(estoque == null){
            estoque = new HashMap<Categoria, Queue<Produto>>();
        } 
        
        return estoque;
    }    
}
