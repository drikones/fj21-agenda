package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?serverTimezone=UTC","root","Gant@!940cfS#@");
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Algo deu errado: "+e);
			return null;
		}
	}

}
