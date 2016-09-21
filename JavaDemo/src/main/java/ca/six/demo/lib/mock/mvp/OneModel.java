package ca.six.demo.lib.mock.mvp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songzhw on 2016-09-21.
 */
public class OneModel {
    public static int index = 1;

    public List<Note> notes;

    public OneModel() {
        this.notes = new ArrayList<>();
    }

    public void addNote(String text){
        notes.add(new Note(index, text));
        index += 1;
    }

    public void refresh() {
    }

    public void getNote(ILoadNoteCallback iLoadNoteCallback) {
    }
}
