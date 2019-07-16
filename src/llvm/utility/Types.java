package llvm.utility;

import java.util.HashMap;

public class Types {
    private static HashMap<String, String> types= new HashMap<>();
    private static Types instance = new Types();

    private Types(){
        types.put("integer", "i32");
        types.put("string", "i8*");
        types.put("real", "float");
        types.put("boolean", "i1");
        types.put("char", "i8");
    }

    public static String lookup(String type){
        return types.get(type);
    }

    public static boolean hasRawType(String rawType){
        return types.containsKey(rawType);
    }
}
