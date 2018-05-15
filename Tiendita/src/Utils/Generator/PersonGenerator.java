package Utils.Generator;

import static java.lang.Integer.parseInt;
import java.util.Random;

/**
 *
 * @author ashh412
 */
public class PersonGenerator {

    private static final String LETRAS_NIF = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final Random RAND = new Random();

    private static final String[] NAME = {"Tatiana", "Adam", "Ernesto", "Lázaro", "Leandro", "León", "Cecilia",
        "Ray", "Maria", "Rosa", "Patricia", "Armando", "Lorenzo", "Mar", "Silvia", "Svenka",
        "Hernando", "Nadja", "Africa", "Abel", "", "Alma", "Amor", "Rei", "Cerene", "Mar", "Antonio",
        "Ainsley", "Josiah", "Tarik", "Adam", "Tatyana", "Warren", "Hollee", "Ali", "Armando", "Yuri",
        "Yoko", "Mary", "Ivy", "Aurora", "Graiden", "Allegra", "Philip", "Joel", "Brody", "Donna", "Wallace",
        "Orla", "Avye", "Cooper", "Fay", "Neil", "Vera", "Cade", "Kenyon", "Brenda", "Maya", "Jackson",
        "Malik", "Darius", "Denton", "Cassandra", "Harrison", "Avye", "Eleanor", "Hayley", "PetraR",
        "Stacey", "AmosCo", "Oliver", "Dominic", "Wayne", "Eden", "Knox", "Oleg", "Sonia", "Zorita", "Mollie",
        "Stephen", "Pearl", "Ursula", "Carter", "Tanisha", "Carson", "Kiara", "Guineve", "Iris",
        "Dustin", "Kelly", "Sandra", "Julian", "Quemby", "Anjolie", "Bree", "Daquan", "Brynne", "Xanthus",
        "Roanna", "Perry", "Arsenio", "Paul", "Helen", "Talon", "Whitney", "Aquila", "James", "Odysseu",
        "Chava", "Murphy", "Eugenia", "Hanae", "Declan", "Armando", "Zoe", "Cody", "Selma", "Dalton", "Aiko",
        "Matthew", "Keiko", "Wang", "Aurora", "Nora", "Channin", "Quail", "Zahir"};

    private static final String[] FIRSTNAME = {"D.", "K.", "Albeicer", "Roque", "del Mar ", "Pablo ", "Vera", "Muñoz",
        "Alex", "Godoy", "Castillo", "Delgado", "Flores", "Silvestre", "Cres", "Suárez", "García",
        "Miranda", "Morales", "Ana", "Salmar", "Benitez"};
    private static final String[] LASTNAME = {"De la vega", "Mateo", "Ruiz", "Afonso", "Suárez", "Pérez", "Smith",
        "Maqueda", "Díaz", "Romero", "Sosa", "García", "Pulido", "Holder", "Barlow", "Campos", "Potter"};

    /**
     *
     */
    public PersonGenerator() {
    }

    /**
     * Genera un NIF
     *
     * @return NIF (DNI + letra)
     */
    public static String generateDni() {
        String dniNumber = "";

        for (int i = 0; 8 > i; i++) {
            Random r = new Random();

            dniNumber = dniNumber.concat(String.valueOf(r.nextInt(10)));
        }

        return getNifLetter(dniNumber);
    }

    /**
     * Calcula el NIF (DNI + letra) para un número de identificación dado
     *
     * @param numerosDni - números de un dni
     * @return NIF (DNI + letra)
     */
    private static String getNifLetter(String numerosDni) {

        int numeros = parseInt(numerosDni);
        return String.valueOf(numerosDni) + LETRAS_NIF.charAt(numeros % 23);
    }

    /**
     *
     * @return
     */
    public static String generateLastName() {

        return LASTNAME[RAND.nextInt(LASTNAME.length)];
    }

    /**
     *
     * @return
     */
    public static String generateFirstName() {

        return NAME[RAND.nextInt(NAME.length)] + " "
                + FIRSTNAME[RAND.nextInt(FIRSTNAME.length)];
    }

}
