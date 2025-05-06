public class Livro {
    //ATRIBUTOS
    private static int proximoIsbn = 1;
    private int isbn;
    private String titulo;
    private String autor;
    private int ano;
    
    //CONTRUTOR
    public Livro(String titulo, String autor, int ano){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn=proximoIsbn++;
    }
    
    //METODOS getter
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    //MEODOS SETTER
    public void setTitulo(String novoTitulo){
        this.titulo = novoTitulo;
    }
    
    public void setAutor(String novoAutor){
        this.autor = novoAutor;
    }
    
    public void setAno(int novoAno){
        this.ano = novoAno;
    }
}
