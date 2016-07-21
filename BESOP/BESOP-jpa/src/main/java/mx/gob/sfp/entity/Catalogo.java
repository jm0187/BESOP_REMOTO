package mx.gob.sfp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CATALOGO database table.
 * 
 */
@Entity
//@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
@NamedQueries({@NamedQuery( name= "Catalogo.findById" , query="SELECT c FROM Catalogo c WHERE c.idCatalogo = :idCatalogo")})
@Table(name = "Catalogo")
@SqlResultSetMapping(name = "resultCatalogos", entities = { @EntityResult(entityClass = Catalogo.class, fields = {
		@FieldResult(name = "idCatalogo", column = "ID_CATALOGO"),
		@FieldResult(name = "descripcionCorta", column = "DESCRIPCION_CORTA"),
		}) })
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(generator = "SEQ_CATALOGO", strategy = GenerationType.SEQUENCE)
//        @SequenceGenerator(allocationSize = 1,name = "SEQ_CATALOGO", sequenceName = "SEQ_CATALOGO")
	@Column(name="ID_CATALOGO")
	private long idCatalogo;

	@Column(name="DESCRIPCION_CORTA")
	private String descripcionCorta;

	@Column(name="DESCRIPCION_LARGA")
	private String descripcionLarga;

	private BigDecimal estatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_ALTA")
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="ID_TIPO_CATALOGO")
	private BigDecimal idTipoCatalogo;

	public Catalogo() {
	}

	public long getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(long idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public String getDescripcionCorta() {
		return this.descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return this.descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public BigDecimal getEstatus() {
		return this.estatus;
	}

	public void setEstatus(BigDecimal estatus) {
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

	public BigDecimal getIdTipoCatalogo() {
		return this.idTipoCatalogo;
	}

	public void setIdTipoCatalogo(BigDecimal idTipoCatalogo) {
		this.idTipoCatalogo = idTipoCatalogo;
	}

    @Override
    public String toString() {
        return "Catalogo{" + "idCatalogo=" + idCatalogo + ", descripcionCorta=" + descripcionCorta + ", descripcionLarga=" + descripcionLarga + ", estatus=" + estatus + ", fechaAlta=" + fechaAlta + ", fechaModificacion=" + fechaModificacion + ", idTipoCatalogo=" + idTipoCatalogo + '}';
    }
        
        

}