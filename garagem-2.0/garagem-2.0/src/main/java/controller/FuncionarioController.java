package controller;

import entity.Funcionario;
import model.FuncionarioModel;

import java.util.List;

public class FuncionarioController {
     private FuncionarioModel funcionarioModel;

     public FuncionarioController(){
         this.funcionarioModel = new FuncionarioModel();
     }

     public List<Funcionario> listar(){
         return funcionarioModel.listar();
     }

     public boolean cadastrar(Funcionario funcionario){
         return funcionarioModel.cadastrar(funcionario);
     }

     public boolean alterar(Funcionario f){

         return funcionarioModel.alterar(f);
     }

     public Funcionario buscar(String codigo){

         return funcionarioModel.buscar(codigo);
     }

     public boolean excluir(String codigo){
         return funcionarioModel.excluir(codigo);
     }

}
