package gob.mx.issste.siscal.old.api.server.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gob.mx.issste.siscal.old.api.server.entity.CatTitulo;
import gob.mx.issste.siscal.old.api.server.service.CatTituloService;
import gob.mx.issste.siscal.old.api.server.utils.Util;

@RestController
public class CatTituloController {
	
	@Autowired
	CatTituloService catTituloService;
	
	@GetMapping("/titulo")
	public List<CatTitulo> titulos(){
		return catTituloService.obtenerRegistros();
	}
	
	@GetMapping("/titulo/{id}")
	public CatTitulo titulo(@PathVariable(value = "id") Integer id) {
		return catTituloService.obtenerRegistroPorId(id);
	}
	
	@PostMapping(value="/titulo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CatTitulo> crear(@RequestBody CatTitulo catTitulo) throws URISyntaxException {
		ResponseEntity<CatTitulo> responseEntity = null;
		if(!Util.isEmpty(catTitulo)) {
			CatTitulo titulo = catTituloService.crear(catTitulo);
			if(!Util.isEmpty(titulo)) {
				responseEntity = ResponseEntity.created(new URI("/titulo/"+titulo.getIdTitulo()))
						//.headers(HeaderUtil.entityCreationAlert(PERSON, String.valueOf(personReturn.getPersonId())))
						.body(titulo);
			} else {
				responseEntity = ResponseEntity.badRequest()
						//.headers(HeaderUtil.createFailureAlert(CAT_OFICIO, MessageConstants.ERROR_CREATION))
						.body(null);
			}
		} else {
			responseEntity = ResponseEntity.badRequest()
					//.headers(HeaderUtil.createFailureAlert(CAT_OFICIO, MessageConstants.ERROR_CREATION))
					.body(null);
		}
		
		return responseEntity;
	}
	
	@PutMapping(value = "/titulo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CatTitulo> actualizar(@RequestBody CatTitulo catTitulo) throws URISyntaxException {
		ResponseEntity<CatTitulo> responseEntity = null;
		if (!Util.isEmpty(catTitulo)) {
			CatTitulo titulo = catTituloService.actualizar(catTitulo);
			if (!Util.isEmpty(titulo)) {
				responseEntity = ResponseEntity.ok()
						// .headers(HeaderUtil.entityCreationAlert(PERSON,
						// String.valueOf(personReturn.getPersonId())))
						.body(catTitulo);
			} else {
				responseEntity = ResponseEntity.badRequest()
						// .headers(HeaderUtil.createFailureAlert(CAT_OFICIO,
						// MessageConstants.ERROR_CREATION))
						.body(null);
			}
		} else {
			responseEntity = ResponseEntity.badRequest()
					// .headers(HeaderUtil.createFailureAlert(CAT_OFICIO,
					// MessageConstants.ERROR_CREATION))
					.body(null);
		}
		return responseEntity;

	}
}
