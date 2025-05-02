package com.example.demo.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Boleta;
import com.example.demo.repository.BoletaRepository;
import com.example.demo.service.BoletaService;

@Service("boletaservice")
public class BoletaServiceImpl implements BoletaService{
	@Autowired
	@Qualifier("boletarepository")
	private BoletaRepository boletaRepository;
	
	@Override
	public List<Boleta> listAllBoleta() {
		return boletaRepository.findAll();
	}

	@Override
	public Boleta addBoleta(Boleta boleta) {
		return boletaRepository.save(boleta);
	}

	@Override
	public void deleteBoleta(int id) {
		boletaRepository.deleteById(id);	}

	@Override
	public Boleta getBoletaById(int id) {
		return boletaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Boleta> buscarPorFiltro(String tipo, String valor) {
		switch (tipo) {
        case "bolId":
            return boletaRepository.findByBolId(Integer.parseInt(valor));
        case "bolFechaEmision":
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = sdf.parse(valor);
                return boletaRepository.findByBolFechaEmision(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
                return List.of();
            }
        case "bolMesPago":
            return boletaRepository.findByBolMesPago(valor);
        case "bolempId":
            return boletaRepository.findByBolempId(Integer.parseInt(valor));
        case "bolempreid":
            return boletaRepository.findByBolempreId(Integer.parseInt(valor));
        default:
            return listAllBoleta();
		}
	}
}