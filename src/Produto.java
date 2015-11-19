import java.util.Calendar;
import java.util.Date;

public class Produto {
    
    private int Quantidade;
    private String Nome;
    private double Preco;
    private int Codigo;
    private Categoria catagoria;
    private Calendar vencimento;
    
    
    public Produto(int Quantidade, String Nome, double Preco, int Codigo, Categoria catagoria, Calendar vencimento) {
        this.Quantidade = Quantidade;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Codigo = Codigo;
        this.catagoria = catagoria;
        this.vencimento = vencimento;
    }
    
    
    

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public Categoria getCatagoria() {
        return catagoria;
    }

    public void setCatagoria(Categoria catagoria) {
        this.catagoria = catagoria;
    }
    
    
    
    
}
