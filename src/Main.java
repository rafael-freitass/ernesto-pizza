import java.util.Scanner;

import domain.Loader;

public class Main{
    public static void main(String[] args){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        while(opt != 3){
            Loader.LoadLogo();
            System.out.println("\n");
            Loader.LoadMenu();
            opt = sc.nextInt();
            Loader.MenuHandler(opt);
        }
    }
}