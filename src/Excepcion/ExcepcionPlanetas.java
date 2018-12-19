package Excepcion;




/**
 *
 * @author CRISTIAN
 */
public class ExcepcionPlanetas extends Exception {
private int codigoError;
    public ExcepcionPlanetas(int codigoError) {
        super();
        this.codigoError=codigoError;
    }

    public String getMessage() {
        String mensaje="";
        switch(codigoError){
            case 1:
                mensaje="N.º de argumentos inválido";
                break;
            case 2:
                  mensaje="Especie incorrecta";
                break;
            case 3:
                mensaje="Planeta incorrecto";
                break;
            case 4:
                  mensaje="Dato incorrecto";
                break;
            case 5:
                mensaje="No se puede registrar ese ser en ese planeta";
                break;
            case 6:
                  mensaje="Ya existe un ser censado con ese nombre";
                break;
            case 7:
                mensaje="No existe ningún ser con ese nombre";
                break;
            case 8:
                  mensaje="El ser no permite ser modificado";
                break;
            case 9:
                mensaje="Operación incorrecta";
                break;
            case 10:
                  mensaje="Edad incorrecta";
                break;
            case 11:
                mensaje="Nivel de meditación incorrecto";
                break;
            case 12:
                  mensaje="Valor de fuerza incorrecto";
                break;
            case 13:
                  mensaje="Planeta completo (30 censados máximo)";
                break;
         
                
    }
         return mensaje;
    }

}
