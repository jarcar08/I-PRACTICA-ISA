package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ModContrato;
import com.example.demo.repository.ModContratoRepository;
import com.example.demo.service.ModContratoService;

@Service("modcontratoservice")
public class ModContratoServiceImpl implements ModContratoService{
	@Autowired
	@Qualifier("modcontratorepository")
	private ModContratoRepository modContratoRepository;

	@Override
	public List<ModContrato> listAllModContrato() {
		return modContratoRepository.findAll();
	}

	@Override
	public ModContrato addModContrato(ModContrato modContrato) {
		return modContratoRepository.save(modContrato);
	}

	@Override
	public void deleteModContrato(int id) {
		modContratoRepository.deleteById(id);
	}

	@Override
	public ModContrato getModContratoById(int id) {
		return modContratoRepository.findById(id).orElse(null);
	}

	@Override
	public List<ModContrato> buscarPorFiltro(String tipo, String valor) {
		switch (tipo) {
        case "modconId":
            return modContratoRepository.findByModconId(Integer.parseInt(valor));
        case "modcontipo":
            return modContratoRepository.findByModcontipo(valor);
        default:
            return listAllModContrato();
		}
	}
}