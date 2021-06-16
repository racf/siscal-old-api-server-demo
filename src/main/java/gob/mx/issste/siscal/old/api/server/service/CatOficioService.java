package gob.mx.issste.siscal.old.api.server.service;

import java.util.List;

import gob.mx.issste.siscal.old.api.server.entity.CatOficio;

public interface CatOficioService {
	public List<CatOficio> obtenerRegistros();
	public CatOficio obtenerRegistroPorId(Integer id);
	public Integer crear(String descripcion);
	public Integer actualizar(Integer id, String descripcion);
}
