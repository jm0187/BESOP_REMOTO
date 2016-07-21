package mx.gob.sfp.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "findUserByEmail", query = "SELECT u FROM Usuario u WHERE u.correoElectronico = :correo"),
		@NamedQuery(name = "findUserByLogin", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
		@NamedQuery(name = "findPrueba", 	  query = "SELECT u FROM Usuario u WHERE u.usuario = 'admon.pruebas@stps.gob.mx'")
		})
@Table(name="Usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USUARIO_IDUSUARIO_GENERATOR", sequenceName = "SEQ_USUARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_IDUSUARIO_GENERATOR")
	@Column(name = "ID_USUARIO")
	private long idUsuario;

	private String apellido1;

	private String apellido2;

	private String contrasena;

	@Column(name = "CORREO_ELECTRONICO")
	private String correoElectronico;

	private Integer estatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ALTA")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name = "ID_ENTIDAD")
	private Long idEntidad;
	
	@Column(name = "ID_PERFIL")
	private Long idPerfil;

	@Column(name = "ID_REGISTRO")
	private Long idRegistro;

	@Column(name = "ID_TIPO_USUARIO")
	private Long idTipoUsuario;

	private String nombre;

	@Column(name = "SESION_ACTIVA")
	private Integer sesionActiva;

	private String usuario;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Long getIdPerfil() {
	 return this.idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	public Long getIdRegistro() {
		return this.idRegistro;
	}


	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Long getIdTipoUsuario() {
		return this.idTipoUsuario;
	}

	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSesionActiva() {
		return this.sesionActiva;
	}

	public void setSesionActiva(Integer sesionActiva) {
		this.sesionActiva = sesionActiva;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", contrasena=" + contrasena + ", correoElectronico=" + correoElectronico + ", estatus=" + estatus
				+ ", fechaAlta=" + fechaAlta + ", fechaModificacion=" + fechaModificacion + ", idEntidad=" + idEntidad
				+ ", idPerfil=" + idPerfil + ", idRegistro=" + idRegistro + ", idTipoUsuario=" + idTipoUsuario
				+ ", nombre=" + nombre + ", sesionActiva=" + sesionActiva + ", usuario=" + usuario + "]";
	}

}