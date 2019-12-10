package controller;

import entity.Automovel;
import model.AutomovelModel;

/**
 * Chamadas de metodos.
 * 
 * @author Carlos Murilo
 *
 */
public class AutomovelController {

    AutomovelModel automovelModel;

    public AutomovelController(){
        this.automovelModel= new AutomovelModel();
    }

    public void listar(){
        automovelModel.listar();
    }

    public boolean cadastrar(Automovel automovel){
        return automovelModel.cadastrar(automovel);
    }

    public boolean alterar(Automovel a){

        return automovelModel.alterar(a);
    }

    public Automovel buscar(String placa){
    	
       return automovelModel.buscar(placa);
        
    }

    public boolean excluir(String placa){

        return automovelModel.excluir(placa);
    }

}
