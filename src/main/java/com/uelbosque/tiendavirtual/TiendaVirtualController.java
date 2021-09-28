package com.uelbosque.tiendavirtual;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.dao.ClienteDAO;
import com.tiendavirtual.dto.Cliente;

@RestController
public class TiendaVirtualController {
    
    @RequestMapping("/crearCliente")
    public String insertarCliente(Cliente cliente) {
    	ClienteDAO dao=new ClienteDAO();
    	dao.insertarCliente(cliente);
    	
        return "Microservicio de insercion de cliente";
    }	
    
    @RequestMapping("/buscarCliente")
    public String consultarCliente() {
        return "Microservicio de consulta de cliente";
    }
}
