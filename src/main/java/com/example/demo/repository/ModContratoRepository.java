package com.example.demo.repository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.ModContrato;

@Repository("modcontratorepository")
public interface ModContratoRepository extends JpaRepository<ModContrato, Serializable>{
	List<ModContrato> findByModconId(int modconId);
	List<ModContrato> findByModcontipo(String modcontipo);
}