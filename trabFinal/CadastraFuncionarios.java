package trabFinal;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CadastraFuncionarios {
Funcionarios funcionario = new Funcionarios();
	
	public void cadastroFuncionario() {
		Scanner ler = new Scanner(System.in).useDelimiter("\n");
		
		System.out.printf("Informe a matrícula do funcionario: ");
		funcionario.setMatricula(Integer.parseInt(ler.nextLine()));
		
		System.out.printf("Informe o nome do funcionario: ");
		funcionario.setNome(ler.nextLine());
		
		System.out.printf("Informe o endereço do funcionario: ");
		funcionario.setEndereco(ler.nextLine());
		
		System.out.printf("Informe o setor do funcionario: ");
		funcionario.setSetor(ler.nextLine());
		
		System.out.printf("Informe a data de ingresso do funcionario: ");
		funcionario.setData(ler.nextLine());
		
		System.out.printf("Informe o login do funcionario: ");
		funcionario.setLogin(ler.nextLine());
		
		System.out.printf("Informe a senha do usuario:  ");
		funcionario.setSenha(ler.nextLine());

		arquivarfuncionario();
	}
	
	public void arquivarfuncionario() {
		try {
			OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("csv\\FUNCIONARIOS.csv", true), "UTF-8");
			escritor.write(System.lineSeparator());
			escritor.write(funcionario.toString());
			System.out.println("Cadastro realizado com sucesso!");
			escritor.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}
}

