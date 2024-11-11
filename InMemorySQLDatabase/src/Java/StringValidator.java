package Java;

public class StringValidator implements IValidator{

    private static StringValidator stringValidator;

    private StringValidator(){};

    public static StringValidator getInstance(){
        if(stringValidator == null){
            stringValidator = new StringValidator();
        }
        return stringValidator;
    }

    public boolean validate(String columnName, Object val){
        if(val instanceof String){
            if(((String) val).length() <= 8){
                return true;
            }
            else
                throw new IllegalArgumentException(columnName + " should have length <= 8");
        }
        throw new IllegalArgumentException(columnName + " object not in Integer");
    }

}
