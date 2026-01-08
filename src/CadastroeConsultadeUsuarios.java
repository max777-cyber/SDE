import java.util.Scanner;

public class CadastroeConsultadeUsuarios {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nomes = new String[5];
        int[] idades = new int[5];
        int totalUsuarios = 0;
        int menu;

        do {
            System.out.println("\n1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar usuário pelo nome");
            System.out.println("4 - Sair");

            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {

                case 1:
                    if (totalUsuarios >= 5) {
                        System.out.println("Limite de usuários atingido.");
                    } else {
                        System.out.print("Insira o nome do usuário: ");
                        nomes[totalUsuarios] = scanner.nextLine();

                        System.out.print("Insira a idade: ");
                        idades[totalUsuarios] = scanner.nextInt();
                        scanner.nextLine();

                        totalUsuarios++;
                        System.out.println("Usuário cadastrado com sucesso!");
                    }
                    break;
                case 3:
                	
                    if (totalUsuarios == 0) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.print("Digite o nome para buscar: ");
                        String nomeBuscado = scanner.nextLine();

                        boolean encontrado = false;

                        for (int i = 0; i < totalUsuarios; i++) {
                            if (nomes[i].equalsIgnoreCase(nomeBuscado)) {
                                System.out.println("Usuário encontrado!");
                                System.out.println("Nome: " + nomes[i]);
                                System.out.println("Idade: " + idades[i]);
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Usuário não encontrado.");
                        }
                    }
                    break;


                case 2:
                    if (totalUsuarios == 0) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("\n--- Lista de Usuários ---");
                        for (int i = 0; i < totalUsuarios; i++) {
                            System.out.println(
                                (i + 1) + " - Nome: " + nomes[i] + ", Idade: " + idades[i]
                            );
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (menu != 4);

        scanner.close();
    }
}
