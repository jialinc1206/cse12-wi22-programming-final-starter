/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * File description: 
 */

import java.util.List;
import java.util.ArrayList;

/**
 * TODO: Add class header
 */
public class CSE12NaryTree<E> {
    
    /**
     * This inner class encapsulates the data and children for a Node.
     */
    class Node{
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
         * Add the node to children
         * 
         * @param n The node to add
         */
        public void addChild(Node n) {
            children.add(n);
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
        this.N = N;
    }

    public void add(E element) {
        //TODO
    }


    public boolean contains(E element) {
        //TODO
        return false;
    }

    public List<E> sortTree(){
        //TODO
        return null;
    }
}