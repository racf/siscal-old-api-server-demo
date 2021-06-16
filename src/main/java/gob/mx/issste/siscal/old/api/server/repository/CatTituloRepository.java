package gob.mx.issste.siscal.old.api.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.mx.issste.siscal.old.api.server.entity.CatTitulo;

@Repository
public interface CatTituloRepository extends JpaRepository<CatTitulo, Integer>{
		
}
