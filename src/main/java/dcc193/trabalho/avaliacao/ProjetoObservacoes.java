package dcc193.trabalho.avaliacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjetoObservacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idProjeto;
    private Long idObservacao;

    public ProjetoObservacoes() {
    }

    public ProjetoObservacoes(Long id, Long idProjeto, Long idObservacao) {
        this.id = id;
        this.idProjeto = idProjeto;
        this.idObservacao = idObservacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Long getIdObservacao() {
        return idObservacao;
    }

    public void setIdObservacao(Long idObservacao) {
        this.idObservacao = idObservacao;
    }
}
