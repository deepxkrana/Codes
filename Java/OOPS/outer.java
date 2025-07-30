class outer{
    int sum=20;
    class inner{
        public int divisor;
        public int rem;
        public inner(){
            sum=15;
            divisor=4;
            rem=sum%divisor;
        }
        private int getdivisor(){
            return divisor;
        }
        private int getremainder(){
            return rem;
        }
        private int getquotient(){
            System.out.println("Inner Class");
            return sum/divisor;
        }
    }
    public outer(){
    inner inn=new inner();
    System.out.println("Quoteint is = "+inn.getquotient());
    System.out.println("Quoteint is = "+inn.getdivisor());
    System.out.println("Quoteint is = "+inn.getremainder());
    }
    public static void main(String[] args) {
        new outer();

    }
}
