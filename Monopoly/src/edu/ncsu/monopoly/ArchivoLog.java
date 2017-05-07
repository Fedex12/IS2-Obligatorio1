/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author Federico
 */
public class ArchivoLog {
    FileWriter archivo; //nuestro archivo log

     public void crearLog(String operacion)  {

        try {
            //Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
            if (new File("log.txt").exists()==false){archivo=new FileWriter(new File("log.txt"),false);}
            archivo = new FileWriter(new File("log.txt"), true);
            Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar
            //Empieza a escribir en el archivo
            archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                    +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                    +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
                    +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                    +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
                    +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";"+operacion+"\r\n");
            archivo.close(); //Se cierra el archivo
        } //Fin del metodo crearLog
        catch (IOException ex) {
            System.out.println(ex);
        }
     }
}
