import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CadastroAlunos extends JFrame implements ActionListener {
    private JLabel labelNome, labelTelefone, labelEmail, labelCurso;
    private JTextField campoNome, campoTelefone, campoEmail;
    private JComboBox<String> comboCursos;
    private JButton botaoEnviar;
    private DefaultTableModel tableModel;
    private JTable tabela;

    public CadastroAlunos() {
        setTitle("Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Formulário
        JPanel formularioPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        labelNome = new JLabel("Nome:");
        campoNome = new JTextField();

        labelTelefone = new JLabel("Telefone:");
        campoTelefone = new JTextField();

        labelEmail = new JLabel("Email:");
        campoEmail = new JTextField();

        labelCurso = new JLabel("Curso:");
        String[] cursos = {"Magisterio A", "Magisterio B", "Magisterio C", "Magisterio D", "Magisterio E"};
        comboCursos = new JComboBox<>(cursos);

        botaoEnviar = new JButton("Enviar");
        botaoEnviar.addActionListener(this);

        formularioPanel.add(labelNome);
        formularioPanel.add(campoNome);
        formularioPanel.add(labelTelefone);
        formularioPanel.add(campoTelefone);
        formularioPanel.add(labelEmail);
        formularioPanel.add(campoEmail);
        formularioPanel.add(labelCurso);
        formularioPanel.add(comboCursos);
        formularioPanel.add(new JLabel());
        formularioPanel.add(botaoEnviar);

        add(formularioPanel, BorderLayout.NORTH);

        // Tabela
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Email");
        tableModel.addColumn("Curso");

        tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoEnviar) {
            String nome = campoNome.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();
            String cursoSelecionado = (String) comboCursos.getSelectedItem();

            // Adicionando informações à tabela
            tableModel.addRow(new Object[]{nome, telefone, email, cursoSelecionado});

            // Limpando os campos do formulário após o envio
            campoNome.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
            comboCursos.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new CadastroAlunos();
    }
}
