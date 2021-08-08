package com.adjafsaobraz.ebdapp.classes.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjafsaobraz.ebdapp.classes.entidades.Sala;
import com.adjafsaobraz.ebdapp.classes.repositorios.SalaRepositorio;

@Service
public class SalaServices {

	@Autowired
	private SalaRepositorio repositorio;

	public List<Sala> buscarTodos() {
		List<Sala> sala = repositorio.listarTodos();
		return sala;
	}

	public Sala procurarPorId(Integer id) {
		if (this.salaExists(id)) {
			return repositorio.findById(id).get();
		}
		return null;
	}

	public Sala inserirAluno(Sala aula) {
		return repositorio.save(aula);
	}
	
	public Sala modificarAluno(Sala aula) {
		return repositorio.save(aula);
	}

	public void DeletarPorId(Integer id) {
		if (this.salaExists(id)) {
			repositorio.deleteById(id);
		}
	}

	private Boolean salaExists(Integer id) {
		Optional<Sala> aluno = repositorio.findById(id);
		if (aluno.isPresent()) {
			return true;
		}
		return false;
	}
}
