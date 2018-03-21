package controllers;

import db.DBHelper;
import models.Books;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BooksController {

    public BooksController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/books", (req, res) -> {

            List<Books> books = DBHelper.getAll(Books.class);

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/books/index.vtl");
            model.put("books", books);

            return new ModelAndView(model, "templates/layout.vtl");


        }, new VelocityTemplateEngine());

    }
}
