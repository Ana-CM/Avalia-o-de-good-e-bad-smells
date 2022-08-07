package dcc193.trabalho.avaliacao;

public class Observacao {
    
    private String nome;
    private String uriDescricao;
    private Escala escala;

    public Observacao() {
    }

    public Observacao(String nome, String uriDescricao, Escala escala) {
        this.nome = nome;
        this.uriDescricao = uriDescricao;
        this.escala = escala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUriDescricao() {
        return uriDescricao;
    }

    public void setUriDescricao(String uriDescricao) {
        this.uriDescricao = uriDescricao;
    }

    public Escala getEscala() {
        return escala;
    }

    public void setEscala(Escala escala) {
        this.escala = escala;
    }
}
