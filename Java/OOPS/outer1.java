class outer1{
    int data=10;
    private int getvalue(){
        return data;
    }
    public static void main(String[] args) {
        outer1 out=new outer1();
        for(int i=out.getvalue();i<15;i++){
            class inner{
                public int getvalue(){
                    System.out.println("Inner class");
                    return out.getvalue();
                }
            }
            inner inn=new inner();
            System.out.println("Value of inner class is "+inn.getvalue());
        }
    }
}
