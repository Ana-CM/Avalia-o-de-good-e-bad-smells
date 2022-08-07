package dcc193.trabalho.avaliacao;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String uriRepositorio;
    private String uriPerfil;

    public Projeto() {
    }

    public Projeto( Long id, String nome, String uriRepositorio, String uriPerfil ) {
        this.id = id;
        this.nome = nome;
        this.uriRepositorio = uriRepositorio;
        this.uriPerfil = uriPerfil;
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

    public String getUriRepositorio() {
        return uriRepositorio;
    }

    public void setUriRepositorio(String uriRepositorio) {
        this.uriRepositorio = uriRepositorio;
    }

    public String getUriPerfil() {
        return uriPerfil;
    }

    public void setUriPerfil(String uriPerfil) {
        this.uriPerfil = uriPerfil;
    }
}
