package colorcoder;
import java.util.ArrayList;
import java.util.List;
import ColorCodeService;

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
