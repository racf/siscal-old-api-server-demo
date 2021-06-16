package gob.mx.issste.siscal.old.api.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.mx.issste.siscal.old.api.server.entity.CatTitulo;
import gob.mx.issste.siscal.old.api.server.repository.CatTituloRepository;
import gob.mx.issste.siscal.old.api.server.service.CatTituloService;

@Service
public class CatTituloServiceImpl implements CatTituloService{
	
	@Autowired
	CatTituloRepository catTituloRepository;

	@Override
	public List<CatTitulo> obtenerRegistros() {
		return catTituloRepository.findAll();
	}

	@Override
	public CatTitulo obtenerRegistroPorId(Integer id) {
		return catTituloRepository.findById(id).orElse(null);
	}

	@Override
	public CatTitulo crear(CatTitulo catTitulo) {
		return catTituloRepository.save(catTitulo);
	}

	@Override
	public CatTitulo actualizar(CatTitulo catTitulo) {
		return catTituloRepository.save(catTitulo);
	}

}
