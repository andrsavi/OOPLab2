package po83.savinov.oop.model;

public class WeightTraining implements ComplexExercise {

    private class Node {
        public Node next;
        Approach value;

        public Node(Approach approach) {
            this.value = approach;
        }
    }

    private String name;
    private Node head;
    private Node tail;
    private int size;

    public WeightTraining(String name) // конструктор инициализирует голову и хвост списка значением null
    {
        head = null;
        tail = null;
    }

    public WeightTraining(String name, Approach[] approaches) // в конструкторе происходит создание списка и заполнение его элементов ссылками из массива
    {
        for (Approach approache : approaches) {
            add(approache);
            size++;
        }
    }

    private Node removeNode(int index) // метод, удаляющий узел по его номеру в списке
    {
        Node n = head;
        int count = 0;
        Node res;
        if (index == 0) {
            head = n.next;
            size--;
            return n;
        }
        while (n != null) {
            if (count + 1 == index) {
                res = n.next;
                n.next = n.next.next;
                res.next = null;
                size--;
                return res;
            }
            count++;
            n = n.next;
        }
        return null;
    }

    private Node getNode(int index) //метод, возвращающий ссылку на узел по его номеру в списке
    {
        Node n = head;
        int count = 0;
        while (n != null) {
            if (count == index) {
                return n;
            }
            count++;
            n = n.next;
        }
        return null;
    }

    private void addNode(int index,Node node) // метод, добавляющий узел в заданную позицию в списке
    {
        Node n = head;
        Node temp;
        int count = 0;
        while (n!=null){
            if (count+1==index){
                temp=n.next;
                n.next = node;
                node.next=temp;
                size++;
                return;
            }
            count++;
            n=n.next;
        }
    }

    private void addNode(Node node) // метод, добавляющий узел в конец списка
    {
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    private void setNode(int index, Node node) // метод, изменяющий узел с заданным номером
    {
        Node n = head;
        int count = 0;
        Node temp;
        while (n!=null){
            if (count+1==index){
                temp = n.next.next;
                n.next=node;
                node.next = temp;
            }
            count++;
            n=n.next;
        }
    }

    //Реализация методов интерфейса Exercise

    @Override
    public int getDuration() {
        int sum = 0;
        Approach[] approaches = getApproaches();
        for (int i = 0; i < approaches.length; i++) {
            sum+=approaches[i].getDuration();
        }
        return sum;
    }

    @Override
    public void setDuration(int duration) { }

    public boolean add(Approach approach) {
        addNode(new Node(approach));
        return true;
    }

    public Approach remove() {
        return removeNode(0).value;
    }

    public Approach approach() {
        return head.value;
    }

    public boolean add(int index, Approach approach) {
        addNode(index,new Node(approach));
        return true;
    }

    public Approach getApproach(int index) {
        return getNode(index).value;
    }

    public void setApproach(int index, Approach approach) {
        setNode(index,new Node(approach));
    }

    public Approach remove(int index) {
        return removeNode(index).value;
    }

    public int size() {
        return size;
    }

    public Approach[] getApproaches() {
        Approach[] returnArr=new Approach[size];
        Node n = head;
        int i = 0;
        while (n!=null){
            returnArr[i] = n.value;
            i++;
            n=n.next;
        }
        return returnArr;
    }

    public double[] approachWeights() {
        Approach[] approaches = getApproaches();
        double[] approachWeights = new double[approaches.length];
        for(int i = 0; i < approaches.length; i++){
            approachWeights[i] = approaches[i].getWeight();
        }
        return approachWeights;
    }

    public int[] approachRepetitions() {
        Approach[] approaches = getApproaches();
        int[] approachQuantities = new int[approaches.length];
        for(int i = 0; i < approaches.length; i++){
            approachQuantities[i] = approaches[i].getNumOfRepetitions();
        }
        return approachQuantities;
    }

    public Approach remove(Approach approach) {
        Node n = head;
        Node res;
        while (n!=null){
            if (approach==n.value){
                res=n.next;
                n.next = n.next.next;
                res.next=null;
                size--;
                return res.value;
            }
            n=n.next;
        }
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }
}