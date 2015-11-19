
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Principal {

    
    public static void main(String[] args){
    
        Calendar c = Calendar.getInstance();
        
        c.set(2015, 12, 6);
        Produto arroz = new Produto(3, "Fumaçense", 10.25, 545, Categoria.ARROZ, c);
          
        
        Crud cr = new Crud();
        cr.insert(arroz);
        
        Produto p1 = cr.searchById(545);
        p1.setNome("fumaca");
        
        cr.update(p1);
        
        for(Produto p: cr.list())
            out.print("Codigo: "+ p.getCodigo() + "Nome: "+ p.getNome());
        
    /*    
        Calendar c = Calendar.getInstance();
        
        c.set(2015, 12, 6);
        Produto arroz = new Produto(3, "Fumaçense", 10.25, 54455, Categoria.ARROZ, c);
        
        Calendar d = Calendar.getInstance();
        
        d.set(2015, 12, 12);
        Produto feijao = new Produto(2, "Negro", 5.50, 14446, Categoria.FEIJAO, d);
        
        Calendar e = Calendar.getInstance();
        
        e.set(2015, 12, 20);
        Produto Chocolate = new Produto(5, "Biz", 3.90, 12254, Categoria.CHOCOLATE, e);
      */
        /************LISTA****************/
        /*
        String string;
        int inteiro;
        double pontoflutuante = 0;
        
        
        List<Produto> lista = new ArrayList();
        lista.add(arroz);
        lista.add(Chocolate);
        
        
        for(Produto ref:lista)
        {
            System.out.println(ref.getPreco());
        }
        */
        
     
        
        
        
        
        }
}
