package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.DetalleBoleta;

public interface DetalleBoletaService {
	List<DetalleBoleta> listAllDetalleBoleta();
	DetalleBoleta addDetalleBoleta(DetalleBoleta detalleBoleta);
    void deleteDetalleBoleta(int id);
    DetalleBoleta getDetalleBoletaById(int id);
    List<DetalleBoleta> buscarPorFiltro(String tipo, String valor);
}