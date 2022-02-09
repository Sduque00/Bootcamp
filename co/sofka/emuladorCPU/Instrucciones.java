package co.sofka.emuladorCPU;

import java.util.HashMap;
import java.util.Map;

public class Instrucciones {

    private static Map<String, Integer> registros;

    public Instrucciones(){
//        Inicializamos los registros
        registros = new HashMap<String, Integer>(43);
        for(int i = 0; i < 43; i++){
            registros.put("R0"+i, 0);
        }
    };

    public static void MOV(String Rxx, String Ryy){ //"R01", "R19"
        registros.replace(Ryy, registros.get(Rxx));
    }
    public static void MOV(int d, String Rxx){
        registros.replace(Rxx, d);
    }


    //ADD Rxx,Ryy → calcula (Rxx + Ryy) MOD 2pow32
    //y almacena el resultado en el registro Rxx
    public static void ADD(String Rxx, String Ryy){

    }

    public static void DEC(String Rxx){

    }
    public static void INC(String Rxx){

    }

    public static void INV(String Rxx){

    }


    public static int getR00() {
        return registros.get("R00");
    }

    public static int getR42() {
        return registros.get("R42");
    }


}










