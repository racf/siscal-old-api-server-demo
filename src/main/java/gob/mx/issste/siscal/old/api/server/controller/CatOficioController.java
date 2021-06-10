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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gob.mx.issste.siscal.old.api.server.entity.CatOficio;
import gob.mx.issste.siscal.old.api.server.repository.CatOficioRepository;
import gob.mx.issste.siscal.old.api.server.service.CatOficioService;
import gob.mx.issste.siscal.old.api.server.utils.Util;

@RestController
public class CatOficioController {
	private static Logger log = LoggerFactory.getLogger(CatOficioController.class);
	//private static final String CAT_OFICIO = CatOficio.class.getSimpleName();
	@Autowired
	CatOficioService catOficioService;
	
	@Autowired
	CatOficioRepository catOficioRepository;
	
	@GetMapping("/oficios")
	public List<CatOficio> obtenerOficios(){
		//return (List<CatOficio>) catOficioRepository.findAll();
		return catOficioService.obtenerRegistros();
	}
	
	@PostMapping(value = "/oficio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CatOficio> crear(@RequestBody CatOficio oficio) throws URISyntaxException{
		ResponseEntity<CatOficio> responseEntity = null;
		if(!Util.isEmpty(oficio)) {
			//catOficioRepository.save(oficio);
			log.info("CREAR {}", oficio.toString());
			catOficioRepository.crear2(oficio.getDescripcion());
			//catOficioRepository.actualizar(oficio.getDescripcion());
			//catOficioService.crear2(oficio.getDescripcion());
			/*Integer id = catOficioService.crear(oficio.getDescripcion());
			if(id > 0) {
				oficio.setIdCatOficio(id);
				responseEntity = ResponseEntity.created(new URI("/oficio/"+id))
						//.headers(HeaderUtil.entityCreationAlert(PERSON, String.valueOf(personReturn.getPersonId())))
						.body(oficio);
			} else {
				responseEntity = ResponseEntity.badRequest()
						//.headers(HeaderUtil.createFailureAlert(CAT_OFICIO, MessageConstants.ERROR_CREATION))
						.body(null);
			}*/
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
			catOficioRepository.actualizar(oficio.getDescripcion(), oficio.getIdCatOficio());
			//catOficioService.crear2(oficio.getDescripcion());
			/*Integer id = catOficioService.crear(oficio.getDescripcion());
			if(id > 0) {
				oficio.setIdCatOficio(id);
				responseEntity = ResponseEntity.created(new URI("/oficio/"+id))
						//.headers(HeaderUtil.entityCreationAlert(PERSON, String.valueOf(personReturn.getPersonId())))
						.body(oficio);
			} else {
				responseEntity = ResponseEntity.badRequest()
						//.headers(HeaderUtil.createFailureAlert(CAT_OFICIO, MessageConstants.ERROR_CREATION))
						.body(null);
			}*/
		} else {
			responseEntity = ResponseEntity.badRequest()
					//.headers(HeaderUtil.createFailureAlert(CAT_OFICIO, MessageConstants.ERROR_CREATION))
					.body(null);
		}
		return responseEntity;
	}
}
