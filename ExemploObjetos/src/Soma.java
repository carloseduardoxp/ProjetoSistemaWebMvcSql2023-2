import java.util.Scanner;

public class Soma {

    // Matematica matematica = new Matematica();
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
       
        int resposta = Matematica.soma(a, b);
        System.out.println(resposta); 

        scanner.close();
    }

   
}
