package com.company.Collections;

public class Lista<T> {

    Node<T> head = null;

    public void add(T data){

        if (head == null){
            head = new Node<>();
            head.setData(data);
            head.setNext(null);
        }else {

            Node<T> iterator = head;

            while (iterator.getNext() != null){

               iterator = iterator.getNext();

            }

            Node<T> nou = new Node<>();
            nou.setData(data);
            iterator.setNext(nou);
            nou.setNext(null);
            head = nou;

        }

    }

    public void stergeSfarsit(){

        Node<T> iterator = head;

        while (iterator.getNext().getNext() != null){
            iterator = iterator.getNext();
        }

        iterator.setNext(iterator.getNext());
    }

    public void stergeStart(){

        head = head.getNext();

    }

    public int indexOf(T data){

        int index = 0;

        Node<T> iterator = head;

        while (iterator.getData().equals(data) == false){
            iterator = iterator.getNext();
            index++;
        }

        return index;

    }

    public void stergePozitie(int index){

        int count = 0;

        Node<T> it = head;

        while (count != index){
            it = it.getNext();
            count++;

        }

        it.setNext(it.getNext().getNext());

    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }

    public boolean contains(T data){

        Node<T> iterator = head;

        while (iterator != null ){

            if ( iterator.getData().equals(data)){
                return true;
            }

            iterator = iterator.getNext();
        }
        return false;

    }

    public int size(){

        Node<T> iterator = head;
        int cout = 0;

        while (iterator!= null){
            iterator = iterator.getNext();
            cout++;
        }

        return cout;
    }

    public T get(int index){

        Node<T> iterator = head;
        int cout = 0;

        while (cout != index && iterator != null){
            iterator = iterator.getNext();
            cout++;
        }

        return iterator.getData();

    }

    public void traverse(){

        Node<T> iterator = head;

        while (iterator != null){
            System.out.println(iterator.getData());
            iterator = iterator.getNext();
        }

    }

    public Node<T>iterator(){
        return head;
    }

    public void remove(T data){

        int poz = indexOf(data);

        if (poz == 0){
            this.stergeStart();
        }else if (poz > 0 && poz < size() -1){
            this.stergePozitie(poz);
        }else {
            this.stergeSfarsit();
        }

    }

    public void clear(){
        while (head != null){
            head.setData(null);
        }
    }

    public void remove(int pozitie){

        if (pozitie == 0){
            this.stergeStart();
        }else if (pozitie > 0 && pozitie < size() -1){
            this.stergePozitie(pozitie);
        }else {
            this.stergeSfarsit();
        }

    }

}
