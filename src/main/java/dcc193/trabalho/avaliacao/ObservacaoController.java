package dcc193.trabalho.avaliacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller

@RequestMapping("/observacao")
public class ObservacaoController{

    @Autowired
    private ObservacaoRepository observacaoRepository;

    @Autowired
    private EscalaRepository escalaRepository;

    @GetMapping("/nova.html")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("nova-observacao-form");
        List<Escala> escalas = escalaRepository.findAll();
        mv.addObject("escalas", escalas);
        mv.addObject("observacao", new Observacao());
        
        return mv;
    }

    @PostMapping("/nova.html")
    public ModelAndView criar(Observacao observacao) {
        ModelAndView mv = new ModelAndView();
        observacaoRepository.save(observacao);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping("/listar.html")
    public ModelAndView listar() {
        List<Observacao> observacoes = observacaoRepository.findAll();
        List<Escala> escalas = escalaRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("listar-observacao");
        mv.addObject("observacoes", observacoes);
        mv.addObject("escalas", escalas);
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        List<Escala> escalas = escalaRepository.findAll();
        mv.setViewName("edit-observacao-form");
        Observacao observacao = observacaoRepository.findById(id).get();
        mv.addObject("observacao", observacao);
        mv.addObject("escalas", escalas);
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, Observacao observacao) {
        ModelAndView mv = new ModelAndView();
        observacaoRepository.save(observacao);
        mv.setViewName("redirect:../listar.html");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listar.html");

        Optional<Observacao> observacao = observacaoRepository.findById(id);
        if (observacao.isPresent()) {
            Observacao o = observacao.get();
            observacaoRepository.delete(o);
            return mv;
        }
        return mv;
    }
}
