package ntut.csie.team3.runner;

import ntut.csie.team3.tests.category.create.CreateCategoryTest;
import ntut.csie.team3.tests.category.edit.EditCategoryTest;
import ntut.csie.team3.tests.note.archive.ArchiveNoteTest;
import ntut.csie.team3.tests.note.create.CreateTimestampsTest;
import ntut.csie.team3.tests.note.create.checklist.CreateChecklistNoteTest;
import ntut.csie.team3.tests.note.create.textnote.CreateTextNoteTest;
import ntut.csie.team3.tests.note.edit.checklist.EditChecklistNoteContentTest;
import ntut.csie.team3.tests.note.edit.checklist.UnableChecklistTest;
import ntut.csie.team3.tests.note.edit.textnote.EditNoteCategoryTest;
import ntut.csie.team3.tests.note.edit.textnote.EditTextNoteContentTest;
import ntut.csie.team3.tests.note.edit.textnote.EditTextNoteTitleTest;
import ntut.csie.team3.tests.note.edit.textnote.EnableChecklistTest;
import ntut.csie.team3.tests.note.restore_archive.RestoreArchiveNoteTest;
import ntut.csie.team3.tests.note.search.SearchNoteTest;
import ntut.csie.team3.tests.note.sort.SortNoteTest;
import ntut.csie.team3.tests.note.trash.clear.ClearTrashTest;
import ntut.csie.team3.tests.note.trash.delete.DeleteTextNoteTest;
import ntut.csie.team3.tests.note.trash.move.MoveNotesToTrashTest;
import ntut.csie.team3.tests.note.trash.restore.RestoreTextNoteTest;
import ntut.csie.team3.tests.tag.add.AddTagTest;
import ntut.csie.team3.tests.tag.create.CreateTagTest;
import ntut.csie.team3.tests.tag.delete.DeleteTagTest;
import ntut.csie.team3.tests.tag.edit.EditTagTest;
import ntut.csie.team3.tests.tag.remove.RemoveTagTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( {
        CreateTextNoteTest.class,
        CreateChecklistNoteTest.class,
        ArchiveNoteTest.class,
        RestoreArchiveNoteTest.class,
        MoveNotesToTrashTest.class,
        DeleteTextNoteTest.class,
        RestoreTextNoteTest.class,
        ClearTrashTest.class,
        EditTextNoteTitleTest.class,
        EditTextNoteContentTest.class,
        EditChecklistNoteContentTest.class,
        EnableChecklistTest.class,
        UnableChecklistTest.class,
        CreateCategoryTest.class,
        EditCategoryTest.class,
        DeleteTextNoteTest.class,
        EditNoteCategoryTest.class,
        DeleteTextNoteTest.class,
        CreateTagTest.class,
        AddTagTest.class,
        RemoveTagTest.class,
        EditTagTest.class,
        DeleteTagTest.class,
        CreateTimestampsTest.class,
        SearchNoteTest.class,
        SortNoteTest.class,
} )
public class JUnit5TestSuite {
}
