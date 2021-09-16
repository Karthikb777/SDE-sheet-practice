package DSAprep;

/*
*       implementation of LRU cache [least recently used cache]:
*           use hashmap and doubly linked list to implement LRU cache
*
*           4 main methods, 2 public and 2 private
*           private:
*               insert:
*                   inserts a the node containing key value pairs right after the head of DLL and inserts/updates in the map
*               delete:
*                   removes the entry of the specified key from the hashmap and also deletes from the DLL
*
*           public:
*               get(key):
*                   retrieves the value associated with the key from the LRU cache
*                   check if key is in map, if it isn't return -1
*                   if it is present in map,
*                       delete the node associated with key in the DLL
*                       insert the node again into the DLL and update the node address in the map
*                       deleting and inserting is done to ensure that the least recently used is moved back in the DLL
*               put(key, value):
*                   inserts the given key value pair into the LRU cache
*                   check if the map has the given key
*                       if yes, delete the entry from the map and the node by using the delete function
*                   check if the map's size is equal to the capacity of the LRU cache
*                       if yes, delete the tail's prev node
*                   finally insert the key value pair into the DLL and insert/update the entry of key - node in the map
*                   if the size == capacity, deleting the tail's prev node makes sure that the least recently used
*                   entry is deleted and space is made for the new key value pair node to be inserted into the LRU cache
*
*           TC - O(1)
*
* */

import java.util.HashMap;
import java.util.Scanner;

public class D13LRUcache {

//    doubly linked list node for the LRU cache containing key value pair
    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
            prev = next = null;
        }
    }

//    capacity of the LRU cache
    int capacity;
//    hashmap to store the key and the node address
    HashMap<Integer, Node> map;
//    head and tail node of the DLL
    Node head, tail;

    public D13LRUcache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

//    get method - retrieves the value from the specified key from the LRU
    public int get(int key) {
//        check if map has key
        if (map.containsKey(key)) {
            Node node = map.get(key);

//            delete the node associated with the key
            delete(node);

//            insert the node right after the head
            insert(node);

//            return the node's value
            return node.value;
        }
//        if the map doesn't have the specified key, return -1
        return -1;
    }

//    put method - inserts the key value pair into the LRU
    public void put(int key, int value) {
//        check if map has the key
        if (map.containsKey(key)) {
            delete(map.get(key));
        }

//        check if size == capacity
        if (map.size() == capacity) {
            delete(tail.prev);
        }

//        insert the node into the dll and map
        insert(new Node(key, value));
    }

//    insert method - inserts the node right after head in DLL and also inserts/updates the key - node address pair in the map
    private void insert(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
        map.put(node.key, node);
    }

//    delete method - deletes the given node and also removes the key - node address pair from the map
    private void delete(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


//  test code to test the LRU cache
class testLRU {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("LRU cache test");
        System.out.print("enter size of cache: ");

        D13LRUcache lru = new D13LRUcache(scanner.nextInt());
//       scanner.next

        int select = 0;
        while(select != 3) {
            select = 0;
            System.out.println("enter the option: 1. get 2. put 3. exit");
            select = scanner.nextInt();

            switch (select) {
                case 1 -> {
                    System.out.println("enter the key to get the value:");
                    int key = scanner.nextInt();
                    System.out.println("value: " + lru.get(key));
                }
                case 2 -> {
                    System.out.println("enter the key value pair to insert: ");
                    int key, value;
                    key = scanner.nextInt();
                    value = scanner.nextInt();
                    lru.put(key, value);
                    System.out.println("inserted.");
                }
            }
        }
        System.out.println("test completed");
    }
}
