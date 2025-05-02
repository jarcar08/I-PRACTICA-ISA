package com.example.demo.repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Area;

@Repository("arearepository")
public interface AreaRepository extends JpaRepository<Area, Serializable>{
	List<Area> findByAreId(int areId);
	List<Area> findByAreNombre(String areNombre);
}