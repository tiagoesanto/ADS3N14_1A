package Controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import View.*;
import Estruturas.*;
import Model.*;

public class ListaTelefonicaController {
	
	
	private Scanner scanner;
	ArvoreBinaria arvore = new ArvoreBinaria<Pessoa>(null);
	private ContatoView view = new ContatoView();

	public ListaTelefonicaController() throws FileNotFoundException
	{
		scanner = new Scanner(new FileReader("PhonebookFiles.txt")).useDelimiter("\\|");
	}

	public void iniciaLista() 
	{
		while (scanner.hasNext())
		{
			Nodo<Pessoa> novo = new Nodo<Pessoa>();
			Pessoa contato = new Pessoa();
			contato.setNome(scanner.next());
			contato.setTelefone(scanner.next());
			novo.setChave(contato);
			arvore.Inserir(novo, contato);
		}
	}
	
}
