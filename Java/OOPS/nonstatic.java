class nonstatic{
    static int a=5;
    void disp2(){
        System.out.println("hello");
    }
    static void disp(){
        System.out.println("Hii");
    }
    static class XYZ{
        void display(){
            System.out.println("inside Static nested class "+a);
            disp();
            // disp2();
        }
    }
    static class XYZ1{
        void display2(){
            System.out.println("inside Static nested class "+a);
            disp();
            // display();
            // disp2();
        }
    }
    public static void main(String[] args) {
        XYZ obj=new XYZ();
        XYZ1 obj1=new XYZ1();
        obj1.display2();
        obj.display();
    }
}
