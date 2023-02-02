package tela;

import javax.swing.*;
import java.text.ParseException;

public class ValidacaoCpf {

    boolean erroCpf;

    public void validadoCpf(String cpf) {

        if (cpf.equals("   .   .   -  ")) {
            erroCpf = false;
        } else {
            erroCpf = true;
        }
    }
}
