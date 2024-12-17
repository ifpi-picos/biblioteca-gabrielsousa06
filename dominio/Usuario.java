package biblioteca.dominio;

public class Usuario {
    private String usuario;
    private String cpf;
    private String email;

    public Usuario(String usuario, String cpf, String email) {
        this.usuario = usuario;
        this.cpf = cpf;
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
