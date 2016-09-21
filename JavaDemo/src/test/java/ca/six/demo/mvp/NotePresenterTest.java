package ca.six.demo.mvp;

import ca.six.demo.lib.mock.mvp.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

/**
 * Created by songzhw on 2016-09-21.
 */
public class NotePresenterTest {
    public OnePresenter presenter;
    @Mock
    public OneView view;
    @Mock
    public OneModel model;
    @Captor
    ArgumentCaptor<ILoadNoteCallback> argumentCaptor;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new OnePresenter(view, model);
    }

    @Test
    public void clickOnFinish_showAddResult(){
        // 测试方法命名分为两个部分，即动作+展示功能，二者用_连接
        String input = "sample";
        presenter.addNewNote(input);
        verify(model).addNote(input);
        verify(view).showResult(true);
    }

    @Test
    public void clickOneItem_showDetailUI(){
        Note note = new Note(3, "text3");
        presenter.openNoteDetails(note);
        verify(view).openNoteDetails(3);
    }

    @Test
    public void longClickOneItem_showNote(){
        presenter.loadNotes(true);
        verify(model).refresh();

        verify(model).getNote(argumentCaptor.capture());
        argumentCaptor.getValue().onNotesLoaded(any(Note.class));
        verify(view).openNoteDetails(anyInt());
    }

}
