package br.edu.ifc.blumenau.list;

public class List {
    private long memorySize;
    private Node root = null;

    public List(long memorySize) {
        this.memorySize = memorySize;
    }

    public long aloca(long value) {
        return firstFit(value);
    }

    public void desaloca(long pointer) {
        Node node = this.root;
        Node ant = null;

        while ((node != null) && (node.getPointer() != pointer)) {
            ant = node;
            node = node.getNext();
            if (ant.getState() == 'H' && node.getState() == 'H') {
                this.mergeHole(ant, node);
            }
        }

        if (node == null) {
            return;
        }

        node.setState('H');
        this.memorySize += node.getValue();
    }

    private void mergeHole(Node node1, Node node2) {
        node2.setValue(node1.getValue() + node2.getValue());
        node1.getPrevious().setNext(node2);
        node2.setPrevious(node1.getPrevious());
    }

    public String getMemorySize() {
        return this.memorySize+" B";
    }

    private Node getFirsHoleNode(long value) {
        Node node = this.root;
        while (node != null) {
            if (value <= node.getValue() && node.getState() == 'H') {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private long getHolesSize() {
        long count = 0;
        Node node = this.root;
        while (node != null) {
            if (node.getState() == 'H') {
                count += node.getValue();
            }
            node = node.getNext();
        }

        return count;
    }

    private long firstFit(long value) {
        long pointer = -1;
        Node newNode = new Node(value);
        Node nodeHole = getFirsHoleNode(value);
        if (nodeHole == null) {
            pointer = simpleInsert(value, newNode);
        } else {
            newNode.setNext(nodeHole);
            if (nodeHole.getPrevious() != null) {
                nodeHole.getPrevious().setNext(newNode);
            }
            newNode.setPrevious(nodeHole.getPrevious());
            nodeHole.setPrevious(newNode);
            pointer = nodeHole.getPointer();
            if ((nodeHole.getValue() - value) > 0) {
                nodeHole.setValue(nodeHole.getValue() - value);
                nodeHole.setPointer(pointer-value);
            } else {
                this.removeNode(nodeHole);
            }

            if (nodeHole == this.root) {
                this.root = newNode;
            }
            this.memorySize -= value;
        }

        newNode.setPointer(pointer);

        return pointer;
    }

    private void removeNode(Node nodeHole) {
        nodeHole.getNext().setPrevious(nodeHole.getPrevious());
        nodeHole.getPrevious().setNext(nodeHole.getNext());
        nodeHole.setNext(null);
        nodeHole.setPrevious(null);
    }

    private long simpleInsert(long value, Node newNode) {
        long pointer = -1;
        try {
            if ((this.memorySize - getHolesSize()) >= value) {
                if (this.root != null) {
                    this.root.setPrevious(newNode);
                }
                newNode.setNext(this.root);
                pointer = this.memorySize;
                this.root = newNode;
                this.memorySize -= value;
            } else {
                System.out.println("Espaço de memória requerido é maior do que o maior espaço disponível!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pointer;
    }

    @Override
    public String toString() {
        Node node = this.root;
        String sReturn = "Lista {\n";
        while (node != null) {
            sReturn += "Memory size: "+node.getValue()+"bytes State: "+node.getState()+" Pointer: "+node.getPointer()+", \n";
            node = node.getNext();
        }
        return sReturn+"}";
    }
}
