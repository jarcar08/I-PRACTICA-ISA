package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Empresa;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.service.EmpresaService;

@Service("empresaservice")
public class EmpresaServiceImpl implements EmpresaService{
	@Autowired
	@Qualifier("empresarepository")
	private EmpresaRepository empresaRepository;

	@Override
	public List<Empresa> listAllEmpresa() {
		return empresaRepository.findAll();
	}

	@Override
	public Empresa addCEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public void deleteEmpresa(int id) {
		empresaRepository.deleteById(id);
	}

	@Override
	public Empresa getEmpresaById(int id) {
		return empresaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Empresa> buscarPorFiltro(String tipo, String valor) {
		switch (tipo) {
        case "emprId":
            return empresaRepository.findByEmprId(Integer.parseInt(valor));
        case "conIdEmp":
            return empresaRepository.findByEmprRuc(valor);
        case "conIdModEmpl":
            return empresaRepository.findByEmprNombre(valor);
        default:
            return listAllEmpresa();
		}
	}
}