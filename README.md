# appiumOmniNotes

## Features to be tested
* [x] TC-01
* [x] TC-02
* [x] TC-03
* [x] TC-04
* [x] TC-05
* [x] TC-06
* [x] TC-07
* [x] TC-08
* [x] TC-09
* [x] TC-10
* [x] TC-11
* [ ] TC-12 // 待測試
* [ ] TC-13 // 待測試
* [ ] TC-14 // 先不用做
* [ ] TC-15 // 先不用做
* [x] TC-16
* [x] TC-17
* [ ] TC-18 // 待測試
* [ ] TC-19 // 待測試
* [ ] TC-20 // 待測試
* [x] TC-21
* [x] TC-22
* [x] TC-23
* [x] TC-24
* [x] TC-25
* [x] TC-26
* [x] TC-27//增加布林不知要不要再測
* [x] TC-28

## ADB Command
```
adb shell am start -n it.feio.android.omninotes/.MainActivity
adb shell am start -n it.feio.android.omninotes/.intro.IntroActivity
```

## Run/Debug Configurations
Arguments:
```
--tests
"ntut.csie.team3.tests.note.create.textnote.CreateTextNote"
"ntut.csie.team3.tests.note.create.checklist.CreateChecklistNote"
"ntut.csie.team3.tests.note.archive.ArchiveNote"
"ntut.csie.team3.tests.note.restore_archive.RestoreArchiveNote"
"ntut.csie.team3.tests.note.trash.move.MoveNotesToTrash"
"ntut.csie.team3.tests.note.trash.delete.DeleteTextNote"
"ntut.csie.team3.tests.note.trash.restore.RestoreTextNote"
"ntut.csie.team3.tests.note.trash.clear.ClearTrash"
"ntut.csie.team3.tests.note.edit.textnote.EditTextNoteTitle"
"ntut.csie.team3.tests.note.edit.textnote.EditTextNoteContent"
"ntut.csie.team3.tests.note.edit.checklist.EditChecklistNoteContent"
"ntut.csie.team3.tests.note.edit.checklist.EnableChecklist"
"ntut.csie.team3.tests.note.edit.checklist.UnableChecklist"
"ntut.csie.team3.tests.category.delete.CreateCategory"
"ntut.csie.team3.tests.category.edit.EditCategory"
"ntut.csie.team3.tests.category.edit.DeleteCategory"
"ntut.csie.team3.tests.note.edit.textnote.EditNoteCategory"
"ntut.csie.team3.tests.note.delete.textnote.DeleteNoteCategory"
"ntut.csie.team3.tests.tag.create.CreateTag"
"ntut.csie.team3.tests.tag.add.AddTag"
"ntut.csie.team3.tests.tag.remove.RemoveTag"
"ntut.csie.team3.tests.tag.edit.EditTag"
"ntut.csie.team3.tests.tag.delete.DeleteTag"
"ntut.cise.team3.tests.note.create.CreateTimestamps"
"ntut.cise.team3.tests.note.search.SearchNote"
"ntut.csie.team3.tests.note.sort.SortNote"
```
