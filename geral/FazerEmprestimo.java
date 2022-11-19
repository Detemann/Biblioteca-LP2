package geral;

import java.util.Random;

public class FazerEmprestimo {
	PlanilhaDeEmprestimos emprestimo = new PlanilhaDeEmprestimos();
	PlanilhaItensEmprestimos item = new PlanilhaItensEmprestimos();
	Auxiliares auxi = new Auxiliares();
	
	public void emprestimo() {
		Random codigo = new Random();
		emprestimo.setCodigo(codigo.nextInt(10000000, 99999999));
		item.setCodigoEmprestimo(emprestimo.getCodigo());
		
		while(true) {
			System.out.println("Digite a matricula: ");
			int matricula = auxi.buscaMatricula(ProgramaMain.entrada.nextLine());
			if (matricula!=0) {
				break;
			} else {
				System.out.println("Matricula não encontrada!");
			}
		}
		
		
	}
}
