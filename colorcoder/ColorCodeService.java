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
