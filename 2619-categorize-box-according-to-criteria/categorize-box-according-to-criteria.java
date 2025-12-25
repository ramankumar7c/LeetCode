class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        if (isBulky(length, width, height)) {
            if (isHeavy(mass))
                return "Both";
            else
                return "Bulky";
        } else if (isHeavy(mass))
            return "Heavy";
        else
            return "Neither";
    }

    private boolean isBulky(int l, int w, int h) {
        long volume = (long) l * (long) w * (long) h;
        if (l >= 10_000 || w >= 10_000 || h >= 10_000 || volume >= 1_000_000_000)
            return true;

        return false;
    }

    private boolean isHeavy(int m) {
        return (m >= 100);
    }
}