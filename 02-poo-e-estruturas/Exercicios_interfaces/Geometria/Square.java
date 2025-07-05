package Geometria;

public record Square(int side) implements GeometricArea{
    @Override
    public double getArea() {
        return side * side;
    }
}
