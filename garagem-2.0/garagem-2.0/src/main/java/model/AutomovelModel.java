package model;

import config.SQLConnection;
import entity.Automovel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AutomovelModel {
	
	Connection connection;
	
	public AutomovelModel() {
		this.connection = SQLConnection.getConnection();
	}
	

    @SuppressWarnings("finally")
	public List<Automovel> listar(){
    	
        String sql = "SELECT * FROM automovel ORDER BY id";
    	
    	ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
    	
    	
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	
    	try {

    		//connection = ConnectionFactory.createConnectionToMySQL();
    		 
    		 pstm = connection.prepareStatement(sql);
    		 
    		 rset = pstm.executeQuery();
    		 
    		 while(rset.next()){
    			 
    			 Automovel automovel = new Automovel();
    			 
    			 
    			// automovel.setNomeMarca(rset.getString("nomeMarca"));
    			 
    			 automovel.setNomeModelo(rset.getString("nomeModelo"));
    			 
    			 automovel.setTipo(rset.getString("tipo"));
    			 
    			 automovel.setCor(rset.getString("cor"));
    			 
    			 automovel.setAno_fab(rset.getDate("anoFab"));
    			 
    			 automovel.setAno_modelo(rset.getDate("anoMod"));
    			 
    			 automovel.setChassi(rset.getString("chassi"));
    			 
    			 automovel.setPlaca(rset.getString("placa"));
    			 
    			 automovel.setKm(rset.getFloat("km"));
    			 
    			 automovel.setValor(rset.getFloat("valor"));
    			 
    			 automoveis.add(automovel);
    	
    			 }
    		 
    		 
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		try {
    			if(rset != null){
   				 
   				 rset.close();
   				 }
   				 
   				 if(pstm != null){
   				 
   				 pstm.close();
   				 }
   				 
   				 if(connection != null){
   				 connection.close();
   				 }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    		
    		return automoveis;
    		
    	}
       
    }

    public boolean cadastrar(Automovel automovel){
        
    	 String SQL = "INSERT INTO automovel (nomeMarca, nomeModelo, tipo, cor, anoFab, anoMod, chassi, placa, km, valor ) VALUES (?,?,?,?,?,?,?,?,?,?)";
    	 Boolean a = false;
    	 
    	 try {
    		 
    		 PreparedStatement ps = connection.prepareStatement(SQL);
          //   ps.setString(1, automovel.getNomeMarca());
             ps.setString(2, automovel.getNomeModelo());
             ps.setString(3, automovel.getTipo());
             ps.setString(4, automovel.getCor());
             ps.setDate(5, new Date(automovel.getAno_fab().getTime()));
             ps.setDate(6, new Date(automovel.getAno_modelo().getTime()));
             ps.setString(7, automovel.getChassi());
             ps.setString(8, automovel.getPlaca());
             ps.setFloat(9, automovel.getKm());
             ps.setFloat(10,automovel.getValor());
             
            
             ps.execute();
             a = true;
            
    		 
    	 }catch(Exception e){
    		 
    		 System.out.println(e.getMessage());
    		 
    	 }
    	 
    	return a;
    }

    public boolean alterar(Automovel a){

        return true;
    }

    public Automovel buscar(String placa){
    	
    	String sql = "SELECT * FROM automovel WHERE placa="+placa;
    	
    	Automovel automovel = new Automovel();
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	
try {
    		
    		//connection = ConnectionFactory.createConnectionToMySQL();
    		 
    		 pstm = connection.prepareStatement(sql);
    		 

    		 
    		 rset = pstm.executeQuery();
    		
    			 
    			 
    		//	 automovel.setNomeMarca(rset.getString("nomeMarca"));
    			 
    			 automovel.setNomeModelo(rset.getString("nomeModelo"));
    			 
    			 automovel.setTipo(rset.getString("tipo"));
    			 
    			 automovel.setCor(rset.getString("cor"));
    			 
    			 automovel.setAno_fab(rset.getDate("anoFab"));
    			 
    			 automovel.setAno_modelo(rset.getDate("anoMod"));
    			 
    			 automovel.setChassi(rset.getString("chassi"));
    			 
    			 automovel.setPlaca(rset.getString("placa"));
    			 
    			 automovel.setKm(rset.getFloat("km"));
    			 
    			 automovel.setValor(rset.getFloat("valor"));


    		 
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		try {
    			if(rset != null){

   				 rset.close();
   				 }

   				 if(pstm != null){

   				 pstm.close();
   				 }

   				 if(connection != null){
   				 connection.close();
   				 }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    		
    		return automovel;
    		
    	}


    }


    public boolean excluir(String placa){
    	
    	Boolean a = false;
    	
    	
    	return a;
    	
    }

}
