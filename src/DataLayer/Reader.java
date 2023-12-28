public interface Reader {

    public default String[][] readUsers(){
        return new String[0][];
    }

    public default String[][] readCourses(){
        return new String[0][];
    }

    public default String[][] readFeedbacks(){
        return new String[0][];
    }




}
