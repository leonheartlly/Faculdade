package br.com.assessoria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import br.com.assessoria.security.Encryptor;

public class Conexao {  
	private static final Logger LOGGER = Logger.getLogger(Conexao.class.getName());
    public Connection conectar() {  
        try {  
            String driverName = AssessoriaJuridicaUtils.getProperty("driver.name.bd");                          
            Class.forName(driverName);  
           
            String serverName = AssessoriaJuridicaUtils.getProperty("endereco.servidor.bd");  
            String mydatabase = AssessoriaJuridicaUtils.getProperty("nome.bd");  
            String url = AssessoriaJuridicaUtils.getProperty("url.bd") + serverName + "/" + mydatabase;  
            String username = AssessoriaJuridicaUtils.getProperty("user.bd");        
            String password = Encryptor.decrypt(AssessoriaJuridicaUtils.getProperty("senha.bd"));  
            Connection connection = DriverManager.getConnection(url, username, password);  
            return connection;  
        }  catch (ClassNotFoundException e) {  
        	LOGGER.error("O driver expecificado nao foi encontrado. " + e.getMessage());
            return null;  
        } catch (SQLException e) {  
        	LOGGER.error("Nao foi possivel conectar ao Banco de Dados." + e.getMessage());
            return null;  
        }  
    }
    
    public void desconectar(Connection con){  
        try {
        	if(con != null){
        		con.close();
        	}
        } catch (SQLException e) {  
        	LOGGER.error("Erro ao desconectar: " + e.getMessage());  
        }  
    }  
}