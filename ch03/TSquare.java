package ch03;
import java.awt.*;
import java.awt.image.*;
import java.awt.color.*;
import java.io.*;
import javax.imageio.*;

public class TSquare {

    static final int SIDE = 1000; //image is SIDE X SIDE
    static BufferedImage image = new BufferedImage(SIDE, SIDE, BufferedImage.TYPE_INT_RGB);
    static final int WHITE = Color.WHITE.getRGB();
    static final int BLUE = Color.BLUE.getRGB();

    private static void drawSquare(int x, int y, int s) {
        //center of square is x,y, length of side is s
        if (s <= 0) { //Base case
            return;
        } else {
            //Determine corners
            int left = x - s / 2;
            int right = x + s / 2;
            int top = y - s / 2;
            int bottom = y + s / 2;

            //Print white square
            for (int i = left; i < right; i++) {
                for (int j = top; j < bottom; j++) {
                    image.setRGB(i, j, WHITE);
                }
            }

            //recursively paint squares at corners
            drawSquare(left, top, s / 2);
            drawSquare(left, bottom, s / 2);
            drawSquare(right, top, s / 2);
            drawSquare(right, bottom, s / 2);
        }
    }


    public static void main(String[] args) throws IOException {
        String fileOut = "fractal1";
        String file2 = "fractal2";

        //make image black
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                image.setRGB(i, j, BLUE);
            }
        }

        drawSquare(SIDE/2,SIDE/2,SIDE/2);
        File outputfile = new File(file2);
        ImageIO.write(image, "jpg", outputfile);
    }
}

