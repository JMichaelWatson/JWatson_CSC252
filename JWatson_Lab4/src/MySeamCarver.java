/**
 * Created by JMichael on 9/8/2014.
 */

import edu.neumont.ui.Picture;


import java.awt.Color;
import java.util.*;


public class MySeamCarver {

    private MyPixel[][] pixelPaths;
    private Picture pic;

    public MySeamCarver(Picture pic) {
        this.pic = pic;
        pixelPaths = new MyPixel[pic.width()][pic.height()];
        System.out.println("Width: " + width());
        System.out.println("Height: " + height());
    }


    public Picture getPicture() {
        return this.pic;
    }

    public int width() {
        return this.pic.width();
    }

    public int height() {
        return this.pic.height();
    }

    public double energy(int x, int y) {
        int rX = 0, bX = 0, gX = 0, rY = 0, bY = 0, gY = 0;
        double dX2, dY2;
        //X values
        //rX
        if (x == 0) {
            rX = 0 - this.pic.get(x + 1, y).getRed();
        } else if (x == this.width() - 1) {
            rX = this.pic.get(x - 1, y).getRed();
        } else {
            rX = this.pic.get(x - 1, y).getRed() - this.pic.get(x + 1, y).getRed();
        }
        //gX
        if (x == 0) {
            gX = 0 - this.pic.get(x + 1, y).getGreen();
        } else if (x == this.width() - 1) {
            gX = this.pic.get(x - 1, y).getGreen();
        } else {
            gX = this.pic.get(x - 1, y).getGreen() - this.pic.get(x + 1, y).getGreen();
        }
        //bX
        if (x == 0) {
            bX = 0 - this.pic.get(x + 1, y).getBlue();
        } else if (x == this.width() - 1) {
            bX = this.pic.get(x - 1, y).getBlue();
        } else {
            bX = this.pic.get(x - 1, y).getBlue() - this.pic.get(x + 1, y).getBlue();
        }
        //Y Values
        //rY
        if (y == 0) {
            rY = 0 - this.pic.get(x, y + 1).getRed();
        } else if (y == this.height() - 1) {
            rY = this.pic.get(x, y - 1).getRed();
        } else {
            rY = this.pic.get(x, y - 1).getRed() - this.pic.get(x, y + 1).getRed();
        }
        //gY
        if (y == 0) {
            gY = 0 - this.pic.get(x, y + 1).getGreen();
        } else if (y == this.height() - 1) {
            gY = this.pic.get(x, y - 1).getGreen();
        } else {
            gY = this.pic.get(x, y - 1).getGreen() - this.pic.get(x, y + 1).getGreen();
        }
        //bY
        if (y == 0) {
            bY = 0 - this.pic.get(x, y + 1).getBlue();
        } else if (y == this.height() - 1) {
            bY = this.pic.get(x, y - 1).getBlue();
        } else {
            bY = this.pic.get(x, y - 1).getBlue() - this.pic.get(x, y + 1).getBlue();
        }
        dX2 = (Math.pow(rX, 2) + Math.pow(gX, 2) + Math.pow(bX, 2));
        dY2 = (Math.pow(rY, 2) + Math.pow(gY, 2) + Math.pow(bY, 2));

        return dX2 + dY2;
    }

    public int[] findVerticalSeam() {
        pixelPaths = new MyPixel[this.width()][this.height()];
        for (int y = 0; y < this.height(); y++) {
            for (int x = 0; x < this.width(); x++) {
                pathSetupVert(x, y);
            }
        }

        int smallestX = 0;
        int y = this.height() - 1;
        for (int x = 1; x < this.width(); x++) {
            if (pixelPaths[x][y].getEnegery() < pixelPaths[smallestX][y].getEnegery()) {
                smallestX = x;
            }
        }
        int[] result = new int[height()];
        MyPixel current = pixelPaths[smallestX][this.height() - 1];
        while (current != null) {
            result[current.getCoordinates()[1]] = current.getCoordinates()[0];
            current = current.getParentPath();
        }
        return result;
    }

    private void pathSetupVert(int x, int y) {
        if (y < this.height()) {
            if (y == 0 && x < this.width()) {
                pixelPaths[x][y] = new MyPixel(energy(x, y), new int[]{x, y}, null);
            } else if (x == 0) {
                double currentEnergy = energy(x, y);
                MyPixel parent = MyPixel.min(pixelPaths[x][y - 1], pixelPaths[x + 1][y - 1]);
                pixelPaths[x][y] = new MyPixel(currentEnergy + parent.getEnegery(), new int[]{x, y}, parent);
            } else if (x == this.width() - 1) {
                double currentEnergy = energy(x, y);
                MyPixel parent = MyPixel.min(pixelPaths[x - 1][y - 1], pixelPaths[x][y - 1]);
                pixelPaths[x][y] = new MyPixel(currentEnergy + parent.getEnegery(), new int[]{x, y}, parent);
            } else if (x > 0 && x < this.width()) {
                double currentEnergy = energy(x, y);
                MyPixel parent = MyPixel.min(pixelPaths[x - 1][y - 1], pixelPaths[x + 1][y - 1], pixelPaths[x][y - 1]);
                pixelPaths[x][y] = new MyPixel(currentEnergy + parent.getEnegery(), new int[]{x, y}, parent);
            }
        }
    }

    public void piantLine() {
        for (int x = 0; x < this.width(); x++) {
            this.pic.set(x, 0, Color.RED);
        }
    }

    public void paintLine2() {
        for (int x = 0; x < this.height(); x++) {
            this.pic.set(0, x, Color.RED);
        }
    }

    private void pathSetupHorz(int x, int y) {
        if (x < this.width()) {
            if (x == 0 && y < this.height()) {
                pixelPaths[x][y] = new MyPixel(energy(x, y), new int[]{x, y}, null);
            } else if (y == 0) {
                double currentEnergy = energy(x, y);
                MyPixel parent = MyPixel.min(pixelPaths[x - 1][y], pixelPaths[x - 1][y + 1]);
                pixelPaths[x][y] = new MyPixel(currentEnergy + parent.getEnegery(), new int[]{x, y}, parent);
            } else if (y == this.height() - 1) {
                double currentEnergy = energy(x, y);
                MyPixel parent = MyPixel.min(pixelPaths[x - 1][y], pixelPaths[x - 1][y - 1]);
                pixelPaths[x][y] = new MyPixel(currentEnergy + parent.getEnegery(), new int[]{x, y}, parent);
            } else if (y > 0 && y < this.height()) {
                double currentEnergy = energy(x, y);
                MyPixel parent = MyPixel.min(pixelPaths[x - 1][y], pixelPaths[x - 1][y - 1], pixelPaths[x - 1][y + 1]);
                pixelPaths[x][y] = new MyPixel(currentEnergy + parent.getEnegery(), new int[]{x, y}, parent);
            }
        }
    }

    public int[] findHorizontalSeam() {
        pixelPaths = new MyPixel[this.width()][this.height()];
        for (int x = 0; x < this.width(); x++) {
            for (int y = 0; y < this.height(); y++) {
                pathSetupHorz(x, y);
            }
        }
        int smallestY = 0;
        int x = this.width() - 1;
        for (int y = 1; y < this.height(); y++) {
            if (pixelPaths[x][y].getEnegery() < pixelPaths[x][smallestY].getEnegery()) {
                smallestY = y;
            }
        }
        int[] result = new int[width()];
        MyPixel current = pixelPaths[x][smallestY];
        while (current != null) {
            result[current.getCoordinates()[0]] = current.getCoordinates()[1];
            current = current.getParentPath();
        }
        return result;
    }

    public void removeHorizontalSeam(int[] indices) {
        Picture newPic = new Picture(this.width(), height()-1);
        int currentY = 0;
        for (int x = 0; x < width(); x++) {
            for (int y = 0; y < this.height(); y++) {
                if (indices[x] != y) {
                    newPic.set(x, currentY, this.pic.get(x, y));
                    currentY++;
                }
            }
            currentY = 0;
        }
        this.pic = newPic;
    }

    public void removeVerticalSeam(int[] indices) {
        Picture newPic = new Picture(this.width() - 1, height());
        int currentX = 0;
        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < this.width(); x++) {
                if (indices[y] != x) {
                    newPic.set(currentX, y, this.pic.get(x, y));
                    currentX++;
                }
            }
            currentX = 0;
        }

        this.pic = newPic;
    }

    public void paintVert(int[] indices) {
        for (int x = 0; x < height(); x++) {
            pic.set(indices[x], x, Color.CYAN);
        }
    }

    public void paintHorz(int[] indices) {
        for (int x = 0; x < width(); x++) {
            pic.set(x, indices[x], Color.CYAN);
        }
    }


    public double getEnergy(int x, int y) {
        return energy(x, y);
    }


}


//boolean isMoved = false;
//Picture newPic = new Picture(this.width()-1,height());
//for(int x = 0; x < width()-1;x++){
//        for(int y = 0; y < this.height(); y++){
//        if(isMoved){
//        newPic.set(x,y,this.pic.get(x+1,y));
//        }else{
//        if(indices[y] == x) {
//        isMoved = true;
//        }else {
//        newPic.set(x, y, this.pic.get(x, y));
//        }
//
//        }
//        }
//        isMoved = false;
//        }
//        this.pic = newPic;

//boolean isMoved = false;
//Picture newPic = new Picture(this.width(), height() - 1);
//for (int x = 0; x < width(); x++) {
//        for (int y = 0; y < this.height() - 1; y++) {
//        if (isMoved) {
//        newPic.set(x, y, this.pic.get(x, y + 1));
//        } else {
//        if (indices[x] == y) {
//        isMoved = true;
//        } else {
//        newPic.set(x, y, this.pic.get(x, y));
//        }
//
//        }
//
//        }
//        isMoved = false;
//        }
//        this.pic = newPic;
