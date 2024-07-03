import java.util.ArrayList;
// import java.util.Stack;

public class stack {
    class Stack1{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }


        //push in stack
        public static void push(int data){
            list.add(data);
        }
        //pop in stack
        public static void pop(int data){
            list.remove(data);
        }
        // public static void peek(int data){
        //     int first = list.get(list.size()-1);
        //     return first;
        // }
    }

    public static void main(String[] args) {
        // stack s = new stack();
        Stack1 s = new Stack1();
        s.push(1);        
        s.push(2);        
        s.push(3);        
        s.push(4);        
    }   
}
