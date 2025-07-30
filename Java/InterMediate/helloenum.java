// enum helloenum{
//     monday;
//     public static void main(String[] args){
//         System.out.println(args[0]);
//     }
// }


enum helloenum{
    monday,tuesday,wednesday;
    public static void main(String[] args){
        helloenum input[]=helloenum.values();
        for(helloenum a:input){
            System.out.println(a.ordinal()+" "+a);
        }
    }
}