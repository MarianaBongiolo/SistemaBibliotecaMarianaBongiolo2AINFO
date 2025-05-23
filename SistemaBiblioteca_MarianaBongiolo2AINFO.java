import java.util.Scanner;

public class SistemaBiblioteca_MarianaBongiolo2AINFO {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(); //Cria o objeto biblioteca
        Scanner scanner = new Scanner(System.in); //scanner para ler as entradas digitadas pelo usuario

        while (true) { //laço while para criar um looping, menu repetitivo, que só fechará quando o usuario digitar 9
            System.out.println("\n*** Sistema de Biblioteca ***");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuario");
            System.out.println("3 - Cadastrar Administrador");
            System.out.println("4 - Emprestar Livro");
            System.out.println("5 - Devolver Livro");
            System.out.println("6 - Listar Livros");
            System.out.println("7 - Listar Usuarios");
            System.out.println("8 - Listar Administradores");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opcao: ");

            int opcao = scanner.nextInt(); //lê a opcao digitadda pelo usuario
            scanner.nextLine();

            if (opcao == 9) { //o programa encerra quando o usuario digitar a opcao 9
                System.out.println("Sistema finalizado!");
                break;
            }

            if (opcao < 1 || opcao > 9) { //se o usuario não inserir um numero de 1 a 9, sera imprimida uma mensagem informando que o opcao é invalida
                System.out.println("Opcao Invalida!");
                continue;
            }

            switch (opcao) {
                case 1: //lê os dados informados pelo usuario e chama cadastrarLivro para amarzenar esses dados
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    String resultadoLivro = biblioteca.cadastrarLivro(titulo, autor, ano);
                    System.out.println(resultadoLivro);
                    break;

                case 2: //lê os dados informados pelo usuario e chama cadastrarUsuario para amarzenar esses dados
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    String resultadoUsuario = biblioteca.cadastrarUsuario(nome, email);
                    System.out.println(resultadoUsuario);
                    break;

                case 3: //lê os dados informados pelo usuario e chama cadastrarAdministrador para amarzenar esses dados
                    System.out.print("Nome: ");
                    String admNome = scanner.nextLine();
                    System.out.print("Email: ");
                    String admEmail = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();

                    String resultadoAdmin = biblioteca.cadastrarAdmin(admNome, admEmail, cargo);
                    System.out.println(resultadoAdmin);
                    break;

                case 4: //Recebe o isbn e o id do usuario para que consiga executar o metodo emprestarLivro
                    System.out.print("ISBN do livro para emprestimo: ");
                    int isbnEmprestimo = scanner.nextInt();
                    System.out.print("ID do usuario: ");
                    int usuarioIdEmprestimo = scanner.nextInt();
                    scanner.nextLine();

                    biblioteca.emprestarLivro(isbnEmprestimo, usuarioIdEmprestimo);
                    break;

                case 5: //recebe o isbn do livro para fazer a devolução dele utilizando o metodo devolverLivro
                    System.out.print("ISBN do livro para devolucao: ");
                    int isbnDevolucao = scanner.nextInt();
                    scanner.nextLine();

                    biblioteca.devolverLivro(isbnDevolucao);
                    break;

                    //CaSO 6 E 7 NÃO ESTÃO FUNCIONANDO
                case 6:
                    System.out.println("=== Lista de Livros ===");
                    biblioteca.listarLivros();
                    break;

                case 7:
                    System.out.println("=== Lista de Usuarios ===");
                    biblioteca.listarUsuarios();
                    break;

                case 8: //lista os administradores atraves do metodo listarAdmnistradores e os imprime na tela
                    System.out.println("=== Lista de Administradores ===");
                    biblioteca.listarAdministradores();
                    break;
            }
        }

        scanner.close();
    }
}
