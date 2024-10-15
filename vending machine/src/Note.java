public enum Note {
    one(1), two(2), five(5), ten(10), twenty(20), fifty(50), hundred(100);

    private final int code;

    Note(int i) {
        code = i;
    }

    public static Note getNoteEnum(Integer note){
        if(note==1)
            return Note.one;
        else if(note==2)
            return Note.two;
        else if(note==5)
            return Note.five;
        else if(note==10)
            return Note.ten;
        else if(note==20)
            return Note.twenty;
        else if(note==50)
            return Note.fifty;
        else if(note==100)
            return Note.hundred;
        return null;
    }

    public int getCode(){
        return code;
    }
}
