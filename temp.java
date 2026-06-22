import java .util.*;
public class temp{
    static class Queue{
        static int arr[];
        static int rear = -1;
        static int size;
        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty(){
            return rear==-1;
        }

        public static void add(int data){
            if(rear==size-1){
                System.out.println("full queue");
                return;
            }

            rear++;
            arr[rear]=data;
        }

        public static int remove(){

            int front  = arr[0];
            for(int i=0; i<rear; i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }
    }
    public static void main(String[] args){
        
    }


}