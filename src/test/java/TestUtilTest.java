import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {

    //TestUtil -> 테스트를 위해 반복 작업, 사용성 편하게 하기 위함 (즉 반복작업들을 굳이 계속해서 t1,t2,t3 이렇게 만들필요없다
    @Test
    @DisplayName("TestUtil.genScanner()")
    void t1() {
        Scanner sc = TestUtil.genScanner("""
                        등록
                        너 자신을 알라
                        소크라테스
                        """
        );

        String cmd = sc.nextLine();
        String saying = sc.nextLine();
        String author = sc.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(saying).isEqualTo("너 자신을 알라");
        assertThat(author).isEqualTo("소크라테스");
    }

}
