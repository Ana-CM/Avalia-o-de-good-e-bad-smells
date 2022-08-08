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

@RequestMapping("/projeto/{id}/observacoes")
public class ProjetoObservacoesController {
    
    @Autowired
    private ProjetoObservacoesRepository projetoObservacoesRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ObservacaoRepository observacaoRepository;

    @Autowired
    private EscalaRepository escalaRepository;

    @GetMapping("/nova.html")
    public ModelAndView criar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        Projeto projeto = projetoRepository.findById(id).get();
        List<Observacao> observacoes = observacaoRepository.findAll();

        mv.setViewName("novo-projeto-observacoes-form");
        mv.addObject("projeto", projeto);
        mv.addObject("observacoes", observacoes);
        mv.addObject("projetoObservacoes", new ProjetoObservacoes());
        return mv;
    }

    @PostMapping("/nova.html")
    public ModelAndView criar(ProjetoObservacoes projetoObservacoes) {
        ModelAndView mv = new ModelAndView();
        projetoObservacoesRepository.save(projetoObservacoes);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping("/listar.html")
    public ModelAndView listar(@PathVariable Long id) {
        List<ProjetoObservacoes> projetoObservacoes = projetoObservacoesRepository.findAll();
        Projeto projeto = projetoRepository.findById(id).get();
        List<Observacao> observacoes = observacaoRepository.findAll();
        List<Escala> escalas = escalaRepository.findAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("listar-projeto-observacoes");
        mv.addObject("projeto", projeto);
        mv.addObject("projetoObservacoes", projetoObservacoes);
        mv.addObject("observacoes", observacoes);
        mv.addObject("escalas", escalas);
        return mv;
    }

    @GetMapping("/excluir/{idProjetoObservacoes}")
    public ModelAndView excluir(@PathVariable Long id, @PathVariable Long idProjetoObservacoes) {
        ModelAndView mv = new ModelAndView("redirect:../listar.html");

        Optional<ProjetoObservacoes> projetoObservacoes = projetoObservacoesRepository.findById(idProjetoObservacoes);

        if (projetoObservacoes.isPresent()) {
            projetoObservacoesRepository.delete(projetoObservacoes.get());
        }

        return mv;
    }

    @GetMapping("/razao.html")
    public ModelAndView razao(@PathVariable Long id) {
        List<ProjetoObservacoes> projetoObservacoes = projetoObservacoesRepository.findByIdProjeto(id);
        Projeto projeto = projetoRepository.findById(id).get();
        List<Observacao> observacoes = observacaoRepository.findAll();
        List<Escala> escalas = escalaRepository.findAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("razao-projeto-observacoes");
        mv.addObject("projeto", projeto);
        mv.addObject("projetoObservacoes", projetoObservacoes);
        mv.addObject("observacoes", observacoes);
        mv.addObject("escalas", escalas);;
        return mv;
    }
}
