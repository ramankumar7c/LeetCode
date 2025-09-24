class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0))
            sb.append("-");

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        sb.append(n / d);
        long r = n % d;
        if (r == 0)
            return sb.toString();

        sb.append(".");
        Map<Long, Integer> seen = new HashMap<>();

        StringBuilder frac = new StringBuilder();
        while (r != 0) {
            if (seen.containsKey(r)) {
                int start = seen.get(r);
                return sb.toString() + frac.substring(0, start) + "(" + frac.substring(start) + ")";
            }
            seen.put(r, frac.length());
            r *= 10;
            frac.append(r / d);
            r %= d;
        }

        return sb.toString() + frac.toString();
    }
}