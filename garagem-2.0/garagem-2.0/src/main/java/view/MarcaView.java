package view;

import controller.MarcaController;
import entity.Marca;

import java.util.List;
import java.util.Scanner;

public class MarcaView {

   private MarcaController marcaController;
   private Marca marca;

    public MarcaView(){
        this.marcaController = new MarcaController();
        this.marca = new Marca();
    }

    public void menuMarca(){

        System.out.println("#Menu Marca");
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
                listarMarca();
                break;
            case 2:
                cadastrarMarca();
                break;
            case 3:
                alterarMarca();
                break;
            case 4:
                buscarMarca();
                break;
            case 5:
                excluirMarca();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção Inválida");
                menuMarca();
                break;
        }

        menuMarca();

    }

    private void listarMarca() {


        for(Marca m : marcaController.listar()){
            System.out.println(
                    "Id - "+ m.getId()+
                    "\nNome - " + m.getNome()+
                    "\n"
            );
        }

    }

    private void cadastrarMarca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da marca");
        marca.setNome(sc.nextLine());

        if (marcaController.cadastrar(marca)){
            System.out.println("Marca cadastrada");
        }else {
            System.out.println("Erro ao cadastrar marca, tente novamente");
        }

    }

    private void alterarMarca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo da marca que deseja alterar");
        int codigo = sc.nextInt();

        Marca m = marcaController.buscar(codigo);

        if (m == null){
            System.out.println("Marca não encontrada");
        }else{
            System.out.println(
                    "Id - "+ m.getId()+
                            "\nNome - " + m.getNome()+
                            "\n"
            );
        }

        sc.nextLine();
        System.out.println("Digite o novo nome da marca");
        marca.setNome(sc.nextLine());
        marca.setId(codigo);

        if (marcaController.alterar(marca)){
            System.out.println("Marca alterada");
        }else{
            System.out.println("Erro ao alterar marca, tente novamente");
        }

    }

    private void buscarMarca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo da marca que deseja buscar");
        int codigo = sc.nextInt();

        Marca marca = marcaController.buscar(codigo);

        if (marca == null){
            System.out.println("Marca não encontrada");
        }else{
            System.out.println(
                    "Id - "+ marca.getId()+
                            "\nNome - " + marca.getNome()+
                            "\n"
            );
        }

    }

    private void excluirMarca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo da marca que deseja exlcuir");
        int codigo = sc.nextInt();

        marcaController.excluir(codigo);
    }


}
