package trabFinal;
import java.util.*;

public class ProgramaMain {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		
		//MENU DE ADM
		System.out.println("\n=============== BIBLIOTECA DO(A) XXXXXXXXXX ===============");
		int op = 0;
		while (op != 9) {
			//PRECISA SER REALIZADO UMA AUTENTICACAO DE USUARIO ANTES DE EXIBIR A TELA DE MENU
			System.out.println("Informe o opcao desejada\n"
					+ "[1] Consultar livros emprestados\n"
					+ "[2] Devolução de Livros\n"
					+ "[3] Cadastrar novos Livros\n"
					+ "[4] Cadastrar novos Usuários\n" //Aluno ou Funcionário
					+ "[5] Relat�rio Geral\n" //Livros cadastrados; Empréstimos realizados; Funcionários cadastrados; Alunos cadastrados; Imprimir multa individual;
					+ "[6] Funcao6");
			
			op = entrada.nextInt();

			switch (op) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 9:
				System.out.println("Fim de programa!");
				break;
			default:
				System.out.println("A opcao informada é inválida!");
				break;
			}
			
		}
		
	}
	//MENU DE USUARIO
	public static void menuUsuarios() {
		System.out.println("\n=============== BIBLIOTECA DO(A) XXXXXXXXXX ===============");
		int op = 0;
		while (op != 9) {
			//PRECISA SER REALIZADO UMA AUTENTICACAO DE USUARIO ANTES DE EXIBIR A TELA DE MENU
			System.out.println("Informe o opcao desejada\n"
					+ "[1] Empréstimo de livros\n"
					+ "[2] Devolução de Livros\n"
					+ "[3] Consultar multa\n"
					+ "[4] Retornar ao menu principal");					
			op = entrada.nextInt();

			switch (op) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;			
			case 4:
				System.out.println("Fim do programa!");
				break;
			default:
				System.out.println("A opcao informada é inválida!");
				break;
			}
			
		}
	}
}
