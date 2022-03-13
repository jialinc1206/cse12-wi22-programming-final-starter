/**
 * Name: Jialin Chen
 * ID: A16636887
 * Email: jic053@ucsd.edu
 * File description: This file containes a tree class
 * that's been implements to meet the requirements for 
 * CSE12 Winter22 Fianl
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Implements a generic N-art tree with methods
 * to add, find, and sort the tree.
 */
public class CSE12NaryTree<E extends Comparable<E>> {

    /**
     * This inner class encapsulates the data and children for a Node.
     * Do NOT edit this inner class.
     */
    protected class Node{
        E data;
        List<Node> children;
    
        /**
         * Initializes the node with the data passed in
         * 
         * @param data The data to initialize the node with
         */
        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    
        /**
         * Getter for data
         * 
         * @return Return a reference to data
         */
        public E getData() {
            return data;
        }

        /**
         * Setter for the data
         * 
         * @param data Data that this node is set to
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Getter for children
         * 
         * @return reference to the list of children
         */
        public List<Node> getChildren() {
            return children;
        }

        /**
         * Returns the number of children
         * 
         * @return number of children
         */
        public int getNumChildren() {
            // assume there are no nulls in list
            return children.size();
        }

        /**
         * Add the given node to this node's list of children
         * 
         * @param node The node to add
         */
        public void addChild(Node node) {
            children.add(node);
        }
    
    }
    
    Node root;
    int size;
    int N;

    /**
     * Constructor that initializes an empty N-ary tree, with the given N
     * 
     * @param N The N the N-tree should be initialized with
     */
    public CSE12NaryTree(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.root = null;
        this.size = 0;
        this.N = N;
    }

    /**
     * Add a new Node containing element to the N-ary tree in level order
     * @param element the element to be added to the tree
     */
    public void add(E element) {
        if(element == null) 
            throw new IllegalArgumentException();

        Node toAdd = new Node(element);

        if(this.size == 0){
            this.root = toAdd;
            this.size++;
        }
        else{
            Queue<Node> nodes = new LinkedList<>();
            nodes.add(this.root);
            while(!nodes.isEmpty()){
                Node curr = nodes.poll();
                // if curr is not full
                // add the element to curr's children
                if(curr.getNumChildren() < this.N){
                    curr.addChild(toAdd);
                    this.size++;
                    break;
                }
                // if curr is full, add curr's children to nodes
                else{
                    for(Node n : curr.children){
                        nodes.add(n);
                    }
                }
            }
        }
    }

    /**
     * Check if element is in the N-ary tree
     * @param element element to be checked
     * @return true if element is in the N-ary tree 
     * and false otherwise.
     */
    public boolean contains(E element) {
        if(element == null) 
            throw new IllegalArgumentException();

        if(this.size == 0) return false;

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(this.root);

        while(!nodes.isEmpty()){
            Node curr = nodes.poll();
            // return true if element is found
            if(curr.getData().equals(element)) 
                return true;
            // else, add curr's children to nodes
            for(Node n : curr.children)
                nodes.add(n);
        }
        // return false is element not found
        return false;
    }

    /**
     * Use a PriorityQueue and perform heap sort on the tree 
     * not modifying the tree itself
     * @return an ArrayList of all elements in the tree 
     * in sorted order (ascending)
     */
    public ArrayList<E> sortTree(){
        ArrayList<E> toReturn = new ArrayList<>(this.size);

        if(this.size==0) 
            return toReturn;

        PriorityQueue<E> sorted = new PriorityQueue<>(this.size);
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(this.root);

        // level order traverse the tree into nodes and sorted
        while(!nodes.isEmpty()){
            Node curr = nodes.poll();
            sorted.add(curr.getData());
            if(curr.getNumChildren() > 0){
                for(Node n : curr.children)
                    nodes.add(n);
            }
        }
        
        // copy element from sorted into toReturn ane return
        while(!sorted.isEmpty()){
            E e = sorted.poll();
            toReturn.add(e);
        }
        return toReturn;
    }
}
