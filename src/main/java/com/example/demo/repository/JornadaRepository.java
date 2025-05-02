package com.example.demo.repository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Jornada;

@Repository("jornadarepository")
public interface JornadaRepository extends JpaRepository<Jornada, Serializable>{
	List<Jornada> findByJornId(int jornId);
	List<Jornada> findByJornTipo(String jornTipo);
}