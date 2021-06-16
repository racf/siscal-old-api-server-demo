package gob.mx.issste.siscal.old.api.server.service;

import java.util.List;

import gob.mx.issste.siscal.old.api.server.entity.CatTitulo;

public interface CatTituloService {
	public List<CatTitulo> obtenerRegistros();
	public CatTitulo obtenerRegistroPorId(Integer id);
	public CatTitulo crear(CatTitulo catTitulo);
	public CatTitulo actualizar(CatTitulo catTitulo);
}
