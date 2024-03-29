package es.antonio.duarte.servicios;

/**
 * Implementacion del servicio de ingresosgastos de la plantilla
 * @author Antonio Duarte
 *
 */

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import es.antonio.duarte.dao.*;
import es.antonio.duarte.model.IngresosGastos;
@SuppressWarnings("unchecked")
public class IngresosGastosServicioImpl implements IngresosGastosServicio{
	
	/**
	 * Texto con el que rellenar las excepciones
	 */
	private String mensaje = "Debe introducir un parámetro en este método";
	
	/**
	 * El dao asociado a la clase IngresosGastos con el que iremos a la BBDD
	 */
	private IngresosGastosDAO ingresosGastosDAO;
	
	
	/**
	 * Recuperamos el DAO asociado a IngresosGastos
	 * @return IngresosGastosDAO 
	 */
	public IngresosGastosDAO getIngresosGastosDAO(){
		return ingresosGastosDAO;		
	}
	
	
	/**
	 * Spring usara este metodo para inyectar el dao de IngresosGastos
	 * @param ingresosGastosDAO
	 * El dao de IngresosGastos
	 */
	public void setIngresosGastosDAO(final IngresosGastosDAO ingresosGastosDAO){
		this.ingresosGastosDAO = ingresosGastosDAO;
	}
	
	
	/**
	 * Inserta la entidad proporcionada.
	 * @param entidad 
	 * Entidad que se desea insertar en la BBDD
	 */
	public void insertar(Object entidad) {
		if(entidad == null){
			throw new IllegalArgumentException(mensaje);
		}
		
		ingresosGastosDAO.insertar(entidad);
	}	
	
	/**
	 * Actualiza la entidad proporcionada
	 * @param entidad
	 * Entidad que se desea actualizar en la BBDD
	 */
	public void actualizar(Object entidad) {
		if(entidad == null){
			throw new IllegalArgumentException(mensaje);
		}
		ingresosGastosDAO.actualizar(entidad);		
	}
	
	/**
	 * Elimina la entidad proporcionada
	 * @param entidad
	 * Entidad que se desea eliminar de la BBDD
	 */
	public void eliminar(Object entidad) {
		if(entidad == null){
			throw new IllegalArgumentException(mensaje);
		}
		
		ingresosGastosDAO.eliminar(entidad);		
	}
	
	/**
	 * Consulta de todas las caracteristicas de la plantilla. Podra recibir un objeto o ser invocado sin parametros.
	 * @return Lista de ingresosgastos de la plantilla (vacía si no hay registros)
	 * @param objeto
	 * Objeto con el que se realizara la consulta
	 */
	public Collection consultar(final Object... objeto) {
		return ingresosGastosDAO.consultar(IngresosGastos.class);
	}

	/**
	 * Consulta los ingresosgastos de la plantilla para que concuerden con el id proporcionado.
	 * @return Objeto IngresosGastos asociado al id proporcionado
	 * @param id - El id del objeto que se quiere recuperar 
	 */
	public Object consultarPorId(Long id) {
		if (id == null){
			throw new IllegalArgumentException(mensaje);
		}
		
		return ingresosGastosDAO.consultarPorId(id, IngresosGastos.class);
	}
	
	/**
	    * Consulta de ingresosgastos por fecha.
	    * @param fecha Fecha por la cual se buscaran ingresosgastos
	    * @return Lista de ingresosgastos que cumplen con la fecha (vacia si no hay
	    *         registros)
	    */
	   public Collection consultarPorFecha(final Date fecha) {
	      if (fecha == null) {
	         throw new IllegalArgumentException(mensaje);
	      }
	      Collection resultado = ingresosGastosDAO.consultarPorFecha(fecha);
	      return resultado;
	   }
	   
	   
	   /**
	    * Consulta de ingresosgastos por tipo.
	    * @param tipo Tipo por el cual se buscaran ingresosgastos
	    * @return Lista de ingresosgastos que cumplen con la descripcion (vacia si no hay
	    *         registros)
	    */
	   public Collection consultarPorTipo(final String tipo) {
	      if (tipo == null) {
	         throw new IllegalArgumentException(mensaje);
	      }

	      Collection resultado = ingresosGastosDAO.consultarPorTipo(tipo);
	      return resultado;
	   }
	   
	   /**
	    * Consulta de ingresosgastos por cualquiera o todos los campos.
	    * @param tipo Tipo por el cual se buscaran ingresosgastos
	    * @param concepto Concepto por el cual se buscaran ingresosgastos
	    * @param fecha Fecha por la cual se buscaran ingresosgastos
	    * @param cantidad Cantidad por la cual se buscaran ingresosgastos
	    * @return Lista de ingresosgastos que cumplen con alguno o todos los campos de busqueda (vacia si no hay
	    *         registros)
	    */
	   public Collection consultarPor(final Date fecha, final String tipo,
			   							final String cantidad, final String concepto) {
		   /*
		   if (tipo == null) {
			   throw new IllegalArgumentException(mensaje);
		   }
		   */
		   
		   Collection resultado = ingresosGastosDAO.consultarPor(fecha, tipo, cantidad, concepto);
		   return resultado;
	   }
	   
	   
	   /**
	    * Consulta de ingresosgastos por un mes y año.
	    * @param mes Mes por el cual se buscaran ingresosgastos
	    * @param anyo Año por el cual se buscaran ingresosgastos
	    * @return Lista de ingresosgastos que cumplen con el mes y año especificado (vacia si no hay
	    *         registros)
	    */
	   public Collection consultarMesAnyo(final String mes, final String anyo){
		   /**
		    * Permitimos que el mes o el año o ambos puedan ser nulos
		    */
		   Collection resultado = ingresosGastosDAO.consultarMesAnyo(mes,anyo);
		   return resultado;
	   }
	   
	   /**
	    * Calculo de ingresos o gastos totales por mes de un año.
	    * @param anyo Año por el cual se calcularan los ingresos o gastos totales
	    * @param tipo Tipo por el cual se calcularan los ingresos o gastos totales
	    * @return Lista de ingresos o gastos para cada mes del año especificado (vacia si no hay
	    *         registros)
	    */
	   public Collection calcularIngresosGastosAnuales(final String anyo, final String tipo){
		   /**
		    * Permitimos que el año pueda ser nulo porque se controlará en la capa de datos
		    */
		   Collection resultado = ingresosGastosDAO.calcularIngresosGastosAnuales(anyo,tipo);
		   
		   return resultado;		   
	   }
	   
	   

	   

}
