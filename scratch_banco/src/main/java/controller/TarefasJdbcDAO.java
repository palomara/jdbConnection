package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Tarefas;

public class TarefasJdbcDAO {

	private Connection conn;
	
	public TarefasJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Tarefas t) throws SQLException {
		String sql = "insert into tarefas (titulo, prazo, descricao) values ('"+t.getTitulo()+"','"+t.getPrazo()+"','"+t.getDescricao()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int id) throws SQLException {
		
		String sql = "delete from tarefas where tarefas.id="+id+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Tarefas t) throws SQLException {
		String sql = "update tarefas set nome'"+t.getTitulo()+"',Prazo='"+t.getPrazo()+"',Descricao='"+t.getDescricao()+"';";
		
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
