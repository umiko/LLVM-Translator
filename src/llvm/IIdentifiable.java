package llvm;

public interface IIdentifiable {
    String getRawName();
    void setRawName(String rawName);
    String getLLVMName();

    static String translateIdentifier(String identifierName, boolean isGlobal){
        if(identifierName != null && identifierName.length()>0) {
            return String.format("%s%s", isGlobal ? '@' : '%', identifierName);
        }
        return null;
    }

    static boolean validateIdentifier(String identifierName){
        return identifierName != null && identifierName.length()>0;
    }
}
