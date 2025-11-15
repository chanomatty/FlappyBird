import java.awt.*;

public class Bird extends GameObject implements Collidable {
    private double velocityY = 0;
    private final double gravity = 0.4;     // smoother falling speed
    private final double jumpStrength = -6.5; // gentler jump

    public Bird(Image img, int x, int y, int width, int height) {
        super(x, y, width, height, img);
    }

    @Override
    public void update() {
        velocityY += gravity;
        y += velocityY;

        // Prevent bird from flying off the top
        y = Math.max(y, 0);

        // Prevent bird from falling below bottom
        if (y > 640 - height) {
            y = 640 - height;
        }
    }

    public void jump() {
        velocityY = jumpStrength;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

    @Override
    public boolean isColliding(GameObject other) {
        return x < other.x + other.width &&
               x + width > other.x &&
               y < other.y + other.height &&
               y + height > other.y;
    }

    public int getYPosition() { return y; }
}