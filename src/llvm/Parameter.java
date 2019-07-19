package llvm;

public class Parameter extends Variable{

    public Parameter(String rawName, String rawType){
        super(rawName, rawType, false);
    }

    //circumvent checking if the name is existent as parameters can be identifierless in declaration signatures
    @Override
    public void setRawName(String rawName) {
        this.setName(rawName);
    }

    public String toLLVMString(){
        if(getRawName().equals("")){
            return getLLVMType();
        }
        return String.format("%s %s", getLLVMType(), getLLVMName());
    }
}