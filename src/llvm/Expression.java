package llvm;

import llvm.utility.Types;

public class Expression extends Statement implements IEvaluable {

    private String rawType;
    private String operation;
    private IEvaluable[] values = new IEvaluable[2];

    public Expression(String op, IEvaluable left, IEvaluable right){
        super();
        this.operation = op;
        values[0]=left;
        values[1]=right;
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

    public String getLLVMString(){
        return String.format("%s %s %s, %s", Operations.lookup(operation), Types.lookup(rawType), values[0], values[1]);
    }
}
