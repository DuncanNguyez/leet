public class StringToInteger {

    public int myAtoi(String s) {
        double res = 0;
        boolean dig = false;
        boolean pos = false;
        boolean neg = false;
        boolean other = false;
        int n = s.length();
        int i = 0;
        while (i<n && s.charAt(i)==' ')
            i++;
        for (; i<n; i++)
        {
            if (other)
                break;

            char S = s.charAt(i);
            if (S>='0' && S<='9')
            {
                res = res*10 + (S-'0');
                dig = true;
            }
            else
            {
                if (dig)
                    break;

                else if (S=='-' && !neg)
                    neg = true;

                else if (S=='+' && !pos)
                    pos = true;

                else
                    other = true;
            }
        }
        if (pos && neg)
            return 0;

        if (neg)
            res = -res;

        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)res;
    }
}
