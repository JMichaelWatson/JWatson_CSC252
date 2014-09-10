/**
 * Created by JMichael on 9/8/2014.
 */
public class MyPixel {


    public static MyPixel min(MyPixel first, MyPixel second, MyPixel third){
        if(first.getEnegery() < second.getEnegery()){
            if(first.getEnegery()< third.getEnegery()) {
                return first;
            }else{
                return third;
            }
        }else if(second.getEnegery() < third.getEnegery()){
            return second;
        }else{
            return third;
        }
    }
    public static MyPixel min(MyPixel first, MyPixel second){
        if(first.getEnegery() < second.getEnegery()){
            return first;
        }else{
            return second;
        }
    }
    private double energy = 0;
    private MyPixel parentPath;
    private int[] coordinates;
    private double sortedWeight = Double.MAX_VALUE;

    public MyPixel(double energy, int[] coor, MyPixel parent) {
        this.energy = energy;
        this.coordinates = coor;
        this.parentPath = parent;
    }

    public double getSortedWeight() {
        return sortedWeight;
    }

    public void setSortedWeight(double sortedWeight) {
        this.sortedWeight = sortedWeight;
    }

    public double getEnegery() {
        return energy;
    }

    public void setEnegery(double enegery) {
        this.energy = enegery;
    }

    public MyPixel getParentPath() {
        return parentPath;
    }

    public void setParentPath(MyPixel parentPath) {
        this.parentPath = parentPath;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object e) {
        boolean match = false;
        if (e.getClass() == this.getClass()) {
            MyPixel temp = (MyPixel) e;
            if (temp.getCoordinates()[0] == this.coordinates[0]
                    && temp.getCoordinates()[1] == this.coordinates[1]) {
                match = true;
            }
        }
        return match;

    }

}
