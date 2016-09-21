package ca.six.demo.dao;

import ca.six.demo.lib.mock.dao.Person;
import ca.six.demo.lib.mock.dao.PersonDao;
import ca.six.demo.lib.mock.dao.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by songzhw on 2016-09-20.
 */
public class PeopleServiceTest {
    @Mock
    private PersonDao dao;
    private PersonService personService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        personService = new PersonService(dao);
    }

    @Test
    public void testUpdateName() {
        Person p1 = new Person(1, "phil");
        when(dao.fetchPerson(1)).thenReturn(p1);

        boolean isUpdated = personService.update(1, "david");
        assertTrue(isUpdated);
        verify(dao).fetchPerson(1);
        verify(dao).update(any(Person.class)); // verify(dao).update(p1)会报错。因为p1对象不一样！


        // ArgumentCaptor ：参数捕获器
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        verify(dao).update(personCaptor.capture());

        Person updatedPerson = personCaptor.getValue();
        assertEquals("david", updatedPerson.getPersonName());

    }

    @Test
    public void testUpdateNameFail() {
        when(dao.fetchPerson(1)).thenReturn(null);
        boolean isUpdated = personService.update(1, "david");
        assertFalse(isUpdated);

        verify(dao).fetchPerson(1);

    }


}
