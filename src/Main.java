import java.util.Scanner;

import domain.Loader;

public class Main{
    public static void main(String[] args){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        Loader loader = new Loader();
        int opt = 0;
        while(opt != 3){
            loader.LoadLogo();
            System.out.println("\n");
            loader.LoadMenu();
            opt = sc.nextInt();
            loader.MenuHandler(opt);
        }
    }
}