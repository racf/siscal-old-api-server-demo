package gob.mx.issste.siscal.old.api.server.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.mx.issste.siscal.old.api.server.entity.CatTitulo;

@Repository
public interface CatTituloRepository extends JpaRepository<CatTitulo, Integer>{
	@Query("SELECT titulo FROM CatTitulo titulo")
	List<CatTitulo> obtenerRegistros();
	
	/*@Query(value = "SELECT * FROM cat_titulo", nativeQuery = true)
	List<CatTitulo> obtenerRegistros();*/
	
	/*@Modifying
	@Query(value = "INSERT INTO CatTitulo"
			+ "(descTitulo, nombreTitulo) "
			+ "VALUES(:descTitulo, :nombreTitulo)")
	void crear(@Param("descTitulo") String descTitulo, @Param("nombreTitulo") String nombreTitulo);*/
	
   @Modifying
	@Query(value = "INSERT INTO cat_titulo"
			+ "(desc_titulo, nombre_titulo) "
			+ "VALUES(?1, ?2)", nativeQuery = true)
	void crear(String descTitulo, String nombreTitulo);
		
}
