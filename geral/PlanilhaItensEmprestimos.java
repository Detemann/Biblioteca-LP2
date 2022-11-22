package geral;

public class PlanilhaItensEmprestimos {
	private int codigoItem;
	private int codigoEmprestimo;
	private int codigoLivro;
	private int codigoPeriodico;
	private String dataDevolucao;
	
	public int getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(int codigoItem) {
		this.codigoItem = codigoItem;
	}
	public int getCodigoEmprestimo() {
		return codigoEmprestimo;
	}
	public void setCodigoEmprestimo(int codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}
	public int getCodigoLivro() {
		return codigoLivro;
	}
	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
	public int getCodigoPeriodico() {
		return codigoPeriodico;
	}
	public void setCodigoPeriodico(int codigoPeriodico) {
		this.codigoPeriodico = codigoPeriodico;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String toString() {
		return codigoItem+";"+codigoEmprestimo+";"+codigoLivro+";"+codigoPeriodico+";"+dataDevolucao;
	}
}
