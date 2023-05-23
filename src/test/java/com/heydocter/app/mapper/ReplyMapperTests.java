package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.enums.DepartmentType;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.ReplyVO;
import com.heydoctor.app.mapper.AnswerMapper;
import com.heydoctor.app.mapper.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class ReplyMapperTests {

    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void insertTest() {
        IntStream.range(0, 3).forEach(i -> {
            ReplyVO replyVO = new ReplyVO();
            replyVO.setReplyContent("test content "+(i+1));
            replyVO.setUserId(1L);
            replyVO.setAnswerId((long) (i+1));

            replyMapper.insert(replyVO);
        });
    }

    @Test
    public void selectAllTest() {
        assertThat(replyMapper.selectAllReplyVO(Arrays.asList(1L,2L,3L)).size()).isEqualTo(3);
    }
}
