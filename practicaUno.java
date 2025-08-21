import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class practicaUno {

    /**
     * Metodo de fuerza bruta que recibe un arreglo de enteros y
     * devuelve la cantidad de parejas que suman cero.
     * @param numeros arreglo de numeros enteros
     * @return numero de parejas que suman cero
     */
    public static int parejasSumanCero(int [] numeros) {
        int contador = 0;
        for(int i = 0; i < numeros.length; i++) {
            for(int j = i+1; j < numeros.length; j++) {
                if(numeros[i] + numeros[j] ==0) {
                    contador++;
                }
            }
        }
        return contador;
    }

    /**
     * Genera un arreglo de n numeros enteros aleatorios
     * entre -50 y 50.
     * @param cantidad cantidad de numeros a generar
     * @return arreglo de numeros enteros
     */
    public static int[] generarNumeros(int cantidad) {
        int[] numeros =  new int[cantidad];
        Random random = new Random();
        for(int i = 0; i < cantidad; i++) {
            numeros[i] = random.nextInt(100 + 1) - 50;
        }
        return numeros;       
    }

    /**
     * Metodo main que ejecuta el programa.
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Clase de apoyo para almacenar los resultados de las ejecuciones.
         */
        class Resultado {
            int ejecucion;
            int cantidad;
            Long tiempo;
            
            Resultado(int ejecucion, int cantidad, Long tiempo) {
                this.cantidad = cantidad;
                this.ejecucion = ejecucion;
                this.tiempo = tiempo;
            }
        }


        int ejecucionesTotales = 18;
        int cantidadNumeros = 30;
        List<Resultado> resultados = new ArrayList<>();
        Long inicio;
        Long fin;

        for(int i = 0; i <= ejecucionesTotales ; i++ ) {
            //Condicion para variar la cantidad de numeros generados
            if(i % 3 == 0) {
                cantidadNumeros *= 2;
            }
            int[] numeros = generarNumeros(cantidadNumeros);
            inicio = System.nanoTime();
            parejasSumanCero(numeros);
            fin = System.nanoTime();
            Long tiempo = fin - inicio;
            resultados.add(new Resultado(i,cantidadNumeros,tiempo));
        }
        System.out.println("Tiempos de ejecución para cada cantidad de números generados:");
        for (Resultado resultado : resultados) {
            System.out.println("Ejecución: " + resultado.ejecucion + 
                               ", Cantidad de números: " + resultado.cantidad + 
                               ", Tiempo: " + resultado.tiempo + " ns");
        }
    }
}

 /* int cantidad = 30;
        int[] numeros = generarNumeros(cantidad);
        
        System.out.print("Números generados: ");
        for(int num : numeros) {
            System.out.print(num + " ");
        }
        
        
        Long inicio = System.nanoTime();
        int resultado = parejasSumanCero(numeros);
        Long fin = System.nanoTime();
        Long tiempo = fin - inicio;
        System.out.println("\nCantidad de parejas que suman cero: " + resultado);
        System.out.println("Tiempo de ejecución: " + tiempo + " ns"); */