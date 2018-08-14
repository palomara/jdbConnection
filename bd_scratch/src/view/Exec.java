package view;


import java.sql.Connection;

import controller.JdbUtil;
import controller.UsuariosJdbcDAO;
import model.Usuarios;

public class Exec {
	
	public static void main (String [] args) {
		
		Usuarios usuarios = new Usuarios();
		
		try {
			usuarios.setNome("Jeferson");
			usuarios.setEmail("jeferson@etec.com");
			usuarios.setSexo("Masculino");
			
			
			Connection connection = JdbUtil.getConnection();
			UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
			
			usuariosJdbcDao.salvar(usuarios);
			//usuariosJdbcDao.alterar(c);
			//usuariosJdbcDao.deletar(1); 
			//usuariosJdbcDao.listar();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
