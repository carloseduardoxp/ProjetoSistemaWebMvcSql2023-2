import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("Carlos Eduardo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date("01/01/1912",sdf);

        cliente.setDataNascimento(data);
        cliente.setEmail("carloseduardodantas@iftm.edu.br");
        cliente.setSexo(SexoEnum.MASCULINO);
        cliente.setUf("MG");
        cliente.setWebSitePessoal("https://carloseduardoxp.github.io/");
        cliente.setCidade("Uberlândia");
        cliente.setTelefoneCelular("(34)99595-4504");
        
    }
}
