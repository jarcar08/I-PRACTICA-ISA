package com.example.demo.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Contrato;
import com.example.demo.repository.ContratoRepository;
import com.example.demo.service.ContratoService;

@Service("clienteservice")
public class ContratoServiceImpl implements ContratoService{
	@Autowired
	@Qualifier("contratorepository")
	private ContratoRepository contratoRepository;
	
	//LISTA TODOS LOS CONTRATOS
	@Override
	public List<Contrato> listAllContrato() {
		return contratoRepository.findAll();
	}

	//AGREGA CONTRATO
	@Override
	public Contrato addContrato(Contrato contrato) {
		return contratoRepository.save(contrato);
	}

	//ELIMINA CONTRATO POR ID
	@Override
	public void deleteContrato(int id) {
		contratoRepository.deleteById(id);
	}

	//OBTIENE CONTRATO POR ID
	@Override
	public Contrato getContratoById(int id) {
		return contratoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Contrato> buscarPorFiltro(String tipo, String valor) {
	    switch (tipo) {
	        case "conId":
	            return contratoRepository.findByConId(Integer.parseInt(valor));
	        case "conIdEmp":
	            return contratoRepository.findByConIdEmp(Integer.parseInt(valor));
	        case "conIdModEmpl":
	            return contratoRepository.findByConIdModEmpl(Integer.parseInt(valor));
	        case "conIdArea":
	            return contratoRepository.findByConIdArea(Integer.parseInt(valor));
	        case "conFechaInicio":
	        	try {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                Date fecha = sdf.parse(valor);
	                return contratoRepository.findByConFechaInicio(fecha);
	            } catch (ParseException e) {
	                e.printStackTrace();
	                return List.of();
	            }
	        case "conFechaFin":
	        	try {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                Date fecha = sdf.parse(valor);
	                return contratoRepository.findByConFechaFin(fecha);
	            } catch (ParseException e) {
	                e.printStackTrace();
	                return List.of();
	            }
	        default:
	            return listAllContrato();
	    }
	}
}