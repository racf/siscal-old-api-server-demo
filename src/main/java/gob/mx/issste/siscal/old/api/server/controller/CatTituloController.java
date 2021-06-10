package gob.mx.issste.siscal.old.api.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gob.mx.issste.siscal.old.api.server.entity.CatTitulo;
import gob.mx.issste.siscal.old.api.server.repository.CatTituloRepository;

@RestController
public class CatTituloController {
	@Autowired
	CatTituloRepository catTituloRepository;
	
	@GetMapping("/titulo")
	public List<CatTitulo> titulos(){
		return catTituloRepository.obtenerRegistros();
	}
	
	@PostMapping("/titulo")
	public void crear(@RequestBody CatTitulo titulo) {
		catTituloRepository.crear(titulo.getDescTitulo(), titulo.getNombreTitulo());
	}
}
