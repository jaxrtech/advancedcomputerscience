public class PictureTest {
    public static void main(String[] args) {
        String file = "../res/hotel.jpg";
        Picture p = new Picture(file);
        p.pattern();
        p.show();
    }
}