import java.util.ArrayList;

public class Biblioteca {
    //ATRIBUTOS - LISTAS QUE VÃO AMaRZENAR OS OBJETOS DO TIPO Livros, Usuario e Administrador
    private ArrayList<Livros> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Administrador> administradores;

    private static final String SENHA_ADMIN_PADRAO = "admin";

    //CONSTRUTOR DA BILIOTECA - incia as listas como vazias
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.administradores = new ArrayList<>();
    }

    
    //METODO PARA CADASTRAR LIVRO 
    public String cadastrarLivro(String titulo, String autor, int ano) {
        
        //VERIFICAR DADOS 
        if (titulo == null
                || titulo.trim().isEmpty()
                || autor == null
                || autor.trim().isEmpty()) {
            return "Erro: Titulo ou autor nao podem ser vazios";
        }

        Livros livro = new Livros(titulo, autor, ano); //cria um objeto Livros
        livros.add(livro);//adiciona a lista livros
        return "Livro " + titulo + " cadastrado com sucesso.";
    }

    //METODO PARA CADASTRAR USUARIO
    public String cadastrarUsuario(String nome, String email) {
        Usuario usuario = new Usuario(nome, email);//cria um objeto Usuario
        usuarios.add(usuario);//adiciona a lista usuarios
        return "Usuario " + nome + " foi cadastrado com sucesso.";
    }

    //METODO PARA CADASTRAR ADMIN
    public String cadastrarAdmin(String nome, String email, String cargo) {
        Administrador admin = new Administrador(nome, email, cargo); //cria um objeto Administrador
        administradores.add(admin);//adiciona a lista administradores
        return "Admin " + nome + " foi cadastrado com sucesso.";
    }

    //METODO PARA EMPRESTAR LIVRO - percorre a lista procurando o isbn do livro, se o livro estiver disponivel o marca como não disponivel e salva o id do usuario, caso contrario exibe uma mensagem dizendo que não está disponivel
    public void emprestarLivro(int isbn, int idUsuario) {
        for (Livros livro : livros) {
            if (livro.getIsbn() == isbn) {
                if (livro.getIsDisponivel()== true) {
                    livro.setIsDisponivel(false);
                    livro.setIdUsuarioEmprestadoPara(idUsuario);
                    System.out.println("Livro emprestado com sucesso.");
                    return;
                } else {
                    System.out.println("Livro não disponível.");
                    return;
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }
    
    //METODO PARA DEVOLVER LIVRO - percorre a lista procurando o isbn do livro, se ele já esta cadastrado é marcado como disponivel e o id do usuario já não esta salvo, se não estiver cadstrado exibe uma mesagem informando
    public void devolverLivro(int isbn) {
        for (Livros livro : livros) {
            if (livro.getIsbn() == isbn) {
                if (livro.getIsDisponivel()==false) {
                    livro.setIsDisponivel(true);
                    livro.setIdUsuarioEmprestadoPara(0);
                    System.out.println("Livro devolvido com sucesso.");
                    return;
                } else {
                    System.out.println("Livro não estava emprestado.");
                    return;
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }

    //METODO PARA BUSCAR USUARIO POR ID - retorna o usuario se o id informado existir
    public Usuario buscarUsuarioPorId(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    //METOdO PARA BUSCAR ADMIN POR ID - retorna o administrador se o id informado existir
    public Administrador buscarAdminPorID(int idAdmin) {
        for (Administrador admin : administradores) {
            if (admin.getId() == idAdmin) {
                return admin;
            }
        }
        return null;
    }

    //METODO PARA VERIFICAR A SENHA
    public boolean autenticarAdmin(String senha) {
        return SENHA_ADMIN_PADRAO.equals(senha);
    }

    //METODO PARA BUSCAR LIVRO POR ISBN - retorna o livro com o isbn especificado
    public Livros buscarLivroPorIsbn(int isbn) {
        for (Livros livro : livros) {
            if (livro.getIsbn() == isbn) {
                return livro;
            }
        }
        return null;
    }
    
    //METODO PARA LISTAR A LISTA DE LIVROS - era para percorer a lista livros e exibir as informações de cada livro registrado
    public void listarLivros() {
        for (Livros livro : livros) {
            livro.exibirInformacoes();
        }
    }
    
    //METODOS PARA LISTAR USUARIOS - semelhante ao anterior, mas percorre a lista usuarios
    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            usuario.exibirInformacoesUsuario();
        }
    }
    
    //METODO PARA LISTAR ADMINISTRADOR 
    public void listarAdministradores() {
        for (Administrador administrador : administradores) {
            administrador.exibir();
        }
    }


}
