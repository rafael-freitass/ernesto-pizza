package domain;

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

    public static void LoadPizza(){
        Pizza p1 = new Pizza("Calabresa", "Calabresa", new String[] {"Mussarela"}, "M", 0)
    }

    public static void LoadBebida(){
       
    }

    public static void LoadCardapio(){
       
    }

    public static int MenuHandler(int opt){
        clearScreen();

        return 0;
    }
}
