public class EliminarElemento {

    // Método que elimina todas las ocurrencias de un elemento específico
    public static void eliminarOcurrencias(PilaArray pila, int elementoAEliminar) {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía");
            return;
        }

        PilaArray temp = new PilaArray(pila.getCapacidad());

        // Transferimos todos los elementos a temporal, excepto los que coinciden
        while (!pila.isEmpty()) {
            int elemento = pila.pop();
            if (elemento != elementoAEliminar) {
                temp.push(elemento);
            }
        }

        // Transferimos de vuelta a la pila original para mantener el orden
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }

    // Método de prueba
    public static void main(String[] args) {
        PilaArray pila = new PilaArray(10);

        // Llenar la pila con algunos valores repetidos
        pila.push(5);
        pila.push(2);
        pila.push(8);
        pila.push(2);
        pila.push(3);
        pila.push(2);
        pila.push(7);
        pila.push(2);

        System.out.println("Pila original:");
        pila.mostrar();

        // Eliminar todas las ocurrencias del número 2
        eliminarOcurrencias(pila, 2);

        System.out.println("Pila después de eliminar todos los 2:");
        pila.mostrar();

        // Prueba con elemento que no existe
        System.out.println("\nEliminar elemento 99 (que no existe):");
        eliminarOcurrencias(pila, 99);
        pila.mostrar();
    }
}