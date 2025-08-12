package colorcoder;
import java.util.ArrayList;
import java.util.List;

 public interface ColorCode {
        int getIndex();
    }

    public enum MajorColor implements ColorCode {
        WHITE(0),
        RED(1),
        BLACK(2),
        YELLOW(3),
        VIOLET(4);
        private int index;
        MajorColor(int index) {
            this.index = index;
        }
        @Override
        public int getIndex() {
            return index;
        }
    }

    public enum MinorColor implements ColorCode {
        BLUE(0),
        ORANGE(1),
        GREEN(2),
        BROWN(3),
        SLATE(4);
        private int index;
        MinorColor(int index) {
            this.index = index;
        }
        @Override
        public int getIndex() {
            return index;
        }
    }

    public static class ColorCodeService {
        final static String MajorColorNames[] = {
            "White", "Red", "Black", "Yellow", "Violet"
        };
        final static int numberOfMajorColors = MajorColorNames.length;
        final static String MinorColorNames[] = {
            "Blue", "Orange", "Green", "Brown", "Slate"
        };
        final static int numberOfMinorColors = MinorColorNames.length;

        static <T extends Enum<T> & ColorCode> T fromIndex(Class<T> enumClass, int index) {
            for (T color : enumClass.getEnumConstants()) {
                if (color.getIndex() == index) {
                    return color;
                }
            }
            return null;
        }

        public static ColorPair getColorFromPairNumber(int pairNumber) {
            int zeroBasedPairNumber = pairNumber - 1;
            MajorColor majorColor = fromIndex(MajorColor.class, zeroBasedPairNumber / numberOfMinorColors);
            MinorColor minorColor = fromIndex(MinorColor.class, zeroBasedPairNumber % numberOfMinorColors);
            return new ColorPair(majorColor, minorColor);
        }

        public static int getPairNumberFromColor(MajorColor major, MinorColor minor) {
            return major.getIndex() * numberOfMinorColors + minor.getIndex() + 1;
        }
        
        public static List<String> getColorCodingManual() {
            List<String> manual = new ArrayList<>();
            for (MajorColor major : MajorColor.values()) {
                for (MinorColor minor : MinorColor.values()) {
                    int pairNumber = getPairNumberFromColor(major, minor);
                    String pairString = String.format("Pair %2d: %s, %s",
                        pairNumber,
                        MajorColorNames[major.getIndex()],
                        MinorColorNames[minor.getIndex()]);
                    manual.add(pairString);
                }
            }
            return manual;
        }
    }

    public static class ColorPair {
        private MajorColor majorColor;
        private MinorColor minorColor;
        
        public ColorPair(MajorColor major, MinorColor minor) {
            this.majorColor = major;
            this.minorColor = minor;
        }
        public MajorColor getMajor() {
            return majorColor;
        }
        public MinorColor getMinor() {
            return minorColor;
        }
        String toString() {
            return ColorCodeService.MajorColorNames[majorColor.getIndex()] + " " + ColorCodeService.MinorColorNames[minorColor.getIndex()];
        }
    }

    static void testNumberToPair(int pairNumber, MajorColor expectedMajor, MinorColor expectedMinor) {
        ColorPair colorPair = ColorCodeService.getColorFromPairNumber(pairNumber);
        System.out.println("Got pair " + colorPair.toString());
        assert colorPair.getMajor() == expectedMajor;
        assert colorPair.getMinor() == expectedMinor;
    }

    static void testPairToNumber(MajorColor major, MinorColor minor, int expectedPairNumber) {
        int pairNumber = ColorCodeService.getPairNumberFromColor(major, minor);
        System.out.println("Got pair number " + pairNumber);
        assert pairNumber == expectedPairNumber;
    }

    public static void main(String[] args) {
        testNumberToPair(4, MajorColor.WHITE, MinorColor.BROWN);
        testNumberToPair(5, MajorColor.WHITE, MinorColor.SLATE);
    
        testPairToNumber(MajorColor.BLACK, MinorColor.ORANGE, 12);
        testPairToNumber(MajorColor.VIOLET, MinorColor.SLATE, 25);


      // Test cases for number-to-pair conversion
        testNumberToPair(1, MajorColor.WHITE, MinorColor.BLUE);
        testNumberToPair(5, MajorColor.WHITE, MinorColor.SLATE);
        testNumberToPair(6, MajorColor.RED, MinorColor.BLUE);
        testNumberToPair(10, MajorColor.RED, MinorColor.SLATE);
        testNumberToPair(11, MajorColor.BLACK, MinorColor.BLUE);
        testNumberToPair(15, MajorColor.BLACK, MinorColor.SLATE);
        testNumberToPair(16, MajorColor.YELLOW, MinorColor.BLUE);
        testNumberToPair(20, MajorColor.YELLOW, MinorColor.SLATE);
        testNumberToPair(21, MajorColor.VIOLET, MinorColor.BLUE);
        testNumberToPair(25, MajorColor.VIOLET, MinorColor.SLATE);

        System.out.println("--------------------");

        // Test cases for pair-to-number conversion
        testPairToNumber(MajorColor.WHITE, MinorColor.BLUE, 1);
        testPairToNumber(MajorColor.WHITE, MinorColor.SLATE, 5);
        testPairToNumber(MajorColor.RED, MinorColor.BLUE, 6);
        testPairToNumber(MajorColor.RED, MinorColor.SLATE, 10);
        testPairToNumber(MajorColor.BLACK, MinorColor.BLUE, 11);
        testPairToNumber(MajorColor.BLACK, MinorColor.SLATE, 15);
        testPairToNumber(MajorColor.YELLOW, MinorColor.BLUE, 16);
        testPairToNumber(MajorColor.YELLOW, MinorColor.SLATE, 20);
        testPairToNumber(MajorColor.VIOLET, MinorColor.BLUE, 21);
        testPairToNumber(MajorColor.VIOLET, MinorColor.SLATE, 25);
        
        System.out.println("\n--- Color Coding Manual ---");
        List<String> manual = ColorCodeService.getColorCodingManual();
        manual.forEach(System.out::println);
    }
}
