package domain;

import java.util.Arrays;
import java.util.Scanner;

public class Loader {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void LoadLogo(){
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

    public static void LoadMenu(){
        System.out.println("Realize seu pedido aqui:");
        System.out.println("-------------- ###### --------------");
        System.out.println("[1] Ver cardápio");
        System.out.println("[2] Realizar Pedido");
        System.out.println("[3] Sair");
        System.out.println("-------------- ###### --------------");
    }

    public static Pizza[] LoadPizza(){
        Pizza p1 = new Pizza("Calabresa", "Calabresa", new String[] {"Mussarela", "Calabresa", "Molho de tomate", "Cebola", "Orégano"}, 'P', 25);
        Pizza p2 = new Pizza("Mussarela", "Mussarela", new String[] {"Mussarela", "Molho de tomate"}, 'P', 23);
        Pizza p3 = new Pizza("Marguerita", "Marguerita", new String[] {"Mussarela", "Tomate", "Manjericão", "Molho de tomate"}, 'P', 20);
        Pizza p4 = new Pizza("Frango com catupiry", "Frango com catupiry", new String[] {"Frango desfiado", "Catupiry", "Mussarela", "Molho de tomate"}, 'P', 25);

        return new Pizza[]{p1, p2, p3, p4};
    }

    public static Bebida[] LoadBebida(){
        Bebida b1 = new Bebida("Coca-Cola", "Refrigerante", 10);
        Bebida b2 = new Bebida("Prats", "Suco", 9);
        Bebida b3 = new Bebida("Chopp Brahma", "Cerveja", 5);

        return new Bebida[]{b1, b2, b3};
    }

    public static void LoadCardapio(){
        clearScreen();
        Pizza[] PizzaList = LoadPizza();
        Bebida[] BebidaList = LoadBebida();
        Scanner sc = new Scanner(System.in);
        int voltar = 0;

        while(voltar != 1) {
            System.out.println("---------- Pizzas ----------");
            for (int i = 0; i < PizzaList.length; i++) {
                System.out.println("Sabor: " + PizzaList[i].sabor + "\t" + "Ingredientes: " + Arrays.toString(PizzaList[i].ingredientes) + "\t" + "Preco: R$" + PizzaList[i].precoBase);
            }

            System.out.println("\nBebidas");
            for (int i = 0; i < BebidaList.length; i++) {
                System.out.println(BebidaList[i].nome + " " + BebidaList[i].preco + "R$");
            }

            System.out.println("[1] Voltar");
            voltar = sc.nextInt();
        }
    }

    public static double [] PriceHandler(double price){
        return new double[]{0.0};
    }

    public static int MenuHandler(int opt){
        clearScreen();
        if(opt == 1){
            LoadCardapio();
        }
        else if(opt == 2){
            // realizar pedido
        }
        return 0;
    }
}