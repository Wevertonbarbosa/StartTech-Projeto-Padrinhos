package tela;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoNome {


    public static boolean validarnome(String nome){
        String regex = "^(?:[\\p{Lu}&&[\\p{IsLatin}]])" +
                "(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])" +
                "(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*" +
                "(?: (?:(?:e|y|de(?:(?: la| las| lo| los))?|do|dos|da|das|del|van|von|bin|le) )?" +
                "(?:(?:(?:d'|D'|O'|Mc|Mac|al\\-))?(?:[\\p{Lu}&&[\\p{IsLatin}]])" +
                "(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+|(?:[\\p{Lu}&&[\\p{IsLatin}]])" +
                "(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])" +
                "(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*))+(?: (?:Jr\\.|II|III|IV))?$";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(nome);

        return m.matches();
    }

    public void validadoNome(String nome){
        if (!validarnome(nome)){
            JOptionPane.showMessageDialog(null, "Por favor, " +
                    "preencher nome completo corretamente.", "Erro no NOME", JOptionPane.ERROR_MESSAGE);
        }else {
            boolean isValidNome = false;
            isValidNome = true;
        }

    }


}
