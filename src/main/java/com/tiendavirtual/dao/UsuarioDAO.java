package com.tiendavirtual.dao;

import java.sql.SQLException;
import java.sql.Statement;

import com.tiendavirtual.dto.Usuario;

public class UsuarioDAO {
	public void insertarUsuario(Usuario user) {
		ConexionBD connection= new ConexionBD();
		try {
			Statement stmt = connection.getConexionBD().createStatement(); //nuevo getConexionBD
			stmt.executeUpdate("INSERT INTO usuarios(nombre, password) VALUES (" + "'" + user.getNombre() + "'" + ","+ "'"+user.getPassword()+"'" + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarUsuario() {
	}

	public void actualizarUsuario() {
	}

	public void borrarUsuario() {
	}

}
