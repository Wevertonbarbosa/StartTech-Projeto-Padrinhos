package tela;

import javax.swing.*;

import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;


    public class Screen extends JFrame implements ActionListener {

        private JPanel pnlMain;
        private JPanel pnlFooter;
        private JLabel lblName;
        private JLabel lblEmail;
        private JLabel lblTel;
        private JLabel lblCPF;
        private JTextField txtName;
        private JTextField txtEmail;
        private JTextField txtTel;
        private JTextField txtCPF;
        private JButton btnCadastro;
        private Integer TAMANHO_TXT = 23;



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
            if (pnlMain == null){
                pnlMain = new JPanel(new GridLayout(4,2));

                lblName = new JLabel("Nome: ");
                lblName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName = new JTextField(TAMANHO_TXT);

                lblEmail =  new JLabel("Email: ");
                lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
                txtEmail = new JFormattedTextField();

                lblCPF = new JLabel("CPF: ");
                txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));

                lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
                txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));

                lblTel = new JLabel("Telefone: ");
                lblTel.setHorizontalAlignment(SwingConstants.CENTER);
                txtTel =  new JFormattedTextField(new MaskFormatter("+## (##) #####-####"));

                pnlMain.add(lblName);
                pnlMain.add(txtName);

                pnlMain.add(lblEmail);
                pnlMain.add(txtEmail);

                pnlMain.add(lblCPF);
                pnlMain.add(txtCPF);

                pnlMain.add(lblTel);
                pnlMain.add(txtTel);
            }
            return pnlMain;
        }

        public JPanel getPnlFooter() {
            if (pnlFooter == null){
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


        }
}
