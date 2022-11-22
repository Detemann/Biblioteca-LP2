package geral;

public class PlanilhaDeEmprestimos {
	private int codigo;
	private int matriculaCliente;
	private int matriculaFuncionarios;
	private String dataEmprestimo;
	private String dataDevolucao;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getMatriculaCliente() {
		return matriculaCliente;
	}
	public void setMatriculaCliente(int matriculaCliente) {
		this.matriculaCliente = matriculaCliente;
	}
	public int getMatriculaFuncionarios() {
		return matriculaFuncionarios;
	}
	public void setMatriculaFuncionarios(int matriculaFuncionarios) {
		this.matriculaFuncionarios = matriculaFuncionarios;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String toString() {
		return codigo+";"+matriculaCliente+";"+matriculaFuncionarios+";"+dataEmprestimo+";"+dataDevolucao;
	}
}
