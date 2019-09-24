package org.pg4200.ex06;

import java.util.Arrays;
import java.util.List;

public class ImmutableBookImp implements ImmutableBook {

    private String title;

    private int year;

    private List<ImmutableAuthor> authors;

    public ImmutableBookImp(){
    }

    public ImmutableBookImp(String title, int year, List<ImmutableAuthor> authors) {
        this.title = title;
        this.year = year;
        this.authors = authors;
    }

    @Override
    public ImmutableBook withTitle(String title) {
        return new ImmutableBookImp(title, this.year, this.authors);
    }

    @Override
    public ImmutableBook withYear(int year) {
        return new ImmutableBookImp(this.title, year, this.authors);
    }

    @Override
    public ImmutableBook withAuthors(List<ImmutableAuthor> authors) {
        return new ImmutableBookImp(this.title, this.year, authors);
    }

    @Override
    public ImmutableBook withAuthors(ImmutableAuthor... authors) {
        return withAuthors((Arrays.asList(authors)));
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public List<ImmutableAuthor> getAuthors() {
        return this.authors;
    }
}
