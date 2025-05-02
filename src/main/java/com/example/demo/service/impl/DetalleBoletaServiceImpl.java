package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.DetalleBoleta;
import com.example.demo.repository.DetalleBoletaRepository;
import com.example.demo.service.DetalleBoletaService;

@Service("detalleboletaservice")
public class DetalleBoletaServiceImpl implements DetalleBoletaService{
	@Autowired
	@Qualifier("detalleboletarepository")
	private DetalleBoletaRepository detalleBoletaRepository;
	
	@Override
	public List<DetalleBoleta> listAllDetalleBoleta() {
		return detalleBoletaRepository.findAll();
	}

	@Override
	public DetalleBoleta addDetalleBoleta(DetalleBoleta detalleBoleta) {
		return detalleBoletaRepository.save(detalleBoleta);
	}

	@Override
	public void deleteDetalleBoleta(int id) {
		detalleBoletaRepository.deleteById(id);
	}

	@Override
	public DetalleBoleta getDetalleBoletaById(int id) {
		return detalleBoletaRepository.findById(id).orElse(null);
	}

	@Override
	public List<DetalleBoleta> buscarPorFiltro(String tipo, String valor) {
		switch (tipo) {
        case "detId":
            return detalleBoletaRepository.findByDetId(Integer.parseInt(valor));
        case "detbolId":
        	return detalleBoletaRepository.findByDetboId(Integer.parseInt(valor));
        case "detTipoMonto":
            return detalleBoletaRepository.findByDetTipoMonto(valor);
        case "detDescrip":
            return detalleBoletaRepository.findByDetDescrip(valor);
        case "detMonto":
            return detalleBoletaRepository.findByDetMonto(Double.parseDouble(valor));
        default:
            return listAllDetalleBoleta();
		}
	}
}