import java.awt.*;

public class Pipe extends GameObject implements Collidable {
    private boolean passed = false;

    public Pipe(Image img, int x, int y, int width, int height) {
        super(x, y, width, height, img);
    }

    @Override
    public void update() {
        x -= 4; // Move pipe to the left
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

    public boolean isPassed() { return passed; }
    public void setPassed(boolean passed) { this.passed = passed; }

    @Override
    public boolean isColliding(GameObject other) {
        return x < other.x + other.width &&
               x + width > other.x &&
               y < other.y + other.height &&
               y + height > other.y;
    }
}