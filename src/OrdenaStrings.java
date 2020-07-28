import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


public class OrdenaStrings {
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora cada do código");
		palavras.add("caelum");
		
		Comparator<String> comparator = new ComparadorDeStringPorTamanho();
		// Forma antiga de ordenar a lista
		//Collections.sort(palavras, comparator);
		
		//Nova forma de ordenar a lista utilizando o médoto default da interface
		//Default methods: métodos com implementação dentro das interfaces
//		palavras.sort(comparator);
		
		//Agora o Comparator com o Lambda
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		//OU
		palavras.sort((s1, s2) -> s1.length() - s2.length());
		//OU
		palavras.sort(Comparator.comparing(s -> s.length()));
		//OU
		palavras.sort(Comparator.comparing(String::length));
		
		System.out.println(palavras);
		
		//Forma antiga de printar os itens de uma lista
//		for (String p : palavras) {
//			System.out.println(p);
//		}
		
		//Nova forma de printar os itens de uma lista
//		Consumer<String> consumer = new ImprimeNaLinha();
//		palavras.forEach(consumer);
		
		//Classe  anônima, usamos quando não vamos utilizar a classe em outros pontos do código, como foi feito no exemplo anterior
//		palavras.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);		
//			}
//		});
		 
		//Agora com lambda
		// O lambda só funciona para as interfaces que só tem um método abstrato
		palavras.forEach(s -> System.out.println(s));
		//OU
		palavras.forEach(System.out::println);
		
		//Thread com lambda
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
		/*
		 * ### ANOTAÇÕES
		 * Interface Funcional: interface com apenas um método abstrato*/
	}

}

class ComparadorDeStringPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return -1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}

//Consumer
class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);		
	}
	
}