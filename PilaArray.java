public class PilaArray {
    private int[] elementos;
    private int tope;
    private int capacidad;

    public PilaArray(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new int[capacidad];
        this.tope = -1;
    }

    // Operación push: insertar elemento
    public void push(int elemento) {
        if (tope == capacidad - 1) {
            System.out.println("Error: Pila llena");
            return;
        }
        elementos[++tope] = elemento;
    }

    // Operación pop: eliminar y retornar elemento
    public int pop() {
        if (isEmpty()) {
            System.out.println("Error: Pila vacía");
            return -1;
        }
        return elementos[tope--];
    }

    // Operación peek: ver elemento superior sin eliminarlo
    public int peek() {
        if (isEmpty()) {
            System.out.println("Error: Pila vacía");
            return -1;
        }
        return elementos[tope];
    }

    // Operación isEmpty: verificar si está vacía
    public boolean isEmpty() {
        return tope == -1;
    }

    // Operación size: obtener tamaño actual
    public int size() {
        return tope + 1;
    }

    // Operación getCapacidad: obtener capacidad máxima
    public int getCapacidad() {
        return capacidad;
    }

    // Operación mostrar: mostrar contenido de la pila
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Pila vacía");
            return;
        }
        System.out.print("Pila: ");
        for (int i = 0; i <= tope; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}