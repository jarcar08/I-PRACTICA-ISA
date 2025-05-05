package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Contrato;
import com.example.demo.repository.ContratoRepository;
import com.example.demo.service.ContratoService;

@Service("contratoservice")
public class ContratoServiceImpl implements ContratoService {

    @Autowired
    @Qualifier("contratorepository")
    private ContratoRepository contratoRepository;

    // Listar todos los contratos
    @Override
    public List<Contrato> listAllContratos() {
        return contratoRepository.findAll();
    }

    // Agregar un contrato
    @Override
    public Contrato addContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    // Eliminar un contrato por ID
    @Override
    public void deleteContrato(int id) {
        contratoRepository.deleteById(id);
    }

    // Obtener un contrato por ID
    @Override
    public Contrato getContratoById(int id) {
        return contratoRepository.findById(id).orElse(null);
    }

    // Buscar contratos por filtro
    @Override
    public List<Contrato> buscarPorFiltro(String tipo, String valor) {
        switch (tipo) {
            case "conId":
                return contratoRepository.findByConId(Integer.parseInt(valor));
            case "conEmpId":
                return contratoRepository.findByConEmpId(Integer.parseInt(valor));
            case "conAreaId":
                return contratoRepository.findByConAreaId(Integer.parseInt(valor));
            case "conJornId":
                return contratoRepository.findByConJornId(Integer.parseInt(valor));
            case "conEstado":
                return contratoRepository.findByConEstado(Byte.parseByte(valor));
            case "conFechaInicio":
                return contratoRepository.findByConFechaInicio(java.sql.Date.valueOf(valor));
            case "conFechaFin":
                return contratoRepository.findByConFechaFin(java.sql.Date.valueOf(valor));
            case "conDiasTrabajo":
                return contratoRepository.findByConDiasTrabajo(Integer.parseInt(valor));
            default:
                return listAllContratos();
        }
    }
}
