public class PictureTest {
    public static void main(String[] args) {
        String file = "H:/hotel.jpg";
        Picture p = new Picture(file);
        p.pattern();
        p.show();
    }
}