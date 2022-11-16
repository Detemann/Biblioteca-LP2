package trabFinal;

public class Periodicos {
	private int codigo;	
	private String autores;	
	private String titulo;
	private char  issn;
	private char tipo;
	private int fatorDeImpacto;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public char getIssn() {
		return issn;
	}
	public void setIssn(char issn) {
		this.issn = issn;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public int getFatorDeImpacto() {
		return fatorDeImpacto;
	}
	public void setFatorDeImpacto(int fatorDeImpacto) {
		this.fatorDeImpacto = fatorDeImpacto;
	}
	
	
}	
