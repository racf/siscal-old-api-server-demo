package gob.mx.issste.siscal.old.api.server.service;

import java.util.List;

import gob.mx.issste.siscal.old.api.server.entity.CatOficio;

public interface CatOficioService {
	public List<CatOficio> findAll();
	public List<CatOficio> obtenerRegistros();
	public CatOficio findById(String id);
	public Integer crear(String descripcion);
	public void crear2(String descripcion);
}
