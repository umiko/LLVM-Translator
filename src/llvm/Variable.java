package llvm;

import llvm.utility.Types;

public class Variable implements IEvaluable, IIdentifiable {
    private String rawName;
    private String rawType;

    public Variable(String rawName, String rawType){
        if(null == rawName){
            rawName = "";
        }
        if(!Types.hasRawType(rawType)){
            throw new IllegalArgumentException("rawType cannot be null");
        }
        this.rawName = rawName;
        this.rawType = rawType;
    }



    //Getter, Setter, Helper

    public String getRawName() {
        return rawName;
    }

    public void setRawName(String rawName) {
        if(IIdentifiable.validateIdentifier(rawName))
            setName(rawName);
    }

    protected void setName(String rawName) {
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
        return IIdentifiable.translateIdentifier(rawName, false);
    }

    public String getLLVMType(){
        return Types.lookup(rawType);
    }

    public Parameter toParameter(){
        return new Parameter(this.rawName, this.rawType);
    }
}
