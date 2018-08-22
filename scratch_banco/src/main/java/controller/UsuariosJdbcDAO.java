package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuarios;


public class UsuariosJdbcDAO {

	private Connection conn;
	
	public UsuariosJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Usuarios c) throws SQLException {
		String sql = "insert into usuarios (nome, email, sexo) values ('"+c.getNome()+"','"+c.getEmail()+"','"+c.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int id) throws SQLException {
		String sql = "delete from usuario where alunos.id="+id+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Usuarios c) throws SQLException {
		String sql = "update alunos set nome'"+c.getNome()+"',endereco='"+c.getEmail()+"',sexo='"+c.getSexo()+"';";
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
	
	public List<Usuarios> listar() {
		String sql = "select * from usuarios";
		System.out.println(sql);
		
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			//int id = rs.getInt("id");
			String nome = rs.getString("nome");
			System.out.println(nome);
			}
			prepareStatement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
}
