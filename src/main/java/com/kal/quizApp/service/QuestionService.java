package com.kal.quizApp.service;

import com.kal.quizApp.Question;
import com.kal.quizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        try{
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("not added",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        questionDao.save(question);
        try{
            return new ResponseEntity<>("Question updated",HttpStatus.ACCEPTED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question not updated",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        questionDao.deleteById(id);
        try{
            return new ResponseEntity<>("Question deleted",HttpStatus.ACCEPTED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not Deleted",HttpStatus.BAD_REQUEST);
    }
}
