package com.uelbosque.tiendavirtual;

import java.io.File;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tiendavirtual.dao.ClienteDAO;
import com.tiendavirtual.dao.ProductosDAO;
import com.tiendavirtual.dao.ProveedorDAO;
import com.tiendavirtual.dao.UsuarioDAO;
import com.tiendavirtual.dto.Cliente;
import com.tiendavirtual.dto.Proveedor;
import com.tiendavirtual.dto.Usuario;

@RestController
public class TiendaVirtualController {
	@RequestMapping("/crearUsuario")
    public String insertarUsuario(Usuario user) {
    	UsuarioDAO dao=new UsuarioDAO();
    	dao.insertarUsuario(user);
    	
        return "Microservicio de insercion de cliente";
    }
	
	
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
    
    
    
    @RequestMapping("/registrarProveedor")
	public String registrarProveedor(Proveedor p) {		
		ProveedorDAO dao = new ProveedorDAO();
		dao.insertProveedor(p);
		return "Proveedor Registrado";		
	}
	
	@RequestMapping("/consultarProveedores")
	public ArrayList<Proveedor> consultarProveedores(String nit) {		
		ProveedorDAO dao = new ProveedorDAO();
		return dao.consultarProveedores(nit);		
	}
	
	
/*------------------------------------------- Producto --------------------------------------------------*/
	@PostMapping("/cargarProducto")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		try {
			File fl = new File("C:\\WebDevelopEclipseAndTomcat\\MisProyectos\\ArchivosRecibidos\\" + fileName);
			file.transferTo(fl);
			ProductosDAO dao = new ProductosDAO();
			dao.FileUpload(fl);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok("Archivo cargado con exito.");
	}	
}
