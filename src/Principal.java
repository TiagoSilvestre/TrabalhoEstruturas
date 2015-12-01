
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Queue;

public class Principal {

    public static void main(String[] args) {

        Crud cr = new Crud();
        Calendar c1 = Calendar.getInstance();
        
        c1.set(2015, 10, 6);
        Produto arroz1 = new Produto(1, "Fumaçense", 545, 10.25, Categoria.ARROZ, c1);
        cr.inserir(arroz1);

        c1 = Calendar.getInstance();
        c1.set(2015, 11, 6);
        Produto arroz2 = new Produto(2, "neguinho do trilho", 545, 10.25, Categoria.ARROZ, c1);
        cr.inserir(arroz2);
        
        c1 = Calendar.getInstance();
        c1.set(2015, 11, 25);
        cr.inserir(new Produto(3, "galaxia negra", 545, 10.25, Categoria.CHOCOLATE, c1));

        c1 = Calendar.getInstance();
        c1.set(2015, 11, 22);
        cr.inserir(new Produto(3, "galaxia negra", 545, 10.25, Categoria.CHOCOLATE, c1));

        c1 = Calendar.getInstance();
        c1.set(2015, 11, 16);
        cr.inserir(new Produto(3, "galaxia negra", 545, 10.25, Categoria.CHOCOLATE, c1));

        c1 = Calendar.getInstance();
        c1.set(2015, 11, 10);
        cr.inserir(new Produto(3, "galaxia negra", 545, 10.25, Categoria.CHOCOLATE, c1));

        cr.imprimir();
    }
}
