package service;

import dao.AuthorDao;
import models.Author;

public class AuthorService {
    private AuthorDao authorDao = new AuthorDao();

    public AuthorService() {
    }

    public void save(String authorName, String authorSurname, int coAuthorExists){
        authorDao.save(new Author(authorName, authorSurname, coAuthorExists));
    }

    public void findByIds(int bookId, int authorId) {
        authorDao.findByIds(bookId, authorId);
    }

    public void setAuthorToBook(int bookId, int authorId) {
        authorDao.setAuthorToBook(bookId, authorId);
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public void setAuthorDao(AuthorDao authorDao) {
    }
}
