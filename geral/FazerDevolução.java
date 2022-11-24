package geral;

public class FazerDevolução {
	Auxiliares auxi = new Auxiliares();
	
	public void devolucao() {
		System.out.println("------ Devoluções ------\n");
		System.out.println("Digite a matricula do aluno, professor ou funcionário: ");
		int matricula = auxi.buscaMatricula(ProgramaMain.entrada.next(), 0);
		
		
	}
}
