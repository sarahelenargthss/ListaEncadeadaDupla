package listaencadeadadupla;

public class Filme {
    
    private String nome;
    private Filme anterior;
    private Filme proximo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Filme getAnterior() {
        return anterior;
    }

    public void setAnterior(Filme anterior) {
        this.anterior = anterior;
    }

    public Filme getProximo() {
        return proximo;
    }

    public void setProximo(Filme proximo) {
        this.proximo = proximo;
    }
    
}
