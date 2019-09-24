package org.pg4200.ex06;

public class ImmutableAuthorImp implements  ImmutableAuthor{
    private String name;

    private String surname;

    public ImmutableAuthorImp(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public ImmutableAuthorImp() {

    }

    @Override
    public ImmutableAuthor withName(String name) {
        return new ImmutableAuthorImp(name, this.surname);
    }

    @Override
    public ImmutableAuthor withSurname(String surname) {
        return new ImmutableAuthorImp(this.name, surname);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }
}
