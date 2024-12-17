package biblioteca.dominio;

public class Livro{
    private String titulo;
    private int ano;
    private String autor;
    private String editora;
    private Boolean emprestado;
    
    public Livro(String titulo, int ano, String autor, String editora, Boolean emprestado){
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.editora = editora;
        this.emprestado = emprestado;
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }
}

