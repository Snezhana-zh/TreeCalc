//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Tree root = parser.parse("500 - (1 + 2) + 10/2");
        root.print();
        int result = root.calc();
        System.out.println(result);
    }
}