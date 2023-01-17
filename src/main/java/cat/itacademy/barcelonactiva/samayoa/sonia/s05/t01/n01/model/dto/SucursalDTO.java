package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO {
	
	private Long pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	
	String[] listaPaises = { "Alemania", "Belgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia",
			"Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia",
			"Republica Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungria", "Italia", "Lituania",
			"Portugal", "Rumania" };
	List<String> paisesEU = Arrays.asList(listaPaises);

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

	public String getTipusSucursal(String paisSucursal) {
		this.tipusSucursal = "Sense Tipus";
		int indice = paisesEU.indexOf(paisSucursal);
		if (indice != -1) {
			this.tipusSucursal = "EU";
		} else {
			this.tipusSucursal = "No EU";
		}

		return this.tipusSucursal;

	}

	
	

}
