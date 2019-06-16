package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @BeforeEach // 테스트 이전에 실행
    void setUp() {
        System.out.println("setUp====");
    }

    //@Test
    void split() {
        String[] result = "1,2".split(",");
        //System.out.println(result[0]); 옛날 main method 테스트 방식
        //System.out.println(result[1]);
        System.out.println("split====");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result).containsExactly("1","2");
    }

    // 위처럼 Index 사용하지 않아도 contains로 확인 가능
    @Test
    void split1() {
        System.out.println("split1====");
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2"); // 1, 2의 순서도 보장
        assertThat(result).contains("2","1"); // 순서는 없음
    }

    //@Test
    void split2() {
        System.out.println("split2====");
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");

    }

    @Test
    void substring1() {
        String result = "(1,2)";

        assertThat(result.substring(1, result.length() -1)).isEqualTo("1,2");
    }

    // string 값 주어졌을 때 charAt() 메서드 활용해 특정 위치의 문자 가져온다.
    // charAt() 메서드로 특정 위치의 문자 가져올 때, 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생한다.
    //@Test
    void charAt1() {

        String result = "abc";

        assertThat(result.charAt(0)).isEqualTo('a');
        assertThat(result.charAt(1)).isEqualTo('b');
        assertThat(result.charAt(3)).isEqualTo('c');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() ->
                    result.charAt(3)
                ).withMessage("String index out of range: 3");

    }

    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            String inputData = "abc";
            inputData.charAt(inputData.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessage("[TEST] StringIndexOutOfBoundsException");
    }

    //
    @Test
    void charAtException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(4);
                });
    }

    @AfterEach // 각 테스트가 독립적으로 실행되기 위해 초기화 작업을 매번 함
    void tearDown() {
        System.out.println("tear Down");
    }

}
