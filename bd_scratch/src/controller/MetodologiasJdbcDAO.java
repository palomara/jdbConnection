package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Metodologias;

public class MetodologiasJdbcDAO {

	private Connection conn;
	
	public MetodologiasJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Metodologias m) throws SQLException {
	String sql = "inset into metodologias (metodo) values ('"+m.getMetodo()+"'";
	System.out.println(sql);
	PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	prepareStatement.executeUpdate();
	prepareStatement.close();	
	}
	
	public void deletar (int id) throws SQLException {
		String sql = "delete from metodologias where metodologias.id"+id+"";
	}
	
	public void alterar (Metodologias m) throws SQLException {
		String sql = "update metodologias set metodo'"+m.getMetodo()+"'";
		
		System.out.println(sql);
		PreparedStatement prepareStatement;
		
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
