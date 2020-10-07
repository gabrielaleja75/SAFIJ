package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@Table(name="municipio")
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="municipio_id")
	private int municipioId;

	@Column(name="municipio_estado")
	private int municipioEstado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="municipio_fecha_crea")
	private Date municipioFechaCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="municipio_fecha_modifica")
	private Date municipioFechaModifica;

	@Column(name="municipio_nombre")
	private String municipioNombre;

	@Column(name="municipio_usuario_crea")
	private int municipioUsuarioCrea;

	@Column(name="municipio_usuario_modifica")
	private int municipioUsuarioModifica;

	//bi-directional many-to-one association to CatalogoAgencia
	@OneToMany(mappedBy="municipio")
	private List<CatalogoAgencia> catalogoAgencias;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="municipio")
	private List<Ciudad> ciudads;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="municipio_departamento_id")
	private Departamento departamento;

	//bi-directional many-to-one association to PersonalPersona
	@OneToMany(mappedBy="municipio")
	private List<PersonalPersona> personalPersonas;

	public Municipio() {
	}

	public int getMunicipioId() {
		return this.municipioId;
	}

	public void setMunicipioId(int municipioId) {
		this.municipioId = municipioId;
	}

	public int getMunicipioEstado() {
		return this.municipioEstado;
	}

	public void setMunicipioEstado(int municipioEstado) {
		this.municipioEstado = municipioEstado;
	}

	public Date getMunicipioFechaCrea() {
		return this.municipioFechaCrea;
	}

	public void setMunicipioFechaCrea(Date municipioFechaCrea) {
		this.municipioFechaCrea = municipioFechaCrea;
	}

	public Date getMunicipioFechaModifica() {
		return this.municipioFechaModifica;
	}

	public void setMunicipioFechaModifica(Date municipioFechaModifica) {
		this.municipioFechaModifica = municipioFechaModifica;
	}

	public String getMunicipioNombre() {
		return this.municipioNombre;
	}

	public void setMunicipioNombre(String municipioNombre) {
		this.municipioNombre = municipioNombre;
	}

	public int getMunicipioUsuarioCrea() {
		return this.municipioUsuarioCrea;
	}

	public void setMunicipioUsuarioCrea(int municipioUsuarioCrea) {
		this.municipioUsuarioCrea = municipioUsuarioCrea;
	}

	public int getMunicipioUsuarioModifica() {
		return this.municipioUsuarioModifica;
	}

	public void setMunicipioUsuarioModifica(int municipioUsuarioModifica) {
		this.municipioUsuarioModifica = municipioUsuarioModifica;
	}

	public List<CatalogoAgencia> getCatalogoAgencias() {
		return this.catalogoAgencias;
	}

	public void setCatalogoAgencias(List<CatalogoAgencia> catalogoAgencias) {
		this.catalogoAgencias = catalogoAgencias;
	}

	public CatalogoAgencia addCatalogoAgencia(CatalogoAgencia catalogoAgencia) {
		getCatalogoAgencias().add(catalogoAgencia);
		catalogoAgencia.setMunicipio(this);

		return catalogoAgencia;
	}

	public CatalogoAgencia removeCatalogoAgencia(CatalogoAgencia catalogoAgencia) {
		getCatalogoAgencias().remove(catalogoAgencia);
		catalogoAgencia.setMunicipio(null);

		return catalogoAgencia;
	}

	public List<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(List<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}

	public Ciudad addCiudad(Ciudad ciudad) {
		getCiudads().add(ciudad);
		ciudad.setMunicipio(this);

		return ciudad;
	}

	public Ciudad removeCiudad(Ciudad ciudad) {
		getCiudads().remove(ciudad);
		ciudad.setMunicipio(null);

		return ciudad;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<PersonalPersona> getPersonalPersonas() {
		return this.personalPersonas;
	}

	public void setPersonalPersonas(List<PersonalPersona> personalPersonas) {
		this.personalPersonas = personalPersonas;
	}

	public PersonalPersona addPersonalPersona(PersonalPersona personalPersona) {
		getPersonalPersonas().add(personalPersona);
		personalPersona.setMunicipio(this);

		return personalPersona;
	}

	public PersonalPersona removePersonalPersona(PersonalPersona personalPersona) {
		getPersonalPersonas().remove(personalPersona);
		personalPersona.setMunicipio(null);

		return personalPersona;
	}

}