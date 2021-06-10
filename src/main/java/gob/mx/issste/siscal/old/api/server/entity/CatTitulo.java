package gob.mx.issste.siscal.old.api.server.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gob.mx.issste.siscal.old.api.server.utils.DBConstants;

@Entity
@Table(name = "cat_titulo", schema = DBConstants.SCHEMA_INFORMIX)
public class CatTitulo implements Serializable{

	
	private static final long serialVersionUID = -8096081024319325866L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_titulo")
	private Integer idTitulo;
	@Column(name = "desc_titulo")
	private String descTitulo;
	@Column(name = "nombre_titulo")
	private String nombreTitulo;
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	@Column(name = "alias_usuario")
	private String aliasUsuario;
	
	public CatTitulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CatTitulo(Integer idTitulo, String descTitulo, String nombreTitulo, Date fechaRegistro,
			Date fechaModificacion, String aliasUsuario) {
		super();
		this.idTitulo = idTitulo;
		this.descTitulo = descTitulo;
		this.nombreTitulo = nombreTitulo;
		this.fechaRegistro = fechaRegistro;
		this.fechaModificacion = fechaModificacion;
		this.aliasUsuario = aliasUsuario;
	}
	public Integer getIdTitulo() {
		return idTitulo;
	}
	public void setIdTitulo(Integer idTitulo) {
		this.idTitulo = idTitulo;
	}
	public String getDescTitulo() {
		return descTitulo;
	}
	public void setDescTitulo(String descTitulo) {
		this.descTitulo = descTitulo;
	}
	public String getNombreTitulo() {
		return nombreTitulo;
	}
	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getAliasUsuario() {
		return aliasUsuario;
	}
	public void setAliasUsuario(String aliasUsuario) {
		this.aliasUsuario = aliasUsuario;
	}

}
