public class PilaOrdenada {

    // Método que verifica si una pila está ordenada ascendentemente
    public static boolean estaOrdenadaAscendente(PilaArray pila) {
        if (pila.isEmpty() || pila.size() == 1) {
            return true;
        }

        // Usamos una pila temporal para preservar la original
        PilaArray temp = new PilaArray(pila.getCapacidad());
        boolean ordenada = true;
        int anterior = Integer.MAX_VALUE;

        // Verificamos el orden mientras transferimos a temporal
        while (!pila.isEmpty()) {
            int actual = pila.pop();
            if (actual > anterior) {
                ordenada = false;
            }
            temp.push(actual);
            anterior = actual;
        }

        // Restauramos la pila original
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }

        return ordenada;
    }

    // Método de prueba
    public static void main(String[] args) {
        // Caso 1: Pila ordenada ascendentemente
        PilaArray pila1 = new PilaArray(5);
        pila1.push(5);
        pila1.push(4);
        pila1.push(3);
        pila1.push(2);
        pila1.push(1);

        System.out.println("Pila 1:");
        pila1.mostrar();
        System.out.println("¿Está ordenada ascendentemente? " + estaOrdenadaAscendente(pila1));
        System.out.println("Pila después de verificación:");
        pila1.mostrar();

        // Caso 2: Pila no ordenada
        PilaArray pila2 = new PilaArray(5);
        pila2.push(3);
        pila2.push(5);
        pila2.push(1);
        pila2.push(4);
        pila2.push(2);

        System.out.println("\nPila 2:");
        pila2.mostrar();
        System.out.println("¿Está ordenada ascendentemente? " + estaOrdenadaAscendente(pila2));
        System.out.println("Pila después de verificación:");
        pila2.mostrar();

        // Caso 3: Pila vacía
        PilaArray pila3 = new PilaArray(5);
        System.out.println("\nPila 3 (vacía):");
        pila3.mostrar();
        System.out.println("¿Está ordenada ascendentemente? " + estaOrdenadaAscendente(pila3));
    }
}