package ca.six.demo.lib.mock.mvp;

/**
 * Created by songzhw on 2016-09-21.
 */
public class OnePresenter {
    private OneView view;
    private OneModel model;

    public OnePresenter(OneView view, OneModel model) {
        this.view = view;
        this.model = model;
    }

    public void loadNotes(boolean forceUpdate) {
        view.setProgressBar(true);
        if(forceUpdate) {
            model.refresh();
        }

        model.getNote(new ILoadNoteCallback(){
            @Override
            public void onNotesLoaded(Note note) {
                view.openNoteDetails(note == null ? 1 : note.id);
            }
        });
    }

    public void addNewNote(String text) {
        model.addNote(text);
        view.showResult(true);
    }

    public void openNoteDetails(Note requestedNote) {
        view.openNoteDetails(requestedNote.id);
    }

}
