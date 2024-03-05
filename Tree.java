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
    public static void print(Tree node) {
        if (node != null) {
            System.out.print(node.value);
            System.out.print(' ');
            print(node.left);
            print(node.right);
        }
    }
    public static int calc(Tree node) {
        if (node.isLeaf()) {
            return node.value;
        }
        int leftRes = calc(node.left);
        int rightRes = calc(node.right);
        switch (node.value) {
            case '+': return leftRes + rightRes;
            case '*': return leftRes * rightRes;
            case '-': return leftRes - rightRes;
            case '/': return leftRes / rightRes;
            default: return 0;
        }
    }
}
