package dcc193.trabalho.avaliacao;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Observacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String uriDescricao;
    private Escala escala;

    public Observacao() {
    }

    public Observacao(Long id, String nome, String uriDescricao, Escala escala) {
        this.id = id;
        this.nome = nome;
        this.uriDescricao = uriDescricao;
        this.escala = escala;
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

    public Escala getEscala() {
        return escala;
    }

    public void setEscala(Escala escala) {
        this.escala = escala;
    }
}
