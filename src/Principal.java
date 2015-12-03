
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws InterruptedException, ParseException {
        int operacao;
        Scanner input = new Scanner(System.in);
        Crud cr = new Crud();

        do {
            System.out.println("-----------------------");
            System.out.println("Escolha um operação:\n");
            System.out.println("1 - Inserir");
            System.out.println("2 - Deletar");
            System.out.println("3 - Deletar vencidos");
            System.out.println("4 - Listar todos");
            System.out.println("5 - Listar todos vencidos");
            System.out.println("----------------------\n0 - Sair");

            out.print("Digite um operação: ");
            operacao = input.nextInt();
            out.println();
            
            switch (operacao) {
                case 0:
                    input.close();
                    out.println("\nFinalizando sistema...");
                    Thread.sleep(2000);
                    out.println("Finalizado. :)");
                    break;

                case 1:
                    Produto p = new Produto();

                    System.out.print("Código: ");
                    p.setCodigo(input.nextInt());

                    System.out.print("Descrição: ");
                    p.setNome(input.next());

                    p.setCategoria(escolherCategoria(input));

                    System.out.print("Qauntidade: ");
                    p.setQuantidade(input.nextInt());

                    System.out.print("Preço: ");
                    p.setPreco(input.nextDouble());

                    out.println("Data de validade (dd/MM/yyyy): ");
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(input.next());
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    p.setVencimento(c);

                    cr.inserir(p);
                    break;

                case 2:
                    Categoria categoria = escolherCategoria(input);
                    
                    System.out.print("Digite o código do produto: ");
                    int codigo = input.nextInt();
                    cr.deletar(categoria, codigo);
                    break;

                case 3:
                    cr.deletarPorVencimento();
                    break;

                case 4:
                    cr.imprimirTodosProdutos();
                    break;

                case 5:
                    cr.imprimirProdutosVencidos();
                    break;

            }

        } while (operacao != 0);

//        Calendar c1 = Calendar.getInstance();
//        
//        c1.set(2015, 10, 6);
//        Produto arroz1 = new Produto(1, "Fumaçense", 545, 10.25, Categoria.ARROZ, c1);
//        cr.inserir(arroz1);
//
//        c1 = Calendar.getInstance();
//        c1.set(2015, 11, 6);
//        Produto arroz2 = new Produto(2, "jaozinho", 545, 10.25, Categoria.ARROZ, c1);
//        cr.inserir(arroz2);
//        
//        c1 = Calendar.getInstance();
//        c1.set(2015, 11, 25);
//        cr.inserir(new Produto(3, "galaxia dourada", 545, 10.25, Categoria.CHOCOLATE, c1));
//
//        c1 = Calendar.getInstance();
//        c1.set(2015, 11, 22);
//        cr.inserir(new Produto(3, "batata", 545, 10.25, Categoria.CHOCOLATE, c1));
//
//        c1 = Calendar.getInstance();
//        c1.set(2015, 11, 16);
//        cr.inserir(new Produto(3, "laktia", 545, 10.25, Categoria.CHOCOLATE, c1));
//
//        c1 = Calendar.getInstance();
//        c1.set(2015, 11, 10);
//        cr.inserir(new Produto(3, "chuvarada", 545, 10.25, Categoria.CHOCOLATE, c1));
//        
//        c1 = Calendar.getInstance();
//        c1.set(2015, 10, 1);
//        cr.inserir(new Produto(3, "chuvarada efewff", 545, 10.25, Categoria.CHOCOLATE, c1));
//
//        cr.imprimirProdutos();
//        cr.deletarPorVencimento(Categoria.CHOCOLATE);
    }

    private static Categoria escolherCategoria(Scanner input) {
        System.out.println("Escolha uma categoria: ");
        System.out.println("1 - Arroz | 2 - Feijão | 3 - Chocolate");
        int categoria = input.nextInt();
        switch (categoria) {
            case 1:
                return Categoria.ARROZ;
            case 2:
                return Categoria.FEIJAO;
            case 3:
                return Categoria.CHOCOLATE;
            default:
                return Categoria.NAO_SEI;
        }
    }
}
