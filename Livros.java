public class Livros {
    
    //ATRIBUTOS
    private static int proximoIsbn = 1;
    private int isbn;
    private String titulo;
    private String autor;
    private int ano;
    private boolean isDisponivel;
    private int idUsusarioEmprestadoPara;

    
    //CONSTRUTOR
    public Livros(String titulo, String autor, int ano) {
        this.isbn = proximoIsbn++;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isDisponivel = true;
        this.idUsusarioEmprestadoPara = 0;
    }

    //METODOS GETTER
    public int getIsbn() {
        return this.isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAno() {
        return this.ano;
    }

    public boolean getIsDisponivel() {
        return this.isDisponivel;
    }

    //METODOS SETTER
    public void setTitulo(String novoTitulo) {
        this.titulo = novoTitulo;
    }

    public void setAutor(String novoAutor) {
        this.autor = novoAutor;
    }

    public void setAno(int novoAno) {
        this.ano = novoAno;
    }

    public void setIsDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    public void setIdUsuarioEmprestadoPara(int idUsuario) {
        this.idUsusarioEmprestadoPara = idUsuario;
    }

    //METODO PARA EXIBIR AS INFORMAÇÕES DO LIVRO
    public String exibirInformacoes() {
        String info = "Livro - ISBN=" + isbn + ", Titulo=" + titulo + ", Autor=" + autor + ", Ano=" + ano + ", Disponivel=" + (isDisponivel ? "Sim" : "Não");
        if (!isDisponivel && idUsusarioEmprestadoPara != 0) {
            info += ", Emprestado para ID Usuario: " + idUsusarioEmprestadoPara;
        }
        return info;
    }
}
