package br.edu.ifc.blumenau;

import br.edu.ifc.blumenau.list.List;

public class Main {

    public static void main(String[] args) {
//        List memoryManager = new List(4294967296L);
        List memoryManager = new List(15);
        System.out.println("Start memory size: "+memoryManager.getMemorySize());
        memoryManager.aloca(3L);
        long a = memoryManager.aloca(5L);
        System.out.println(memoryManager.toString());
        System.out.println(memoryManager.getMemorySize());
        memoryManager.aloca(4L);
        System.out.println(memoryManager.toString());
        System.out.println(memoryManager.getMemorySize());
        memoryManager.desaloca(a);
        System.out.println(memoryManager.toString());
        System.out.println(memoryManager.getMemorySize());
        System.out.println(memoryManager.aloca(2L));
        System.out.println(memoryManager.toString());
        System.out.println(memoryManager.getMemorySize());
        System.out.println(memoryManager.aloca(3L));
        System.out.println(memoryManager.toString());
        System.out.println(memoryManager.getMemorySize());


    }
}
