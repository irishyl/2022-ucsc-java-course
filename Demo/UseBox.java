package Demo;
/*
 * Week5: Classes: accessor, mutator, constructor, toString()
 */
class Box{
    // state
    private int hSize = 20;
    private int vSize = 10;
    private String hStr = "-";
    private String vStr = "|";
    private String fillerStr = " ";

    // constructor
    public Box(int hSize, int vSize, String hStr, String vStr, String fillerStr) {
        this.hSize = hSize;
        this.vSize = vSize;
        this.hStr = hStr;
        this.vStr = vStr;
        this.fillerStr = fillerStr;
    }

    // accessor method
    public int gethSize() {
        return hSize;
    }
    // mutator method
    public void sethSize(int hSize) {
        this.hSize = hSize;
    }

    public int getvSize() {
        return vSize;
    }

    public void setvSize(int vSize) {
        this.vSize = vSize;
    }

    public String gethStr() {
        return hStr;
    }

    public void sethStr(String hStr) {
        this.hStr = hStr;
    }

    public String getvStr() {
        return vStr;
    }

    public void setvStr(String vStr) {
        this.vStr = vStr;
    }

    public String getFillerStr() {
        return fillerStr;
    }

    public void setFillerStr(String fillerStr) {
        this.fillerStr = fillerStr;
    }

    // behavior
    private void drawHline(int h, String hStr){
        for(int i=0; i<h; i++){
            System.out.print(hStr);
        }
    }

    private void drawVline(int h, int v, String vStr, String fStr){
        for(int i=0; i<v-2; i++){
            System.out.print(vStr);
            drawHline(h-2, fStr);
            System.out.println(vStr);
        }
    }

    public void drawYourself(){
        drawHline(hSize, hStr);
        System.out.printf("\n");
        drawVline(hSize, vSize, vStr, fillerStr);
        drawHline(hSize, hStr);
        System.out.printf("\n");
    }

    // override toString()
    public String toString(){
        String str;
        str = "\n Horizontal Size: " + gethSize() + 
              "\n Vertical Size: " + getvSize() + 
              "\n Horizontal String: " + gethStr() + 
              "\n Vertical String: " + getvStr() + 
              "\n Filler String: " + getFillerStr() +"\n\n";
        return str;
    }
}

public class UseBox {
    public static void main(String[] args) {
        Box defaultbox = new Box(20,10,"$","-","|");
        defaultbox.drawYourself();

        defaultbox.setFillerStr("$");
        defaultbox.drawYourself();

        System.out.println(defaultbox.getvSize());
        System.out.println(defaultbox.gethSize());
        System.out.println(defaultbox.gethStr());
        System.out.println(defaultbox.getvStr());
        System.out.println(defaultbox.getFillerStr());

        System.out.println(defaultbox); // implicitly calling toString()
    }
}
