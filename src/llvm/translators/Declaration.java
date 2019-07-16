package llvm.translators;

import llvm.utility.Parameter;
import llvm.utility.Types;

public class Declaration {
    public static String buildFunction(String formattingString, String translatedReturnType, String translatedIdentifier, String parameterList){
        return String.format(formattingString, translatedReturnType, translatedIdentifier, parameterList);
    }

    public static String buildFunctionDeclaration(String translatedReturnType, String translatedIdentifier, Parameter[] parameters){
        return buildFunction("declare %s %s (%s)", translatedReturnType, translatedIdentifier, buildParameterList(parameters));
    }

    public static String buildFunctionDefinition(String translatedReturnType, String translatedIdentifier, Parameter[] parameters){
        return buildFunction("define %s %s (%s){", translatedReturnType, translatedIdentifier, buildParameterList(parameters));
    }

    public static String translateFunctionDeclaration(String returnType, String Identifier, Parameter[] parameters){
        return buildFunctionDeclaration(Types.lookup(returnType), llvm.translators.Identifier.translateIdentifier(Identifier, true), parameters);
    }

    public static String translateFunctionDefinition(String returnType, String Identifier, Parameter[] parameters){
        return buildFunctionDefinition(Types.lookup(returnType), llvm.translators.Identifier.translateIdentifier(Identifier, true), parameters);
    }


    public static String writeLnDeclaration(){
        return translateFunctionDeclaration("integer", "puts", new Parameter[]{new Parameter("", "string")});
    }

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
}
