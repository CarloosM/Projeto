package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.SQLConnection;
import entity.Funcionario;

public class FuncionarioModel {

    Connection connection;

    public FuncionarioModel(){
        this.connection = SQLConnection.getConnection();
    }

    public List<Funcionario> listar(){
        String sql = "SELECT * FROM funcionario ";

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {


            pstm = connection.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){

                Funcionario funcionario = new Funcionario();


                funcionario.setCargo(rset.getString("cargo"));

                funcionario.setNome(rset.getString("nome"));

                funcionario.setCpf(rset.getString("cpf"));

                funcionario.setEndereco(rset.getString("endereco"));

                funcionario.setTelefone(rset.getString("telefone"));

                funcionario.setDt_nascimento(rset.getDate("dtNascimento"));

                funcionario.setCodigo(rset.getString("codigo"));

                funcionario.setUsuario(rset.getString("usuario"));

                funcionario.setSenha(rset.getString("senha"));



                funcionarios.add(funcionario);

            }



        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

            return funcionarios;
    }

    public boolean cadastrar(Funcionario funcionario){

        String sql = "INSERT INTO funcionario (cargo, nome, cpf, endereco, telefone, dtNascimento, codigo, usuario, senha) VALUES (?,?,?,?,?,?,?,?,?)";
        boolean x = false;

        try {
            PreparedStatement ps  = connection.prepareStatement(sql);
            ps.setString(1,funcionario.getCargo());
            ps.setString(2,funcionario.getNome());
            ps.setString(3,funcionario.getCpf());
            ps.setString(4,funcionario.getEndereco());
            ps.setString(5,funcionario.getTelefone());
            ps.setDate(6, new java.sql.Date(funcionario.getDt_nascimento().getTime()));
            ps.setString(7,funcionario.getCodigo());
            ps.setString(8,funcionario.getUsuario());
            ps.setString(9,funcionario.getSenha());

            ps.execute();

            x = true;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

       return x;
    }

    public boolean alterar(Funcionario f){
        String sql = "UPDATE funcionario SET cargo = ?, nome = ?, cpf = ?, endereco = ?, telefone = ?, dtNascimento = ?, " +
                "usuario = ?, senha = ? WHERE codigo = ?";
        boolean x = false;

        PreparedStatement pstm = null;

        try {

            pstm = connection.prepareStatement(sql);
            pstm.setString(1,f.getCargo());
            pstm.setString(2,f.getNome());
            pstm.setString(3,f.getCpf());
            pstm.setString(4,f.getEndereco());
            pstm.setString(5,f.getTelefone());
            pstm.setDate(6, new java.sql.Date(f.getDt_nascimento().getTime()));
            pstm.setString(7,f.getUsuario());
            pstm.setString(8,f.getSenha());
            pstm.setString(9,f.getCodigo());

            pstm.execute();
            x= true;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return x;
    }

    public Funcionario buscar(String codigo){

        String sql = "SELECT * FROM funcionario WHERE codigo=?";

        Funcionario funcionario = new Funcionario();
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {

            pstm = connection.prepareStatement(sql);
            pstm.setString(1, codigo);

            rset = pstm.executeQuery();

            while(rset.next()) {

                funcionario.setCargo(rset.getString("cargo"));

                funcionario.setNome(rset.getString("nome"));

                funcionario.setCpf(rset.getString("cpf"));

                funcionario.setEndereco(rset.getString("endereco"));

                funcionario.setTelefone(rset.getString("telefone"));

                funcionario.setDt_nascimento(rset.getDate("dtNascimento"));

                funcionario.setCodigo(rset.getString("codigo"));

                funcionario.setUsuario(rset.getString("usuario"));

                funcionario.setSenha(rset.getString("senha"));
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return funcionario;
    }

    public boolean excluir(String codigo){

        boolean x = false;
        String sql = "DELETE FROM funcionario WHERE codigo = ?";


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
