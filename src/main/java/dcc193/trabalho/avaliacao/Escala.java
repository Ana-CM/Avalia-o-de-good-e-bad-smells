package dcc193.trabalho.avaliacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String uriDescricao;
    private Boolean smell; // true = Good smell, false = Bad smell

    public Escala() {
    }

    public Escala(Long id, String nome, String uriDescricao, Boolean smell) {
        this.id = id;
        this.nome = nome;
        this.uriDescricao = uriDescricao;
        this.smell = smell;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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