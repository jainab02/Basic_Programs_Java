import java.util.ArrayList;
// import java.util.Stack;

public class StackClass {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }


        //push in stack
        public static void push(int data){
            list.add(data);
        }
        //pop in stack
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int first = list.get(list.size()-1);
            list.remove(list.size()-1);
            return first;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Stack  s= new Stack();
        // Stack1 s = new Stack1();
        s.push(1);        
        s.push(2);        
        s.push(3);        
        s.push(4);        
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }   
}
