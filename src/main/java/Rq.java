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
        String params = cmd.split("\\?")[1];

        for (String param : params.split("&")) {
            String paramKey = param.split("=")[0];
            String paramValue = param.split("=")[1];

            if (paramKey.equals(key)) {
                return paramValue;
            }
        }


        return "";
    }

    public int getParamAsInt(String key, int defaultValue) {
        String rst = getParam(key);
        return Integer.parseInt(rst);
    }
}

