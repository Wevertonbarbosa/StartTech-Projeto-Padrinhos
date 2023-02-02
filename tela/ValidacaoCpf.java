package tela;

import javax.swing.*;

public class ValidacaoCpf {

    public boolean isValidCpf = false;
    public void validadoCpf(String cpf) {

        if (cpf.equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "Por favor, " +
                    "preencher CPF corretamente.", "Erro no campo CPF", JOptionPane.ERROR_MESSAGE);
        }else{
            isValidCpf = true;
        }

    }
}
