package dcc193.trabalho.avaliacao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EscalaRepository extends JpaRepository<Escala, Long> {
 
}
