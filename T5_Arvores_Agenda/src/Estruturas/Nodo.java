package Estruturas;

public class Nodo<T> 
{
	private T chave;
	private Nodo<T> raiz;	
	private Nodo<T> esquerda;
	private Nodo<T> direita;
	
	public Nodo()
	{
		chave = null;
		raiz = null;
		esquerda = null;
		direita = null;
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	public Nodo<T> getDireita() {
		return direita;
	}

	public void setDireita(Nodo<T> direita) {
		this.direita = direita;
	}
	
	public Nodo<T> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Nodo<T> esquerda) {
		this.esquerda = esquerda;
	}	
}