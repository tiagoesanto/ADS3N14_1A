package Estruturas;

public class Nodo<T> {
	private T chave;
	private Nodo<T> proximo;
	
	public Nodo()
	{
		chave = null;
		proximo = null;
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public Nodo<T> getProximo() {
		return proximo;
	}

	public void setProximo(Nodo<T> proximo) {
		this.proximo = proximo;
	}
}