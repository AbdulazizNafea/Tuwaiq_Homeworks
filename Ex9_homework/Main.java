package Ex9_homework;

public class Main {
    public static void main(String[] args){

        try{
            Book book=new Book("Light in Sky",15,"Ahmad");
            System.out.println(book.getName()+": "+book.getDiscount()+"$");
            Movie movie=new Movie("HangOver",5,"James s");
            System.out.println(movie.getName()+": "+movie.getDiscount()+"$");


            //Move interface
//
//        MoveablePoint move = new MoveablePoint(3,6, 10, 10);
//        move.moveUp();
//        move.moveDown();
//        move.moveLeft();
//        move.moveRight();
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
