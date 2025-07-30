class nonstaticnested{

    public nonstaticnested() {
        System.out.println("Hii");
    }
    int a=5;
    void disp2(){
        System.out.println("Hello");
    }
    static void disp(){
        System.out.println("Hiiii");
    }
    class XYZ{
        XYZ(){
            System.out.println("Hello HII");
        }
        void display(){
            System.out.println("Inside staic nested class "+a);
            disp();
            disp2();
        }
    }
    class XYZ1{
        void display3(){
            System.out.println("Inside staic nested class "+a);
            disp();
            // display();
            disp2();
        }
    }
    public static void main(String[] args) {
        nonstaticnested obj=new nonstaticnested();
        nonstaticnested.XYZ obj1=obj.new XYZ();
        nonstaticnested.XYZ1 obj2=obj.new XYZ1();
        obj1.display();
    }
}
