package Estruturas;

import java.util.ArrayList;

import Model.Pessoa;

public class ListaEmArray {
	
	ArrayList<Nodo<Pessoa>> lista = new ArrayList<Nodo<Pessoa>>();

	/**
	 * Método Construtor
	 * @param sorted A sorted list
	 */
	public ListaEmArray(ListaOrdenada<Pessoa> listaOrdenada)
	{
		Nodo<Pessoa> atual = listaOrdenada.getHead();

		// Create an ArrayList out of a sorted list
		while(atual != null)
		{
			lista.add(atual);
			atual = atual.getProximo();
		}
	}	

}
