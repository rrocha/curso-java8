import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Datas {

	public static void main(String[] args) {
		//Data de agora
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		//Quantos anos falta para a olimpiádas
		LocalDate olimpiadasTokio = LocalDate.of(2021, Month.MAY, 5);
		int anos = olimpiadasTokio.getYear() - hoje.getYear();
		System.out.println(anos);
		
		// OU podemos utilizar o Period
		Period periodo = Period.between(hoje, olimpiadasTokio);
		System.out.println(periodo.getYears());
		
		//
		LocalDate proximasOlimpiadas = olimpiadasTokio.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		//Formatar data
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(formatador.format(proximasOlimpiadas));
		
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println(intervalo);
	}

}
