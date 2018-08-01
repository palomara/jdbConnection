package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec {

	public static void main(String[] args) {
		
		Alunos alunos = new Alunos();
		try {
			alunos.setNome("Paloma Rangel Rocha");
			alunos.setEndereco("Av. Laranja da China, 51");
			alunos.setBairro("Jardim das Camélias");
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			//alunosJdbcDao.salvar(alunos);
			
			alunosJdbcDao.deletar(1); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
