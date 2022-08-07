package dcc193.trabalho.avaliacao;

import java.util.List;

public class Projeto {

    private String nome;
    private String uriRepositorio;
    private String uriPerfil;
    private List <Observacao> observacoes;

    public Projeto() {
    }

    public Projeto(String nome, String uriRepositorio, String uriPerfil ) {
        this.nome = nome;
        this.uriRepositorio = uriRepositorio;
        this.uriPerfil = uriPerfil;
        this.observacoes = null;
    }

    public Projeto(String nome, String uriRepositorio, String uriPerfil, List <Observacao> observacoes) {
        this.nome = nome;
        this.uriRepositorio = uriRepositorio;
        this.uriPerfil = uriPerfil;
        this.observacoes = observacoes;
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

    public List <Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List <Observacao> observacoes) {
        this.observacoes = observacoes;
    }
}
