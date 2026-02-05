import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RqTest {

    @Test
    @DisplayName(value = "rq.getActionName() - 삭제")
    void t1() {

        Rq rq = new Rq("삭제?id=1");
        String actionName = rq.getActionName();
        assertThat(actionName).isEqualTo("삭제");
    }


    @Test
    @DisplayName(value = "rq.getActionName() - 수정")
    void t2() {

        Rq rq = new Rq("수정?id=1");
        String actionName = rq.getActionName();
        assertThat(actionName).isEqualTo("수정");
    }

    @Test
    @DisplayName(value = "목록?ikeyword=자바, rq.getParam(\"keyword\") -> \"자바\"")
    void t3() {

        Rq rq = new Rq("수정?id=1");
        String rst = rq.getParam("keyword","");
        assertThat(rst).isEqualTo("자바");
    }

    @Test
    @DisplayName(value = "목록?keywordType=title, rq.getParam(\"keywordType=title\") -> \"title\"")
    void t4() {

        Rq rq = new Rq("수정?keywordType=title");
        String rst = rq.getParam("keywordType","");
        assertThat(rst).isEqualTo("title");
    }

    @Test
    @DisplayName(value = "목록?keywordType=title, rq.getParam(\"keywordType=title\") -> \"title\"")
    void t5() {

        Rq rq = new Rq("수정?keywordType=title");
        String rst = rq.getParam("keywordType","");
        assertThat(rst).isEqualTo("title");
    }

    @Test
    @DisplayName(value = "목록?keyword=자바&keywordType=title, rq.getParam(\"keyword=자바&keywordType=title\") -> \"자바, title\"")
    void t6() {

        Rq rq = new Rq("목록?keyword=자바&keywordType=title");
        String rst = rq.getParam("keywordType","");
        assertThat(rst).isEqualTo("title");
    }


    @Test
    @DisplayName(value = "목록?page=1, rq.getParam(\"page\") -> 1")
    void t7() {

        Rq rq = new Rq("목록?page=1");
        int rst = rq.getParamAsInt("page",-1);
        assertThat(rst).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "목록?page=1, rq.getParam(\"page\") -> 1")
    void t8() {

        Rq rq = new Rq("목록?page=10");
        int rst = rq.getParamAsInt("page",-1);
        assertThat(rst).isEqualTo(10);
    }
    @Test
    @DisplayName(value = "삭제?id=aaa, rq.getParamAsInt(\"id\") -> \"-1\"")
    void t9() {

        Rq rq = new Rq("삭제?id=aaa");
        int rst = rq.getParamAsInt("id",-1);
        assertThat(rst).isEqualTo(-1);
    }

    @Test
    @DisplayName(value = "목록?keyword=자바, rq.getParam(\"keywordType\",\"\") -> \"\"")
    void t10() {

        Rq rq = new Rq("목록?keyword=자바");
        String rst = rq.getParam("keywordType","");
        assertThat(rst).isEqualTo("");
    }
}