package tela;

import javax.swing.*;

public class ValidacaoTel {


    public void validadoTel(String telefone) {
        if (telefone.equals("+   (  )      -    ")) {
            JOptionPane.showMessageDialog(null, "Por favor, " +
                    "preencher o telefone corretamente", "Erro no campo Telefone", JOptionPane.ERROR_MESSAGE);
        } else {
         JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        }
    }
}
