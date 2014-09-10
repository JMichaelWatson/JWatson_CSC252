/**
 * Created by JMichael on 9/8/2014.
 */

import edu.neumont.ui.Picture;

import java.awt.*;

public class Program {

    public static void main(String[] args) {
        Picture pic = new Picture("overlayimagewithhiddenmessage.png");
//        Picture pic = new Picture("Test.png");
//        Picture pic = new Picture("SmallTest.png");
//        Picture pic = new Picture(2,2);
//        pic.set(0,0, Color.RED);
//        pic.set(0,1, Color.BLUE);
//        pic.set(1,0, Color.RED);
//        pic.set(1,1, Color.BLUE);
//        pic.show();
        MySeamCarver seam = new MySeamCarver(pic);
//        System.out.println(seam.getEnergy(1,1));
//        for(int x = 0; x < 50; x++) {
//            System.out.println("Finding Horz: " + (x+1));
//            int[] indices = seam.findHorizontalSeam();
////            seam.paintHorz(indices);
//            seam.removeHorizontalSeam(indices);
//        }
        for(int x = 0; x < 200; x++){
            System.out.println("Finding Seam: " + (x+1));
            int[] indices = seam.findVerticalSeam();
//            seam.paintVert(indices);
            seam.removeVerticalSeam(indices);
            seam.removeHorizontalSeam(seam.findHorizontalSeam());
//            seam.paintHorz(seam.findHorizontalSeam());
        }
        seam.getPicture().show();
    }

}
