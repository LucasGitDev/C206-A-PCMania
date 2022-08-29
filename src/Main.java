import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);
    public static Computador[] computadores = new Computador[3];
    public static Cliente cliente;

    public static String separator = "\n==========================================================\n";

    public static void main(String[] args) {
        int op;

        criaComputadores();
        System.out.println(separator);
        criaCliente();
        System.out.println(separator);

        do {
            printaMenu();
            mostraCarrinhoAtual();
            op = reader.nextInt();
            reader.nextLine();

            switch (op) {
                case 1:
                    cliente.adicionarComputadorAoCarrinho(computadores[0]);
                    break;
                case 2:
                    cliente.adicionarComputadorAoCarrinho(computadores[1]);
                    break;
                case 3:
                    cliente.adicionarComputadorAoCarrinho(computadores[2]);
                    break;
                case 4:
                    System.out.println(separator);
                    descreverComputador();
                    break;
                case 0:
                default:
                    System.out.println("Saindo...");
                    break;
            }
            System.out.println(separator);
        } while (op != 0);

        System.out.println(separator);
        finalizaCompra();
    }

    public static void printaMenu() {
        System.out.println("Escolha uma das opcoes abaixo:");
        System.out.println("1 - Promocao 1");
        System.out.println("2 - Promocao 2");
        System.out.println("3 - Promocao 3");
        System.out.println("4 - Descrever a promoção 'x'");
        System.out.println("0 - Sair");
    }

    public static void mostraCarrinhoAtual() {
        System.out.println("\nCarrinho atual:");
        System.out.println("R$ " + cliente.calculaTotalCompra());
    }

    public static void finalizaCompra() {
        System.out.println("Total da compra: R$ " + cliente.calculaTotalCompra());
        System.out.println("Lista de computadores escolhidos: \n" + cliente.getComputadores());
        System.out.println(separator);
        System.out.println("Obrigado por comprar conosco!");
        System.out.println(separator);
        System.out.println(separator);
    }

    public static void descreverComputador() {
        System.out.print("Escolha uma promacao para descrever (1-3):");
        int op = reader.nextInt();
        reader.nextLine();

        computadores[op - 1].mostraPCConfigs();
    }

    public static void criaComputadores() {
        HardwareBasico[] hardwaresBasicos = new HardwareBasico[3];
        hardwaresBasicos[0] = new HardwareBasico("Pentium Core i3", 1200.0f);
        hardwaresBasicos[1] = new HardwareBasico("Memoria RAM", 4.0f);
        hardwaresBasicos[2] = new HardwareBasico("HD", 500.0f);
        computadores[0] = new Computador("Positivo", 1300.0f, "Linux Ubuntu", 32, hardwaresBasicos);
        computadores[0].adicionaMemoriaUSB(new MemoriaUSB("Pendrive", 16));

        hardwaresBasicos[0] = new HardwareBasico("Pentium Core i5", 2260.0f);
        hardwaresBasicos[1] = new HardwareBasico("Memoria RAM", 8.0f);
        hardwaresBasicos[2] = new HardwareBasico("HD", 1000.0f);
        computadores[1] = new Computador("Acer", 1800.0f, "Windows 8", 64, hardwaresBasicos);
        computadores[1].adicionaMemoriaUSB(new MemoriaUSB("Pendrive", 32));

        hardwaresBasicos[0] = new HardwareBasico("Pentium Core i7", 3500.0f);
        hardwaresBasicos[1] = new HardwareBasico("Memoria RAM", 16.0f);
        hardwaresBasicos[2] = new HardwareBasico("HD", 2000.0f);
        computadores[2] = new Computador("Vaio", 2800.0f, "Windows 10", 64, hardwaresBasicos);
        computadores[2].adicionaMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
    }

    public static void criaCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = reader.nextLine();
        System.out.print("Digite o cpf do cliente: ");
        long cpf = reader.nextLong();
        reader.nextLine();
        cliente = new Cliente(nome, cpf);

        System.out.println("Cliente criado com sucesso!");
    }
}
