package view;

import controller.AutomovelController;
import entity.Automovel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AutomovelView {

    AutomovelController automovelController;
    Scanner sc;

    public AutomovelView(){
        this.automovelController = new AutomovelController();
        this.sc = new Scanner(System.in);
    }

    public void menuAutomovel(){
        System.out.println("#Menu entity.Automovel");
        System.out.println("01- Listar");
        System.out.println("02- Cadastrar");
        System.out.println("03- Alterar");
        System.out.println("04- Buscar");
        System.out.println("05- Excluir");
        System.out.println("00- Voltar");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op){
            case 1:
                listarAutomovel();
                break;
            case 2:
                cadastrarAutomovel();
                break;
            case 3:
                alterarAutomovel();
                break;
            case 4:
                buscarAutomovel();
                break;
            case 5:
                excluirAutomovel();
                break;
            case 0:
                break;
            default:
                System.out.println("OpÁ„o Inv·lida");
                menuAutomovel();
                break;
        }

        menuAutomovel();
    }

    public void listarAutomovel(){

    }

    public void cadastrarAutomovel()  {

        Automovel automovel = new Automovel();

        System.out.println("# Cadastro de entity.Automovel ");

        System.out.println("> Informe o nome da marca: ");
       // automovel.setNomeMarca(sc.nextLine());

        System.out.println("> Informe o nome do modelo: ");
        automovel.setNomeModelo(sc.nextLine());

        System.out.println("> Informe o tipo do modelo: ");
        automovel.setTipo(sc.nextLine());

        System.out.println("> Informe a cor do automovel: ");
        automovel.setCor(sc.nextLine());

        try {
            System.out.print("> Informe o ano da fabricaÁ„o ");
            String dataFab = sc.nextLine();
            Date anF = new SimpleDateFormat("dd/MM/yyyy").parse(dataFab);
            automovel.setAno_fab(anF);

            System.out.print("> Informe o ano do modelo ");
            String dataMod = sc.nextLine();
            Date anM = new SimpleDateFormat("dd/MM/yyyy").parse(dataMod);
            automovel.setAno_modelo(anM);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o chassi: ");
        automovel.setChassi(sc.nextLine());

        System.out.println("> Informe a placa: ");
        automovel.setPlaca(sc.nextLine());

        System.out.println("> Informe a quilometragem: ");
        automovel.setKm(sc.nextFloat());

        System.out.println("> Informe o valor: ");
        automovel.setValor(sc.nextFloat());

        automovelController.cadastrar(automovel);
            
    }

    public void alterarAutomovel(){

        //automovelController.alterar();

       /* Scanner sc = new Scanner(System.in);
        if (automovel.verificarListaVasia()){
            System.out.println("Nenhum automovel cadastrado");
        }else {
            System.out.println("# Digite o nome do modelo do automovel que deseja alterar");
            String nome = sc.nextLine();

            if (automovel.alterarAutomovel(nome)){
                System.out.println("entity.Automovel alterado!");
            }else {
                System.out.println("entity.Automovel n√£o encontrado");
            }

        }*/
    }


    public void buscarAutomovel(){

            Scanner sc = new Scanner(System.in);
            System.out.println("# Digite a placa do automovel  que deseja buscar");
            String placa = sc.nextLine();
            Automovel automovel = new Automovel();
            
            automovel = automovelController.buscar(placa);
            
            
            

        }


    public void excluirAutomovel(){

            System.out.println("# Digite a placa do automovel que deseja excluir");
            String placa = sc.nextLine();

            if (automovelController.excluir(placa)){
                System.out.println("entity.Automovel Excluido!");
            }else {
                System.out.println("entity.Automovel n√£o encontrado!");
            }
        }

}
