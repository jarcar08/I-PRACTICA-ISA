package com.example.demo.repository;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Contrato;

@Repository("contratorepository")
public interface ContratoRepository extends JpaRepository<Contrato, Serializable>{
	List<Contrato> findByConId(int conId);
	List<Contrato> findByConIdEmp(int conIdEmp);
	List<Contrato> findByConIdModEmpl(int conIdModEmp);
	List<Contrato> findByConIdArea(int conIdArea);
	List<Contrato> findByConFechaInicio(Date conFechaInicio);
	List<Contrato> findByConFechaFin(Date conFechaFin);
}