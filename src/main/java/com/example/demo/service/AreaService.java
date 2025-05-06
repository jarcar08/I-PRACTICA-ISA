package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Area;

public interface AreaService {
	List<Area> listAllArea();

	Area addContrato(Area area);

	void deleteArea(int id);

	Area getAreaById(int id);

	List<Area> buscarPorFiltro(String tipo, String valor);
}