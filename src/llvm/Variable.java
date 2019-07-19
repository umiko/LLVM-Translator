package llvm;

import llvm.utility.Types;

public class Variable implements IEvaluable, IIdentifiable {
    private String rawName;
    private String rawType;
    private boolean isGlobal;

    private static Integer tempVarCounter = 0;

    public Variable(String rawName, String rawType, boolean isGlobal ){
        this.isGlobal = isGlobal;
        if(null == rawName){
            rawName = "";
        }
        if(!Types.hasRawType(rawType)){
            throw new IllegalArgumentException("rawType cannot be null");
        }
        this.rawName = rawName;
        this.rawType = rawType;
    }

    public static Variable createTempVar(String rawType){
        return new Variable(getTempVarCounter().toString(), rawType, false);
    }

    //Getter, Setter, Helper

    private static Integer getTempVarCounter(){
        return tempVarCounter++;
    }

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
        return IIdentifiable.translateIdentifier(rawName, isGlobal);
    }

    public String getLLVMType(){
        return Types.lookup(rawType);
    }

    public String getLLVMString(){
        //return String.format("%s %s", getLLVMType(), getLLVMName());
        return getLLVMName();
    }

    public Parameter toParameter(){
        return new Parameter(this.rawName, this.rawType);
    }
}
