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
