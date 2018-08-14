package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec {

	public static void main(String[] args) {
		
		Alunos alunos = new Alunos();
		try {
			alunos.setNome("Huguinho");
			alunos.setEndereco("Av Tal");
			alunos.setBairro("Bairro ABC");
			alunos.setCep(123145);
			
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			//alunosJdbcDao.salvar(alunos);
			alunosJdbcDao.alterar(alunos, 3);
			//alunosJdbcDao.deletar(1); 
			//alunosJdbcDao.listar();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
