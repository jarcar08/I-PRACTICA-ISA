package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Area;
import com.example.demo.repository.AreaRepository;
import com.example.demo.service.AreaService;

@Service("areaservice")
public class AreaServiceImpl implements AreaService{
	@Autowired
	@Qualifier("arearepository")
	private AreaRepository areaRepository;

	@Override
	public List<Area> listAllArea() {
		return areaRepository.findAll();
	}

	@Override
	public Area addContrato(Area area) {
		return areaRepository.save(area);
	}

	@Override
	public void deleteArea(int id) {
		areaRepository.deleteById(id);
	}

	@Override
	public Area getAreaById(int id) {
		return areaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Area> buscarPorFiltro(String tipo, String valor) {
		switch (tipo) {
        case "areId":
            return areaRepository.findByAreId(Integer.parseInt(valor));
        case "areNombre":
            return areaRepository.findByAreNombre(valor);
        default:
            return listAllArea();
		}
	}
}