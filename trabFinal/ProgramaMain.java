package trabFinal;

public class ProgramaMain {

	public static void main(String[] args) {

		//MENU DE ESCOLHA
		System.out.println("\n=============== ALGUM NOME ===============");
		int op = 0;
		while (op != 9) {
			System.out.println("Informe o opcao desejada\n"
					+ "[1] Funcao1\n"
					+ "[2] Funcao2\n"
					+ "[3] Funcao3\n"
					+ "[4] Funcao4\n"
					+ "[5] Funcao5\n"
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

}
