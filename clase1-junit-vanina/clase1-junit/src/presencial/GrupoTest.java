package presencial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    //Dadas 5 personas (Juan, Pedro, Ana, Luz y Julián) y
    //una colección vacía de objetos tipo Persona, cuando se intentan
    //agregar estas a la colección, el tamaño de la colección debería ser 2
     @Test
    public void casoUno(){
        //DADO lo que necesito para hacer la prueba
        Persona juan = new Persona("Juan", 20);
        Persona pedro = new Persona("Pedro", 20);
        Persona ana = new Persona("Ana", 20);
        Persona luz = new Persona("Luz", 20);
        Persona julian = new Persona("Julián", 20);
        Grupo grupo1 = new Grupo();

        //CUANDO ocurre el proceso, cuando se produce la acción de agregar
         grupo1.agregarPersona(juan);
         grupo1.agregarPersona(pedro);
         grupo1.agregarPersona(ana);
         grupo1.agregarPersona(luz);
         grupo1.agregarPersona(julian);

         //List<Persona> = {pedro, julian}

        //ENTONCES hacemos un check del tamaño de la colección
         assertTrue(grupo1.getPersonas().size() == 2);

    }

    /*Dadas 5 personas (18 años, 17 años, 22 años, 14 años y 32 años),
    el tamaño de la colección debería ser 3
     */

    @Test
    public void casoDos(){
        //DADO lo que necesito para hacer la prueba
        Persona lucas = new Persona("Lucas", 18);
        Persona pedro = new Persona("Pedro", 17);
        Persona elton = new Persona("Elton", 22);
        Persona nicolas = new Persona("Nicolas", 14);
        Persona alexia = new Persona("Alexia", 32);
        Grupo grupo2 = new Grupo();

        //CUANDO ocurre el proceso, cuando se produce la acción de agregar
        grupo2.agregarPersona(lucas);
        grupo2.agregarPersona(pedro);
        grupo2.agregarPersona(elton);
        grupo2.agregarPersona(nicolas);
        grupo2.agregarPersona(alexia);

        //List<Persona> = {pedro, julian}

        //ENTONCES hacemos un check del tamaño de la colección
        assertTrue(grupo2.getPersonas().size() == 3);
    }

    /*Dado 5 personas (N1c0las, Tomas, 3steban, Carlos\sV,
    Francisco\sII), el tamaño de la colección debería ser 1
     */
    @Test
    public void casoTres(){
        //DADO lo que necesito para hacer la prueba
        Persona nico = new Persona("N1c0las", 20);
        Persona tomas = new Persona("Tomas", 20);
        Persona esteban = new Persona("3steban", 22);
        Persona nicolas = new Persona("Carlos\\sV", 20);
        Persona fran = new Persona("Francisco\\sII", 32);
        Grupo grupo3 = new Grupo();

        //CUANDO ocurre el proceso, cuando se produce la acción de agregar
        grupo3.agregarPersona(nico);
        grupo3.agregarPersona(tomas);
        grupo3.agregarPersona(esteban);
        grupo3.agregarPersona(nicolas);
        grupo3.agregarPersona(fran);

        //List<Persona> = {pedro, julian}

        //ENTONCES hacemos un check del tamaño de la colección
        assertTrue(grupo3.getPersonas().size() == 1);
    }


}