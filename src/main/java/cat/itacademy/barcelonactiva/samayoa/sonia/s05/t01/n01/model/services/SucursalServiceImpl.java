package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	SucursalRepository sucursalRepo;

	@Override
	public Long add(SucursalDTO sucursalDTO) {
		Sucursal sucursal = this.mapDTOToEntity(sucursalDTO);
		sucursal=sucursalRepo.save(sucursal);
		return sucursal.getPk_SucursalID();
	}

	@Override
	public SucursalDTO update(SucursalDTO sucursalDTO, Long pk_SucursalID) {
				
		Sucursal sucursalUpdate = sucursalRepo.findById(pk_SucursalID).orElse(null);
		SucursalDTO sucursal = this.mapEntityToDTO(sucursalUpdate);
		sucursal = sucursalRepo.save(sucursal);
		return sucursal;
	}

	@Override
	public void delete(Long id) {
		sucursalRepo.deleteById(id);
		
	}

	@Override
	public Sucursal getOne(Long id) {
		Sucursal resultat = null;
		Optional<Sucursal> sucursal = sucursalRepo.findById(id);
		if(sucursal.isPresent()) {
			resultat=sucursal.get();
		}
		return resultat;
	}

	@Override
	public List<SucursalDTO> getAll() {
		List<SucursalDTO> resultat = new ArrayList<SucursalDTO>();
		List<Sucursal> sucursales = sucursalRepo.findAll();
		if (sucursales!=null && sucursales.size()>0) {
			for(Sucursal sucursal: sucursales) {
				resultat.add(this.mapEntityToDTO(sucursal));
			}
		}
		return resultat;
	}
	
	private Sucursal mapDTOToEntity(SucursalDTO sucursalDTO) {
		Sucursal resultat = null;
		if(sucursalDTO != null) {
			resultat = new Sucursal();
			resultat.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
			resultat.setNomSucursal(sucursalDTO.getNomSucursal());
			resultat.setPaisSucursal(sucursalDTO.getPaisSucursal());
		}
		return resultat;
	}
	
	private SucursalDTO mapEntityToDTO(Sucursal sucursal) {
		SucursalDTO resultat = null;
		if(sucursal != null) {
			resultat = new SucursalDTO();
			resultat.setPk_SucursalID(sucursal.getPk_SucursalID());
			resultat.setNomSucursal(sucursal.getNomSucursal());
			resultat.setPaisSucursal(sucursal.getPaisSucursal());
			String pais=sucursal.getPaisSucursal();
			resultat.getTipusSucursal(pais);
		}
		return resultat;
	}

}
