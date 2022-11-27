package geral;

public class FazerDevolucao {
	Auxiliares auxi = new Auxiliares();
	
	public void devolucao() {
		System.out.println("------ Devoluções ------\n");
		System.out.println("Digite a matricula do aluno, professor ou funcionário: ");
		int matricula = auxi.buscaMatricula(ProgramaMain.entrada.next(), 0);
		
		String[] statusEmprestimo = auxi.buscaEmprestimo(matricula, 1);
		if (statusEmprestimo[1].equals("0")) {
			Integer[] codigoItem = auxi.buscaItem(Integer.parseInt(statusEmprestimo[0]));
			String[] item = auxi.buscaArcevo(String.valueOf(codigoItem[0]), codigoItem[1]);
			auxi.setDisponibilidade(item, codigoItem[1]);
			System.out.println("FIM");
		} else {
			auxi.buscarMulta(matricula);
		}
		
	}
}
