package llvm;

import java.util.HashMap;

public class Operations {
    private static HashMap<String, String> operations= new HashMap<>();
    private static Operations instance = new Operations();

    private Operations(){
        operations.put("+", "add");
        operations.put("*", "mul");
        operations.put("/", "div");
        operations.put("-", "sub");
    }

    public static String lookup(String operator){
        return operations.get(operator);
    }

}
