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
                mensaje="< ERROR 001: N.º de argumentos inválido >";
                break;
            case 2:
                  mensaje="< ERROR 002: Especie incorrecta >";
                break;
            case 3:
                mensaje="< ERROR 003: Planeta incorrecto >";
                break;
            case 4:
                  mensaje="< ERROR 004: Dato incorrecto >";
                break;
            case 5:
                mensaje="No se puede registrar ese ser en ese planeta";
                break;
            case 6:
                  mensaje="< ERROR 006: Ya existe un ser censado con ese nombre >";
                break;
            case 7:
                mensaje="< ERROR 007: No existe ningún ser con ese nombre >";
                break;
            case 8:
                  mensaje="< ERROR 008: El ser no permite ser modificado >";
                break;
            case 9:
                mensaje="< ERROR 009: Operación incorrecta >";
                break;
            case 10:
                  mensaje="Edad incorrecta";
                break;
            case 11:
                mensaje="< ERROR 011: Nivel de meditación incorrecto >";
                break;
            case 12:
                  mensaje="< ERROR 012: Valor de fuerza incorrecto >";
                break;
            case 13:
                  mensaje="Planeta completo (30 censados máximo)";
                break;
                 case 14:
                  mensaje="< Nobody registered yet >";
                break;
         
                
    }
         return mensaje;
    }

}
