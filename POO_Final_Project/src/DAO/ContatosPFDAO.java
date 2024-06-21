package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidade.ContatosPF;

public class ContatosPFDAO extends DAO<ContatosPF> {

	public ContatosPFDAO() {
		super();
	}

	@Override
	public boolean insert(ContatosPF contatoPf) throws SQLException {
		// Insert SQL script
		String query = "INSERT INTO ContatosPF (nome_completo, telefone, telefone_secundario, email, email_secundario, rua, numero, complemento, bairro, cidade, estado, cep, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// stmt to execute DatabaseQuery
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, contatoPf.getNome_completo());
			stmt.setString(2, contatoPf.getTelefone());
			stmt.setString(3, contatoPf.getTelefone_secundario());
			stmt.setString(4, contatoPf.getEmail());
			stmt.setString(5, contatoPf.getEmail_secundario());
			stmt.setString(6, contatoPf.getRua());
			stmt.setString(7, contatoPf.getNumero());
			stmt.setString(8, contatoPf.getComplemento());
			stmt.setString(9, contatoPf.getBairro());
			stmt.setString(10, contatoPf.getCidade());
			stmt.setString(11, contatoPf.getEstado());
			stmt.setString(12, contatoPf.getCep());
			stmt.setString(13, contatoPf.getData_Nascimento());

			return stmt.executeUpdate() > 0;
		}
	}
}
