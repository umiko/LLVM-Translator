package llvm;

import llvm.utility.Types;

public class Function implements IIdentifiable, IEvaluable {

    private String rawType;
    private String rawName;
    private Parameter[] parameterList;

    public Function(String rawType, String rawName, Parameter[] parameterList){
        this.rawName = rawName;
        this.rawType = rawType;
        this.parameterList = parameterList;
    }

    //Generators

    public String buildFunction(String formattingString, Parameter[] parameterList){
        return String.format(formattingString, Types.lookup(this.rawType), IIdentifiable.translateIdentifier(rawName, true), buildParameterList(parameterList));
    }

    public String buildFunction(String formattingString){
        return String.format(formattingString, Types.lookup(this.rawType), IIdentifiable.translateIdentifier(rawName, true), buildParameterList(parameterList));
    }

    public String buildFunctionDeclaration(){
        return buildFunction("declare %s %s (%s);");
    }

    public String buildFunctionDefinition(){
        return buildFunction("define %s %s (%s){");
    }

    //this requires the actual parameters
    public String buildFunctionCall(Parameter[] actualParameterList){
        return buildFunction("call %s %s(%s)", actualParameterList);
    }

    public String buildReturnStatement(String translatedReturnValue){
        return String.format("ret %s %s", Types.lookup(rawType), translatedReturnValue);
    }

    public String closeFunction(){
        return "}";
    }

    public static String writeLnDeclaration(){
        return new Function("integer", "puts", new Parameter[]{new Parameter("", "string")}).buildFunctionDeclaration();
    }


    //Helpers, Getters, Setters

    public static String buildParameterList(Parameter[] params){
        if(params !=null && params.length>0){
            StringBuilder sb = new StringBuilder("");
            for (Parameter p : params) {
                if(p!=null) {
                    sb.append(p.toLLVMString());
                    if (params.length > 1 && params[params.length - 1] != p) {
                        sb.append(", ");
                    }
                }
            }
            return sb.toString();
        }
        return "";
    }


    @Override
    public String getRawType() {
        return rawType;
    }

    @Override
    public void setRawType(String rawType) {
        if(Types.hasRawType(rawType)){
            this.rawType = rawType;
        }
    }

    @Override
    public String getLLVMType() {
        return Types.lookup(this.rawType);
    }

    @Override
    public String getLLVMString() {
        return buildFunctionDefinition();
    }

    @Override
    public String getRawName() {
        return this.rawName;
    }

    @Override
    public void setRawName(String rawName) {
        if(IIdentifiable.validateIdentifier(rawName)){
            this.rawName = rawName;
        }
    }

    @Override
    public String getLLVMName() {
        return IIdentifiable.translateIdentifier(this.rawName, true);
    }
}
