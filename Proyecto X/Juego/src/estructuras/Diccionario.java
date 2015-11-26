package estructuras;
import java.util.LinkedList;

/**
 * Clase Diccionario
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Diccionario<K,V> {

	//Atributos
	protected LinkedList<Par<K,V>> lista;


	//construtor
	/**
	 * Constructor de la clase.
	 */
	public Diccionario(){
		lista=new LinkedList<Par<K,V>>();
	}

	//comandos y consultas
	/**
	 * Retorna la cantidad de elementos del diccionario.
	 * @return Cantidad de elementos del diccionario.
	 */
	public int size(){
		return lista.size();
	}

	/**
	 * Decide si el diccionario está vacío o no.
	 * @return True si el diccionario está vacío, false en caso contrario.
	 */
	public boolean isEmpty(){
		return lista.isEmpty();
	}

	/**
	 * Retorna el par asociado a la clave pasada por parámetro. Null si el par no existe.
	 * @param key Clave del par buscado.
	 * @return Par con clave key.
	 */
	public Par<K,V> find(K key){

		for (int i=0; i<lista.size(); i++){
			if (lista.get(i).getKey().equals(key))
				return lista.get(i);
		}
		return null;

	}

	/**
	 * Inserta un par con clave key y valor value.
	 * @param key Clave del nuevo par.
	 * @param value Valor del nuevo par.
	 */
	public void insert (K key, V value) {

		Par<K,V> e=new Par<K,V>(key,value);
		lista.add(e);
	}

	/**
	 * Elimina el par pasado por parámetro del diccionario.
	 * @param e Par a eliminar.
	 * @return Boolean indicando si se eliminó correctamente o no.
	 */
	public boolean remove(Par<K,V> e) {

		return lista.remove(e);
	}
}
