package Ex9_homework;

public class MoveablePoint implements Moveable{
    private int xSpeed,ySpeed,x, y;

    public MoveablePoint(int xSpeed, int ySpeed, int x, int y) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.x = x;
        this.y = y;
    }


    @Override
    public void moveUp() {
        y-=ySpeed;
        System.out.println(y);
    }

    @Override
    public void moveDown() {
        y+=ySpeed;
        System.out.println(y);
    }

    @Override
    public void moveLeft() {
        x-=xSpeed;
        System.out.println(x);
    }

    @Override
    public void moveRight() {
        x+=xSpeed;
        System.out.println(x);
    }
}
