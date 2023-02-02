package tela;

import javax.swing.*;

import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;


public class Screen extends JFrame implements ActionListener {

    private JPanel pnlMain, pnlFooter;
    private JLabel lblName, lblEmail;
    private JLabel lblTel, lblCPF;
    public JLabel lblErroNome, lblErroEmail;
    public JLabel lblErroCpf, lblErroTel;
    private JTextField txtName, txtEmail;
    private JTextField txtTel, txtCPF;
    private JButton btnCadastro;
    private Integer TAMANHO_TXT = 20;


    public Screen() throws ParseException {
        setTitle("Sistema de Cadastro");
        setVisible(true); //Aqui estou deixando a tela que eu quero criar visivel;
        setSize(500, 400); //Tamanho da tela;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Estou falando que, quando eu fechar meu programa, é pra encerrar a operação
        setResizable(false); //Aqui estou falando que ele não pode diminuir o tamanho da tela;
        setLocationRelativeTo(null); //Aqui eu digo que, eu quero que a minha tela, vá para o meio da tela do computador

        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(getPnlMain(), BorderLayout.CENTER);
        getContentPane().add(getPnlFooter(), BorderLayout.PAGE_END);

        pack();
    }


    public JPanel getPnlMain() throws ParseException {
        if (pnlMain == null) {
            pnlMain = new JPanel(new GridLayout(4, 3));

            lblName = new JLabel("Nome: ");
            lblName.setHorizontalAlignment(SwingConstants.CENTER);
            txtName = new JTextField(TAMANHO_TXT);

            lblEmail = new JLabel("Email: ");
            lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
            txtEmail = new JFormattedTextField();

            lblCPF = new JLabel("CPF: ");
            txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));

            lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
            txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));

            lblTel = new JLabel("Telefone: ");
            lblTel.setHorizontalAlignment(SwingConstants.CENTER);
            txtTel = new JFormattedTextField(new MaskFormatter("+## (##) #####-####"));

            lblErroNome = new JLabel("Erro Nome");
            lblErroNome.setHorizontalAlignment(SwingConstants.LEFT);
            lblErroNome.setForeground(new Color(0xF50303));
            lblErroNome.setVisible(false);

            lblErroEmail = new JLabel("Erro Email");
            lblErroEmail.setHorizontalAlignment(SwingConstants.LEFT);
            lblErroEmail.setForeground(new Color(0xF50303));
            lblErroEmail.setVisible(false);


            lblErroCpf = new JLabel("Erro CPF");
            lblErroCpf.setHorizontalAlignment(SwingConstants.LEFT);
            lblErroCpf.setForeground(new Color(0xF50303));
            lblErroCpf.setVisible(false);


            lblErroTel = new JLabel("Erro Telefone");
            lblErroTel.setHorizontalAlignment(SwingConstants.LEFT);
            lblErroTel.setForeground(new Color(0xF50303));
            lblErroTel.setVisible(false);


            pnlMain.add(lblName);
            pnlMain.add(txtName);
            pnlMain.add(lblErroNome);

            pnlMain.add(lblEmail);
            pnlMain.add(txtEmail);
            pnlMain.add(lblErroEmail);

            pnlMain.add(lblCPF);
            pnlMain.add(txtCPF);
            pnlMain.add(lblErroCpf);

            pnlMain.add(lblTel);
            pnlMain.add(txtTel);
            pnlMain.add(lblErroTel);

        }
        return pnlMain;
    }

    public JPanel getPnlFooter() {
        if (pnlFooter == null) {
            pnlFooter = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pnlFooter.setBackground(new Color(0x96BBB0B0, true));
            btnCadastro = new JButton("Cadastrar");
            btnCadastro.setBackground(new Color(0x38D061));
            btnCadastro.setForeground(new Color(0xFFFFFF));
            pnlFooter.add(btnCadastro);

            btnCadastro.addActionListener(this);
        }
        return pnlFooter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ValidacaoEmail validacaoEmail = new ValidacaoEmail();
        ValidacaoNome validacaoNome = new ValidacaoNome();
        ValidacaoCpf validacaoCpf = new ValidacaoCpf();
        ValidacaoTel validacaoTel = new ValidacaoTel();

        //Validação Nome
        validacaoNome.validadoNome(txtName.getText());
        //Validação email
        validacaoEmail.validadoEmail(txtEmail.getText());
        //Validação CPF
        validacaoCpf.validadoCpf(txtCPF.getText());
        //Validação Telefone
        validacaoTel.validadoTel(txtTel.getText());


        //Mostrar msg Error
        if (validacaoNome.erroNome == false) {
            lblErroNome.setVisible(true);
        } else {
            lblErroNome.setVisible(false);
        }

        if (validacaoEmail.erroEmail == false) {
            lblErroEmail.setVisible(true);
        } else {
            lblErroEmail.setVisible(false);
        }

        if (validacaoCpf.erroCpf == false) {
            lblErroCpf.setVisible(true);
        } else {
            lblErroCpf.setVisible(false);
        }

        if (validacaoTel.erroTel == false) {
            lblErroTel.setVisible(true);
        } else {
            lblErroTel.setVisible(false);
        }

        //Mensagem de cadastrado e Limpar inputs
        if (validacaoNome.erroNome && validacaoEmail.erroEmail && validacaoCpf.erroCpf && validacaoTel.erroTel) {

            JOptionPane.showMessageDialog(null, txtName.getText() +"\nCadastrado com sucesso!"
                    , "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            limparInputs();
        }
    }

    public void limparInputs(){
        txtName.setText("");
        txtEmail.setText("");
        txtCPF.setText("");
        txtTel.setText("");
    }
}
