package trabFinal;

public class Livros {
	private String titulo;	
	private String autores;
	private int codigo;
	private int anoDePubli;
	private String editora;
	private char tipo;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getAnoDePubli() {
		return anoDePubli;
	}
	public void setAnoDePubli(int anoDePubli) {
		this.anoDePubli = anoDePubli;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
}
