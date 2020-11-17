package com.tutiempolibro.bookmaintenance.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class Util {
	
	
	
	
    public static void generateTracking() {
	Thread.currentThread().setName(UUID.randomUUID().toString().replace("-", ""));
    }

    public static String getTracking() {
	return Thread.currentThread().getName();
    }

	/**
	 * Método de formato de fecha y hora utilizado en la clase LoggingAspect.
	 * 
	 * @return date
	 */
	public static String getDateTimeFormatter() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constant.DATE_TIME);
		LocalDateTime localDateTime = LocalDateTime.now();
		String date = dateTimeFormatter.format(localDateTime);
		return date;
	}

	/**
	 * Método de formato de fecha y hora utilizado en el response (Json).
	 * 
	 * @return OffsetDateTime
	 */
	public static OffsetDateTime getOffsetDateTime(Date date) {
		Instant instantFromDate = date.toInstant();
		ZoneOffset zoneOffSet = ZoneOffset.of("-05:00");
		OffsetDateTime offsetdatetime = instantFromDate.atOffset(zoneOffSet);

		return offsetdatetime;
	}

	public static String getDateFormat(Date date, String exp) {
		SimpleDateFormat sdf = new SimpleDateFormat(exp);
		return sdf.format(date);
	}
	
	/*public static void main(String[] args) {
		 File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      
	      File archivo2 = null;
	      FileReader fr2 = null;
	      BufferedReader br2 = null;

	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File ("C:\\Users\\Indra\\Documents\\compartir\\feat1233\\fijas.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         
	         
	         

	         // Lectura del fichero
	         String linea;
	         String linea2;
	         
	         while((linea=br.readLine())!=null) {
	        	 boolean existe=false;
	        	 
	        	 archivo2 = new File ("C:\\Users\\Indra\\Documents\\compartir\\feat1233\\lineasexistentes.txt");
		         fr2 = new FileReader (archivo2);
		         br2 = new BufferedReader(fr2);
		         
	        	 while((linea2=br2.readLine())!=null) {
	        	
	        		 if(linea.trim().equals(linea2.trim())) {
	        			 
	        			 existe = true;
	        			 break;
	        		 }
	        	 }
	        	 if(!existe)
	        		 System.out.println(linea);
	        		 
	         }
	            
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	         
	         try{                    
		            if( null != fr2 ){   
		               fr2.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
	      }
	 }*/
	

}
