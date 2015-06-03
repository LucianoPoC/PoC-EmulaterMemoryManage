package br.edu.ifc.blumenau.list;

public class List {
    private long memorySize;
    private Node root = null;

    public List(long memorySize) {
        this.memorySize = memorySize;
    }

    public void aloca(long value) {
        Node node = this.firstFit(value);
        node.setNext(this.root);
        if (this.root != null) {
            this.root.setPrevious(node);
        }
        this.root = node;
        this.memorySize -= value;
    }

    public void desaloca(int processNumber) {
        Node node = this.root;
        Node ant = null;

        while ((node != null) && (node.getPonteiro() != processNumber)) {
            ant = node;
            node = node.getNext();
        }

        if (node == null) {
            return;
        }

        node.setState('H');
        this.memorySize += node.getValue();
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
        }
        return null;
    }
    private Node firstFit(long value) {
        Node nodeHole = getFirsHoleNode(value);
        if (nodeHole == null) {
            //Testar se ainda existe memoria, se existir coloca na lista
        } else {
            Node newNode = new Node(value);

            newNode.setNext(nodeHole);
            nodeHole.getPrevious().setNext(newNode);
            newNode.setPrevious(nodeHole.getPrevious());
            nodeHole.setPrevious(newNode);

            //Trocar valor de nodeHole
        }

        Node node = this.root;
        Node ant = null;

        while ((node != null) && (node.getPonteiro() != processNumber)) {
            ant = node;
            node = node.getNext();
        }

        if (node == null) {
            return;
        }

        node.setState('H');
        this.memorySize += node.getValue();
    }
}
