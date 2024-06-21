package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import conexao.Conexao;

public abstract class DAO<T> {
	protected Connection connection;
	
	//Constructor for database connection
	public DAO() {
		this.connection = Conexao.getConexao();
	}
	
	//Abstract methods
	//insert data
	public abstract boolean insert(T obj) throws SQLException;

}
