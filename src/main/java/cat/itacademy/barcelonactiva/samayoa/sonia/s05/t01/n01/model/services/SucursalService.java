package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.dto.SucursalDTO;

public interface SucursalService {
	
	/*http://localhost:9000/sucursal/add
		http://localhost:9000/sucursal/update
		http://localhost:9000/sucursal/delete/{id}
		http://localhost:9000/sucursal/getOne/{id}
		http://localhost:9000/sucursal/getAll */
	
	public Long add(SucursalDTO sucursalDTO);
	public SucursalDTO update(SucursalDTO sucursalDTO, Long Pk_SucursalID);
	public void delete(Long id);
	public SucursalDTO getOne(Long id);
	public List<SucursalDTO> getAll();

}
