package llvm;

public class Assignment extends Statement {

    private Variable assignee;
    private Expression value;

    public Assignment(Variable assignee, Expression value){
        this.assignee = assignee;
        this.value = value;
    }
}