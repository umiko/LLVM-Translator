package llvm.translators;

public class Identifier {
    public static String translateIdentifier(String identifierName, boolean isGlobal){
        if(identifierName != null && identifierName.length()>0) {
            return String.format("%s%s", isGlobal ? '@' : '%', identifierName);
        }
        return null;
    }
}
