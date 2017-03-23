package br.com.softplan.sajadv.listaconvidados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.sajadv.listaconvidados.model.Convidado;
import br.com.softplan.sajadv.listaconvidados.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;

	public Iterable<Convidado> obterTodosConvidados() {
		return repository.findAll();
	}

	public void salvarConvidados(Convidado convidado) {
		repository.save(convidado);
	}
}
