package domain;

import enums.Tamanho;

import java.util.Arrays;
import java.util.Scanner;

public class Loader {
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

    public void LoadMenu(){
        System.out.println("Realize seu pedido aqui:");
        System.out.println("-------------- ###### --------------");
        System.out.println("[1] Ver cardápio");
        System.out.println("[2] Realizar Pedido");
        System.out.println("[3] Sair");
        System.out.println("-------------- ###### --------------");
    }

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

    // Mostra o cardapio
    public void LoadCardapio(){
        clearScreen();
        Pizza[] PizzaList = LoadPizza();
        Bebida[] BebidaList = LoadBebida();
        Scanner sc = new Scanner(System.in);
        int voltar = 0;
        char[] tamanhos = {'P', 'M', 'G'};
        Tamanho medium = Tamanho.M;
        Tamanho large = Tamanho.G;

        while(voltar != 1) {
            System.out.println("---------- Pizzas ----------");
            for (int i = 0; i < PizzaList.length; i++) {
                System.out.println("\n---------****--------");
                System.out.println("Sabor: " + PizzaList[i].sabor + "\n" + "Ingredientes: " + Arrays.toString(PizzaList[i].ingredientes) + "\t");
                System.out.print("P: R$" + PizzaList[i].calcularPreco(Tamanho.P) + " " + "M: R$" + PizzaList[i].calcularPreco(Tamanho.M) + " " + "G: R$" + PizzaList[i].calcularPreco(Tamanho.G) + "\n");
                System.out.println("---------------------\n");
            }

            System.out.println("\n-------- Bebidas --------");
            for (int i = 0; i < BebidaList.length; i++) {
                System.out.println(BebidaList[i].nome + "\tPreço: " + BebidaList[i].preco);
            }

            System.out.println("[1] Voltar");
            voltar = sc.nextInt();
        }
    }

    public void FazerPedido(){
        Pizza[] PizzaList = LoadPizza();
        Bebida[] BebidaList = LoadBebida();

        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione uma pizza:");
        for (int i = 0; i < PizzaList.length; i++) {
            System.out.println("[" + (i + 1) + "] " + PizzaList[i].sabor);
        }
        int escolhaPizza = sc.nextInt();
        if (escolhaPizza < 1 || escolhaPizza > PizzaList.length) {
            System.out.println("Escolha inválida!");
            return;
        }

        System.out.println("Selecione o tamanho: [P] Pequeno, [M] Médio, [G] Grande");

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
            return;
        }

        System.out.println("Selecione uma Bebida");
        for (int i=0; i < BebidaList.length; i++){
            System.out.println("[" + (i + 1) + "]" + BebidaList[i].nome);
        }
        int escolhaBebida = sc.nextInt();
        if (escolhaBebida < 1 || escolhaBebida > BebidaList.length) {
            System.out.println("Escolha inválida!");
            return;
        }

        Pizza pizzaEscolhida = PizzaList[escolhaPizza - 1];
        double preco = pizzaEscolhida.calcularPreco(tamanhoSelecionado);
        Bebida bebidaEscolhida = BebidaList[escolhaBebida - 1];

        double precoTotal = preco + bebidaEscolhida.preco;

        System.out.println("----Pedido----");
        System.out.println(pizzaEscolhida.sabor + " - Tamanho " + tamanhoSelecionado + " - Preço: R$" + preco);
        System.out.println(bebidaEscolhida.nome + "- Preço: R$" + bebidaEscolhida.preco);
        System.out.println("Total: R$" + precoTotal);

        // Essa lógica só deixa pedir 1 pizza e 1 bebida, talves fazer um loop while e uma opção de finalizar
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
