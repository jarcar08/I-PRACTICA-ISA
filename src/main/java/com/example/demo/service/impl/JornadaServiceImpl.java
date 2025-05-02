package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Jornada;
import com.example.demo.repository.JornadaRepository;
import com.example.demo.service.JornadaService;

@Service("jornadaservice")
public class JornadaServiceImpl implements JornadaService{
	@Autowired
	@Qualifier("jornadarepository")
	private JornadaRepository jornadaRepository;

	@Override
	public List<Jornada> listAllJornada() {
		return jornadaRepository.findAll();
	}

	@Override
	public Jornada addJornada(Jornada jornada) {
		return jornadaRepository.save(jornada);
	}

	@Override
	public void deleteJornada(int id) {
		jornadaRepository.deleteById(id);
	}

	@Override
	public Jornada getJornadaById(int id) {
		return jornadaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Jornada> buscarPorFiltro(String tipo, String valor) {
		switch (tipo) {
        case "jornId":
            return jornadaRepository.findByJornId(Integer.parseInt(valor));
        case "jornTipo":
            return jornadaRepository.findByJornTipo(valor);
        default:
            return listAllJornada();
		}
	}
}