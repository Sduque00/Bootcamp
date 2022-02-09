package co.sofka.emuladorCPU;

public class App {

    public int ejecutarSubrutina(String[] subrutina){
        for (int i = 0; i < subrutina.length; i++) {

            String[] instruccionSeparada = subrutina[i].split("\\W"); // ["MOV", 5, "R00"]

            switch (instruccionSeparada[0]) {
                case "MOV":
                    if (instruccionSeparada[1].contains("R"))
                        Instrucciones.MOV(instruccionSeparada[1], instruccionSeparada[2]);
                    else
                        Instrucciones.MOV(Integer.parseInt(instruccionSeparada[1]), instruccionSeparada[2]);
                    break;
                case "ADD":
                    Instrucciones.ADD(instruccionSeparada[1], instruccionSeparada[2]);
                    break;
                case "DEC":
                    Instrucciones.DEC(instruccionSeparada[1]);
                    break;
                case "INC":
                    Instrucciones.INC(instruccionSeparada[1]);
                    break;
                case "JMP":
                    i = Integer.parseInt(instruccionSeparada[1]);
                    break;
                case "JZ":
                    int R00 = Instrucciones.getR00();
                    if (R00 == 0)
                        i = Integer.parseInt(instruccionSeparada[1]);
                    break;
                default:
                    break;
            }
            ;
        }
        return Instrucciones.getR42();
    };

    public static void main(String[] args) {
        App app = new App();

        String[] subrutina = {
                "MOV 5,R00",
                "MOV 10,R01",
                "JZ 7",
                "ADD R02,R01",
                "DEC R00",
                "JMP 3",
                "MOV R02,R42"
        };

        int r42 = app.ejecutarSubrutina(subrutina);

        System.out.println("R42: " + r42);
    }

}
