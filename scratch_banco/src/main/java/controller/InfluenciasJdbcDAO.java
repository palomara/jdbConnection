package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Influencias;

public class InfluenciasJdbcDAO {

	private Connection conn;
	
	public InfluenciasJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Influencias i) throws SQLException {
		String sql = "insert into influencias (humor) values ('"+i.getHumor()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int id) throws SQLException {
		String sql = "delete from influencias where influencias.id="+id+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Influencias i) throws SQLException {
	String sql = "update influencias set humor'"+i.getHumor()+"';";
	
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
