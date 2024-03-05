public class Parser {
    private int strPos = 0;
    public void Skip(String str) {
        while(strPos < str.length() && str.charAt(strPos) == ' ') {
            strPos++;
        }
    }
    public Tree parse(String str) {
        return plusOrMinus(str);
    }
    public Tree plusOrMinus(String str) {
        Tree leftTree = multOrDiv(str);

        for (;;) {
            Skip(str);
            if (strPos >= str.length())
                break;

            char op = str.charAt(strPos);
            if (op == '+' || op == '-') {
                strPos++;
                Tree right = multOrDiv(str);
                leftTree = new Tree(leftTree, right, op);
            }
            else {
                break;
            }
        }

        return leftTree;
    }
    public Tree multOrDiv(String str) {
        Tree leftTree = P(str);

        for (; ; ) {
            Skip(str);
            if (strPos >= str.length())
                break;

            char op = str.charAt(strPos);
            if (op == '*' || op == '/') {
                strPos++;
                Tree right = P(str);
                leftTree = new Tree(leftTree, right, op);
            } else {
                break;
            }
        }

        return leftTree;
    }
    Tree P(String str) {
        Skip(str);
        if(str.charAt(strPos) == '(') {
            strPos++;
            Tree tree = plusOrMinus(str);
            if (str.charAt(strPos) == ')') {
                strPos++;
                return tree;
            }
            else {
                System.out.println("missed ')' symbol");
                return null;
            }
        }
        String elem = "";
        while (strPos < str.length() && Character.isDigit(str.charAt(strPos))) {
            elem = elem + str.charAt(strPos);
            strPos++;
        }
        int elemInt;
        try {
            elemInt = Integer.parseInt(elem);
        }
        catch (NumberFormatException e) {
            System.out.println("Unacceptable value");
            return null;
        }
        return new Tree(null, null, elemInt);
    }
}
