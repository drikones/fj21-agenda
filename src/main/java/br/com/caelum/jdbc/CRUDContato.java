package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.modelo.Contato;

public class CRUDContato  implements CRUD<Contato>{

	@Override
	public void save(Contato t) {
		try(Connection conn = new ConnectionFactory().getConnection())
		{
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO contatos (nome,email,endereco, dataNascimento) VALUES(?,?,?,?)");
			pstm.setString(1, t.getNome());
			pstm.setString(2, t.getEmail());
			pstm.setString(3, t.getEndereco());
			
			java.sql.Date dataParaGravar = new java.sql.Date(
					t.getDataNascimento().getTimeInMillis());
			
			pstm.setDate(4,dataParaGravar );
			pstm.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Contato t) {
		try(Connection conn = new ConnectionFactory().getConnection())
		{
			{
				PreparedStatement pstm = conn.prepareStatement("UPDATE contatos SET nome=?,email=?,endereco=?, dataNascimento=? WHERE id=?");
				pstm.setString(1, t.getNome());
				pstm.setString(2, t.getEmail());
				pstm.setString(3, t.getEndereco());
				
				java.sql.Date dataParaGravar = new java.sql.Date(
						t.getDataNascimento().getTimeInMillis());
				
				pstm.setDate(4,dataParaGravar );
				pstm.setInt(5, t.getId());
				pstm.execute();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Contato t) {
		try(Connection conn = new ConnectionFactory().getConnection())
		{
			PreparedStatement pstm = conn.prepareStatement("DELETE FROM contatos WHERE id=?");
			pstm.setInt(1, t.getId());
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Contato> getList() {
		List<Contato> contatos = new ArrayList<Contato>();
		try(Connection conn = new ConnectionFactory().getConnection())
		{
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM contatos");
			ResultSet rst = pstm.executeQuery();
			while(rst.next()) {
				Contato c = new Contato();
				c.setId(rst.getInt("id"));
				c.setNome(rst.getString("nome"));
				c.setEmail(rst.getString("email"));
				c.setEndereco(rst.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rst.getDate("dataNascimento"));
				c.setDataNascimento(data);
				
				contatos.add(c);
			}
			return contatos;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
