package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n01.model.dto.SucursalDTO;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

	SucursalDTO save(SucursalDTO sucursal);



}
