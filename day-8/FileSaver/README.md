Day 8 — FileSaver / Swing examples
=================================

Small Java Swing exercises for simple file creation and editing. The code lives in this folder and the `FileSaver` package. This README explains what each file does, how to build/run the examples on Windows PowerShell, and important implementation notes (including the word-by-word undo/redo logic).

Java version
------------
- Java 8 or newer (OpenJDK / Oracle JDK).

Project files
-------------
- `FileSave.java` (in `FileSaver` package)
  - Small GUI to create a new file by name + extension.
  - Validation uses `String.equalsIgnoreCase` for extension checks (e.g. `txt`).

- `SelectFile.java` (in `FileSaver` package)
  - Shows a `JFileChooser` to open `.txt` files, loads the file into an editable `JTextArea` inside a `JScrollPane`.
  - Provides Undo / Redo buttons and Save/Close.
  - Integrated with `OperationStack` to support undo/redo behavior.

- `OperationStack.java` (in `FileSaver` package)
  - Implements a word-by-word undo/redo mechanism.
  - Text is split into tokens (words, whitespace, punctuation) and stored in stacks.
  - API used by `SelectFile`:
    - `OperationStack.init(currentText)` — initialize stacks with the current document.
    - `OperationStack.recordBeforeChange(currentText)` — call BEFORE making a user change (the code in `SelectFile` uses a document listener and a small debounce timer to record at word boundaries).
    - `OperationStack.undo(currentText)` — returns previous text state.
    - `OperationStack.redo(currentText)` — returns next text state.

- `Form.java` (default package)
  - Small Swing form example (name/email) for learning event handling.

- `SwingExample.java` (default package)
  - Placeholder main demonstrating a simple print to the console.

How to build
------------
Open PowerShell in this folder (`f:/code/Java/backend-journey/day-8`) and run:

```powershell
# create an output directory for compiled classes
mkdir out -ErrorAction SilentlyContinue

# compile package sources and top-level java files
javac -d out FileSaver/*.java *.java
```

Notes:
- `-d out` places compiled `.class` files under `out` keeping package folders.
- If compilation fails, inspect the compiler errors and fix the indicated files.

How to run
----------
Run the GUI programs from the `out` folder. Examples:

```powershell
# Run the file selector/editor (opens GUI)
java -cp out FileSaver.SelectFile

# Run the file creator form
java -cp out FileSaver.FileSave

# Run the simple form example
java -cp out Form
```

Usage notes
-----------
- SelectFile will open a dialog where you can choose a `.txt` file (current directory by default). The file contents appear in an editor window where you can type, undo, redo, and save.

- Word-by-word undo/redo behavior:
  - The editor uses a `DocumentListener` that detects word boundaries (space, punctuation) and uses a 1-second debounce timer to record the text state at those boundaries.
  - `OperationStack` splits text into tokens (words, whitespace, punctuation) and stores snapshots on an undo stack. Undo/redo operate on token snapshots so they remove/restore whole words or punctuation tokens rather than single characters.
  - This approach is simpler and more natural for many text-editing scenarios but has limitations (see Known issues).

Known issues & limitations
--------------------------
- Caret (cursor) position: undo/redo currently returns the text snapshot but does not restore the caret position. Restoring cursor location would require storing/setting caret offsets.
- Large files: storing whole-document snapshots on each recorded change can use a lot of memory for very large files. For large documents, consider a delta-based approach.
- Timing: the debounce timer (1s) groups quick typing into a single recorded token — you can adjust the timeout in `SelectFile` if you want shorter/longer grouping.
- Thread-safety: the implementation assumes single-UI-thread usage (Swing EDT). All document interactions should occur on the EDT.
- Save behavior: saving writes the current text to disk but does not reset or clear undo/redo history — you may want to call `OperationStack.init(...)` after a save to treat the saved state as the new baseline.

Extending or customizing
------------------------
- To change grouping rules (for example: undo by sentence), change `splitIntoWords` in `OperationStack` and the document listener logic in `SelectFile`.
- To persist undo history across saves or sessions, serialize the stacks in `OperationStack`.
- To restore caret position after undo/redo, add caret position storage in `OperationStack.recordBeforeChange` and use `textArea.setCaretPosition(...)` after applying a state.

Troubleshooting
---------------
- "Undo/Redo not working": Ensure `OperationStack.init(textArea.getText())` is called once after loading the file and that `recordBeforeChange(...)` is called before edits. These calls are already present in `SelectFile`.
- "Extension if-condition not executing": `FileSave` was updated to use `String.equalsIgnoreCase` instead of `==` for extension comparison.

Who
---
Small learning project (Swing + file I/O + simple undo/redo). Feel free to adapt and improve.

License
-------
Use as you wish for learning and experimentation. No warranty.