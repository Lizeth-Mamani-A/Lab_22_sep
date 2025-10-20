public class FusionarPilas {

    // Método que fusiona dos pilas ordenadas en una sola pila ordenada
    public static PilaArray fusionarPilasOrdenadas(PilaArray pila1, PilaArray pila2) {
        PilaArray resultado = new PilaArray(pila1.getCapacidad() + pila2.getCapacidad());
        PilaArray temp = new PilaArray(pila1.getCapacidad() + pila2.getCapacidad());

        // Fusionamos las dos pilas en orden descendente en temporal
        while (!pila1.isEmpty() && !pila2.isEmpty()) {
            if (pila1.peek() >= pila2.peek()) {
                temp.push(pila1.pop());
            } else {
                temp.push(pila2.pop());
            }
        }

        // Agregamos los elementos restantes de pila1
        while (!pila1.isEmpty()) {
            temp.push(pila1.pop());
        }

        // Agregamos los elementos restantes de pila2
        while (!pila2.isEmpty()) {
            temp.push(pila2.pop());
        }

        // Transferimos de temporal a resultado para obtener orden ascendente
        while (!temp.isEmpty()) {
            resultado.push(temp.pop());
        }

        return resultado;
    }

    // Método de prueba
    public static void main(String[] args) {
        // Pila 1 ordenada ascendentemente
        PilaArray pila1 = new PilaArray(5);
        pila1.push(10);
        pila1.push(7);
        pila1.push(5);
        pila1.push(3);
        pila1.push(1);

        // Pila 2 ordenada ascendentemente
        PilaArray pila2 = new PilaArray(4);
        pila2.push(9);
        pila2.push(6);
        pila2.push(4);
        pila2.push(2);

        System.out.println("Pila 1 ordenada:");
        pila1.mostrar();
        System.out.println("Pila 2 ordenada:");
        pila2.mostrar();

        PilaArray fusionada = fusionarPilasOrdenadas(pila1, pila2);

        System.out.println("Pila fusionada ordenada:");
        fusionada.mostrar();
    }
}