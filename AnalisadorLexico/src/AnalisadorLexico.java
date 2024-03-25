import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalisadorLexico {

    private static final String[] PALAVRAS_RESERVADAS = {
            "int", "float", "char", "boolean", "void", "if", "else", "for", "while", "scanf", "println", "main", "return"
    };

    public List<Token> analisar(String codigoFonte) {
        List<Token> tokens = new ArrayList<>();
        String[] linhas = codigoFonte.split("\n");

        for (String linha : linhas) {
            // Ajuste para não dividir por espaços, mas sim analisar a linha inteira
            // e identificar tokens com base em expressões regulares.
            Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+|[a-zA-Z_][a-zA-Z0-9_]*|\\\".*?\\\"|//.*|[=+\\-*/%&|!><]=]|[(),;{}\\[\\]]");
            Matcher matcher = pattern.matcher(linha);

            while (matcher.find()) {
                String tokenStr = matcher.group();
                if (tokenStr.matches("\\d+\\.\\d+")) {
                    tokens.add(new Token(TipoToken.NUM_DEC, tokenStr));
                } else if (tokenStr.matches("\\d+")) {
                    tokens.add(new Token(TipoToken.NUM_INT, tokenStr));
                } else if (tokenStr.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                    tokens.add(new Token(TipoToken.ID, tokenStr));
                } else if (tokenStr.matches("\".*?\"")) {
                    tokens.add(new Token(TipoToken.TEXTO, tokenStr));
                } else if (tokenStr.startsWith("//")) {
                    tokens.add(new Token(TipoToken.COMENTARIO, tokenStr));
                } else if (Arrays.asList(PALAVRAS_RESERVADAS).contains(tokenStr)) {
                    tokens.add(new Token(TipoToken.PALAVRAS_RESERVADAS, tokenStr));
                } else if (tokenStr.matches("[=+\\-*/%&|!><]=]")) {
                    tokens.add(new Token(TipoToken.OPERADOR, tokenStr));
                } else if (tokenStr.matches("[(),;{}\\[\\]]")) {
                    tokens.add(new Token(TipoToken.SIMBOLO_ESPECIAL, tokenStr));
                } else {
                    System.out.println("Token inválido encontrado: " + tokenStr);
                }
            }
        }

        return tokens;
    }
}
