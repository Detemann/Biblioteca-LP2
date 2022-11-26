package geral;

public class FazerDevolucao {
	Auxiliares auxi = new Auxiliares();
	
	public void devolucao() {
		System.out.println("------ Devoluções ------\n");
		System.out.println("Digite a matricula do aluno, professor ou funcionário: ");
		int matricula = auxi.buscaMatricula(ProgramaMain.entrada.next(), 0);
		
		String[] statusEmprestimo = auxi.buscaEmprestimo(matricula, 1);
		if (statusEmprestimo[1].equals("0")) {
			String[] item = auxi.buscaArcevo(statusEmprestimo[0], 0);
			if (item[0].equals("0")) {
				System.out.println("Emprestimo não encontrado.");
				ProgramaMain.menuPrincipal();
			}
			
			System.out.println("FIM");
		} else {
			auxi.buscarMulta(matricula);
		}
		
	}
}
