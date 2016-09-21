package ca.six.demo.lib.mock.dao;

public interface PersonDao {
    Person fetchPerson(Integer personID);
    void update(Person person);
}