package llvm.utility;

import llvm.translators.Identifier;

public class Parameter {


    private String rawName;
    private String rawType;

    public Parameter(String rawName, String rawType){
        if(null == rawName){
            rawName = "";
        }
        if(!Types.hasRawType(rawType)){
            throw new IllegalArgumentException("rawType cannot be null");
        }
        this.rawName = rawName;
        this.rawType = rawType;
    }

    public String getRawName() {
        return rawName;
    }

    public void setRawName(String rawName) {
        this.rawName = rawName;
    }

    public String getRawType() {
        return rawType;
    }

    public void setRawType(String rawType) {
        if(Types.hasRawType(rawType))
            this.rawType = rawType;
        else
            throw new IllegalArgumentException("rawType does not exist");
    }

    public String getLLVMName(){
        //parameters are never global
        return Identifier.translateIdentifier(rawName, false);
    }

    public String getLLVMType(){
        return Types.lookup(rawType);
    }

    public String toLLVMString(){
        if(getRawName()==""){
            return getLLVMType();
        }
        return String.format("%s %s", getLLVMType(), getLLVMName());
    }

}
