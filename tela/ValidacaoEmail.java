package tela;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoEmail {

    public boolean isValidEmail = false;
    public boolean verificar_email(String email){

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mat = patron.matcher(email);

        return mat.find();
    }

    public void validadoEmail(String email){
        if (!verificar_email(email)){
            JOptionPane.showMessageDialog(null, "Por favor, " +
                    "preencher corretamente o email", "Erro no campo EMAIL", JOptionPane.ERROR_MESSAGE);
        }else {
            isValidEmail = true;
        }


    }




}

