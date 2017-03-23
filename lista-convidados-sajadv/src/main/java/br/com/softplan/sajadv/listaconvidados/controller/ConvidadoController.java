package br.com.softplan.sajadv.listaconvidados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.softplan.sajadv.listaconvidados.model.Convidado;
import br.com.softplan.sajadv.listaconvidados.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = service.obterTodosConvidados();
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {
		Convidado novoConvidado = new Convidado(nome, email, telefone);
		service.salvarConvidados(novoConvidado);
		Iterable<Convidado> convidados = service.obterTodosConvidados();
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}

}

