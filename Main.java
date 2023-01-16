package Ex7_OOP;

public class Main {
    public static void main(String[] args) {
        try{
            Account account = new Account("1440-23","aziz",10000);
            Account account1 = new Account("13330-23","ahmad",8900);
            System.out.println(account.getBalance());
            System.out.println(account.debit(10));
            System.out.println(account.getBalance());
            System.out.println(account.transferTo(account1,500));
            System.out.println(account1.getBalance());

            System.out.println("--=-=-=-=-=-=-=-=-=--=-=-==-");
            Employee employee1 = new Employee(109209,"aziz",5690);
            System.out.println(employee1.raiseSalary(55));
            System.out.println(employee1.toString());
            //Employee employee2 = new Employee();
        }catch (Exception e){
            System.out.println(e.toString());
        }




        //int x=10;
        //System.out.println((1000*55)/100);
    }
}
