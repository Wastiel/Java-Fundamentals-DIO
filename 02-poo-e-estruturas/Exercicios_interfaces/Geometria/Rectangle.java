package Geometria;

public record Rectangle(double heigth, double base) implements GeometricArea {
    @Override
    public double getArea() {
        return heigth * base;
    }
}
