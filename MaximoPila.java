public class MaximoPila {

    // Método que encuentra el elemento máximo en una pila
    public static int encontrarMaximo(PilaArray pila) {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía");
            return Integer.MIN_VALUE;
        }

        int maximo = Integer.MIN_VALUE;
        PilaArray temp = new PilaArray(pila.getCapacidad());

        // Buscamos el máximo mientras transferimos a temporal
        while (!pila.isEmpty()) {
            int elemento = pila.pop();
            if (elemento > maximo) {
                maximo = elemento;
            }
            temp.push(elemento);
        }

        // Restauramos la pila original
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }

        return maximo;
    }

    // Método adicional: encontrar mínimo
    public static int encontrarMinimo(PilaArray pila) {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía");
            return Integer.MAX_VALUE;
        }

        int minimo = Integer.MAX_VALUE;
        PilaArray temp = new PilaArray(pila.getCapacidad());

        // Buscamos el mínimo mientras transferimos a temporal
        while (!pila.isEmpty()) {
            int elemento = pila.pop();
            if (elemento < minimo) {
                minimo = elemento;
            }
            temp.push(elemento);
        }

        // Restauramos la pila original
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }

        return minimo;
    }

    // Método de prueba
    public static void main(String[] args) {
        PilaArray pila = new PilaArray(8);
        pila.push(3);
        pila.push(15);
        pila.push(7);
        pila.push(22);
        pila.push(9);
        pila.push(18);
        pila.push(4);
        pila.push(11);

        System.out.println("Pila original:");
        pila.mostrar();

        int maximo = encontrarMaximo(pila);
        System.out.println("Elemento máximo: " + maximo);

        int minimo = encontrarMinimo(pila);
        System.out.println("Elemento mínimo: " + minimo);

        System.out.println("Pila después de buscar máximo y mínimo:");
        pila.mostrar(); // Debe estar igual que al inicio
    }
}