package com.kal.quizApp.service;

import com.kal.quizApp.Question;
import com.kal.quizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    public String updateQuestion(Question question) {
        questionDao.save(question);
        return "Question updated";

    }

    public String deleteQuestion(int id) {
        questionDao.deleteById(id);
        return "dQuestion deleted";
    }
}
