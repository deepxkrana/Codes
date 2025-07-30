public class outer2{
    static int data=20;
    static class inner{
        static void msg(){
            System.out.println("Data is "+data);
        }
    }
    public static void main(String[] args){
        inner obj1=new inner(); //{option1
        obj1.msg();                     //}
        inner.msg();        //option2
        outer2.inner.msg();     //option3
    }
}
