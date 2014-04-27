package Estruturas;



public class ListaOrdenada<T extends Comparable<T>>
				extends ListaEncadeada<T>
{	
	public Nodo<T> procuraNodo(Nodo<T> needle)
	{
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		T chaveNeedle = needle.getChave();
		
		while (atual != null) {
			T chaveAtual = atual.getChave();
			int cmp = chaveNeedle.compareTo(chaveAtual);
			if (cmp == 0)
				return atual; 
			if (cmp < 0)
				return anterior;
			anterior = atual;
			atual = atual.getProximo();
		}
		return anterior;
	}
	
	@Override
	public void append(Nodo<T> novo)
	{
		inserir(novo);
	}
	
	@Override
	public void inserir(Nodo<T> novo, Nodo<T> anterior)
	{
		inserir(novo);
	}
	
	@Override
	public void inserir(Nodo<T> novo)
	{
		Nodo<T> anterior = procuraNodo(novo);
		
		if (anterior == null) {
			novo.setProximo(head);
			head = novo;
			if (tail == null)
				tail = novo;
		} else {
			novo.setProximo(anterior.getProximo());
			anterior.setProximo(novo);
			if (tail == anterior)
				tail = novo;
		}		
	}
	
	public Nodo<T> getAnterior(Nodo<T> needle)
	{
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		T chaveNeedle = needle.getChave();
		
		while (atual != null) {
			T keyCurrent = atual.getChave();
			int cmp = chaveNeedle.compareTo(keyCurrent);
			
			if (cmp == 0)
			{
				return anterior;
			}
			if (cmp < 0)
			{
				return anterior;
			}
			
			anterior = atual;
			atual = atual.getProximo();
		}
		return anterior;
	}
}
