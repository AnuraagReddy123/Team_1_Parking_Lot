// class InputValidation
// for checking valid input
// basically for integers
class InputValidation {
    public static int inputCheckInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
                num = num * 10 + (s.charAt(i) - '0');
            else {
                return -1;
            }
        }
        return num;
    }
}
