import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {
	
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
		
}


public class ExemploCursos {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		//Imprimir apenas os cursos com mais de 100 alunos
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.forEach(c -> System.out.println(c.getNome()));
		
		//Mostrar quantos alunos tem nos cursos com mais de 100 alunos
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.forEach(System.out::println);
		
		//Soma da quantidade dos alunos com mais de 100 alunos
		int sum = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos)
				.sum();
		
		System.out.println(sum);
		
		//Calcular a quantidade média de alunos de todos os curso
		OptionalDouble mediaNumeroAlunos = 
				cursos.stream()
				.mapToInt(Curso::getAlunos)
				.average();
		
		System.out.println(mediaNumeroAlunos);
		
		//Trazer algum curso com mais 100 ou mais alunos
		//Optional ajuda para a gente trabalhar com NULL
		Optional<Curso> optionalCurso = 
				cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.findAny(); // Retorna algum curso
		
		//Se existir o curso ele printa algo, se não não printa
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		//Collect: voltar de uma stream para uma collection
		List<Curso> novaListaCursos = 
				cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toList());
		
		System.out.println(novaListaCursos);
		
		//Retornar um Map
		cursos
			.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
	}

}
