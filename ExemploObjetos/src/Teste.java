public class Teste {

    public static void main(String args[]) {
        int[] vetor = new int[5];
        for (int i = 0; i < vetor.length;i++) {
            System.out.println(vetor[i]);
        }

        for (int valor: vetor) {
            System.out.println(valor);
        }
    }
    
}
