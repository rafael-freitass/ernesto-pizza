package domain;

import enums.Tamanho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Loader {
    private  ArrayList<Pizza> pizzasList = new ArrayList<>();
    private  ArrayList<Bebida> bebidasList = new ArrayList<>();
    private Funcionario funcionario;
    private Cliente cliente;
    private Pedido pedido = new Pedido();

    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void LoadLogo(){
        System.out.println("\n" +
                "  ______                          _           _____  _                 \n" +
                " |  ____|                        | |         |  __ \\(_)                \n" +
                " | |__    _ __  _ __    ___  ___ | |_  ___   | |__) |_  ____ ____ __ _ \n" +
                " |  __|  | '__|| '_ \\  / _ \\/ __|| __|/ _ \\  |  ___/| ||_  /|_  // _` |\n" +
                " | |____ | |   | | | ||  __/\\__ \\| |_| (_) | | |    | | / /  / /| (_| |\n" +
                " |______||_|   |_| |_| \\___||___/ \\__|\\___/  |_|    |_|/___|/___|\\__,_|\n" +
                "                                                                       \n" +
                "                                                                       ");
    }

    public Funcionario LoadFuncionario(){
        return new Funcionario("Rafão", "12345678910", LocalDate.parse("2003-01-31"), "Pizzaiolo");
    }

    public Cliente CadastrarCliente(){
        Scanner sc = new Scanner(System.in);
        Pessoa p1 = CadastrarUsuario();
        System.out.println("Insira seu telefone:");
        String telefone = sc.nextLine();
        System.out.println("Insira seu endereco:");
        String endereco = sc.nextLine();

        return new Cliente(p1.getNome(), p1.getDataNascimento(), telefone, endereco);
    }

    public Pessoa CadastrarUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo!\t Realize seu cadastro para realizar seu pedido!\n");
        System.out.println("Insira seu nome: \t");
        String name = sc.nextLine();
        System.out.println("Insira sua data de nascimento no formato yyyy-MM-dd: \t");
        String birthday = sc.nextLine();
        LocalDate birthdate = LocalDate.parse(birthday);

        return new Pessoa(birthdate, name);
    }

    public void LoadMenu(Funcionario funcionario){
        if(this.cliente == null){
            Cliente usuario = this.CadastrarCliente();
            this.cliente = usuario;
        }
        System.out.println(this.cliente.getNome() + ", realize seu pedido aqui:");
        System.out.println("-------------- ###### --------------");
        System.out.println("[1] Ver cardápio");
        System.out.println("[2] Realizar Pedido");
        System.out.println("[3] Sair");
        System.out.println("-------------- ###### --------------");
        this.funcionario = funcionario;
    }

    // Instancia as pizzas
    public Pizza[] LoadPizza(){
        Pizza p1 = new Pizza("Calabresa", new String[] {"Mussarela", "Calabresa", "Molho de tomate", "Cebola", "Orégano"}, 25);
        Pizza p2 = new Pizza("Mussarela", new String[] {"Mussarela", "Molho de tomate"}, 23);
        Pizza p3 = new Pizza("Marguerita", new String[] {"Mussarela", "Tomate", "Manjericão", "Molho de tomate"}, 20);
        Pizza p4 = new Pizza("Frango com catupiry", new String[] {"Frango desfiado", "Catupiry", "Mussarela", "Molho de tomate"}, 25);

        return new Pizza[]{p1, p2, p3, p4};
    }

    // Instancia as bebidas
    public Bebida[] LoadBebida(){
        Bebida b1 = new Bebida("Coca-Cola", "Refrigerante", 10);
        Bebida b2 = new Bebida("Prats", "Suco", 9);
        Bebida b3 = new Bebida("Chopp Brahma", "Cerveja", 5);

        return new Bebida[]{b1, b2, b3};
    }

    private void exibirPizzas(Pizza[] PizzaList){
        System.out.println("---------- Pizzas ----------");
        for (int i = 0; i < PizzaList.length; i++) {
            System.out.println("\n---------****--------");
            System.out.println("Sabor: " + PizzaList[i].sabor + "\n" +
                    "Ingredientes: " + Arrays.toString(PizzaList[i].ingredientes));
            System.out.print("P: R$" + String.format("%.2f", PizzaList[i].calcularPreco(Tamanho.P)) + " " +
                    "M: R$" + String.format("%.2f", PizzaList[i].calcularPreco(Tamanho.M)) + " " +
                    "G: R$" + String.format("%.2f",PizzaList[i].calcularPreco(Tamanho.G)));
            System.out.println("\n---------------------");
        }
    }

    private void exibirBebidas(Bebida[] BebidaList){
        System.out.println("\n-------- Bebidas --------");
        for (int i = 0; i < BebidaList.length; i++) {
            System.out.println(BebidaList[i].nome + "\tPreço: " + BebidaList[i].preco);
        }
    }

    // Mostra o cardapio
    public void LoadCardapio(){
        clearScreen();
        Pizza[] PizzaList = LoadPizza();
        Bebida[] BebidaList = LoadBebida();
        Scanner sc = new Scanner(System.in);

        int voltar = 0;
        while(voltar != 1) {
            exibirPizzas(PizzaList);
            exibirBebidas(BebidaList);

            System.out.println("[1] Voltar");
            voltar = sc.nextInt();
        }
    }

    public void FazerPedido(){
        clearScreen();
        Pizza[] pizzas = LoadPizza();
        Bebida[] bebidas = LoadBebida();

        Scanner sc = new Scanner(System.in);
        boolean finalizar = false;
        double total = 0;

        while(!finalizar){
            // Escolhe o que vai fazer
            System.out.println("[1] Adicionar pizza ao pedido");
            System.out.println("[2] Adicionar bebida ao pedido");
            System.out.println("[3] Finalizar pedido");
            System.out.println("[4] Cancelar pedido");

            int opcao = sc.nextInt();

            if (opcao == 1){
                total += selecionarPizza(pizzas, sc);
            }
            else if (opcao == 2){
                total += selecionarBebida(bebidas, sc);
            }
            else if (opcao == 3){
                this.pedido.precoTotal = total;
                this.pedido.status = "Preparando";
                mostrarNota(this.pedido);
                finalizar = true;
            }
            else if (opcao == 4){
                System.out.println("Pedido cancelado.");
                finalizar = true;
            }
            else{
                System.out.println("Opção inválida!");
            }
        }
    }

    private double selecionarPizza(Pizza[] pizzas, Scanner sc){
        System.out.println("Selecione uma pizza");
        for (int i = 0; i < pizzas.length; i++) {
            System.out.println("[" + (i + 1) + "] " + pizzas[i].sabor); // loop para printar as opções
        }

        // Escolhe as pizzas
        int escolhaPizza = sc.nextInt();
        if (escolhaPizza < 1 || escolhaPizza > pizzas.length) {
            System.out.println("Escolha inválida!");
            return 0;
        }

        // Escolhe o tamanho das pizzas
        System.out.println("Selecione o tamanho: [P] Pequeno, [M] Médio, [G] Grande");

        // O TAMANHO TA AQUI MAS TEM QUE TA NA PIZZAAAA
        char tamanho = sc.next().toUpperCase().charAt(0);
        Tamanho tamanhoSelecionado;
        if (tamanho == 'P') {
            tamanhoSelecionado = Tamanho.P;
        } else if (tamanho == 'M') {
            tamanhoSelecionado = Tamanho.M;
        } else if (tamanho == 'G') {
            tamanhoSelecionado = Tamanho.G;
        } else {
            System.out.println("Tamanho inválido!");
            return 0;
        }

        pizzas[escolhaPizza - 1].tamanho = tamanhoSelecionado;
        Pizza pizzaEscolhida = pizzas[escolhaPizza - 1];
        double precoPizza = pizzaEscolhida.calcularPreco(tamanhoSelecionado);
        pizzas[escolhaPizza - 1].precoBase = precoPizza;
        pizzasList.add(pizzaEscolhida);
        this.pedido.listaPizzas = pizzasList;

        System.out.println("Adicionado: " + pizzaEscolhida.sabor + " - Tamanho " + tamanhoSelecionado + " - R$" + String.format("%.2f",precoPizza));
        return precoPizza;
    }

    private double selecionarBebida(Bebida[] bebidas, Scanner sc){
        System.out.println("Selecione uma bebida");
        for (int i = 0; i < bebidas.length; i++) {
            System.out.println("[" + (i + 1) + "] " + bebidas[i].nome);
        }
        int escolhaBebida = sc.nextInt();
        if(escolhaBebida < 1 || escolhaBebida > bebidas.length) {
            System.out.println("Escolha invalida");
            return 0;
        }
        Bebida bebidaEscolhida = bebidas[escolhaBebida - 1];
        bebidasList.add(bebidaEscolhida);
        this.pedido.listaBebidas = bebidasList;
        System.out.println("Adicionado: " + bebidaEscolhida.nome + " - R$" + bebidaEscolhida.preco);
        return bebidaEscolhida.preco;
    }

    private void mostrarNota(Pedido pedido){
        System.out.println("Obrigado por comprar com a Ernesto Pizzas! Seu pedido foi recebido com sucesso!");
        System.out.println("O funcionário " + this.funcionario.getNome() + " está preparando tudo com muito carinho :)\n");
        System.out.println("Confira seu pedido abaixo\n\n");
        System.out.println("------ Pedido ------ ");
        System.out.println("*** Pizzas ***");
        for (int i = 0; i < pedido.listaPizzas.size(); i++) {
            System.out.println(" - " + pedido.listaPizzas.get(i).sabor + " - Tamanho " + pedido.listaPizzas.get(i).tamanho + " - R$" + String.format("%.2f", pedido.listaPizzas.get(i).precoBase));
        }
        System.out.println("*** Bebidas ***");
        for (int i = 0; i < pedido.listaBebidas.size(); i++) {
            System.out.println(" - " + pedido.listaBebidas.get(i).nome + " - R$" + pedido.listaBebidas.get(i).preco );
        }
        System.out.println(" Total - " + "R$" + pedido.precoTotal);
        this.limparPedido(pedido.listaPizzas, pedido.listaBebidas);
    }

    private void limparPedido(ArrayList<Pizza> pizzaList, ArrayList<Bebida> bebidasList){
        pizzaList.removeAll(pizzaList);
        bebidasList.removeAll(bebidasList);
    }

    public int MenuHandler(int opt){
        clearScreen();
        if(opt == 1){
            LoadCardapio();
        }
        else if(opt == 2){
            FazerPedido();
        }
        return 0;
    }
}