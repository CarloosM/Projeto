
import entity.Marca;
import view.*;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args){

        Principal principal = new Principal();
        principal.menuPrincipal();

    }

    /**
     * Chamada do Menu principal.
     * 
     */
    public void menuPrincipal() {
        System.out.println("#Menu Principal");
        System.out.println("01- Funcionario");
        System.out.println("02- Cliente");
        System.out.println("03- Marca");
        System.out.println("04- Automovel");
        System.out.println("05- Vendas");
        System.out.println("00- Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op) {
            case 1:
                FuncionarioView funcionarioView = new FuncionarioView();
                funcionarioView.menuFuncionario();
                break;
            case 2:
                ClienteView clienteView = new ClienteView();
                clienteView.menuCliente();
                break;
            case 3:
                MarcaView marcaView = new MarcaView();
                marcaView.menuMarca();
                break;
            case 4:
                VendaView vendaView = new VendaView();
                vendaView.menuVenda();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida");
                menuPrincipal();
                break;
        }

    }
}
