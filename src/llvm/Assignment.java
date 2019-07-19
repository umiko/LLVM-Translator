package llvm;

public class Assignment extends Statement {

    private Variable assignee;
    private IEvaluable value;

    public Assignment(Variable assignee, IEvaluable value){
        this.assignee = assignee;
        //Assignments arent a thing, it needs operations
        if(value.getClass() != Expression.class){
            value = new Expression("+", value, new Value(value.getRawType(), "0"));
        }
        this.value = value;
    }

    public String buildAssignment(){
        return String.format("%s = %s", assignee.getLLVMName(), value.getLLVMString());
    }
}
