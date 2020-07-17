package ru.l4gunner4l.figuresappmodule1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.Random;

import ru.l4gunner4l.figuresappmodule1.figures.Circle;
import ru.l4gunner4l.figuresappmodule1.figures.Ellipse;
import ru.l4gunner4l.figuresappmodule1.figures.Point;
import ru.l4gunner4l.figuresappmodule1.figures.Rectangle;
import ru.l4gunner4l.figuresappmodule1.figures.Square;

public class DrawView extends View {

    private static final int STEP = 40;

    Paint p;
    private Circle[] circles;
    private Ellipse[] ellipses;
    private Rectangle[] rectangles;
    private Square[] squares;
    private Random random;

    public DrawView(Context context) {
        super(context);
        p = new Paint();
        random = new Random();
        circles = new Circle[]{
                new Circle(new Point(400, 400), 50),
                new Circle(new Point(400, 600), 50)
        };
        squares = new Square[]{
                new Square(new Point(400, 400), 50),
                new Square(new Point(400, 600), 80)
        };
        rectangles = new Rectangle[]{
                new Rectangle(new Point(400, 950), 50, 40),
                new Rectangle(new Point(400, 900), 80, 40)
        };
        ellipses = new Ellipse[]{
                new Ellipse(new Point(400, 500), 100, 50),
                new Ellipse(new Point(400, 800), 30, 50)
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        for (Circle c : circles) {
            c.draw(canvas);
        }
        for (Ellipse e : ellipses) {
            e.draw(canvas);
        }
        for (Rectangle r : rectangles) {
            r.draw(canvas);
        }
        for (Square s : squares) {
            s.draw(canvas);
        }
    }

    @Override
    public void invalidate() {
        for (Circle c : circles) {
            c.moveTo(
                    -STEP + random.nextInt(STEP*2),
                    -STEP + random.nextInt(STEP*2)
            );
        }
        for (Ellipse e : ellipses) {
            e.moveTo(-STEP + random.nextInt(STEP*2),
                    -STEP + random.nextInt(STEP*2)
            );
            e.changeColor(-random.nextInt(16777216));
        }
        for (Square s : squares) {
            s.moveTo(-STEP + random.nextInt(STEP*2),
                    -STEP + random.nextInt(STEP*2)
            );
            s.changeColor(-random.nextInt(16777216));
        }
        for (Rectangle r : rectangles) {
            r.moveTo(-STEP + random.nextInt(STEP*2),
                    -STEP + random.nextInt(STEP*2)
            );
            r.changeColor(-random.nextInt(16777216));
        }
        super.invalidate();
    }
}
