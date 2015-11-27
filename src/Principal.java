
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Queue;

public class Principal {

    public static void main(String[] args) {

        Calendar c1 = Calendar.getInstance();
        c1.set(2015, 10, 6);
        Produto arroz1 = new Produto(1, "Fumaçense", 545, 10.25, Categoria.ARROZ, c1);

        Calendar c2 = Calendar.getInstance();
        c2.set(2015, 12, 6);
        Produto arroz2 = new Produto(2, "neguinho do trilho", 545, 10.25, Categoria.ARROZ, c2);

        Calendar c3 = Calendar.getInstance();
        c3.set(2015, 12, 25);
        Produto choc = new Produto(3, "galaxia negra", 545, 10.25, Categoria.CHOCOLATE, c3);

        Crud cr = new Crud();
        cr.inserir(arroz2);
        cr.inserir(arroz1);
        cr.inserir(choc);

        cr.imprimir();
    }
}
