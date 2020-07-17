package ru.l4gunner4l.figuresappmodule1.figures;

import android.graphics.Canvas;

abstract class Figure {

    private Point basePoint;

    public Figure(Point basePoint) {
        this.basePoint = basePoint;
    }

    abstract void draw(Canvas canvas);

    public void moveTo(int dx, int dy){
        basePoint.setX(basePoint.getX() + dx);
        basePoint.setY(basePoint.getY() + dy);
    }

    public Point getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Point basePoint) {
        this.basePoint = basePoint;
    }
}
