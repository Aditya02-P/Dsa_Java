package Generics.det;

class Node<T> {
    public void setData(T data) {
        System.out.println("Node Data");
    }
}

class MyNode extends Node<Integer> {
    // You intend to OVERRIDE setData
   final public void setData(Integer data) {
        System.out.println("MyNode Data");
    }
}
