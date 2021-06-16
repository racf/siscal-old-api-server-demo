package gob.mx.issste.siscal.old.api.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.mx.issste.siscal.old.api.server.entity.CatOficio;

@Repository
public interface CatOficioRepository extends JpaRepository<CatOficio, Integer>{
	@Transactional(readOnly = true)
	@Query("SELECT oficio FROM CatOficio oficio")
	List<CatOficio> obtenerRegistros();
	
	@Transactional(readOnly = true)
	@Query("SELECT oficio FROM CatOficio oficio WHERE oficio.idCatOficio=:idCatOficio")
	CatOficio obtenerRegistroPorId(@Param("idCatOficio") Integer idCatOficio);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO cat_oficio"
			+ "(descripcion) "
			+ "VALUES(?1)", nativeQuery = true)
	Integer crear(String descripcio);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE cat_oficio SET descripcion=?1 WHERE id_cat_oficio=?2", nativeQuery = true)
	Integer actualizar(String descripcion, Integer idCatOficio);
}
