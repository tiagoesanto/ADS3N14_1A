package Estruturas;


public class ListaEncadeada<T> {

	protected Nodo<T> head;
	protected Nodo<T> tail;

	public ListaEncadeada() {
		head = null;
		tail = null;
	}
	
	public void inserir(Nodo<T> novo)
	{
		novo.setProximo(head);
		head = novo;
		if (tail == null)
			tail = novo;
	}
	
	public void inserir(Nodo<T> novo, Nodo<T> anterior)
	{
		if (anterior == null) {
			novo.setProximo(head);
			head = novo;
			if (tail == null)
				tail = head;
		} else {
			novo.setProximo(anterior.getProximo());
			anterior.setProximo(novo);
			if (anterior == tail)
				tail = novo;
		}
	}
	
	public void append(Nodo<T> novo)
	{
		if (tail != null) {
			tail.setProximo(novo);
		} else {
			head = novo;
		}
		tail = novo;
	}
	
	public Nodo<T> getTail()
	{
		return tail;
	}
	
	public Nodo<T> getHead()
	{
		return head;
	}

}
