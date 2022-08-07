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

@RequestMapping("/escala")
public class EscalaController {

    @Autowired
    private EscalaRepository escalaRepository;

    @GetMapping("/nova.html")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("nova-escala-form");
        mv.addObject("escala", new Escala());
        return mv;
    }

    @PostMapping("/nova.html")
    public ModelAndView criar(Escala escala) {
        ModelAndView mv = new ModelAndView();
        escalaRepository.save(escala);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping("/listar.html")
    public ModelAndView listar() {
        List<Escala> escalas = escalaRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("listar-escala");
        mv.addObject("escalas", escalas);
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit-escala-form");
        Escala escala = escalaRepository.findById(id).get();
        mv.addObject("escala", escala);
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, Escala escala) {
        ModelAndView mv = new ModelAndView();
        escalaRepository.save(escala);
        mv.setViewName("redirect:../listar.html");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listar.html");

        Optional<Escala> escala = escalaRepository.findById(id);
        if (escala.isPresent()) {
            Escala e = escala.get();
            escalaRepository.delete(e);
            return mv;
        }
        return mv;
    }
}
