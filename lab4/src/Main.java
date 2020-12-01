public class Main {
    public static void main(String[] args) {
        String exp = "a+b/(c-d)";
        System.out.println("Выражение: " + exp);
        System.out.println("Польская нотация: " + prefix_notation(exp));
        System.out.println("Обратная польская нотация: " + postfix_notation(exp));
    }

    public static int getPriority(String value) {
        int priority = -1;
        switch (value) {
            case "(" -> priority = 0;
            case ")" -> priority = 1;
            case "-", "+" -> priority = 2;
            case "*", "/" -> priority = 3;
            case "^" -> priority = 4;
        }
        return priority;
    }
    static String postfix_notation(String exp) {
        Stack stack = new Stack();
        StringBuilder output = new StringBuilder();
        String letter;
        for (int i = 0; i < exp.length(); i++) {
            letter = String.valueOf(exp.charAt(i));
            int priority = getPriority(letter);
            if (letter.equals("(")) {
                stack.push(letter);
            } else if (letter.equals(")")) {
                String item = "";

                while (!item.equals("(")) {
                    output.append(item);
                    item = stack.pop();
                }
            } else if (priority == -1) {
                output.append(letter);
            } else if (priority == 0 || (stack.getHead() != null && priority > getPriority(stack.getHead().value))) {
                stack.push(letter);
            } else {
                String item = stack.pop();
                output.append(item);
                while (stack.getHead() != null && priority <= getPriority(stack.getHead().value)) {
                    item = stack.pop();
                    output.append(item);
                }
                stack.push(letter);
            }
        }
        output.append(stack);
        return output.toString();
    }

    static String prefix_notation(String exp) {
        exp = new StringBuilder(exp).reverse().toString();
        exp = exp.replace("(", "]");
        exp = exp.replace(")", "(");
        exp = exp.replace("]", ")");

        return new StringBuilder(postfix_notation(exp)).reverse().toString();
    }
}
