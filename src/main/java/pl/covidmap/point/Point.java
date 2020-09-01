package pl.covidmap.point;

public class Point {

    private double lat;
    private double lon;
    private String text;

    public Point() {
    }

    public Point(double x, double y, String text) {
        this.lat = x;
        this.lon = y;
        this.text = text;
    }

    public double getX() {
        return lat;
    }

    public void setX(double x) {
        this.lat = x;
    }

    public double getY() {
        return lon;
    }

    public void setY(double y) {
        this.lon = y;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
