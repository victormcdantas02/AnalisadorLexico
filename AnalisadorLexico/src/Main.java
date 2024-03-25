import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnalisadorLexico analisador = new AnalisadorLexico();
        String codigoFonte = "int main() { println(\"Olá, mundo!\"); return 0; }";
        List<Token> tokens = analisador.analisar(codigoFonte);

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
