package Ex7_OOP;

public class Account {
    private String id;
    private String name;
    private int balance;
    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int credit (int amount){
        return amount+balance;
    }
    public int debit (int amount) throws Exception {
        //int newBalance;
        if(balance - amount <=0){
            throw new Exception("test debit");
        }else{
            balance -= amount;
        }
        return balance;
    }

    public int transferTo(Account acc,int amount) throws Exception {

        if(balance - amount <=0){
            throw new Exception("test debit");
        }else{
            balance -= amount;
            acc.balance += amount;
        }
        return balance;
    }
}
