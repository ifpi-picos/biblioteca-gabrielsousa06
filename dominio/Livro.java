package dominio;

public class Livro{
    private String titulo;
    private int ano;
    private String autor;
    private String editora;
    private Boolean disponivel;
    
    public Livro(String titulo, int ano, String autor, String editora, Boolean disponivel){
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.editora = editora;
        this.disponivel = disponivel;
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

    public Boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String toString(){
        return "Livro{" +
                "Título ='" + titulo + '\'' +
                ", Autor ='" + autor + '\'' +
                ", Ano de publicação ='" + ano + '\'' +
                ", Editora =" + editora + '\'' +
                ", Disponivel =" + disponivel +
                '}';
    }
}

