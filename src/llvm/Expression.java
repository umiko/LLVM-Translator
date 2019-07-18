package llvm;

import llvm.utility.Types;

public class Expression extends Statement implements IEvaluable {

    private String rawType;

    public Expression(){
        super();
    }

    @Override
    public String getRawType() {
        return null;
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

    public String getLLVMString(){
        return "";
    }
}
