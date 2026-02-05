public class Rq {

    private String cmd;
    public Rq(String cmd) {
        this.cmd = cmd;
    }

    public String getActionName() {
//        if (cmd.equals("삭제?id=1")) return "삭제";
//        if (cmd.equals("수정?id=1")) return "수정";
//        return "";
        return cmd.split("\\?")[0];
    }

    public String getParam(String key) {
        String param = cmd.split("\\?")[0];
        String paramKey = param.split("=")[0];
        String paramValue = param.split("=")[1];

        if(paramKey.equals(key)){
            return paramValue;
        }
        return "";
    }
}
