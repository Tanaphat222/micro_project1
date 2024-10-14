package GameFinal;

import java.awt.Color;

public class Block {
    int x, y;          // ตำแหน่งของบล็อค
    int width, height; // ขนาดของบล็อค
    Color color;       // สีของบล็อค
    
    public static final Color LightBlue = new Color(57, 127, 195);
    public static final Color SoftRed = new Color(194, 24, 7);
    public static final Color Citron = new Color(254, 223, 78);
    public static final Color Green = new Color(113, 173, 153);

    public Block(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
}
