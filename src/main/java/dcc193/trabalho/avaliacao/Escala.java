package dcc193.trabalho.avaliacao;

public class Escala {

    private String nome;
    private String uriDescricao;
    private Boolean smell; // true = Good smell, false = Bad smell

    public Escala() {
    }

    public Escala(String nome, String uriDescricao, Boolean smell) {
        this.nome = nome;
        this.uriDescricao = uriDescricao;
        this.smell = smell;
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

    public Boolean getSmell() {
        return smell;
    }

    public void setSmell(Boolean smell) {
        this.smell = smell;
    }
}