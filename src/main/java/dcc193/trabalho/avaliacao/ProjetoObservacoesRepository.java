package dcc193.trabalho.avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository

public interface ProjetoObservacoesRepository extends JpaRepository<ProjetoObservacoes, Long> {

    List<ProjetoObservacoes> findByIdProjeto(Long id);
}
