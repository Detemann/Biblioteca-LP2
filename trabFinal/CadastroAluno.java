package trabFinal;

import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class CadastroAluno {
	
	Aluno aluno = new Aluno();
	
	public void cadastroAluno() {
		Scanner entrada = new Scanner(System.in).useDelimiter("\n");
		Random ran = new Random();
		
		aluno.setMatricula(ran.nextInt(9999));
		System.out.println("Nome: ");
		aluno.setNome(entrada.next());
		
		System.out.println("Digite o endereço: ");
		aluno.setEndereco(entrada.next());
		
		System.out.println("Digite o curso: ");
		aluno.setCurso(entrada.next());
		
		LocalDate dataHoje = LocalDate.now();
		aluno.setData(dataHoje.toString());
		
		aluno.setMulta(0);
		arquivarAluno();
	}
	
	public void arquivarAluno() {
		try {
			RandomAccessFile arquivo = new RandomAccessFile("csv\\ALUNOS.csv", "rw");
			
			arquivo.seek(arquivo.length());
			arquivo.writeChars(aluno.toString());
			arquivo.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro.");
		}
	}
}
