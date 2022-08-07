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

@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping("/nova.html")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("novo-projeto-form");
        mv.addObject("projeto", new Projeto());
        return mv;
    }

    @PostMapping("/nova.html")
    public ModelAndView criar(Projeto projeto) {
        ModelAndView mv = new ModelAndView();
        projetoRepository.save(projeto);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping("/listar.html")
    public ModelAndView listar() {
        List<Projeto> projetos = projetoRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("listar-projeto");
        mv.addObject("projetos", projetos);
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit-projeto-form");
        Projeto projeto = projetoRepository.findById(id).get();
        mv.addObject("projeto", projeto);
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, Projeto projeto) {
        ModelAndView mv = new ModelAndView();
        projetoRepository.save(projeto);
        mv.setViewName("redirect:../listar.html");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listar.html");

        Optional<Projeto> projeto = projetoRepository.findById(id);
        if (projeto.isPresent()) {
            Projeto p = projeto.get();
            projetoRepository.delete(p);
            return mv;
        }
        return mv;
    }
}
