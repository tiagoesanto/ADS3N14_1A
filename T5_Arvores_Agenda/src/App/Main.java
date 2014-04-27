package App;

import java.io.FileNotFoundException;

import Controller.ListaTelefonicaController;
import View.ConsoleView;

public class Main {

	public static void main(String[] args) 
	{
		// ConsoleView view = new ConsoleView();

		// view.menuPrincipal();
		
		try
		{
			ListaTelefonicaController lista = new ListaTelefonicaController();
		
			lista.iniciaLista();
		}
		catch (FileNotFoundException e)
		{
			System.out.print("ARQUIVO NÃO ENCONTRADO");			
		}
	}

}
