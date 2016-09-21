package ca.six.demo.lib.mock.dao;

public interface PersonDao {
    public Person fetchPerson(Integer personID);
    public void update(Person person);
}