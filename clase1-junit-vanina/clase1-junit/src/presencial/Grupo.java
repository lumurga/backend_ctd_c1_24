package presencial;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

    //[]
    //List, Set, Map<key, value>
    private List<Persona> personas;


    //constructor de grupo
    public Grupo() {
        this.personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona(Persona persona) {

        boolean esMayor = persona.esMayor();
        boolean entre0y120 = persona.checkEdad120();
        boolean letras = persona.letrasCheck();
        boolean letrasAaZ = persona.checkAZNombre();

        if (esMayor && entre0y120 && letras && letrasAaZ) {
            //agrega la persona al grupo
            personas.add(persona);
            System.out.println("Se agregaron las personas");
        } else {
            System.out.println("No se pudo agregar a la persona");
            if (!persona.esMayor()) {
                System.out.println("La persona " + persona.getNombre() + " no es mayor de edad");
            }
            if (!persona.checkAZNombre()) {
                System.out.println("El nombre no contiene solo letras: " + persona.getNombre() );
            }
            if (!persona.letrasCheck()) {
                System.out.println("El nombre tiene menos de 5 letras: " + persona.getNombre());
            }
            if (!persona.checkEdad120()) {
                System.out.println("La persona: " + persona.getNombre() + "no tiene entre 0 y  120 años");
            }

        }
    }
}
