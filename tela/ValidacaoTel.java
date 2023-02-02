package tela;

import javax.swing.*;
import java.text.ParseException;

public class ValidacaoTel {

    boolean erroTel;
    public void validadoTel(String telefone) {

        if (telefone.equals("+   (  )      -    ")) {
            erroTel = false;
        }else {
            erroTel = true;
        }
    }
}
