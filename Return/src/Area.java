public class Area {
    int width;
    int breadth;

    Area(int width, int breadth){
        this.width = width;
        this.breadth = breadth;
    }

    public int calculateArea(){
        int area  = width * breadth;
        return area;
    }
}
