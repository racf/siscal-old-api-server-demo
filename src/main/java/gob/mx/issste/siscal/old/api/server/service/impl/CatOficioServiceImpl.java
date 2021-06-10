package gob.mx.issste.siscal.old.api.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.mx.issste.siscal.old.api.server.entity.CatOficio;
import gob.mx.issste.siscal.old.api.server.repository.CatOficioRepository;
import gob.mx.issste.siscal.old.api.server.service.CatOficioService;

@Service
public class CatOficioServiceImpl implements CatOficioService{
	
	@Autowired
	CatOficioRepository catOficioRepository;
	
	@Override
	public List<CatOficio> findAll() {
		return catOficioRepository.findAll();
	}

	@Override
	public List<CatOficio> obtenerRegistros() {
		return catOficioRepository.obtenerRegistros();
	}

	@Override
	public CatOficio findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer crear(String descripcion) {
		return catOficioRepository.crear(descripcion);
	}

	@Override
	public void crear2(String descripcion) {
		catOficioRepository.crear2(descripcion);
	}

}
