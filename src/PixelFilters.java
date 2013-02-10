import java.awt.Color;

public class PixelFilters {
    public static ColorChannelPixelFilter getMaxColorPixelFilter() {
        return new ColorChannelPixelFilter() {
            private ColorChannel color;

            @Override
            public void setColorChannel(ColorChannel c) {
                color = c;
            }

            @Override
            public void filter(Pixel p) {
                setColor(p, color, 255);
            }
        };
    }

    ;

    public static PixelFilter getGrayscalePixelFilter() {
        return new PixelFilter() {
            @Override
            public void filter(Pixel p) {
                int v = (int) p.getAverage();
                p.setColor(new Color(v, v, v));
            }
        };
    }

    ;

    public static PixelFilter getSepiaTonePixelFilter() {
        return new PixelFilter() {
            @Override
            public void filter(Pixel p) {
                // Sepia values as percentages from Wikipedia
                double red = 112 / 255.0;
                double green = 66 / 255.0;
                double blue = 20 / 255.0;

                int v = p.getRed(); // does not matter since its graycale
                p.setColor(new Color((int) (v * red), (int) (v * green), (int) (v * blue)));
            }
        };
    }

    ;

    public static AdjustablePixelFilter getBrightnessPixelFilter() {
        return new AdjustablePixelFilter() {
            private int adjustment = 0;

            @Override
            public void setAdjustment(int amount) {
                adjustment = amount;
            }

            @Override
            public void filter(Pixel p) {
                int red = limitByte(p.getRed() + adjustment);
                int green = limitByte(p.getGreen() + adjustment);
                int blue = limitByte(p.getBlue() + adjustment);
                p.setColor(new Color(red, green, blue));
            }
        };
    }

    ;

    private static void setColor(Pixel p, ColorChannel color, int value) {
        value = limitByte(value);

        switch (color) {
            case RED:
                p.setRed(value);
                break;
            case GREEN:
                p.setGreen(value);
                break;
            case BLUE:
                p.setBlue(value);
                break;
        }
    }

    private static int limitByte(int value) {
        if (value < 0) return 0;
        if (value > 255) return 255;
        return value;
    }
}