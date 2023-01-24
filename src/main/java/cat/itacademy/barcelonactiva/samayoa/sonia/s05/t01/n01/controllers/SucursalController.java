package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.services.SucursalServiceImpl;

//@CrossOrigin(origins = "http://localhost:9000")
@Controller
@RequestMapping("/sucursal")
public class SucursalController {
	
	@Autowired
	private SucursalServiceImpl sucursalService;

	
	@GetMapping("/add")
	public String add(Model model) {
		
		Sucursal sucursal = new Sucursal();
		model.addAttribute("titulo", "Formulario nueva Sucursal");
		model.addAttribute("sucursal", sucursal);
		
		return "/sucursal/frmCrear";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long idSucursal, Model model) {
		
		Sucursal sucursal = new Sucursal();
		sucursal = sucursalService.getOne(idSucursal);
		model.addAttribute("titulo", "Formulario Editar Sucursal");
		model.addAttribute("sucursal", sucursal);
		
		return "/sucursal/frmCrear";
	}
	
		
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		
		sucursalService.delete(id);
		System.out.println("registro con id: " +id+ " eliminado");
		
		return this.getAll(model);
	}
	
	@GetMapping("/getOne/{id}")
	public String getOneSucursal(@PathVariable("id") Long id, Model model) {
		model.addAttribute("Sucursal", sucursalService.getOne(id));
		return "/sucursal/consultaSucursal";
	}
	
	@GetMapping("/getAll")
	public String getAll(Model model) {
		List<SucursalDTO> listadoSucursales = sucursalService.getAll();
		model.addAttribute("titulo", "Lista de Sucursales");
		model.addAttribute("sucursales", listadoSucursales);
		return "/sucursal/sucursales";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute SucursalDTO sucursalDTO, Model model) {

		sucursalService.add(sucursalDTO);
		System.out.println("Sucursal guardada correctament");
		
		return this.getAll(model);
				
	}


}
