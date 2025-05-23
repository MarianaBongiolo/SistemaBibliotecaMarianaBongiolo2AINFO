public class Administrador {
    
    //ATRIBUTOS
    private static int proximoId = 1;
    private int id;
    private String nome;
    private String email;
    private String cargo;

    //CONSTRUDOR 
    public Administrador(String nome, String email, String cargo) {
        this.id = proximoId++;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    //METODOS GETTER
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCargo() {
        return this.cargo;
    }
    
    //METODO SETTER
    public void setCargo(String novoCargo){
        this.cargo = novoCargo;
    }
    
    //METODO PARA EXIBIR AS INFORMAÇÕES DO ADMINISTRADOR
    public void exibir() { //Método para exibir a lista de Administradores
        System.out.println("Administrador: " + nome + " | ID: " + id + " | Email: " + email + " | Cargo: " + cargo);
    }
}
