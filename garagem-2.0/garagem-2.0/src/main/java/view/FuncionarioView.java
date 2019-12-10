package view;

import controller.FuncionarioController;
import entity.Badeco;
import entity.Funcionario;
import entity.Gerente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FuncionarioView {
    private FuncionarioController funcionarioController;
    private Scanner sc;
    private Funcionario funcionario;

    public FuncionarioView(){
        this.funcionarioController = new FuncionarioController();
        this.sc = new Scanner(System.in);
        this.funcionario = new Funcionario();
    }

    public void menuFuncionario() {
        System.out.println("#Menu entity.Funcionario");
        System.out.println("01- Listar");
        System.out.println("02- Cadastrar");
        System.out.println("03- Alterar");
        System.out.println("04- Buscar");
        System.out.println("05- Excluir");
        System.out.println("06- Calcular Salario");
        System.out.println("00- Voltar");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op){
            case 1:
                listarFuncionarios();
                break;
            case 2:
                cadastrarFuncionario();
                break;
            case 3:
                alterarUsuario();
                break;
            case 4:
                buscarFuncionario();
                break;
            case 5:
                excluirFuncionario();
                break;
            case 6:
                //calcularSalario();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção Inválida");
                menuFuncionario();
                break;
        }

        menuFuncionario();

    }

    public void listarFuncionarios(){

        for (Funcionario f : funcionarioController.listar()){
            System.out.println(
                    "Codigo: "+f.getCodigo()+
                            "\n"+"Cargo: "+f.getCargo()+
                            "\n"+"Nome: "+f.getNome()+
                            "\n"+"CPF: "+f.getCpf()+
                            "\n"+"Endereco: "+f.getEndereco()+
                            "\n"+"Telefone: "+f.getTelefone()+
                            "\n"+"Data Nascimento: "+f.getDt_nascimento()+
                            "\n"+"Usuario: "+f.getUsuario());
        }
        }



    public void cadastrarFuncionario()  {

        System.out.println("Digite 1 para cadastrar Gerente");
        System.out.println("Digite 2 para cadastrar Funcionario");
        System.out.println("Digite 3 para cadastrar Badeco");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op){
            case 1:
                this.funcionario = new Gerente();
                funcionario.setCargo("Gerente");
                break;
            case 2:
                this.funcionario = new Funcionario();
                funcionario.setCargo("Funcionario");
                break;
            case 3:
                this.funcionario = new Badeco();
                funcionario.setCargo("Badeco");
                break;
        }

        sc.nextLine();

       System.out.println("> Informe o nome: ");
        funcionario.setNome(sc.nextLine());

        System.out.println("> Informe o cpf: ");
        funcionario.setCpf(sc.nextLine());

        System.out.println("> Informe o endereço: ");
        funcionario.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        funcionario.setTelefone(sc.nextLine());

        try {
            System.out.print("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            funcionario.setDt_nascimento(dt);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        funcionario.setCodigo(sc.nextLine());

        System.out.println("> Informe o usuario: ");
        funcionario.setUsuario(sc.nextLine());

        System.out.println("> Informe a senha: ");
        funcionario.setSenha(sc.nextLine());

       if (funcionarioController.cadastrar(funcionario)){
           System.out.println("Sucesso ao cadastrar funcionario");
       }else{
           System.out.println("Erro ao cadastrar funcionario, tente novamente");
       }

    }

    public void alterarUsuario(){
        Scanner sc = new Scanner(System.in);

            System.out.println("# Digite o codigo do funcionário que deseja alterar");
            String codigo = sc.nextLine();

        Funcionario f =  funcionarioController.buscar(codigo);

        if (f == null){
            System.out.println("Funcionario não encontrado");
        }else{
            System.out.println(
                    "Codigo: "+f.getCodigo()+
                            "\n"+"Cargo: "+f.getCargo()+
                            "\n"+"Nome: "+f.getNome()+
                            "\n"+"CPF: "+f.getCpf()+
                            "\n"+"Endereco: "+f.getEndereco()+
                            "\n"+"Telefone: "+f.getTelefone()+
                            "\n"+"Data Nascimento: "+f.getDt_nascimento()+
                            "\n"+"Usuario: "+f.getUsuario());
        }


        System.out.println("> Informe o novo nome: ");
        funcionario.setNome(sc.nextLine());

        System.out.println("> Informe o novo cpf: ");
        funcionario.setCpf(sc.nextLine());

        System.out.println("> Informe o novo endereço: ");
        funcionario.setEndereco(sc.nextLine());

        System.out.println("> Informe o novo telefone: ");
        funcionario.setTelefone(sc.nextLine());

        try {
            System.out.print("> Informe a nova data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            funcionario.setDt_nascimento(dt);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        funcionario.setCodigo(codigo);

        System.out.println("> Informe o novo usuario: ");
        funcionario.setUsuario(sc.nextLine());

        System.out.println("> Informe a nova senha: ");
        funcionario.setSenha(sc.nextLine());

        if (funcionarioController.alterar(funcionario)){
            System.out.println("Sucesso ao alterar usuario");
        }else{
            System.out.println("Erro ao alterar usuario, tente novamente");
        }




        }



    public void buscarFuncionario(){

            Scanner sc = new Scanner(System.in);
            System.out.println("# Digite o codigo do funcionário que deseja buscar");
            String codigo = sc.nextLine();


          Funcionario f =  funcionarioController.buscar(codigo);

          if (f == null){
              System.out.println("Funcionario não encontrado");
          }else{
              System.out.println(
                      "Codigo: "+f.getCodigo()+
                              "\n"+"Cargo: "+f.getCargo()+
                              "\n"+"Nome: "+f.getNome()+
                              "\n"+"CPF: "+f.getCpf()+
                              "\n"+"Endereco: "+f.getEndereco()+
                              "\n"+"Telefone: "+f.getTelefone()+
                              "\n"+"Data Nascimento: "+f.getDt_nascimento()+
                              "\n"+"Usuario: "+f.getUsuario());
          }


        }


    public void excluirFuncionario(){

            Scanner sc = new Scanner(System.in);
            System.out.println("# Digite o codigo do funcionário que deseja excluir");
            String codigo = sc.nextLine();

            if (funcionarioController.excluir(codigo)){
                System.out.println("Funcionario Excluido");
            }else {
                System.out.println("Erro ao excluir funcionario, verifique se o funcionario está cadastrado");
            }
        }


    /*public void calcularSalario(){
        System.out.println("Salario funcionario: "+funcionario.calcularSalario());
        System.out.println("Salario badeco: "+badeco.calcularSalario());
        System.out.println("Salario gerente: "+ gerente.calcularSalario());
    }*/

}
