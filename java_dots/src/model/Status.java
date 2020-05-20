package model;

public class Status {
    public boolean top;
    public boolean bottom;
    public boolean left;
    public boolean right;

    public Status(){
        this.top = false;
        this.bottom = false;
        this.left = false;
        this.right = false;
    }

    public Status(boolean top, boolean bottom, boolean left, boolean right){
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public Status clone() {
        return new Status(this.top, this.bottom, this.left, this.right);
    }
    public void set(boolean top, boolean bottom, boolean left, boolean right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

}
