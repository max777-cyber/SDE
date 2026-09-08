import javax.swing.*;

public class CadastroeConsultadeUsuarios {

    static final int MAX_USUARIOS = 5;
    static String[] nomes = new String[MAX_USUARIOS];
    static int[] idades = new int[MAX_USUARIOS];
    static int totalUsuarios = 0;

    public static void main(String[] args) {
        while (true) {
            String[] opcoes = {"1 - Cadastrar usuario", "2 - Listar usuarios", "3 - Buscar por nome", "4 - Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Bem-vindo ao SDE!", "SDE", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            if (escolha == JOptionPane.CLOSED_OPTION || escolha == 3) {
                JOptionPane.showMessageDialog(null, "Encerrando. Ate logo!", "SDE", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            switch (escolha) {
                case 0 -> cadastrarUsuario();
                case 1 -> listarUsuarios();
                case 2 -> buscarUsuario();
            }
        }
    }

    static void cadastrarUsuario() {
        if (totalUsuarios >= MAX_USUARIOS) {
            JOptionPane.showMessageDialog(null, "Limite atingido!", "SDE", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String nome = JOptionPane.showInputDialog(null, "Nome do usuario:", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
        if (nome == null || nome.trim().isEmpty()) return;
        String idadeStr = JOptionPane.showInputDialog(null, "Idade:", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
        if (idadeStr == null) return;
        try {
            int idade = Integer.parseInt(idadeStr.trim());
            nomes[totalUsuarios] = nome.trim();
            idades[totalUsuarios] = idade;
            totalUsuarios++;
            JOptionPane.showMessageDialog(null, "Cadastrado! Nome: " + nome + " | Idade: " + idade, "SDE", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Idade invalida.", "SDE", JOptionPane.ERROR_MESSAGE);
        }
    }

    static void listarUsuarios() {
        if (totalUsuarios == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum usuario cadastrado.", "Listar", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder("Usuarios cadastrados:
");
        for (int i = 0; i < totalUsuarios; i++) sb.append((i+1) + ". " + nomes[i] + " - " + idades[i] + " anos
");
        JOptionPane.showMessageDialog(null, sb.toString(), "Listar", JOptionPane.INFORMATION_MESSAGE);
    }

    static void buscarUsuario() {
        String busca = JOptionPane.showInputDialog(null, "Nome para buscar:", "Buscar", JOptionPane.PLAIN_MESSAGE);
        if (busca == null) return;
        for (int i = 0; i < totalUsuarios; i++) {
            if (nomes[i].equalsIgnoreCase(busca.trim())) {
                JOptionPane.showMessageDialog(null, "Encontrado: " + nomes[i] + ", " + idades[i] + " anos", "Buscar", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario nao encontrado.", "Buscar", JOptionPane.WARNING_MESSAGE);
    }
}
