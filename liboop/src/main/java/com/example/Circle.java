package com.example;

/**
 * 12. Создать класс - Круг. Поле - радиус. Функции-члены вычисляют площадь, длину окружности,
 * устанавливает поля и возвращают значения. Функции-члены установки полей класса должны проверять
 * корректность задаваемых параметров. Функция печати.
 */
public class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double circleSquare() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public double circleLength() {
        return this.radius * Math.PI;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (Double.compare(circle.radius, radius) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + " square=" + Double.toString(circleSquare()) +
                " length=" + Double.toString(circleLength()) + "}";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
