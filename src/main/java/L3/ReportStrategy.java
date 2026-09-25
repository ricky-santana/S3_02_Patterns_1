package L3;

public interface ReportStrategy {
    String generate (String report);

    static ReportStrategy HTMl(){
        return report -> report + ".HTML";
    }

    static ReportStrategy json(){
        return report -> report + ".JSON";
    }

    static ReportStrategy csv(){
        return report -> report + ".CSV";
    }

    static ReportStrategy xml(){
        return report -> report + ".XML";
    }

    static ReportStrategy pdf(){
        return report -> report + ".PDF";
    }

    static ReportStrategy word(){
        return report -> report + ".WORD";
    }

    static ReportStrategy excel(){
        return report -> report + ".EXCEL";
    }

}