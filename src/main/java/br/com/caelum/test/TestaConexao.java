package br.com.caelum.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.caelum.jdbc.CRUDContato;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

public class TestaConexao {
	
	@Test
	public void testar() {
		try {
			Connection conn = new ConnectionFactory().getConnection();
			System.out.println("Conexão aberta");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void listar() 
	{

			for(Contato c : new CRUDContato().getList() ) {
				System.out.println(c);
			}
		
	}
	
	
	public  void testadata() {
        Calendar c = Calendar.getInstance();
        c.set(2013, Calendar.FEBRUARY, 28);
        Date data = c.getTime();
        System.out.println("Data atual sem formatação: "+data);
         
        //Formata a data
        DateFormat formataData = DateFormat.getDateInstance();
        System.out.println("Data atual com formatação: "+ formataData.format(data));
         
        //Formata Hora
        DateFormat hora = DateFormat.getTimeInstance();
        System.out.println("Hora formatada: "+hora.format(data));
 
        //Formata Data e Hora
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        System.out.println(dtHora.format(data));
 
    }

}
