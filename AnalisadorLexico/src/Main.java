import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnalisadorLexico analisador = new AnalisadorLexico();
        String codigoFonte = "int main() { println(\"Olá, mundo!\"); return 0; }";
        codigoFonte = "int main() { int numero1 = 123; int numero2 = 456; int resultado = numero1 + numero2; return resultado; } float calcularMedia(float nota1, float nota2) { float media = (nota1 + nota2) / 2.0; if (media >= 6.0) { println(\"Aprovado!\"); } else { println(\"Reprovado.\"); } return media; } void saudacao() { char mensagem[] = \"Olá, mundo!\"; int numero = 42; println(mensagem); println(\"O número é: \" + numero); } int dobrar(int x) { return x * 2; } void imprimirValores(int valores[]) { for (int i = 0; i < valores.length; i++) { println(\"Valor[\" + i + \"] = \" + valores[i]); } }\n";
        List<Token> tokens = analisador.analisar(codigoFonte);

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
