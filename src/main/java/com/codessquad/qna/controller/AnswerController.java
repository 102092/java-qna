package com.codessquad.qna.controller;

import com.codessquad.qna.domain.Answer;
import com.codessquad.qna.domain.Question;
import com.codessquad.qna.domain.User;
import com.codessquad.qna.repository.AnswerRepository;
import com.codessquad.qna.repository.QnaRepository;
import com.codessquad.qna.repository.UserRepository;
import com.codessquad.qna.web.HttpSessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/questions/{id}/answers")
public class AnswerController {

  @Autowired
  AnswerRepository answerRepository;

  @Autowired
  QnaRepository qnaRepository;

  @Autowired
  UserRepository userRepository;


  @PostMapping(value = "")
  public String create(@PathVariable("id") Long questionsId, String contents,
      HttpSession httpSession) {
    if (!HttpSessionUtils.isLoginUser(httpSession)) {
      return "redirect:/user/login";
    }

    Question question = qnaRepository.getOne(questionsId);
    User writer = HttpSessionUtils.getUserFromSession(httpSession);
    Answer answer = new Answer(question, writer, contents);
    answerRepository.save(answer);
    return "redirect:/questions/{id}";
  }

  @DeleteMapping(value = "/{id}")
  public String delete(@PathVariable("id") Long answerId, HttpSession httpSession,
      HttpServletRequest request) {
    if (!HttpSessionUtils.isLoginUser(httpSession)) {
      return "redirect:/user/login";
    }

    User sessionUser = HttpSessionUtils.getUserFromSession(httpSession);
    Answer answer = answerRepository.getOne(answerId);
    if (!answer.isSameWriter(sessionUser)) {
      throw new IllegalStateException("자신이 쓴 답글만 삭제할 수 있습니다");
    }
    answer = answerRepository.getOne(answerId);
    answerRepository.delete(answer);

    String referer = request.getHeader("Referer");
    return "redirect:" + referer;

  }


}