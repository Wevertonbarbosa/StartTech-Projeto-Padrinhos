package tela;

import javax.swing.*;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoEmail {

    boolean erroEmail;


    public boolean verificar_email(String email) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mat = patron.matcher(email);

        return mat.find();
    }

    public void validadoEmail(String email) {


        if (!verificar_email(email)) {
            erroEmail = false;
        } else {
            erroEmail = true;
        }


    }


}

