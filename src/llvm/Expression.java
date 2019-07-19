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
        //operations can only work on the same type
        this.rawType = left.getRawType();
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


    //TODO: Test this abomination
    public String getLLVMString(){
        StringBuilder sb = new StringBuilder("");
        //resolve nested expressions
        if(values[0].getClass() != Expression.class || values[1].getClass() != Expression.class){
            for (int i = 0; i<values.length; i++) {
                if (values[i].getClass() == Expression.class){
                    //create a new
                    Variable temp = Variable.createTempVar(values[i].getRawType());
                    Assignment a = new Assignment(temp, values[i]);
                    sb.append(a.buildAssignment()+"\n");
                    values[i] = temp;
                }
            }
        }

        return sb.append(String.format("%s %s %s, %s", Operations.lookup(operation), Types.lookup(rawType), values[0].getLLVMString(), values[1].getLLVMString())).toString();
    }
}
