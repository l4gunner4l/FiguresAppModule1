package ru.l4gunner4l.figuresappmodule1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.l4gunner4l.figuresappmodule1.figures.Circle;
import ru.l4gunner4l.figuresappmodule1.figures.ColorChangeble;
import ru.l4gunner4l.figuresappmodule1.figures.Ellipse;
import ru.l4gunner4l.figuresappmodule1.figures.Figure;
import ru.l4gunner4l.figuresappmodule1.figures.Point;
import ru.l4gunner4l.figuresappmodule1.figures.Rectangle;
import ru.l4gunner4l.figuresappmodule1.figures.Square;

public class DrawView extends View {

    private static final int STEP = 40;

    Paint p;
    private ArrayList<Figure> figures;
    private Random random;

    public DrawView(Context context) {
        super(context);
        p = new Paint();
        random = new Random();
        figures = new ArrayList<>();
        figures.add(new Circle(new Point(400, 400), 50));
        figures.add(new Circle(new Point(400, 600), 50));
        figures.add(new Square(new Point(400, 400), 50));
        figures.add(new Square(new Point(400, 600), 80));
        figures.add(new Rectangle(new Point(400, 950), 50, 40));
        figures.add(new Rectangle(new Point(400, 900), 80, 40));
        figures.add(new Ellipse(new Point(400, 500), 100, 50));
        figures.add(new Ellipse(new Point(400, 800), 30, 50));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        for (Figure f : figures) {
            f.draw(canvas);
        }
    }

    @Override
    public void invalidate() {
        for (Figure f : figures) {
            f.moveTo(
                    -STEP + random.nextInt(STEP*2),
                    -STEP + random.nextInt(STEP*2)
            );
            if (f instanceof ColorChangeble){
                ((ColorChangeble) f).changeColor(-random.nextInt(16777216));
            }
        }
        super.invalidate();
    }
}
