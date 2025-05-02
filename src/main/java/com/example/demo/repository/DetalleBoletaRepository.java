package com.example.demo.repository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.DetalleBoleta;

@Repository("detalleboletarepository")
public interface DetalleBoletaRepository extends JpaRepository<DetalleBoleta, Serializable>{
	List<DetalleBoleta> findByDetId(int detId);
	List<DetalleBoleta> findByDetboId(int detboId);
	List<DetalleBoleta> findByDetTipoMonto(String detTipoMonto);
	List<DetalleBoleta> findByDetDescrip(String detDescrip);
	List<DetalleBoleta> findByDetMonto(double detMonto);
}