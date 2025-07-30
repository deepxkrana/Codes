// interface Age{
//     int x=21;
//     void getage();
// }
// // class myclass implements Age{
// //     public void getage(){
// //         System.out.println("Age is "+x);
// //     }
// // }
// class anonym{
//     public static void main(String[] args) {
//         Age obj=new Age(){public void getage(){System.out.println("data is "+x);}};
//         obj.getage();
//     }
// }


// interface abc{
//     public int name(int a,int b);
// }
// class anonym{
//     public static void main(String[] args){
//         abc a1=(int a,int b)->{return(a+b);};
//         System.out.println(a1.name(5,6));
//     }
// }


// interface abc{
//     public String name(String s);
// }
// class anonym{
//     public static void main(String[] args){
//         String ab="Hello";
//         abc a1=(str)->{return ab+str;};
//         System.out.println(a1.name(" world"));
//     }
// }


// interface abc{
//     void print();
// }
// class anonym{
//     int a;
//     anonym(int a){
//         this.a=a;
//     }
//     void show(){
//         abc a1=()-> {System.out.println("a: "+a);};
//         a1.print();
//     }
//     public static void main(String[] args) {
//         anonym ab=new anonym(19);
//         ab.show();
//     }
// }


interface abc{
    void print();
}
class anonym{
    static int a=120;
    void show(){
        abc a1=()-> {System.out.println("a: "+a);};
        a1.print();
    }
    public static void main(String[] args) {
        anonym ab=new anonym();
        ab.show();
    }
}
