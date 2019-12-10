package view;

import controller.AutomovelController;
import controller.ClienteController;
import controller.FuncionarioController;
import controller.VendaController;
import entity.Venda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VendaView {
    VendaController vendaController;
    Scanner sc;

    public VendaView(){
        this.vendaController = new VendaController();
        this.sc = new Scanner(System.in);
    }


    public void menuVenda(){
        System.out.println("#Menu entity.Venda");
        System.out.println("01 - Realizar entity.Venda");
        System.out.println("02 - Cancelar entity.Venda");
        System.out.println("03 - Listar Vendas");
        System.out.println("0  - Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op) {
            case 1:
                realizarVenda();
                break;
            case 2:
               // cancelarVenda();
                break;
            case 3:
               // listarVenda();
                break;
            case 0:

                break;
            default:
                System.out.println("Opção Inválida");
                menuVenda();
                break;
        }

        menuVenda();

    }

    public void realizarVenda() {

        Venda venda = new Venda();
        AutomovelController automovelController = new AutomovelController();
        ClienteController clienteController = new ClienteController();
        FuncionarioController funcionarioController = new FuncionarioController();

        boolean dadosPrimarios = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a placa do veículo");
        String placa = sc.nextLine();
        System.out.println("Digite o código do cliente");
        String codigoCliente = sc.nextLine();
        System.out.println("Digite o código do funcionário");
        String codigoFuncionario = sc.nextLine();

       /* if (automovelController.verifica(placa)){
            venda.setAutomovel(automovel.enviaObjeto(placa));
            if (cliente.verificaLista(codigoCliente)){
                venda.setCliente(cliente.enviaObjeto(codigoCliente));
                if (funcionario.verificaLista(codigoFuncionario)){
                    venda.setFuncionario(funcionario.enviaObjeto(codigoFuncionario));
                    dadosPrimarios = true;
                }
            }
        }



        if (dadosPrimarios){
            System.out.println("Digite o codigo da venda");
            venda.setCodigo(sc.nextLine());
            try {
                System.out.println("Digite a data da venda");
                String dataVenda = sc.nextLine();
                Date dtV = new SimpleDateFormat("dd/MM/yyyy").parse(dataVenda);
                venda.setDt_venda(dtV);
            }catch (ParseException e){
                e.getMessage();
            }

            System.out.println("Digite o valor da venda");
            venda.setValor_venda(sc.nextFloat());
            System.out.println("Digite a comissão da venda");
            venda.setComissao_venda(sc.nextFloat());
            venda.cadastrarVenda();

            System.out.println("entity.Venda realizada");

        }else {
            System.out.println("Algum dado digitado é inexistente");
        }
    }

    private void cancelarVenda(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo da venda para excluí-la");
        String codVenda = sc.nextLine();

        if (venda.excluirVenda(codVenda)){
            System.out.println("entity.Venda Exlcuída");
        }

    }

    private void listarVenda(){
        if (venda.verificaListaVazia()){
            System.out.println("Nenhuma venda realizada");
        }else {
            venda.listarVenda();
        }

    }*/

    }
}
