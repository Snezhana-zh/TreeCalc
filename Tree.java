public class Tree {
    public Tree left, right;
    public int value;
    public boolean isLeaf() {
        return left == null && right == null;
    }
    public Tree(Tree l, Tree r, int val) {
        left = l;
        right = r;
        value = val;
    }
    public void print() {
        System.out.print(value);
        System.out.print(' ');
        if (left != null && right != null) {
            left.print();
            right.print();
        }
    }
    public int calc() {
        if (isLeaf()) {
            return value;
        }
        int leftRes = left.calc();
        int rightRes = right.calc();
        switch (value) {
            case '+': return leftRes + rightRes;
            case '*': return leftRes * rightRes;
            case '-': return leftRes - rightRes;
            case '/': return leftRes / rightRes;
            default: return 0;
        }
    }
}
