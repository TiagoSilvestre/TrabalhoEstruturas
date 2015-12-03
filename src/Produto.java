
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Produto {

    private int codigo;
    private String nome;
    private int quantidade;
    private double preco;
    private Categoria categoria;
    private Calendar vencimento;

    public Produto() {
    }

    public Produto(int codigo, String nome, int quantidade, double preco, Categoria categoria, Calendar vencimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
        this.vencimento = vencimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public String toString() {
        String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(vencimento.getTime());
        return "Produto{ Codigo=" + codigo + ", Quantidade=" + quantidade + ", Nome=" + nome + ", Preco=" + preco + ", Codigo=" + codigo + ", categoria=" + categoria + ", vencimento=" + dataFormatada + '}';
    }
}
