
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TesteClassificacao {
    public static void main(String args[]) {
        Map<TipoProduto, Queue<Produto>> map = new HashMap<>();
        
        
        Queue<Produto> arroz = map.get(TipoProduto.ARROZ);
        if (arroz == null) {
           arroz = new LinkedList<Produto>();
        }
        
        //arroz.add(new Produto((), null, Preco, Codigo, Categoria.ARROZ, null));
        
        map.put(TipoProduto.ARROZ, arroz);
        
        
    
    }
}
