package llvm;

import llvm.utility.Types;

public class Value implements IEvaluable {
    private String rawType;
    private String value;

    public Value(String rawType, String value){
        this.rawType = rawType;
        this.value = value;

    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getRawType() {
        return rawType;
    }

    @Override
    public void setRawType(String rawType) {
        if(Types.hasRawType(rawType))
            this.rawType = rawType;
    }

    @Override
    public String getLLVMType() {
        return Types.lookup(rawType);
    }
}
