package estructuras;

/**
 * Clase Par
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Par<K,V> {
	
	//Atributos
	private K clave;
	private V valor;
	
	/**
	 * Constructor de la clase.Recibe una clave y un valor.
	 * @param k Clave del par
	 * @param v Valor del par asociado a la clave.
	 */
	public Par (K k, V v){
		clave=k;
		valor=v;
	}
	
	/**
	 * Retorna la clave.
	 * @return clave del par.
	 */
	public K getKey(){
		return clave;
	}
	
	/**
	 * Retorna el valor.
	 * @return el valor del par.
	 */
	public V getValue(){
		return valor;
	}
	
	/**
	 * Setea la clave del par con la pasada en el parámetro.
	 * @param k Nueva clave.
	 */
	public void setKey(K k){
		clave=k;
	}
	
	/**
	 * Setea el valor del par con el pasado en el parámetro.
	 * @param v Nuevo valor.
	 */
	public void setValue(V v){
		valor=v;
	}
	
	
}
