package trabFinal;

public class Periodicos {
	private int codigo;	
	private String autores;	
	private String titulo;
	private int  issn;
	private char tipo;
	private double fatorDeImpacto;
	
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
	public int getIssn() {
		return issn;
	}
	public void setIssn(int issn) {
		this.issn = issn;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public double getFatorDeImpacto() {
		return fatorDeImpacto;
	}
	public void setFatorDeImpacto(double fatorDeImpacto) {
		this.fatorDeImpacto = fatorDeImpacto;
	}
	public String toString() {
		return codigo+";"+autores+";"+titulo+";"+tipo+";"+fatorDeImpacto+";"+issn;
	}
	
}	
