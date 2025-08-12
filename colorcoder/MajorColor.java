import colorcoder.ColorCode;
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
