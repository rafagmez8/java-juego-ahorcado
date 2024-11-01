import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        // Clase Scanner permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        // Declaraciones y asignaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arrays
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Estructura de control iterativa (bucle)
        for(int i = 1; i<letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '-'; // Inicialización del array con _
        }

        // Estructura de control iterativa (bucle)
        while (!palabraAdivinada && intentos < intentosMaximos) {
            // String.valueOf se usa cuando se tiene una palabra de chars
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor");
            // Se usa la clase scanner para pedir una letra
            char letra = Character.toLowerCase( scanner.next().charAt(0) );

            boolean letraCorrecta = false;

            // Estructura de control iterativa (bucle)
            for(int i = 0; i<palabraSecreta.length(); i++) {
                // Estructura de control condicional
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra; // Se sustituye el _ por la letra introducida en su posición correcta
                    letraCorrecta = true;
                }
            }

            // Estructura de control condicional
            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan "+ (intentosMaximos - intentos) + " intentos.");
            }

            // Estructura de control condicional
            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades, has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        // Estructura de control condicional
        if (!palabraAdivinada) System.out.println("¡Qué pena, te has quedado sin intentos! GAME OVER");
        scanner.close();
    }
}
