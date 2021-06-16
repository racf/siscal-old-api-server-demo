package gob.mx.issste.siscal.old.api.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gob.mx.issste.siscal.old.api.server.utils.DBConstants;

@Entity
@Table(name = "cat_oficio", schema = DBConstants.SCHEMA_SIAPRIT)
public class CatOficio implements Serializable{

	private static final long serialVersionUID = 7709900770520052668L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cat_oficio")
	private Integer idCatOficio;
	private String descripcion;
	
	public CatOficio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CatOficio(Integer idCatOficio, String descripcion) {
		super();
		this.idCatOficio = idCatOficio;
		this.descripcion = descripcion;
	}

	public Integer getIdCatOficio() {
		return idCatOficio;
	}
	public void setIdCatOficio(Integer idCatOficio) {
		this.idCatOficio = idCatOficio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "CatOficio [idCatOficio=" + idCatOficio + ", descripcion=" + descripcion + "]";
	}
	
}
