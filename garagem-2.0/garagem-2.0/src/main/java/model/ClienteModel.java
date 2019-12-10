package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.SQLConnection;
import entity.Cliente;

public class ClienteModel {

    Connection connection;

    public ClienteModel(){
        this.connection = SQLConnection.getConnection();
    }

    public List<Cliente> listar(){

        String sql = "SELECT * FROM cliente ";

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {


            pstm = connection.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){

                Cliente cliente = new Cliente();


                cliente.setNome(rset.getString("nome"));

                cliente.setCpf(rset.getString("cpf"));

                cliente.setEndereco(rset.getString("endereco"));

                cliente.setTelefone(rset.getString("telefone"));

                cliente.setDt_nascimento(rset.getDate("dtNascimento"));

                cliente.setCodigo(rset.getString("codigo"));

                clientes.add(cliente);
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return clientes;

    }

    public boolean cadastrar(Cliente cliente){
        String sql = "INSERT INTO cliente (codigo, nome, cpf, endereco, telefone, dtNascimento) VALUES (?,?,?,?,?,?)";
        boolean x = false;

        try {
            PreparedStatement ps  = connection.prepareStatement(sql);
            ps.setString(1,cliente.getCodigo());
            ps.setString(2,cliente.getNome());
            ps.setString(3,cliente.getCpf());
            ps.setString(4,cliente.getEndereco());
            ps.setString(5,cliente.getTelefone());
            ps.setDate(6, new java.sql.Date(cliente.getDt_nascimento().getTime()));

            ps.execute();

            x = true;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return x;
    }

    public boolean alterar(Cliente c){

        String sql = "UPDATE cliente SET nome = ?, cpf = ?, endereco = ?, telefone = ?, dtNascimento = ?" +
                "WHERE codigo = ?";

        boolean x = false;

        PreparedStatement pstm = null;

        try {

            pstm = connection.prepareStatement(sql);
            pstm.setString(1,c.getNome());
            pstm.setString(2,c.getCpf());
            pstm.setString(3,c.getEndereco());
            pstm.setString(4,c.getTelefone());
            pstm.setDate(5, new java.sql.Date(c.getDt_nascimento().getTime()));
            pstm.setString(6,c.getCodigo());

            pstm.execute();
            x= true;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return x;
    }

    public Cliente buscar(String codigo){

        String sql = "SELECT * FROM cliente WHERE codigo=?";

        Cliente cliente = new Cliente();
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, codigo);

            rset = pstm.executeQuery();

            while(rset.next()) {

                cliente.setNome(rset.getString("nome"));

                cliente.setCpf(rset.getString("cpf"));

                cliente.setEndereco(rset.getString("endereco"));

                cliente.setTelefone(rset.getString("telefone"));

                cliente.setDt_nascimento(rset.getDate("dtNascimento"));

                cliente.setCodigo(rset.getString("codigo"));
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return cliente;
    }

    public boolean excluir(String codigo) {

        boolean x = false;
        String sql = "DELETE FROM cliente WHERE codigo = ?";


        PreparedStatement pstm = null;

        try {

            pstm = connection.prepareStatement(sql);

            pstm.setString(1,codigo);

            pstm.execute();
            x = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  x;
    }

}
