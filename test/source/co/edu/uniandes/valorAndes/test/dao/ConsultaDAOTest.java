/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 
 * Ejercicio: ValorAndes
 * Autor: David Ricardo Mayorga - 13-Septiembre-2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.valorAndes.test.dao;

import junit.framework.TestCase;
import co.edu.uniandes.valorAndes.dao.*;


public class ConsultaDAOTest extends TestCase
{

	// - Atributos ----------------------------------------------
	
	
	private ConsultaDAO baseDeDatos;
	
	/**
	 * 
	 * 1. Pruebas de unicidad de tuplas. Para cada tabla,
a. Inserte una tupla 1 con una PK conocida y nueva
b. Inserte una tupla 2, con la misma PK que la tupla 1
c. Haga las pruebas de resultados de la inserción del primer registro y del segundo registro.
2. Pruebas de integridad con FK
a. Inserte una tupla 1 que tenga una FK que se encuentra en la tabla referenciada
b. Inserte una tupla 1 que tenga una FK que no se encuentra en la tabla referenciada
c. Haga las pruebas de inserción para cada caso
d. Haga pruebas de borrado de tuplas maestras y dependientes.
3. Pruebas de integridad de acuerdo con restricciones de chequeo
a. Inserte tuplas que cumplen con las restricciones de chequeo establecidas
b. Inserte tuplas que violan las restricciones de chequeo establecidas
c. Haga las pruebas de inserción y borrado correspondientes.
	 
	 */
	
	
	// - Metodos ----------------------------------------------

	 private void setupEscenario1( )
	    {
		 	baseDeDatos = new ConsultaDAO( );

	       // Agrega 12 palabras con traducción en inglés
	       //baseDeDatos.inicializar(path);
	    
	    }
	
}
