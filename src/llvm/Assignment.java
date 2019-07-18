package llvm;

public class Assignment extends Statement {

    private Variable assignee;
    private IEvaluable value;

    public Assignment(Variable assignee, IEvaluable value){
        this.assignee = assignee;
        this.value = value;
    }

    public String buildAssignment(){
        return String.format("%s = %s", assignee.getLLVMName(), value.getLLVMString());
    }
}
