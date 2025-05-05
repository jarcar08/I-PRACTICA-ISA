package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Contrato;
import java.sql.Date;
import java.util.List;

@Repository("contratorepository")
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
	List<Contrato> findByConId(int conId);

	List<Contrato> findByConEmpId(int conEmpId);

	List<Contrato> findByConAreaId(int conAreaId);

	List<Contrato> findByConJornId(int conJornId);

	List<Contrato> findByConEstado(Byte conEstado);

	List<Contrato> findByConFechaInicio(Date conFechaInicio);

	List<Contrato> findByConFechaFin(Date conFechaFin);

	List<Contrato> findByConDiasTrabajo(int conDiasTrabajo);
}