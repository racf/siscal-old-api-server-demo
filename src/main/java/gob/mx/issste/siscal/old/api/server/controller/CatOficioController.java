package gob.mx.issste.siscal.old.api.server.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gob.mx.issste.siscal.old.api.server.entity.CatOficio;
import gob.mx.issste.siscal.old.api.server.service.CatOficioService;
import gob.mx.issste.siscal.old.api.server.utils.Util;

@RestController
public class CatOficioController {
	private static Logger log = LoggerFactory.getLogger(CatOficioController.class);
	//private static final String CAT_OFICIO = CatOficio.class.getSimpleName();
	@Autowired
	CatOficioService catOficioService;
	
	@GetMapping("/oficio")
	public List<CatOficio> obtenerOficios(){
		//return (List<CatOficio>) catOficioRepository.findAll();
		return catOficioService.obtenerRegistros();
	}
	
	@GetMapping("/oficio/{id}")
	public CatOficio obtenerOficioPorId(@PathVariable("id") Integer id) {
		log.info("IDENTIFICADOR {}", id);
		return catOficioService.obtenerRegistroPorId(id);
	}
	
	@PostMapping(value = "/oficio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CatOficio> crear(@RequestBody CatOficio oficio) throws URISyntaxException{
		ResponseEntity<CatOficio> responseEntity = null;
		if(!Util.isEmpty(oficio)) {
			log.info("CREAR {}", oficio.toString());
			Integer id = catOficioService.crear(oficio.getDescripcion());
			if(id > 0) {
				responseEntity = ResponseEntity.created(new URI("/oficio/"))
						//.headers(HeaderUtil.entityCreationAlert(PERSON, String.valueOf(personReturn.getPersonId())))
						.body(null);
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
	
	@PutMapping(value = "/oficio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CatOficio> actualizar(@RequestBody CatOficio oficio) throws URISyntaxException{
		ResponseEntity<CatOficio> responseEntity = null;
		if(!Util.isEmpty(oficio)) {
			log.info("ACTUALIZAR {}", oficio.toString());
			Integer id = catOficioService.actualizar(oficio.getIdCatOficio(), oficio.getDescripcion());
			if(id > 0) {
				responseEntity = ResponseEntity.ok()
						//.headers(HeaderUtil.entityCreationAlert(PERSON, String.valueOf(personReturn.getPersonId())))
						.body(oficio);
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
}
