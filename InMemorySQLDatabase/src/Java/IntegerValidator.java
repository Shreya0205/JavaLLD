package Java;

public class IntegerValidator implements IValidator{

    private static IntegerValidator integerValidator;

    private IntegerValidator(){};

    public static IntegerValidator getInstance(){
        if(integerValidator == null){
            integerValidator = new IntegerValidator();
        }
        return integerValidator;
    }

    public boolean validate(String columnName, Object val){
        if(val instanceof Integer){
            Integer value = (Integer) val;
            if ( value <= 1024 && value >= -1024){
                return true;
            }
            else
                throw new IllegalArgumentException(columnName + " should have value in {-1024, 1024}");
        }
        throw new IllegalArgumentException(columnName + " object not in Integer");
    }
}
