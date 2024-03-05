//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Tree root = parser.parse(" 500 / 2 + 38 - 8 ");
        Tree.print(root);
        int result = Tree.calc(root);
        System.out.println(result);
    }
}