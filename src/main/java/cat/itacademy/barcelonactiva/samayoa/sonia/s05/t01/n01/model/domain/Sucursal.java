package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="sucursal_db")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_SucursalID")
	private Long pk_SucursalID;

	@Column(name="nomSucursal", length=50, unique=true, nullable=false)
	private String nomSucursal;

	@Column(name="paisSucursal", length=50)
	private String paisSucursal;

	public Long getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(Long pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	@Override
	public String toString() {
		return "Sucursal [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + "]";
	}
	
	

}
