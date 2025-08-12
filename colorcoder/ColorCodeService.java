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
