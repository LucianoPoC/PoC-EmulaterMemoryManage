package br.edu.ifc.blumenau;

import br.edu.ifc.blumenau.list.List;

public class Main {

    public static void main(String[] args) {
        List memoryManager = new List(4294967296L);
        System.out.println(memoryManager.getMemorySize());

        memoryManager.aloca(1, 1L);
        System.out.println(memoryManager.getMemorySize());
        memoryManager.desaloca(1);

        System.out.println(memoryManager.getMemorySize());

        System.out.println(memoryManager.getMemorySize());
        memoryManager.aloca(1, 1L);
    }
}
