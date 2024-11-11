package Java;

public class ColumnValidatorFactory {

    static IValidator getValidator(ColumnType type){
        if(type == ColumnType.integer){
            return IntegerValidator.getInstance();
        }
        else
            return StringValidator.getInstance();
    }

}
