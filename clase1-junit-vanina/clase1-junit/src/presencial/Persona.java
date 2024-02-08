package presencial;

public class Persona {
    private String nombre;

    private Integer edad;

    //primitivo o objetos(objetos ej: Integer -> Métodos)

    //constructor, para construir nuestro objeto: Persona
    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    //chequeamos que sea mayor de edad
    public boolean esMayor() {
        return edad>=18;
    }

    //chequeamos que el nombre tenga mínimo 5 letras
    public boolean letrasCheck() {
        return nombre.length()>4;
    }

    //nombre -> String: ej Mateo
    //chequear que el nombre tenga solo letras
    //String = Mateo
    //char[] = [M,a,t,e,o];
    public boolean checkAZNombre() {
        boolean respuesta = false;

        char[] nombreChars;
        nombreChars = nombre.toCharArray();

        for (char letra: nombreChars) {
            if (!Character.isLetter(letra)) {
                return respuesta;
            }
        }
        respuesta = true;

        return respuesta;
    }

    //chequeando que la edad este entre 0 y 120 años
    public boolean checkEdad120() {

        boolean respuesta = true;

        //si esta entre 0 y 120
        if (edad>0 && edad<120) {
            //se agrega a la persona al grupo -> true

            return respuesta;
        }

        //si tiene menos de 0 o más de 120
        //-> no se puede agregar al grupo -> devolver un false
        respuesta = false;
        return respuesta;


    }

}
