package com.example.demo.repository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Boleta;
import java.util.Date;

@Repository("boletarepository")
public interface BoletaRepository extends JpaRepository<Boleta, Serializable>{
	List<Boleta> findByBolId(int bolId);
	List<Boleta> findByBolFechaEmision(Date bolFechaEmision);
	List<Boleta> findByBolMesPago(String bolMesPago);
	List<Boleta> findByBolempId(int bolempId);
	List<Boleta> findByBolempreId(int bolempreId);
}